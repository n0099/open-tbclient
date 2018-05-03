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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.o;
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
import com.baidu.tieba.frs.v;
import com.baidu.tieba.frs.w;
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
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0045a, VoiceManager.c, t.a, d.a {
    private static int hhD = 0;
    private EditorTools aCS;
    private String aEu;
    private LocationModel aEv;
    private NewWriteModel aEw;
    private VoiceManager cXg;
    private LinearLayout fjq;
    private PlayVoiceBntNew fjr;
    private ImageView fjt;
    private TextView glQ;
    private com.baidu.tieba.write.d glR;
    private ImageView glS;
    private View glT;
    private int glt;
    private TextView hgA;
    List<v> hgB;
    v hgC;
    private int hgD;
    private String hgE;
    private int hgF;
    private PostCategoryView hgG;
    private HotTopicBussinessData hgJ;
    private TextView hgK;
    private com.baidu.tieba.write.editor.b hgM;
    private e hgP;
    private com.baidu.tieba.view.b hgW;
    private LinearLayout hgq;
    private LinearLayout hgr;
    private View hgt;
    private Toast hgv;
    private AdditionData hgw;
    private RelativeLayout hgx;
    private TextView hgy;
    private TextView hgz;
    private View hhH;
    private View hhI;
    private TextView hhJ;
    private com.baidu.tieba.d.c hhM;
    private View hhf;
    private g hhm;
    private boolean isPrivacy;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    private PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private int privateThread;
    private String hgn = "";
    private boolean hgo = false;
    private WriteData mData = null;
    private boolean hhb = false;
    private boolean hgp = false;
    private boolean hhc = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText glL = null;
    private HeadImageView hhd = null;
    private View glM = null;
    private LinearLayout glO = null;
    private EditText glP = null;
    private FeedBackModel hgs = null;
    private FeedBackTopListView hhe = null;
    private ArrayList<WritePrefixItemLayout> hgu = new ArrayList<>();
    private String eIH = null;
    private final KeyEvent cKg = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View asg = null;
    private TextView hhg = null;
    private TextView mPost = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a hhh = null;
    private final Handler mHandler = new Handler();
    private boolean hhi = false;
    private String hhj = null;
    private RelativeLayout mParent = null;
    private String aEA = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int aEB = 0;
    private int hhk = 0;
    private WriteImagesInfo hhl = new WriteImagesInfo();
    private View mRootView = null;
    private GridView hhn = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a hho = null;
    private ScrollView hgH = null;
    private EditText hhp = null;
    private View hhq = null;
    private View hhr = null;
    private View hhs = null;
    private EditText hht = null;
    private TextView hhu = null;
    private TextView hhv = null;
    private TextWatcher hhw = null;
    private TextWatcher hhx = null;
    private boolean hgI = false;
    private boolean hhy = false;
    private com.baidu.tbadk.core.view.a aNc = null;
    private String mFrom = AlbumActivityConfig.FROM_WRITE;
    private File hhz = null;
    private TbImageView hhA = null;
    private View mBubbleView = null;
    private Dialog hhB = null;
    private LinearLayout hhC = null;
    private boolean hhE = false;
    private long hhF = -1000;
    private boolean hhG = false;
    private String gLv = "2";
    private int hbp = 0;
    private String hhK = "";
    private SpannableStringBuilder hgL = new SpannableStringBuilder();
    private boolean hhL = false;
    private boolean hgN = false;
    private final b hgO = new b();
    private final HttpMessageListener hhN = new HttpMessageListener(CmdConfigHttp.REQUEST_BUBBLELIST_CMD) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(2001284, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.eIH)) {
                    WriteActivity.this.eIH = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.nx(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.eIH)) {
                    WriteActivity.this.eIH = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.eIH);
                    WriteActivity.this.nx(true);
                }
            }
        }
    };
    private TbFaceManager.a hgQ = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan gC(String str) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new RequestStaticEmotionMessage(null, str), com.baidu.adp.widget.ImageView.a.class);
            com.baidu.adp.widget.ImageView.a aVar = runTask != null ? (com.baidu.adp.widget.ImageView.a) runTask.getData() : null;
            if (aVar == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar.km());
            int width = aVar.getWidth();
            if (str.startsWith("#(meme,")) {
                bitmapDrawable.setBounds(0, 0, width, aVar.getHeight());
            } else {
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            return new com.baidu.tbadk.core.view.d(bitmapDrawable, 0);
        }
    };
    private final AntiHelper.a cYe = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12536").r("obj_locate", ar.a.ajb));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new al("c12535").r("obj_locate", ar.a.ajb));
        }
    };
    private final NewWriteModel.d aEK = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.t tVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.apC();
            WriteActivity.this.closeLoadingDialog();
            if (postWriteCallBackData != null && WriteActivity.this.mData != null) {
                WriteActivity.this.hgO.ax(null);
                if (z) {
                    WriteActivity.this.bF(z);
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
                        if (!com.baidu.tbadk.core.util.v.w(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.hhK)) {
                            TiebaStatic.log(new al("c11731").ac(VideoPlayActivityConfig.OBJ_ID, WriteActivity.this.hhK));
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
                    WriteActivity.this.hgO.ax(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.hgO.uB(postWriteCallBackData.getErrorString());
                    WriteActivity.this.hgO.b(WriteActivity.this.glL, WriteActivity.this.glP);
                } else if ((tVar == null || writeData == null || tVar.getVcode_pic_url() == null || AntiHelper.f(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (tVar != null && writeData != null && tVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(tVar.getVcode_md5());
                    writeData.setVcodeUrl(tVar.getVcode_pic_url());
                    writeData.setVcodeExtra(tVar.yL());
                    if (com.baidu.tbadk.p.a.hq(tVar.yK())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG, writeData, false, tVar.yK());
                        if (WriteActivity.this.hhc) {
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
    private final LocationModel.a aEI = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.39
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void Eu() {
            WriteActivity.this.showToast(d.k.no_network_guide);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void gq(String str) {
            WriteActivity writeActivity = WriteActivity.this;
            if (StringUtils.isNull(str)) {
                str = WriteActivity.this.getPageContext().getString(d.k.location_fail);
            }
            writeActivity.showToast(str);
            WriteActivity.this.b(0, true, null);
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
            if (aVar != null && !StringUtils.isNull(aVar.bsA())) {
                WriteActivity.this.b(2, true, aVar.bsA());
            } else {
                gq(null);
            }
        }
    };
    private final CustomMessageListener gyE = new CustomMessageListener(2001226) { // from class: com.baidu.tieba.write.write.WriteActivity.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.aEv.mt(false);
                    WriteActivity.this.aEv.cf(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.b(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.aEv.mt(true);
                WriteActivity.this.b(0, true, null);
            }
        }
    };
    private CustomMessageListener hgR = new CustomMessageListener(2016554) { // from class: com.baidu.tieba.write.write.WriteActivity.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private final View.OnClickListener hgS = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.42
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            WriteActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int bCY = WriteActivity.this.bCY();
            if (bCY >= 0 && bCY < WriteActivity.this.glP.getText().length()) {
                WriteActivity.this.glP.setSelection(bCY);
            }
        }
    };
    private boolean hgT = true;
    private final View.OnFocusChangeListener glJ = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.3
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            if (view2 == WriteActivity.this.glL || view2 == WriteActivity.this.asg || view2 == WriteActivity.this.mPost) {
                if (z) {
                    WriteActivity.this.hgT = true;
                    WriteActivity.this.bCZ();
                    l.c(WriteActivity.this.getActivity(), WriteActivity.this.glL);
                    if (WriteActivity.this.aCS != null) {
                        WriteActivity.this.aCS.Ca();
                    }
                } else if (view2 == WriteActivity.this.glL) {
                    WriteActivity.this.glQ.setVisibility(0);
                }
            }
            if (view2 == WriteActivity.this.glP && z) {
                WriteActivity.this.hgT = false;
                WriteActivity.this.bCZ();
                l.c(WriteActivity.this.getActivity(), WriteActivity.this.glP);
                if (WriteActivity.this.aCS != null) {
                    WriteActivity.this.aCS.Ca();
                }
            }
            WriteActivity.this.bDf();
        }
    };
    private TextWatcher hgU = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        private String hgY = "";
        private String hgZ;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hgZ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hgZ != null ? this.hgZ.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bnS();
            WriteActivity.this.bDg();
            EditText bDr = WriteActivity.this.bDr();
            if (editable != null && bDr != null && bDr.getText() != null) {
                if (this.hgY == null || !this.hgY.equals(editable.toString())) {
                    if (WriteActivity.this.hgO != null) {
                        this.hgY = bDr.getText().toString();
                        WriteActivity.this.hgO.k(bDr);
                        return;
                    }
                    return;
                }
                bDr.setSelection(bDr.getSelectionEnd());
            }
        }
    };
    private TextWatcher hgV = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        private String hgZ;
        private String hha = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.hgZ = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.hgZ != null ? this.hgZ.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.bnS();
            EditText bDq = WriteActivity.this.bDq();
            if (editable != null && bDq != null && bDq.getText() != null) {
                if (this.hha == null || !this.hha.equals(editable.toString())) {
                    if (WriteActivity.this.hgO != null) {
                        this.hha = bDq.getText().toString();
                        WriteActivity.this.hgO.k(bDq);
                        return;
                    }
                    return;
                }
                bDq.setSelection(bDq.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0215a fqk = new a.InterfaceC0215a() { // from class: com.baidu.tieba.write.write.WriteActivity.30
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0215a
        public void onRefresh() {
            WriteActivity.this.eIH = null;
            WriteActivity.this.nx(false);
            WriteActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void Eg() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void Eh() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(d.k.location_system_permission_prompt);
            b(0, true, null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            Ei();
        } else if (this.aEv.bsI()) {
            Eg();
        } else {
            this.aEv.mt(false);
            b(1, true, null);
            this.aEv.bsG();
        }
    }

    private void Ei() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.bZ(d.k.location_app_permission_prompt).a(d.k.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.gP()) {
                    WriteActivity.this.b(1, true, null);
                    WriteActivity.this.aEv.abs();
                } else {
                    WriteActivity.this.aEI.Eu();
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
        aVar.tD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bCY() {
        int selectionEnd = bDq().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) bDq().getText().getSpans(0, bDq().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = bDq().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = bDq().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCZ() {
        if (this.aCS != null) {
            this.aCS.setBarLauncherEnabled(!this.hgT);
            this.aCS.setBarLauncherEnabled(true, 26);
            this.aCS.setBarLauncherEnabled(true, 2);
            K(9, this.hgT ? false : true);
        }
    }

    private void K(int i, boolean z) {
        com.baidu.tbadk.editortools.g eE;
        if (this.aCS != null && (eE = this.aCS.eE(i)) != null) {
            if (z) {
                eE.lN();
            } else {
                eE.hide();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.hgI) {
            this.glL.setVisibility(8);
            if (this.mData.getType() == 5) {
                this.hhs.setVisibility(8);
            } else {
                this.hhs.setVisibility(0);
            }
            a(this.hhv, this.hhp);
            a(this.hhu, this.hht);
            bnS();
        }
        if (this.hhb) {
            this.hgT = true;
            bCZ();
            if (this.aCS != null) {
                this.aCS.Ca();
            }
            this.glL.requestFocus();
            ShowSoftKeyPadDelay(this.glL);
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
            bDO();
            if (this.writeImagesInfo.getChosedFiles() != null) {
                bDz();
            }
            ny(true);
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
            vi(this.hbp);
        }
        initUI();
        bDE();
        this.aEv = new LocationModel(this);
        this.aEv.a(this.aEI);
        registerListener(this.gyE);
        registerListener(this.hgR);
        initEditor();
        bDQ();
        if (this.hgI) {
            this.hho.setEditorTools(this.aCS);
        } else {
            this.glP.requestFocus();
        }
        bjW();
        bDz();
    }

    @SuppressLint({"ResourceAsColor"})
    private void initEditor() {
        this.aCS = new EditorTools(getActivity());
        this.aCS.setBarMaxLauCount(5);
        this.aCS.setMoreButtonAtEnd(true);
        this.aCS.setBarLauncherType(1);
        this.aCS.bx(true);
        this.aCS.by(true);
        this.aCS.setMoreLauncherIcon(d.f.write_more);
        this.aCS.setBackgroundColorId(d.C0126d.cp_bg_line_d);
        switch (this.mData.getType()) {
            case 4:
            case 5:
                bDC();
                break;
            default:
                bDa();
                break;
        }
        this.aCS.DG();
        if (this.hgq != null) {
            this.hgq.addView(this.aCS);
        }
        bDb();
        this.aCS.lN();
        com.baidu.tbadk.editortools.g eE = this.aCS.eE(6);
        if (eE != null && !TextUtils.isEmpty(this.aEA)) {
            ((View) eE).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    WriteActivity.this.showToast(WriteActivity.this.aEA);
                }
            });
        }
        if (!this.hgI) {
            this.aCS.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.aCS.Ca();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("xiaoying_has_click", false)) {
            this.aCS.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("hot_topic_has_click", false)) {
            this.aCS.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        bDd();
    }

    private void bDA() {
        this.hhq = this.mRootView.findViewById(d.g.photo_live_scroll);
        this.hhs = this.hhq.findViewById(d.g.live_post_title_container);
        this.hhp = (EditText) this.hhq.findViewById(d.g.live_post_content);
        this.hhn = (GridView) this.hhq.findViewById(d.g.photoLiveGridView);
        this.hht = (EditText) this.hhq.findViewById(d.g.live_post_title);
        this.hhu = (TextView) this.hhq.findViewById(d.g.titleOverPlusNumber);
        this.hhv = (TextView) this.hhq.findViewById(d.g.contentOverPlusNumber);
        this.hhr = this.hhq.findViewById(d.g.live_interval_view);
        this.hhu.setText(String.valueOf(20));
        this.hhv.setText(String.valueOf(233));
        this.hhq.setVisibility(0);
        this.hhu.setVisibility(0);
        this.hhv.setVisibility(0);
        this.hht.setHint(d.k.tips_title_limit_new);
        this.hht.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z) {
                    WriteActivity.this.hhy = true;
                    WriteActivity.this.hgT = true;
                    WriteActivity.this.bCZ();
                    if (WriteActivity.this.aCS != null) {
                        WriteActivity.this.aCS.Ca();
                    }
                }
            }
        });
        if (this.mData.getType() == 4) {
            this.hhp.setHint(d.k.live_write_input_content_new);
        } else if (this.mData.getType() == 5) {
            this.hhp.setHint(d.k.live_write_input_content_update);
        }
        this.hhp.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z) {
                    WriteActivity.this.hhy = false;
                    WriteActivity.this.hgT = false;
                    WriteActivity.this.bCZ();
                    if (WriteActivity.this.aCS != null) {
                        WriteActivity.this.aCS.Ca();
                    }
                }
            }
        });
        this.hhp.requestFocus();
        this.hhp.addTextChangedListener(bDG());
        this.hht.requestFocus();
        this.hht.addTextChangedListener(bDG());
        this.hht.setOnClickListener(this.hgS);
        this.hhp.setOnClickListener(this.hgS);
        this.hho = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.hhn);
        this.hho.vc(6);
        this.hhn.setAdapter((ListAdapter) this.hho);
        View findViewById = this.hhq.findViewById(d.g.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void bCK() {
                WriteActivity.this.aOK();
            }
        });
        bDB();
    }

    private void bDB() {
        if (this.mData.getType() == 0) {
            if (this.mData.getTitle() != null) {
                this.hht.setText(this.mData.getTitle());
                this.hht.setSelection(this.mData.getTitle().length());
                return;
            }
            return;
        }
        if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.hgI) {
            bDL();
        }
        if (this.aCS.DI()) {
            this.aCS.Ca();
        }
        vi(0);
    }

    private void vi(int i) {
        if (this.writeImagesInfo != null && this.mData != null) {
            AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumActivityConfig.getIntent().putExtra("forum_id", this.mData.getForumId());
            albumActivityConfig.getIntent().putExtra("forum_name", this.mData.getForumName());
            albumActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
            albumActivityConfig.setAlbumThread(i);
            albumActivityConfig.setFromWrite(true);
            albumActivityConfig.setCallFrom(this.gLv);
            sendMessage(new CustomMessage(2002001, albumActivityConfig));
        }
    }

    private void bDC() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.aCS.C(arrayList);
        com.baidu.tbadk.editortools.k eH = this.aCS.eH(5);
        if (eH != null) {
            eH.aDB = 2;
            eH.aDz = d.f.write_emotion;
        }
        com.baidu.tbadk.editortools.a.a aVar = new com.baidu.tbadk.editortools.a.a(getActivity(), 3);
        aVar.aDz = d.f.write_at;
        this.aCS.b(aVar);
        this.aCS.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void bDa() {
        com.baidu.tbadk.editortools.k kVar;
        com.baidu.tbadk.editortools.k kVar2;
        com.baidu.tbadk.editortools.k kVar3;
        com.baidu.tbadk.editortools.k kVar4;
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.k kVar5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 2);
        dVar.aDz = d.f.write_picture;
        this.aCS.b(dVar);
        Boolean bDJ = bDJ();
        if (!this.hhb && bDJ != null && bDJ.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.btg() && p.a(this.mData.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, getActivity()), com.baidu.tbadk.editortools.k.class)) != null && (kVar5 = (com.baidu.tbadk.editortools.k) runTask.getData()) != null) {
            kVar5.aDB = 3;
            kVar5.aDz = d.f.write_recorder;
            this.aCS.b(kVar5);
        }
        com.baidu.tbadk.editortools.c.a aVar = new com.baidu.tbadk.editortools.c.a(getActivity(), 4);
        aVar.aDz = d.f.icon_post_topic_selector;
        this.aCS.b(aVar);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001343, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask2 != null && (kVar4 = (com.baidu.tbadk.editortools.k) runTask2.getData()) != null) {
            kVar4.aDB = 5;
            kVar4.aDz = d.f.write_privilege;
            this.aCS.b(kVar4);
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2016556, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask3 != null && (kVar3 = (com.baidu.tbadk.editortools.k) runTask3.getData()) != null) {
            kVar3.aDB = 6;
            kVar3.aDz = this.hhb ? d.f.write_location : d.f.icon_post_more_location;
            this.aCS.b(kVar3);
        }
        com.baidu.tbadk.editortools.a.a aVar2 = new com.baidu.tbadk.editortools.a.a(getActivity(), 7);
        aVar2.aDz = d.f.icon_post_more_at;
        this.aCS.b(aVar2);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask4 != null && (kVar2 = (com.baidu.tbadk.editortools.k) runTask4.getData()) != null) {
            kVar2.aDD = true;
            kVar2.aDB = 9;
            kVar2.aDz = 0;
            this.aCS.b(kVar2);
        }
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, getActivity()), com.baidu.tbadk.editortools.k.class);
        if (runTask5 != null && (kVar = (com.baidu.tbadk.editortools.k) runTask5.getData()) != null) {
            kVar.aDD = true;
            kVar.aDB = 10;
            kVar.aDz = 0;
            this.aCS.b(kVar);
        }
        if (this.hgw == null) {
            if (this.hgM == null) {
                this.hgM = new com.baidu.tieba.write.editor.b(getActivity(), this.gLv);
                this.hgM.aP(this.mData.getForumId(), this.privateThread);
            }
            this.aCS.b(this.hgM);
        }
        this.aCS.C(arrayList);
        com.baidu.tbadk.editortools.k eH = this.aCS.eH(5);
        if (eH != null) {
            eH.aDB = 1;
            eH.aDz = d.f.write_emotion;
        }
    }

    private void bDc() {
        if (this.hgP != null) {
            this.hgP.hideTip();
        }
    }

    private void bDd() {
        if (this.hgP == null) {
            this.hgP = new e(getPageContext());
        }
        this.hgP.c(this.aCS);
    }

    private void bDb() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                String str;
                VideoInfo videoInfo;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        if (WriteActivity.this.bDp()) {
                            WriteActivity.this.showToast(d.k.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage(2002001, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new al("c12612").r("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (WriteActivity.this.bDp()) {
                            WriteActivity.this.showToast(d.k.over_limit_tip);
                        } else if (aVar.data != null && (aVar.data instanceof n)) {
                            WriteActivity.this.d((n) aVar.data);
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.bDs();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.aYd();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.bDO();
                        WriteActivity.this.bnS();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.vj(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        TiebaStatic.log(new al("c12612").r("obj_locate", 3));
                        if (aVar.data != null && WriteActivity.this.hgw == null) {
                            WriteActivity.this.Ej();
                            return;
                        }
                        switch (WriteActivity.this.aEB) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ab.aC(pageActivity)) {
                                    WriteActivity.this.Eh();
                                    return;
                                } else {
                                    ab.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.Eg();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.aEv != null) {
                            WriteActivity.this.aEv.mt(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.eIH = null;
                        } else {
                            WriteActivity.this.eIH = (String) aVar.data;
                        }
                        WriteActivity.this.nx(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("xiaoying_has_click", true);
                        al alVar = new al("c10645");
                        if (WriteActivity.this.mData != null) {
                            str = WriteActivity.this.mData.getForumId();
                        } else {
                            str = "";
                        }
                        alVar.ac(ImageViewerConfig.FORUM_ID, str);
                        TiebaStatic.log(alVar);
                        if (WriteActivity.this.mData == null || (videoInfo = WriteActivity.this.mData.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.aCS.DI()) {
                                        WriteActivity.this.aCS.Ca();
                                        WriteActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.mData.setVideoInfo(null);
                        WriteActivity.this.bnS();
                        if (WriteActivity.this.glP != null) {
                            WriteActivity.this.glP.requestFocus();
                        }
                        WriteActivity.this.aCS.Ca();
                        WriteActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.glP);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new al("c12612").r("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("hot_topic_has_click", true);
                        WriteActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.hgo = true;
                        WriteActivity.this.nv(true);
                        if (WriteActivity.this.bDr().isFocused()) {
                            WriteActivity.this.hgn = "from_title";
                        } else if (WriteActivity.this.bDq().isFocused()) {
                            WriteActivity.this.hgn = "from_content";
                        }
                    } else if (aVar.code == 45) {
                        WriteActivity.this.hgr.setVisibility(0);
                        WriteActivity.this.hgr.requestFocus();
                        WriteActivity.this.bnS();
                    } else if (aVar.code == 53) {
                        if (WriteActivity.this.hgr.hasFocus()) {
                            WriteActivity.this.glP.requestFocus();
                            WriteActivity.this.glP.setSelection(WriteActivity.this.glP.getText().toString().length());
                        }
                        WriteActivity.this.hgr.setVisibility(8);
                        WriteActivity.this.bnS();
                    } else if (aVar.code == 55 && aVar.data != null && (aVar.data instanceof Boolean)) {
                        WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                    }
                }
            }
        };
        this.aCS.setActionListener(16, bVar);
        this.aCS.setActionListener(14, bVar);
        this.aCS.setActionListener(24, bVar);
        this.aCS.setActionListener(3, bVar);
        this.aCS.setActionListener(10, bVar);
        this.aCS.setActionListener(11, bVar);
        this.aCS.setActionListener(12, bVar);
        this.aCS.setActionListener(13, bVar);
        this.aCS.setActionListener(15, bVar);
        this.aCS.setActionListener(18, bVar);
        this.aCS.setActionListener(20, bVar);
        this.aCS.setActionListener(25, bVar);
        this.aCS.setActionListener(27, bVar);
        this.aCS.setActionListener(29, bVar);
        this.aCS.setActionListener(43, bVar);
        this.aCS.setActionListener(45, bVar);
        this.aCS.setActionListener(53, bVar);
        this.aCS.setActionListener(48, bVar);
        this.aCS.setActionListener(46, bVar);
        this.aCS.setActionListener(49, bVar);
        this.aCS.setActionListener(47, bVar);
        this.aCS.setActionListener(55, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vj(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ej() {
        if (this.aEv.abo()) {
            if (this.aEv.bsI()) {
                b(2, true, com.baidu.tieba.tbadkCore.location.c.bsE().getLocationData().bsA());
                return;
            }
            b(1, true, null);
            this.aEv.bsG();
            return;
        }
        b(0, true, null);
    }

    protected void bnK() {
        if (this.aEw != null) {
            this.aEw.cancelLoadData();
        }
        if (this.hgs != null) {
            this.hgs.cancelLoadData();
        }
        if (this.aEv != null) {
            this.aEv.cancelLoadData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        bDc();
        TiebaPrepareImageService.StopService();
        bnK();
        bDI();
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.hhm != null) {
            this.hhm.destroy();
        }
        if (this.hhM != null) {
            this.hhM.ahf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDe() {
        if (this.mData != null && this.mData.getType() == 2 && this.hhi) {
            finish();
        } else if (this.mData == null) {
            finish();
        } else {
            this.mData.setTitle(bDr().getText().toString());
            this.mData.setContent(bDq().getText().toString());
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
            if (this.glR != null && this.glR.isShowing()) {
                com.baidu.adp.lib.g.g.a(this.glR, getPageContext().getPageActivity());
                return true;
            } else if (this.aCS.DI()) {
                this.aCS.Ca();
                return true;
            } else {
                bnK();
                bDe();
                return true;
            }
        }
        if (i == 67 && (text = bDq().getText()) != null) {
            int selectionStart = bDq().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bDq().onKeyDown(67, this.cKg);
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
        getLayoutMode().u(this.mParent);
        getLayoutMode().u(this.hhC);
        if (this.hhA != null && i == 1) {
            this.hhA.setBorderColor(ak.getColor(d.C0126d.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ak.c(this.mPost, d.C0126d.cp_link_tip_a, 1);
        bCZ();
        ak.j(this.hhq, d.C0126d.cp_bg_line_d);
        ak.j(this.glM, d.C0126d.cp_bg_line_c);
        ak.j(this.hhr, d.C0126d.cp_bg_line_c);
        ak.j(bDr(), d.C0126d.cp_bg_line_d);
        ak.c(this.fjt, d.f.icon_edit_close_n);
        if (TextUtils.isEmpty(this.eIH)) {
            ak.j(bDq(), d.C0126d.cp_bg_line_d);
        }
        bnS();
        this.aCS.onChangeSkinType(i);
        if (this.hgG != null) {
            this.hgG.wY();
        }
        ak.h(this.mName, d.C0126d.cp_cont_b);
        bDf();
        bDg();
        if (this.hgO != null) {
            this.hgO.c(bDr(), bDq());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDf() {
        if (this.glL.hasFocus()) {
            this.glL.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        } else {
            this.glL.setHintTextColor(ak.getColor(d.C0126d.cp_cont_d));
        }
        if (this.glP.hasFocus()) {
            this.glP.setHintTextColor(ak.getColor(d.C0126d.cp_cont_e));
        } else {
            this.glP.setHintTextColor(ak.getColor(d.C0126d.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDg() {
        if (this.glL != null && this.glL.getText() != null && this.glL.getText().toString() != null && this.glL.getPaint() != null) {
            if (this.glL.getText().toString().length() == 0) {
                this.glL.getPaint().setFakeBoldText(false);
            } else if (this.glL.getText().toString().length() > 0) {
                this.glL.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        boolean z = true;
        this.aNc = new com.baidu.tbadk.core.view.a(getPageContext());
        this.hgI = this.mData.getType() == 4 || 5 == this.mData.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(d.i.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.asg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setmBackImageViewBg(d.f.icon_topbar_close, d.f.icon_topbar_close);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ak.h(this.mName, d.C0126d.cp_cont_b);
        this.hhg = (TextView) findViewById(d.g.btn_image_problem);
        bDi();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mPost.getLayoutParams();
        layoutParams.rightMargin = l.e(getPageContext().getPageActivity(), d.e.ds14);
        this.mPost.setLayoutParams(layoutParams);
        this.mPost.setOnFocusChangeListener(this.glJ);
        this.hgH = (ScrollView) findViewById(d.g.write_scrollview);
        this.hgH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.glP != null) {
                        l.b(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.glP);
                    }
                    if (WriteActivity.this.aCS != null) {
                        WriteActivity.this.aCS.Ca();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.hhe = (FeedBackTopListView) findViewById(d.g.feedback_top_list);
        this.hhf = findViewById(d.g.feedback_divider);
        this.mParent = (RelativeLayout) findViewById(d.g.parent);
        this.hgq = (LinearLayout) findViewById(d.g.tool_view);
        this.hgq.setContentDescription("..");
        this.hgr = (LinearLayout) findViewById(d.g.title_view);
        this.glM = findViewById(d.g.interval_view);
        this.hhH = findViewById(d.g.hot_topic_fourm_view);
        this.hhI = findViewById(d.g.hot_topic_divider);
        this.hgK = (TextView) findViewById(d.g.hot_topic_title_edt);
        this.hhJ = (TextView) findViewById(d.g.change_one_tv);
        bnR();
        if (this.hgI) {
            this.hgH.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            bDA();
        } else {
            this.hhm = new g(getPageContext(), this.mRootView);
            g gVar = this.hhm;
            if (this.mData.getType() != 0 && this.mData.getType() != 9) {
                z = false;
            }
            gVar.nq(z);
        }
        bnT();
        if (this.hhb || this.hgp) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().ajJ) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(d.g.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(d.g.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.glO = (LinearLayout) findViewById(d.g.post_content_container);
        this.glO.setDrawingCacheEnabled(false);
        this.glO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                view2.requestFocus();
                WriteActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.glP.requestFocus();
            }
        });
        this.fjq = (LinearLayout) findViewById(d.g.layout_voice_play);
        this.fjr = (PlayVoiceBntNew) findViewById(d.g.btn_play_voice);
        this.fjt = (ImageView) findViewById(d.g.iv_delete_voice);
        this.fjt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                WriteActivity.this.aYd();
            }
        });
        this.asg.setOnFocusChangeListener(this.glJ);
        this.asg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                WriteActivity.this.bnK();
                WriteActivity.this.bDe();
            }
        });
        this.hhg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                WriteActivity.this.sendMessage(new CustomMessage(2002001, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        bDl();
        i(bDJ());
        bDn();
        bDh();
        bDF();
        bDH();
        bCZ();
        bDm();
        bnQ();
        bDt();
        if (this.mData.getType() == 4 && this.glT != null && this.hgt != null) {
            this.glT.setVisibility(8);
            this.hgt.setVisibility(8);
        }
        bnS();
        bDD();
    }

    private void bDh() {
        String str;
        String str2;
        if (this.mData != null) {
            switch (this.mData.getType()) {
                case 0:
                case 9:
                    if (this.hhb || this.hgp) {
                        if (this.hhc) {
                            this.mName.setText(d.k.feedback_vcode);
                        } else {
                            this.mName.setText(d.k.feedback);
                        }
                    } else if (this.gLv != null && this.gLv.equals("1")) {
                        this.mName.setText(d.k.post_to_home_page);
                    } else if (this.gLv != null && this.gLv.equals("2")) {
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
                    this.glL.setVisibility(0);
                    this.glP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(d.k.send_reply);
                    this.glP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.glL.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(d.k.publish_photo_live);
                    this.glP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(d.k.update_photo_live_tip, Integer.valueOf(this.mData.getFloorNum() + 1)));
                    this.hhr.setVisibility(8);
                    return;
                case 7:
                    this.glL.setVisibility(0);
                    this.glP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(d.k.post_drift_bottle);
                    return;
            }
        }
    }

    private void bDi() {
        if (this.mData.getType() == 7) {
            this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.throw_bottle));
            return;
        }
        this.mPost = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(d.k.send_post));
    }

    private void bDj() {
        if (this.mData != null && this.mData.getType() == 0 && this.mData.getType() == 9 && !this.hhb && !this.hgp && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String d = an.d(this.mPostTopicData.getTitleTopic(), 31, (String) null);
            if (!StringUtils.isNull(d) && bDr() != null) {
                bDr().setText(d);
                bDr().setSelection(d.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.fjq.setVisibility(0);
            this.fjr.setVoiceModel(voiceModel);
            this.fjr.btf();
            bnS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYd() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.aJ(com.baidu.tbadk.core.voice.a.eR(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.fjq.setVisibility(8);
        this.fjr.aza();
        this.fjr.setVoiceModel(null);
        com.baidu.tbadk.editortools.k eH = this.aCS.eH(6);
        if (eH != null && eH.aCM != null) {
            eH.aCM.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        bnS();
    }

    private void bDk() {
        this.hgB = null;
        this.hgD = -1;
        this.hgF = -1;
        x kk = w.aqF().kk(1);
        if (kk != null) {
            this.hgB = kk.daa;
            this.hgD = getIntent().getIntExtra("category_id", -1);
            if (this.hgB != null && !this.hgB.isEmpty() && this.hgD >= 0) {
                this.hgC = new v();
                this.hgC.cZW = 0;
                this.hgC.name = getPageContext().getResources().getString(d.k.category_auto);
                this.hgF = this.hgC.cZW;
                this.hgE = this.hgC.name;
                for (v vVar : this.hgB) {
                    if (vVar.cZW == this.hgD) {
                        this.hgF = vVar.cZW;
                        this.hgE = vVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void bDl() {
        if (this.hgB != null && !this.hgB.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(d.g.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(d.g.interval_view_cate).setVisibility(0);
            this.hgG = (PostCategoryView) linearLayout.findViewById(d.g.category_selected);
            this.hgG.setText(this.hgE);
            this.hgG.setCategoryContainerData(this.hgB, this.hgC, this.hgF);
            this.hgG.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.17
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view2, com.baidu.tieba.frs.ar arVar) {
                    if (arVar != null) {
                        WriteActivity.this.hgG.setText(arVar.name);
                        WriteActivity.this.mData.setCategoryTo(arVar.cZW);
                        WriteActivity.this.hgF = arVar.cZW;
                        WriteActivity.this.hgG.bCN();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    WriteActivity.this.hgG.bCM();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bDr());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bDq());
                }
            });
        }
    }

    private void bDD() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.hgW = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.hgW.setTitle(d.k.no_disturb_start_time);
        this.hgW.setButton(-1, getPageContext().getString(d.k.alert_yes_button), this.hgW);
        this.hgW.setButton(-2, getPageContext().getString(d.k.cancel), this.hgW);
        return this.hgW;
    }

    private void bDm() {
        this.hgx = (RelativeLayout) findViewById(d.g.addition_container);
        this.hgy = (TextView) findViewById(d.g.addition_create_time);
        this.hgz = (TextView) findViewById(d.g.addition_last_time);
        this.hgA = (TextView) findViewById(d.g.addition_last_content);
        if (this.hgw != null) {
            this.hgx.setVisibility(0);
            this.hgy.setText(getPageContext().getString(d.k.write_addition_create) + an.s(this.hgw.getCreateTime() * 1000));
            if (this.hgw.getAlreadyCount() == 0) {
                this.hgz.setVisibility(8);
            } else {
                this.hgz.setText(getPageContext().getString(d.k.write_addition_last) + an.s(this.hgw.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.hgw.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.hgA.setText(lastAdditionContent);
            } else {
                this.hgA.setVisibility(8);
            }
            bDq().setHint(String.format(getPageContext().getString(d.k.write_addition_hint), Integer.valueOf(this.hgw.getAlreadyCount()), Integer.valueOf(this.hgw.getTotalCount())));
            this.mName.setText(d.k.write_addition_title);
            return;
        }
        this.hgx.setVisibility(8);
    }

    private void bnQ() {
        this.glT = findViewById(d.g.post_prefix_layout);
        if (this.hhM == null) {
            this.hhM = new com.baidu.tieba.d.c(getPageContext(), this.glT);
            this.hhM.jd(d.f.bg_tip_blue_up_left);
            this.hhM.jc(16);
            this.hhM.eF(true);
            this.hhM.B(true);
            this.hhM.jg(l.e(getActivity(), d.e.ds32));
        }
        this.glQ = (TextView) findViewById(d.g.post_prefix);
        this.hgt = findViewById(d.g.prefix_divider);
        this.glS = (ImageView) findViewById(d.g.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.glT.setVisibility(0);
            this.hhM.h(getString(d.k.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.glt = 0;
            this.glT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.log(new al("c13013").ac(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).f("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.glQ.setVisibility(0);
                    WriteActivity.this.glT.setSelected(true);
                    ak.c(WriteActivity.this.glS, d.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.glR, view2, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aCS.Ca();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.glL);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.glP);
                }
            });
            this.glQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.log(new al("c13013").ac(ImageViewerConfig.FORUM_ID, WriteActivity.this.mData.getForumId()).f("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.glQ.setSelected(true);
                    ak.c(WriteActivity.this.glS, d.f.icon_arrow_gray_up);
                    com.baidu.adp.lib.g.g.showPopupWindowAsDropDown(WriteActivity.this.glR, view2, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.aCS.Ca();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bDr());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bDq());
                }
            });
            this.glR = new com.baidu.tieba.write.d(getPageContext().getPageActivity());
            this.glR.a(this);
            this.glR.setMaxHeight(l.e(getActivity(), d.e.ds510));
            this.glR.setOutsideTouchable(true);
            this.glR.setFocusable(true);
            this.glR.setOnDismissListener(this);
            this.glR.setBackgroundDrawable(ak.getDrawable(d.C0126d.cp_bg_line_d));
            int color = ak.getColor(d.C0126d.cp_cont_b);
            ak.getColor(d.C0126d.cp_cont_c);
            ak.i(this.glQ, d.C0126d.cp_bg_line_d);
            ak.c(this.glS, d.f.icon_arrow_gray_down);
            this.glQ.setTextColor(color);
            this.hgu.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.hgu.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.nl(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.nl(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.glR.addView(writePrefixItemLayout);
            }
            this.glR.setCurrentIndex(0);
            this.glQ.setText(prefixs.get(0));
            vh(0);
            return;
        }
        this.glT.setVisibility(8);
    }

    private void bDE() {
        if (this.hhb && this.mData != null) {
            this.hhe.setVisibility(0);
            this.hhf.setVisibility(0);
            this.hgs = new FeedBackModel(getPageContext());
            this.hgs.uU(this.mData.getForumName());
            this.hgs.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void f(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.hhe.setVisibility(8);
                        WriteActivity.this.hhf.setVisibility(8);
                        WriteActivity.this.showToast(d.k.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.hhe.setVisibility(8);
                        WriteActivity.this.hhf.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.hhe.a(feedBackModel.bCP(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void bDn() {
        this.mPost.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.adp.lib.util.j.gP()) {
                    WriteActivity.this.showToast(d.k.neterror);
                }
                if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                    if (WriteActivity.this.hgO.a(WriteActivity.this.glL, WriteActivity.this.glP)) {
                        WriteActivity.this.showToast(WriteActivity.this.hgO.bAY());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bDr());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.bDq());
                    WriteActivity.this.aCS.Ca();
                    if (WriteActivity.this.mData.getType() != 7) {
                        if (WriteActivity.this.hhb) {
                            WriteActivity.this.bDw();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            al alVar = new al("c12102");
                            alVar.r("obj_type", StringUtils.isNull(WriteActivity.this.mData.getForumName()) ? 1 : 2);
                            TiebaStatic.log(alVar);
                            WriteActivity.this.bDx();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.bDw();
                    }
                    TiebaStatic.log(new al("c12262").ac("obj_locate", WriteActivity.this.gLv));
                }
            }
        });
    }

    protected void bDF() {
        this.hhh = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hhh.dc(getPageContext().getString(d.k.is_save_draft)).ar(false).a(getPageContext().getString(d.k.save), new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                WriteActivity.this.mData.setTitle(WriteActivity.this.bDr().getText().toString());
                WriteActivity.this.mData.setContent(WriteActivity.this.bDq().getText().toString());
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
        this.hhh.b(getPageContext());
    }

    protected void bnR() {
        this.hhd = (HeadImageView) findViewById(d.g.user_head_portrait);
        this.hhd.setIsRound(true);
        this.hhd.setDrawBorder(false);
        this.hhd.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String dU = o.dU(currentPortrait);
            this.hhd.setUrl(dU);
            this.hhd.startLoad(dU, 12, false);
        }
        if (this.mData.isUserFeedback()) {
            this.hhd.setVisibility(0);
        }
        this.glL = (EditText) findViewById(d.g.post_title);
        this.glL.setOnClickListener(this.hgS);
        this.glL.setOnFocusChangeListener(this.glJ);
        if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
            if (this.mData.getTitle() != null) {
                this.glL.setText(this.mData.getTitle());
                this.glL.setSelection(this.mData.getTitle().length());
            } else if (this.hhc) {
                this.glL.setText(getResources().getString(d.k.vcode_feed_back_title));
            }
        } else if (this.mData.getType() == 1 || this.mData.getType() != 2) {
        }
        this.glL.addTextChangedListener(this.hgU);
        if (!this.mData.getHaveDraft()) {
            bDj();
            this.hhG = true;
        }
        if (this.mData.isUserFeedback()) {
            this.glL.setHint(getResources().getString(d.k.feedback_title_hint));
        } else {
            this.glL.setHint(getResources().getString(d.k.post_title_hint));
        }
    }

    private TextWatcher bDG() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            private int hhQ;
            private EditText mEditText = null;
            private TextView mTextView = null;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.bnS();
                if (WriteActivity.this.hgI) {
                    this.hhQ = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.hhQ);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.hgI || !WriteActivity.this.hhy) {
                    if (WriteActivity.this.hgI) {
                        if (this.mEditText != WriteActivity.this.hhp || this.mTextView != WriteActivity.this.hhv) {
                            this.mEditText = WriteActivity.this.hhp;
                            this.mTextView = WriteActivity.this.hhv;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.hht || this.mTextView != WriteActivity.this.hhu) {
                    this.mEditText = WriteActivity.this.hht;
                    this.mTextView = WriteActivity.this.hhu;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.hgI && this.hhy) {
            if (this.hhw != null) {
                this.hht.removeTextChangedListener(this.hhw);
            }
            this.hhw = textWatcher;
        } else if (this.hgI) {
            if (this.hhx != null) {
                this.hhp.removeTextChangedListener(this.hhx);
            }
            this.hhx = textWatcher;
        }
        return textWatcher;
    }

    private long l(EditText editText) {
        if (editText == this.hhp) {
            return 233L;
        }
        if (editText != this.hht) {
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
                    textView.setTextColor(ak.getColor(d.C0126d.common_color_10159));
                } else {
                    textView.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
                }
            } else if (m < 0) {
                if (m < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(ak.getColor(d.C0126d.common_color_10159));
            } else {
                textView.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long m(EditText editText) {
        return com.baidu.tieba.write.b.a.l(editText.getText().toString().trim());
    }

    protected void bnT() {
        this.glP = (EditText) findViewById(d.g.post_content);
        this.glP.setDrawingCacheEnabled(false);
        this.glP.setOnClickListener(this.hgS);
        if (this.mData.getContent() != null && this.mData.getContent().length() > 0) {
            SpannableString R = TbFaceManager.EZ().R(getPageContext().getPageActivity(), this.mData.getContent());
            this.glP.setText(R);
            this.glP.setSelection(R.length());
        } else if (this.mData.getType() == 2) {
            if (this.hhi) {
                if (this.hhj != null && this.hhj.length() > 0) {
                    this.glP.setText(getPageContext().getPageActivity().getString(d.k.reply_sub_floor, new Object[]{this.hhj}));
                    this.glP.setSelection(this.glP.getText().length());
                }
            } else if (this.mData.getFloorNum() > 0) {
                String format = String.format(getPageContext().getString(d.k.reply_x_floor), Integer.valueOf(this.mData.getFloorNum()));
                this.glP.setText(format);
                this.glP.setSelection(format.length());
            }
        }
        this.glP.setOnFocusChangeListener(this.glJ);
        this.glP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view2.requestFocus();
                    WriteActivity.this.aCS.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.glP.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.glP.addTextChangedListener(this.hgV);
        if (this.mData.getType() == 0) {
            this.hhL = true;
        } else {
            nx(true);
            this.hhL = false;
        }
        if (this.mData.isUserFeedback()) {
            this.glP.setHint(d.k.write_input_content);
        } else {
            this.glP.setHint(d.k.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void nx(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.hgI) {
            bDq().setPadding(0, 0, 0, 0);
            bDq().setBackgroundDrawable(null);
            ak.j(bDq(), d.C0126d.cp_bg_line_d);
            if (!TextUtils.isEmpty(this.eIH) && this.hgw == null) {
                com.baidu.adp.lib.f.c.fp().a(this.eIH, 19, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass29) aVar, str, i);
                        if (aVar != null && aVar.km() != null && aVar.kq() != null) {
                            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.km(), aVar.km().getNinePatchChunk(), aVar.kq(), null);
                            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                                ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                            }
                            WriteActivity.this.bDq().setBackgroundDrawable(ninePatchDrawable);
                            if (z) {
                                com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this, WriteActivity.this.bDq(), true, WriteActivity.this.fqk);
                            }
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bDp() {
        int i = 5000;
        if (this.hgw != null) {
            i = 1000;
        }
        return bDq().getText() != null && bDq().getText().length() >= i;
    }

    private void gh(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.hgn)) {
                this.hgn = "";
                bDq().requestFocus();
                if (bDq().getText() != null && bDq().getText().length() + str.length() > 5000) {
                    showToast(d.k.over_limit_tip);
                    return;
                } else {
                    i = bDq().getSelectionStart();
                    editable = bDq().getText();
                }
            } else if ("from_title".equals(this.hgn)) {
                this.hgn = "";
                bDr().requestFocus();
                if (bDr().getText() != null && bDr().getText().length() + str.length() > 31) {
                    showToast(d.k.over_limit_tip);
                    return;
                } else {
                    i = bDr().getSelectionStart();
                    editable = bDr().getText();
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
    public void nv(boolean z) {
        if (!com.baidu.tbadk.plugins.b.a(getPageContext(), z, false)) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.mData != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L), this.mData.getFirstDir(), this.mData.getSecondDir());
            }
            sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
        }
    }

    protected void d(n nVar) {
        if (((ImageSpan[]) bDq().getText().getSpans(0, bDq().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.hgv == null) {
                this.hgv = Toast.makeText(getPageContext().getPageActivity(), d.k.too_many_face, 0);
            }
            this.hgv.show();
            return;
        }
        String name = nVar.getName();
        final EmotionGroupType yC = nVar.yC();
        if (name != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
            com.baidu.adp.lib.f.c.fp().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    super.onLoaded((AnonymousClass31) aVar, str, i);
                    if (aVar != null) {
                        WriteActivity.this.a(spannableStringBuilder, WriteActivity.this.bDq().getSelectionStart(), aVar, yC);
                    }
                }
            }, 0, 0, getUniqueId(), null, name, false, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (spannableStringBuilder != null && bDq() != null && bDq().getText() != null) {
            Bitmap km = aVar.km();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(km);
            int width = km.getWidth();
            if (emotionGroupType == EmotionGroupType.USER_COLLECT || emotionGroupType == EmotionGroupType.BIG_EMOTION) {
                bitmapDrawable.setBounds(0, 0, width, km.getHeight());
            } else {
                if (emotionGroupType == EmotionGroupType.LOCAL) {
                    width = (int) (width * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width, width);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.d(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                int selectionStart = bDq().getSelectionStart() - 1;
                if (bDq().getText().length() > 1 && selectionStart >= 0 && bDq().getText().charAt(selectionStart) != '\n') {
                    SpannableString spannableString = new SpannableString("\u0000\n");
                    bDq().getText().insert(bDq().getSelectionStart(), spannableString);
                    i += spannableString.length();
                }
            }
            bDq().getText().insert(i, spannableStringBuilder);
            SpannableString spannableString2 = null;
            if (EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) {
                spannableString2 = new SpannableString("\u0000\n");
                bDq().getText().insert(bDq().getSelectionStart(), spannableString2);
            }
            Editable text = bDq().getText();
            if (text != null) {
                this.hgL.clear();
                this.hgL.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hgL);
                if ((EmotionGroupType.BIG_EMOTION == emotionGroupType || EmotionGroupType.USER_COLLECT == emotionGroupType) && spannableString2 != null && bDq().length() > spannableStringBuilder.length() + i + spannableString2.length()) {
                    bDq().setSelection(spannableString2.length() + spannableStringBuilder.length() + i);
                    return;
                }
                bDq().setSelection(spannableStringBuilder.length() + i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bDq() {
        return this.hgI ? this.hhp : this.glP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText bDr() {
        return this.hgI ? this.hht : this.glL;
    }

    protected void bDs() {
        Editable text;
        if (bDq() != null && (text = bDq().getText()) != null) {
            int selectionStart = bDq().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                bDq().onKeyDown(67, this.cKg);
            }
            bDq().onKeyDown(67, this.cKg);
            int selectionStart2 = bDq().getSelectionStart();
            if (text != null) {
                this.hgL.clear();
                this.hgL.append((CharSequence) text);
                text.clear();
                text.append((CharSequence) this.hgL);
                bDq().setSelection(selectionStart2);
            }
        }
    }

    private void i(Boolean bool) {
        String str = null;
        if (this.mData != null) {
            str = this.mData.getForumName();
        }
        if (getPageContext().getString(d.k.feedback_bar_name).equals(str)) {
            this.hhb = true;
        }
    }

    private void bDH() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void bDI() {
        try {
            if (this.hhh != null) {
                this.hhh.dismiss();
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.aNc.d(null);
        this.aNc.cZ(d.k.sending);
        this.aNc.aI(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.aNc.aI(false);
    }

    private Boolean bDJ() {
        Boolean bool = null;
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                bool = Boolean.valueOf(intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true));
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.aEA = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return bool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnS() {
        if (this.mData != null) {
            String str = "";
            String str2 = "";
            if (bDr() != null) {
                str = bDr().getText().toString();
            }
            if (bDq() != null) {
                str2 = bDq().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.mData.getType() == 0 || this.mData.getType() == 9 || this.mData.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.glt == com.baidu.tbadk.core.util.v.v(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.mData.setIsNoTitle(true);
                        } else if (this.hgr.getVisibility() == 0) {
                            this.mData.setIsNoTitle(false);
                            nw(true);
                            return;
                        }
                    } else if (this.hgr.getVisibility() == 0) {
                        this.mData.setIsNoTitle(false);
                        nw(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.mData.setIsNoTitle(true);
                } else if (this.hgr.getVisibility() == 0) {
                    this.mData.setIsNoTitle(false);
                    nw(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.hgI) {
                    nw(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    nw(true);
                }
            }
            if (this.mData.getType() == 4) {
                nw(o(this.hhp) && n(this.hht));
            } else if (this.mData.getType() == 5) {
                nw(o(this.hhp));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                nw(true);
            } else if (this.mData.getVideoInfo() != null) {
                nw(true);
            } else {
                nw(false);
            }
        }
    }

    public void nw(boolean z) {
        if (z) {
            ak.b(this.mPost, d.C0126d.cp_link_tip_a, d.C0126d.s_navbar_title_color);
            this.mPost.setEnabled(true);
            return;
        }
        ak.c(this.mPost, d.C0126d.cp_cont_d, 1);
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
        this.aEw = new NewWriteModel(this);
        this.aEw.b(this.aEK);
        registerListener(this.hhN);
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.bnK();
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
            this.hhb = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.hhc = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hhi = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hhj = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.aEu = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.hgw = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.mData.setIsAddition(this.hgw != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.hhk = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mData.setTitle(bundle.getString("write_title"));
            this.mData.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.hhK = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.gLv = bundle.getString("KEY_CALL_FROM");
            this.hbp = bundle.getInt(IntentConfig.KEY_ALBUM_THREAD);
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
            this.hhb = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.hhc = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.hhi = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.hhj = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.hgw = (AdditionData) intent.getSerializableExtra("addition_data");
            this.mData.setIsAddition(this.hgw != null);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.hhk = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.mData.setTitle(intent.getStringExtra("write_title"));
            this.mData.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.hhK = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.gLv = intent.getStringExtra("KEY_CALL_FROM");
            this.hbp = intent.getIntExtra(IntentConfig.KEY_ALBUM_THREAD, 0);
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
        this.mData.setIsUserFeedback(this.hhb);
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
        this.eIH = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.mData != null && this.mData.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.mData.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.hgp = true;
        }
        bDk();
        try {
            this.hhz = bDP();
        } catch (Throwable th) {
            this.hhz = null;
        }
    }

    private void bDt() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.glL.setText(com.baidu.tbadk.plugins.b.gT(com.baidu.tbadk.plugins.b.gU(hotTopicBussinessData.mTopicName)));
            this.glL.setMovementMethod(com.baidu.tieba.view.c.bAd());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString gT = com.baidu.tbadk.plugins.b.gT(com.baidu.tbadk.plugins.b.gU(hotTopicBussinessData.mTopicName));
            if (gT != null) {
                this.glL.setText(gT);
            }
            this.hgK.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.t.a
    public void a(WriteData writeData) {
        String str;
        String gU;
        if (writeData != null) {
            if (this.mData != null) {
                this.mData.setHaveDraft(true);
                if (com.baidu.adp.lib.util.k.isEmpty(bDr().getText().toString()) || this.hhG || ((this.hhb || this.hgp) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle()))) {
                    if (com.baidu.adp.lib.util.k.isEmpty(this.mData.getTitle())) {
                        this.mData.setTitle(writeData.getTitle());
                    }
                    if (!com.baidu.tbadk.core.util.v.w(this.mList)) {
                        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.v.c(this.mList, 0);
                        if (hotTopicBussinessData == null) {
                            str = null;
                        } else {
                            str = hotTopicBussinessData.mTopicName;
                        }
                        if (StringUtils.isNull(str)) {
                            gU = this.mData.getTitle();
                        } else {
                            gU = com.baidu.tbadk.plugins.b.gU(str);
                        }
                        SpannableString gT = com.baidu.tbadk.plugins.b.gT(gU);
                        if (gT != null) {
                            bDr().setText(gT);
                            bDr().setSelection(gT.length() > gU.length() ? gU.length() : gT.length());
                        }
                    } else {
                        SpannableString gT2 = com.baidu.tbadk.plugins.b.gT(this.mData.getTitle());
                        if (gT2 != null) {
                            bDr().setText(gT2);
                            bDr().setSelection(this.mData.getTitle().length() > gT2.length() ? gT2.length() : this.mData.getTitle().length());
                        }
                    }
                }
                if (this.mData != null && !this.mData.getHaveDraft()) {
                    bDj();
                }
                if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.copy(writeData.getVideoInfo());
                    this.mData.setVideoInfo(videoInfo);
                    this.aCS.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                }
                if ((com.baidu.adp.lib.util.k.isEmpty(bDq().getText().toString()) || this.hhb || this.hgp) && !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent())) {
                    this.mData.setContent(writeData.getContent());
                    SpannableString a2 = TbFaceManager.EZ().a(getPageContext().getPageActivity(), this.mData.getContent(), this.hgQ);
                    bDq().setText(a2);
                    bDq().setSelection(a2.length());
                    if (this.hgI) {
                        a(this.hhv, this.hhp);
                    }
                }
                if (writeData.getWriteImagesInfo() != null && this.writeImagesInfo.size() == 0) {
                    this.writeImagesInfo = writeData.getWriteImagesInfo();
                    this.mData.setWriteImagesInfo(this.writeImagesInfo);
                    bDO();
                    if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
                        bDz();
                    }
                    ny(false);
                }
                if (writeData.getType() == 4 || writeData.getType() == 5) {
                    bDK();
                }
                bnS();
                int categoryTo = writeData.getCategoryTo();
                if (categoryTo >= 0 && this.hgB != null) {
                    this.hgF = this.hgC.cZW;
                    this.hgE = this.hgC.name;
                    int i = 0;
                    while (true) {
                        if (i == this.hgB.size()) {
                            break;
                        }
                        v vVar = this.hgB.get(i);
                        if (categoryTo != vVar.cZW) {
                            i++;
                        } else {
                            this.hgF = categoryTo;
                            this.hgE = vVar.name;
                            this.mData.setCategoryTo(this.hgF);
                            break;
                        }
                    }
                    if (this.hgG != null) {
                        this.hgG.setText(this.hgE);
                        this.hgG.setCategoryContainerData(this.hgB, this.hgC, this.hgF);
                    }
                }
                this.aCS.Ca();
                return;
            }
            return;
        }
        bDK();
        bDj();
    }

    private void bDK() {
        if ((!this.hgI || this.hho != null) && this.hhn != null) {
            this.hho.c(this.writeImagesInfo);
            aOK();
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
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.hhi);
        if (this.hhb) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.aEu);
        if (this.hgw != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.hgw));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.hhk);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.gLv);
        bundle.putInt(IntentConfig.KEY_ALBUM_THREAD, this.hbp);
        bundle.putInt("private_thread", this.privateThread);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = bDq().getEditableText().toString();
        if (obj != null) {
            bDq().setText(TbFaceManager.EZ().a(getPageContext().getPageActivity(), obj, this.hgQ));
            bDq().setSelection(bDq().getText().length());
        }
    }

    private String bDu() {
        return (bDq() == null || bDq().getText() == null) ? "" : bDq().getText().toString();
    }

    private String bDv() {
        if (this.mData == null || bDr() == null || bDr().getVisibility() != 0 || bDr().getText() == null) {
            return "";
        }
        String obj = bDr().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.v.v(this.mPrefixData.getPrefixs()) > 0 && this.glt != com.baidu.tbadk.core.util.v.v(this.mPrefixData.getPrefixs()) - 1 && this.mData.getType() != 4 && this.glQ != null && this.glQ.getText() != null) {
            this.mData.setPostPrefix(this.glQ.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.mData.getTitle();
        }
        return obj;
    }

    private void uV(String str) {
        if (this.mData != null && this.hgr != null) {
            if (this.hgr.getVisibility() == 0) {
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
    public void bDw() {
        bnK();
        this.mData.setContent(bDu());
        uV(bDv());
        if (this.hhb || this.hgp) {
            String string = getResources().getString(d.k.android_feedback);
            if (TextUtils.isEmpty(this.mData.getTitle()) || !this.mData.getTitle().startsWith(string)) {
                uV(string + this.mData.getTitle());
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
                if (com.baidu.adp.lib.util.j.gP()) {
                    sb.append(com.baidu.adp.lib.util.j.gX());
                } else {
                    sb.append("UNKNOWN");
                }
                sb.append(":");
                sb.append(this.mData.getContent());
                this.mData.setContent(sb.toString());
            }
        }
        if (this.hgD >= 0) {
            this.mData.setCategoryFrom(this.hgD);
        }
        if (this.hgF >= 0) {
            this.mData.setCategoryTo(this.hgF);
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
        this.mData.setHasLocationData(this.aEv != null && this.aEv.abo());
        if (this.writeImagesInfo != null) {
            this.aEw.mv(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.v.w(this.mList) && this.hgJ != null && this.hgJ.mIsGlobalBlock == 0) {
            this.mData.setForumId(String.valueOf(this.hgJ.mForumId));
            this.mData.setForumName(this.hgJ.mForumName);
        }
        this.aEw.setWriteData(this.mData);
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000\n", ""));
        this.mData.setContent(this.mData.getContent().replaceAll("\u0000", ""));
        this.mData.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.aEw.getWriteData().setVoice(this.mVoiceModel.getId());
                this.aEw.getWriteData().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.aEw.getWriteData().setVoice(null);
                this.aEw.getWriteData().setVoiceDuringTime(-1);
            }
        } else {
            this.aEw.getWriteData().setVoice(null);
            this.aEw.getWriteData().setVoiceDuringTime(-1);
        }
        if (!this.aEw.bth()) {
            showToast(d.k.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.gP()) {
            showToast(d.k.neterror);
        } else {
            showLoadingDialog(getPageContext().getString(d.k.sending), this.mDialogCancelListener);
            this.aEw.startPostWrite();
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
            if (this.hgw != null) {
                i2 = this.hgw.getTotalCount();
                i = this.hgw.getAlreadyCount() + 1;
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
                if (this.glL == getCurrentFocus()) {
                    bDq().clearFocus();
                    this.glL.requestFocus();
                    if (this.aCS != null) {
                        this.aCS.Ca();
                    }
                    ShowSoftKeyPadDelay(this.glL);
                } else {
                    bDq().requestFocus();
                    if (this.aCS != null) {
                        this.aCS.Ca();
                    }
                    ShowSoftKeyPadDelay(this.glP);
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
                            bDq().getText().insert(bDq().getSelectionStart(), sb.toString());
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
                                bDN();
                            } else {
                                ag(intent);
                            }
                        } else if (intExtra == 1) {
                            ah(intent);
                        } else {
                            ae(intent);
                            com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.33
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.b(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        if (this.hhL) {
                            nx(true);
                            this.hhL = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.hgI) {
                        A(intent);
                        bnS();
                        return;
                    }
                    af(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.mData.setVideoInfo(videoInfo);
                        this.aCS.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.aCS.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.aCS.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    bnS();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2010040));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.hgo) {
                                sb2.append(com.baidu.tbadk.plugins.b.aMz);
                                this.hgo = false;
                            }
                            sb2.append(stringExtra);
                            gh(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.v.w(this.mList) && !com.baidu.tbadk.core.util.v.w(this.mList) && intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0) < this.mList.size()) {
                    this.hgJ = this.mList.get(intent.getIntExtra(IntentConfig.HOT_TOPIC_CHANGE_FOURM, 0));
                    a(this.hgJ);
                }
            }
        } else if (i2 == 0) {
            if (this.aCS != null && !this.aCS.DI()) {
                this.glP.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.aCS.Ca();
            }
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN /* 12001 */:
                    Em();
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null && intent.hasExtra(AlbumActivityConfig.LAST_ALBUM_ID)) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra(AlbumActivityConfig.LAST_ALBUM_ID));
                    }
                    bDM();
                    if (this.hhL) {
                        nx(true);
                        this.hhL = false;
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_LOGIN /* 12004 */:
                    if (this.glL == getCurrentFocus()) {
                        bDq().clearFocus();
                        this.glL.requestFocus();
                        if (this.aCS != null) {
                            this.aCS.Ca();
                        }
                        ShowSoftKeyPadDelay(this.glL);
                        return;
                    }
                    bDq().requestFocus();
                    if (this.aCS != null) {
                        this.aCS.Ca();
                    }
                    ShowSoftKeyPadDelay(this.glP);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_REG /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.hgO.uB(postWriteCallBackData.getErrorString());
                        this.hgO.ax(postWriteCallBackData.getSensitiveWords());
                        this.hgO.b(this.glL, this.glP);
                        return;
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                default:
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.aEu = String.valueOf(System.currentTimeMillis());
                    aj.a(getPageContext(), this.aEu);
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER /* 12012 */:
                    bDM();
                    return;
                case 25004:
                    if ("from_title".equals(this.hgn)) {
                        bDr().requestFocus();
                        return;
                    } else if ("from_content".equals(this.hgn)) {
                        bDq().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDx() {
        if ("1".equals(this.gLv)) {
            this.mData.setCanNoForum(true);
            this.mData.setTransmitForumData("[]");
        } else if ("2".equals(this.gLv)) {
            this.mData.setCanNoForum(false);
        }
        bDy();
        this.mData.setPrivacy(this.isPrivacy);
        this.mData.setCallFrom(this.gLv);
        if (this.mData.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        bDw();
    }

    private void bDy() {
        if (this.aCS != null) {
            this.aCS.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void bDL() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void bDM() {
        if (this.hgI) {
            this.hho.c(this.writeImagesInfo);
            aOK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOK() {
        this.hho.notifyDataSetChanged();
        this.hhn.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.35
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.hho.notifyDataSetChanged();
                WriteActivity.this.hhn.invalidateViews();
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
        bnS();
    }

    private void ae(Intent intent) {
        if (this.hgI) {
            af(intent);
            bDM();
        } else {
            ai(intent);
        }
        bnS();
    }

    private void af(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            bDM();
            ny(true);
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

    private void bDN() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void ah(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.hhl.parseJson(stringExtra);
            this.hhl.updateQuality();
            if (this.hhl.getChosedFiles() != null && this.hhl.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.hhl.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.hhl.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, bDr());
        HidenSoftKeyPad(this.mInputManager, bDq());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
    }

    private void ai(Intent intent) {
        c(intent, true);
    }

    private void z(Intent intent) {
        this.aEu = intent.getStringExtra(AlbumActivityConfig.CAMERA_PHOTO_NAME);
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + TbConfig.LOCAL_CAMERA_DIR + "/" + this.aEu;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.af(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.ah(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    com.baidu.tbadk.core.util.k.a(TbConfig.LOCAL_CAMERA_DIR, this.aEu, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            bDO();
            bDz();
        }
        ny(true);
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
                bDO();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    bDz();
                }
            }
            ny(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDO() {
        if (this.aCS.eH(10) != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() != 0) {
        }
    }

    private void Em() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.36
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                com.baidu.tbadk.core.util.k.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.aEu));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void ny(boolean z) {
        String forumId = this.mData == null ? "" : this.mData.getForumId();
        if (this.hhm != null) {
            this.hhm.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.cXg == null) {
            this.cXg = VoiceManager.instance();
        }
        return this.cXg;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void apC() {
        this.cXg = getVoiceManager();
        this.cXg.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.tt(postWriteCallBackData.getErrorCode())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.cYe) != null) {
                    TiebaStatic.log(new al("c12534").r("obj_locate", ar.a.ajb));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(d.k.sand_fail);
                }
                showToast(errorString2);
            } else if (this.mData.getType() != 7) {
                if (this.hgw == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.e(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                q(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, boolean z, String str) {
        this.aEB = i;
        if (this.aCS != null) {
            this.aCS.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void bDz() {
        if (!this.hgI) {
            if (this.aCS != null) {
                this.aCS.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.aCS.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.mData == null ? "" : this.mData.getForumId();
            if (this.hhm != null) {
                this.hhm.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bF(boolean z) {
        if (this.aCS != null) {
            this.aCS.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void vh(int i) {
        if (i < this.hgu.size()) {
            for (int i2 = 0; i2 < this.hgu.size(); i2++) {
                this.hgu.get(i2).nm(false);
            }
            this.hgu.get(i).nm(true);
        }
    }

    @Override // com.baidu.tieba.write.d.a
    public void sO(int i) {
        if (i == com.baidu.tbadk.core.util.v.v(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new al("c13014").r("obj_type", 1));
        } else {
            TiebaStatic.log(new al("c13014").r("obj_type", 2));
        }
        this.glt = i;
        this.glR.setCurrentIndex(i);
        vh(i);
        this.glQ.setText(this.mPrefixData.getPrefixs().get(i));
        bnS();
        com.baidu.adp.lib.g.g.a(this.glR, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.glT.setSelected(false);
        ak.c(this.glS, d.f.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.glP);
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

    @Override // android.app.Activity, com.baidu.d.a.a.InterfaceC0045a
    @SuppressLint({"NewApi"})
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0) {
            Eh();
        } else if (i == 1) {
            ArrayMap<String, Boolean> a2 = ab.a(strArr, iArr);
            if (ab.aD(getApplicationContext())) {
                aj.a(getPageContext(), this.aEu);
            } else {
                showToast(d.k.system_permission_prompt_camera);
            }
            if (a2.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a2.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.k.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        this.hgN = z;
        if (this.hhE && System.currentTimeMillis() - this.hhF < 800) {
            l.b(getPageContext().getPageActivity(), getCurrentFocus());
            this.hhE = false;
        }
        if (this.hgM != null && !z) {
            this.hgM.akW();
        }
        if (this.hgP != null && !z) {
            bDc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uW(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.hhB != null) {
            uX(str);
            this.hhB.dismiss();
        }
    }

    private void ci(Context context) {
        hhD = l.ah(context);
    }

    private void uX(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(d.k.album_beyond_max_choose), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.hhE = true;
        bDO();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            bDz();
        }
        ny(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4240=4] */
    private static Bitmap e(String str, float f) {
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

    private File bDP() {
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

    private void bDQ() {
        if (this.hhz != null && this.mData.getType() == 0 && this.mData.getType() == 9) {
            ci(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(d.i.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (WriteActivity.this.hhz != null) {
                        WriteActivity.this.uW(WriteActivity.this.hhz.getAbsolutePath());
                    }
                }
            });
            this.hhA = (TbImageView) this.mBubbleView.findViewById(d.g.rec_img_view);
            this.hhC = (LinearLayout) this.mBubbleView.findViewById(d.g.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getString("write_rec_pic_path", "").equalsIgnoreCase(this.hhz.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putString("write_rec_pic_path", this.hhz.getAbsolutePath());
                Bitmap e = e(this.hhz.getAbsolutePath(), getResources().getDimensionPixelSize(d.e.ds160));
                if (e != null) {
                    this.hhA.setImageBitmap(e);
                    this.hhA.setDrawBorder(true);
                    this.hhA.setBorderWidth(2);
                    this.hhA.setBorderColor(ak.getColor(d.C0126d.common_color_10264));
                    this.hhB = new Dialog(getActivity(), d.l.bubble_dialog);
                    this.hhB.setCanceledOnTouchOutside(true);
                    this.hhB.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.hhE) {
                                l.b(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.hhF = System.currentTimeMillis();
                            }
                        }
                    });
                    this.hhB.setContentView(this.mBubbleView);
                    this.hhB.show();
                    Window window = this.hhB.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(d.e.ds28);
                    attributes.y = (hhD / 18) + getResources().getDimensionPixelSize(d.e.ds12);
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
        if (this.hgN && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.hgo = false;
            this.hgn = "";
            if ("from_content".equals(str)) {
                this.hgn = "from_content";
            } else if ("from_title".equals(str)) {
                this.hgn = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.gS(String.valueOf(charSequence.charAt(i)))) {
                nv(false);
            }
        }
    }

    public void bjW() {
        if (this.hhb || !com.baidu.tbadk.core.util.v.w(this.mList) || !StringUtils.isNull(this.mData.getTitle())) {
            this.hgr.setVisibility(0);
            this.hgr.requestFocus();
            this.aCS.b(new com.baidu.tbadk.editortools.a(21, 15, null));
            return;
        }
        this.hgr.setVisibility(8);
    }
}
