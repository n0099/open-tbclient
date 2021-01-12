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
import com.baidu.l.a.a;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.live.tbadk.pay.PayHelper;
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
/* loaded from: classes7.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0148a, VoiceManager.c, y.a, i.a {
    private static int oaY = 0;
    private String fBq;
    private LocationModel fBr;
    private EditorTools fzf;
    List<ab> gKl;
    private String iYu;
    private String iYv;
    private String iYw;
    private boolean isEvaluate;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private VoiceManager jaA;
    private com.baidu.tbadk.core.dialog.i jnR;
    private SaveDraftDialogView jnS;
    private boolean job;
    private LinearLayout lKD;
    private PlayVoiceBntNew lKE;
    private ImageView lKG;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private ListView mListView;
    private PostTopicData mPostTopicData;
    public PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private FrsTabInfoData nUa;
    private WriteTipBubbleController nYl;
    private LinearLayout nZF;
    private LinearLayout nZG;
    private View nZJ;
    private Toast nZL;
    private AdditionData nZM;
    private RelativeLayout nZN;
    private TextView nZO;
    private TextView nZP;
    private TextView nZQ;
    ab nZR;
    private String nZT;
    private PostCategoryView nZV;
    private HotTopicBussinessData nZY;
    private TextView nZZ;
    private com.baidu.tieba.write.i ncA;
    private ImageView ncB;
    private View ncC;
    private int ncd;
    private TextView ncz;
    private com.baidu.tieba.tbadkCore.writeModel.a oaE;
    private i oaG;
    private com.baidu.tieba.write.editor.b oab;
    private g oad;
    private ForumTabSelectedView oae;
    private com.baidu.tieba.view.b oal;
    private TitleTipView oau;
    private View oaw;
    private View oay;
    private ImageView obA;
    private TextView obB;
    private List<com.baidu.tieba.j.a> obC;
    private EBusinessProtocolView obD;
    private WriteImageGridView obK;
    private com.baidu.tbadk.editortools.c.a obL;
    private com.baidu.tieba.c.e obd;
    private b obe;
    private ForumSelectedView obf;
    private com.baidu.tbadk.data.j obg;
    private WriteEvaluationHeaderView obh;
    private TextView obi;
    private View obk;
    private com.baidu.tieba.write.write.video.a obl;
    private com.baidu.tieba.write.write.vote.a obm;
    private RelativeLayout obn;
    private boolean obo;
    private SerializableItemInfo obp;
    private boolean obq;
    private int obr;
    private Serializable obv;
    private String obw;
    private d oby;
    private LinearLayout obz;
    private int privateThread;
    private String nZB = "";
    private boolean nZC = false;
    protected WriteData ncc = null;
    private boolean oar = false;
    private boolean oas = false;
    private boolean nZE = false;
    private boolean oat = false;
    private InputMethodManager mInputManager = null;
    private EditText ncu = null;
    private HeadImageView oav = null;
    private View ncv = null;
    private LinearLayout ncx = null;
    private SpanGroupEditText nZH = null;
    private FeedBackModel nZI = null;
    private FeedBackTopListView oax = null;
    private ArrayList<WritePrefixItemLayout> nZK = new ArrayList<>();
    private String ldn = null;
    private final KeyEvent iME = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView oaz = null;
    private TextView lLu = null;
    private TextView mName = null;
    private ImageView oaA = null;
    private final Handler mHandler = new Handler();
    private boolean oaB = false;
    private String oaC = null;
    private RelativeLayout loZ = null;
    public boolean oaD = true;
    public String fBw = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int fBx = 0;
    private int nZS = -1;
    private int nZU = -1;
    private WriteImagesInfo oaF = new WriteImagesInfo();
    private View mRootView = null;
    private GridView oaH = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a oaI = null;
    private ScrollView nZW = null;
    private EditText oaJ = null;
    private View oaK = null;
    private View oaL = null;
    private View oaM = null;
    private EditText oaN = null;
    private TextView oaO = null;
    private TextView oaP = null;
    private TextWatcher oaQ = null;
    private TextWatcher oaR = null;
    private boolean nZX = false;
    private boolean oaS = false;
    private com.baidu.tbadk.core.view.a fJT = null;
    private String mFrom = "write";
    private File oaT = null;
    private TbImageView oaU = null;
    private View oaV = null;
    private Dialog oaW = null;
    private LinearLayout oaX = null;
    private boolean oaZ = false;
    private long oba = -1000;
    private boolean obb = false;
    private String jHl = "2";
    private int bHv = 0;
    private boolean canGoods = false;
    private String mTopicId = "";
    private SpannableStringBuilder oaa = new SpannableStringBuilder();
    private boolean obc = false;
    private boolean bnE = false;
    private final c oac = new c();
    private boolean obs = true;
    private boolean obt = false;
    private String obu = null;
    private final d.a obx = new d.a() { // from class: com.baidu.tieba.write.write.WriteActivity.1
        @Override // com.baidu.tieba.write.write.d.a
        public void Ld(int i) {
            if (WriteActivity.this.nZH != null) {
                WriteActivity.this.nZH.pT(i);
            }
        }

        @Override // com.baidu.tieba.write.write.d.a
        public void gl(List<u> list) {
            WriteActivity.this.gm(list);
        }
    };
    private boolean obE = false;
    private boolean obF = false;
    private final HttpMessageListener obG = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.ldn)) {
                    WriteActivity.this.ldn = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.zp(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.ldn)) {
                    WriteActivity.this.ldn = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.ldn);
                    WriteActivity.this.zp(true);
                }
            }
        }
    };
    private CustomMessageListener obH = new CustomMessageListener(2921494) { // from class: com.baidu.tieba.write.write.WriteActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (WriteActivity.this.ncc != null && WriteActivity.this.canGoods) {
                TiebaStatic.log(new aq("c13896").an("obj_locate", 1).dW("fid", WriteActivity.this.ncc.getForumId()).dW("fname", WriteActivity.this.ncc.getForumName()));
            }
        }
    };
    private final CustomMessageListener obI = new CustomMessageListener(2921505) { // from class: com.baidu.tieba.write.write.WriteActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.data.j jVar;
            if (WriteActivity.this.obf != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j) && (jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData()) != null && !StringUtils.isNull(jVar.forumId) && !StringUtils.isNull(jVar.forumName)) {
                WriteActivity.this.a(jVar);
            }
        }
    };
    private TbFaceManager.a oaf = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.45
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan CR(String str) {
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
    private final AntiHelper.a jbW = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.56
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).an("obj_locate", ax.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).an("obj_locate", ax.a.LOCATE_WRITE));
        }
    };
    private WriteTipBubbleController.a obJ = new WriteTipBubbleController.a() { // from class: com.baidu.tieba.write.write.WriteActivity.60
        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.a
        public void f(View view, String str) {
            if (WriteActivity.this.nYl != null) {
                TiebaStatic.log("c13802");
                WriteActivity.this.nYl.VA();
                UtilHelper.clearClipBoard();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, str, false, null)));
            }
        }
    };
    private final NewWriteModel.d fBH = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.61
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.cBI();
            WriteActivity.this.closeLoadingDialog();
            WriteActivity.this.obN = true;
            if (postWriteCallBackData != null && WriteActivity.this.ncc != null) {
                WriteActivity.this.oac.bh(null);
                if (z) {
                    WriteActivity.this.kW(z);
                    if (WriteActivity.this.h(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    com.baidu.tieba.write.b.b.g(WriteActivity.this.ncc);
                    WriteActivity.this.cFB();
                    WriteActivity.this.dMR();
                    if ((WriteActivity.this.ncc.getType() == 0 || WriteActivity.this.ncc.getType() == 9 || WriteActivity.this.ncc.getType() == 11) && !x.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                        TiebaStatic.log(new aq("c11731").dW("obj_id", WriteActivity.this.mTopicId));
                    }
                    WriteActivity.this.j(postWriteCallBackData);
                    if (!at.isEmpty(postWriteCallBackData.getVideoid()) && WriteActivity.this.ncc.getVideoInfo() != null) {
                        postWriteCallBackData.mVideoMd5 = WriteActivity.this.ncc.getVideoInfo().getVideoMd5();
                        if (!at.isEmpty(WriteActivity.this.ncc.getForumName())) {
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
                    WriteActivity.this.oac.bh(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.oac.TW(postWriteCallBackData.getErrorString());
                    WriteActivity.this.oac.b(WriteActivity.this.ncu, WriteActivity.this.nZH);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.d(WriteActivity.this.getActivity(), WriteActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.d(WriteActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this.getActivity());
                    if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.Ad(WriteActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.Ad(postWriteCallBackData.getErrorString());
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
                    aVar.b(WriteActivity.this.getPageContext()).bqe();
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
                    writeData.setVcodeExtra(ahVar.bwn());
                    if (com.baidu.tbadk.t.a.DE(ahVar.bwm())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, ahVar.bwm());
                        if (WriteActivity.this.oat) {
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
    private final LocationModel.a fBF = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.62
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bBP() {
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
    private final CustomMessageListener npA = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.fBr.yj(false);
                    WriteActivity.this.fBr.gu(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.fBr.yj(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener oag = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.3
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
                WriteActivity.this.dXa();
            }
        }
    };
    private CustomMessageListener obM = new CustomMessageListener(2921516) { // from class: com.baidu.tieba.write.write.WriteActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof EvaluateRelevanceItemSelectedMessage)) {
                WriteActivity.this.a((EvaluateRelevanceItemSelectedMessage) customResponsedMessage);
            }
        }
    };
    private final View.OnClickListener oah = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dVN = WriteActivity.this.dVN();
            if (dVN >= 0 && dVN < WriteActivity.this.nZH.getText().length()) {
                WriteActivity.this.nZH.setSelection(dVN);
            }
        }
    };
    private boolean oai = true;
    private final View.OnFocusChangeListener hsU = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.9
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.ncu || view == WriteActivity.this.mBack || view == WriteActivity.this.lLu) {
                if (z) {
                    WriteActivity.this.oai = true;
                    WriteActivity.this.dVO();
                    l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.ncu);
                    if (WriteActivity.this.fzf != null) {
                        WriteActivity.this.fzf.bzl();
                    }
                } else if (view == WriteActivity.this.ncu) {
                    WriteActivity.this.ncz.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.nZH && z) {
                WriteActivity.this.oai = false;
                WriteActivity.this.dVO();
                l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.nZH);
                if (WriteActivity.this.fzf != null) {
                    WriteActivity.this.fzf.bzl();
                }
            }
            WriteActivity.this.dVT();
        }
    };
    private com.baidu.tbadk.mutiprocess.h iZF = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.write.write.WriteActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(GoodsEvent goodsEvent) {
            if (goodsEvent != null) {
                WriteActivity.this.Uq(goodsEvent.getGoodsList());
                goodsEvent.setDispost(true);
            }
            return false;
        }
    };
    private boolean obN = false;
    private TextWatcher oaj = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.20
        private String oan = "";
        private String oao;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.oao = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.oao != null ? this.oao.length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dHG();
            WriteActivity.this.dVU();
            EditText dWg = WriteActivity.this.dWg();
            if (editable != null && dWg != null && dWg.getText() != null) {
                if (this.oan == null || !this.oan.equals(editable.toString())) {
                    if (WriteActivity.this.oac != null) {
                        this.oan = dWg.getText().toString();
                        WriteActivity.this.oac.b(dWg, true);
                        return;
                    }
                    return;
                }
                dWg.setSelection(dWg.getSelectionEnd());
            }
        }
    };
    private TextWatcher oak = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.21
        private String oao;
        private String oap = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.oao = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.oao != null ? this.oao.length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.dHG();
            EditText dWf = WriteActivity.this.dWf();
            if (editable != null && dWf != null && dWf.getText() != null) {
                if (this.oap == null || !this.oap.equals(editable.toString())) {
                    if (WriteActivity.this.oac != null) {
                        this.oap = dWf.getText().toString();
                        WriteActivity.this.oac.b(dWf, false);
                    }
                    if (WriteActivity.this.isEvaluate) {
                        WriteActivity.this.e(editable);
                        return;
                    }
                    return;
                }
                dWf.setSelection(dWf.getSelectionEnd());
            }
        }
    };
    private int obO = 0;
    private final a.InterfaceC0867a lRF = new a.InterfaceC0867a() { // from class: com.baidu.tieba.write.write.WriteActivity.47
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0867a
        public void onRefresh() {
            WriteActivity.this.ldn = null;
            WriteActivity.this.zp(false);
            WriteActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(2, 12, null));
        }
    };
    private final Runnable obP = new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.49
        @Override // java.lang.Runnable
        public void run() {
            if (WriteActivity.this.obt) {
                WriteActivity.this.fBH.callback(false, com.baidu.tieba.tbadkCore.writeModel.c.nqZ, com.baidu.tieba.tbadkCore.writeModel.c.nra, com.baidu.tieba.tbadkCore.writeModel.c.nrb, com.baidu.tieba.tbadkCore.writeModel.c.antiData);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.data.j jVar) {
        if (jVar != null) {
            this.obg = jVar;
            if (this.ncc != null) {
                this.ncc.setForumId(this.obg.forumId);
                this.ncc.setForumName(this.obg.forumName);
            }
            this.obf.setSelectedForum(this.obg.forumName);
            this.nUa = null;
            if (!x.isEmpty(this.obg.tabInfoList)) {
                this.nUa = new FrsTabInfoData();
                this.nUa.selectedTabId = -1;
                this.nUa.tabList = this.obg.tabInfoList;
                if (this.obg.isForumBusinessAccount && this.nUa.tabList != null) {
                    FrsTabItemData frsTabItemData = new FrsTabItemData();
                    frsTabItemData.tabId = 505;
                    frsTabItemData.name = "官方";
                    this.nUa.tabList.add(0, frsTabItemData);
                }
                this.nUa.isForumBusinessAccount = this.obg.isForumBusinessAccount;
            }
            this.oae.setData(this.nUa);
            if (this.ncc != null) {
                this.ncc.setFrsTabInfoData(this.nUa);
            }
            if (this.oae.getVisibility() == 0) {
                this.obk.setVisibility(0);
            }
            this.mPrefixData = null;
            if (this.obg.fxT != null && !x.isEmpty(this.obg.fxT.getPrefixs())) {
                this.mPrefixData = this.obg.fxT;
                this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
            }
            dWI();
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
    public void bBx() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EvaluateRelevanceItemSelectedMessage evaluateRelevanceItemSelectedMessage) {
        this.obh.setVisibility(0);
        TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
        tbRichTextEvaluateItemInfo.setItemID(evaluateRelevanceItemSelectedMessage.item_id);
        tbRichTextEvaluateItemInfo.setTags(evaluateRelevanceItemSelectedMessage.tags);
        tbRichTextEvaluateItemInfo.setScore(evaluateRelevanceItemSelectedMessage.score);
        tbRichTextEvaluateItemInfo.setStar(evaluateRelevanceItemSelectedMessage.star);
        tbRichTextEvaluateItemInfo.setIconUrl(evaluateRelevanceItemSelectedMessage.icon_url);
        tbRichTextEvaluateItemInfo.setIconSize(evaluateRelevanceItemSelectedMessage.icon_size);
        tbRichTextEvaluateItemInfo.setTitle(evaluateRelevanceItemSelectedMessage.item_name);
        this.ncc.setItemInfo(tbRichTextEvaluateItemInfo);
        this.obh.setItemInfo(tbRichTextEvaluateItemInfo);
    }

    public void bBz() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bBB();
        } else if (this.fBr.dMe()) {
            bBx();
        } else {
            this.fBr.yj(false);
            a(1, true, (String) null);
            this.fBr.dMc();
        }
    }

    public void dWq() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.oab != null) {
                this.oab.dUT();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bBB();
        } else if (this.fBr != null) {
            this.fBr.yj(false);
            a(1, true, (String) null);
            this.fBr.dMc();
        }
    }

    private void bBB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.nu(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.fBr.dMg();
                } else {
                    WriteActivity.this.fBF.bBP();
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
        aVar.bqe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dVN() {
        int selectionEnd = dWf().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dWf().getText().getSpans(0, dWf().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dWf().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dWf().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVO() {
        if (this.fzf != null) {
            if (this.obl != null && this.obl.isVisible()) {
                this.fzf.setBarLauncherEnabled(!this.oai);
                this.fzf.setDeskLauncherEnabled(!this.oai);
                this.fzf.setToolEnabled(true, 2);
                this.fzf.setToolEnabled(true, 32);
                this.fzf.setToolEnabled(false, 10);
                this.fzf.setToolEnabled(false, 6);
                this.fzf.setToolEnabled(false, 18);
                this.fzf.qP(5).kO(false);
                if (this.oab != null) {
                    this.oab.zj(true);
                }
            } else {
                this.fzf.setBarLauncherEnabled(!this.oai);
                this.fzf.setDeskLauncherEnabled(!this.oai);
                this.fzf.setToolEnabled(true, 26);
                this.fzf.setToolEnabled(true, 2);
                this.fzf.setToolEnabled(true, 30);
                this.fzf.qP(5).kO(true);
                if (this.oab != null) {
                    this.oab.zj(true);
                }
                dWW();
            }
            if (this.isEvaluate && this.obL != null && !this.obL.isEnable()) {
                this.fzf.setToolEnabled(false, 31);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.nZX) {
            this.ncu.setVisibility(8);
            if (this.ncc.getType() == 5) {
                this.oaM.setVisibility(8);
            } else {
                this.oaM.setVisibility(0);
            }
            a(this.oaP, this.oaJ);
            a(this.oaO, this.oaN);
            dHG();
        }
        if (this.oar) {
            this.oai = true;
            dVO();
            if (this.fzf != null) {
                this.fzf.bzl();
            }
            this.ncu.requestFocus();
            ShowSoftKeyPadDelay(this.ncu);
        }
        if (this.obl != null) {
            this.obl.onResume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
        if (this.obl != null) {
            this.obl.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
        if (this.obl != null) {
            this.obl.onStop();
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
                    dWo();
                }
                zq(true);
            }
            Serializable serializableExtra = intent.getSerializableExtra(WriteActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.ncc.setVideoInfo((VideoInfo) serializableExtra);
            } else {
                this.ncc.setVideoInfo(null);
            }
            if (this.obl == null) {
                this.obl = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            }
            if (this.ncc.getVideoInfo() != null && this.ncc.getVideoInfo().isEditVideoDataLegal()) {
                aD(false, false);
                this.obl.dXF();
                return;
            }
            aD(true, false);
        }
    }

    public void DR(String str) {
        showToastWithDefaultIcon(str, BdToast.DefaultIcon.FAILURE);
    }

    public void aD(boolean z, boolean z2) {
        if (z) {
            this.ncc.setVideoInfo(null);
            this.obl.a(null, z2);
            this.oaG.Wf().setVisibility(0);
            zp(false);
        } else {
            this.obl.a(this.ncc.getVideoInfo(), z2);
            this.writeImagesInfo.clear();
            this.oaG.Wf().setVisibility(8);
            dWK();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, false));
        }
        dHG();
        dVO();
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
        if (this.ncc.getType() == 0) {
            Lg(this.bHv);
        }
        initUI();
        dWJ();
        this.fBr = new LocationModel(getPageContext());
        this.fBr.a(this.fBF);
        dXg();
        cXZ();
        dWZ();
        if (this.nZX) {
            this.oaI.setEditorTools(this.fzf);
        } else {
            this.nZH.requestFocus();
        }
        dBM();
        dWo();
        dWX();
        this.iZF.setPriority(1);
        registerResponsedEventListener(GoodsEvent.class, this.iZF);
        dWr();
        if (this.obt) {
            k(this.ncc);
            dHG();
            dWO();
        }
    }

    private void initListener() {
        registerListener(this.obG);
        registerListener(this.obH);
        registerListener(this.obI);
        registerListener(this.npA);
        registerListener(this.oag);
        registerListener(this.mBackgroundListener);
        registerListener(this.obM);
    }

    private void dWr() {
        Uq(this.obu);
    }

    @SuppressLint({"ResourceAsColor"})
    private void cXZ() {
        this.fzf = new EditorTools(getActivity());
        this.fzf.setBarMaxLauCount(5);
        this.fzf.setMoreButtonAtEnd(true);
        this.fzf.setBarBackgroundColorId(R.color.CAM_X0201);
        this.fzf.setBarLauncherType(1);
        this.fzf.kK(true);
        this.fzf.kL(false);
        switch (this.ncc.getType()) {
            case 4:
            case 5:
                dWu();
                break;
            default:
                dVP();
                break;
        }
        this.fzf.build();
        if (this.nZF != null) {
            this.nZF.addView(this.fzf);
        }
        cXz();
        this.fzf.rV();
        com.baidu.tbadk.editortools.h qM = this.fzf.qM(6);
        if (qM != null && !TextUtils.isEmpty(this.fBw)) {
            ((View) qM).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.fBw);
                }
            });
        }
        if (!this.nZX) {
            this.fzf.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.fzf.bzl();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.fzf.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.fzf.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (com.baidu.tbadk.core.sharedPref.b.brx().getInt("commodity_tip_show_controller", 0) == 0 && this.canGoods) {
            dWv();
            return;
        }
        dVR();
        dXa();
    }

    private void dWs() {
        this.oaK = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.oaM = this.oaK.findViewById(R.id.live_post_title_container);
        this.oaJ = (EditText) this.oaK.findViewById(R.id.live_post_content);
        this.oaH = (GridView) this.oaK.findViewById(R.id.photoLiveGridView);
        this.oaN = (EditText) this.oaK.findViewById(R.id.live_post_title);
        this.oaO = (TextView) this.oaK.findViewById(R.id.titleOverPlusNumber);
        this.oaP = (TextView) this.oaK.findViewById(R.id.contentOverPlusNumber);
        this.oaL = this.oaK.findViewById(R.id.live_interval_view);
        this.oaO.setText(String.valueOf(20));
        this.oaP.setText(String.valueOf(233));
        this.oaK.setVisibility(0);
        this.oaO.setVisibility(0);
        this.oaP.setVisibility(0);
        this.oaN.setHint(R.string.tips_title_limit_new);
        this.oaN.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.oaS = true;
                    WriteActivity.this.oai = true;
                    WriteActivity.this.dVO();
                    if (WriteActivity.this.fzf != null) {
                        WriteActivity.this.fzf.bzl();
                    }
                }
            }
        });
        if (this.ncc.getType() == 4) {
            this.oaJ.setHint(R.string.live_write_input_content_new);
        } else if (this.ncc.getType() == 5) {
            this.oaJ.setHint(R.string.live_write_input_content_update);
        }
        this.oaJ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.14
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.oaS = false;
                    WriteActivity.this.oai = false;
                    WriteActivity.this.dVO();
                    if (WriteActivity.this.fzf != null) {
                        WriteActivity.this.fzf.bzl();
                    }
                }
            }
        });
        this.oaJ.requestFocus();
        this.oaJ.addTextChangedListener(awn());
        this.oaN.requestFocus();
        this.oaN.addTextChangedListener(awn());
        this.oaN.setOnClickListener(this.oah);
        this.oaJ.setOnClickListener(this.oah);
        this.oaI = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.oaH);
        this.oaI.KX(6);
        this.oaH.setAdapter((ListAdapter) this.oaI);
        View findViewById = this.oaK.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.15
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void dVn() {
                WriteActivity.this.dWU();
            }
        });
        dWt();
    }

    private void dWt() {
        if (this.ncc.getType() == 0) {
            if (this.ncc.getTitle() != null) {
                this.oaN.setText(this.ncc.getTitle());
                this.oaN.setSelection(this.ncc.getTitle().length());
                return;
            }
            return;
        }
        if (this.ncc.getType() == 1 || this.ncc.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.nZX) {
            dWS();
        }
        if (this.fzf.bAT()) {
            this.fzf.bzl();
        }
        Lg(0);
    }

    public boolean dUE() {
        return !"1".equals(this.jHl) && this.writeImagesInfo.size() == 0 && this.mVoiceModel == null;
    }

    private boolean e(Spannable spannable) {
        if (spannable != null) {
            ImageSpan[] imageSpanArr = (ImageSpan[]) spannable.getSpans(0, spannable.length(), ImageSpan.class);
            if (imageSpanArr == null || imageSpanArr.length <= 0) {
                if (this.oac == null || !this.oac.d(spannable)) {
                    return be.bsB().n(spannable);
                }
                return true;
            }
            return true;
        }
        return false;
    }

    private void Lg(int i) {
        if (this.writeImagesInfo != null && this.ncc != null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.ncc.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", this.ncc.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumFloatActivityConfig.setRequestCode(12002);
            albumFloatActivityConfig.setAlbumThread(i);
            albumFloatActivityConfig.setCanSelectVideo(dUE());
            albumFloatActivityConfig.setFromWrite(true);
            albumFloatActivityConfig.setCallFrom(this.jHl);
            albumFloatActivityConfig.setStatisticFrom(this.ncc.getStatisticFrom());
            albumFloatActivityConfig.setProfessionZone(this.ncc.getProZone());
            albumFloatActivityConfig.setFrsTabInfo(this.nUa);
            AntiData antiData = new AntiData();
            antiData.voice_message = this.fBw;
            antiData.setIfVoice(this.oaD);
            albumFloatActivityConfig.setExtraData(antiData, this.mPrefixData, this.ncc.getFirstDir(), this.ncc.getSecondDir());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
        }
    }

    private void dWu() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.fzf.bL(arrayList);
        m qP = this.fzf.qP(5);
        if (qP != null) {
            qP.fzS = 2;
        }
        this.fzf.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.fzf.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void dVP() {
        m mVar;
        m mVar2;
        m mVar3;
        CustomResponsedMessage runTask;
        m mVar4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 1);
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            this.fzf.b(dVar);
        }
        Boolean dWN = dWN();
        if (!this.oar && dWN != null && dWN.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.dMI() && com.baidu.tieba.tbadkCore.u.d(this.ncc.getForumName(), true) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), m.class)) != null && (mVar4 = (m) runTask.getData()) != null) {
            mVar4.fzS = 2;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fzf.b(mVar4);
            }
        }
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), m.class);
        if (runTask2 != null && (mVar3 = (m) runTask2.getData()) != null) {
            mVar3.fzS = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fzf.b(mVar3);
            }
        }
        if (!com.baidu.tieba.write.b.b.dVc() && !this.isEvaluate) {
            this.fzf.b(new com.baidu.tbadk.editortools.l(getActivity(), 6));
        }
        this.fzf.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 7));
        if (at.equals(this.jHl, "2")) {
            this.obL = new com.baidu.tbadk.editortools.c.a(getActivity(), 3);
            if (this.isEvaluate) {
                this.obL.kP(false);
                this.obL.setEnable(false);
            }
            this.fzf.b(this.obL);
            if (!this.isEvaluate) {
                this.fzf.b(new com.baidu.tbadk.editortools.e.a(getActivity(), 8));
            }
        }
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), m.class);
        if (runTask3 != null && (mVar2 = (m) runTask3.getData()) != null) {
            mVar2.fzU = true;
            mVar2.fzS = 9;
            mVar2.fzM = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fzf.b(mVar2);
            }
        }
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), m.class);
        if (runTask4 != null && (mVar = (m) runTask4.getData()) != null) {
            mVar.fzU = true;
            mVar.fzS = 10;
            mVar.fzM = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.fzf.b(mVar);
            }
        }
        if (this.nZM == null) {
            if (this.oab == null) {
                this.oab = new com.baidu.tieba.write.editor.b(getActivity(), this.jHl);
                this.oab.KR(0);
                this.oab.zi(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.oab.dUR();
                this.oab.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                dWq();
            }
            if (!x.isEmpty(this.mList)) {
                this.oab.dUR();
            }
            this.fzf.b(this.oab);
        }
        if (!this.isEvaluate && !"main_tab".equals(this.mFrom)) {
            this.fzf.b(new com.baidu.tbadk.editortools.d(getActivity(), 10));
        }
        this.fzf.bL(arrayList);
        m qP = this.fzf.qP(5);
        if (qP != null) {
            qP.fzS = 4;
        }
    }

    private void dVQ() {
        if (this.oad != null) {
            this.oad.hideTip();
        }
    }

    private void dWv() {
        if (this.fzf != null) {
            this.fzf.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.16
                @Override // java.lang.Runnable
                public void run() {
                    if (WriteActivity.this.fzf != null && WriteActivity.this.fzf.fzi != null) {
                        if (WriteActivity.this.obe == null) {
                            WriteActivity.this.obe = new b(WriteActivity.this.getPageContext());
                        }
                        WriteActivity.this.obe.showTip(WriteActivity.this.fzf.fzi.qN(2));
                    }
                }
            });
        }
    }

    private void dWw() {
        if (this.obe != null) {
            this.obe.hideTip();
        }
    }

    private void dVR() {
        if (this.oad == null) {
            this.oad = new g(getPageContext());
        }
        this.oad.d(this.fzf);
    }

    private void cXz() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                VideoInfo videoInfo;
                WriteVoteData writeVoteData = null;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        TiebaStatic.log(new aq("c12612").an("obj_locate", 9));
                        if (WriteActivity.this.dWe()) {
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
                            if (uVar.bwd() == EmotionGroupType.BIG_EMOTION || uVar.bwd() == EmotionGroupType.USER_COLLECT) {
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
                                    WriteActivity.this.zq(true);
                                    WriteActivity.this.dHG();
                                }
                            } else if (WriteActivity.this.dWe()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(uVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.dWh();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.f((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.dlT();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.dWW();
                        WriteActivity.this.dHG();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.Lh(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.nZM == null) {
                            WriteActivity.this.bBC();
                            return;
                        }
                        switch (WriteActivity.this.fBx) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ad.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.bBz();
                                    return;
                                } else {
                                    ad.c(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.bBx();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.fBr != null) {
                            WriteActivity.this.fBr.yj(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.ldn = null;
                        } else {
                            WriteActivity.this.ldn = (String) aVar.data;
                        }
                        WriteActivity.this.zp(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        aq aqVar = new aq("c10645");
                        aqVar.dW("fid", WriteActivity.this.ncc != null ? WriteActivity.this.ncc.getForumId() : "");
                        TiebaStatic.log(aqVar);
                        if (WriteActivity.this.ncc == null || (videoInfo = WriteActivity.this.ncc.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.fzf.bAT()) {
                                        WriteActivity.this.fzf.bzl();
                                        WriteActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.ncc.setVideoInfo(null);
                        WriteActivity.this.dHG();
                        if (WriteActivity.this.nZH != null) {
                            WriteActivity.this.nZH.requestFocus();
                        }
                        WriteActivity.this.fzf.bzl();
                        WriteActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.nZH);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new aq("c12612").an("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.nZC = true;
                        WriteActivity.this.zm(true);
                        if (!WriteActivity.this.dWg().isFocused() || WriteActivity.this.nZG.getVisibility() != 0) {
                            WriteActivity.this.nZB = "from_content";
                        } else {
                            WriteActivity.this.nZB = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        TiebaStatic.log(new aq("c12612").an("obj_locate", 8));
                        if (WriteActivity.this.nZG.getVisibility() == 0) {
                            if (WriteActivity.this.nZG.hasFocus()) {
                                WriteActivity.this.nZH.requestFocus();
                                WriteActivity.this.nZH.setSelection(WriteActivity.this.nZH.getText().toString().length());
                            }
                            WriteActivity.this.nZG.setVisibility(8);
                            if (WriteActivity.this.obK != null) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) WriteActivity.this.obK.getLayoutParams();
                                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                                WriteActivity.this.obK.setLayoutParams(layoutParams);
                            }
                            WriteActivity.this.oaw.setVisibility(8);
                            WriteActivity.this.fzf.qM(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.nZG.setVisibility(0);
                            if (WriteActivity.this.obK != null) {
                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) WriteActivity.this.obK.getLayoutParams();
                                layoutParams2.topMargin = 0;
                                WriteActivity.this.obK.setLayoutParams(layoutParams2);
                            }
                            WriteActivity.this.oaw.setVisibility(0);
                            WriteActivity.this.nZG.requestFocus();
                            WriteActivity.this.fzf.qM(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.dHG();
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
                        if (WriteActivity.this.obm != null && WriteActivity.this.obm.getWriteVoteData() != null) {
                            writeVoteData = WriteActivity.this.obm.getWriteVoteData();
                        }
                        WriteActivity.this.a(writeVoteData);
                        TiebaStatic.log(new aq("c13800").an("obj_source", 2));
                        WriteActivity.this.dWx();
                    } else if (aVar.code == 21) {
                        if (WriteActivity.this.nYl != null) {
                            WriteActivity.this.nYl.VA();
                        }
                        TiebaStatic.log(new aq("c12612").an("obj_locate", 5));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, "", true, null)));
                    } else if (aVar.code == 59) {
                        WriteActivity.this.dUj();
                    }
                }
            }
        };
        this.fzf.setActionListener(16, bVar);
        this.fzf.setActionListener(14, bVar);
        this.fzf.setActionListener(24, bVar);
        this.fzf.setActionListener(3, bVar);
        this.fzf.setActionListener(10, bVar);
        this.fzf.setActionListener(11, bVar);
        this.fzf.setActionListener(12, bVar);
        this.fzf.setActionListener(13, bVar);
        this.fzf.setActionListener(15, bVar);
        this.fzf.setActionListener(18, bVar);
        this.fzf.setActionListener(20, bVar);
        this.fzf.setActionListener(25, bVar);
        this.fzf.setActionListener(27, bVar);
        this.fzf.setActionListener(29, bVar);
        this.fzf.setActionListener(43, bVar);
        this.fzf.setActionListener(56, bVar);
        this.fzf.setActionListener(48, bVar);
        this.fzf.setActionListener(46, bVar);
        this.fzf.setActionListener(49, bVar);
        this.fzf.setActionListener(47, bVar);
        this.fzf.setActionListener(55, bVar);
        this.fzf.setActionListener(58, bVar);
        this.fzf.setActionListener(22, bVar);
        this.fzf.setActionListener(21, bVar);
        this.fzf.setActionListener(59, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWx() {
        if (this.oaA != null) {
            this.oaA.setVisibility(8);
        }
        if (this.mName != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
            layoutParams.rightMargin = this.obO;
            this.mName.setLayoutParams(layoutParams);
        }
    }

    private void dWy() {
        if (this.obv instanceof WriteVoteData) {
            final WriteVoteData writeVoteData = (WriteVoteData) this.obv;
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.a(writeVoteData);
                    TiebaStatic.log(new aq("c13800").an("obj_source", 3));
                }
            };
            this.obm.ap(onClickListener);
            this.obm.setOnItemClickListener(onClickListener);
            this.obm.b(writeVoteData);
            this.obm.zs(true);
            dHG();
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
    public void Lh(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBC() {
        if (this.fBr.ckC()) {
            if (this.fBr.dMe()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.b.dLZ().getLocationData().getFormatted_address());
                return;
            }
            a(1, true, (String) null);
            this.fBr.dMc();
            return;
        }
        a(0, true, (String) null);
    }

    protected void zo(boolean z) {
        if (!z && this.oaE != null) {
            this.oaE.cEk();
        }
        if (this.nZI != null) {
            this.nZI.cancelLoadData();
        }
        if (this.fBr != null) {
            this.fBr.cancelLoadData();
        }
        if (this.obl != null) {
            this.obl.onDestroy();
        }
    }

    protected void dHy() {
        zo(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        this.mNavigationBar.removeCallbacks(this.obP);
        if (this.oaE != null) {
            this.oaE.dML();
        }
        dVQ();
        dWw();
        TiebaPrepareImageService.StopService();
        zo(true);
        if (!this.obN) {
            dWz();
        }
        com.baidu.adp.lib.f.g.dismissDialog(this.jnR, this);
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.oaG != null) {
            this.oaG.destroy();
        }
        if (this.obd != null) {
            this.obd.RS();
        }
        MessageManager.getInstance().unRegisterTask(2921500);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWz() {
        if (this.ncc != null && this.ncc.getType() == 2 && this.oaB) {
            finish();
        } else if (this.ncc == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.ncc.setTitle(dWg().getText().toString());
            this.ncc.setContent(dWf().getText().toString());
            if (this.obh != null) {
                this.ncc.setEvaluationStar(this.obh.getStarCount());
            }
            int type = this.ncc.getType();
            if (type == 0 || type == 9 || type == 11) {
                if (this.obs) {
                    if (this.ncc.isEvaluate()) {
                        y.d(this.ncc.getItem_id(), this.ncc);
                    } else if (TextUtils.isEmpty(this.ncc.getTopicId())) {
                        y.c(this.ncc.getForumId(), this.ncc);
                    } else {
                        y.e(this.ncc.getTopicId(), this.ncc);
                    }
                }
            } else if (type == 7) {
                if (this.obs) {
                    y.c("24591571", this.ncc);
                }
            } else if (type == 1) {
                y.b(this.ncc.getThreadId(), this.ncc);
            } else if (type == 4) {
                y.c(this.ncc.getForumId() + "photolive", this.ncc);
            } else if (type == 5) {
                y.b(this.ncc.getThreadId() + "updatephotolive", this.ncc);
            }
            this.obN = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGi() {
        if (this.lLu == null || ((!this.lLu.isEnabled() && !this.isEvaluate) || ((this.isEvaluate && TextUtils.isEmpty(this.nZH.getText()) && ((this.writeImagesInfo.getChosedFiles() == null || this.writeImagesInfo.size() == 0) && (this.obl == null || !this.obl.isVisible()))) || this.obo || !this.obs))) {
            cFB();
            dMR();
            setResult(100);
            finish();
            return;
        }
        if (this.jnS == null) {
            this.jnS = new SaveDraftDialogView(this);
            this.jnS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            WriteActivity.this.cFB();
                            WriteActivity.this.dMR();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            WriteActivity.this.dWz();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        }
                        WriteActivity.this.jnR.dismiss();
                    }
                }
            });
        }
        if (this.jnR == null) {
            this.jnR = new com.baidu.tbadk.core.dialog.i(getPageContext());
            this.jnR.setContentView(this.jnS);
        }
        boolean z = (this.obl == null || !this.obl.isVisible() || this.ncc == null || this.ncc.getVideoInfo() == null || this.ncc.getVideoInfo().isVideoMixFinished()) ? false : true;
        this.jnS.setText(getString(z ? R.string.write_save_draft_dialog_video_fail_title : R.string.write_save_draft_dialog_normal_title), z ? getString(R.string.write_save_draft_dialog_video_fail_sub_title) : null, getString(z ? R.string.write_save_draft_dialog_video_fail_save_text : R.string.save));
        this.jnR.Pd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFB() {
        if (this.ncc.getType() == 0 || this.ncc.getType() == 9 || this.ncc.getType() == 11) {
            if (this.obs) {
                if (this.ncc.isEvaluate()) {
                    y.d(this.ncc.getItem_id(), (WriteData) null);
                } else if (TextUtils.isEmpty(this.ncc.getTopicId())) {
                    y.c(this.ncc.getForumId(), (WriteData) null);
                } else {
                    y.e(this.ncc.getTopicId(), (WriteData) null);
                }
            }
        } else if (this.ncc.getType() == 1) {
            y.b(this.ncc.getThreadId(), (WriteData) null);
        }
        this.obN = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dMR() {
        n.deleteFileOrDir(new File(com.baidu.tieba.video.c.nAB));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.ncA != null && this.ncA.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.ncA, getPageContext().getPageActivity());
                return true;
            } else if (this.fzf.bAT()) {
                this.fzf.bzl();
                return true;
            } else {
                dHy();
                cGi();
                return true;
            }
        }
        if (i == 67 && (text = dWf().getText()) != null) {
            int selectionStart = dWf().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dWf().onKeyDown(67, this.iME);
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
        getLayoutMode().onModeChanged(this.loZ);
        getLayoutMode().onModeChanged(this.oaX);
        ao.setBackgroundColor(this.loZ, R.color.CAM_X0205);
        if (this.oaU != null && (i == 1 || i == 4)) {
            this.oaU.setBorderColor(ao.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mNavigationBar.getBackImageView() != null) {
            this.mNavigationBar.getBackImageView().setImageDrawable(WebPManager.a(R.drawable.icon_pure_topbar_close40, ao.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
        }
        this.lLu.setTextColor(ao.aP(R.color.CAM_X0302, i));
        dVO();
        ao.setBackgroundColor(this.ncv, R.color.CAM_X0204);
        ao.setBackgroundColor(this.oaL, R.color.CAM_X0204);
        ao.setBackgroundColor(dWg(), R.color.CAM_X0205);
        this.lKG.setImageDrawable(WebPManager.a(R.drawable.icon_pure_home_delete16, ao.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null));
        if (TextUtils.isEmpty(this.ldn)) {
            ao.setBackgroundColor(dWf(), R.color.CAM_X0205);
        }
        dHG();
        this.fzf.onChangeSkinType(i);
        if (this.nZV != null) {
            this.nZV.btV();
        }
        if (this.oby != null) {
            this.oby.notifyDataSetChanged();
        }
        ao.setViewTextColor(this.mName, R.color.CAM_X0105);
        this.oaG.ocn.notifyDataSetChanged();
        dVT();
        dVU();
        zp(false);
        if (this.oac != null) {
            this.oac.c(dWg(), dWf());
        }
        if (this.obf != null) {
            this.obf.onChangeSkinType();
        }
        if (this.obh != null) {
            this.obh.onChangeSkinType();
        }
        if (this.oae != null) {
            this.oae.onChangeSkinType(i);
        }
        if (this.obl != null) {
            this.obl.btU();
        }
        if (this.obm != null) {
            this.obm.onChangeSkinType(i);
        }
        if (this.obD != null) {
            this.obD.onChangeSkinType(i);
        }
        if (this.oau != null) {
            this.oau.onChangeSkinType(i);
        }
        if (this.obi != null) {
            ao.setViewTextColor(this.obi, R.color.CAM_X0301);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVT() {
        if (this.ncu.hasFocus()) {
            this.ncu.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        } else {
            this.ncu.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        }
        if (this.nZH.hasFocus()) {
            this.nZH.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        } else {
            this.nZH.setHintTextColor(ao.getColor(R.color.CAM_X0110));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dVU() {
        if (this.ncu != null && this.ncu.getText() != null && this.ncu.getText().toString() != null && this.ncu.getPaint() != null) {
            if (this.ncu.getText().toString().length() == 0) {
                this.ncu.getPaint().setFakeBoldText(true);
            } else if (this.ncu.getText().toString().length() > 0) {
                this.ncu.getPaint().setFakeBoldText(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Editable editable) {
        g(editable);
        f(editable);
    }

    private void f(Editable editable) {
        if (!TextUtils.isEmpty(editable) && editable.length() >= 20 && editable.length() <= 500 && this.obh.dVs()) {
            this.lLu.setEnabled(true);
        } else {
            this.lLu.setEnabled(false);
        }
    }

    private void g(Editable editable) {
        if (editable.length() > 500) {
            this.obi.setText((500 - editable.length()) + "/500");
            this.obi.setVisibility(0);
            return;
        }
        this.obi.setVisibility(4);
    }

    private void initUI() {
        this.fJT = new com.baidu.tbadk.core.view.a(getPageContext());
        this.nZX = this.ncc.getType() == 4 || 5 == this.ncc.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        ao.setViewTextColor(this.mName, R.color.CAM_X0105);
        this.oaz = (TextView) findViewById(R.id.btn_image_problem);
        dVX();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lLu.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.tbds2);
        this.lLu.setLayoutParams(layoutParams);
        this.lLu.setOnFocusChangeListener(this.hsU);
        this.nZW = (ScrollView) findViewById(R.id.write_scrollview);
        this.nZW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.nZH != null) {
                        l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.nZH);
                    }
                    if (WriteActivity.this.fzf != null) {
                        WriteActivity.this.fzf.bzl();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.oax = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.oay = findViewById(R.id.feedback_divider);
        this.loZ = (RelativeLayout) findViewById(R.id.parent);
        this.nZF = (LinearLayout) findViewById(R.id.tool_view);
        this.nZF.setContentDescription(IStringUtil.TOP_PATH);
        this.nZG = (LinearLayout) findViewById(R.id.title_view);
        this.obK = (WriteImageGridView) findViewById(R.id.write_image_grid_view);
        this.oaw = findViewById(R.id.title_view_divider);
        this.ncv = findViewById(R.id.interval_view);
        this.nZZ = (TextView) findViewById(R.id.hot_topic_title_edt);
        dHF();
        if (this.nZX) {
            this.nZW.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            dWs();
        } else {
            this.oaG = new i(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.oaG.zf(false);
            } else {
                this.oaG.zf(this.ncc.getType() == 0 || this.ncc.getType() == 9 || this.ncc.getType() == 11);
            }
            this.obl = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            if (this.ncc.getVideoInfo() != null && this.ncc.getVideoInfo().isEditVideoDataLegal()) {
                aD(false, false);
                this.obl.dXF();
            } else {
                aD(true, false);
            }
        }
        dHH();
        if (this.oar || this.nZE) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.b.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.b.e.getInstance().eZB) {
                    com.baidu.tbadk.core.util.b.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.b.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.ncx = (LinearLayout) findViewById(R.id.post_content_container);
        this.ncx.setDrawingCacheEnabled(false);
        this.ncx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.nZH.requestFocus();
            }
        });
        this.lKD = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.lKE = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.lKG = (ImageView) findViewById(R.id.iv_delete_voice);
        this.lKG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dlT();
            }
        });
        f(this.mVoiceModel);
        this.mBack.setOnFocusChangeListener(this.hsU);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.26
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dHy();
                WriteActivity.this.cGi();
            }
        });
        this.oaz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.27
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        dWa();
        v(dWN());
        dWc();
        dVW();
        dWL();
        dVO();
        dWb();
        dHE();
        dWi();
        if (this.ncc.getType() == 4 && this.ncC != null && this.nZJ != null) {
            this.ncC.setVisibility(8);
            this.nZJ.setVisibility(8);
        }
        dHG();
        dWH();
        dWG();
        dWA();
        dVV();
        dWB();
        dWC();
        dWM();
        dWD();
        bRv();
    }

    private void dWA() {
        if ("main_tab".equals(this.mFrom) && !this.obt) {
            this.obf = (ForumSelectedView) findViewById(R.id.write_select_forum_view);
            this.obf.setVisibility(0);
        }
    }

    private void dVV() {
        if (!this.isEvaluate) {
            this.oae = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
            this.oae.setBgColor(R.color.CAM_X0205);
            this.obk = findViewById(R.id.frs_tab__divider);
            this.oae.setData(this.nUa);
            if (this.oae.getVisibility() == 0) {
                this.obk.setVisibility(0);
            }
            this.oae.setActivity(this);
        }
    }

    private void dWB() {
        if (this.isEvaluate) {
            this.obi = (TextView) findViewById(R.id.post_content_counter);
            this.obh = (WriteEvaluationHeaderView) findViewById(R.id.write_evaluation_header_view);
            this.obh.setStarChangeListener(new WriteEvaluationHeaderView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.28
                @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.a
                public void ap(float f) {
                    if (TextUtils.isEmpty(WriteActivity.this.nZH.getText()) || WriteActivity.this.nZH.getText().length() < 20 || WriteActivity.this.nZH.getText().length() > 500 || f <= 0.0f) {
                        WriteActivity.this.lLu.setEnabled(false);
                    } else {
                        WriteActivity.this.lLu.setEnabled(true);
                    }
                }
            });
            this.obh.setItemCloseListener(new WriteEvaluationHeaderView.b() { // from class: com.baidu.tieba.write.write.WriteActivity.29
                @Override // com.baidu.tieba.write.view.WriteEvaluationHeaderView.b
                public void onClose() {
                    WriteActivity.this.lLu.setEnabled(false);
                }
            });
        }
    }

    private void dWC() {
        if (this.isEvaluate) {
            this.obh.setVisibility(0);
            if (!this.job) {
                if (this.obq) {
                    this.obh.setShowItemInfo(false);
                }
                if (this.obp != null) {
                    TbRichTextEvaluateItemInfo tbRichTextEvaluateItemInfo = new TbRichTextEvaluateItemInfo();
                    tbRichTextEvaluateItemInfo.setItemID(String.valueOf(this.obp.id));
                    tbRichTextEvaluateItemInfo.setTags(this.obp.tags);
                    tbRichTextEvaluateItemInfo.setScore(this.obp.averageScore);
                    tbRichTextEvaluateItemInfo.setStar(F(this.obp.averageScore));
                    tbRichTextEvaluateItemInfo.setIconUrl(this.obp.icon_url);
                    tbRichTextEvaluateItemInfo.setIconSize(this.obp.icon_size);
                    tbRichTextEvaluateItemInfo.setTitle(this.obp.name);
                    this.obh.setItemInfo(tbRichTextEvaluateItemInfo);
                    this.obh.setStarCount(this.obr);
                    this.ncc.setItemInfo(tbRichTextEvaluateItemInfo);
                    this.ncc.setEvaluationStar(this.obr);
                } else if (this.ncc.getItemInfo() != null) {
                    this.obh.setItemInfo(this.ncc.getItemInfo());
                    this.obh.setStarCount(this.ncc.getEvaluationStar());
                }
            }
        }
    }

    private int F(double d) {
        return (int) ((1.0d + d) / 2.0d);
    }

    private void dWD() {
        this.obz = (LinearLayout) this.mRootView.findViewById(R.id.protocol);
        this.obA = (ImageView) this.mRootView.findViewById(R.id.protocol_tag);
        this.obB = (TextView) this.mRootView.findViewById(R.id.protocol_info);
        ao.setViewTextColor(this.obB, R.color.CAM_X0107);
        this.obD = new EBusinessProtocolView(this);
        this.obD.a(EBusinessProtocolView.WindowType.PROTOCOL);
        this.obD.setTitle(getResources().getString(R.string.protocol_title));
        SpannableString spannableString = new SpannableString(getResources().getString(R.string.readed_protocol));
        spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.write.write.WriteActivity.30
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.showDialog(WriteActivity.this.obD, WriteActivity.this);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NonNull TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, 6, 17, 34);
        spannableString.setSpan(new ForegroundColorSpan(ao.getColor(R.color.CAM_X0302)), 6, 17, 34);
        this.obB.setText(spannableString);
        this.obB.setMovementMethod(LinkMovementMethod.getInstance());
        this.obA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.31
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.obE) {
                    WriteActivity.this.obE = false;
                    WriteActivity.this.obA.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ao.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                } else {
                    WriteActivity.this.obE = true;
                    WriteActivity.this.obA.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                }
                if (!com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false) && WriteActivity.this.obE) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this);
                    aVar.nw(R.color.CAM_X0105);
                    aVar.Ac("");
                    aVar.Ad(WriteActivity.this.getResources().getString(R.string.protocol_tip));
                    aVar.nx(1);
                    aVar.a("同意", new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.31.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", true);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(PayHelper.STATUS_CANCEL_DESC, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.31.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false);
                            aVar2.dismiss();
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).bqe();
                }
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(TbadkApplication.getCurrentAccount() + "is_agree_protocol", false)) {
            this.obE = true;
            this.obA.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
        } else {
            this.obE = false;
            this.obA.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ao.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
        }
        this.obD.a(new EBusinessProtocolView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.32
            @Override // com.baidu.tieba.write.write.EBusinessProtocolView.a
            public void zk(boolean z) {
                if (z) {
                    if (!WriteActivity.this.obE) {
                        WriteActivity.this.obE = true;
                        WriteActivity.this.obA.setImageDrawable(WebPManager.a(R.drawable.icon_mask_use_check16, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
                    }
                } else if (WriteActivity.this.obE) {
                    WriteActivity.this.obE = false;
                    WriteActivity.this.obA.setImageDrawable(WebPManager.a(R.drawable.icon_pure_use_uncheck16, ao.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL));
                }
            }
        });
    }

    private void dWE() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mName.getLayoutParams();
        this.obO = layoutParams.rightMargin;
        layoutParams.rightMargin = 0;
        this.mName.setLayoutParams(layoutParams);
        this.oaA = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.oaA.setImageDrawable(WebPManager.a(R.drawable.icon_pure_creation_question16, ao.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds47);
        this.oaA.setPadding(dimens, dimens, dimens, dimens);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.oaA.getLayoutParams();
        layoutParams2.width = dimens + dimens2 + dimens;
        layoutParams2.height = dimens + dimens2 + dimens;
        this.oaA.setLayoutParams(layoutParams2);
        this.oaA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.dWF();
            }
        });
        this.oaA.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWF() {
        EBusinessProtocolView eBusinessProtocolView = new EBusinessProtocolView(this);
        eBusinessProtocolView.a(EBusinessProtocolView.WindowType.TIP);
        eBusinessProtocolView.setTitle(getResources().getString(R.string.tip_title));
        com.baidu.adp.lib.f.g.showDialog(eBusinessProtocolView, this);
    }

    private void dWG() {
        if (this.mName != null && this.ncc != null && this.ncc.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void dVW() {
        String str;
        String str2;
        if (this.ncc != null) {
            switch (this.ncc.getType()) {
                case 0:
                case 9:
                    if (this.oar || this.nZE) {
                        if (this.oat) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.jHl != null && this.jHl.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                    } else if (this.jHl != null && this.jHl.equals("2")) {
                        if (this.isEvaluate) {
                            this.mName.setText(R.string.publish_comment);
                        } else if (StringUtils.isNull(this.ncc.getForumName())) {
                            this.mName.setText(R.string.post_to_thread);
                        } else {
                            String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.ncc.getForumName(), 9, true, false);
                            if (fixedBarText.length() < 14) {
                                str2 = fixedBarText + getResources().getString(R.string.bar);
                            } else {
                                str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                            }
                            this.mName.setText(str2);
                        }
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.ncc.getForumName() + getResources().getString(R.string.bar));
                        this.ncu.setVisibility(8);
                        String str3 = this.iYw + " " + this.iYu;
                        if (!StringUtils.isNull(str3)) {
                            this.nZH.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.ncu.setVisibility(0);
                    this.nZH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                case 10:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.nZH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.ncu.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.nZH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.ncc.getFloorNum() + 1)));
                    this.oaL.setVisibility(8);
                    return;
                case 7:
                    this.ncu.setVisibility(0);
                    this.nZH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
                case 11:
                    this.mName.setText(R.string.publish_comment);
                    this.ncu.setVisibility(0);
                    this.nZH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
            }
        }
    }

    private void dVX() {
        if (this.ncc.getType() == 7) {
            this.lLu = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.lLu = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void dVY() {
        if (this.ncc != null && this.ncc.getType() == 0 && this.ncc.getType() == 9 && !this.oar && !this.nZE && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = at.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dWg() != null) {
                dWg().setText(cutStringWithSuffix);
                dWg().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.ncc.setVoiceModel(voiceModel);
            this.lKD.setVisibility(0);
            this.lKE.setVoiceModel(voiceModel);
            this.lKE.cbz();
            dHG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlT() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.Bu(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.ncc.setVoiceModel(null);
        this.lKD.setVisibility(8);
        this.lKE.cOx();
        this.lKE.setVoiceModel(null);
        m qP = this.fzf.qP(6);
        if (qP != null && qP.fyZ != null) {
            qP.fyZ.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        dHG();
    }

    private void dVZ() {
        com.baidu.tieba.frs.ad yN = ac.cDm().yN(1);
        if (yN != null) {
            this.gKl = yN.jfc;
            if (this.gKl != null && !this.gKl.isEmpty() && this.nZS >= 0) {
                this.nZR = new ab();
                this.nZR.jeY = 0;
                this.nZR.name = getPageContext().getResources().getString(R.string.category_auto);
                this.nZU = this.nZR.jeY;
                this.nZT = this.nZR.name;
                for (ab abVar : this.gKl) {
                    if (abVar.jeY == this.nZS) {
                        this.nZU = abVar.jeY;
                        this.nZT = abVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dWa() {
        if (this.gKl != null && !this.gKl.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.nZV = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.nZV.setText(this.nZT);
            this.nZV.setCategoryContainerData(this.gKl, this.nZR, this.nZU);
            this.nZV.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bc bcVar) {
                    if (bcVar != null) {
                        WriteActivity.this.nZV.setText(bcVar.name);
                        WriteActivity.this.ncc.setCategoryTo(bcVar.jeY);
                        WriteActivity.this.nZU = bcVar.jeY;
                        WriteActivity.this.nZV.dVp();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.nZV.dVo();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dWg());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dWf());
                }
            });
        }
    }

    private void dWH() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.oal = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.oal.setTitle(R.string.no_disturb_start_time);
        this.oal.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.oal);
        this.oal.setButton(-2, getPageContext().getString(R.string.cancel), this.oal);
        return this.oal;
    }

    private void dWb() {
        this.nZN = (RelativeLayout) findViewById(R.id.addition_container);
        this.nZO = (TextView) findViewById(R.id.addition_create_time);
        this.nZP = (TextView) findViewById(R.id.addition_last_time);
        this.nZQ = (TextView) findViewById(R.id.addition_last_content);
        if (this.nZM != null) {
            this.nZN.setVisibility(0);
            this.nZO.setText(getPageContext().getString(R.string.write_addition_create) + at.getFormatTime(this.nZM.getCreateTime() * 1000));
            if (this.nZM.getAlreadyCount() == 0) {
                this.nZP.setVisibility(8);
            } else {
                this.nZP.setText(getPageContext().getString(R.string.write_addition_last) + at.getFormatTime(this.nZM.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.nZM.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.nZQ.setText(lastAdditionContent);
            } else {
                this.nZQ.setVisibility(8);
            }
            dWf().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.nZM.getAlreadyCount()), Integer.valueOf(this.nZM.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.nZN.setVisibility(8);
    }

    private void dHE() {
        this.ncC = findViewById(R.id.post_prefix_layout);
        if (this.obd == null) {
            this.obd = new com.baidu.tieba.c.e(getPageContext(), this.ncC);
            this.obd.ej(R.drawable.bg_tip_blue_up_left);
            this.obd.ei(16);
            this.obd.pz(true);
            this.obd.setUseDirectOffset(true);
            this.obd.xb(l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.ncz = (TextView) findViewById(R.id.post_prefix);
        this.nZJ = findViewById(R.id.prefix_divider);
        this.ncB = (ImageView) findViewById(R.id.prefix_icon);
        dWI();
    }

    private void dWI() {
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.ncC.setVisibility(0);
            this.nZJ.setVisibility(0);
            this.obd.C(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.ncd = 0;
            this.ncC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.38
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c13013").dW("fid", WriteActivity.this.ncc.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.ncz.setVisibility(0);
                    WriteActivity.this.ncC.setSelected(true);
                    SvgManager.bsx().a(WriteActivity.this.ncB, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.ncA, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.fzf.bzl();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.ncu);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.nZH);
                }
            });
            this.ncz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new aq("c13013").dW("fid", WriteActivity.this.ncc.getForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.ncz.setSelected(true);
                    SvgManager.bsx().a(WriteActivity.this.ncB, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.ncA, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.fzf.bzl();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dWg());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dWf());
                }
            });
            this.ncA = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.ncA.a(this);
            this.ncA.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.ncA.setOutsideTouchable(true);
            this.ncA.setFocusable(true);
            this.ncA.setOnDismissListener(this);
            this.ncA.setBackgroundDrawable(ao.getDrawable(R.color.CAM_X0201));
            int color = ao.getColor(R.color.CAM_X0105);
            ao.getColor(R.color.CAM_X0108);
            SvgManager.bsx().a(this.ncB, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.ncz).nV(R.color.CAM_X0105).nX(R.string.F_X02).setBackGroundColor(R.color.CAM_X0201);
            this.nZK.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.nZK.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.zc(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.zc(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.ncA.addView(writePrefixItemLayout);
            }
            this.ncA.setCurrentIndex(0);
            this.ncz.setText(prefixs.get(0));
            Lf(0);
            return;
        }
        this.ncC.setVisibility(8);
        this.nZJ.setVisibility(8);
    }

    private void dWJ() {
        if (this.oar && this.ncc != null) {
            this.oax.setVisibility(0);
            this.oay.setVisibility(0);
            this.nZI = new FeedBackModel(getPageContext());
            this.nZI.Um(this.ncc.getForumName());
            this.nZI.setLoadDataCallBack(new com.baidu.adp.base.e() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.e
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.oax.setVisibility(8);
                        WriteActivity.this.oay.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.oax.setVisibility(8);
                        WriteActivity.this.oay.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.oax.a(feedBackModel.dVz(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void dWc() {
        this.lLu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.41
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WriteActivity.this.obf == null || WriteActivity.this.obg != null) {
                    if (WriteActivity.this.dXd()) {
                        if (!WriteActivity.this.obF || WriteActivity.this.obE) {
                            if (WriteActivity.this.dXf()) {
                                int dXe = WriteActivity.this.dXe();
                                if (dXe == 1) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_commodity));
                                    return;
                                } else if (dXe == 2) {
                                    WriteActivity.this.showToast(TbadkCoreApplication.getInst().getString(R.string.toast_no_haowu_tab));
                                    return;
                                }
                            }
                            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                WriteActivity.this.showToast(R.string.neterror);
                            }
                            if (!com.baidu.tieba.write.b.a.isFastDoubleClick()) {
                                if (WriteActivity.this.oac.a(WriteActivity.this.ncu, WriteActivity.this.nZH)) {
                                    WriteActivity.this.showToast(WriteActivity.this.oac.dUd());
                                    return;
                                }
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dWg());
                                WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dWf());
                                WriteActivity.this.fzf.bzl();
                                if (WriteActivity.this.ncc.getType() != 7) {
                                    if (WriteActivity.this.oar) {
                                        WriteActivity.this.cFE();
                                        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                                    } else {
                                        aq aqVar = new aq("c12102");
                                        aqVar.an("obj_type", StringUtils.isNull(WriteActivity.this.ncc.getForumName()) ? 1 : 2);
                                        TiebaStatic.log(aqVar);
                                        WriteActivity.this.dWm();
                                    }
                                } else {
                                    TiebaStatic.log("c12015");
                                    WriteActivity.this.cFE();
                                }
                                MercatorModel.dMr().startLoad();
                                TiebaStatic.log(new aq("c12262").dW("obj_locate", WriteActivity.this.jHl));
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

    protected void dHF() {
        this.oav = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.oav.setIsRound(true);
        this.oav.setDrawBorder(false);
        this.oav.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String AE = q.AE(currentPortrait);
            this.oav.setUrl(AE);
            this.oav.startLoad(AE, 12, false);
        }
        if (this.ncc.isUserFeedback()) {
            this.oav.setVisibility(0);
        }
        this.ncu = (EditText) findViewById(R.id.post_title);
        this.ncu.setOnClickListener(this.oah);
        this.ncu.setOnFocusChangeListener(this.hsU);
        if (this.ncc.getType() == 0 || this.ncc.getType() == 9 || this.ncc.getType() == 11 || this.ncc.getType() == 7) {
            if (this.ncc.getTitle() != null) {
                this.ncu.setText(this.ncc.getTitle());
                this.ncu.setSelection(this.ncc.getTitle().length());
            } else if (this.oat) {
                this.ncu.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.ncc.getType() == 1 || this.ncc.getType() != 2) {
        }
        this.ncu.addTextChangedListener(this.oaj);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.ncu).nX(R.string.F_X02);
        if (!this.ncc.getHaveDraft()) {
            dVY();
            this.obb = true;
        }
        this.oau = (TitleTipView) findViewById(R.id.post_title_tip);
    }

    private TextWatcher awn() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.42
            private EditText cyH = null;
            private TextView mTextView = null;
            private int obT;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.dHG();
                if (WriteActivity.this.nZX) {
                    this.obT = this.cyH.getSelectionStart();
                    this.cyH.setSelection(this.obT);
                    WriteActivity.this.a(this.mTextView, this.cyH);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.nZX || !WriteActivity.this.oaS) {
                    if (WriteActivity.this.nZX) {
                        if (this.cyH != WriteActivity.this.oaJ || this.mTextView != WriteActivity.this.oaP) {
                            this.cyH = WriteActivity.this.oaJ;
                            this.mTextView = WriteActivity.this.oaP;
                        }
                    }
                } else if (this.cyH != WriteActivity.this.oaN || this.mTextView != WriteActivity.this.oaO) {
                    this.cyH = WriteActivity.this.oaN;
                    this.mTextView = WriteActivity.this.oaO;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.nZX && this.oaS) {
            if (this.oaQ != null) {
                this.oaN.removeTextChangedListener(this.oaQ);
            }
            this.oaQ = textWatcher;
        } else if (this.nZX) {
            if (this.oaR != null) {
                this.oaJ.removeTextChangedListener(this.oaR);
            }
            this.oaR = textWatcher;
        }
        return textWatcher;
    }

    private long k(EditText editText) {
        if (editText == this.oaJ) {
            return 233L;
        }
        if (editText != this.oaN) {
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

    protected void dHH() {
        this.nZH = (SpanGroupEditText) findViewById(R.id.post_content);
        this.nZH.setDrawingCacheEnabled(false);
        this.nZH.setOnClickListener(this.oah);
        this.nZH.setOnSpanGroupChangedListener(new a.InterfaceC0568a() { // from class: com.baidu.tieba.write.write.WriteActivity.43
            @Override // com.baidu.tbadk.core.view.spanGroup.a.InterfaceC0568a
            public void G(int i, boolean z) {
                WriteActivity.this.IZ();
            }
        });
        this.nZH.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_COMMODITY);
        this.nZH.setForumId(com.baidu.adp.lib.f.b.toLong(this.ncc.getForumId(), 0L));
        if (this.oaE != null) {
            this.oaE.setSpanGroupManager(this.nZH.getSpanGroupManager());
        }
        if (this.ncc != null) {
            this.ncc.setSpanGroupManager(this.nZH.getSpanGroupManager());
        }
        if (this.ncc.getContent() != null && this.ncc.getContent().length() > 0) {
            this.nZH.setText(TbFaceManager.bCw().aE(getPageContext().getPageActivity(), this.ncc.getContent()));
            if (this.nZH.getText() != null) {
                this.nZH.setSelection(this.nZH.getText().length());
            }
        } else if (this.ncc.getType() == 2) {
            if (this.oaB) {
                if (this.oaC != null && this.oaC.length() > 0) {
                    this.nZH.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.oaC}));
                    this.nZH.setSelection(this.nZH.getText().length());
                }
            } else if (this.ncc.getFloorNum() > 0) {
                this.nZH.setText(String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.ncc.getFloorNum())));
                this.nZH.setSelection(this.nZH.getText().length());
            }
        }
        this.nZH.setOnFocusChangeListener(this.hsU);
        this.nZH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.44
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.fzf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.nZH.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.nZH.addTextChangedListener(this.oak);
        if (this.ncc.getType() == 0) {
            this.obc = true;
        } else {
            zp(true);
            this.obc = false;
        }
        if (this.isEvaluate) {
            SpannableString spannableString = new SpannableString(" " + ((Object) getResources().getText(R.string.write_evalute_hint)));
            Drawable a2 = WebPManager.a(R.drawable.icon_pure_post_redact16, ao.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL);
            a2.setBounds(0, 0, a2.getIntrinsicWidth(), a2.getIntrinsicHeight());
            spannableString.setSpan(new com.baidu.tieba.face.view.a(a2, 1, l.getDimens(this, R.dimen.tbds4)), 0, 1, 17);
            this.nZH.setHint(spannableString);
        } else if (this.ncc.isUserFeedback()) {
            this.nZH.setHint(R.string.write_input_content);
        } else {
            this.nZH.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void zp(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.nZX && dWf() != null) {
            dWf().setPadding(0, 0, 0, 0);
            dWf().setBackgroundDrawable(null);
            ao.setBackgroundColor(dWf(), R.color.CAM_X0201);
            if (TextUtils.isEmpty(this.ldn) || this.nZM != null) {
                return;
            }
            if (this.obl == null || !this.obl.isVisible()) {
                com.baidu.adp.lib.e.d.mx().a(this.ldn, 19, new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.46
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.c
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass46) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            if (WriteActivity.this.obl == null || !WriteActivity.this.obl.isVisible()) {
                                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                                }
                                WriteActivity.this.dWf().setBackgroundDrawable(ninePatchDrawable);
                                if (z) {
                                    com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.dWf(), true, WriteActivity.this.lRF);
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

    private void dWK() {
        if (dWf() != null) {
            dWf().setPadding(0, 0, 0, 0);
            dWf().setBackgroundDrawable(null);
            ao.setBackgroundColor(dWf(), R.color.CAM_X0201);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dWe() {
        int i = 5000;
        if (this.nZM != null) {
            i = 1000;
        }
        return dWf().getText() != null && dWf().getText().length() >= i;
    }

    private void CB(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.nZB)) {
                this.nZB = "";
                dWf().requestFocus();
                if (dWf().getText() != null && dWf().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dWf().getSelectionStart();
                    editable = dWf().getText();
                }
            } else if ("from_title".equals(this.nZB)) {
                this.nZB = "";
                dWg().requestFocus();
                if (dWg().getText() != null && dWg().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dWg().getSelectionStart();
                    editable = dWg().getText();
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
    public void zm(boolean z) {
        if (!com.baidu.tbadk.plugins.b.k(getPageContext())) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.ncc != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.ncc.getForumId(), 0L), this.ncc.getFirstDir(), this.ncc.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(com.baidu.tbadk.coreExtra.data.u uVar) {
        if (((ImageSpan[]) dWf().getText().getSpans(0, dWf().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.nZL == null) {
                this.nZL = Toast.makeText(getPageContext().getPageActivity(), R.string.too_many_face, 0);
            }
            this.nZL.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, uVar, dWf());
    }

    EditText dWf() {
        return this.nZX ? this.oaJ : this.nZH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dWg() {
        return this.nZX ? this.oaN : this.ncu;
    }

    protected void dWh() {
        if (dWf().getSelectionStart() > 0) {
            String substring = dWf().getText().toString().substring(0, dWf().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.iMD.matcher(substring);
            if (matcher.find()) {
                dWf().getText().delete(dWf().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dWf().getSelectionStart());
                return;
            }
            dWf().onKeyDown(67, this.iME);
        }
    }

    private void v(Boolean bool) {
        String str = null;
        if (this.ncc != null) {
            str = this.ncc.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.oar = true;
        }
    }

    private void dWL() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void dWM() {
        this.obn = (RelativeLayout) this.mRootView.findViewById(R.id.vote_layout_root);
        this.obm = new com.baidu.tieba.write.write.vote.a(getPageContext(), this.obn);
        dWy();
    }

    private void bRv() {
        this.mListView = (ListView) this.mRootView.findViewById(R.id.commodity_list);
        this.oby = new d(getPageContext());
        this.oby.a(this.obx);
        this.mListView.setAdapter((ListAdapter) this.oby);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.48
            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v12, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tieba.write.write.WriteActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (WriteActivity.this.oby != null && (WriteActivity.this.oby.getItem(i) instanceof u)) {
                    u uVar = (u) WriteActivity.this.oby.getItem(i);
                    if (uVar.mType == 1) {
                        if (uVar.eKH == 1) {
                            be.bsB().b(WriteActivity.this.getPageContext(), new String[]{uVar.eKz});
                        } else {
                            be.bsB().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(uVar.eKz)});
                        }
                    } else if (uVar.mType == 2) {
                        if (!TextUtils.isEmpty(uVar.eKC)) {
                            if (uVar.eKC.startsWith("tiebaclient://")) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2921361, uVar.eKC));
                                return;
                            }
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(uVar.eKC));
                            intent.addFlags(268468224);
                            if (UtilHelper.isHaveActivityCanHandleIntent(intent)) {
                                WriteActivity.this.startActivity(intent);
                            } else if (!TextUtils.isEmpty(uVar.eKD)) {
                                be.bsB().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(uVar.eKD)});
                            }
                        } else if (!TextUtils.isEmpty(uVar.eKD)) {
                            be.bsB().b(WriteActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/mo/q/checkurl?url=" + com.baidu.adp.lib.util.k.getUrlEncode(uVar.eKD)});
                        }
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fJT.setCancelListener(null);
        this.fJT.setTipString(R.string.sending);
        this.fJT.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        if (this.fJT != null) {
            this.fJT.setDialogVisiable(false);
        }
    }

    private Boolean dWN() {
        return Boolean.valueOf(this.oaD);
    }

    public void dHG() {
        this.obo = false;
        if (this.ncc != null) {
            String str = "";
            String str2 = "";
            if (dWg() != null) {
                str = dWg().getText().toString();
            }
            if (dWf() != null) {
                str2 = dWf().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.ncc.getType() == 0 || this.ncc.getType() == 9 || this.ncc.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.ncd == x.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.ncc.setIsNoTitle(true);
                        } else if (this.nZG.getVisibility() == 0) {
                            this.ncc.setIsNoTitle(false);
                            zn(true);
                            return;
                        }
                    } else if (this.nZG.getVisibility() == 0) {
                        this.ncc.setIsNoTitle(false);
                        zn(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.ncc.setIsNoTitle(true);
                } else if (this.nZG.getVisibility() == 0) {
                    this.ncc.setIsNoTitle(false);
                    zn(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.nZX) {
                    zn(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    zn(true);
                }
            }
            if (this.ncc.getType() == 4) {
                zn(n(this.oaJ) && m(this.oaN));
            } else if (this.ncc.getType() == 5) {
                zn(n(this.oaJ));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                zn(true);
            } else if (this.ncc.getVideoInfo() != null) {
                zn(this.ncc.getVideoInfo().isVideoMixFinished());
            } else if (dXb()) {
                zn(true);
                this.obo = true;
            } else {
                zn(false);
            }
        }
    }

    public void zn(boolean z) {
        if (!z || !this.isEvaluate || (this.nZH != null && !TextUtils.isEmpty(this.nZH.getText()) && this.nZH.getText().length() >= 20 && this.nZH.getText().length() <= 500 && this.obh != null && this.obh.dVs())) {
            this.lLu.setEnabled(z);
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
        this.oaE = com.baidu.tieba.tbadkCore.writeModel.a.dMJ();
        this.oaE.a(this);
        this.ncc = new WriteData();
        if (bundle != null) {
            this.ncc.setType(bundle.getInt("type", 0));
            this.ncc.setForumId(bundle.getString("forum_id"));
            this.ncc.setForumName(bundle.getString("forum_name"));
            this.ncc.setFirstDir(bundle.getString("forum_first_dir"));
            this.ncc.setSecondDir(bundle.getString("forum_second_dir"));
            this.ncc.setThreadId(bundle.getString("thread_id"));
            this.ncc.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.ncc.setFloorNum(bundle.getInt("floor_num", 0));
            this.ncc.setVideoInfo((VideoInfo) bundle.getSerializable(WriteActivityConfig.VIDEO_INFO));
            String string = bundle.getString("addition_data");
            if (!StringUtils.isNull(string)) {
                this.nZM = (AdditionData) OrmObject.objectWithJsonStr(string, AdditionData.class);
            }
            this.ncc.setIsAddition(this.nZM != null);
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.ncc.setTopicId(this.mTopicId);
            this.ncc.setTitle(bundle.getString("write_title"));
            this.ncc.setContent(bundle.getString("write_content"));
            this.ncc.setStatisticFrom(bundle.getInt(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
            this.oar = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.oas = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.oat = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.oaB = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.oaC = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            this.obw = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.fBq = bundle.getString(WriteActivityConfig.PHOTO_NAME);
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
            this.jHl = bundle.getString("KEY_CALL_FROM");
            this.bHv = bundle.getInt("album_thread");
            this.nUa = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.canGoods = bundle.getBoolean(WriteActivityConfig.CAN_GOODS);
        } else {
            Intent intent = getIntent();
            this.ncc.setType(intent.getIntExtra("type", 9));
            this.ncc.setForumId(intent.getStringExtra("forum_id"));
            this.ncc.setForumName(intent.getStringExtra("forum_name"));
            this.ncc.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.ncc.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.ncc.setThreadId(intent.getStringExtra("thread_id"));
            this.ncc.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.ncc.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.nZM = (AdditionData) intent.getSerializableExtra("addition_data");
            this.ncc.setIsAddition(this.nZM != null);
            this.ncc.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.ncc.setTitle(intent.getStringExtra("write_title"));
            this.ncc.setContent(intent.getStringExtra("write_content"));
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.ncc.setTopicId(this.mTopicId);
            this.ncc.setVideoInfo((VideoInfo) intent.getSerializableExtra(WriteActivityConfig.VIDEO_INFO));
            this.ncc.setStatisticFrom(intent.getIntExtra(WriteActivityConfig.KEY_STATISTIS_FROM, 0));
            this.oar = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.oas = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.oat = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.oaB = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.oaC = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mFrom = intent.getStringExtra("from");
            this.iYv = intent.getStringExtra("more_forum_img");
            this.iYw = intent.getStringExtra("more_forum_title");
            this.iYu = intent.getStringExtra("more_forum_url");
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.jHl = intent.getStringExtra("KEY_CALL_FROM");
            this.bHv = intent.getIntExtra("album_thread", 0);
            this.obw = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.nUa = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.ncc.setFrsTabInfoData(this.nUa);
            this.canGoods = intent.getBooleanExtra(WriteActivityConfig.CAN_GOODS, false);
            this.isEvaluate = getIntent().getBooleanExtra(IntentConfig.IS_EVALUATE, false);
            this.ncc.setIsEvaluate(this.isEvaluate);
            this.obq = getIntent().getBooleanExtra(IntentConfig.IS_ITEM_DETAIL, false);
            this.obr = getIntent().getIntExtra(WriteActivityConfig.STAR_COUNT, 0);
            Serializable serializableExtra = getIntent().getSerializableExtra("item_info");
            if (serializableExtra instanceof SerializableItemInfo) {
                this.obp = (SerializableItemInfo) serializableExtra;
                this.ncc.setItem_id(String.valueOf(this.obp.id));
            }
            this.job = getIntent().getBooleanExtra("item_is_school", false);
            this.obs = getIntent().getBooleanExtra("need_save_draft", true);
            this.obt = getIntent().getBooleanExtra(WriteActivityConfig.IS_FROM_ERROR_DIALOG, false);
            this.nZS = getIntent().getIntExtra("category_id", -1);
            this.obu = getIntent().getStringExtra("goods_list");
            this.obv = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
            this.oaD = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
            this.fBw = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            if (this.obt && com.baidu.tieba.tbadkCore.writeModel.c.nrb != null) {
                this.ncc = com.baidu.tieba.tbadkCore.writeModel.c.nrb;
                this.ncc.setType(9);
                this.ncc.setContent(this.ncc.getContentString());
                this.writeImagesInfo = this.ncc.getWriteImagesInfo();
                this.nUa = this.ncc.getFrsTabInfoData();
                if (this.ncc.getItemInfo() != null) {
                    this.obp = null;
                }
                this.mVoiceModel = this.ncc.getVoiceModel();
            }
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        if (this.ncc.getType() == 9) {
            this.ncc.setEntranceType(1);
        } else if (this.ncc.getType() == 10) {
            this.ncc.setEntranceType(2);
            this.ncc.setType(9);
        } else if (this.ncc.getType() == 0) {
            this.ncc.setEntranceType(3);
        }
        this.ncc.setIsUserFeedback(this.oar);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (this.obw != null) {
            this.writeImagesInfo.parseJson(this.obw);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.ncc.getType() == 4 ? 6 : 9);
        this.ncc.setWriteImagesInfo(this.writeImagesInfo);
        this.ldn = TbadkCoreApplication.getInst().getDefaultBubble();
        dVZ();
        if (this.ncc.getType() == 0 || this.ncc.getType() == 9 || this.ncc.getType() == 11) {
            if (this.obs) {
                if (this.ncc.isEvaluate()) {
                    y.c(this.ncc.getItem_id(), this);
                } else if (TextUtils.isEmpty(this.ncc.getTopicId())) {
                    y.b(this.ncc.getForumId(), this);
                } else {
                    y.d(this.ncc.getTopicId(), this);
                }
            }
        } else if (this.ncc.getType() == 7) {
            if (this.obs) {
                y.b("24591571", this);
            }
        } else if (this.ncc.getType() == 1) {
            y.a(this.ncc.getThreadId(), this);
        } else if (this.ncc.getType() == 4) {
            y.b(this.ncc.getForumId() + "photolive", this);
        } else if (this.ncc.getType() == 5) {
            y.a(this.ncc.getThreadId() + "updatephotolive", this);
        }
        if (this.ncc != null && this.ncc.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.ncc.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.nZE = true;
        }
        try {
            this.oaT = dWY();
        } catch (Throwable th) {
            this.oaT = null;
        }
    }

    private void dWO() {
        this.mNavigationBar.postDelayed(this.obP, 500L);
    }

    private void dWi() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) x.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.ncu.setText(com.baidu.tbadk.plugins.b.Dj(com.baidu.tbadk.plugins.b.Dk(hotTopicBussinessData.mTopicName)));
            this.ncu.setMovementMethod(com.baidu.tieba.view.c.dTE());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) x.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString Dj = com.baidu.tbadk.plugins.b.Dj(com.baidu.tbadk.plugins.b.Dk(hotTopicBussinessData.mTopicName));
            if (Dj != null) {
                this.ncu.setText(Dj);
            }
            this.nZZ.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.y.a
    public void b(WriteData writeData) {
        int i = 0;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !this.obF && !this.obt) {
            if (writeData != null) {
                if (this.ncc != null && writeData.isEvaluate() == this.ncc.isEvaluate()) {
                    boolean z = this.ncc.getVideoInfo() != null && this.ncc.getVideoInfo().isEditVideoDataLegal();
                    boolean z2 = (this.ncc.getWriteImagesInfo() == null || x.isEmpty(this.ncc.getWriteImagesInfo().getChosedFiles())) ? false : true;
                    boolean z3 = !com.baidu.adp.lib.util.k.isEmpty(dWg().getText().toString());
                    boolean z4 = !com.baidu.adp.lib.util.k.isEmpty(dWf().getText().toString());
                    boolean z5 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle());
                    boolean z6 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent());
                    boolean z7 = at.isEmpty(writeData.getTitle()) && !e(TbFaceManager.bCw().a(getPageContext().getPageActivity(), writeData.getContent(), this.oaf));
                    if (!z || z7) {
                        this.ncc.setHaveDraft(true);
                        if (!z2 && !z) {
                            i(writeData);
                        }
                        if (!z && (!z3 || this.obb || ((this.oar || this.nZE) && z5))) {
                            j(writeData);
                        }
                        if (z6 && (!z4 || this.oar || this.nZE)) {
                            k(writeData);
                        }
                        if (this.ncc != null && !this.ncc.getHaveDraft()) {
                            dVY();
                        }
                        if (writeData.getItemInfo() != null) {
                            this.ncc.setItemInfo(writeData.getItemInfo());
                            this.ncc.setEvaluationStar(writeData.getEvaluationStar());
                            this.obp = null;
                            dWC();
                        }
                        if (writeData.getVoiceModel() != null) {
                            f(writeData.getVoiceModel());
                        }
                        if (writeData.getType() == 4 || writeData.getType() == 5) {
                            dWP();
                        }
                        dHG();
                        int categoryTo = writeData.getCategoryTo();
                        if (categoryTo >= 0 && this.gKl != null) {
                            this.nZU = this.nZR.jeY;
                            this.nZT = this.nZR.name;
                            while (true) {
                                if (i == this.gKl.size()) {
                                    break;
                                }
                                ab abVar = this.gKl.get(i);
                                if (categoryTo != abVar.jeY) {
                                    i++;
                                } else {
                                    this.nZU = categoryTo;
                                    this.nZT = abVar.name;
                                    this.ncc.setCategoryTo(this.nZU);
                                    break;
                                }
                            }
                            if (this.nZV != null) {
                                this.nZV.setText(this.nZT);
                                this.nZV.setCategoryContainerData(this.gKl, this.nZR, this.nZU);
                            }
                        }
                        this.fzf.bzl();
                        return;
                    }
                    return;
                }
                return;
            }
            dWP();
            dVY();
        }
    }

    private void i(WriteData writeData) {
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(writeData.getVideoInfo());
            this.ncc.setVideoInfo(videoInfo);
            aD(false, true);
            return;
        }
        if (writeData.getWriteImagesInfo() != null) {
            this.writeImagesInfo = writeData.getWriteImagesInfo();
        }
        this.ncc.setWriteImagesInfo(this.writeImagesInfo);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            dWo();
        }
        zq(false);
        aD(true, true);
    }

    private void j(WriteData writeData) {
        String str;
        String Dk;
        if (com.baidu.adp.lib.util.k.isEmpty(this.ncc.getTitle())) {
            this.ncc.setTitle(writeData.getTitle());
        }
        if (!x.isEmpty(this.mList)) {
            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) x.getItem(this.mList, 0);
            if (hotTopicBussinessData == null) {
                str = null;
            } else {
                str = hotTopicBussinessData.mTopicName;
            }
            if (StringUtils.isNull(str)) {
                Dk = this.ncc.getTitle();
            } else {
                Dk = com.baidu.tbadk.plugins.b.Dk(str);
            }
            SpannableString Dj = com.baidu.tbadk.plugins.b.Dj(Dk);
            if (Dj != null) {
                dWg().setText(Dj);
                dWg().setSelection(Dj.length() > Dk.length() ? Dk.length() : Dj.length());
                return;
            }
            return;
        }
        SpannableString Dj2 = com.baidu.tbadk.plugins.b.Dj(this.ncc.getTitle());
        if (Dj2 != null) {
            dWg().setText(Dj2);
            dWg().setSelection(this.ncc.getTitle().length() > Dj2.length() ? Dj2.length() : this.ncc.getTitle().length());
        }
    }

    private void k(WriteData writeData) {
        this.ncc.setContent(writeData.getContent());
        SpannableString a2 = TbFaceManager.bCw().a(getPageContext().getPageActivity(), this.ncc.getContent(), this.oaf);
        InputFilter[] filters = this.nZH.getFilters();
        this.nZH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(IMConstants.ERROR_BASE)});
        dWf().setText(a2);
        if (dWf() == this.nZH && this.nZH.getSpanGroupManager() != null) {
            this.nZH.buG();
            this.nZH.getSpanGroupManager().buM();
            this.nZH.buH();
            IZ();
        }
        this.nZH.setFilters(filters);
        if (dWf().getText() != null) {
            dWf().setSelection(dWf().getText().length());
        }
        if (this.nZX) {
            a(this.oaP, this.oaJ);
        }
    }

    private void dWP() {
        if ((!this.nZX || this.oaI != null) && this.oaH != null) {
            this.oaI.b(this.writeImagesInfo);
            dWU();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.ncc.getType());
        bundle.putString("forum_id", this.ncc.getForumId());
        bundle.putString("forum_name", this.ncc.getForumName());
        bundle.putString("forum_first_dir", this.ncc.getFirstDir());
        bundle.putString("forum_second_dir", this.ncc.getSecondDir());
        bundle.putString("thread_id", this.ncc.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.ncc.getFloor());
        bundle.putInt("floor_num", this.ncc.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.oaB);
        if (this.oar) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.fBq);
        if (this.nZM != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.nZM));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.jHl);
        bundle.putInt("album_thread", this.bHv);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.nUa);
        bundle.putBoolean(WriteActivityConfig.CAN_GOODS, this.canGoods);
        bundle.putInt(WriteActivityConfig.KEY_STATISTIS_FROM, this.ncc.getStatisticFrom());
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dWf().getEditableText().toString();
        if (obj != null) {
            dWf().setText(TbFaceManager.bCw().a(getPageContext().getPageActivity(), obj, this.oaf));
            dWf().setSelection(dWf().getText().length());
        }
    }

    private String getContent() {
        return (dWf() == null || dWf().getText() == null) ? "" : dWf().getText().toString();
    }

    private String dWk() {
        if (this.ncc == null || dWg() == null || dWg().getVisibility() != 0 || dWg().getText() == null) {
            return "";
        }
        String obj = dWg().getText().toString();
        if (this.mPrefixData != null && x.getCount(this.mPrefixData.getPrefixs()) > 0 && this.ncd != x.getCount(this.mPrefixData.getPrefixs()) - 1 && this.ncc.getType() != 4 && this.ncz != null && this.ncz.getText() != null) {
            this.ncc.setPostPrefix(this.ncz.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.ncc.getTitle();
        }
        return obj;
    }

    private void Un(String str) {
        if (this.ncc != null && this.nZG != null) {
            if (this.nZG.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.ncc.setIsNoTitle(true);
                    this.ncc.setTitle("");
                    return;
                }
                this.ncc.setIsNoTitle(false);
                this.ncc.setTitle(str);
                return;
            }
            this.ncc.setIsNoTitle(true);
            this.ncc.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFE() {
        dHy();
        this.ncc.setContent(getContent());
        Un(dWk());
        if (this.oar || this.nZE) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.ncc.getTitle()) || !this.ncc.getTitle().startsWith(string)) {
                Un(string + this.ncc.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.ncc.getContent()) || !this.ncc.getContent().startsWith(str)) {
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
                sb.append(this.ncc.getContent());
                this.ncc.setContent(sb.toString());
            }
        }
        if (this.oas) {
            this.ncc.setZhongcePrefix(String.format(getResources().getString(R.string.homepage_test_post_suffix), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), com.baidu.adp.lib.util.j.netTypeNameInUpperCase(), Build.VERSION.RELEASE));
        }
        if (this.nZS >= 0) {
            this.ncc.setCategoryFrom(this.nZS);
        }
        if (this.nZU >= 0) {
            this.ncc.setCategoryTo(this.nZU);
        }
        this.ncc.setWriteImagesInfo(this.writeImagesInfo);
        if (this.obm != null) {
            this.ncc.setWriteVoteData(this.obm.getWriteVoteData());
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
            this.ncc.setTakePhotoNum(i);
        }
        this.ncc.setHasLocationData(this.fBr != null && this.fBr.ckC());
        if (this.writeImagesInfo != null) {
            this.oaE.yl(this.writeImagesInfo.size() > 0);
        }
        if (!x.isEmpty(this.mList) && this.nZY != null && this.nZY.mIsGlobalBlock == 0) {
            this.ncc.setForumId(String.valueOf(this.nZY.mForumId));
            this.ncc.setForumName(this.nZY.mForumName);
        }
        if (this.obh != null && this.obh.getEvaluateItemInfo() != null) {
            this.ncc.setItem_id(this.obh.getEvaluateItemInfo().getItemID());
            this.ncc.setComment_head(cFD());
        }
        dWl();
        this.oaE.f(this.ncc);
        this.ncc.setContent(this.ncc.getContent().replaceAll("\u0000\n", ""));
        this.ncc.setContent(this.ncc.getContent().replaceAll("\u0000", ""));
        this.ncc.setVcode(null);
        this.ncc.setVoiceModel(this.mVoiceModel);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.oaE.cYx().setVoice(this.mVoiceModel.getId());
                this.oaE.cYx().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.oaE.cYx().setVoice(null);
                this.oaE.cYx().setVoiceDuringTime(-1);
            }
        } else {
            this.oaE.cYx().setVoice(null);
            this.oaE.cYx().setVoiceDuringTime(-1);
        }
        if (!this.oaE.dMM()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else {
            dWQ();
        }
    }

    private void dWQ() {
        this.oaE.dMK();
        com.baidu.tieba.write.b.b.g(this.ncc);
        cBI();
        dWz();
        setResult(100);
        finish();
    }

    private void dWl() {
        if (this.ncc != null && this.oae != null) {
            this.ncc.setIsForumBusinessAccount(this.nUa == null ? false : this.nUa.isForumBusinessAccount);
            FrsTabItemData selectedTabItemData = this.oae.getSelectedTabItemData();
            if (selectedTabItemData != null) {
                this.ncc.setTabId(selectedTabItemData.tabId);
                this.ncc.setTabName(selectedTabItemData.name);
                this.ncc.setIsGeneralTab(selectedTabItemData.isGeneralTab);
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
            if (this.nZM != null) {
                i2 = this.nZM.getTotalCount();
                i = this.nZM.getAlreadyCount() + 1;
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
                if (this.ncu == getCurrentFocus()) {
                    dWf().clearFocus();
                    this.ncu.requestFocus();
                    if (this.fzf != null) {
                        this.fzf.bzl();
                    }
                    ShowSoftKeyPadDelay(this.ncu);
                } else {
                    dWf().requestFocus();
                    if (this.fzf != null) {
                        this.fzf.bzl();
                    }
                    ShowSoftKeyPadDelay(this.nZH);
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
                            dWf().getText().insert(dWf().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                cFB();
                dMR();
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
                                dWV();
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
                        if (this.obc) {
                            zp(true);
                            this.obc = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.nZX) {
                        G(intent);
                        dHG();
                        return;
                    }
                    ap(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.ncc.setVideoInfo(videoInfo);
                        this.fzf.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.fzf.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.fzf.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    dHG();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.nZC) {
                                sb2.append(com.baidu.tbadk.plugins.b.fJn);
                                this.nZC = false;
                            }
                            sb2.append(stringExtra);
                            CB(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !x.isEmpty(this.mList)) {
                    if (!x.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                        this.nZY = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                        a(this.nZY);
                    }
                } else if (i == 25048) {
                    Serializable serializableExtra = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
                    if (serializableExtra instanceof WriteVoteData) {
                        this.obv = serializableExtra;
                        dWy();
                    }
                } else if (i == 25049 && intent != null) {
                    String str = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                    int selectionStart = this.nZH.getSelectionStart();
                    int selectionEnd = this.nZH.getSelectionEnd();
                    if (selectionStart >= 0) {
                        Editable text = this.nZH.getText();
                        if (selectionEnd > selectionStart) {
                            text.replace(selectionStart, selectionEnd, str);
                        } else {
                            text.insert(selectionStart, str);
                        }
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.fzf != null && !this.fzf.bAT()) {
                this.nZH.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.fzf.bzl();
            }
            switch (i) {
                case 12001:
                    bBF();
                    return;
                case 12002:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    dWT();
                    if (this.obc) {
                        zp(true);
                        this.obc = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.ncu == getCurrentFocus()) {
                        dWf().clearFocus();
                        this.ncu.requestFocus();
                        if (this.fzf != null) {
                            this.fzf.bzl();
                        }
                        ShowSoftKeyPadDelay(this.ncu);
                        return;
                    }
                    dWf().requestFocus();
                    if (this.fzf != null) {
                        this.fzf.bzl();
                    }
                    ShowSoftKeyPadDelay(this.nZH);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.oac.TW(postWriteCallBackData.getErrorString());
                        this.oac.bh(postWriteCallBackData.getSensitiveWords());
                        this.oac.b(this.ncu, this.nZH);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.fBq = String.valueOf(System.currentTimeMillis());
                    an.c(getPageContext(), this.fBq);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dWT();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.nZB)) {
                        dWg().requestFocus();
                        return;
                    } else if ("from_content".equals(this.nZB)) {
                        dWf().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWm() {
        if ("1".equals(this.jHl)) {
            this.ncc.setCanNoForum(true);
            this.ncc.setTransmitForumData("[]");
        } else if ("2".equals(this.jHl)) {
            this.ncc.setCanNoForum(false);
        }
        dWn();
        this.ncc.setPrivacy(this.isPrivacy);
        dWR();
        this.ncc.setToDynamic(this.isToDynamic);
        this.ncc.setCallFrom(this.jHl);
        if (this.ncc.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        cFE();
    }

    private void dWn() {
        if (this.fzf != null) {
            this.fzf.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void dWR() {
        if (this.fzf != null) {
            this.fzf.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void dWS() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void dWT() {
        if (this.nZX) {
            this.oaI.b(this.writeImagesInfo);
            dWU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dWU() {
        this.oaI.notifyDataSetChanged();
        this.oaH.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.51
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.oaI.notifyDataSetChanged();
                WriteActivity.this.oaH.invalidateViews();
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
        dHG();
    }

    private void ao(Intent intent) {
        if (this.nZX) {
            ap(intent);
            dWT();
        } else {
            as(intent);
        }
        dHG();
    }

    private void ap(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            dWT();
            zq(true);
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

    private void dWV() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void ar(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.oaF.parseJson(stringExtra);
            this.oaF.updateQuality();
            if (this.oaF.getChosedFiles() != null && this.oaF.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.oaF.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.oaF.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dWg());
        HidenSoftKeyPad(this.mInputManager, dWf());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
        if (this.obl != null) {
            this.obl.onPause();
        }
        if (this.fzf.bAT()) {
            this.fzf.bzl();
        }
    }

    private void as(Intent intent) {
        e(intent, true);
    }

    private void F(Intent intent) {
        this.fBq = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.fBq;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.getEquipmentWidth(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.fBq, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            dWW();
            dWo();
        }
        zq(true);
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
                dWW();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    dWo();
                }
            }
            zq(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dWW() {
        if (this.fzf.qP(10) != null) {
            this.fzf.setToolEnabled(this.writeImagesInfo == null || x.getCount(this.writeImagesInfo.getChosedFiles()) < this.writeImagesInfo.getMaxImagesAllowed(), 10);
        }
    }

    private void bBF() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.52
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.fBq));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void dWX() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.iYv)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                o oVar = new o(this, this.iYv, new o.a() { // from class: com.baidu.tieba.write.write.WriteActivity.53
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
                            WriteActivity.this.zq(true);
                        }
                    }
                });
                oVar.setFrom(1);
                oVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zq(boolean z) {
        String forumId = this.ncc == null ? "" : this.ncc.getForumId();
        if (this.oaG != null) {
            this.oaG.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.jaA == null) {
            this.jaA = VoiceManager.instance();
        }
        return this.jaA;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cBI() {
        this.jaA = getVoiceManager();
        this.jaA.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bQ(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.jbW) != null) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).an("obj_locate", ax.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.ncc.getType() != 7) {
                if (this.nZM == null) {
                    com.baidu.tieba.tbadkCore.writeModel.g.i(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                I(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.fBx = i;
        if (this.fzf != null) {
            this.fzf.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dWo() {
        if (!this.nZX) {
            if (this.fzf != null) {
                this.fzf.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.fzf.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.ncc == null ? "" : this.ncc.getForumId();
            if (this.oaG != null) {
                this.oaG.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kW(boolean z) {
        if (this.fzf != null) {
            this.fzf.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void Lf(int i) {
        if (i < this.nZK.size()) {
            for (int i2 = 0; i2 < this.nZK.size(); i2++) {
                this.nZK.get(i2).zd(false);
            }
            this.nZK.get(i).zd(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void IO(int i) {
        if (i == x.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new aq("c13014").an("obj_type", 1));
        } else {
            TiebaStatic.log(new aq("c13014").an("obj_type", 2));
        }
        this.ncd = i;
        this.ncA.setCurrentIndex(i);
        Lf(i);
        this.ncz.setText(this.mPrefixData.getPrefixs().get(i));
        dHG();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.ncA, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.ncC.setSelected(false);
        SvgManager.bsx().a(this.ncB, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, (SvgManager.SvgResourceStateType) null);
        ShowSoftKeyPadDelay(this.nZH);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes7.dex */
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
        if (this.ncc != null) {
            if (this.ncc.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.ncc.getType() == 5) {
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
            bBz();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ad.transformPermissionResult(strArr, iArr);
            if (ad.checkCamera(getApplicationContext())) {
                an.c(getPageContext(), this.fBq);
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
        this.bnE = z;
        if (this.oaZ && System.currentTimeMillis() - this.oba < 800) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.oaZ = false;
        }
        if (this.oab != null && !z) {
            this.oab.cvg();
        }
        if (this.oad != null && !z) {
            dVQ();
        }
        if (this.obe != null && !z) {
            dWw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uo(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.oaW != null) {
            Up(str);
            this.oaW.dismiss();
        }
    }

    private void hd(Context context) {
        oaY = l.getEquipmentHeight(context);
    }

    private void Up(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.oaZ = true;
        dWW();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            dWo();
        }
        zq(true);
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

    private File dWY() {
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

    private void dWZ() {
        if (this.oaT != null && this.ncc.getType() == 0 && this.ncc.getType() == 9 && this.ncc.getType() == 11) {
            hd(getActivity());
            this.oaV = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.oaV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.54
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.oaT != null) {
                        WriteActivity.this.Uo(WriteActivity.this.oaT.getAbsolutePath());
                    }
                }
            });
            this.oaU = (TbImageView) this.oaV.findViewById(R.id.rec_img_view);
            this.oaX = (LinearLayout) this.oaV.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.brx().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.oaT.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.brx().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.oaT.getAbsolutePath());
                Bitmap h = h(this.oaT.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (h != null) {
                    this.oaU.setImageBitmap(h);
                    this.oaU.setDrawBorder(true);
                    this.oaU.setBorderWidth(2);
                    this.oaU.setBorderColor(ao.getColor(R.color.common_color_10264));
                    this.oaW = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.oaW.setCanceledOnTouchOutside(true);
                    this.oaW.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.55
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.oaZ) {
                                l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.oba = System.currentTimeMillis();
                            }
                        }
                    });
                    this.oaW.setContentView(this.oaV);
                    this.oaW.show();
                    Window window = this.oaW.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (oaY / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.bnE && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.nZC = false;
            this.nZB = "";
            if ("from_content".equals(str)) {
                this.nZB = "from_content";
            } else if ("from_title".equals(str)) {
                this.nZB = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.Di(String.valueOf(charSequence.charAt(i)))) {
                zm(false);
            }
        }
    }

    public void dBM() {
        if (this.isEvaluate) {
            this.nZG.setVisibility(8);
            if (this.obK != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.obK.getLayoutParams();
                layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                this.obK.setLayoutParams(layoutParams);
            }
            this.oaw.setVisibility(8);
        } else if (com.baidu.tieba.write.b.b.dVc()) {
            this.ncu.setHint(R.string.title_hint_for_hot);
            this.nZG.setVisibility(0);
            if (this.obK != null) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.obK.getLayoutParams();
                layoutParams2.topMargin = 0;
                this.obK.setLayoutParams(layoutParams2);
            }
            this.oaw.setVisibility(0);
            com.baidu.tieba.write.b.b.a(this.oau);
            this.nZG.requestFocus();
        } else {
            this.oau.setVisibility(8);
            this.ncu.setHint(this.oar ? R.string.feedback_title_hint : R.string.post_title_hint);
            if (this.oar || !x.isEmpty(this.mList) || (this.ncc != null && !StringUtils.isNull(this.ncc.getTitle()))) {
                this.nZG.setVisibility(0);
                if (this.obK != null) {
                    LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.obK.getLayoutParams();
                    layoutParams3.topMargin = 0;
                    this.obK.setLayoutParams(layoutParams3);
                }
                this.oaw.setVisibility(0);
                this.nZG.requestFocus();
                return;
            }
            this.nZG.setVisibility(8);
            if (this.obK != null) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.obK.getLayoutParams();
                layoutParams4.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X012);
                this.obK.setLayoutParams(layoutParams4);
            }
            this.oaw.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXa() {
        if (this.fzf != null) {
            this.fzf.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.57
                @Override // java.lang.Runnable
                public void run() {
                    if (WriteActivity.this.fzf != null && WriteActivity.this.fzf.fzi != null) {
                        String clipBoardContent = UtilHelper.getClipBoardContent();
                        if (at.isEmpty(clipBoardContent) || !be.bsB().l(clipBoardContent)) {
                            WriteActivity.this.oab.dur();
                            return;
                        }
                        if (WriteActivity.this.nYl == null) {
                            WriteActivity.this.nYl = new WriteTipBubbleController(WriteActivity.this.getPageContext(), WriteActivity.this.obJ);
                        }
                        WriteActivity.this.nYl.a(WriteActivity.this.fzf.fzi.qN(31), WriteActivity.this.getPageContext().getString(R.string.find_new_link) + "\n" + clipBoardContent, clipBoardContent, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
                    }
                }
            });
        }
    }

    public String getCallFrom() {
        return this.jHl;
    }

    public WriteData cYx() {
        return this.ncc;
    }

    public FrsTabInfoData getFrsTabInfoData() {
        return this.nUa;
    }

    public String getFrom() {
        return this.mFrom;
    }

    private boolean dXb() {
        return (this.obm == null || this.obn == null || this.obm.getWriteVoteData() == null || this.obn.getVisibility() != 0) ? false : true;
    }

    public void dUj() {
        if (!dXf()) {
            BdToast.b(this, getString(R.string.post_goods_no_tab_tip), R.drawable.icon_pure_toast_mistake40_svg, true).bqk();
        } else if (!this.canGoods) {
            BdToast.b(this, getString(R.string.post_goods_tip), R.drawable.icon_pure_toast_mistake40_svg, true).bqk();
        } else {
            if (this.ncc != null) {
                TiebaStatic.log(new aq("c13897").an("obj_locate", 2).dW("fid", this.ncc.getForumId()).dW("fname", this.ncc.getForumName()));
            }
            if (!com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("commodity_goods_show_first_dialog", false)) {
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.nx(2);
                aVar.jE(false);
                FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(getPageContext().getPageActivity());
                frsPublishFineGoodsDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.58
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (aVar != null) {
                            aVar.dismiss();
                            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean("commodity_goods_show_first_dialog", true);
                            TiebaStatic.log(new aq("c13959").an("obj_locate", 2).dW("fid", WriteActivity.this.ncc != null ? WriteActivity.this.ncc.getForumId() : "").dW("fname", WriteActivity.this.ncc != null ? WriteActivity.this.ncc.getForumName() : ""));
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + WriteActivity.this.dXc()));
                        }
                    }
                });
                aVar.br(frsPublishFineGoodsDialogView);
                TiebaStatic.log(new aq("c13958").an("obj_locate", 2).dW("fid", this.ncc != null ? this.ncc.getForumId() : "").dW("fname", this.ncc != null ? this.ncc.getForumName() : ""));
                aVar.b(getPageContext()).bqe();
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + TbadkCoreApplication.getCurrentAccountInfo().getUk() + "&max=" + dXc()));
        }
    }

    public void IZ() {
        if (this.oby != null && this.oby.dVB() == null && this.nZH != null && this.nZH.getSpanGroupManager() != null) {
            this.oby.h(this.nZH.getSpanGroupManager().buR());
            this.oby.refreshData();
        } else if (this.oby != null && this.oby.dVB() != null) {
            this.oby.refreshData();
        }
        if (this.oby != null) {
            gm(this.oby.dVA());
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
            if (!z && this.obz != null) {
                this.obz.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uq(String str) {
        this.obC = new ArrayList();
        ArrayList arrayList = new ArrayList();
        if (!StringUtils.isNull(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(string);
                    this.obC.add(com.baidu.tieba.j.a.er(jSONObject));
                }
                if (this.obC.size() > 0) {
                    this.obF = true;
                    this.nZH.o(this.obC, arrayList);
                    dWE();
                    IZ();
                    this.obz.setVisibility(0);
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dXc() {
        if (this.nZH == null || this.nZH.getSpanGroupManager() == null) {
            return 10;
        }
        return 10 - this.nZH.getSpanGroupManager().buS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dXd() {
        return this.canGoods || this.nZH == null || this.nZH.getSpanGroupManager() == null || this.nZH.getSpanGroupManager().buS() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dXe() {
        boolean z = this.oby == null || this.oby.dVC();
        boolean z2 = (this.oae == null || this.oae.getSelectedTabItemData() == null || this.oae.getSelectedTabItemData().tabType != 3) ? false : true;
        if (z && z2) {
            return 1;
        }
        return (z || z2) ? 0 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dXf() {
        if (this.nUa == null || x.isEmpty(this.nUa.tabList)) {
            return false;
        }
        for (FrsTabItemData frsTabItemData : this.nUa.tabList) {
            if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                return true;
            }
        }
        return false;
    }

    private void dXg() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921500, new CustomMessageTask.CustomRunnable<Boolean>() { // from class: com.baidu.tieba.write.write.WriteActivity.59
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
                if (customMessage != null && customMessage.getData() != null && customMessage.getData().booleanValue()) {
                    new BdTopToast(WriteActivity.this).yS(false).TP(WriteActivity.this.getResources().getString(R.string.user_collection_emotion_unclickable_hint)).aR((ViewGroup) WriteActivity.this.mRootView);
                    return null;
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private String cFD() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (this.obh != null) {
            i = this.obh.getStarCount();
        }
        arrayList.add(new v("", String.valueOf(i), 2));
        return new Gson().toJson(arrayList);
    }
}
