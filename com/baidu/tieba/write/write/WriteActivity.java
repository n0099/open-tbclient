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
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
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
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.n.a.a;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AddLinkActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.ImageProblemActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.u;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.WriteTipBubbleController;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.message.EvaluateRelevanceItemSelectedMessage;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.SaveDraftDialogView;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.a;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.editortools.m;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.switchs.RepostToDynamicDefaultSwitch;
import com.baidu.tbadk.util.o;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsPublishFineGoodsDialogView;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.tbadkCore.b.a;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.util.MercatorModel;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.y;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.i;
import com.baidu.tieba.write.view.ForumSelectedView;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import com.baidu.tieba.write.view.TitleTipView;
import com.baidu.tieba.write.view.WriteEvaluationHeaderView;
import com.baidu.tieba.write.write.EBusinessProtocolView;
import com.baidu.tieba.write.write.d;
import com.google.gson.Gson;
import com.kwad.sdk.collector.AppStatusRules;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import org.json.JSONArray;
import org.json.JSONObject;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0277a, VoiceManager.c, y.a, i.a {
    private static int ofH = 0;
    private EditorTools fDN;
    private String fFY;
    private LocationModel fFZ;
    List<ab> gOR;
    private boolean isEvaluate;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private String jdb;
    private String jdc;
    private String jdd;
    private VoiceManager jfh;
    private boolean jsH;
    private com.baidu.tbadk.core.dialog.i jsx;
    private SaveDraftDialogView jsy;
    private LinearLayout lPi;
    private PlayVoiceBntNew lPj;
    private ImageView lPl;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private ListView mListView;
    private PostTopicData mPostTopicData;
    public PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private FrsTabInfoData nYG;
    private int ngJ;
    private TextView nhf;
    private com.baidu.tieba.write.i nhg;
    private ImageView nhh;
    private View nhi;
    private WriteTipBubbleController ocT;
    private String oeB;
    private PostCategoryView oeD;
    private HotTopicBussinessData oeG;
    private TextView oeH;
    private com.baidu.tieba.write.editor.b oeJ;
    private g oeL;
    private ForumTabSelectedView oeM;
    private com.baidu.tieba.view.b oeT;
    private LinearLayout oen;
    private LinearLayout oeo;
    private View oer;
    private Toast oet;
    private AdditionData oeu;
    private RelativeLayout oev;
    private TextView oew;
    private TextView oex;
    private TextView oey;
    ab oez;
    private com.baidu.tieba.c.e ofM;
    private b ofN;
    private ForumSelectedView ofO;
    private com.baidu.tbadk.data.j ofP;
    private WriteEvaluationHeaderView ofQ;
    private TextView ofR;
    private View ofS;
    private com.baidu.tieba.write.write.video.a ofT;
    private com.baidu.tieba.write.write.vote.a ofU;
    private RelativeLayout ofV;
    private boolean ofW;
    private SerializableItemInfo ofX;
    private boolean ofY;
    private int ofZ;
    private TitleTipView ofc;
    private View ofe;
    private View ofh;
    private com.baidu.tieba.tbadkCore.writeModel.a ofn;
    private i ofp;
    private Serializable ogd;
    private String oge;
    private d ogg;
    private LinearLayout ogh;
    private ImageView ogi;
    private TextView ogj;
    private List<com.baidu.tieba.j.a> ogk;
    private EBusinessProtocolView ogl;
    private WriteImageGridView ogs;
    private com.baidu.tbadk.editortools.c.a ogt;
    private int privateThread;
    private String oej = "";
    private boolean oek = false;
    protected WriteData ngI = null;
    private boolean oeZ = false;
    private boolean ofa = false;
    private boolean oem = false;
    private boolean ofb = false;
    private InputMethodManager mInputManager = null;
    private EditText nha = null;
    private HeadImageView ofd = null;
    private View nhb = null;
    private LinearLayout nhd = null;
    private SpanGroupEditText oep = null;
    private FeedBackModel oeq = null;
    private FeedBackTopListView ofg = null;
    private ArrayList<WritePrefixItemLayout> oes = new ArrayList<>();
    private String lhT = null;
    private final KeyEvent iRl = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView ofi = null;
    private TextView lPZ = null;
    private TextView mName = null;
    private ImageView ofj = null;
    private final Handler mHandler = new Handler();
    private boolean ofk = false;
    private String ofl = null;
    private RelativeLayout ltF = null;
    public boolean ofm = true;
    public String fGe = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int fGf = 0;
    private int oeA = -1;
    private int oeC = -1;
    private WriteImagesInfo ofo = new WriteImagesInfo();
    private View mRootView = null;
    private GridView ofq = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a ofr = null;
    private ScrollView oeE = null;
    private EditText ofs = null;
    private View oft = null;
    private View ofu = null;
    private View ofv = null;
    private EditText ofw = null;
    private TextView ofx = null;
    private TextView ofy = null;
    private TextWatcher ofz = null;
    private TextWatcher ofA = null;
    private boolean oeF = false;
    private boolean ofB = false;
    private com.baidu.tbadk.core.view.a fOA = null;
    private String mFrom = "write";
    private File ofC = null;
    private TbImageView ofD = null;
    private View ofE = null;
    private Dialog ofF = null;
    private LinearLayout ofG = null;
    private boolean ofI = false;
    private long ofJ = -1000;
    private boolean ofK = false;
    private String jLR = "2";
    private int bMh = 0;
    private boolean canGoods = false;
    private String mTopicId = "";
    private SpannableStringBuilder oeI = new SpannableStringBuilder();
    private boolean ofL = false;
    private boolean bsq = false;
    private final c oeK = new c();
    private boolean oga = true;
    private boolean ogb = false;
    private String ogc = null;
    private final d.a ogf = new d.a() { // from class: com.baidu.tieba.write.write.WriteActivity.1
        @Override // com.baidu.tieba.write.write.d.a
        public void MK(int i) {
            if (WriteActivity.this.oep != null) {
                WriteActivity.this.oep.rz(i);
            }
        }

        @Override // com.baidu.tieba.write.write.d.a
        public void gl(List<u> list) {
            WriteActivity.this.gm(list);
        }
    };
    private boolean ogm = false;
    private boolean ogn = false;
    private final HttpMessageListener ogo = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.lhT)) {
                    WriteActivity.this.lhT = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.zt(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.lhT)) {
                    WriteActivity.this.lhT = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.lhT);
                    WriteActivity.this.zt(true);
                }
            }
        }
    };
    private CustomMessageListener ogp = new CustomMessageListener(2921494) { // from class: com.baidu.tieba.write.write.WriteActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (WriteActivity.this.ngI != null && WriteActivity.this.canGoods) {
                TiebaStatic.log(new aq("c13896").an("obj_locate", 1).dX("fid", WriteActivity.this.ngI.getForumId()).dX("fname", WriteActivity.this.ngI.getForumName()));
            }
        }
    };
    private final CustomMessageListener ogq = new CustomMessageListener(2921505) { // from class: com.baidu.tieba.write.write.WriteActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.data.j jVar;
            if (WriteActivity.this.ofO != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && (jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData()) != null && !StringUtils.isNull(jVar.forumId) && !StringUtils.isNull(jVar.forumName)) {
                WriteActivity.this.a(jVar);
            }
        }
    };
    private TbFaceManager.a oeN = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.45
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan Ed(String str) {
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
    private final AntiHelper.a jgD = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.56
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_WRITE));
        }
    };
    private WriteTipBubbleController.a ogr = new WriteTipBubbleController.a() { // from class: com.baidu.tieba.write.write.WriteActivity.60
        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.a
        public void f(View view, String str) {
            if (WriteActivity.this.ocT != null) {
                TiebaStatic.log("c13802");
                WriteActivity.this.ocT.Zs();
                UtilHelper.clearClipBoard();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, str, false, null)));
            }
        }
    };
    private final NewWriteModel.d fGo = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.61
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.cFz();
            WriteActivity.this.closeLoadingDialog();
            WriteActivity.this.ogv = true;
            if (postWriteCallBackData != null && WriteActivity.this.ngI != null) {
                WriteActivity.this.oeK.bm(null);
                if (z) {
                    WriteActivity.this.la(z);
                    if (WriteActivity.this.h(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    com.baidu.tieba.write.b.b.g(WriteActivity.this.ngI);
                    WriteActivity.this.cJs();
                    WriteActivity.this.dQI();
                    if ((WriteActivity.this.ngI.getType() == 0 || WriteActivity.this.ngI.getType() == 9 || WriteActivity.this.ngI.getType() == 11) && !x.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                        TiebaStatic.log(new aq("c11731").dX("obj_id", WriteActivity.this.mTopicId));
                    }
                    WriteActivity.this.j(postWriteCallBackData);
                    if (!at.isEmpty(postWriteCallBackData.getVideoid()) && WriteActivity.this.ngI.getVideoInfo() != null) {
                        postWriteCallBackData.mVideoMd5 = WriteActivity.this.ngI.getVideoInfo().getVideoMd5();
                        if (!at.isEmpty(WriteActivity.this.ngI.getForumName())) {
                            postWriteCallBackData.mFrom = 2;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VIDEO_WRITE_POST_SUCCESS, postWriteCallBackData));
                    } else {
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                        intent.putExtras(bundle);
                        WriteActivity.this.setResult(-1, intent);
                    }
                    WriteActivity.this.finish();
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    WriteActivity.this.showToast(postWriteCallBackData.getErrorString());
                    WriteActivity.this.oeK.bm(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.oeK.Vf(postWriteCallBackData.getErrorString());
                    WriteActivity.this.oeK.b(WriteActivity.this.nha, WriteActivity.this.oep);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.d(WriteActivity.this.getActivity(), WriteActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.d(WriteActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this.getActivity());
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.Bp(WriteActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.Bp(postWriteCallBackData.getErrorString());
                    }
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.61.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.61.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(WriteActivity.this.getActivity(), 0, 26, 1)));
                            TiebaStatic.log(new aq("c13746").an("obj_locate", 1).an("obj_type", 1));
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).btX();
                    TiebaStatic.log(new aq("c13745").an("obj_locate", 1).an("obj_type", 1));
                } else if ((ahVar == null || writeData == null || ahVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (ahVar != null && writeData != null && ahVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(ahVar.getVcode_md5());
                    writeData.setVcodeUrl(ahVar.getVcode_pic_url());
                    writeData.setVcodeExtra(ahVar.bAg());
                    if (com.baidu.tbadk.t.a.EQ(ahVar.bAf())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bAf());
                        if (WriteActivity.this.ofb) {
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
    private final LocationModel.a fGm = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.62
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bFH() {
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
        public void a(LocationData locationData) {
            if (locationData != null && !StringUtils.isNull(locationData.getFormatted_address())) {
                WriteActivity.this.a(2, true, locationData.getFormatted_address());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener nug = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.fFZ.yn(false);
                    WriteActivity.this.fFZ.gv(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.fFZ.yn(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener oeO = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.write.write.WriteActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                WriteActivity.this.eaR();
            }
        }
    };
    private CustomMessageListener ogu = new CustomMessageListener(2921516) { // from class: com.baidu.tieba.write.write.WriteActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof EvaluateRelevanceItemSelectedMessage)) {
                WriteActivity.this.a((EvaluateRelevanceItemSelectedMessage) customResponsedMessage);
            }
        }
    };
    private final View.OnClickListener oeP = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dZE = WriteActivity.this.dZE();
            if (dZE >= 0 && dZE < WriteActivity.this.oep.getText().length()) {
                WriteActivity.this.oep.setSelection(dZE);
            }
        }
    };
    private boolean oeQ = true;
    private final View.OnFocusChangeListener hxA = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.nha || view == WriteActivity.this.mBack || view == WriteActivity.this.lPZ) {
                if (z) {
                    WriteActivity.this.oeQ = true;
                    WriteActivity.this.dZF();
                    l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.nha);
                    if (WriteActivity.this.fDN != null) {
                        WriteActivity.this.fDN.bDe();
                    }
                } else if (view == WriteActivity.this.nha) {
                    WriteActivity.this.nhf.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.oep && z) {
                WriteActivity.this.oeQ = false;
                WriteActivity.this.dZF();
                l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.oep);
                if (WriteActivity.this.fDN != null) {
                    WriteActivity.this.fDN.bDe();
                }
            }
            WriteActivity.this.dZK();
        }
    };
    private com.baidu.tbadk.mutiprocess.h jem = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(GoodsEvent goodsEvent) {
            if (goodsEvent != null) {
                WriteActivity.this.Vz(goodsEvent.getGoodsList());
                goodsEvent.setDispost(true);
            }
            return false;
        }
    };
    private boolean ogv = false;
    private TextWatcher oeR = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.20
        private String oeV = "";
        private String oeW;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.oeW = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.oeW != null ? this.oeW.length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dLx();
            WriteActivity.this.dZL();
            EditText dZX = WriteActivity.this.dZX();
            if (editable != null && dZX != null && dZX.getText() != null) {
                if (this.oeV == null || !this.oeV.equals(editable.toString())) {
                    if (WriteActivity.this.oeK != null) {
                        this.oeV = dZX.getText().toString();
                        WriteActivity.this.oeK.b(dZX, true);
                        return;
                    }
                    return;
                }
                dZX.setSelection(dZX.getSelectionEnd());
            }
        }
    };
    private TextWatcher oeS = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.21
        private String oeW;
        private String oeX = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.oeW = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.oeW != null ? this.oeW.length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dLx();
            EditText dZW = WriteActivity.this.dZW();
            if (editable != null && dZW != null && dZW.getText() != null) {
                if (this.oeX == null || !this.oeX.equals(editable.toString())) {
                    if (WriteActivity.this.oeK != null) {
                        this.oeX = dZW.getText().toString();
                        WriteActivity.this.oeK.b(dZW, false);
                    }
                    if (WriteActivity.this.isEvaluate) {
                        WriteActivity.this.e(editable);
                        return;
                    }
                    return;
                }
                dZW.setSelection(dZW.getSelectionEnd());
            }
        }
    };
    private int ogw = 0;
    private final a.InterfaceC0851a lWk = new a.InterfaceC0851a() { // from class: com.baidu.tieba.write.write.WriteActivity.47
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0851a
        public void onRefresh() {
            WriteActivity.this.lhT = null;
            WriteActivity.this.zt(false);
            WriteActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };
    private final Runnable ogx = new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.49
        @Override // java.lang.Runnable
        public void run() {
            if (WriteActivity.this.ogb) {
                WriteActivity.this.fGo.callback(false, com.baidu.tieba.tbadkCore.writeModel.c.nvG, com.baidu.tieba.tbadkCore.writeModel.c.nvH, com.baidu.tieba.tbadkCore.writeModel.c.nvI, com.baidu.tieba.tbadkCore.writeModel.c.antiData);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null) {
            this.ofP = jVar;
            if (this.ngI != null) {
                this.ngI.setForumId(this.ofP.forumId);
                this.ngI.setForumName(this.ofP.forumName);
            }
            this.ofO.setSelectedForum(this.ofP.forumName);
            this.nYG = null;
            if (!x.isEmpty(this.ofP.tabInfoList)) {
                this.nYG = new FrsTabInfoData();
                this.nYG.selectedTabId = -1;
                this.nYG.tabList = this.ofP.tabInfoList;
                if (this.ofP.isForumBusinessAccount && this.nYG.tabList != null) {
                    FrsTabItemData frsTabItemData = new FrsTabItemData();
                    frsTabItemData.tabId = 505;
                    frsTabItemData.name = "官方";
                    this.nYG.tabList.add(0, frsTabItemData);
                }
                this.nYG.isForumBusinessAccount = this.ofP.isForumBusinessAccount;
            }
            this.oeM.setData(this.nYG);
            if (this.ngI != null) {
                this.ngI.setFrsTabInfoData(this.nYG);
            }
            if (this.oeM.getVisibility() == 0) {
                this.ofS.setVisibility(0);
            }
            this.mPrefixData = null;
            if (this.ofP.fCB != null && !x.isEmpty(this.ofP.fCB.getPrefixs())) {
                this.mPrefixData = this.ofP.fCB;
                this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
            }
            eaz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(PostWriteCallBackData postWriteCallBackData) {
        if (WriteActivityConfig.FROM_ADD_PHOTO_LIVE_IN_MISSON.equals(this.mFrom)) {
            TiebaStatic.log(TbadkCoreStatisticKey.UPDATE_SUCCES_IN_MISSON);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PHOTO_LIVE_MISSON_UPDATE_SUCCESS, postWriteCallBackData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(WriteData writeData) {
        return writeData == null || !("1".equals(writeData.getCallFrom()) || "2".equals(writeData.getCallFrom()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFq() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EvaluateRelevanceItemSelectedMessage evaluateRelevanceItemSelectedMessage) {
        this.ofQ.setVisibility(0);
        TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
        tbRichTextEvaluateItemInfo.setItemID(evaluateRelevanceItemSelectedMessage.item_id);
        tbRichTextEvaluateItemInfo.setTags(evaluateRelevanceItemSelectedMessage.tags);
        tbRichTextEvaluateItemInfo.setScore(evaluateRelevanceItemSelectedMessage.score);
        tbRichTextEvaluateItemInfo.setStar(evaluateRelevanceItemSelectedMessage.star);
        tbRichTextEvaluateItemInfo.setIconUrl(evaluateRelevanceItemSelectedMessage.icon_url);
        tbRichTextEvaluateItemInfo.setIconSize(evaluateRelevanceItemSelectedMessage.icon_size);
        tbRichTextEvaluateItemInfo.setTitle(evaluateRelevanceItemSelectedMessage.item_name);
        this.ngI.setItemInfo(tbRichTextEvaluateItemInfo);
        this.ofQ.setItemInfo(tbRichTextEvaluateItemInfo);
    }

    public void bFs() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bFu();
        } else if (this.fFZ.dPV()) {
            bFq();
        } else {
            this.fFZ.yn(false);
            a(1, true, (String) null);
            this.fFZ.dPT();
        }
    }

    public void eah() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.oeJ != null) {
                this.oeJ.dYK();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bFu();
        } else if (this.fFZ != null) {
            this.fFZ.yn(false);
            a(1, true, (String) null);
            this.fFZ.dPT();
        }
    }

    private void bFu() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.pa(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.fFZ.dPX();
                } else {
                    WriteActivity.this.fGm.bFH();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.btX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dZE() {
        int selectionEnd = dZW().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dZW().getText().getSpans(0, dZW().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dZW().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dZW().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZF() {
        if (this.fDN != null) {
            if (this.ofT != null && this.ofT.isVisible()) {
                this.fDN.setBarLauncherEnabled(!this.oeQ);
                this.fDN.setDeskLauncherEnabled(!this.oeQ);
                this.fDN.setToolEnabled(true, 2);
                this.fDN.setToolEnabled(true, 32);
                this.fDN.setToolEnabled(false, 10);
                this.fDN.setToolEnabled(false, 6);
                this.fDN.setToolEnabled(false, 18);
                this.fDN.sv(5).kS(false);
                if (this.oeJ != null) {
                    this.oeJ.zn(true);
                }
            } else {
                this.fDN.setBarLauncherEnabled(!this.oeQ);
                this.fDN.setDeskLauncherEnabled(!this.oeQ);
                this.fDN.setToolEnabled(true, 26);
                this.fDN.setToolEnabled(true, 2);
                this.fDN.setToolEnabled(true, 30);
                this.fDN.sv(5).kS(true);
                if (this.oeJ != null) {
                    this.oeJ.zn(true);
                }
                eaN();
            }
            if (this.isEvaluate && this.ogt != null && !this.ogt.isEnable()) {
                this.fDN.setToolEnabled(false, 31);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.oeF) {
            this.nha.setVisibility(8);
            if (this.ngI.getType() == 5) {
                this.ofv.setVisibility(8);
            } else {
                this.ofv.setVisibility(0);
            }
            a(this.ofy, this.ofs);
            a(this.ofx, this.ofw);
            dLx();
        }
        if (this.oeZ) {
            this.oeQ = true;
            dZF();
            if (this.fDN != null) {
                this.fDN.bDe();
            }
            this.nha.requestFocus();
            ShowSoftKeyPadDelay(this.nha);
        }
        if (this.ofT != null) {
            this.ofT.onResume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
        if (this.ofT != null) {
            this.ofT.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
        if (this.ofT != null) {
            this.ofT.onStop();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            if (stringExtra != null && this.writeImagesInfo != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    eaf();
                }
                zu(true);
            }
            Serializable serializableExtra = intent.getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.ngI.setVideoInfo((VideoInfo) serializableExtra);
            } else {
                this.ngI.setVideoInfo(null);
            }
            if (this.ofT == null) {
                this.ofT = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            }
            if (this.ngI.getVideoInfo() != null && this.ngI.getVideoInfo().isEditVideoDataLegal()) {
                aD(false, false);
                this.ofT.ebw();
                return;
            }
            aD(true, false);
        }
    }

    public void Fd(String str) {
        showToastWithDefaultIcon(str, BdToast.DefaultIcon.FAILURE);
    }

    public void aD(boolean z, boolean z2) {
        if (z) {
            this.ngI.setVideoInfo(null);
            this.ofT.a(null, z2);
            this.ofp.ZX().setVisibility(0);
            zt(false);
        } else {
            this.ofT.a(this.ngI.getVideoInfo(), z2);
            this.writeImagesInfo.clear();
            this.ofp.ZX().setVisibility(8);
            eaB();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, false));
        }
        dLx();
        dZF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initListener();
        initData(bundle);
        if (this.ngI.getType() == 0) {
            MN(this.bMh);
        }
        initUI();
        eaA();
        this.fFZ = new LocationModel(getPageContext());
        this.fFZ.a(this.fGm);
        eaX();
        dbQ();
        eaQ();
        if (this.oeF) {
            this.ofr.setEditorTools(this.fDN);
        } else {
            this.oep.requestFocus();
        }
        dFD();
        eaf();
        eaO();
        this.jem.setPriority(1);
        registerResponsedEventListener(GoodsEvent.class, this.jem);
        eai();
        if (this.ogb) {
            k(this.ngI);
            dLx();
            eaF();
        }
    }

    private void initListener() {
        registerListener(this.ogo);
        registerListener(this.ogp);
        registerListener(this.ogq);
        registerListener(this.nug);
        registerListener(this.oeO);
        registerListener(this.mBackgroundListener);
        registerListener(this.ogu);
    }

    private void eai() {
        Vz(this.ogc);
    }

    @SuppressLint({"ResourceAsColor"})
    private void dbQ() {
        this.fDN = new EditorTools(getActivity());
        this.fDN.setBarMaxLauCount(5);
        this.fDN.setMoreButtonAtEnd(true);
        this.fDN.setBarBackgroundColorId(R.color.CAM_X0201);
        this.fDN.setBarLauncherType(1);
        this.fDN.kO(true);
        this.fDN.kP(false);
        switch (this.ngI.getType()) {
            case 4:
            case 5:
                eal();
                break;
            default:
                dZG();
                break;
        }
        this.fDN.build();
        if (this.oen != null) {
            this.oen.addView(this.fDN);
        }
        dbq();
        this.fDN.rV();
        com.baidu.tbadk.editortools.h ss = this.fDN.ss(6);
        if (ss != null && !TextUtils.isEmpty(this.fGe)) {
            ((View) ss).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.fGe);
                }
            });
        }
        if (!this.oeF) {
            this.fDN.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.fDN.bDe();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.fDN.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.fDN.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (com.baidu.tbadk.core.sharedPref.b.bvq().getInt("commodity_tip_show_controller", 0) == 0 && this.canGoods) {
            eam();
            return;
        }
        dZI();
        eaR();
    }

    private void eaj() {
        this.oft = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.ofv = this.oft.findViewById(R.id.live_post_title_container);
        this.ofs = (EditText) this.oft.findViewById(R.id.live_post_content);
        this.ofq = (GridView) this.oft.findViewById(R.id.photoLiveGridView);
        this.ofw = (EditText) this.oft.findViewById(R.id.live_post_title);
        this.ofx = (TextView) this.oft.findViewById(R.id.titleOverPlusNumber);
        this.ofy = (TextView) this.oft.findViewById(R.id.contentOverPlusNumber);
        this.ofu = this.oft.findViewById(R.id.live_interval_view);
        this.ofx.setText(String.valueOf(20));
        this.ofy.setText(String.valueOf(233));
        this.oft.setVisibility(0);
        this.ofx.setVisibility(0);
        this.ofy.setVisibility(0);
        this.ofw.setHint(R.string.tips_title_limit_new);
        this.ofw.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.ofB = true;
                    WriteActivity.this.oeQ = true;
                    WriteActivity.this.dZF();
                    if (WriteActivity.this.fDN != null) {
                        WriteActivity.this.fDN.bDe();
                    }
                }
            }
        });
        if (this.ngI.getType() == 4) {
            this.ofs.setHint(R.string.live_write_input_content_new);
        } else if (this.ngI.getType() == 5) {
            this.ofs.setHint(R.string.live_write_input_content_update);
        }
        this.ofs.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.ofB = false;
                    WriteActivity.this.oeQ = false;
                    WriteActivity.this.dZF();
                    if (WriteActivity.this.fDN != null) {
                        WriteActivity.this.fDN.bDe();
                    }
                }
            }
        });
        this.ofs.requestFocus();
        this.ofs.addTextChangedListener(aAg());
        this.ofw.requestFocus();
        this.ofw.addTextChangedListener(aAg());
        this.ofw.setOnClickListener(this.oeP);
        this.ofs.setOnClickListener(this.oeP);
        this.ofr = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.ofq);
        this.ofr.ME(6);
        this.ofq.setAdapter((ListAdapter) this.ofr);
        View findViewById = this.oft.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void dZe() {
                WriteActivity.this.eaL();
            }
        });
        eak();
    }

    private void eak() {
        if (this.ngI.getType() == 0) {
            if (this.ngI.getTitle() != null) {
                this.ofw.setText(this.ngI.getTitle());
                this.ofw.setSelection(this.ngI.getTitle().length());
                return;
            }
            return;
        }
        if (this.ngI.getType() == 1 || this.ngI.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.oeF) {
            eaJ();
        }
        if (this.fDN.bEM()) {
            this.fDN.bDe();
        }
        MN(0);
    }

    public boolean dYv() {
        return !"1".equals(this.jLR) && this.writeImagesInfo.size() == 0 && this.mVoiceModel == null;
    }

    private boolean e(Spannable spannable) {
        if (spannable != null) {
            ImageSpan[] imageSpanArr = (ImageSpan[]) spannable.getSpans(0, spannable.length(), ImageSpan.class);
            if (imageSpanArr == null || imageSpanArr.length <= 0) {
                if (this.oeK == null || !this.oeK.d(spannable)) {
                    return be.bwu().n(spannable);
                }
                return true;
            }
            return true;
        }
        return false;
    }

    private void MN(int i) {
        if (this.writeImagesInfo != null && this.ngI != null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.ngI.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", this.ngI.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumFloatActivityConfig.setRequestCode(12002);
            albumFloatActivityConfig.setAlbumThread(i);
            albumFloatActivityConfig.setCanSelectVideo(dYv());
            albumFloatActivityConfig.setFromWrite(true);
            albumFloatActivityConfig.setCallFrom(this.jLR);
            albumFloatActivityConfig.setStatisticFrom(this.ngI.getStatisticFrom());
            albumFloatActivityConfig.setProfessionZone(this.ngI.getProZone());
            albumFloatActivityConfig.setFrsTabInfo(this.nYG);
            AntiData antiData = new AntiData();
            antiData.voice_message = this.fGe;
            antiData.setIfVoice(this.ofm);
            albumFloatActivityConfig.setExtraData(antiData, this.mPrefixData, this.ngI.getFirstDir(), this.ngI.getSecondDir());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
        }
    }

    private void eal() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.fDN.bL(arrayList);
        m sv = this.fDN.sv(5);
        if (sv != null) {
            sv.fEA = 2;
        }
        this.fDN.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.fDN.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void dZG() {
        m mVar;
        m mVar2;
        m mVar3;
        CustomResponsedMessage runTask;
        m mVar4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 1);
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            this.fDN.b(dVar);
        }
        Boolean eaE = eaE();
        if (!this.oeZ && eaE != null && eaE.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.dQz() && com.baidu.tieba.tbadkCore.u.d(this.ngI.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), m.class)) != null && (mVar4 = (m) runTask.getData()) != null) {
            mVar4.fEA = 2;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fDN.b(mVar4);
            }
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), m.class);
        if (runTask2 != null && (mVar3 = (m) runTask2.getData()) != null) {
            mVar3.fEA = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fDN.b(mVar3);
            }
        }
        if (!com.baidu.tieba.write.b.b.dYT() && !this.isEvaluate) {
            this.fDN.b(new com.baidu.tbadk.editortools.l(getActivity(), 6));
        }
        this.fDN.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 7));
        if (at.equals(this.jLR, "2")) {
            this.ogt = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
            if (this.isEvaluate) {
                this.ogt.kT(false);
                this.ogt.setEnable(false);
            }
            this.fDN.b(this.ogt);
            if (!this.isEvaluate) {
                this.fDN.b(new com.baidu.tbadk.editortools.e.a(getActivity(), 8));
            }
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), m.class);
        if (runTask3 != null && (mVar2 = (m) runTask3.getData()) != null) {
            mVar2.fEC = true;
            mVar2.fEA = 9;
            mVar2.fEu = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fDN.b(mVar2);
            }
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), m.class);
        if (runTask4 != null && (mVar = (m) runTask4.getData()) != null) {
            mVar.fEC = true;
            mVar.fEA = 10;
            mVar.fEu = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fDN.b(mVar);
            }
        }
        if (this.oeu == null) {
            if (this.oeJ == null) {
                this.oeJ = new com.baidu.tieba.write.editor.b(getActivity(), this.jLR);
                this.oeJ.My(0);
                this.oeJ.zm(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.oeJ.dYI();
                this.oeJ.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                eah();
            }
            if (!x.isEmpty(this.mList)) {
                this.oeJ.dYI();
            }
            this.fDN.b(this.oeJ);
        }
        if (!this.isEvaluate && !"main_tab".equals(this.mFrom)) {
            this.fDN.b(new com.baidu.tbadk.editortools.d(getActivity(), 10));
        }
        this.fDN.bL(arrayList);
        m sv = this.fDN.sv(5);
        if (sv != null) {
            sv.fEA = 4;
        }
    }

    private void dZH() {
        if (this.oeL != null) {
            this.oeL.hideTip();
        }
    }

    private void eam() {
        if (this.fDN != null) {
            this.fDN.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.16
                @Override // java.lang.Runnable
                public void run() {
                    if (WriteActivity.this.fDN != null && WriteActivity.this.fDN.fDQ != null) {
                        if (WriteActivity.this.ofN == null) {
                            WriteActivity.this.ofN = new b(WriteActivity.this.getPageContext());
                        }
                        WriteActivity.this.ofN.showTip(WriteActivity.this.fDN.fDQ.st(2));
                    }
                }
            });
        }
    }

    private void ean() {
        if (this.ofN != null) {
            this.ofN.hideTip();
        }
    }

    private void dZI() {
        if (this.oeL == null) {
            this.oeL = new g(getPageContext());
        }
        this.oeL.d(this.fDN);
    }

    private void dbq() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                VideoInfo videoInfo;
                WriteVoteData writeVoteData = null;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        TiebaStatic.log(new aq("c12612").an("obj_locate", 9));
                        if (WriteActivity.this.dZV()) {
                            WriteActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new aq("c12612").an("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.u)) {
                            com.baidu.tbadk.coreExtra.data.u uVar = (com.baidu.tbadk.coreExtra.data.u) aVar.data;
                            if (uVar.bzW() == EmotionGroupType.BIG_EMOTION || uVar.bzW() == EmotionGroupType.USER_COLLECT) {
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
                                    imageFileInfo.setFilePath(uVar.getName());
                                    imageFileInfo.width = uVar.getWidth();
                                    imageFileInfo.height = uVar.getHeight();
                                    WriteActivity.this.writeImagesInfo.addChooseFile(imageFileInfo);
                                    WriteActivity.this.writeImagesInfo.updateQuality();
                                    WriteActivity.this.zu(true);
                                    WriteActivity.this.dLx();
                                }
                            } else if (WriteActivity.this.dZV()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(uVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.dZY();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.f((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.dpL();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.eaN();
                        WriteActivity.this.dLx();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.MO(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.oeu == null) {
                            WriteActivity.this.bFv();
                            return;
                        }
                        switch (WriteActivity.this.fGf) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ad.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.bFs();
                                    return;
                                } else {
                                    ad.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.bFq();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.fFZ != null) {
                            WriteActivity.this.fFZ.yn(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.lhT = null;
                        } else {
                            WriteActivity.this.lhT = (String) aVar.data;
                        }
                        WriteActivity.this.zt(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        aq aqVar = new aq("c10645");
                        aqVar.dX("fid", WriteActivity.this.ngI != null ? WriteActivity.this.ngI.getForumId() : "");
                        TiebaStatic.log(aqVar);
                        if (WriteActivity.this.ngI == null || (videoInfo = WriteActivity.this.ngI.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.fDN.bEM()) {
                                        WriteActivity.this.fDN.bDe();
                                        WriteActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.ngI.setVideoInfo(null);
                        WriteActivity.this.dLx();
                        if (WriteActivity.this.oep != null) {
                            WriteActivity.this.oep.requestFocus();
                        }
                        WriteActivity.this.fDN.bDe();
                        WriteActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.oep);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new aq("c12612").an("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.oek = true;
                        WriteActivity.this.zq(true);
                        if (!WriteActivity.this.dZX().isFocused() || WriteActivity.this.oeo.getVisibility() != 0) {
                            WriteActivity.this.oej = "from_content";
                        } else {
                            WriteActivity.this.oej = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        TiebaStatic.log(new aq("c12612").an("obj_locate", 8));
                        if (WriteActivity.this.oeo.getVisibility() == 0) {
                            if (WriteActivity.this.oeo.hasFocus()) {
                                WriteActivity.this.oep.requestFocus();
                                WriteActivity.this.oep.setSelection(WriteActivity.this.oep.getText().toString().length());
                            }
                            WriteActivity.this.oeo.setVisibility(8);
                            if (WriteActivity.this.ogs != null) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) WriteActivity.this.ogs.getLayoutParams();
                                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                                WriteActivity.this.ogs.setLayoutParams(layoutParams);
                            }
                            WriteActivity.this.ofe.setVisibility(8);
                            WriteActivity.this.fDN.ss(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.oeo.setVisibility(0);
                            if (WriteActivity.this.ogs != null) {
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) WriteActivity.this.ogs.getLayoutParams();
                                layoutParams2.topMargin = 0;
                                WriteActivity.this.ogs.setLayoutParams(layoutParams2);
                            }
                            WriteActivity.this.ofe.setVisibility(0);
                            WriteActivity.this.oeo.requestFocus();
                            WriteActivity.this.fDN.ss(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.dLx();
                    } else if (aVar.code == 55) {
                        if (aVar.data != null && (aVar.data instanceof Boolean)) {
                            WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                        }
                    } else if (aVar.code == 58) {
                        if (aVar.data != null && (aVar.data instanceof Boolean)) {
                            WriteActivity.this.isToDynamic = ((Boolean) aVar.data).booleanValue();
                        }
                    } else if (aVar.code == 22) {
                        TiebaStatic.log(new aq("c12612").an("obj_locate", 10));
                        if (WriteActivity.this.ofU != null && WriteActivity.this.ofU.getWriteVoteData() != null) {
                            writeVoteData = WriteActivity.this.ofU.getWriteVoteData();
                        }
                        WriteActivity.this.a(writeVoteData);
                        TiebaStatic.log(new aq("c13800").an("obj_source", 2));
                        WriteActivity.this.eao();
                    } else if (aVar.code == 21) {
                        if (WriteActivity.this.ocT != null) {
                            WriteActivity.this.ocT.Zs();
                        }
                        TiebaStatic.log(new aq("c12612").an("obj_locate", 5));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, "", true, null)));
                    } else if (aVar.code == 59) {
                        WriteActivity.this.dYa();
                    }
                }
            }
        };
        this.fDN.setActionListener(16, bVar);
        this.fDN.setActionListener(14, bVar);
        this.fDN.setActionListener(24, bVar);
        this.fDN.setActionListener(3, bVar);
        this.fDN.setActionListener(10, bVar);
        this.fDN.setActionListener(11, bVar);
        this.fDN.setActionListener(12, bVar);
        this.fDN.setActionListener(13, bVar);
        this.fDN.setActionListener(15, bVar);
        this.fDN.setActionListener(18, bVar);
        this.fDN.setActionListener(20, bVar);
        this.fDN.setActionListener(25, bVar);
        this.fDN.setActionListener(27, bVar);
        this.fDN.setActionListener(29, bVar);
        this.fDN.setActionListener(43, bVar);
        this.fDN.setActionListener(56, bVar);
        this.fDN.setActionListener(48, bVar);
        this.fDN.setActionListener(46, bVar);
        this.fDN.setActionListener(49, bVar);
        this.fDN.setActionListener(47, bVar);
        this.fDN.setActionListener(55, bVar);
        this.fDN.setActionListener(58, bVar);
        this.fDN.setActionListener(22, bVar);
        this.fDN.setActionListener(21, bVar);
        this.fDN.setActionListener(59, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eao() {
        if (this.ofj != null) {
            this.ofj.setVisibility(8);
        }
        if (this.mName != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
            layoutParams.rightMargin = this.ogw;
            this.mName.setLayoutParams(layoutParams);
        }
    }

    private void eap() {
        if (this.ogd instanceof WriteVoteData) {
            final WriteVoteData writeVoteData = (WriteVoteData) this.ogd;
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.a(writeVoteData);
                    TiebaStatic.log(new aq("c13800").an("obj_source", 3));
                }
            };
            this.ofU.ap(onClickListener);
            this.ofU.setOnItemClickListener(onClickListener);
            this.ofU.b(writeVoteData);
            this.ofU.zw(true);
            dLx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WriteVoteData writeVoteData) {
        WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SDK_WEB_VIEW);
        if (writeVoteData != null) {
            writeVoteActivityConfig.setExtraData(writeVoteData);
        }
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeVoteActivityConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MO(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFv() {
        if (this.fFZ.cot()) {
            if (this.fFZ.dPV()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.b.dPQ().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.fFZ.dPT();
            return;
        }
        a(0, true, (String) null);
    }

    protected void zs(boolean z) {
        if (!z && this.ofn != null) {
            this.ofn.cIb();
        }
        if (this.oeq != null) {
            this.oeq.cancelLoadData();
        }
        if (this.fFZ != null) {
            this.fFZ.cancelLoadData();
        }
        if (this.ofT != null) {
            this.ofT.onDestroy();
        }
    }

    protected void dLp() {
        zs(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mNavigationBar.removeCallbacks(this.ogx);
        if (this.ofn != null) {
            this.ofn.dQC();
        }
        dZH();
        ean();
        TiebaPrepareImageService.StopService();
        zs(true);
        if (!this.ogv) {
            eaq();
        }
        com.baidu.adp.lib.f.g.dismissDialog(this.jsx, this);
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.ofp != null) {
            this.ofp.destroy();
        }
        if (this.ofM != null) {
            this.ofM.VL();
        }
        MessageManager.getInstance().unRegisterTask(2921500);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaq() {
        if (this.ngI != null && this.ngI.getType() == 2 && this.ofk) {
            finish();
        } else if (this.ngI == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.ngI.setTitle(dZX().getText().toString());
            this.ngI.setContent(dZW().getText().toString());
            if (this.ofQ != null) {
                this.ngI.setEvaluationStar(this.ofQ.getStarCount());
            }
            int type = this.ngI.getType();
            if (type == 0 || type == 9 || type == 11) {
                if (this.oga) {
                    if (this.ngI.isEvaluate()) {
                        y.d(this.ngI.getItem_id(), this.ngI);
                    } else if (TextUtils.isEmpty(this.ngI.getTopicId())) {
                        y.c(this.ngI.getForumId(), this.ngI);
                    } else {
                        y.e(this.ngI.getTopicId(), this.ngI);
                    }
                }
            } else if (type == 7) {
                if (this.oga) {
                    y.c("24591571", this.ngI);
                }
            } else if (type == 1) {
                y.b(this.ngI.getThreadId(), this.ngI);
            } else if (type == 4) {
                y.c(this.ngI.getForumId() + "photolive", this.ngI);
            } else if (type == 5) {
                y.b(this.ngI.getThreadId() + "updatephotolive", this.ngI);
            }
            this.ogv = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJZ() {
        if (this.lPZ == null || ((!this.lPZ.isEnabled() && !this.isEvaluate) || ((this.isEvaluate && TextUtils.isEmpty(this.oep.getText()) && ((this.writeImagesInfo.getChosedFiles() == null || this.writeImagesInfo.size() == 0) && (this.ofT == null || !this.ofT.isVisible()))) || this.ofW || !this.oga))) {
            cJs();
            dQI();
            setResult(100);
            finish();
            return;
        }
        if (this.jsy == null) {
            this.jsy = new SaveDraftDialogView(this);
            this.jsy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            WriteActivity.this.cJs();
                            WriteActivity.this.dQI();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            WriteActivity.this.eaq();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        }
                        WriteActivity.this.jsx.dismiss();
                    }
                }
            });
        }
        if (this.jsx == null) {
            this.jsx = new com.baidu.tbadk.core.dialog.i(getPageContext());
            this.jsx.setContentView(this.jsy);
        }
        boolean z = (this.ofT == null || !this.ofT.isVisible() || this.ngI == null || this.ngI.getVideoInfo() == null || this.ngI.getVideoInfo().isVideoMixFinished()) ? false : true;
        this.jsy.setText(getString(z ? R.string.write_save_draft_dialog_video_fail_title : R.string.write_save_draft_dialog_normal_title), z ? getString(R.string.write_save_draft_dialog_video_fail_sub_title) : null, getString(z ? R.string.write_save_draft_dialog_video_fail_save_text : R.string.save));
        this.jsx.SY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJs() {
        if (this.ngI.getType() == 0 || this.ngI.getType() == 9 || this.ngI.getType() == 11) {
            if (this.oga) {
                if (this.ngI.isEvaluate()) {
                    y.d(this.ngI.getItem_id(), (WriteData) null);
                } else if (TextUtils.isEmpty(this.ngI.getTopicId())) {
                    y.c(this.ngI.getForumId(), (WriteData) null);
                } else {
                    y.e(this.ngI.getTopicId(), (WriteData) null);
                }
            }
        } else if (this.ngI.getType() == 1) {
            y.b(this.ngI.getThreadId(), (WriteData) null);
        }
        this.ogv = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQI() {
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.nFh));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.nhg != null && this.nhg.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.nhg, getPageContext().getPageActivity());
                return true;
            } else if (this.fDN.bEM()) {
                this.fDN.bDe();
                return true;
            } else {
                dLp();
                cJZ();
                return true;
            }
        }
        if (i == 67 && (text = dZW().getText()) != null) {
            int selectionStart = dZW().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dZW().onKeyDown(67, this.iRl);
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
        getLayoutMode().onModeChanged(this.ltF);
        getLayoutMode().onModeChanged(this.ofG);
        ao.setBackgroundColor(this.ltF, R.color.CAM_X0205);
        if (this.ofD != null && (i == 1 || i == 4)) {
            this.ofD.setBorderColor(ao.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mNavigationBar.getBackImageView() != null) {
            this.mNavigationBar.getBackImageView().setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_close40, ao.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
        this.lPZ.setTextColor(ao.aP(R.color.CAM_X0302, i));
        dZF();
        ao.setBackgroundColor(this.nhb, R.color.CAM_X0204);
        ao.setBackgroundColor(this.ofu, R.color.CAM_X0204);
        ao.setBackgroundColor(dZX(), R.color.CAM_X0205);
        this.lPl.setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_delete16, ao.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null));
        if (TextUtils.isEmpty(this.lhT)) {
            ao.setBackgroundColor(dZW(), R.color.CAM_X0205);
        }
        dLx();
        this.fDN.onChangeSkinType(i);
        if (this.oeD != null) {
            this.oeD.bxO();
        }
        if (this.ogg != null) {
            this.ogg.notifyDataSetChanged();
        }
        ao.setViewTextColor(this.mName, R.color.CAM_X0105);
        this.ofp.ogV.notifyDataSetChanged();
        dZK();
        dZL();
        zt(false);
        if (this.oeK != null) {
            this.oeK.c(dZX(), dZW());
        }
        if (this.ofO != null) {
            this.ofO.onChangeSkinType();
        }
        if (this.ofQ != null) {
            this.ofQ.onChangeSkinType();
        }
        if (this.oeM != null) {
            this.oeM.onChangeSkinType(i);
        }
        if (this.ofT != null) {
            this.ofT.bxN();
        }
        if (this.ofU != null) {
            this.ofU.onChangeSkinType(i);
        }
        if (this.ogl != null) {
            this.ogl.onChangeSkinType(i);
        }
        if (this.ofc != null) {
            this.ofc.onChangeSkinType(i);
        }
        if (this.ofR != null) {
            ao.setViewTextColor(this.ofR, R.color.CAM_X0301);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZK() {
        if (this.nha.hasFocus()) {
            this.nha.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        } else {
            this.nha.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        }
        if (this.oep.hasFocus()) {
            this.oep.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        } else {
            this.oep.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZL() {
        if (this.nha != null && this.nha.getText() != null && this.nha.getText().toString() != null && this.nha.getPaint() != null) {
            if (this.nha.getText().toString().length() == 0) {
                this.nha.getPaint().setFakeBoldText(true);
            } else if (this.nha.getText().toString().length() > 0) {
                this.nha.getPaint().setFakeBoldText(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Editable editable) {
        g(editable);
        f(editable);
    }

    private void f(Editable editable) {
        if (!TextUtils.isEmpty(editable) && editable.length() >= 20 && editable.length() <= 500 && this.ofQ.dZj()) {
            this.lPZ.setEnabled(true);
        } else {
            this.lPZ.setEnabled(false);
        }
    }

    private void g(Editable editable) {
        if (editable.length() > 500) {
            this.ofR.setText((500 - editable.length()) + "/500");
            this.ofR.setVisibility(0);
            return;
        }
        this.ofR.setVisibility(4);
    }

    private void initUI() {
        this.fOA = new com.baidu.tbadk.core.view.a(getPageContext());
        this.oeF = this.ngI.getType() == 4 || 5 == this.ngI.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ao.setViewTextColor(this.mName, R.color.CAM_X0105);
        this.ofi = (TextView) findViewById(R.id.btn_image_problem);
        dZO();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lPZ.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds2);
        this.lPZ.setLayoutParams(layoutParams);
        this.lPZ.setOnFocusChangeListener(this.hxA);
        this.oeE = (ScrollView) findViewById(R.id.write_scrollview);
        this.oeE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.oep != null) {
                        l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.oep);
                    }
                    if (WriteActivity.this.fDN != null) {
                        WriteActivity.this.fDN.bDe();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.ofg = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.ofh = findViewById(R.id.feedback_divider);
        this.ltF = (RelativeLayout) findViewById(R.id.parent);
        this.oen = (LinearLayout) findViewById(R.id.tool_view);
        this.oen.setContentDescription(IStringUtil.TOP_PATH);
        this.oeo = (LinearLayout) findViewById(R.id.title_view);
        this.ogs = (WriteImageGridView) findViewById(R.id.write_image_grid_view);
        this.ofe = findViewById(R.id.title_view_divider);
        this.nhb = findViewById(R.id.interval_view);
        this.oeH = (TextView) findViewById(R.id.hot_topic_title_edt);
        dLw();
        if (this.oeF) {
            this.oeE.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            eaj();
        } else {
            this.ofp = new i(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.ofp.zj(false);
            } else {
                this.ofp.zj(this.ngI.getType() == 0 || this.ngI.getType() == 9 || this.ngI.getType() == 11);
            }
            this.ofT = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            if (this.ngI.getVideoInfo() != null && this.ngI.getVideoInfo().isEditVideoDataLegal()) {
                aD(false, false);
                this.ofT.ebw();
            } else {
                aD(true, false);
            }
        }
        dLy();
        if (this.oeZ || this.oem) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.b.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.b.e.getInstance().fek) {
                    com.baidu.tbadk.core.util.b.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.b.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.nhd = (LinearLayout) findViewById(R.id.post_content_container);
        this.nhd.setDrawingCacheEnabled(false);
        this.nhd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.oep.requestFocus();
            }
        });
        this.lPi = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.lPj = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.lPl = (ImageView) findViewById(R.id.iv_delete_voice);
        this.lPl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dpL();
            }
        });
        f(this.mVoiceModel);
        this.mBack.setOnFocusChangeListener(this.hxA);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dLp();
                WriteActivity.this.cJZ();
            }
        });
        this.ofi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        dZR();
        v(eaE());
        dZT();
        dZN();
        eaC();
        dZF();
        dZS();
        dLv();
        dZZ();
        if (this.ngI.getType() == 4 && this.nhi != null && this.oer != null) {
            this.nhi.setVisibility(8);
            this.oer.setVisibility(8);
        }
        dLx();
        eay();
        eax();
        ear();
        dZM();
        eas();
        eat();
        eaD();
        eau();
        bVm();
    }

    private void ear() {
        if ("main_tab".equals(this.mFrom) && !this.ogb) {
            this.ofO = (ForumSelectedView) findViewById(R.id.write_select_forum_view);
            this.ofO.setVisibility(0);
        }
    }

    private void dZM() {
        if (!this.isEvaluate) {
            this.oeM = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
            this.oeM.setBgColor(R.color.CAM_X0205);
            this.ofS = findViewById(R.id.frs_tab__divider);
            this.oeM.setData(this.nYG);
            if (this.oeM.getVisibility() == 0) {
                this.ofS.setVisibility(0);
            }
            this.oeM.setActivity(this);
        }
    }

    private void eas() {
        if (this.isEvaluate) {
            this.ofR = (TextView) findViewById(R.id.post_content_counter);
            this.ofQ = (WriteEvaluationHeaderView) findViewById(R.id.write_evaluation_header_view);
            this.ofQ.setStarChangeListener(new WriteEvaluationHeaderView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.28
                @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.a
                public void ap(float f) {
                    if (TextUtils.isEmpty(WriteActivity.this.oep.getText()) || WriteActivity.this.oep.getText().length() < 20 || WriteActivity.this.oep.getText().length() > 500 || f <= 0.0f) {
                        WriteActivity.this.lPZ.setEnabled(false);
                    } else {
                        WriteActivity.this.lPZ.setEnabled(true);
                    }
                }
            });
            this.ofQ.setItemCloseListener(new WriteEvaluationHeaderView.b() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.b
                public void onClose() {
                    WriteActivity.this.lPZ.setEnabled(false);
                }
            });
        }
    }

    private void eat() {
        if (this.isEvaluate) {
            this.ofQ.setVisibility(0);
            if (!this.jsH) {
                if (this.ofY) {
                    this.ofQ.setShowItemInfo(false);
                }
                if (this.ofX != null) {
                    TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
                    tbRichTextEvaluateItemInfo.setItemID(String.valueOf(this.ofX.id));
                    tbRichTextEvaluateItemInfo.setTags(this.ofX.tags);
                    tbRichTextEvaluateItemInfo.setScore(this.ofX.averageScore);
                    tbRichTextEvaluateItemInfo.setStar(L(this.ofX.averageScore));
                    tbRichTextEvaluateItemInfo.setIconUrl(this.ofX.icon_url);
                    tbRichTextEvaluateItemInfo.setIconSize(this.ofX.icon_size);
                    tbRichTextEvaluateItemInfo.setTitle(this.ofX.name);
                    this.ofQ.setItemInfo(tbRichTextEvaluateItemInfo);
                    this.ofQ.setStarCount(this.ofZ);
                    this.ngI.setItemInfo(tbRichTextEvaluateItemInfo);
                    this.ngI.setEvaluationStar(this.ofZ);
                } else if (this.ngI.getItemInfo() != null) {
                    this.ofQ.setItemInfo(this.ngI.getItemInfo());
                    this.ofQ.setStarCount(this.ngI.getEvaluationStar());
                }
            }
        }
    }

    private int L(double d) {
        return (int) ((1.0d + d) / 2.0d);
    }

    private void eau() {
        this.ogh = (LinearLayout) this.mRootView.findViewById(R.id.protocol);
        this.ogi = (ImageView) this.mRootView.findViewById(R.id.protocol_tag);
        this.ogj = (TextView) this.mRootView.findViewById(R.id.protocol_info);
        ao.setViewTextColor(this.ogj, R.color.CAM_X0107);
        this.ogl = new EBusinessProtocolView(this);
        this.ogl.a(EBusinessProtocolView.WindowType.PROTOCOL);
        this.ogl.setTitle(getResources().getString(R.string.protocol_title));
        SpannableString spannableString = new SpannableString(getResources().getString(R.string.readed_protocol));
        spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.write.write.WriteActivity.30
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.showDialog(WriteActivity.this.ogl, WriteActivity.this);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NonNull TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, 6, 17, 34);
        spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0302)), 6, 17, 34);
        this.ogj.setText(spannableString);
        this.ogj.setMovementMethod(LinkMovementMethod.getInstance());
        this.ogi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.ogm) {
                    WriteActivity.this.ogm = false;
                    WriteActivity.this.ogi.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ao.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                } else {
                    WriteActivity.this.ogm = true;
                    WriteActivity.this.ogi.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                }
                if (!com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false) && WriteActivity.this.ogm) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this);
                    aVar.pc(R.color.CAM_X0105);
                    aVar.Bo("");
                    aVar.Bp(WriteActivity.this.getResources().getString(R.string.protocol_tip));
                    aVar.pd(1);
                    aVar.a("同意", new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.31.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", true);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(PayHelper.STATUS_CANCEL_DESC, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.31.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).btX();
                }
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false)) {
            this.ogm = true;
            this.ogi.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            this.ogm = false;
            this.ogi.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ao.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
        this.ogl.a(new EBusinessProtocolView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // com.baidu.tieba.write.write.EBusinessProtocolView.a
            public void zo(boolean z) {
                if (z) {
                    if (!WriteActivity.this.ogm) {
                        WriteActivity.this.ogm = true;
                        WriteActivity.this.ogi.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                    }
                } else if (WriteActivity.this.ogm) {
                    WriteActivity.this.ogm = false;
                    WriteActivity.this.ogi.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ao.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                }
            }
        });
    }

    private void eav() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
        this.ogw = layoutParams.rightMargin;
        layoutParams.rightMargin = 0;
        this.mName.setLayoutParams(layoutParams);
        this.ofj = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.ofj.setImageDrawable(WebPManager.a(R.drawable.icon_pure_creation_question16, ao.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds47);
        this.ofj.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ofj.getLayoutParams();
        layoutParams2.width = dimens + dimens2 + dimens;
        layoutParams2.height = dimens + dimens2 + dimens;
        this.ofj.setLayoutParams(layoutParams2);
        this.ofj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.eaw();
            }
        });
        this.ofj.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaw() {
        EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this);
        eBusinessProtocolView.a(EBusinessProtocolView.WindowType.TIP);
        eBusinessProtocolView.setTitle(getResources().getString(R.string.tip_title));
        com.baidu.adp.lib.f.g.showDialog(eBusinessProtocolView, this);
    }

    private void eax() {
        if (this.mName != null && this.ngI != null && this.ngI.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void dZN() {
        String str;
        String str2;
        if (this.ngI != null) {
            switch (this.ngI.getType()) {
                case 0:
                case 9:
                    if (this.oeZ || this.oem) {
                        if (this.ofb) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.jLR != null && this.jLR.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                    } else if (this.jLR != null && this.jLR.equals("2")) {
                        if (this.isEvaluate) {
                            this.mName.setText(R.string.publish_comment);
                        } else if (StringUtils.isNull(this.ngI.getForumName())) {
                            this.mName.setText(R.string.post_to_thread);
                        } else {
                            String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.ngI.getForumName(), 9, true, false);
                            if (fixedBarText.length() < 14) {
                                str2 = fixedBarText + getResources().getString(R.string.bar);
                            } else {
                                str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                            }
                            this.mName.setText(str2);
                        }
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.ngI.getForumName() + getResources().getString(R.string.bar));
                        this.nha.setVisibility(8);
                        String str3 = this.jdd + " " + this.jdb;
                        if (!StringUtils.isNull(str3)) {
                            this.oep.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.nha.setVisibility(0);
                    this.oep.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                case 10:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.oep.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.nha.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.oep.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.ngI.getFloorNum() + 1)));
                    this.ofu.setVisibility(8);
                    return;
                case 7:
                    this.nha.setVisibility(0);
                    this.oep.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
                case 11:
                    this.mName.setText(R.string.publish_comment);
                    this.nha.setVisibility(0);
                    this.oep.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
            }
        }
    }

    private void dZO() {
        if (this.ngI.getType() == 7) {
            this.lPZ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.lPZ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void dZP() {
        if (this.ngI != null && this.ngI.getType() == 0 && this.ngI.getType() == 9 && !this.oeZ && !this.oem && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = at.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dZX() != null) {
                dZX().setText(cutStringWithSuffix);
                dZX().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.ngI.setVoiceModel(voiceModel);
            this.lPi.setVisibility(0);
            this.lPj.setVoiceModel(voiceModel);
            this.lPj.cfq();
            dLx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpL() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.CG(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.ngI.setVoiceModel(null);
        this.lPi.setVisibility(8);
        this.lPj.cSo();
        this.lPj.setVoiceModel(null);
        m sv = this.fDN.sv(6);
        if (sv != null && sv.fDH != null) {
            sv.fDH.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dLx();
    }

    private void dZQ() {
        com.baidu.tieba.frs.ad At = ac.cHd().At(1);
        if (At != null) {
            this.gOR = At.jjK;
            if (this.gOR != null && !this.gOR.isEmpty() && this.oeA >= 0) {
                this.oez = new ab();
                this.oez.jjG = 0;
                this.oez.name = getPageContext().getResources().getString(R.string.category_auto);
                this.oeC = this.oez.jjG;
                this.oeB = this.oez.name;
                for (ab abVar : this.gOR) {
                    if (abVar.jjG == this.oeA) {
                        this.oeC = abVar.jjG;
                        this.oeB = abVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dZR() {
        if (this.gOR != null && !this.gOR.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.oeD = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.oeD.setText(this.oeB);
            this.oeD.setCategoryContainerData(this.gOR, this.oez, this.oeC);
            this.oeD.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bc bcVar) {
                    if (bcVar != null) {
                        WriteActivity.this.oeD.setText(bcVar.name);
                        WriteActivity.this.ngI.setCategoryTo(bcVar.jjG);
                        WriteActivity.this.oeC = bcVar.jjG;
                        WriteActivity.this.oeD.dZg();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.oeD.dZf();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dZX());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dZW());
                }
            });
        }
    }

    private void eay() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.oeT = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.oeT.setTitle(R.string.no_disturb_start_time);
        this.oeT.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.oeT);
        this.oeT.setButton(-2, getPageContext().getString(R.string.cancel), this.oeT);
        return this.oeT;
    }

    private void dZS() {
        this.oev = (RelativeLayout) findViewById(R.id.addition_container);
        this.oew = (TextView) findViewById(R.id.addition_create_time);
        this.oex = (TextView) findViewById(R.id.addition_last_time);
        this.oey = (TextView) findViewById(R.id.addition_last_content);
        if (this.oeu != null) {
            this.oev.setVisibility(0);
            this.oew.setText(getPageContext().getString(R.string.write_addition_create) + at.getFormatTime(this.oeu.getCreateTime() * 1000));
            if (this.oeu.getAlreadyCount() == 0) {
                this.oex.setVisibility(8);
            } else {
                this.oex.setText(getPageContext().getString(R.string.write_addition_last) + at.getFormatTime(this.oeu.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.oeu.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.oey.setText(lastAdditionContent);
            } else {
                this.oey.setVisibility(8);
            }
            dZW().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.oeu.getAlreadyCount()), Integer.valueOf(this.oeu.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.oev.setVisibility(8);
    }

    private void dLv() {
        this.nhi = findViewById(R.id.post_prefix_layout);
        if (this.ofM == null) {
            this.ofM = new com.baidu.tieba.c.e(getPageContext(), this.nhi);
            this.ofM.fP(R.drawable.bg_tip_blue_up_left);
            this.ofM.fO(16);
            this.ofM.pD(true);
            this.ofM.setUseDirectOffset(true);
            this.ofM.yH(l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.nhf = (TextView) findViewById(R.id.post_prefix);
        this.oer = findViewById(R.id.prefix_divider);
        this.nhh = (ImageView) findViewById(R.id.prefix_icon);
        eaz();
    }

    private void eaz() {
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.nhi.setVisibility(0);
            this.oer.setVisibility(0);
            this.ofM.C(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.ngJ = 0;
            this.nhi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c13013").dX("fid", WriteActivity.this.ngI.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.nhf.setVisibility(0);
                    WriteActivity.this.nhi.setSelected(true);
                    SvgManager.bwq().a(WriteActivity.this.nhh, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.nhg, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.fDN.bDe();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.nha);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.oep);
                }
            });
            this.nhf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c13013").dX("fid", WriteActivity.this.ngI.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.nhf.setSelected(true);
                    SvgManager.bwq().a(WriteActivity.this.nhh, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.nhg, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.fDN.bDe();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dZX());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dZW());
                }
            });
            this.nhg = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.nhg.a(this);
            this.nhg.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.nhg.setOutsideTouchable(true);
            this.nhg.setFocusable(true);
            this.nhg.setOnDismissListener(this);
            this.nhg.setBackgroundDrawable(ao.getDrawable(R.color.CAM_X0201));
            int color = ao.getColor(R.color.CAM_X0105);
            ao.getColor(R.color.CAM_X0108);
            SvgManager.bwq().a(this.nhh, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.nhf).pC(R.color.CAM_X0105).pE(R.string.F_X02).setBackGroundColor(R.color.CAM_X0201);
            this.oes.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.oes.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.zg(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.zg(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.nhg.addView(writePrefixItemLayout);
            }
            this.nhg.setCurrentIndex(0);
            this.nhf.setText(prefixs.get(0));
            MM(0);
            return;
        }
        this.nhi.setVisibility(8);
        this.oer.setVisibility(8);
    }

    private void eaA() {
        if (this.oeZ && this.ngI != null) {
            this.ofg.setVisibility(0);
            this.ofh.setVisibility(0);
            this.oeq = new FeedBackModel(getPageContext());
            this.oeq.Vv(this.ngI.getForumName());
            this.oeq.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.ofg.setVisibility(8);
                        WriteActivity.this.ofh.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.ofg.setVisibility(8);
                        WriteActivity.this.ofh.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.ofg.a(feedBackModel.dZq(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void dZT() {
        this.lPZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.41
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.ofO == null || WriteActivity.this.ofP != null) {
                    if (WriteActivity.this.eaU()) {
                        if (!WriteActivity.this.ogn || WriteActivity.this.ogm) {
                            if (WriteActivity.this.eaW()) {
                                int eaV = WriteActivity.this.eaV();
                                if (eaV == 1) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_commodity));
                                    return;
                                } else if (eaV == 2) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_haowu_tab));
                                    return;
                                }
                            }
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                WriteActivity.this.showToast(R.string.neterror);
                            }
                            if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                                if (WriteActivity.this.oeK.a(WriteActivity.this.nha, WriteActivity.this.oep)) {
                                    WriteActivity.this.showToast(WriteActivity.this.oeK.dXU());
                                    return;
                                }
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dZX());
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dZW());
                                WriteActivity.this.fDN.bDe();
                                if (WriteActivity.this.ngI.getType() != 7) {
                                    if (WriteActivity.this.oeZ) {
                                        WriteActivity.this.cJv();
                                        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                                    } else {
                                        aq aqVar = new aq("c12102");
                                        aqVar.an("obj_type", StringUtils.isNull(WriteActivity.this.ngI.getForumName()) ? 1 : 2);
                                        TiebaStatic.log(aqVar);
                                        WriteActivity.this.ead();
                                    }
                                } else {
                                    TiebaStatic.log("c12015");
                                    WriteActivity.this.cJv();
                                }
                                MercatorModel.dQi().startLoad();
                                TiebaStatic.log(new aq("c12262").dX("obj_locate", WriteActivity.this.jLR));
                                return;
                            }
                            return;
                        }
                        WriteActivity.this.showToast(WriteActivity.this.getResources().getString(R.string.publish_faile_toast));
                        return;
                    }
                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_cant_but_commodity));
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectForumConfig(WriteActivity.this)));
            }
        });
    }

    protected void dLw() {
        this.ofd = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.ofd.setIsRound(true);
        this.ofd.setDrawBorder(false);
        this.ofd.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String BQ = q.BQ(currentPortrait);
            this.ofd.setUrl(BQ);
            this.ofd.startLoad(BQ, 12, false);
        }
        if (this.ngI.isUserFeedback()) {
            this.ofd.setVisibility(0);
        }
        this.nha = (EditText) findViewById(R.id.post_title);
        this.nha.setOnClickListener(this.oeP);
        this.nha.setOnFocusChangeListener(this.hxA);
        if (this.ngI.getType() == 0 || this.ngI.getType() == 9 || this.ngI.getType() == 11 || this.ngI.getType() == 7) {
            if (this.ngI.getTitle() != null) {
                this.nha.setText(this.ngI.getTitle());
                this.nha.setSelection(this.ngI.getTitle().length());
            } else if (this.ofb) {
                this.nha.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.ngI.getType() == 1 || this.ngI.getType() != 2) {
        }
        this.nha.addTextChangedListener(this.oeR);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.nha).pE(R.string.F_X02);
        if (!this.ngI.getHaveDraft()) {
            dZP();
            this.ofK = true;
        }
        this.ofc = (TitleTipView) findViewById(R.id.post_title_tip);
    }

    private TextWatcher aAg() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.42
            private EditText cDt = null;
            private TextView mTextView = null;
            private int ogB;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.dLx();
                if (WriteActivity.this.oeF) {
                    this.ogB = this.cDt.getSelectionStart();
                    this.cDt.setSelection(this.ogB);
                    WriteActivity.this.a(this.mTextView, this.cDt);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.oeF || !WriteActivity.this.ofB) {
                    if (WriteActivity.this.oeF) {
                        if (this.cDt != WriteActivity.this.ofs || this.mTextView != WriteActivity.this.ofy) {
                            this.cDt = WriteActivity.this.ofs;
                            this.mTextView = WriteActivity.this.ofy;
                        }
                    }
                } else if (this.cDt != WriteActivity.this.ofw || this.mTextView != WriteActivity.this.ofx) {
                    this.cDt = WriteActivity.this.ofw;
                    this.mTextView = WriteActivity.this.ofx;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.oeF && this.ofB) {
            if (this.ofz != null) {
                this.ofw.removeTextChangedListener(this.ofz);
            }
            this.ofz = textWatcher;
        } else if (this.oeF) {
            if (this.ofA != null) {
                this.ofs.removeTextChangedListener(this.ofA);
            }
            this.ofA = textWatcher;
        }
        return textWatcher;
    }

    private long k(EditText editText) {
        if (editText == this.ofs) {
            return 233L;
        }
        if (editText != this.ofw) {
            return 0L;
        }
        return 20L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, EditText editText) {
        if (textView != null && editText != null) {
            long k = k(editText);
            long l = k - l(editText);
            String valueOf = String.valueOf(l);
            if (k == 20) {
                if (l < 0) {
                    if (l < -9) {
                        valueOf = "-∞";
                    }
                    textView.setTextColor(ao.getColor(R.color.common_color_10159));
                } else {
                    textView.setTextColor(ao.getColor(R.color.CAM_X0109));
                }
            } else if (l < 0) {
                if (l < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(ao.getColor(R.color.common_color_10159));
            } else {
                textView.setTextColor(ao.getColor(R.color.CAM_X0109));
            }
            textView.setText(valueOf);
        }
    }

    private long l(EditText editText) {
        return com.baidu.tieba.write.b.a.v(editText.getText().toString().trim());
    }

    protected void dLy() {
        this.oep = (SpanGroupEditText) findViewById(R.id.post_content);
        this.oep.setDrawingCacheEnabled(false);
        this.oep.setOnClickListener(this.oeP);
        this.oep.setOnSpanGroupChangedListener(new a.InterfaceC0585a() { // from class: com.baidu.tieba.write.write.WriteActivity.43
            @Override // com.baidu.tbadk.core.view.spanGroup.a.InterfaceC0585a
            public void G(int i, boolean z) {
                WriteActivity.this.MU();
            }
        });
        this.oep.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
        this.oep.setForumId(com.baidu.adp.lib.f.b.toLong(this.ngI.getForumId(), 0L));
        if (this.ofn != null) {
            this.ofn.setSpanGroupManager(this.oep.getSpanGroupManager());
        }
        if (this.ngI != null) {
            this.ngI.setSpanGroupManager(this.oep.getSpanGroupManager());
        }
        if (this.ngI.getContent() != null && this.ngI.getContent().length() > 0) {
            this.oep.setText(TbFaceManager.bGo().aE(getPageContext().getPageActivity(), this.ngI.getContent()));
            if (this.oep.getText() != null) {
                this.oep.setSelection(this.oep.getText().length());
            }
        } else if (this.ngI.getType() == 2) {
            if (this.ofk) {
                if (this.ofl != null && this.ofl.length() > 0) {
                    this.oep.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.ofl}));
                    this.oep.setSelection(this.oep.getText().length());
                }
            } else if (this.ngI.getFloorNum() > 0) {
                this.oep.setText(String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.ngI.getFloorNum())));
                this.oep.setSelection(this.oep.getText().length());
            }
        }
        this.oep.setOnFocusChangeListener(this.hxA);
        this.oep.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.fDN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.oep.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.oep.addTextChangedListener(this.oeS);
        if (this.ngI.getType() == 0) {
            this.ofL = true;
        } else {
            zt(true);
            this.ofL = false;
        }
        if (this.isEvaluate) {
            SpannableString spannableString = new SpannableString(" " + ((Object) getResources().getText(R.string.write_evalute_hint)));
            Drawable a2 = WebPManager.a(R.drawable.icon_pure_post_redact16, ao.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL);
            a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
            spannableString.setSpan(new com.baidu.tieba.face.view.a(a2, 1, l.getDimens(this, R.dimen.tbds4)), 0, 1, 17);
            this.oep.setHint(spannableString);
        } else if (this.ngI.isUserFeedback()) {
            this.oep.setHint(R.string.write_input_content);
        } else {
            this.oep.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void zt(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.oeF && dZW() != null) {
            dZW().setPadding(0, 0, 0, 0);
            dZW().setBackgroundDrawable(null);
            ao.setBackgroundColor(dZW(), R.color.CAM_X0201);
            if (TextUtils.isEmpty(this.lhT) || this.oeu != null) {
                return;
            }
            if (this.ofT == null || !this.ofT.isVisible()) {
                com.baidu.adp.lib.e.d.mx().a(this.lhT, 19, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.46
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.c
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass46) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            if (WriteActivity.this.ofT == null || !WriteActivity.this.ofT.isVisible()) {
                                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                                }
                                WriteActivity.this.dZW().setBackgroundDrawable(ninePatchDrawable);
                                if (z) {
                                    com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.dZW(), true, WriteActivity.this.lWk);
                                }
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, true));
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, false));
                        }
                    }
                }, getUniqueId());
            }
        }
    }

    private void eaB() {
        if (dZW() != null) {
            dZW().setPadding(0, 0, 0, 0);
            dZW().setBackgroundDrawable(null);
            ao.setBackgroundColor(dZW(), R.color.CAM_X0201);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dZV() {
        int i = 5000;
        if (this.oeu != null) {
            i = 1000;
        }
        return dZW().getText() != null && dZW().getText().length() >= i;
    }

    private void DN(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.oej)) {
                this.oej = "";
                dZW().requestFocus();
                if (dZW().getText() != null && dZW().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dZW().getSelectionStart();
                    editable = dZW().getText();
                }
            } else if ("from_title".equals(this.oej)) {
                this.oej = "";
                dZX().requestFocus();
                if (dZX().getText() != null && dZX().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dZX().getSelectionStart();
                    editable = dZX().getText();
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
    public void zq(boolean z) {
        if (!com.baidu.tbadk.plugins.b.k(getPageContext())) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.ngI != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.ngI.getForumId(), 0L), this.ngI.getFirstDir(), this.ngI.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(com.baidu.tbadk.coreExtra.data.u uVar) {
        if (((ImageSpan[]) dZW().getText().getSpans(0, dZW().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.oet == null) {
                this.oet = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            this.oet.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, dZW());
    }

    EditText dZW() {
        return this.oeF ? this.ofs : this.oep;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dZX() {
        return this.oeF ? this.ofw : this.nha;
    }

    protected void dZY() {
        if (dZW().getSelectionStart() > 0) {
            String substring = dZW().getText().toString().substring(0, dZW().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.iRk.matcher(substring);
            if (matcher.find()) {
                dZW().getText().delete(dZW().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dZW().getSelectionStart());
                return;
            }
            dZW().onKeyDown(67, this.iRl);
        }
    }

    private void v(Boolean bool) {
        String str = null;
        if (this.ngI != null) {
            str = this.ngI.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.oeZ = true;
        }
    }

    private void eaC() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void eaD() {
        this.ofV = (RelativeLayout) this.mRootView.findViewById(R.id.vote_layout_root);
        this.ofU = new com.baidu.tieba.write.write.vote.a(getPageContext(), this.ofV);
        eap();
    }

    private void bVm() {
        this.mListView = (ListView) this.mRootView.findViewById(R.id.commodity_list);
        this.ogg = new d(getPageContext());
        this.ogg.a(this.ogf);
        this.mListView.setAdapter((ListAdapter) this.ogg);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.48
            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v12, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (WriteActivity.this.ogg != null && (WriteActivity.this.ogg.getItem(i) instanceof u)) {
                    u uVar = (u) WriteActivity.this.ogg.getItem(i);
                    if (uVar.mType == 1) {
                        if (uVar.ePs == 1) {
                            be.bwu().b(WriteActivity.this.getPageContext(), new String[]{uVar.ePk});
                        } else {
                            be.bwu().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(uVar.ePk)});
                        }
                    } else if (uVar.mType == 2) {
                        if (!TextUtils.isEmpty(uVar.ePn)) {
                            if (uVar.ePn.startsWith("tiebaclient://")) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, uVar.ePn));
                                return;
                            }
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(uVar.ePn));
                            intent.addFlags(268468224);
                            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                                WriteActivity.this.startActivity(intent);
                            } else if (!TextUtils.isEmpty(uVar.ePo)) {
                                be.bwu().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(uVar.ePo)});
                            }
                        } else if (!TextUtils.isEmpty(uVar.ePo)) {
                            be.bwu().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(uVar.ePo)});
                        }
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fOA.setCancelListener(null);
        this.fOA.setTipString(R.string.sending);
        this.fOA.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.fOA != null) {
            this.fOA.setDialogVisiable(false);
        }
    }

    private Boolean eaE() {
        return Boolean.valueOf(this.ofm);
    }

    public void dLx() {
        this.ofW = false;
        if (this.ngI != null) {
            String str = "";
            String str2 = "";
            if (dZX() != null) {
                str = dZX().getText().toString();
            }
            if (dZW() != null) {
                str2 = dZW().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.ngI.getType() == 0 || this.ngI.getType() == 9 || this.ngI.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.ngJ == x.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.ngI.setIsNoTitle(true);
                        } else if (this.oeo.getVisibility() == 0) {
                            this.ngI.setIsNoTitle(false);
                            zr(true);
                            return;
                        }
                    } else if (this.oeo.getVisibility() == 0) {
                        this.ngI.setIsNoTitle(false);
                        zr(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.ngI.setIsNoTitle(true);
                } else if (this.oeo.getVisibility() == 0) {
                    this.ngI.setIsNoTitle(false);
                    zr(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.oeF) {
                    zr(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    zr(true);
                }
            }
            if (this.ngI.getType() == 4) {
                zr(n(this.ofs) && m(this.ofw));
            } else if (this.ngI.getType() == 5) {
                zr(n(this.ofs));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                zr(true);
            } else if (this.ngI.getVideoInfo() != null) {
                zr(this.ngI.getVideoInfo().isVideoMixFinished());
            } else if (eaS()) {
                zr(true);
                this.ofW = true;
            } else {
                zr(false);
            }
        }
    }

    public void zr(boolean z) {
        if (!z || !this.isEvaluate || (this.oep != null && !TextUtils.isEmpty(this.oep.getText()) && this.oep.getText().length() >= 20 && this.oep.getText().length() <= 500 && this.ofQ != null && this.ofQ.dZj())) {
            this.lPZ.setEnabled(z);
        }
    }

    private boolean m(EditText editText) {
        long l = l(editText);
        return l <= 20 && l > 0;
    }

    private boolean n(EditText editText) {
        long l = l(editText);
        if (l > 233) {
            return false;
        }
        return l > 0 || this.writeImagesInfo.size() >= 1;
    }

    private void initData(Bundle bundle) {
        this.ofn = com.baidu.tieba.tbadkCore.writeModel.a.dQA();
        this.ofn.a(this);
        this.ngI = new WriteData();
        if (bundle != null) {
            this.ngI.setType(bundle.getInt("type", 0));
            this.ngI.setForumId(bundle.getString("forum_id"));
            this.ngI.setForumName(bundle.getString("forum_name"));
            this.ngI.setFirstDir(bundle.getString("forum_first_dir"));
            this.ngI.setSecondDir(bundle.getString("forum_second_dir"));
            this.ngI.setThreadId(bundle.getString("thread_id"));
            this.ngI.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.ngI.setFloorNum(bundle.getInt("floor_num", 0));
            this.ngI.setVideoInfo((VideoInfo) bundle.getSerializable(WriteActivityConfig.VIDEO_INFO));
            String string = bundle.getString("addition_data");
            if (!StringUtils.isNull(string)) {
                this.oeu = (AdditionData) OrmObject.objectWithJsonStr(string, AdditionData.class);
            }
            this.ngI.setIsAddition(this.oeu != null);
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.ngI.setTopicId(this.mTopicId);
            this.ngI.setTitle(bundle.getString("write_title"));
            this.ngI.setContent(bundle.getString("write_content"));
            this.ngI.setStatisticFrom(bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
            this.oeZ = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.ofa = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.ofb = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.ofk = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.ofl = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.oge = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.fFY = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string2)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string2, PostPrefixData.class);
            }
            String string3 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string3)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string3, PostTopicData.class);
            }
            this.mFrom = bundle.getString("from");
            this.privateThread = bundle.getInt("private_thread", -1);
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.jLR = bundle.getString("KEY_CALL_FROM");
            this.bMh = bundle.getInt("album_thread");
            this.nYG = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.canGoods = bundle.getBoolean(WriteActivityConfig.CAN_GOODS);
        } else {
            Intent intent = getIntent();
            this.ngI.setType(intent.getIntExtra("type", 9));
            this.ngI.setForumId(intent.getStringExtra("forum_id"));
            this.ngI.setForumName(intent.getStringExtra("forum_name"));
            this.ngI.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.ngI.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.ngI.setThreadId(intent.getStringExtra("thread_id"));
            this.ngI.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.ngI.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.oeu = (AdditionData) intent.getSerializableExtra("addition_data");
            this.ngI.setIsAddition(this.oeu != null);
            this.ngI.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.ngI.setTitle(intent.getStringExtra("write_title"));
            this.ngI.setContent(intent.getStringExtra("write_content"));
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.ngI.setTopicId(this.mTopicId);
            this.ngI.setVideoInfo((VideoInfo) intent.getSerializableExtra(WriteActivityConfig.VIDEO_INFO));
            this.ngI.setStatisticFrom(intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
            this.oeZ = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.ofa = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.ofb = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.ofk = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.ofl = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.jdc = intent.getStringExtra("more_forum_img");
            this.jdd = intent.getStringExtra("more_forum_title");
            this.jdb = intent.getStringExtra("more_forum_url");
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.jLR = intent.getStringExtra("KEY_CALL_FROM");
            this.bMh = intent.getIntExtra("album_thread", 0);
            this.oge = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.nYG = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.ngI.setFrsTabInfoData(this.nYG);
            this.canGoods = intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false);
            this.isEvaluate = getIntent().getBooleanExtra(IntentConfig.IS_EVALUATE, false);
            this.ngI.setIsEvaluate(this.isEvaluate);
            this.ofY = getIntent().getBooleanExtra(IntentConfig.IS_ITEM_DETAIL, false);
            this.ofZ = getIntent().getIntExtra(WriteActivityConfig.STAR_COUNT, 0);
            Serializable serializableExtra = getIntent().getSerializableExtra("item_info");
            if (serializableExtra instanceof SerializableItemInfo) {
                this.ofX = (SerializableItemInfo) serializableExtra;
                this.ngI.setItem_id(String.valueOf(this.ofX.id));
            }
            this.jsH = getIntent().getBooleanExtra("item_is_school", false);
            this.oga = getIntent().getBooleanExtra("need_save_draft", true);
            this.ogb = getIntent().getBooleanExtra(WriteActivityConfig.IS_FROM_ERROR_DIALOG, false);
            this.oeA = getIntent().getIntExtra("category_id", -1);
            this.ogc = getIntent().getStringExtra("goods_list");
            this.ogd = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
            this.ofm = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
            this.fGe = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            if (this.ogb && com.baidu.tieba.tbadkCore.writeModel.c.nvI != null) {
                this.ngI = com.baidu.tieba.tbadkCore.writeModel.c.nvI;
                this.ngI.setType(9);
                this.ngI.setContent(this.ngI.getContentString());
                this.writeImagesInfo = this.ngI.getWriteImagesInfo();
                this.nYG = this.ngI.getFrsTabInfoData();
                if (this.ngI.getItemInfo() != null) {
                    this.ofX = null;
                }
                this.mVoiceModel = this.ngI.getVoiceModel();
            }
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.ngI.getType() == 9) {
            this.ngI.setEntranceType(1);
        } else if (this.ngI.getType() == 10) {
            this.ngI.setEntranceType(2);
            this.ngI.setType(9);
        } else if (this.ngI.getType() == 0) {
            this.ngI.setEntranceType(3);
        }
        this.ngI.setIsUserFeedback(this.oeZ);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (this.oge != null) {
            this.writeImagesInfo.parseJson(this.oge);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.ngI.getType() == 4 ? 6 : 9);
        this.ngI.setWriteImagesInfo(this.writeImagesInfo);
        this.lhT = TbadkCoreApplication.getInst().getDefaultBubble();
        dZQ();
        if (this.ngI.getType() == 0 || this.ngI.getType() == 9 || this.ngI.getType() == 11) {
            if (this.oga) {
                if (this.ngI.isEvaluate()) {
                    y.c(this.ngI.getItem_id(), this);
                } else if (TextUtils.isEmpty(this.ngI.getTopicId())) {
                    y.b(this.ngI.getForumId(), this);
                } else {
                    y.d(this.ngI.getTopicId(), this);
                }
            }
        } else if (this.ngI.getType() == 7) {
            if (this.oga) {
                y.b("24591571", this);
            }
        } else if (this.ngI.getType() == 1) {
            y.a(this.ngI.getThreadId(), this);
        } else if (this.ngI.getType() == 4) {
            y.b(this.ngI.getForumId() + "photolive", this);
        } else if (this.ngI.getType() == 5) {
            y.a(this.ngI.getThreadId() + "updatephotolive", this);
        }
        if (this.ngI != null && this.ngI.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.ngI.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.oem = true;
        }
        try {
            this.ofC = eaP();
        } catch (Throwable th) {
            this.ofC = null;
        }
    }

    private void eaF() {
        this.mNavigationBar.postDelayed(this.ogx, 500L);
    }

    private void dZZ() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) x.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.nha.setText(com.baidu.tbadk.plugins.b.Ev(com.baidu.tbadk.plugins.b.Ew(hotTopicBussinessData.mTopicName)));
            this.nha.setMovementMethod(com.baidu.tieba.view.c.dXv());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) x.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString Ev = com.baidu.tbadk.plugins.b.Ev(com.baidu.tbadk.plugins.b.Ew(hotTopicBussinessData.mTopicName));
            if (Ev != null) {
                this.nha.setText(Ev);
            }
            this.oeH.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.y.a
    public void b(WriteData writeData) {
        int i = 0;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !this.ogn && !this.ogb) {
            if (writeData != null) {
                if (this.ngI != null && writeData.isEvaluate() == this.ngI.isEvaluate()) {
                    boolean z = this.ngI.getVideoInfo() != null && this.ngI.getVideoInfo().isEditVideoDataLegal();
                    boolean z2 = (this.ngI.getWriteImagesInfo() == null || x.isEmpty(this.ngI.getWriteImagesInfo().getChosedFiles())) ? false : true;
                    boolean z3 = !com.baidu.adp.lib.util.k.isEmpty(dZX().getText().toString());
                    boolean z4 = !com.baidu.adp.lib.util.k.isEmpty(dZW().getText().toString());
                    boolean z5 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle());
                    boolean z6 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent());
                    boolean z7 = at.isEmpty(writeData.getTitle()) && !e(TbFaceManager.bGo().a(getPageContext().getPageActivity(), writeData.getContent(), this.oeN));
                    if (!z || z7) {
                        this.ngI.setHaveDraft(true);
                        if (!z2 && !z) {
                            i(writeData);
                        }
                        if (!z && (!z3 || this.ofK || ((this.oeZ || this.oem) && z5))) {
                            j(writeData);
                        }
                        if (z6 && (!z4 || this.oeZ || this.oem)) {
                            k(writeData);
                        }
                        if (this.ngI != null && !this.ngI.getHaveDraft()) {
                            dZP();
                        }
                        if (writeData.getItemInfo() != null) {
                            this.ngI.setItemInfo(writeData.getItemInfo());
                            this.ngI.setEvaluationStar(writeData.getEvaluationStar());
                            this.ofX = null;
                            eat();
                        }
                        if (writeData.getVoiceModel() != null) {
                            f(writeData.getVoiceModel());
                        }
                        if (writeData.getType() == 4 || writeData.getType() == 5) {
                            eaG();
                        }
                        dLx();
                        int categoryTo = writeData.getCategoryTo();
                        if (categoryTo >= 0 && this.gOR != null) {
                            this.oeC = this.oez.jjG;
                            this.oeB = this.oez.name;
                            while (true) {
                                if (i == this.gOR.size()) {
                                    break;
                                }
                                ab abVar = this.gOR.get(i);
                                if (categoryTo != abVar.jjG) {
                                    i++;
                                } else {
                                    this.oeC = categoryTo;
                                    this.oeB = abVar.name;
                                    this.ngI.setCategoryTo(this.oeC);
                                    break;
                                }
                            }
                            if (this.oeD != null) {
                                this.oeD.setText(this.oeB);
                                this.oeD.setCategoryContainerData(this.gOR, this.oez, this.oeC);
                            }
                        }
                        this.fDN.bDe();
                        return;
                    }
                    return;
                }
                return;
            }
            eaG();
            dZP();
        }
    }

    private void i(WriteData writeData) {
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(writeData.getVideoInfo());
            this.ngI.setVideoInfo(videoInfo);
            aD(false, true);
            return;
        }
        if (writeData.getWriteImagesInfo() != null) {
            this.writeImagesInfo = writeData.getWriteImagesInfo();
        }
        this.ngI.setWriteImagesInfo(this.writeImagesInfo);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            eaf();
        }
        zu(false);
        aD(true, true);
    }

    private void j(WriteData writeData) {
        String str;
        String Ew;
        if (com.baidu.adp.lib.util.k.isEmpty(this.ngI.getTitle())) {
            this.ngI.setTitle(writeData.getTitle());
        }
        if (!x.isEmpty(this.mList)) {
            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) x.getItem(this.mList, 0);
            if (hotTopicBussinessData == null) {
                str = null;
            } else {
                str = hotTopicBussinessData.mTopicName;
            }
            if (StringUtils.isNull(str)) {
                Ew = this.ngI.getTitle();
            } else {
                Ew = com.baidu.tbadk.plugins.b.Ew(str);
            }
            SpannableString Ev = com.baidu.tbadk.plugins.b.Ev(Ew);
            if (Ev != null) {
                dZX().setText(Ev);
                dZX().setSelection(Ev.length() > Ew.length() ? Ew.length() : Ev.length());
                return;
            }
            return;
        }
        SpannableString Ev2 = com.baidu.tbadk.plugins.b.Ev(this.ngI.getTitle());
        if (Ev2 != null) {
            dZX().setText(Ev2);
            dZX().setSelection(this.ngI.getTitle().length() > Ev2.length() ? Ev2.length() : this.ngI.getTitle().length());
        }
    }

    private void k(WriteData writeData) {
        this.ngI.setContent(writeData.getContent());
        SpannableString a2 = TbFaceManager.bGo().a(getPageContext().getPageActivity(), this.ngI.getContent(), this.oeN);
        InputFilter[] filters = this.oep.getFilters();
        this.oep.setFilters(new InputFilter[]{new InputFilter.LengthFilter(IMConstants.ERROR_BASE)});
        dZW().setText(a2);
        if (dZW() == this.oep && this.oep.getSpanGroupManager() != null) {
            this.oep.byz();
            this.oep.getSpanGroupManager().byF();
            this.oep.byA();
            MU();
        }
        this.oep.setFilters(filters);
        if (dZW().getText() != null) {
            dZW().setSelection(dZW().getText().length());
        }
        if (this.oeF) {
            a(this.ofy, this.ofs);
        }
    }

    private void eaG() {
        if ((!this.oeF || this.ofr != null) && this.ofq != null) {
            this.ofr.b(this.writeImagesInfo);
            eaL();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.ngI.getType());
        bundle.putString("forum_id", this.ngI.getForumId());
        bundle.putString("forum_name", this.ngI.getForumName());
        bundle.putString("forum_first_dir", this.ngI.getFirstDir());
        bundle.putString("forum_second_dir", this.ngI.getSecondDir());
        bundle.putString("thread_id", this.ngI.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.ngI.getFloor());
        bundle.putInt("floor_num", this.ngI.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.ofk);
        if (this.oeZ) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.fFY);
        if (this.oeu != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.oeu));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jLR);
        bundle.putInt("album_thread", this.bMh);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.nYG);
        bundle.putBoolean(WriteActivityConfig.CAN_GOODS, this.canGoods);
        bundle.putInt(WriteActivityConfig.KEY_STATISTIS_FROM, this.ngI.getStatisticFrom());
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dZW().getEditableText().toString();
        if (obj != null) {
            dZW().setText(TbFaceManager.bGo().a(getPageContext().getPageActivity(), obj, this.oeN));
            dZW().setSelection(dZW().getText().length());
        }
    }

    private String getContent() {
        return (dZW() == null || dZW().getText() == null) ? "" : dZW().getText().toString();
    }

    private String eab() {
        if (this.ngI == null || dZX() == null || dZX().getVisibility() != 0 || dZX().getText() == null) {
            return "";
        }
        String obj = dZX().getText().toString();
        if (this.mPrefixData != null && x.getCount(this.mPrefixData.getPrefixs()) > 0 && this.ngJ != x.getCount(this.mPrefixData.getPrefixs()) - 1 && this.ngI.getType() != 4 && this.nhf != null && this.nhf.getText() != null) {
            this.ngI.setPostPrefix(this.nhf.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.ngI.getTitle();
        }
        return obj;
    }

    private void Vw(String str) {
        if (this.ngI != null && this.oeo != null) {
            if (this.oeo.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.ngI.setIsNoTitle(true);
                    this.ngI.setTitle("");
                    return;
                }
                this.ngI.setIsNoTitle(false);
                this.ngI.setTitle(str);
                return;
            }
            this.ngI.setIsNoTitle(true);
            this.ngI.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJv() {
        dLp();
        this.ngI.setContent(getContent());
        Vw(eab());
        if (this.oeZ || this.oem) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.ngI.getTitle()) || !this.ngI.getTitle().startsWith(string)) {
                Vw(string + this.ngI.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.ngI.getContent()) || !this.ngI.getContent().startsWith(str)) {
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
                sb.append(this.ngI.getContent());
                this.ngI.setContent(sb.toString());
            }
        }
        if (this.ofa) {
            this.ngI.setZhongcePrefix(String.format(getResources().getString(R.string.homepage_test_post_suffix), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), com.baidu.adp.lib.util.j.netTypeNameInUpperCase(), Build.VERSION.RELEASE));
        }
        if (this.oeA >= 0) {
            this.ngI.setCategoryFrom(this.oeA);
        }
        if (this.oeC >= 0) {
            this.ngI.setCategoryTo(this.oeC);
        }
        this.ngI.setWriteImagesInfo(this.writeImagesInfo);
        if (this.ofU != null) {
            this.ngI.setWriteVoteData(this.ofU.getWriteVoteData());
        }
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
            this.ngI.setTakePhotoNum(i);
        }
        this.ngI.setHasLocationData(this.fFZ != null && this.fFZ.cot());
        if (this.writeImagesInfo != null) {
            this.ofn.yp(this.writeImagesInfo.size() > 0);
        }
        if (!x.isEmpty(this.mList) && this.oeG != null && this.oeG.mIsGlobalBlock == 0) {
            this.ngI.setForumId(String.valueOf(this.oeG.mForumId));
            this.ngI.setForumName(this.oeG.mForumName);
        }
        if (this.ofQ != null && this.ofQ.getEvaluateItemInfo() != null) {
            this.ngI.setItem_id(this.ofQ.getEvaluateItemInfo().getItemID());
            this.ngI.setComment_head(cJu());
        }
        eac();
        this.ofn.f(this.ngI);
        this.ngI.setContent(this.ngI.getContent().replaceAll("\u0000\n", ""));
        this.ngI.setContent(this.ngI.getContent().replaceAll("\u0000", ""));
        this.ngI.setVcode(null);
        this.ngI.setVoiceModel(this.mVoiceModel);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.ofn.dco().setVoice(this.mVoiceModel.getId());
                this.ofn.dco().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.ofn.dco().setVoice(null);
                this.ofn.dco().setVoiceDuringTime(-1);
            }
        } else {
            this.ofn.dco().setVoice(null);
            this.ofn.dco().setVoiceDuringTime(-1);
        }
        if (!this.ofn.dQD()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else {
            eaH();
        }
    }

    private void eaH() {
        this.ofn.dQB();
        com.baidu.tieba.write.b.b.g(this.ngI);
        cFz();
        eaq();
        setResult(100);
        finish();
    }

    private void eac() {
        if (this.ngI != null && this.oeM != null) {
            this.ngI.setIsForumBusinessAccount(this.nYG == null ? false : this.nYG.isForumBusinessAccount);
            FrsTabItemData selectedTabItemData = this.oeM.getSelectedTabItemData();
            if (selectedTabItemData != null) {
                this.ngI.setTabId(selectedTabItemData.tabId);
                this.ngI.setTabName(selectedTabItemData.name);
                this.ngI.setIsGeneralTab(selectedTabItemData.isGeneralTab);
            }
        }
    }

    private void I(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.oeu != null) {
                i2 = this.oeu.getTotalCount();
                i = this.oeu.getAlreadyCount() + 1;
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
                if (this.nha == getCurrentFocus()) {
                    dZW().clearFocus();
                    this.nha.requestFocus();
                    if (this.fDN != null) {
                        this.fDN.bDe();
                    }
                    ShowSoftKeyPadDelay(this.nha);
                } else {
                    dZW().requestFocus();
                    if (this.fDN != null) {
                        this.fDN.bDe();
                    }
                    ShowSoftKeyPadDelay(this.oep);
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
                            dZW().getText().insert(dZW().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                cJs();
                dQI();
                j(postWriteCallBackData2);
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
                                eaM();
                            } else {
                                aq(intent);
                            }
                        } else if (intExtra == 1) {
                            ar(intent);
                        } else {
                            ao(intent);
                            com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.50
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        aD(x.getCount(this.writeImagesInfo.getChosedFiles()) > 0, false);
                        if (this.ofL) {
                            zt(true);
                            this.ofL = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.oeF) {
                        G(intent);
                        dLx();
                        return;
                    }
                    ap(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.ngI.setVideoInfo(videoInfo);
                        this.fDN.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.fDN.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.fDN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    dLx();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.oek) {
                                sb2.append(com.baidu.tbadk.plugins.b.fNU);
                                this.oek = false;
                            }
                            sb2.append(stringExtra);
                            DN(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !x.isEmpty(this.mList)) {
                    if (!x.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                        this.oeG = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                        a(this.oeG);
                    }
                } else if (i == 25048) {
                    Serializable serializableExtra = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
                    if (serializableExtra instanceof WriteVoteData) {
                        this.ogd = serializableExtra;
                        eap();
                    }
                } else if (i == 25049 && intent != null) {
                    String str = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                    int selectionStart = this.oep.getSelectionStart();
                    int selectionEnd = this.oep.getSelectionEnd();
                    if (selectionStart >= 0) {
                        Editable text = this.oep.getText();
                        if (selectionEnd > selectionStart) {
                            text.replace(selectionStart, selectionEnd, str);
                        } else {
                            text.insert(selectionStart, str);
                        }
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.fDN != null && !this.fDN.bEM()) {
                this.oep.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.fDN.bDe();
            }
            switch (i) {
                case 12001:
                    bFy();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    eaK();
                    if (this.ofL) {
                        zt(true);
                        this.ofL = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.nha == getCurrentFocus()) {
                        dZW().clearFocus();
                        this.nha.requestFocus();
                        if (this.fDN != null) {
                            this.fDN.bDe();
                        }
                        ShowSoftKeyPadDelay(this.nha);
                        return;
                    }
                    dZW().requestFocus();
                    if (this.fDN != null) {
                        this.fDN.bDe();
                    }
                    ShowSoftKeyPadDelay(this.oep);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.oeK.Vf(postWriteCallBackData.getErrorString());
                        this.oeK.bm(postWriteCallBackData.getSensitiveWords());
                        this.oeK.b(this.nha, this.oep);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.fFY = String.valueOf(System.currentTimeMillis());
                    an.c(getPageContext(), this.fFY);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    eaK();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.oej)) {
                        dZX().requestFocus();
                        return;
                    } else if ("from_content".equals(this.oej)) {
                        dZW().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ead() {
        if ("1".equals(this.jLR)) {
            this.ngI.setCanNoForum(true);
            this.ngI.setTransmitForumData("[]");
        } else if ("2".equals(this.jLR)) {
            this.ngI.setCanNoForum(false);
        }
        eae();
        this.ngI.setPrivacy(this.isPrivacy);
        eaI();
        this.ngI.setToDynamic(this.isToDynamic);
        this.ngI.setCallFrom(this.jLR);
        if (this.ngI.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cJv();
    }

    private void eae() {
        if (this.fDN != null) {
            this.fDN.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void eaI() {
        if (this.fDN != null) {
            this.fDN.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void eaJ() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void eaK() {
        if (this.oeF) {
            this.ofr.b(this.writeImagesInfo);
            eaL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaL() {
        this.ofr.notifyDataSetChanged();
        this.ofq.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.51
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.ofr.notifyDataSetChanged();
                WriteActivity.this.ofq.invalidateViews();
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
        dLx();
    }

    private void ao(Intent intent) {
        if (this.oeF) {
            ap(intent);
            eaK();
        } else {
            as(intent);
        }
        dLx();
    }

    private void ap(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            eaK();
            zu(true);
        }
    }

    private void aq(Intent intent) {
        if (this.writeImagesInfo != null) {
            F(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, size)));
            }
        }
    }

    private void eaM() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void ar(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.ofo.parseJson(stringExtra);
            this.ofo.updateQuality();
            if (this.ofo.getChosedFiles() != null && this.ofo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.ofo.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.ofo.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dZX());
        HidenSoftKeyPad(this.mInputManager, dZW());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
        if (this.ofT != null) {
            this.ofT.onPause();
        }
        if (this.fDN.bEM()) {
            this.fDN.bDe();
        }
    }

    private void as(Intent intent) {
        e(intent, true);
    }

    private void F(Intent intent) {
        this.fFY = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.fFY;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.getEquipmentWidth(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.fFY, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            eaN();
            eaf();
        }
        zu(true);
    }

    private void G(Intent intent) {
        e(intent, false);
    }

    private void e(Intent intent, boolean z) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
                eaN();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    eaf();
                }
            }
            zu(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void eaN() {
        if (this.fDN.sv(10) != null) {
            this.fDN.setToolEnabled(this.writeImagesInfo == null || x.getCount(this.writeImagesInfo.getChosedFiles()) < this.writeImagesInfo.getMaxImagesAllowed(), 10);
        }
    }

    private void bFy() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.52
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.fFY));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void eaO() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.jdc)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                o oVar = new o(this, this.jdc, new o.a() { // from class: com.baidu.tieba.write.write.WriteActivity.53
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
                            WriteActivity.this.zu(true);
                        }
                    }
                });
                oVar.setFrom(1);
                oVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zu(boolean z) {
        String forumId = this.ngI == null ? "" : this.ngI.getForumId();
        if (this.ofp != null) {
            this.ofp.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.jfh == null) {
            this.jfh = VoiceManager.instance();
        }
        return this.jfh;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cFz() {
        this.jfh = getVoiceManager();
        this.jfh.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bP(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.jgD) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.ngI.getType() != 7) {
                if (this.oeu == null) {
                    com.baidu.tieba.tbadkCore.writeModel.g.i(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                I(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.fGf = i;
        if (this.fDN != null) {
            this.fDN.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void eaf() {
        if (!this.oeF) {
            if (this.fDN != null) {
                this.fDN.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.fDN.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.ngI == null ? "" : this.ngI.getForumId();
            if (this.ofp != null) {
                this.ofp.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la(boolean z) {
        if (this.fDN != null) {
            this.fDN.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void MM(int i) {
        if (i < this.oes.size()) {
            for (int i2 = 0; i2 < this.oes.size(); i2++) {
                this.oes.get(i2).zh(false);
            }
            this.oes.get(i).zh(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void Kv(int i) {
        if (i == x.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new aq("c13014").an("obj_type", 1));
        } else {
            TiebaStatic.log(new aq("c13014").an("obj_type", 2));
        }
        this.ngJ = i;
        this.nhg.setCurrentIndex(i);
        MM(i);
        this.nhf.setText(this.mPrefixData.getPrefixs().get(i));
        dLx();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.nhg, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.nhi.setSelected(false);
        SvgManager.bwq().a(this.nhh, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        ShowSoftKeyPadDelay(this.oep);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes8.dex */
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
        if (this.ngI != null) {
            if (this.ngI.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.ngI.getType() == 5) {
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
            bFs();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ad.transformPermissionResult(strArr, iArr);
            if (ad.checkCamera(getApplicationContext())) {
                an.c(getPageContext(), this.fFY);
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
        this.bsq = z;
        if (this.ofI && System.currentTimeMillis() - this.ofJ < 800) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.ofI = false;
        }
        if (this.oeJ != null && !z) {
            this.oeJ.cyX();
        }
        if (this.oeL != null && !z) {
            dZH();
        }
        if (this.ofN != null && !z) {
            ean();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vx(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.ofF != null) {
            Vy(str);
            this.ofF.dismiss();
        }
    }

    private void hf(Context context) {
        ofH = l.getEquipmentHeight(context);
    }

    private void Vy(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.ofI = true;
        eaN();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            eaf();
        }
        zu(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [5664=4] */
    private static Bitmap h(String str, float f) {
        Throwable th;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3 = null;
        int i = (int) f;
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && i > 0) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                int i2 = options.outWidth;
                int i3 = options.outHeight;
                bitmap2 = BitmapHelper.resizeBitmapAbsolute(str, (Math.max(i2, i3) * i) / Math.min(i2, i3));
            } catch (Exception e) {
                bitmap2 = null;
            } catch (Throwable th2) {
                th = th2;
                bitmap = null;
            }
            try {
                bitmap3 = BitmapHelper.getResizedBitmap(bitmap2, i);
                if (bitmap2 != null && bitmap2 != bitmap3 && !bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
                System.gc();
            } catch (Exception e2) {
                if (bitmap2 != null && bitmap2 != null && !bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
                System.gc();
                return bitmap3;
            } catch (Throwable th3) {
                th = th3;
                bitmap = bitmap2;
                if (bitmap != null && bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                System.gc();
                throw th;
            }
        }
        return bitmap3;
    }

    private File eaP() {
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
                if ((currentTimeMillis - file.lastModified()) / AppStatusRules.DEFAULT_GRANULARITY > 1) {
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

    private void eaQ() {
        if (this.ofC != null && this.ngI.getType() == 0 && this.ngI.getType() == 9 && this.ngI.getType() == 11) {
            hf(getActivity());
            this.ofE = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.ofE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.54
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.ofC != null) {
                        WriteActivity.this.Vx(WriteActivity.this.ofC.getAbsolutePath());
                    }
                }
            });
            this.ofD = (TbImageView) this.ofE.findViewById(R.id.rec_img_view);
            this.ofG = (LinearLayout) this.ofE.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.bvq().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.ofC.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.bvq().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.ofC.getAbsolutePath());
                Bitmap h = h(this.ofC.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (h != null) {
                    this.ofD.setImageBitmap(h);
                    this.ofD.setDrawBorder(true);
                    this.ofD.setBorderWidth(2);
                    this.ofD.setBorderColor(ao.getColor(R.color.common_color_10264));
                    this.ofF = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.ofF.setCanceledOnTouchOutside(true);
                    this.ofF.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.55
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.ofI) {
                                l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.ofJ = System.currentTimeMillis();
                            }
                        }
                    });
                    this.ofF.setContentView(this.ofE);
                    this.ofF.show();
                    Window window = this.ofF.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (ofH / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.bsq && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.oek = false;
            this.oej = "";
            if ("from_content".equals(str)) {
                this.oej = "from_content";
            } else if ("from_title".equals(str)) {
                this.oej = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.Eu(String.valueOf(charSequence.charAt(i)))) {
                zq(false);
            }
        }
    }

    public void dFD() {
        if (this.isEvaluate) {
            this.oeo.setVisibility(8);
            if (this.ogs != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ogs.getLayoutParams();
                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                this.ogs.setLayoutParams(layoutParams);
            }
            this.ofe.setVisibility(8);
        } else if (com.baidu.tieba.write.b.b.dYT()) {
            this.nha.setHint(R.string.title_hint_for_hot);
            this.oeo.setVisibility(0);
            if (this.ogs != null) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ogs.getLayoutParams();
                layoutParams2.topMargin = 0;
                this.ogs.setLayoutParams(layoutParams2);
            }
            this.ofe.setVisibility(0);
            com.baidu.tieba.write.b.b.a(this.ofc);
            this.oeo.requestFocus();
        } else {
            this.ofc.setVisibility(8);
            this.nha.setHint(this.oeZ ? R.string.feedback_title_hint : R.string.post_title_hint);
            if (this.oeZ || !x.isEmpty(this.mList) || (this.ngI != null && !StringUtils.isNull(this.ngI.getTitle()))) {
                this.oeo.setVisibility(0);
                if (this.ogs != null) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.ogs.getLayoutParams();
                    layoutParams3.topMargin = 0;
                    this.ogs.setLayoutParams(layoutParams3);
                }
                this.ofe.setVisibility(0);
                this.oeo.requestFocus();
                return;
            }
            this.oeo.setVisibility(8);
            if (this.ogs != null) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.ogs.getLayoutParams();
                layoutParams4.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                this.ogs.setLayoutParams(layoutParams4);
            }
            this.ofe.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eaR() {
        if (this.fDN != null) {
            this.fDN.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.57
                @Override // java.lang.Runnable
                public void run() {
                    if (WriteActivity.this.fDN != null && WriteActivity.this.fDN.fDQ != null) {
                        String clipBoardContent = UtilHelper.getClipBoardContent();
                        if (at.isEmpty(clipBoardContent) || !be.bwu().l(clipBoardContent)) {
                            WriteActivity.this.oeJ.dyi();
                            return;
                        }
                        if (WriteActivity.this.ocT == null) {
                            WriteActivity.this.ocT = new WriteTipBubbleController(WriteActivity.this.getPageContext(), WriteActivity.this.ogr);
                        }
                        WriteActivity.this.ocT.a(WriteActivity.this.fDN.fDQ.st(31), WriteActivity.this.getPageContext().getString(R.string.find_new_link) + "\n" + clipBoardContent, clipBoardContent, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
                    }
                }
            });
        }
    }

    public String getCallFrom() {
        return this.jLR;
    }

    public WriteData dco() {
        return this.ngI;
    }

    public FrsTabInfoData getFrsTabInfoData() {
        return this.nYG;
    }

    public String getFrom() {
        return this.mFrom;
    }

    private boolean eaS() {
        return (this.ofU == null || this.ofV == null || this.ofU.getWriteVoteData() == null || this.ofV.getVisibility() != 0) ? false : true;
    }

    public void dYa() {
        if (!eaW()) {
            BdToast.b(this, getString(R.string.post_goods_no_tab_tip), R.drawable.icon_pure_toast_mistake40_svg, true).bud();
        } else if (!this.canGoods) {
            BdToast.b(this, getString(R.string.post_goods_tip), R.drawable.icon_pure_toast_mistake40_svg, true).bud();
        } else {
            if (this.ngI != null) {
                TiebaStatic.log(new aq("c13897").an("obj_locate", 2).dX("fid", this.ngI.getForumId()).dX("fname", this.ngI.getForumName()));
            }
            if (!com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean("commodity_goods_show_first_dialog", false)) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.pd(2);
                aVar.jI(false);
                FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(getPageContext().getPageActivity());
                frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.58
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (aVar != null) {
                            aVar.dismiss();
                            com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean("commodity_goods_show_first_dialog", true);
                            TiebaStatic.log(new aq("c13959").an("obj_locate", 2).dX("fid", WriteActivity.this.ngI != null ? WriteActivity.this.ngI.getForumId() : "").dX("fname", WriteActivity.this.ngI != null ? WriteActivity.this.ngI.getForumName() : ""));
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + WriteActivity.this.eaT()));
                        }
                    }
                });
                aVar.br(frsPublishFineGoodsDialogView);
                TiebaStatic.log(new aq("c13958").an("obj_locate", 2).dX("fid", this.ngI != null ? this.ngI.getForumId() : "").dX("fname", this.ngI != null ? this.ngI.getForumName() : ""));
                aVar.b(getPageContext()).btX();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + eaT()));
        }
    }

    public void MU() {
        if (this.ogg != null && this.ogg.dZs() == null && this.oep != null && this.oep.getSpanGroupManager() != null) {
            this.ogg.h(this.oep.getSpanGroupManager().byK());
            this.ogg.refreshData();
        } else if (this.ogg != null && this.ogg.dZs() != null) {
            this.ogg.refreshData();
        }
        if (this.ogg != null) {
            gm(this.ogg.dZr());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gm(List<u> list) {
        boolean z;
        if (list != null) {
            Iterator<u> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                } else if (it.next().mType == 2) {
                    z = true;
                    break;
                }
            }
            if (!z && this.ogh != null) {
                this.ogh.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vz(String str) {
        this.ogk = new ArrayList();
        ArrayList arrayList = new ArrayList();
        if (!StringUtils.isNull(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(string);
                    this.ogk.add(com.baidu.tieba.j.a.er(jSONObject));
                }
                if (this.ogk.size() > 0) {
                    this.ogn = true;
                    this.oep.o(this.ogk, arrayList);
                    eav();
                    MU();
                    this.ogh.setVisibility(0);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eaT() {
        if (this.oep == null || this.oep.getSpanGroupManager() == null) {
            return 10;
        }
        return 10 - this.oep.getSpanGroupManager().byL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eaU() {
        return this.canGoods || this.oep == null || this.oep.getSpanGroupManager() == null || this.oep.getSpanGroupManager().byL() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int eaV() {
        boolean z = this.ogg == null || this.ogg.dZt();
        boolean z2 = (this.oeM == null || this.oeM.getSelectedTabItemData() == null || this.oeM.getSelectedTabItemData().tabType != 3) ? false : true;
        if (z && z2) {
            return 1;
        }
        return (z || z2) ? 0 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eaW() {
        if (this.nYG == null || x.isEmpty(this.nYG.tabList)) {
            return false;
        }
        for (FrsTabItemData frsTabItemData : this.nYG.tabList) {
            if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                return true;
            }
        }
        return false;
    }

    private void eaX() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921500, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.write.write.WriteActivity.59
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                if (customMessage != null && customMessage.getData() != null && customMessage.getData().booleanValue()) {
                    new BdTopToast(WriteActivity.this).yW(false).UY(WriteActivity.this.getResources().getString(R.string.user_collection_emotion_unclickable_hint)).aR((ViewGroup) WriteActivity.this.mRootView);
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private String cJu() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (this.ofQ != null) {
            i = this.ofQ.getStarCount();
        }
        arrayList.add(new v("", String.valueOf(i), 2));
        return new Gson().toJson(arrayList);
    }
}
