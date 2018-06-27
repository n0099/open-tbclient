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
    private static int hyM = 0;
    private EditorTools aMl;
    private String aNN;
    private LocationModel aNO;
    private NewWriteModel aNP;
    private VoiceManager djz;
    private LinearLayout fzT;
    private PlayVoiceBntNew fzU;
    private ImageView fzW;
    private int gBQ;
    private TextView gCn;
    private com.baidu.tieba.write.d gCo;
    private ImageView gCp;
    private View gCq;
    private LinearLayout hxA;
    private View hxC;
    private Toast hxE;
    private AdditionData hxF;
    private RelativeLayout hxG;
    private TextView hxH;
    private TextView hxI;
    private TextView hxJ;
    List<x> hxK;
    x hxL;
    private int hxM;
    private String hxN;
    private int hxO;
    private PostCategoryView hxP;
    private HotTopicBussinessData hxS;
    private TextView hxT;
    private com.baidu.tieba.write.editor.b hxV;
    private e hxY;
    private LinearLayout hxz;
    private View hyQ;
    private View hyR;
    private TextView hyS;
    private com.baidu.tieba.c.d hyV;
    private com.baidu.tieba.view.b hyf;
    private View hyo;
    private g hyv;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String hxw = "";
    private boolean hxx = false;
    private WriteData mData = null;
    private boolean hyk = false;
    private boolean hxy = false;
    private boolean hyl = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText gCi = null;
    private HeadImageView hym = null;
    private View gCj = null;
    private LinearLayout gCl = null;
    private EditText gCm = null;
    private FeedBackModel hxB = null;
    private FeedBackTopListView hyn = null;
    private ArrayList<WritePrefixItemLayout> hxD = new ArrayList<>();
    private String eYZ = null;
    private final KeyEvent cSx = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View aBf = null;
    private TextView hyp = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a hyq = null;
    private final Handler mHandler = new Handler();
    private boolean hyr = false;
    private String hys = null;
    private RelativeLayout mParent = null;
    private String aNT = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aNU = 0;
    private int hyt = 0;
    private WriteImagesInfo hyu = new WriteImagesInfo();
    private View mRootView = null;
    private GridView hyw = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a hyx = null;
    private ScrollView hxQ = null;
    private EditText hyy = null;
    private View hyz = null;
    private View hyA = null;
    private View hyB = null;
    private EditText hyC = null;
    private TextView hyD = null;
    private TextView hyE = null;
    private TextWatcher hyF = null;
    private TextWatcher hyG = null;
    private boolean hxR = false;
    private boolean hyH = false;
    private com.baidu.tbadk.core.view.a aVW = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File hyI = null;
    private TbImageView hyJ = null;
    private View mBubbleView = null;
    private Dialog hyK = null;
    private LinearLayout hyL = null;
    private boolean hyN = false;
    private long hyO = -1000;
    private boolean hyP = false;
    private String hcf = "2";
    private int hsy = 0;
    private String hyT = "";
    private SpannableStringBuilder hxU = new SpannableStringBuilder();
    private boolean hyU = false;
    private boolean hxW = false;
    private final b hxX = new b();
    private final HttpMessageListener hyW = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.eYZ)) {
                    WriteActivity.this.eYZ = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.nO(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.eYZ)) {
                    WriteActivity.this.eYZ = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.eYZ);
                    WriteActivity.this.nO(true);
                }
            }
        }
    };
    private TbFaceManager.a hxZ = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan he(String str) {
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
            return new com.baidu.tbadk.core.view.f(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a dkD = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12536").r("obj_locate", at.a.arM));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an("c12535").r("obj_locate", at.a.arM));
        }
    };
    private final NewWriteModel.d aOd = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.atX();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.hxX.aB(null);
                if (z) {
                    WriteActivity.this.bM(z);
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
                        if (!w.A(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.hyT)) {
                            TiebaStatic.log(new an("c11731").ah(VideoPlayActivityConfig.OBJ_ID, WriteActivity.this.hyT));
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
                    WriteActivity.this.hxX.aB(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hxX.vu(postWriteCallBackData.getErrorString());
                    WriteActivity.this.hxX.b(WriteActivity.this.gCi, WriteActivity.this.gCm);
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.CC());
                    if (com.baidu.tbadk.p.a.hQ(tVar.CB())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.CB());
                        if (WriteActivity.this.hyl) {
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
    private final LocationModel.a aOb = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.39
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Io() {
            WriteActivity.this.showToast(d.k.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gT(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(d.k.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.byg())) {
                WriteActivity.this.b(2, true, aVar.byg());
            } else {
                gT(null);
            }
        }
    };
    private final CustomMessageListener gPl = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aNO.mL(false);
                    WriteActivity.this.aNO.cr(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aNO.mL(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hya = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hyb = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.42
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bIC = WriteActivity.this.bIC();
            if (bIC >= 0 && bIC < WriteActivity.this.gCm.getText().length()) {
                WriteActivity.this.gCm.setSelection(bIC);
            }
        }
    };
    private boolean hyc = true;
    private final View.OnFocusChangeListener gCg = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.gCi || view == WriteActivity.this.aBf || view == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.hyc = true;
                    WriteActivity.this.bID();
                    l.c(WriteActivity.this.getActivity(), WriteActivity.this.gCi);
                    if (WriteActivity.this.aMl != null) {
                        WriteActivity.this.aMl.FT();
                    }
                } else if (view == WriteActivity.this.gCi) {
                    WriteActivity.this.gCn.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.gCm && z) {
                WriteActivity.this.hyc = false;
                WriteActivity.this.bID();
                l.c(WriteActivity.this.getActivity(), WriteActivity.this.gCm);
                if (WriteActivity.this.aMl != null) {
                    WriteActivity.this.aMl.FT();
                }
            }
            WriteActivity.this.bIJ();
        }
    };
    private TextWatcher hyd = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String hyh = "";
        private String hyi;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hyi = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hyi != null ? this.hyi.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.btq();
            WriteActivity.this.bIK();
            EditText bIV = WriteActivity.this.bIV();
            if (editable != null && bIV != null && bIV.getText() != null) {
                if (this.hyh == null || !this.hyh.equals(editable.toString())) {
                    if (WriteActivity.this.hxX != null) {
                        this.hyh = bIV.getText().toString();
                        WriteActivity.this.hxX.k(bIV);
                        return;
                    }
                    return;
                }
                bIV.setSelection(bIV.getSelectionEnd());
            }
        }
    };
    private TextWatcher hye = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String hyi;
        private String hyj = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hyi = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hyi != null ? this.hyi.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.btq();
            EditText bIU = WriteActivity.this.bIU();
            if (editable != null && bIU != null && bIU.getText() != null) {
                if (this.hyj == null || !this.hyj.equals(editable.toString())) {
                    if (WriteActivity.this.hxX != null) {
                        this.hyj = bIU.getText().toString();
                        WriteActivity.this.hxX.k(bIU);
                        return;
                    }
                    return;
                }
                bIU.setSelection(bIU.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0234a fGK = new a.InterfaceC0234a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0234a
        public void onRefresh() {
            WriteActivity.this.eYZ = null;
            WriteActivity.this.nO(false);
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
    public void HZ() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Ia() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.k.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Ic();
        } else if (this.aNO.byo()) {
            HZ();
        } else {
            this.aNO.mL(false);
            b(1, true, null);
            this.aNO.bym();
        }
    }

    private void Ic() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cd(d.k.location_app_permission_prompt).a(d.k.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.jD()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.aNO.afA();
                } else {
                    WriteActivity.this.aOb.Io();
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
        aVar.xn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bIC() {
        int selectionEnd = bIU().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bIU().getText().getSpans(0, bIU().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bIU().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bIU().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bID() {
        if (this.aMl != null) {
            this.aMl.setBarLauncherEnabled(!this.hyc);
            this.aMl.setBarLauncherEnabled(true, 26);
            this.aMl.setBarLauncherEnabled(true, 2);
            K(9, this.hyc ? false : true);
        }
    }

    private void K(int i, boolean z) {
        com.baidu.tbadk.editortools.g eK;
        if (this.aMl != null && (eK = this.aMl.eK(i)) != null) {
            if (z) {
                eK.oD();
            } else {
                eK.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.hxR) {
            this.gCi.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.hyB.setVisibility(8);
            } else {
                this.hyB.setVisibility(0);
            }
            a(this.hyE, this.hyy);
            a(this.hyD, this.hyC);
            btq();
        }
        if (this.hyk) {
            this.hyc = true;
            bID();
            if (this.aMl != null) {
                this.aMl.FT();
            }
            this.gCi.requestFocus();
            ShowSoftKeyPadDelay(this.gCi);
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
            bJs();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bJd();
            }
            nP(true);
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
            vI(this.hsy);
        }
        initUI();
        bJi();
        this.aNO = new LocationModel(this);
        this.aNO.a(this.aOb);
        registerListener(this.gPl);
        registerListener(this.hya);
        initEditor();
        bJu();
        if (this.hxR) {
            this.hyx.setEditorTools(this.aMl);
        } else {
            this.gCm.requestFocus();
        }
        bpv();
        bJd();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aMl = new EditorTools(getActivity());
        this.aMl.setBarMaxLauCount(5);
        this.aMl.setMoreButtonAtEnd(true);
        this.aMl.setBarLauncherType(1);
        this.aMl.bE(true);
        this.aMl.bF(true);
        this.aMl.setMoreLauncherIcon(d.f.write_more);
        this.aMl.setBackgroundColorId(d.C0142d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bJg();
                break;
            default:
                bIE();
                break;
        }
        this.aMl.Hz();
        if (this.hxz != null) {
            this.hxz.addView(this.aMl);
        }
        bIF();
        this.aMl.oD();
        com.baidu.tbadk.editortools.g eK = this.aMl.eK(6);
        if (eK != null && !TextUtils.isEmpty(this.aNT)) {
            ((View) eK).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.aNT);
                }
            });
        }
        if (!this.hxR) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aMl.FT();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        bIH();
    }

    private void bJe() {
        this.hyz = this.mRootView.findViewById(d.g.photo_live_scroll);
        this.hyB = this.hyz.findViewById(d.g.live_post_title_container);
        this.hyy = (EditText) this.hyz.findViewById(d.g.live_post_content);
        this.hyw = (GridView) this.hyz.findViewById(d.g.photoLiveGridView);
        this.hyC = (EditText) this.hyz.findViewById(d.g.live_post_title);
        this.hyD = (TextView) this.hyz.findViewById(d.g.titleOverPlusNumber);
        this.hyE = (TextView) this.hyz.findViewById(d.g.contentOverPlusNumber);
        this.hyA = this.hyz.findViewById(d.g.live_interval_view);
        this.hyD.setText(String.valueOf(20));
        this.hyE.setText(String.valueOf(233));
        this.hyz.setVisibility(0);
        this.hyD.setVisibility(0);
        this.hyE.setVisibility(0);
        this.hyC.setHint(d.k.tips_title_limit_new);
        this.hyC.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hyH = true;
                    WriteActivity.this.hyc = true;
                    WriteActivity.this.bID();
                    if (WriteActivity.this.aMl != null) {
                        WriteActivity.this.aMl.FT();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.hyy.setHint(d.k.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.hyy.setHint(d.k.live_write_input_content_update);
        }
        this.hyy.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.hyH = false;
                    WriteActivity.this.hyc = false;
                    WriteActivity.this.bID();
                    if (WriteActivity.this.aMl != null) {
                        WriteActivity.this.aMl.FT();
                    }
                }
            }
        });
        this.hyy.requestFocus();
        this.hyy.addTextChangedListener(bJk());
        this.hyC.requestFocus();
        this.hyC.addTextChangedListener(bJk());
        this.hyC.setOnClickListener(this.hyb);
        this.hyy.setOnClickListener(this.hyb);
        this.hyx = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.hyw);
        this.hyx.vC(6);
        this.hyw.setAdapter((ListAdapter) this.hyx);
        View findViewById = this.hyz.findViewById(d.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bIo() {
                WriteActivity.this.aUn();
            }
        });
        bJf();
    }

    private void bJf() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.hyC.setText(this.mData.getTitle());
                this.hyC.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.hxR) {
            bJp();
        }
        if (this.aMl.HB()) {
            this.aMl.FT();
        }
        vI(0);
    }

    private void vI(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.hcf);
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void bJg() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aMl.G(arrayList);
        com.baidu.tbadk.editortools.k eN = this.aMl.eN(5);
        if (eN != null) {
            eN.aMU = 2;
            eN.aMS = d.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aMS = d.f.write_at;
        this.aMl.b(aVar);
        this.aMl.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bIE() {
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
        Boolean bJn = bJn();
        if (!this.hyk && bJn != null && bJn.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.byN() && p.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
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
            kVar3.aMS = this.hyk ? d.f.write_location : d.f.icon_post_more_location;
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
        if (this.hxF == null) {
            if (this.hxV == null) {
                this.hxV = new com.baidu.tieba.write.editor.b(getActivity(), this.hcf);
                this.hxV.aT(this.mData.getForumId(), this.privateThread);
            }
            this.aMl.b(this.hxV);
        }
        this.aMl.G(arrayList);
        com.baidu.tbadk.editortools.k eN = this.aMl.eN(5);
        if (eN != null) {
            eN.aMU = 1;
            eN.aMS = d.f.write_emotion;
        }
    }

    private void bIG() {
        if (this.hxY != null) {
            this.hxY.hideTip();
        }
    }

    private void bIH() {
        if (this.hxY == null) {
            this.hxY = new e(getPageContext());
        }
        this.hxY.c(this.aMl);
    }

    private void bIF() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bIT()) {
                            WriteActivity.this.showToast(d.k.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new an("c12612").r("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bIT()) {
                            WriteActivity.this.showToast(d.k.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            WriteActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bIW();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.bdJ();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bJs();
                        WriteActivity.this.btq();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.vJ(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new an("c12612").r("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.hxF == null) {
                            WriteActivity.this.Id();
                            return;
                        }
                        switch (WriteActivity.this.aNU) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ac.aM(pageActivity)) {
                                    WriteActivity.this.Ia();
                                    return;
                                } else {
                                    ac.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.HZ();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.aNO != null) {
                            WriteActivity.this.aNO.mL(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.eYZ = null;
                        } else {
                            WriteActivity.this.eYZ = (String) aVar.data;
                        }
                        WriteActivity.this.nO(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        an anVar = new an("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        anVar.ah(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(anVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aMl.HB()) {
                                        WriteActivity.this.aMl.FT();
                                        WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.btq();
                        if (WriteActivity.this.gCm != null) {
                            WriteActivity.this.gCm.requestFocus();
                        }
                        WriteActivity.this.aMl.FT();
                        WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gCm);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new an("c12612").r("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.hxx = true;
                        WriteActivity.this.nM(true);
                        if (WriteActivity.this.bIV().isFocused()) {
                            WriteActivity.this.hxw = "from_title";
                        } else if (WriteActivity.this.bIU().isFocused()) {
                            WriteActivity.this.hxw = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.hxA.setVisibility(0);
                        WriteActivity.this.hxA.requestFocus();
                        WriteActivity.this.btq();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.hxA.hasFocus()) {
                            WriteActivity.this.gCm.requestFocus();
                            WriteActivity.this.gCm.setSelection(WriteActivity.this.gCm.getText().toString().length());
                        }
                        WriteActivity.this.hxA.setVisibility(8);
                        WriteActivity.this.btq();
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
    public void vJ(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Id() {
        if (this.aNO.afw()) {
            if (this.aNO.byo()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.byk().getLocationData().byg());
                return;
            }
            b(1, true, null);
            this.aNO.bym();
            return;
        }
        b(0, true, null);
    }

    protected void bti() {
        if (this.aNP != null) {
            this.aNP.cancelLoadData();
        }
        if (this.hxB != null) {
            this.hxB.cancelLoadData();
        }
        if (this.aNO != null) {
            this.aNO.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bIG();
        TiebaPrepareImageService.StopService();
        bti();
        bJm();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hyv != null) {
            this.hyv.destroy();
        }
        if (this.hyV != null) {
            this.hyV.akn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bII() {
        if (this.mData != null && this.mData.getType() == 2 && this.hyr) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bIV().getText().toString());
            this.mData.setContent(bIU().getText().toString());
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
            if (this.gCo != null && this.gCo.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.gCo, getPageContext().getPageActivity());
                return true;
            } else if (this.aMl.HB()) {
                this.aMl.FT();
                return true;
            } else {
                bti();
                bII();
                return true;
            }
        }
        if (i == 67 && (text = bIU().getText()) != null) {
            int selectionStart = bIU().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bIU().onKeyDown(67, this.cSx);
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
        getLayoutMode().onModeChanged(this.hyL);
        if (this.hyJ != null && i == 1) {
            this.hyJ.setBorderColor(am.getColor(d.C0142d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        am.c(this.mPost, d.C0142d.cp_link_tip_a, 1);
        bID();
        am.j(this.hyz, d.C0142d.cp_bg_line_d);
        am.j(this.gCj, d.C0142d.cp_bg_line_c);
        am.j(this.hyA, d.C0142d.cp_bg_line_c);
        am.j(bIV(), d.C0142d.cp_bg_line_d);
        am.c(this.fzW, d.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.eYZ)) {
            am.j(bIU(), d.C0142d.cp_bg_line_d);
        }
        btq();
        this.aMl.onChangeSkinType(i);
        if (this.hxP != null) {
            this.hxP.AP();
        }
        am.h(this.mName, d.C0142d.cp_cont_b);
        bIJ();
        bIK();
        if (this.hxX != null) {
            this.hxX.c(bIV(), bIU());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIJ() {
        if (this.gCi.hasFocus()) {
            this.gCi.setHintTextColor(am.getColor(d.C0142d.cp_cont_e));
        } else {
            this.gCi.setHintTextColor(am.getColor(d.C0142d.cp_cont_d));
        }
        if (this.gCm.hasFocus()) {
            this.gCm.setHintTextColor(am.getColor(d.C0142d.cp_cont_e));
        } else {
            this.gCm.setHintTextColor(am.getColor(d.C0142d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIK() {
        if (this.gCi != null && this.gCi.getText() != null && this.gCi.getText().toString() != null && this.gCi.getPaint() != null) {
            if (this.gCi.getText().toString().length() == 0) {
                this.gCi.getPaint().setFakeBoldText(false);
            } else if (this.gCi.getText().toString().length() > 0) {
                this.gCi.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.aVW = new com.baidu.tbadk.core.view.a(getPageContext());
        this.hxR = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.i.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.aBf = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        am.h(this.mName, d.C0142d.cp_cont_b);
        this.hyp = (TextView) findViewById(d.g.btn_image_problem);
        bIM();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.e(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.gCg);
        this.hxQ = (ScrollView) findViewById(d.g.write_scrollview);
        this.hxQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.gCm != null) {
                        l.b(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.gCm);
                    }
                    if (WriteActivity.this.aMl != null) {
                        WriteActivity.this.aMl.FT();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hyn = (FeedBackTopListView) findViewById(d.g.feedback_top_list);
        this.hyo = findViewById(d.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.hxz = (LinearLayout) findViewById(d.g.tool_view);
        this.hxz.setContentDescription("..");
        this.hxA = (LinearLayout) findViewById(d.g.title_view);
        this.gCj = findViewById(d.g.interval_view);
        this.hyQ = findViewById(d.g.hot_topic_fourm_view);
        this.hyR = findViewById(d.g.hot_topic_divider);
        this.hxT = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.hyS = (TextView) findViewById(d.g.change_one_tv);
        btp();
        if (this.hxR) {
            this.hxQ.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bJe();
        } else {
            this.hyv = new g(getPageContext(), this.mRootView);
            g gVar = this.hyv;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            gVar.nH(z);
        }
        btr();
        if (this.hyk || this.hxy) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().asu) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.gCl = (LinearLayout) findViewById(d.g.post_content_container);
        this.gCl.setDrawingCacheEnabled(false);
        this.gCl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.gCm.requestFocus();
            }
        });
        this.fzT = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.fzU = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.fzW = (ImageView) findViewById(d.g.iv_delete_voice);
        this.fzW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bdJ();
            }
        });
        this.aBf.setOnFocusChangeListener(this.gCg);
        this.aBf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.bti();
                WriteActivity.this.bII();
            }
        });
        this.hyp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bIP();
        i(bJn());
        bIR();
        bIL();
        bJj();
        bJl();
        bID();
        bIQ();
        bto();
        bIX();
        if (this.mData.getType() == 4 && this.gCq != null && this.hxC != null) {
            this.gCq.setVisibility(8);
            this.hxC.setVisibility(8);
        }
        btq();
        bJh();
    }

    private void bIL() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hyk || this.hxy) {
                        if (this.hyl) {
                            this.mName.setText(d.k.feedback_vcode);
                        } else {
                            this.mName.setText(d.k.feedback);
                        }
                    } else if (this.hcf != null && this.hcf.equals("1")) {
                        this.mName.setText(d.k.post_to_home_page);
                    } else if (this.hcf != null && this.hcf.equals("2")) {
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
                    this.gCi.setVisibility(0);
                    this.gCm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(d.k.send_reply);
                    this.gCm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.gCi.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(d.k.publish_photo_live);
                    this.gCm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(d.k.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.hyA.setVisibility(8);
                    return;
                case 7:
                    this.gCi.setVisibility(0);
                    this.gCm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(d.k.post_drift_bottle);
                    return;
            }
        }
    }

    private void bIM() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.send_post));
    }

    private void bIN() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hyk && !this.hxy && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = ap.d(this.mPostTopicData.getTitleTopic(), 31, (String) null);
            if (!StringUtils.isNull(d) && bIV() != null) {
                bIV().setText(d);
                bIV().setSelection(d.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.fzT.setVisibility(0);
            this.fzU.setVoiceModel(voiceModel);
            this.fzU.byM();
            btq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdJ() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.aX(com.baidu.tbadk.core.voice.a.getVoiceFilePath(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.fzT.setVisibility(8);
        this.fzU.aED();
        this.fzU.setVoiceModel(null);
        com.baidu.tbadk.editortools.k eN = this.aMl.eN(6);
        if (eN != null && eN.aMf != null) {
            eN.aMf.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        btq();
    }

    private void bIO() {
        this.hxK = null;
        this.hxM = -1;
        this.hxO = -1;
        z ku = y.avd().ku(1);
        if (ku != null) {
            this.hxK = ku.dmG;
            this.hxM = getIntent().getIntExtra("category_id", -1);
            if (this.hxK != null && !this.hxK.isEmpty() && this.hxM >= 0) {
                this.hxL = new x();
                this.hxL.dmC = 0;
                this.hxL.name = getPageContext().getResources().getString(d.k.category_auto);
                this.hxO = this.hxL.dmC;
                this.hxN = this.hxL.name;
                for (x xVar : this.hxK) {
                    if (xVar.dmC == this.hxM) {
                        this.hxO = xVar.dmC;
                        this.hxN = xVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bIP() {
        if (this.hxK != null && !this.hxK.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hxP = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hxP.setText(this.hxN);
            this.hxP.setCategoryContainerData(this.hxK, this.hxL, this.hxO);
            this.hxP.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, com.baidu.tieba.frs.at atVar) {
                    if (atVar != null) {
                        WriteActivity.this.hxP.setText(atVar.name);
                        WriteActivity.this.mData.setCategoryTo(atVar.dmC);
                        WriteActivity.this.hxO = atVar.dmC;
                        WriteActivity.this.hxP.bIr();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.hxP.bIq();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIV());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIU());
                }
            });
        }
    }

    private void bJh() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hyf = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hyf.setTitle(d.k.no_disturb_start_time);
        this.hyf.setButton(-1, getPageContext().getString(d.k.alert_yes_button), this.hyf);
        this.hyf.setButton(-2, getPageContext().getString(d.k.cancel), this.hyf);
        return this.hyf;
    }

    private void bIQ() {
        this.hxG = (RelativeLayout) findViewById(d.g.addition_container);
        this.hxH = (TextView) findViewById(d.g.addition_create_time);
        this.hxI = (TextView) findViewById(d.g.addition_last_time);
        this.hxJ = (TextView) findViewById(d.g.addition_last_content);
        if (this.hxF != null) {
            this.hxG.setVisibility(0);
            this.hxH.setText(getPageContext().getString(d.k.write_addition_create) + ap.w(this.hxF.getCreateTime() * 1000));
            if (this.hxF.getAlreadyCount() == 0) {
                this.hxI.setVisibility(8);
            } else {
                this.hxI.setText(getPageContext().getString(d.k.write_addition_last) + ap.w(this.hxF.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hxF.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hxJ.setText(lastAdditionContent);
            } else {
                this.hxJ.setVisibility(8);
            }
            bIU().setHint(String.format(getPageContext().getString(d.k.write_addition_hint), Integer.valueOf(this.hxF.getAlreadyCount()), Integer.valueOf(this.hxF.getTotalCount())));
            this.mName.setText(d.k.write_addition_title);
            return;
        }
        this.hxG.setVisibility(8);
    }

    private void bto() {
        this.gCq = findViewById(d.g.post_prefix_layout);
        if (this.hyV == null) {
            this.hyV = new com.baidu.tieba.c.d(getPageContext(), this.gCq);
            this.hyV.jd(d.f.bg_tip_blue_up_left);
            this.hyV.jc(16);
            this.hyV.eK(true);
            this.hyV.D(true);
            this.hyV.jg(l.e(getActivity(), d.e.ds32));
        }
        this.gCn = (TextView) findViewById(d.g.post_prefix);
        this.hxC = findViewById(d.g.prefix_divider);
        this.gCp = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.gCq.setVisibility(0);
            this.hyV.h(getString(d.k.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.gBQ = 0;
            this.gCq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").ah(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).f("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.gCn.setVisibility(0);
                    WriteActivity.this.gCq.setSelected(true);
                    am.c(WriteActivity.this.gCp, d.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gCo, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aMl.FT();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gCi);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.gCm);
                }
            });
            this.gCn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new an("c13013").ah(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).f("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.gCn.setSelected(true);
                    am.c(WriteActivity.this.gCp, d.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.gCo, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aMl.FT();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIV());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIU());
                }
            });
            this.gCo = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.gCo.a(this);
            this.gCo.setMaxHeight(l.e(getActivity(), d.e.ds510));
            this.gCo.setOutsideTouchable(true);
            this.gCo.setFocusable(true);
            this.gCo.setOnDismissListener(this);
            this.gCo.setBackgroundDrawable(am.getDrawable(d.C0142d.cp_bg_line_d));
            int color = am.getColor(d.C0142d.cp_cont_b);
            am.getColor(d.C0142d.cp_cont_c);
            am.i(this.gCn, d.C0142d.cp_bg_line_d);
            am.c(this.gCp, d.f.icon_arrow_gray_down);
            this.gCn.setTextColor(color);
            this.hxD.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.hxD.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.nC(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.nC(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.gCo.addView(writePrefixItemLayout);
            }
            this.gCo.setCurrentIndex(0);
            this.gCn.setText(prefixs.get(0));
            vH(0);
            return;
        }
        this.gCq.setVisibility(8);
    }

    private void bJi() {
        if (this.hyk && this.mData != null) {
            this.hyn.setVisibility(0);
            this.hyo.setVisibility(0);
            this.hxB = new FeedBackModel(getPageContext());
            this.hxB.vN(this.mData.getForumName());
            this.hxB.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void i(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.hyn.setVisibility(8);
                        WriteActivity.this.hyo.setVisibility(8);
                        WriteActivity.this.showToast(d.k.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.hyn.setVisibility(8);
                        WriteActivity.this.hyo.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.hyn.a(feedBackModel.bIt(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bIR() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.jD()) {
                    WriteActivity.this.showToast(d.k.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (WriteActivity.this.hxX.a(WriteActivity.this.gCi, WriteActivity.this.gCm)) {
                        WriteActivity.this.showToast(WriteActivity.this.hxX.bGC());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIV());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bIU());
                    WriteActivity.this.aMl.FT();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.hyk) {
                            WriteActivity.this.bJa();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            an anVar = new an("c12102");
                            anVar.r("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(anVar);
                            WriteActivity.this.bJb();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.bJa();
                    }
                    TiebaStatic.log(new an("c12262").ah("obj_locate", WriteActivity.this.hcf));
                }
            }
        });
    }

    protected void bJj() {
        this.hyq = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hyq.dE(getPageContext().getString(d.k.is_save_draft)).aw(false).a(getPageContext().getString(d.k.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bIV().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bIU().getText().toString());
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
        this.hyq.b(getPageContext());
    }

    protected void btp() {
        this.hym = (HeadImageView) findViewById(d.g.user_head_portrait);
        this.hym.setIsRound(true);
        this.hym.setDrawBorder(false);
        this.hym.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String ex = com.baidu.tbadk.core.util.p.ex(currentPortrait);
            this.hym.setUrl(ex);
            this.hym.startLoad(ex, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.hym.setVisibility(0);
        }
        this.gCi = (EditText) findViewById(d.g.post_title);
        this.gCi.setOnClickListener(this.hyb);
        this.gCi.setOnFocusChangeListener(this.gCg);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.gCi.setText(this.mData.getTitle());
                this.gCi.setSelection(this.mData.getTitle().length());
            } else if (this.hyl) {
                this.gCi.setText(getResources().getString(d.k.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.gCi.addTextChangedListener(this.hyd);
        if (!this.mData.getHaveDraft()) {
            bIN();
            this.hyP = true;
        }
        if (this.mData.isUserFeedback()) {
            this.gCi.setHint(getResources().getString(d.k.feedback_title_hint));
        } else {
            this.gCi.setHint(getResources().getString(d.k.post_title_hint));
        }
    }

    private TextWatcher bJk() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int hyZ;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.btq();
                if (WriteActivity.this.hxR) {
                    this.hyZ = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.hyZ);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.hxR || !WriteActivity.this.hyH) {
                    if (WriteActivity.this.hxR) {
                        if (this.mEditText != WriteActivity.this.hyy || this.mTextView != WriteActivity.this.hyE) {
                            this.mEditText = WriteActivity.this.hyy;
                            this.mTextView = WriteActivity.this.hyE;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.hyC || this.mTextView != WriteActivity.this.hyD) {
                    this.mEditText = WriteActivity.this.hyC;
                    this.mTextView = WriteActivity.this.hyD;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.hxR && this.hyH) {
            if (this.hyF != null) {
                this.hyC.removeTextChangedListener(this.hyF);
            }
            this.hyF = textWatcher;
        } else if (this.hxR) {
            if (this.hyG != null) {
                this.hyy.removeTextChangedListener(this.hyG);
            }
            this.hyG = textWatcher;
        }
        return textWatcher;
    }

    private long l(EditText editText) {
        if (editText == this.hyy) {
            return 233L;
        }
        if (editText != this.hyC) {
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
                    textView.setTextColor(am.getColor(d.C0142d.common_color_10159));
                } else {
                    textView.setTextColor(am.getColor(d.C0142d.cp_cont_d));
                }
            } else if (m < 0) {
                if (m < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(am.getColor(d.C0142d.common_color_10159));
            } else {
                textView.setTextColor(am.getColor(d.C0142d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long m(EditText editText) {
        return com.baidu.tieba.write.b.a.l(editText.getText().toString().trim());
    }

    protected void btr() {
        this.gCm = (EditText) findViewById(d.g.post_content);
        this.gCm.setDrawingCacheEnabled(false);
        this.gCm.setOnClickListener(this.hyb);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString U = TbFaceManager.IU().U(getPageContext().getPageActivity(), this.mData.getContent());
            this.gCm.setText(U);
            this.gCm.setSelection(U.length());
        } else if (this.mData.getType() == 2) {
            if (this.hyr) {
                if (this.hys != null && this.hys.length() > 0) {
                    this.gCm.setText(getPageContext().getPageActivity().getString(d.k.reply_sub_floor, new Object[]{this.hys}));
                    this.gCm.setSelection(this.gCm.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.k.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.gCm.setText(format);
                this.gCm.setSelection(format.length());
            }
        }
        this.gCm.setOnFocusChangeListener(this.gCg);
        this.gCm.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.aMl.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.gCm.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.gCm.addTextChangedListener(this.hye);
        if (this.mData.getType() == 0) {
            this.hyU = true;
        } else {
            nO(true);
            this.hyU = false;
        }
        if (this.mData.isUserFeedback()) {
            this.gCm.setHint(d.k.write_input_content);
        } else {
            this.gCm.setHint(d.k.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void nO(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.hxR) {
            bIU().setPadding(0, 0, 0, 0);
            bIU().setBackgroundDrawable(null);
            am.j(bIU(), d.C0142d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.eYZ) && this.hxF == null) {
                com.baidu.adp.lib.f.c.ig().a(this.eYZ, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
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
                            WriteActivity.this.bIU().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bIU(), true, WriteActivity.this.fGK);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIT() {
        int i = 5000;
        if (this.hxF != null) {
            i = 1000;
        }
        return bIU().getText() != null && bIU().getText().length() >= i;
    }

    private void gK(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hxw)) {
                this.hxw = "";
                bIU().requestFocus();
                if (bIU().getText() != null && bIU().getText().length() + str.length() > 5000) {
                    showToast(d.k.over_limit_tip);
                    return;
                } else {
                    i = bIU().getSelectionStart();
                    editable = bIU().getText();
                }
            } else if ("from_title".equals(this.hxw)) {
                this.hxw = "";
                bIV().requestFocus();
                if (bIV().getText() != null && bIV().getText().length() + str.length() > 31) {
                    showToast(d.k.over_limit_tip);
                    return;
                } else {
                    i = bIV().getSelectionStart();
                    editable = bIV().getText();
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
    public void nM(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bIU().getText().getSpans(0, bIU().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hxE == null) {
                this.hxE = Toast.makeText(getPageContext().getPageActivity(), d.k.too_many_face, 0);
            }
            this.hxE.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType Ct = nVar.Ct();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.ig().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bIU().getSelectionStart(), aVar, Ct);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bIU() != null && bIU().getText() != null) {
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
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.f(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bIU().getSelectionStart() - 1;
                if (bIU().getText().length() > 1 && selectionStart >= 0 && bIU().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bIU().getText().insert(bIU().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bIU().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bIU().getText().insert(bIU().getSelectionStart(), spannableString2);
            }
            Editable text = bIU().getText();
            if (text != null) {
                this.hxU.clear();
                this.hxU.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hxU);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bIU().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bIU().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bIU().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bIU() {
        return this.hxR ? this.hyy : this.gCm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bIV() {
        return this.hxR ? this.hyC : this.gCi;
    }

    protected void bIW() {
        Editable text;
        if (bIU() != null && (text = bIU().getText()) != null) {
            int selectionStart = bIU().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bIU().onKeyDown(67, this.cSx);
            }
            bIU().onKeyDown(67, this.cSx);
            int selectionStart2 = bIU().getSelectionStart();
            if (text != null) {
                this.hxU.clear();
                this.hxU.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hxU);
                bIU().setSelection(selectionStart2);
            }
        }
    }

    private void i(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.k.feedback_bar_name).equals(str)) {
            this.hyk = true;
        }
    }

    private void bJl() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bJm() {
        try {
            if (this.hyq != null) {
                this.hyq.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aVW.d(null);
        this.aVW.dd(d.k.sending);
        this.aVW.aO(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aVW.aO(false);
    }

    private Boolean bJn() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aNT = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btq() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bIV() != null) {
                str = bIV().getText().toString();
            }
            if (bIU() != null) {
                str2 = bIU().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.gBQ == w.z(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.hxA.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            nN(true);
                            return;
                        }
                    } else if (this.hxA.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        nN(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.hxA.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    nN(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hxR) {
                    nN(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    nN(true);
                }
            }
            if (this.mData.getType() == 4) {
                nN(o(this.hyy) && n(this.hyC));
            } else if (this.mData.getType() == 5) {
                nN(o(this.hyy));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                nN(true);
            } else if (this.mData.getVideoInfo() != null) {
                nN(true);
            } else {
                nN(false);
            }
        }
    }

    public void nN(boolean z) {
        if (z) {
            am.b(this.mPost, d.C0142d.cp_link_tip_a, d.C0142d.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        am.c(this.mPost, d.C0142d.cp_cont_d, 1);
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
        this.aNP = new NewWriteModel(this);
        this.aNP.b(this.aOd);
        registerListener(this.hyW);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.bti();
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
            this.hyk = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.hyl = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hyr = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hys = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.aNN = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.hxF = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hxF != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.hyt = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hyT = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.hcf = bundle.getString("KEY_CALL_FROM");
            this.hsy = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
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
            this.hyk = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.hyl = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hyr = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hys = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.hxF = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hxF != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.hyt = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hyT = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.hcf = intent.getStringExtra("KEY_CALL_FROM");
            this.hsy = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.hyk);
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
        this.eYZ = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hxy = true;
        }
        bIO();
        try {
            this.hyI = bJt();
        } catch (Throwable th) {
            this.hyI = null;
        }
    }

    private void bIX() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) w.d(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.gCi.setText(com.baidu.tbadk.plugins.b.hs(com.baidu.tbadk.plugins.b.ht(hotTopicBussinessData.mTopicName)));
            this.gCi.setMovementMethod(com.baidu.tieba.view.c.bFG());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) w.d(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString hs = com.baidu.tbadk.plugins.b.hs(com.baidu.tbadk.plugins.b.ht(hotTopicBussinessData.mTopicName));
            if (hs != null) {
                this.gCi.setText(hs);
            }
            this.hxT.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t.a
    public void a(WriteData writeData) {
        String str;
        String ht;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (com.baidu.adp.lib.util.k.isEmpty(bIV().getText().toString()) || this.hyP || ((this.hyk || this.hxy) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                    if (com.baidu.adp.lib.util.k.isEmpty(this.mData.getTitle())) {
                        this.mData.setTitle(writeData.getTitle());
                    }
                    if (!w.A(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) w.d(this.mList, 0);
                        if (hotTopicBussinessData == null) {
                            str = null;
                        } else {
                            str = hotTopicBussinessData.mTopicName;
                        }
                        if (StringUtils.isNull(str)) {
                            ht = this.mData.getTitle();
                        } else {
                            ht = com.baidu.tbadk.plugins.b.ht(str);
                        }
                        SpannableString hs = com.baidu.tbadk.plugins.b.hs(ht);
                        if (hs != null) {
                            bIV().setText(hs);
                            bIV().setSelection(hs.length() > ht.length() ? ht.length() : hs.length());
                        }
                    } else {
                        SpannableString hs2 = com.baidu.tbadk.plugins.b.hs(this.mData.getTitle());
                        if (hs2 != null) {
                            bIV().setText(hs2);
                            bIV().setSelection(this.mData.getTitle().length() > hs2.length() ? hs2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bIN();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aMl.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.k.isEmpty(bIU().getText().toString()) || this.hyk || this.hxy) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.IU().a(getPageContext().getPageActivity(), this.mData.getContent(), this.hxZ);
                    bIU().setText(a2);
                    bIU().setSelection(a2.length());
                    if (this.hxR) {
                        a(this.hyE, this.hyy);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bJs();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        bJd();
                    }
                    nP(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bJo();
                }
                btq();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.hxK != null) {
                    this.hxO = this.hxL.dmC;
                    this.hxN = this.hxL.name;
                    int i = 0;
                    while (true) {
                        if (i == this.hxK.size()) {
                            break;
                        }
                        x xVar = this.hxK.get(i);
                        if (categoryTo != xVar.dmC) {
                            i++;
                        } else {
                            this.hxO = categoryTo;
                            this.hxN = xVar.name;
                            this.mData.setCategoryTo(this.hxO);
                            break;
                        }
                    }
                    if (this.hxP != null) {
                        this.hxP.setText(this.hxN);
                        this.hxP.setCategoryContainerData(this.hxK, this.hxL, this.hxO);
                    }
                }
                this.aMl.FT();
                return;
            }
            return;
        }
        bJo();
        bIN();
    }

    private void bJo() {
        if ((!this.hxR || this.hyx != null) && this.hyw != null) {
            this.hyx.c(this.writeImagesInfo);
            aUn();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.hyr);
        if (this.hyk) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aNN);
        if (this.hxF != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hxF));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.hyt);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.hcf);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hsy);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bIU().getEditableText().toString();
        if (obj != null) {
            bIU().setText(TbFaceManager.IU().a(getPageContext().getPageActivity(), obj, this.hxZ));
            bIU().setSelection(bIU().getText().length());
        }
    }

    private String bIY() {
        return (bIU() == null || bIU().getText() == null) ? "" : bIU().getText().toString();
    }

    private String bIZ() {
        if (this.mData == null || bIV() == null || bIV().getVisibility() != 0 || bIV().getText() == null) {
            return "";
        }
        String obj = bIV().getText().toString();
        if (this.mPrefixData != null && w.z(this.mPrefixData.getPrefixs()) > 0 && this.gBQ != w.z(this.mPrefixData.getPrefixs()) - 1 && this.mData.getType() != 4 && this.gCn != null && this.gCn.getText() != null) {
            this.mData.setPostPrefix(this.gCn.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void vO(String str) {
        if (this.mData != null && this.hxA != null) {
            if (this.hxA.getVisibility() == 0) {
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
    public void bJa() {
        bti();
        this.mData.setContent(bIY());
        vO(bIZ());
        if (this.hyk || this.hxy) {
            String string = getResources().getString(d.k.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                vO(string + this.mData.getTitle());
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
        if (this.hxM >= 0) {
            this.mData.setCategoryFrom(this.hxM);
        }
        if (this.hxO >= 0) {
            this.mData.setCategoryTo(this.hxO);
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
        this.mData.setHasLocationData(this.aNO != null && this.aNO.afw());
        if (this.writeImagesInfo != null) {
            this.aNP.mN(this.writeImagesInfo.size() > 0);
        }
        if (!w.A(this.mList) && this.hxS != null && this.hxS.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hxS.mForumId));
            this.mData.setForumName(this.hxS.mForumName);
        }
        this.aNP.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.aNP.getWriteData().setVoice(this.mVoiceModel.getId());
                this.aNP.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.aNP.getWriteData().setVoice(null);
                this.aNP.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aNP.getWriteData().setVoice(null);
            this.aNP.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aNP.byO()) {
            showToast(d.k.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.jD()) {
            showToast(d.k.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.k.sending), this.mDialogCancelListener);
            this.aNP.startPostWrite();
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
            if (this.hxF != null) {
                i2 = this.hxF.getTotalCount();
                i = this.hxF.getAlreadyCount() + 1;
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
                if (this.gCi == getCurrentFocus()) {
                    bIU().clearFocus();
                    this.gCi.requestFocus();
                    if (this.aMl != null) {
                        this.aMl.FT();
                    }
                    ShowSoftKeyPadDelay(this.gCi);
                } else {
                    bIU().requestFocus();
                    if (this.aMl != null) {
                        this.aMl.FT();
                    }
                    ShowSoftKeyPadDelay(this.gCm);
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
                            bIU().getText().insert(bIU().getSelectionStart(), sb.toString());
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
                                bJr();
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
                        if (this.hyU) {
                            nO(true);
                            this.hyU = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.hxR) {
                        A(intent);
                        btq();
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
                    btq();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.hxx) {
                                sb2.append(com.baidu.tbadk.plugins.b.aVu);
                                this.hxx = false;
                            }
                            sb2.append(stringExtra);
                            gK(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !w.A(this.mList) && !w.A(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.hxS = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.hxS);
                }
            }
        } else if (i2 == 0) {
            if (this.aMl != null && !this.aMl.HB()) {
                this.gCm.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.aMl.FT();
            }
            switch (i) {
                case 12001:
                    Ig();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bJq();
                    if (this.hyU) {
                        nO(true);
                        this.hyU = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.gCi == getCurrentFocus()) {
                        bIU().clearFocus();
                        this.gCi.requestFocus();
                        if (this.aMl != null) {
                            this.aMl.FT();
                        }
                        ShowSoftKeyPadDelay(this.gCi);
                        return;
                    }
                    bIU().requestFocus();
                    if (this.aMl != null) {
                        this.aMl.FT();
                    }
                    ShowSoftKeyPadDelay(this.gCm);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.hxX.vu(postWriteCallBackData.getErrorString());
                        this.hxX.aB(postWriteCallBackData.getSensitiveWords());
                        this.hxX.b(this.gCi, this.gCm);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.aNN = String.valueOf(System.currentTimeMillis());
                    al.a(getPageContext(), this.aNN);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bJq();
                    return;
                case 25004:
                    if ("from_title".equals(this.hxw)) {
                        bIV().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hxw)) {
                        bIU().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJb() {
        if ("1".equals(this.hcf)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.hcf)) {
            this.mData.setCanNoForum(false);
        }
        bJc();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.hcf);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bJa();
    }

    private void bJc() {
        if (this.aMl != null) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void bJp() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bJq() {
        if (this.hxR) {
            this.hyx.c(this.writeImagesInfo);
            aUn();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUn() {
        this.hyx.notifyDataSetChanged();
        this.hyw.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.hyx.notifyDataSetChanged();
                WriteActivity.this.hyw.invalidateViews();
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
        btq();
    }

    private void ae(Intent intent) {
        if (this.hxR) {
            af(intent);
            bJq();
        } else {
            ai(intent);
        }
        btq();
    }

    private void af(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bJq();
            nP(true);
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

    private void bJr() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void ah(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.hyu.parseJson(stringExtra);
            this.hyu.updateQuality();
            if (this.hyu.getChosedFiles() != null && this.hyu.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.hyu.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.hyu.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bIV());
        HidenSoftKeyPad(this.mInputManager, bIU());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ai(Intent intent) {
        c(intent, true);
    }

    private void z(Intent intent) {
        this.aNN = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aNN;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.ah(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.aj(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.l.a(TbConfig.LOCAL_CAMERA_DIR, this.aNN, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bJs();
            bJd();
        }
        nP(true);
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
                bJs();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    bJd();
                }
            }
            nP(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJs() {
        if (this.aMl.eN(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void Ig() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.l.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aNN));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void nP(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.hyv != null) {
            this.hyv.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.djz == null) {
            this.djz = VoiceManager.instance();
        }
        return this.djz;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void atX() {
        this.djz = getVoiceManager();
        this.djz.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.tQ(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.dkD) != null) {
                    TiebaStatic.log(new an("c12534").r("obj_locate", at.a.arM));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.k.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hxF == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                r(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aNU = i;
        if (this.aMl != null) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bJd() {
        if (!this.hxR) {
            if (this.aMl != null) {
                this.aMl.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aMl.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.hyv != null) {
                this.hyv.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(boolean z) {
        if (this.aMl != null) {
            this.aMl.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void vH(int i) {
        if (i < this.hxD.size()) {
            for (int i2 = 0; i2 < this.hxD.size(); i2++) {
                this.hxD.get(i2).nD(false);
            }
            this.hxD.get(i).nD(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void tj(int i) {
        if (i == w.z(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new an("c13014").r("obj_type", 1));
        } else {
            TiebaStatic.log(new an("c13014").r("obj_type", 2));
        }
        this.gBQ = i;
        this.gCo.setCurrentIndex(i);
        vH(i);
        this.gCn.setText(this.mPrefixData.getPrefixs().get(i));
        btq();
        com.baidu.adp.lib.g.g.a(this.gCo, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.gCq.setSelected(false);
        am.c(this.gCp, d.f.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.gCm);
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

    @Override // android.app.Activity, com.baidu.d.a.a.InterfaceC0062a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            Ia();
        } else if (i == 1) {
            ArrayMap<String, Boolean> b = ac.b(strArr, iArr);
            if (ac.aN(getApplicationContext())) {
                al.a(getPageContext(), this.aNN);
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
        this.hxW = z;
        if (this.hyN && System.currentTimeMillis() - this.hyO < 800) {
            l.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.hyN = false;
        }
        if (this.hxV != null && !z) {
            this.hxV.aox();
        }
        if (this.hxY != null && !z) {
            bIG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vP(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.hyK != null) {
            vQ(str);
            this.hyK.dismiss();
        }
    }

    private void cr(Context context) {
        hyM = l.aj(context);
    }

    private void vQ(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.k.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.hyN = true;
        bJs();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            bJd();
        }
        nP(true);
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

    private File bJt() {
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

    private void bJu() {
        if (this.hyI != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            cr(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(d.i.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.hyI != null) {
                        WriteActivity.this.vP(WriteActivity.this.hyI.getAbsolutePath());
                    }
                }
            });
            this.hyJ = (TbImageView) this.mBubbleView.findViewById(d.g.rec_img_view);
            this.hyL = (LinearLayout) this.mBubbleView.findViewById(d.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.hyI.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.hyI.getAbsolutePath());
                Bitmap f = f(this.hyI.getAbsolutePath(), getResources().getDimensionPixelSize(d.e.ds160));
                if (f != null) {
                    this.hyJ.setImageBitmap(f);
                    this.hyJ.setDrawBorder(true);
                    this.hyJ.setBorderWidth(2);
                    this.hyJ.setBorderColor(am.getColor(d.C0142d.common_color_10264));
                    this.hyK = new Dialog(getActivity(), d.l.bubble_dialog);
                    this.hyK.setCanceledOnTouchOutside(true);
                    this.hyK.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.hyN) {
                                l.b(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.hyO = System.currentTimeMillis();
                            }
                        }
                    });
                    this.hyK.setContentView(this.mBubbleView);
                    this.hyK.show();
                    Window window = this.hyK.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.e.ds28);
                    attributes.y = (hyM / 18) + getResources().getDimensionPixelSize(d.e.ds12);
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
        if (this.hxW && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hxx = false;
            this.hxw = "";
            if ("from_content".equals(str)) {
                this.hxw = "from_content";
            } else if ("from_title".equals(str)) {
                this.hxw = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.hr(String.valueOf(charSequence.charAt(i)))) {
                nM(false);
            }
        }
    }

    public void bpv() {
        if (this.hyk || !w.A(this.mList) || !StringUtils.isNull(this.mData.getTitle())) {
            this.hxA.setVisibility(0);
            this.hxA.requestFocus();
            this.aMl.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hxA.setVisibility(8);
    }
}
