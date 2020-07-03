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
import android.text.Spannable;
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
import com.baidu.tbadk.core.atomData.AddLinkActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleChooseActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.ImageProblemActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AdditionData;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.SaveDraftDialogView;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
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
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.ae;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.bd;
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
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.tieba.write.b.a;
import com.baidu.tieba.write.b.c.b;
import com.baidu.tieba.write.i;
import com.baidu.tieba.write.upload.BaseUploadData;
import com.baidu.tieba.write.upload.ImageTextUploadData;
import com.baidu.tieba.write.view.ForumTabSelectedView;
import com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout;
import com.baidu.tieba.write.view.PostCategoryView;
import com.baidu.tieba.write.write.FindNewLinkBubbleController;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class WriteActivity extends BaseActivity<WriteActivity> implements PopupWindow.OnDismissListener, a.InterfaceC0127a, VoiceManager.c, w.a, i.a {
    private static int muz = 0;
    private EditorTools etN;
    private String evv;
    private LocationModel evw;
    private NewWriteModel evx;
    List<ad> fyR;
    private com.baidu.tbadk.core.dialog.i hLK;
    private SaveDraftDialogView hLL;
    private String hxE;
    private String hxF;
    private String hxG;
    private VoiceManager hzJ;
    private boolean isPrivacy;
    private boolean isToDynamic;
    private LinearLayout khm;
    private PlayVoiceBntNew khn;
    private ImageView khp;
    private TextView lvG;
    private com.baidu.tieba.write.i lvH;
    private ImageView lvI;
    private View lvJ;
    private int lvj;
    private GestureDetector mGestureDetector;
    private List<HotTopicBussinessData> mList;
    private PostTopicData mPostTopicData;
    public PostPrefixData mPrefixData;
    private VoiceData.VoiceModel mVoiceModel;
    private FrsTabInfoData mnb;
    private ForumTabSelectedView mry;
    private FindNewLinkBubbleController msj;
    private int mtA;
    private PostCategoryView mtB;
    private HotTopicBussinessData mtE;
    private TextView mtF;
    private com.baidu.tieba.write.editor.b mtH;
    private e mtJ;
    private com.baidu.tieba.view.b mtQ;
    private LinearLayout mtl;
    private LinearLayout mtm;
    private View mtp;
    private Toast mtr;
    private AdditionData mts;
    private RelativeLayout mtt;
    private TextView mtu;
    private TextView mtv;
    private TextView mtw;
    ad mtx;
    private int mty;
    private String mtz;
    private View muD;
    private View muE;
    private TextView muF;
    private com.baidu.tieba.c.e muH;
    private com.baidu.tieba.write.write.video.a muI;
    private com.baidu.tieba.write.write.vote.a muJ;
    private RelativeLayout muK;
    private boolean muL;
    private View mub;
    private g mui;
    private int privateThread;
    private String mth = "";
    private boolean mti = false;
    protected WriteData lvi = null;
    private boolean mtW = false;
    private boolean mtX = false;
    private boolean mtk = false;
    private boolean mtY = false;
    private int forumLevel = -1;
    private InputMethodManager mInputManager = null;
    private EditText lvA = null;
    private HeadImageView mtZ = null;
    private View lvB = null;
    private LinearLayout lvD = null;
    private SpanGroupEditText mtn = null;
    private FeedBackModel mto = null;
    private FeedBackTopListView mua = null;
    private ArrayList<WritePrefixItemLayout> mtq = new ArrayList<>();
    private String jAv = null;
    private final KeyEvent hlO = new KeyEvent(0, 67);
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView muc = null;
    private TextView lvF = null;
    private TextView mName = null;
    private DialogInterface.OnCancelListener hqD = null;
    private final Handler mHandler = new Handler();
    private boolean mud = false;
    private String mue = null;
    private RelativeLayout iKg = null;
    public boolean muf = true;
    public String evB = null;
    private WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
    private int evC = 0;
    private int mug = 0;
    private WriteImagesInfo muh = new WriteImagesInfo();
    private View mRootView = null;
    private GridView muj = null;
    private com.baidu.tieba.write.view.PhotoLiveView.a muk = null;
    private ScrollView mtC = null;
    private EditText mul = null;
    private View mum = null;
    private View mun = null;
    private View muo = null;
    private EditText mup = null;
    private TextView muq = null;
    private TextView mur = null;
    private TextWatcher mus = null;
    private TextWatcher mut = null;
    private boolean mtD = false;
    private boolean muu = false;
    private com.baidu.tbadk.core.view.a eDA = null;
    private String mFrom = "write";
    private File muv = null;
    private TbImageView muw = null;
    private View mBubbleView = null;
    private Dialog mux = null;
    private LinearLayout muy = null;
    private boolean muA = false;
    private long muB = -1000;
    private boolean muC = false;
    private String ici = "2";
    private int biz = 0;
    private String mTopicId = "";
    private SpannableStringBuilder mtG = new SpannableStringBuilder();
    private boolean muG = false;
    private boolean aXk = false;
    private final b mtI = new b();
    private boolean mrc = false;
    private final HttpMessageListener muM = new HttpMessageListener(1001500) { // from class: com.baidu.tieba.write.write.WriteActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage.getError() == 0) {
                String str = (String) MessageManager.getInstance().runTask(CmdConfigCustom.CMD_DECODE_BUBBLE, String.class, httpResponsedMessage).getData();
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(WriteActivity.this.jAv)) {
                    WriteActivity.this.jAv = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(str);
                    WriteActivity.this.vX(true);
                } else if (!TextUtils.isEmpty(str) && !str.equals(WriteActivity.this.jAv)) {
                    WriteActivity.this.jAv = str;
                    TbadkCoreApplication.getInst().setDefaultBubble(WriteActivity.this.jAv);
                    WriteActivity.this.vX(true);
                }
            }
        }
    };
    private TbFaceManager.a mtK = new TbFaceManager.a() { // from class: com.baidu.tieba.write.write.WriteActivity.12
        @Override // com.baidu.tbadk.imageManager.TbFaceManager.a
        public ImageSpan yM(String str) {
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
    private final AntiHelper.a hAZ = new AntiHelper.a() { // from class: com.baidu.tieba.write.write.WriteActivity.23
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ag("obj_locate", av.a.LOCATE_WRITE));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ag("obj_locate", av.a.LOCATE_WRITE));
        }
    };
    private FindNewLinkBubbleController.a muN = new FindNewLinkBubbleController.a() { // from class: com.baidu.tieba.write.write.WriteActivity.34
        @Override // com.baidu.tieba.write.write.FindNewLinkBubbleController.a
        public void f(View view, String str) {
            if (WriteActivity.this.msj != null) {
                TiebaStatic.log("c13802");
                WriteActivity.this.msj.Kv();
                UtilHelper.clearClipBoard();
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, str, false, null)));
            }
        }
    };
    private final NewWriteModel.d evL = new NewWriteModel.d() { // from class: com.baidu.tieba.write.write.WriteActivity.43
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ad adVar, WriteData writeData, AntiData antiData) {
            WriteActivity.this.bYw();
            WriteActivity.this.closeLoadingDialog();
            WriteActivity.this.muO = true;
            if (postWriteCallBackData != null && WriteActivity.this.lvi != null) {
                WriteActivity.this.mtI.aY(null);
                if (z) {
                    WriteActivity.this.in(z);
                    if (WriteActivity.this.e(writeData) || WriteActivityConfig.FROM_FORUM_SHARE.equals(WriteActivity.this.mFrom)) {
                        WriteActivity.this.c(true, postWriteCallBackData);
                    }
                    WriteActivity.this.cbY();
                    WriteActivity.this.dtp();
                    if ((WriteActivity.this.lvi.getType() == 0 || WriteActivity.this.lvi.getType() == 9) && !com.baidu.tbadk.core.util.w.isEmpty(WriteActivity.this.mList) && !StringUtils.isNull(WriteActivity.this.mTopicId)) {
                        TiebaStatic.log(new ao("c11731").dk("obj_id", WriteActivity.this.mTopicId));
                    }
                    WriteActivity.this.k(postWriteCallBackData);
                    if (!ar.isEmpty(postWriteCallBackData.getVideoid()) && WriteActivity.this.lvi.getVideoInfo() != null) {
                        postWriteCallBackData.mVideoMd5 = WriteActivity.this.lvi.getVideoInfo().getVideoMd5();
                        if (!ar.isEmpty(WriteActivity.this.lvi.getForumName())) {
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
                    WriteActivity.this.mtI.aY(postWriteCallBackData.getSensitiveWords());
                    WriteActivity.this.mtI.OM(postWriteCallBackData.getErrorString());
                    WriteActivity.this.mtI.b(WriteActivity.this.lvA, WriteActivity.this.mtn);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (ar.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.c(WriteActivity.this.getActivity(), WriteActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.c(WriteActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(WriteActivity.this.getActivity());
                    if (ar.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.we(WriteActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                    } else {
                        aVar.we(postWriteCallBackData.getErrorString());
                    }
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.43.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                        }
                    });
                    aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.43.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(WriteActivity.this.getActivity(), 0, 26, 1)));
                            TiebaStatic.log(new ao("c13746").ag("obj_locate", 1).ag("obj_type", 1));
                        }
                    });
                    aVar.b(WriteActivity.this.getPageContext()).aUN();
                    TiebaStatic.log(new ao("c13745").ag("obj_locate", 1).ag("obj_type", 1));
                } else if ((adVar == null || writeData == null || adVar.getVcode_pic_url() == null || AntiHelper.e(antiData)) && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() != 227001) {
                    WriteActivity.this.c(false, postWriteCallBackData);
                } else if (adVar != null && writeData != null && adVar.getVcode_pic_url() != null) {
                    if (writeData.isCanNoForum()) {
                        writeData.setForumName("");
                        writeData.setForumId("0");
                    }
                    writeData.setVcodeMD5(adVar.getVcode_md5());
                    writeData.setVcodeUrl(adVar.getVcode_pic_url());
                    writeData.setVcodeExtra(adVar.bas());
                    if (com.baidu.tbadk.t.a.zq(adVar.bar())) {
                        NewVcodeActivityConfig newVcodeActivityConfig = new NewVcodeActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_VCODE, writeData, false, adVar.bar());
                        if (WriteActivity.this.mtY) {
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
    private final LocationModel.a evJ = new LocationModel.a() { // from class: com.baidu.tieba.write.write.WriteActivity.44
        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
        public void bfT() {
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
            if (aVar != null && !StringUtils.isNull(aVar.diB())) {
                WriteActivity.this.a(2, true, aVar.diB());
            } else {
                onFail(null);
            }
        }
    };
    private final CustomMessageListener lIo = new CustomMessageListener(CmdConfigCustom.CMD_SELECT_LOCATION) { // from class: com.baidu.tieba.write.write.WriteActivity.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ResponsedSelectLocation) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WriteActivity.this.evw.uL(false);
                    WriteActivity.this.evw.fB(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    WriteActivity.this.a(2, true, responsedSelectLocation.getName());
                    return;
                }
                WriteActivity.this.evw.uL(true);
                WriteActivity.this.a(0, true, (String) null);
            }
        }
    };
    private CustomMessageListener mtL = new CustomMessageListener(CmdConfigCustom.CMD_UEG_VALIDATE_TIPS) { // from class: com.baidu.tieba.write.write.WriteActivity.46
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                WriteActivity.this.showToast((String) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener mBackgroundListener = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.write.write.WriteActivity.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                WriteActivity.this.dtG();
            }
        }
    };
    private final View.OnClickListener mtM = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WriteActivity.this.etN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
            int dsH = WriteActivity.this.dsH();
            if (dsH >= 0 && dsH < WriteActivity.this.mtn.getText().length()) {
                WriteActivity.this.mtn.setSelection(dsH);
            }
        }
    };
    private boolean mtN = true;
    private final View.OnFocusChangeListener gbk = new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.5
        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (view == WriteActivity.this.lvA || view == WriteActivity.this.mBack || view == WriteActivity.this.lvF) {
                if (z) {
                    WriteActivity.this.mtN = true;
                    WriteActivity.this.dsI();
                    l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.lvA);
                    if (WriteActivity.this.etN != null) {
                        WriteActivity.this.etN.bdC();
                    }
                } else if (view == WriteActivity.this.lvA) {
                    WriteActivity.this.lvG.setVisibility(0);
                }
            }
            if (view == WriteActivity.this.mtn && z) {
                WriteActivity.this.mtN = false;
                WriteActivity.this.dsI();
                l.showSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.mtn);
                if (WriteActivity.this.etN != null) {
                    WriteActivity.this.etN.bdC();
                }
            }
            WriteActivity.this.dsN();
        }
    };
    private boolean muO = false;
    private TextWatcher mtO = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.14
        private String mtS = "";
        private String mtT;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mtT = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.mtT != null ? this.mtT.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_title");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.deC();
            WriteActivity.this.dsO();
            EditText dta = WriteActivity.this.dta();
            if (editable != null && dta != null && dta.getText() != null) {
                if (this.mtS == null || !this.mtS.equals(editable.toString())) {
                    if (WriteActivity.this.mtI != null) {
                        this.mtS = dta.getText().toString();
                        WriteActivity.this.mtI.b(dta, true);
                        return;
                    }
                    return;
                }
                dta.setSelection(dta.getSelectionEnd());
            }
        }
    };
    private TextWatcher mtP = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.15
        private String mtT;
        private String mtU = "";

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mtT = charSequence != null ? charSequence.toString() : "";
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if ((charSequence != null ? charSequence.toString().length() : 0) > (this.mtT != null ? this.mtT.toString().length() : 0)) {
                WriteActivity.this.a(charSequence, i, i3, "from_content");
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WriteActivity.this.deC();
            EditText dsZ = WriteActivity.this.dsZ();
            if (editable != null && dsZ != null && dsZ.getText() != null) {
                if (this.mtU == null || !this.mtU.equals(editable.toString())) {
                    if (WriteActivity.this.mtI != null) {
                        this.mtU = dsZ.getText().toString();
                        WriteActivity.this.mtI.b(dsZ, false);
                        return;
                    }
                    return;
                }
                dsZ.setSelection(dsZ.getSelectionEnd());
            }
        }
    };
    private final a.InterfaceC0743a knN = new a.InterfaceC0743a() { // from class: com.baidu.tieba.write.write.WriteActivity.32
        @Override // com.baidu.tieba.tbadkCore.b.a.InterfaceC0743a
        public void onRefresh() {
            WriteActivity.this.jAv = null;
            WriteActivity.this.vX(false);
            WriteActivity.this.etN.b(new com.baidu.tbadk.editortools.a(2, 12, null));
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
    public void bfC() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SelectLocationActivityConfig(getPageContext().getPageActivity())));
    }

    public void bfE() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bfG();
        } else if (this.evw.diI()) {
            bfC();
        } else {
            this.evw.uL(false);
            a(1, true, (String) null);
            this.evw.diG();
        }
    }

    public void dtj() {
        if (!UtilHelper.isSystemLocationProviderEnabled(getPageContext().getPageActivity())) {
            showToast(R.string.location_system_permission_prompt);
            a(0, true, (String) null);
            if (this.mtH != null) {
                this.mtH.drz();
            }
        } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
            bfG();
        } else if (this.evw != null) {
            this.evw.uL(false);
            a(1, true, (String) null);
            this.evw.diG();
        }
    }

    private void bfG() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.kT(R.string.location_app_permission_prompt).a(R.string.isopen, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.a(1, true, (String) null);
                    WriteActivity.this.evw.diK();
                } else {
                    WriteActivity.this.evJ.bfT();
                }
                aVar2.dismiss();
            }
        }).b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.write.write.WriteActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                WriteActivity.this.a(0, true, (String) null);
                aVar2.dismiss();
            }
        }).b(getPageContext());
        aVar.aUN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dsH() {
        int selectionEnd = dsZ().getSelectionEnd();
        ImageSpan[] imageSpanArr = (ImageSpan[]) dsZ().getText().getSpans(0, dsZ().getText().length(), ImageSpan.class);
        for (int i = 0; i < imageSpanArr.length; i++) {
            int spanStart = dsZ().getText().getSpanStart(imageSpanArr[i]);
            int spanEnd = dsZ().getText().getSpanEnd(imageSpanArr[i]);
            if (selectionEnd > spanStart && selectionEnd < spanEnd) {
                return spanEnd;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsI() {
        if (this.etN != null) {
            if (this.muI != null && this.muI.isVisible()) {
                this.etN.setBarLauncherEnabled(false);
                this.etN.setDeskLauncherEnabled(false);
                this.etN.setToolEnabled(true, 2);
                if (this.mtH != null) {
                    this.mtH.vO(false);
                    return;
                }
                return;
            }
            this.etN.setBarLauncherEnabled(!this.mtN);
            this.etN.setDeskLauncherEnabled(this.mtN ? false : true);
            this.etN.setToolEnabled(true, 26);
            this.etN.setToolEnabled(true, 2);
            this.etN.setToolEnabled(true, 30);
            if (this.mtH != null) {
                this.mtH.vO(true);
            }
            dtC();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getVoiceManager().onResume(getPageContext());
        if (this.mtD) {
            this.lvA.setVisibility(8);
            if (this.lvi.getType() == 5) {
                this.muo.setVisibility(8);
            } else {
                this.muo.setVisibility(0);
            }
            a(this.mur, this.mul);
            a(this.muq, this.mup);
            deC();
        }
        if (this.mtW) {
            this.mtN = true;
            dsI();
            if (this.etN != null) {
                this.etN.bdC();
            }
            this.lvA.requestFocus();
            ShowSoftKeyPadDelay(this.lvA);
        }
        if (this.muI != null) {
            this.muI.onResume();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
        if (this.muI != null) {
            this.muI.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        getWindow().setSoftInputMode(18);
        if (this.muI != null) {
            this.muI.onStop();
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
                    dth();
                }
                vY(true);
            }
            Serializable serializableExtra = intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                this.lvi.setVideoInfo((VideoInfo) serializableExtra);
            } else {
                this.lvi.setVideoInfo(null);
            }
            if (this.muI == null) {
                this.muI = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            }
            if (this.lvi.getVideoInfo() != null && this.lvi.getVideoInfo().isEditVideoDataLegal()) {
                vW(false);
                this.muI.dur();
                if (this.mtm != null && this.mtm.getVisibility() == 0) {
                    this.mtm.setVisibility(8);
                    if (this.etN != null) {
                        this.etN.ny(30).setName(getResources().getString(R.string.editor_add_title));
                    }
                }
                if (dsZ() != null && e(dsZ().getText())) {
                    dsZ().setText("");
                    this.lvi.setContent("");
                    return;
                }
                return;
            }
            vW(true);
        }
    }

    public void Pk(String str) {
        showToastWithDefaultIcon(str, BdToast.DefaultIcon.FAILURE);
    }

    public void vW(boolean z) {
        if (z) {
            this.lvi.setVideoInfo(null);
            this.muI.setVideoInfo(null);
            this.mui.dtK().setVisibility(0);
            vX(false);
        } else {
            this.muI.setVideoInfo(this.lvi.getVideoInfo());
            this.writeImagesInfo.clear();
            this.mui.dtK().setVisibility(8);
            dts();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_BUBBLE_TOOL_RED_DOT, false));
        }
        deC();
        dsI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        this.mGestureDetector = new GestureDetector(getPageContext().getPageActivity(), new a());
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        initData(bundle);
        if (this.lvi.getType() == 0) {
            GV(this.biz);
        }
        initUI();
        dtr();
        this.evw = new LocationModel(getPageContext());
        this.evw.a(this.evJ);
        registerListener(this.lIo);
        registerListener(this.mtL);
        registerListener(this.mBackgroundListener);
        cBv();
        dtF();
        if (this.mtD) {
            this.muk.setEditorTools(this.etN);
        } else {
            this.mtn.requestFocus();
        }
        cZC();
        dth();
        dtD();
    }

    @SuppressLint({"ResourceAsColor"})
    private void cBv() {
        this.etN = new EditorTools(getActivity());
        this.etN.setBarMaxLauCount(5);
        this.etN.setMoreButtonAtEnd(true);
        this.etN.setBarBackgroundColorId(R.color.cp_bg_line_h);
        this.etN.setBarLauncherType(1);
        this.etN.m32if(true);
        this.etN.ig(true);
        switch (this.lvi.getType()) {
            case 4:
            case 5:
                dtm();
                break;
            default:
                dsJ();
                break;
        }
        this.etN.build();
        if (this.mtl != null) {
            this.mtl.addView(this.etN);
        }
        cvh();
        this.etN.display();
        com.baidu.tbadk.editortools.g ny = this.etN.ny(6);
        if (ny != null && !TextUtils.isEmpty(this.evB)) {
            ((View) ny).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.showToast(WriteActivity.this.evB);
                }
            });
        }
        if (!this.mtD) {
            this.etN.b(new com.baidu.tbadk.editortools.a(34, 5, 1));
        }
        this.etN.bdC();
        if (XiaoyingUtil.showXiaoyingTool() && !com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, false)) {
            this.etN.b(new com.baidu.tbadk.editortools.a(2, 19, "N"));
        }
        if (!com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, false)) {
            this.etN.b(new com.baidu.tbadk.editortools.a(2, 26, " "));
        }
        if (!this.mrc) {
            dsL();
        }
        dtG();
    }

    private void dtk() {
        this.mum = this.mRootView.findViewById(R.id.photo_live_scroll);
        this.muo = this.mum.findViewById(R.id.live_post_title_container);
        this.mul = (EditText) this.mum.findViewById(R.id.live_post_content);
        this.muj = (GridView) this.mum.findViewById(R.id.photoLiveGridView);
        this.mup = (EditText) this.mum.findViewById(R.id.live_post_title);
        this.muq = (TextView) this.mum.findViewById(R.id.titleOverPlusNumber);
        this.mur = (TextView) this.mum.findViewById(R.id.contentOverPlusNumber);
        this.mun = this.mum.findViewById(R.id.live_interval_view);
        this.muq.setText(String.valueOf(20));
        this.mur.setText(String.valueOf(233));
        this.mum.setVisibility(0);
        this.muq.setVisibility(0);
        this.mur.setVisibility(0);
        this.mup.setHint(R.string.tips_title_limit_new);
        this.mup.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.7
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.muu = true;
                    WriteActivity.this.mtN = true;
                    WriteActivity.this.dsI();
                    if (WriteActivity.this.etN != null) {
                        WriteActivity.this.etN.bdC();
                    }
                }
            }
        });
        if (this.lvi.getType() == 4) {
            this.mul.setHint(R.string.live_write_input_content_new);
        } else if (this.lvi.getType() == 5) {
            this.mul.setHint(R.string.live_write_input_content_update);
        }
        this.mul.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.write.write.WriteActivity.8
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    WriteActivity.this.muu = false;
                    WriteActivity.this.mtN = false;
                    WriteActivity.this.dsI();
                    if (WriteActivity.this.etN != null) {
                        WriteActivity.this.etN.bdC();
                    }
                }
            }
        });
        this.mul.requestFocus();
        this.mul.addTextChangedListener(afN());
        this.mup.requestFocus();
        this.mup.addTextChangedListener(afN());
        this.mup.setOnClickListener(this.mtM);
        this.mul.setOnClickListener(this.mtM);
        this.muk = new com.baidu.tieba.write.view.PhotoLiveView.a(this, this.writeImagesInfo, this.muj);
        this.muk.GP(6);
        this.muj.setAdapter((ListAdapter) this.muk);
        View findViewById = this.mum.findViewById(R.id.live_post_content_container);
        findViewById.bringToFront();
        ((PhotoLiveLinearLayout) findViewById).setOnChangeLayoutListener(new PhotoLiveLinearLayout.a() { // from class: com.baidu.tieba.write.write.WriteActivity.9
            @Override // com.baidu.tieba.write.view.PhotoLiveView.PhotoLiveLinearLayout.a
            public void dsr() {
                WriteActivity.this.dtA();
            }
        });
        dtl();
    }

    private void dtl() {
        if (this.lvi.getType() == 0) {
            if (this.lvi.getTitle() != null) {
                this.mup.setText(this.lvi.getTitle());
                this.mup.setSelection(this.lvi.getTitle().length());
                return;
            }
            return;
        }
        if (this.lvi.getType() == 1 || this.lvi.getType() != 2) {
        }
    }

    public void e(com.baidu.tbadk.editortools.a aVar) {
        if (this.mtD) {
            dty();
        }
        if (this.etN.bfc()) {
            this.etN.bdC();
        }
        GV(0);
    }

    public boolean dro() {
        return (this.writeImagesInfo.size() == 0 && this.mVoiceModel == null && ((this.mtm == null || this.mtm.getVisibility() != 0) && ((this.mtn == null || !this.mtn.aYY()) && !dtI()))) && (dsZ() == null || !e(dsZ().getText()));
    }

    private boolean e(Spannable spannable) {
        if (spannable != null) {
            ImageSpan[] imageSpanArr = (ImageSpan[]) spannable.getSpans(0, spannable.length(), ImageSpan.class);
            if (imageSpanArr != null && imageSpanArr.length > 0) {
                return true;
            }
            if (this.mtI != null) {
                if (this.mtI.d(spannable)) {
                    return true;
                }
            }
            if (bc.aWU().l(spannable)) {
                return true;
            }
        }
        return false;
    }

    private void GV(int i) {
        if (this.writeImagesInfo != null && this.lvi != null) {
            AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(getPageContext().getPageActivity(), this.writeImagesInfo.toJsonString(), true, true);
            albumFloatActivityConfig.getIntent().putExtra("forum_id", this.lvi.getForumId());
            albumFloatActivityConfig.getIntent().putExtra("forum_name", this.lvi.getForumName());
            albumFloatActivityConfig.getIntent().putExtra("from", this.mFrom);
            albumFloatActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
            albumFloatActivityConfig.setAlbumThread(i);
            albumFloatActivityConfig.setCanSelectVideo(dro());
            albumFloatActivityConfig.setFromWrite(true);
            albumFloatActivityConfig.setCallFrom(this.ici);
            albumFloatActivityConfig.setProfessionZone(this.lvi.getProZone());
            albumFloatActivityConfig.setFrsTabInfo(this.mnb);
            AntiData antiData = new AntiData();
            antiData.voice_message = this.evB;
            antiData.setIfVoice(this.muf);
            albumFloatActivityConfig.setExtraData(antiData, this.mPrefixData, this.lvi.getFirstDir(), this.lvi.getSecondDir());
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumFloatActivityConfig));
        }
    }

    private void dtm() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(10);
        arrayList.add(5);
        this.etN.aW(arrayList);
        com.baidu.tbadk.editortools.l nB = this.etN.nB(5);
        if (nB != null) {
            nB.euy = 2;
        }
        this.etN.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        this.etN.b(new com.baidu.tbadk.editortools.imagetool.b(getActivity(), 6));
    }

    private void dsJ() {
        CustomResponsedMessage runTask;
        com.baidu.tbadk.editortools.l lVar;
        CustomResponsedMessage runTask2;
        com.baidu.tbadk.editortools.l lVar2;
        CustomResponsedMessage runTask3;
        com.baidu.tbadk.editortools.l lVar3;
        CustomResponsedMessage runTask4;
        com.baidu.tbadk.editortools.l lVar4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        com.baidu.tbadk.editortools.imagetool.d dVar = new com.baidu.tbadk.editortools.imagetool.d(getActivity(), 1);
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            this.etN.b(dVar);
        }
        if (!this.mrc) {
            Boolean dtv = dtv();
            if (!this.mtW && dtv != null && dtv.booleanValue() && com.baidu.tieba.tbadkCore.voice.c.djm() && s.d(this.lvi.getForumName(), true) && (runTask4 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_NEW_SEND_VOICE_VIEW, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar4 = (com.baidu.tbadk.editortools.l) runTask4.getData()) != null) {
                lVar4.euy = 2;
                if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                    this.etN.b(lVar4);
                }
            }
        }
        if (!this.mrc && (runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_PRIVILEGE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar3 = (com.baidu.tbadk.editortools.l) runTask3.getData()) != null) {
            lVar3.euy = 5;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.etN.b(lVar3);
            }
        }
        if (!this.mrc) {
            this.etN.b(new com.baidu.tbadk.editortools.k(getActivity(), 6));
        }
        if (!this.mrc) {
            this.etN.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 7));
        } else {
            this.etN.b(new com.baidu.tbadk.editortools.a.a(getActivity(), 3));
        }
        if (ar.equals(this.ici, "2")) {
            this.etN.b(new com.baidu.tbadk.editortools.c.a(getActivity(), 3));
            this.etN.b(new com.baidu.tbadk.editortools.e.a(getActivity(), 8));
        }
        if (!this.mrc && (runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_BUBBLE_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar2 = (com.baidu.tbadk.editortools.l) runTask2.getData()) != null) {
            lVar2.euA = true;
            lVar2.euy = 9;
            lVar2.eut = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.etN.b(lVar2);
            }
        }
        if (!this.mrc && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_TAIL_TOOL_CRTL, getActivity()), com.baidu.tbadk.editortools.l.class)) != null && (lVar = (com.baidu.tbadk.editortools.l) runTask.getData()) != null) {
            lVar.euA = true;
            lVar.euy = 10;
            lVar.eut = 0;
            if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.etN.b(lVar);
            }
        }
        if (!this.mrc && this.mts == null) {
            if (this.mtH == null) {
                this.mtH = new com.baidu.tieba.write.editor.b(getActivity(), this.ici);
                this.mtH.bJ(this.lvi.getForumId(), this.privateThread);
                this.mtH.vN(SwitchManager.getInstance().findType(RepostToDynamicDefaultSwitch.KEY) == 1);
            }
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.mtH.drx();
                this.mtH.setFrom(WriteActivityConfig.FROM_FORUM_SHARE);
                dtj();
            }
            if (!com.baidu.tbadk.core.util.w.isEmpty(this.mList)) {
                this.mtH.drx();
            }
            this.etN.b(this.mtH);
        }
        this.etN.aW(arrayList);
        com.baidu.tbadk.editortools.l nB = this.etN.nB(5);
        if (nB != null) {
            nB.euy = 4;
        }
    }

    private void dsK() {
        if (this.mtJ != null) {
            this.mtJ.hideTip();
        }
    }

    private void dsL() {
        if (this.mtJ == null) {
            this.mtJ = new e(getPageContext());
        }
        this.mtJ.c(this.etN);
    }

    private void cvh() {
        com.baidu.tbadk.editortools.b bVar = new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.write.write.WriteActivity.10
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                VideoInfo videoInfo;
                WriteVoteData writeVoteData = null;
                if (aVar != null) {
                    if (aVar.code == 16) {
                        TiebaStatic.log(new ao("c12612").ag("obj_locate", 9));
                        if (WriteActivity.this.dsY()) {
                            WriteActivity.this.showToast(R.string.over_limit_tip);
                        } else {
                            WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtListActivityConfig(WriteActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_AT_SELECT, true)));
                        }
                    } else if (aVar.code == 14 || aVar.code == 48) {
                        TiebaStatic.log(new ao("c12612").ag("obj_locate", 1));
                        WriteActivity.this.e(aVar);
                    } else if (aVar.code == 24) {
                        if (aVar.data != null && (aVar.data instanceof q)) {
                            q qVar = (q) aVar.data;
                            if (qVar.bai() == EmotionGroupType.BIG_EMOTION || qVar.bai() == EmotionGroupType.USER_COLLECT) {
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
                                    WriteActivity.this.vY(true);
                                    WriteActivity.this.deC();
                                }
                            } else if (WriteActivity.this.dsY()) {
                                WriteActivity.this.showToast(R.string.over_limit_tip);
                            } else {
                                WriteActivity.this.e(qVar);
                            }
                        }
                    } else if (aVar.code == 3) {
                        WriteActivity.this.dtb();
                    } else if (aVar.code == 10) {
                        if (aVar.data instanceof VoiceData.VoiceModel) {
                            WriteActivity.this.e((VoiceData.VoiceModel) aVar.data);
                        }
                    } else if (aVar.code == 11) {
                        WriteActivity.this.cJQ();
                    } else if (aVar.code == 12 || aVar.code == 13 || aVar.code == 46 || aVar.code == 49) {
                        WriteActivity.this.dtC();
                        WriteActivity.this.deC();
                    } else if (aVar.code == 15 || aVar.code == 47) {
                        if (aVar.data != null && (aVar.data instanceof Integer)) {
                            WriteActivity.this.GW(((Integer) aVar.data).intValue());
                        }
                    } else if (aVar.code == 18) {
                        if (aVar.data != null && WriteActivity.this.mts == null) {
                            WriteActivity.this.bfH();
                            return;
                        }
                        switch (WriteActivity.this.evC) {
                            case 0:
                                Activity pageActivity = WriteActivity.this.getPageContext().getPageActivity();
                                if (ac.checkLocationForGoogle(pageActivity)) {
                                    WriteActivity.this.bfE();
                                    return;
                                } else {
                                    ac.d(pageActivity, 0);
                                    return;
                                }
                            case 1:
                            default:
                                return;
                            case 2:
                                WriteActivity.this.bfC();
                                return;
                        }
                    } else if (aVar.code == 20) {
                        if (WriteActivity.this.evw != null) {
                            WriteActivity.this.evw.uL(true);
                        }
                    } else if (aVar.code == 25) {
                        if (aVar.data == null || !(aVar.data instanceof String)) {
                            WriteActivity.this.jAv = null;
                        } else {
                            WriteActivity.this.jAv = (String) aVar.data;
                        }
                        WriteActivity.this.vX(false);
                    } else if (aVar.code == 27) {
                        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.XIAOYING_HAS_CLICK, true);
                        ao aoVar = new ao("c10645");
                        aoVar.dk("fid", WriteActivity.this.lvi != null ? WriteActivity.this.lvi.getForumId() : "");
                        TiebaStatic.log(aoVar);
                        if (WriteActivity.this.lvi == null || (videoInfo = WriteActivity.this.lvi.getVideoInfo()) == null || !videoInfo.isAvaliable()) {
                            WriteActivity.this.etN.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                            if (XiaoyingUtil.isXiaoyingInstalled()) {
                                if (!XiaoyingUtil.isXiaoyingForbidden()) {
                                    if (WriteActivity.this.etN.bfc()) {
                                        WriteActivity.this.etN.bdC();
                                        WriteActivity.this.etN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
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
                        WriteActivity.this.etN.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        WriteActivity.this.etN.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else if (aVar.code == 29) {
                        WriteActivity.this.etN.b(new com.baidu.tbadk.editortools.a(2, 19, null));
                        WriteActivity.this.etN.b(new com.baidu.tbadk.editortools.a(1, 2, null));
                        WriteActivity.this.lvi.setVideoInfo(null);
                        WriteActivity.this.deC();
                        if (WriteActivity.this.mtn != null) {
                            WriteActivity.this.mtn.requestFocus();
                        }
                        WriteActivity.this.etN.bdC();
                        WriteActivity.this.etN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        WriteActivity.this.ShowSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mtn);
                    } else if (aVar.code == 43) {
                        TiebaStatic.log(new ao("c12612").ag("obj_locate", 4));
                        com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.HOT_TOPIC_HAS_CLICK, true);
                        WriteActivity.this.etN.b(new com.baidu.tbadk.editortools.a(2, 26, null));
                        WriteActivity.this.mti = true;
                        WriteActivity.this.vU(true);
                        if (!WriteActivity.this.dta().isFocused() || WriteActivity.this.mtm.getVisibility() != 0) {
                            WriteActivity.this.mth = "from_content";
                        } else {
                            WriteActivity.this.mth = "from_title";
                        }
                    } else if (aVar.code == 56) {
                        TiebaStatic.log(new ao("c12612").ag("obj_locate", 8));
                        if (WriteActivity.this.mtm.getVisibility() == 0) {
                            if (WriteActivity.this.mtm.hasFocus()) {
                                WriteActivity.this.mtn.requestFocus();
                                WriteActivity.this.mtn.setSelection(WriteActivity.this.mtn.getText().toString().length());
                            }
                            WriteActivity.this.mtm.setVisibility(8);
                            WriteActivity.this.etN.ny(30).setName(WriteActivity.this.getResources().getString(R.string.editor_add_title));
                        } else {
                            WriteActivity.this.mtm.setVisibility(0);
                            WriteActivity.this.mtm.requestFocus();
                            WriteActivity.this.etN.ny(30).setName(WriteActivity.this.getResources().getString(R.string.editor_hide_title));
                        }
                        WriteActivity.this.deC();
                    } else if (aVar.code == 55) {
                        if (aVar.data != null && (aVar.data instanceof Boolean)) {
                            WriteActivity.this.isPrivacy = ((Boolean) aVar.data).booleanValue();
                        }
                    } else if (aVar.code == 58) {
                        if (aVar.data != null && (aVar.data instanceof Boolean)) {
                            WriteActivity.this.isToDynamic = ((Boolean) aVar.data).booleanValue();
                        }
                    } else if (aVar.code == 22) {
                        Intent intent = WriteActivity.this.getIntent();
                        if (intent != null) {
                            TiebaStatic.log(new ao("c12612").ag("obj_locate", 10));
                            int intExtra = intent.getIntExtra(WriteActivityConfig.KEY_ANTI_POLL_LEVEL, 0);
                            if (intent.getIntExtra("key_write_level", -1) >= intExtra) {
                                if (WriteActivity.this.muJ != null && WriteActivity.this.muJ.getWriteVoteData() != null) {
                                    writeVoteData = WriteActivity.this.muJ.getWriteVoteData();
                                }
                                WriteActivity.this.a(writeVoteData);
                                TiebaStatic.log(new ao("c13800").ag("obj_source", 2));
                                return;
                            }
                            WriteActivity.this.showToast(String.format(WriteActivity.this.getResources().getString(R.string.vote_level_tip), Integer.valueOf(intExtra)));
                        }
                    } else if (aVar.code == 21) {
                        if (WriteActivity.this.msj != null) {
                            WriteActivity.this.msj.Kv();
                        }
                        TiebaStatic.log(new ao("c12612").ag("obj_locate", 5));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddLinkActivityConfig(WriteActivity.this.getActivity(), RequestResponseCode.REQUESTCODE_FILECHOOSER, "", true, null)));
                    }
                }
            }
        };
        this.etN.setActionListener(16, bVar);
        this.etN.setActionListener(14, bVar);
        this.etN.setActionListener(24, bVar);
        this.etN.setActionListener(3, bVar);
        this.etN.setActionListener(10, bVar);
        this.etN.setActionListener(11, bVar);
        this.etN.setActionListener(12, bVar);
        this.etN.setActionListener(13, bVar);
        this.etN.setActionListener(15, bVar);
        this.etN.setActionListener(18, bVar);
        this.etN.setActionListener(20, bVar);
        this.etN.setActionListener(25, bVar);
        this.etN.setActionListener(27, bVar);
        this.etN.setActionListener(29, bVar);
        this.etN.setActionListener(43, bVar);
        this.etN.setActionListener(56, bVar);
        this.etN.setActionListener(48, bVar);
        this.etN.setActionListener(46, bVar);
        this.etN.setActionListener(49, bVar);
        this.etN.setActionListener(47, bVar);
        this.etN.setActionListener(55, bVar);
        this.etN.setActionListener(58, bVar);
        this.etN.setActionListener(22, bVar);
        this.etN.setActionListener(21, bVar);
    }

    private void ao(Intent intent) {
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
            if (serializableExtra instanceof WriteVoteData) {
                final WriteVoteData writeVoteData = (WriteVoteData) serializableExtra;
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        WriteActivity.this.a(writeVoteData);
                        TiebaStatic.log(new ao("c13800").ag("obj_source", 3));
                    }
                };
                this.muJ.am(onClickListener);
                this.muJ.setOnItemClickListener(onClickListener);
                this.muJ.b(writeVoteData);
                this.muJ.wa(true);
                deC();
            }
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
    public void GW(int i) {
        int size;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && (size = this.writeImagesInfo.getChosedFiles().size()) >= 1 && i >= 0 && i < size) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfH() {
        if (this.evw.bKs()) {
            if (this.evw.diI()) {
                a(2, true, com.baidu.tieba.tbadkCore.location.c.diD().getLocationData().diB());
                return;
            }
            a(1, true, (String) null);
            this.evw.diG();
            return;
        }
        a(0, true, (String) null);
    }

    protected void det() {
        if (this.evx != null) {
            this.evx.cancelLoadData();
        }
        if (this.mto != null) {
            this.mto.cancelLoadData();
        }
        if (this.evw != null) {
            this.evw.cancelLoadData();
        }
        if (this.muI != null) {
            this.muI.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        dsK();
        TiebaPrepareImageService.StopService();
        det();
        if (!this.muO) {
            dtn();
        }
        com.baidu.adp.lib.f.g.dismissDialog(this.hLK, this);
        super.onDestroy();
        getVoiceManager().onDestory(getPageContext());
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mui != null) {
            this.mui.destroy();
        }
        if (this.muH != null) {
            this.muH.HH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtn() {
        if (this.lvi != null && this.lvi.getType() == 2 && this.mud) {
            finish();
        } else if (this.lvi == null) {
            finish();
        } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            finish();
        } else {
            this.lvi.setTitle(dta().getText().toString());
            this.lvi.setContent(dsZ().getText().toString());
            int type = this.lvi.getType();
            if (type == 0 || type == 9) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    if (this.mrc) {
                        w.e(this.lvi.getForumId(), this.lvi);
                    } else {
                        w.d(this.lvi.getForumId(), this.lvi);
                    }
                }
            } else if (type == 7) {
                if (getIntent().getBooleanExtra("need_save_draft", true)) {
                    w.d("24591571", this.lvi);
                }
            } else if (type == 1) {
                w.f(this.lvi.getThreadId(), this.lvi);
            } else if (type == 4) {
                w.d(this.lvi.getForumId() + "photolive", this.lvi);
            } else if (type == 5) {
                w.f(this.lvi.getThreadId() + "updatephotolive", this.lvi);
            }
            this.muO = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dto() {
        if (this.lvF == null || !this.lvF.isEnabled() || this.muL) {
            cbY();
            dtp();
            setResult(100);
            finish();
            return;
        }
        if (this.hLL == null) {
            this.hLL = new SaveDraftDialogView(this);
            this.hLL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (view != null) {
                        int id = view.getId();
                        if (id == R.id.save_draft_dialog_not_save) {
                            WriteActivity.this.cbY();
                            WriteActivity.this.dtp();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        } else if (id == R.id.save_draft_dialog_save) {
                            WriteActivity.this.dtn();
                            WriteActivity.this.setResult(100);
                            WriteActivity.this.finish();
                        }
                        WriteActivity.this.hLK.dismiss();
                    }
                }
            });
        }
        if (this.hLK == null) {
            this.hLK = new com.baidu.tbadk.core.dialog.i(getPageContext());
            this.hLK.setContentView(this.hLL);
        }
        boolean z = (this.muI == null || !this.muI.isVisible() || this.lvi == null || this.lvi.getVideoInfo() == null || this.lvi.getVideoInfo().isVideoMixFinished()) ? false : true;
        this.hLL.setText(getString(z ? R.string.write_save_draft_dialog_video_fail_title : R.string.write_save_draft_dialog_normal_title), z ? getString(R.string.write_save_draft_dialog_video_fail_sub_title) : null, getString(z ? R.string.write_save_draft_dialog_video_fail_save_text : R.string.save));
        this.hLK.showDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbY() {
        if (this.lvi.getType() == 0 || this.lvi.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.mrc) {
                    w.e(this.lvi.getForumId(), (WriteData) null);
                } else {
                    w.d(this.lvi.getForumId(), (WriteData) null);
                }
            }
        } else if (this.lvi.getType() == 1) {
            w.f(this.lvi.getThreadId(), (WriteData) null);
        }
        this.muO = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtp() {
        n.deleteFileOrDir(new File(com.baidu.tieba.video.d.lUu));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Editable text;
        if (i == 4) {
            if (this.lvH != null && this.lvH.isShowing()) {
                com.baidu.adp.lib.f.g.dismissPopupWindow(this.lvH, getPageContext().getPageActivity());
                return true;
            } else if (this.etN.bfc()) {
                this.etN.bdC();
                return true;
            } else {
                det();
                dto();
                return true;
            }
        }
        if (i == 67 && (text = dsZ().getText()) != null) {
            int selectionStart = dsZ().getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                dsZ().onKeyDown(67, this.hlO);
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
        getLayoutMode().onModeChanged(this.iKg);
        getLayoutMode().onModeChanged(this.muy);
        an.setBackgroundColor(this.iKg, R.color.cp_bg_line_e);
        if (this.muw != null && (i == 1 || i == 4)) {
            this.muw.setBorderColor(an.getColor(R.color.common_color_10043));
        }
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.aWQ().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.lvF.setTextColor(an.lu(R.color.cp_link_tip_a));
        dsI();
        an.setBackgroundColor(this.lvB, R.color.cp_bg_line_c);
        an.setBackgroundColor(this.mun, R.color.cp_bg_line_c);
        an.setBackgroundColor(dta(), R.color.cp_bg_line_e);
        an.setImageResource(this.khp, R.drawable.icon_edit_close_n);
        if (TextUtils.isEmpty(this.jAv)) {
            an.setBackgroundColor(dsZ(), R.color.cp_bg_line_e);
        }
        deC();
        this.etN.onChangeSkinType(i);
        if (this.mtB != null) {
            this.mtB.aYj();
        }
        an.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.mui.mvl.notifyDataSetChanged();
        dsN();
        dsO();
        vX(false);
        if (this.mtI != null) {
            this.mtI.c(dta(), dsZ());
        }
        if (this.mry != null) {
            this.mry.onChangeSkinType(i);
        }
        if (this.muI != null) {
            this.muI.aYi();
        }
        if (this.muJ != null) {
            this.muJ.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsN() {
        if (this.lvA.hasFocus()) {
            this.lvA.setHintTextColor(an.getColor(R.color.cp_cont_e));
        } else {
            this.lvA.setHintTextColor(an.getColor(R.color.cp_cont_d));
        }
        if (this.mtn.hasFocus()) {
            this.mtn.setHintTextColor(an.getColor(R.color.cp_cont_e));
        } else {
            this.mtn.setHintTextColor(an.getColor(R.color.cp_cont_d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsO() {
        if (this.lvA != null && this.lvA.getText() != null && this.lvA.getText().toString() != null && this.lvA.getPaint() != null) {
            if (this.lvA.getText().toString().length() == 0) {
                this.lvA.getPaint().setFakeBoldText(false);
            } else if (this.lvA.getText().toString().length() > 0) {
                this.lvA.getPaint().setFakeBoldText(true);
            }
        }
    }

    private void initUI() {
        this.eDA = new com.baidu.tbadk.core.view.a(getPageContext());
        this.mtD = this.lvi.getType() == 4 || 5 == this.lvi.getType();
        this.mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.write_activity, (ViewGroup) null);
        setContentView(this.mRootView);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.showBottomLine();
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mName = this.mNavigationBar.setCenterTextTitle("");
        an.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        this.muc = (TextView) findViewById(R.id.btn_image_problem);
        dsR();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lvF.getLayoutParams();
        layoutParams.rightMargin = l.getDimens(getPageContext().getPageActivity(), R.dimen.ds14);
        this.lvF.setLayoutParams(layoutParams);
        this.lvF.setOnFocusChangeListener(this.gbk);
        this.mtC = (ScrollView) findViewById(R.id.write_scrollview);
        this.mtC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.16
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 2) {
                    if (WriteActivity.this.mtn != null) {
                        l.hideSoftKeyPad(WriteActivity.this.getPageContext().getContext(), WriteActivity.this.mtn);
                    }
                    if (WriteActivity.this.etN != null) {
                        WriteActivity.this.etN.bdC();
                        return false;
                    }
                    return false;
                }
                return false;
            }
        });
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mua = (FeedBackTopListView) findViewById(R.id.feedback_top_list);
        this.mub = findViewById(R.id.feedback_divider);
        this.iKg = (RelativeLayout) findViewById(R.id.parent);
        this.mtl = (LinearLayout) findViewById(R.id.tool_view);
        this.mtl.setContentDescription(IStringUtil.TOP_PATH);
        this.mtm = (LinearLayout) findViewById(R.id.title_view);
        this.lvB = findViewById(R.id.interval_view);
        this.muD = findViewById(R.id.hot_topic_fourm_view);
        this.muE = findViewById(R.id.hot_topic_divider);
        this.mtF = (TextView) findViewById(R.id.hot_topic_title_edt);
        this.muF = (TextView) findViewById(R.id.change_one_tv);
        deB();
        if (this.mtD) {
            this.mtC.setVisibility(8);
            this.writeImagesInfo.setMaxImagesAllowed(6);
            dtk();
        } else {
            this.mui = new g(getPageContext(), this.mRootView);
            if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                this.mui.vL(false);
            } else {
                this.mui.vL(this.lvi.getType() == 0 || this.lvi.getType() == 9);
            }
            this.muI = new com.baidu.tieba.write.write.video.a(getPageContext(), this.mRootView);
            if (this.lvi.getVideoInfo() != null && this.lvi.getVideoInfo().isEditVideoDataLegal()) {
                vW(false);
                this.muI.dur();
            } else {
                vW(true);
            }
        }
        deD();
        if (this.mtW || this.mtk) {
            getWindow().setSoftInputMode(18);
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                if (!com.baidu.tbadk.core.util.a.e.getInstance().dVt) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
                if (com.baidu.tbadk.core.util.a.e.getInstance().hasImageProblem()) {
                    findViewById(R.id.ll_image_problem).setVisibility(0);
                } else {
                    findViewById(R.id.ll_image_problem).setVisibility(8);
                }
            }
        }
        this.lvD = (LinearLayout) findViewById(R.id.post_content_container);
        this.lvD.setDrawingCacheEnabled(false);
        this.lvD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                view.requestFocus();
                WriteActivity.this.etN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                WriteActivity.this.mtn.requestFocus();
            }
        });
        this.khm = (LinearLayout) findViewById(R.id.layout_voice_play);
        this.khn = (PlayVoiceBntNew) findViewById(R.id.btn_play_voice);
        this.khp = (ImageView) findViewById(R.id.iv_delete_voice);
        this.khp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.cJQ();
            }
        });
        this.mBack.setOnFocusChangeListener(this.gbk);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.det();
                WriteActivity.this.dto();
            }
        });
        this.muc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WriteActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ImageProblemActivityConfig(WriteActivity.this.getPageContext().getPageActivity())));
            }
        });
        dsU();
        o(dtv());
        dsW();
        dsQ();
        dtt();
        dsI();
        dsV();
        deA();
        dtc();
        if (this.lvi.getType() == 4 && this.lvJ != null && this.mtp != null) {
            this.lvJ.setVisibility(8);
            this.mtp.setVisibility(8);
        }
        deC();
        dtq();
        drY();
        dsP();
        dtu();
    }

    private void dsP() {
        this.mry = (ForumTabSelectedView) findViewById(R.id.frs_tab_list);
        this.mry.setData(this.mnb);
        this.mry.setActivity(this);
    }

    private void drY() {
        if (this.mName != null && this.lvi != null && this.lvi.getProZone() == 1) {
            this.mName.setText(R.string.write_zone_profession_title);
        }
    }

    private void dsQ() {
        String str;
        String str2;
        if (this.lvi != null) {
            switch (this.lvi.getType()) {
                case 0:
                case 9:
                    if (this.mtW || this.mtk) {
                        if (this.mtY) {
                            this.mName.setText(R.string.feedback_vcode);
                        } else {
                            this.mName.setText(R.string.feedback);
                        }
                    } else if (this.ici != null && this.ici.equals("1")) {
                        this.mName.setText(R.string.post_to_home_page);
                        if (this.mrc) {
                            this.mName.setText(R.string.publish_to_dynamic_title);
                        }
                    } else if (this.ici != null && this.ici.equals("2")) {
                        String fixedBarText = UtilHelper.getFixedBarText(getResources().getString(R.string.post_to) + this.lvi.getForumName(), 9, true, false);
                        if (fixedBarText.length() < 14) {
                            str2 = fixedBarText + getResources().getString(R.string.bar);
                        } else {
                            str2 = UtilHelper.getFixedBarText(str, 7, true, false) + getResources().getString(R.string.bar);
                        }
                        this.mName.setText(str2);
                    } else if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
                        this.mName.setText(getResources().getString(R.string.share_to) + this.lvi.getForumName() + getResources().getString(R.string.bar));
                        this.lvA.setVisibility(8);
                        String str3 = this.hxG + " " + this.hxE;
                        if (!StringUtils.isNull(str3)) {
                            this.mtn.setText(str3);
                        }
                    } else {
                        this.mName.setText("");
                    }
                    this.lvA.setVisibility(0);
                    this.mtn.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 1:
                case 2:
                case 3:
                case 6:
                case 8:
                default:
                    this.mName.setText(R.string.send_reply);
                    this.mtn.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1000)});
                    this.lvA.setVisibility(8);
                    return;
                case 4:
                    this.mName.setText(R.string.publish_photo_live);
                    this.mtn.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    return;
                case 5:
                    this.mName.setText(getPageContext().getResources().getString(R.string.update_photo_live_tip, Integer.valueOf(this.lvi.getFloorNum() + 1)));
                    this.mun.setVisibility(8);
                    return;
                case 7:
                    this.lvA.setVisibility(0);
                    this.mtn.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5000)});
                    this.mName.setText(R.string.post_drift_bottle);
                    return;
            }
        }
    }

    private void dsR() {
        if (this.lvi.getType() == 7) {
            this.lvF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.throw_bottle));
            return;
        }
        String string = getPageContext().getString(R.string.send_post);
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            string = getPageContext().getString(R.string.share);
        }
        this.lvF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, string);
    }

    private void dsS() {
        if (this.lvi != null && this.lvi.getType() == 0 && this.lvi.getType() == 9 && !this.mtW && !this.mtk && this.mPostTopicData != null && !StringUtils.isNull(this.mPostTopicData.getTitleTopic())) {
            String cutStringWithSuffix = ar.cutStringWithSuffix(this.mPostTopicData.getTitleTopic(), 31, null);
            if (!StringUtils.isNull(cutStringWithSuffix) && dta() != null) {
                dta().setText(cutStringWithSuffix);
                dta().setSelection(cutStringWithSuffix.length());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            this.mVoiceModel = voiceModel;
            this.khm.setVisibility(0);
            this.khn.setVoiceModel(voiceModel);
            this.khn.bCn();
            deC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJQ() {
        if (this.mVoiceModel != null) {
            com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.xr(this.mVoiceModel.voiceId));
        }
        this.mVoiceModel = null;
        this.khm.setVisibility(8);
        this.khn.cje();
        this.khn.setVoiceModel(null);
        com.baidu.tbadk.editortools.l nB = this.etN.nB(6);
        if (nB != null && nB.etH != null) {
            nB.etH.a(new com.baidu.tbadk.editortools.a(52, 0, null));
        }
        deC();
    }

    private void dsT() {
        this.fyR = null;
        this.mty = -1;
        this.mtA = -1;
        af uK = ae.bZX().uK(1);
        if (uK != null) {
            this.fyR = uK.hDV;
            this.mty = getIntent().getIntExtra("category_id", -1);
            if (this.fyR != null && !this.fyR.isEmpty() && this.mty >= 0) {
                this.mtx = new ad();
                this.mtx.hDR = 0;
                this.mtx.name = getPageContext().getResources().getString(R.string.category_auto);
                this.mtA = this.mtx.hDR;
                this.mtz = this.mtx.name;
                for (ad adVar : this.fyR) {
                    if (adVar.hDR == this.mty) {
                        this.mtA = adVar.hDR;
                        this.mtz = adVar.name;
                        return;
                    }
                }
            }
        }
    }

    private void dsU() {
        if (this.fyR != null && !this.fyR.isEmpty()) {
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.place_post_category);
            linearLayout.setVisibility(0);
            findViewById(R.id.interval_view_cate).setVisibility(0);
            this.mtB = (PostCategoryView) linearLayout.findViewById(R.id.category_selected);
            this.mtB.setText(this.mtz);
            this.mtB.setCategoryContainerData(this.fyR, this.mtx, this.mtA);
            this.mtB.setCategoryContainerClickCallback(new TabMenuPopView.a() { // from class: com.baidu.tieba.write.write.WriteActivity.21
                @Override // com.baidu.tieba.frs.TabMenuPopView.a
                public void a(View view, bd bdVar) {
                    if (bdVar != null) {
                        WriteActivity.this.mtB.setText(bdVar.name);
                        WriteActivity.this.lvi.setCategoryTo(bdVar.hDR);
                        WriteActivity.this.mtA = bdVar.hDR;
                        WriteActivity.this.mtB.dst();
                    }
                }
            });
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.22
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    WriteActivity.this.mtB.dss();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dta());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dsZ());
                }
            });
        }
    }

    private void dtq() {
    }

    @Override // android.app.Activity
    protected void onPrepareDialog(int i, Dialog dialog) {
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int i) {
        this.mtQ = new com.baidu.tieba.view.b(getPageContext().getPageActivity(), new TimePickerDialog.OnTimeSetListener() { // from class: com.baidu.tieba.write.write.WriteActivity.24
            @Override // android.app.TimePickerDialog.OnTimeSetListener
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            }
        }, new Date().getHours(), new Date().getMinutes(), false);
        this.mtQ.setTitle(R.string.no_disturb_start_time);
        this.mtQ.setButton(-1, getPageContext().getString(R.string.alert_yes_button), this.mtQ);
        this.mtQ.setButton(-2, getPageContext().getString(R.string.cancel), this.mtQ);
        return this.mtQ;
    }

    private void dsV() {
        this.mtt = (RelativeLayout) findViewById(R.id.addition_container);
        this.mtu = (TextView) findViewById(R.id.addition_create_time);
        this.mtv = (TextView) findViewById(R.id.addition_last_time);
        this.mtw = (TextView) findViewById(R.id.addition_last_content);
        if (this.mts != null) {
            this.mtt.setVisibility(0);
            this.mtu.setText(getPageContext().getString(R.string.write_addition_create) + ar.getFormatTime(this.mts.getCreateTime() * 1000));
            if (this.mts.getAlreadyCount() == 0) {
                this.mtv.setVisibility(8);
            } else {
                this.mtv.setText(getPageContext().getString(R.string.write_addition_last) + ar.getFormatTime(this.mts.getLastAdditionTime() * 1000));
            }
            String lastAdditionContent = this.mts.getLastAdditionContent();
            if (!TextUtils.isEmpty(lastAdditionContent)) {
                this.mtw.setText(lastAdditionContent);
            } else {
                this.mtw.setVisibility(8);
            }
            dsZ().setHint(String.format(getPageContext().getString(R.string.write_addition_hint), Integer.valueOf(this.mts.getAlreadyCount()), Integer.valueOf(this.mts.getTotalCount())));
            this.mName.setText(R.string.write_addition_title);
            return;
        }
        this.mtt.setVisibility(8);
    }

    private void deA() {
        this.lvJ = findViewById(R.id.post_prefix_layout);
        if (this.muH == null) {
            this.muH = new com.baidu.tieba.c.e(getPageContext(), this.lvJ);
            this.muH.cS(R.drawable.bg_tip_blue_up_left);
            this.muH.cR(16);
            this.muH.mk(true);
            this.muH.setUseDirectOffset(true);
            this.muH.sZ(l.getDimens(getActivity(), R.dimen.ds32));
        }
        this.lvG = (TextView) findViewById(R.id.post_prefix);
        this.mtp = findViewById(R.id.prefix_divider);
        this.lvI = (ImageView) findViewById(R.id.prefix_icon);
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 1) {
            this.lvJ.setVisibility(0);
            this.muH.z(getString(R.string.write_title_prefix_tip), "write_title_prefix_tip_key", true);
            ArrayList<String> prefixs = this.mPrefixData.getPrefixs();
            int size = prefixs.size();
            this.lvj = 0;
            this.lvJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.25
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ao("c13013").dk("fid", WriteActivity.this.lvi.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.lvG.setVisibility(0);
                    WriteActivity.this.lvJ.setSelected(true);
                    an.setImageResource(WriteActivity.this.lvI, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.lvH, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.etN.bdC();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.lvA);
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.mtn);
                }
            });
            this.lvG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.26
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TiebaStatic.log(new ao("c13013").dk("fid", WriteActivity.this.lvi.getForumId()).s("uid", TbadkCoreApplication.getCurrentAccountId()));
                    WriteActivity.this.lvG.setSelected(true);
                    an.setImageResource(WriteActivity.this.lvI, R.drawable.icon_arrow_gray_up);
                    com.baidu.adp.lib.f.g.showPopupWindowAsDropDown(WriteActivity.this.lvH, view, 0, l.dip2px(WriteActivity.this.getPageContext().getPageActivity(), 1.0f));
                    WriteActivity.this.etN.bdC();
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dta());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dsZ());
                }
            });
            this.lvH = new com.baidu.tieba.write.i(getPageContext().getPageActivity());
            this.lvH.a(this);
            this.lvH.setMaxHeight(l.getDimens(getActivity(), R.dimen.ds510));
            this.lvH.setOutsideTouchable(true);
            this.lvH.setFocusable(true);
            this.lvH.setOnDismissListener(this);
            this.lvH.setBackgroundDrawable(an.getDrawable(R.color.cp_bg_line_d));
            int color = an.getColor(R.color.cp_cont_b);
            an.getColor(R.color.cp_cont_c);
            an.setBackgroundResource(this.lvG, R.color.cp_bg_line_d);
            an.setImageResource(this.lvI, R.drawable.icon_arrow_gray_down);
            this.lvG.setTextColor(color);
            this.mtq.clear();
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(getActivity());
                this.mtq.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                if (i == size - 1) {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.vI(true);
                } else {
                    writePrefixItemLayout.setPrefixTextColor(color);
                    writePrefixItemLayout.vI(false);
                }
                if (i != size - 1) {
                    writePrefixItemLayout.setDividerStyle(false);
                }
                this.lvH.addView(writePrefixItemLayout);
            }
            this.lvH.setCurrentIndex(0);
            this.lvG.setText(prefixs.get(0));
            GU(0);
            return;
        }
        this.lvJ.setVisibility(8);
    }

    private void dtr() {
        if (this.mtW && this.lvi != null) {
            this.mua.setVisibility(0);
            this.mub.setVisibility(0);
            this.mto = new FeedBackModel(getPageContext());
            this.mto.Pj(this.lvi.getForumName());
            this.mto.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.write.write.WriteActivity.27
                /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.tieba.write.write.WriteActivity */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.adp.base.d
                public void callback(Object obj) {
                    WriteActivity.this.hideProgressBar();
                    if (obj == null || !(obj instanceof FeedBackModel)) {
                        WriteActivity.this.mua.setVisibility(8);
                        WriteActivity.this.mub.setVisibility(8);
                        WriteActivity.this.showToast(R.string.neterror);
                        return;
                    }
                    FeedBackModel feedBackModel = (FeedBackModel) obj;
                    if (feedBackModel.getErrCode() != 0) {
                        WriteActivity.this.mua.setVisibility(8);
                        WriteActivity.this.mub.setVisibility(8);
                        return;
                    }
                    WriteActivity.this.mua.a(feedBackModel.dsx(), WriteActivity.this.getPageContext());
                }
            });
        }
    }

    protected void dsW() {
        this.lvF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    WriteActivity.this.showToast(R.string.neterror);
                }
                if (!com.baidu.tieba.write.c.a.isFastDoubleClick()) {
                    if (WriteActivity.this.mtI.a(WriteActivity.this.lvA, WriteActivity.this.mtn)) {
                        WriteActivity.this.showToast(WriteActivity.this.mtI.dqM());
                        return;
                    }
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dta());
                    WriteActivity.this.HidenSoftKeyPad(WriteActivity.this.mInputManager, WriteActivity.this.dsZ());
                    WriteActivity.this.etN.bdC();
                    if (WriteActivity.this.lvi.getType() != 7) {
                        if (WriteActivity.this.mtW) {
                            WriteActivity.this.ccb();
                            BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
                        } else {
                            ao aoVar = new ao("c12102");
                            aoVar.ag("obj_type", StringUtils.isNull(WriteActivity.this.lvi.getForumName()) ? 1 : 2);
                            TiebaStatic.log(aoVar);
                            WriteActivity.this.dtf();
                        }
                    } else {
                        TiebaStatic.log("c12015");
                        WriteActivity.this.ccb();
                    }
                    MercatorModel.diV().startLoad();
                    TiebaStatic.log(new ao("c12262").dk("obj_locate", WriteActivity.this.ici));
                }
            }
        });
    }

    protected void deB() {
        this.mtZ = (HeadImageView) findViewById(R.id.user_head_portrait);
        this.mtZ.setIsRound(true);
        this.mtZ.setDrawBorder(false);
        this.mtZ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
        if (!StringUtils.isNull(currentPortrait)) {
            String wz = p.wz(currentPortrait);
            this.mtZ.setUrl(wz);
            this.mtZ.startLoad(wz, 12, false);
        }
        if (this.lvi.isUserFeedback()) {
            this.mtZ.setVisibility(0);
        }
        this.lvA = (EditText) findViewById(R.id.post_title);
        this.lvA.setOnClickListener(this.mtM);
        this.lvA.setOnFocusChangeListener(this.gbk);
        if (this.lvi.getType() == 0 || this.lvi.getType() == 9 || this.lvi.getType() == 7) {
            if (this.lvi.getTitle() != null) {
                this.lvA.setText(this.lvi.getTitle());
                this.lvA.setSelection(this.lvi.getTitle().length());
            } else if (this.mtY) {
                this.lvA.setText(getResources().getString(R.string.vcode_feed_back_title));
            }
        } else if (this.lvi.getType() == 1 || this.lvi.getType() != 2) {
        }
        this.lvA.addTextChangedListener(this.mtO);
        if (!this.lvi.getHaveDraft()) {
            dsS();
            this.muC = true;
        }
        if (this.lvi.isUserFeedback()) {
            this.lvA.setHint(getResources().getString(R.string.feedback_title_hint));
        } else {
            this.lvA.setHint(getResources().getString(R.string.post_title_hint));
        }
    }

    private TextWatcher afN() {
        TextWatcher textWatcher = new TextWatcher() { // from class: com.baidu.tieba.write.write.WriteActivity.29
            private EditText mEditText = null;
            private TextView mTextView = null;
            private int muR;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                WriteActivity.this.deC();
                if (WriteActivity.this.mtD) {
                    this.muR = this.mEditText.getSelectionStart();
                    this.mEditText.setSelection(this.muR);
                    WriteActivity.this.a(this.mTextView, this.mEditText);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!WriteActivity.this.mtD || !WriteActivity.this.muu) {
                    if (WriteActivity.this.mtD) {
                        if (this.mEditText != WriteActivity.this.mul || this.mTextView != WriteActivity.this.mur) {
                            this.mEditText = WriteActivity.this.mul;
                            this.mTextView = WriteActivity.this.mur;
                        }
                    }
                } else if (this.mEditText != WriteActivity.this.mup || this.mTextView != WriteActivity.this.muq) {
                    this.mEditText = WriteActivity.this.mup;
                    this.mTextView = WriteActivity.this.muq;
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        if (this.mtD && this.muu) {
            if (this.mus != null) {
                this.mup.removeTextChangedListener(this.mus);
            }
            this.mus = textWatcher;
        } else if (this.mtD) {
            if (this.mut != null) {
                this.mul.removeTextChangedListener(this.mut);
            }
            this.mut = textWatcher;
        }
        return textWatcher;
    }

    private long j(EditText editText) {
        if (editText == this.mul) {
            return 233L;
        }
        if (editText != this.mup) {
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
                    textView.setTextColor(an.getColor(R.color.common_color_10159));
                } else {
                    textView.setTextColor(an.getColor(R.color.cp_cont_d));
                }
            } else if (k < 0) {
                if (k < -99) {
                    valueOf = "-∞";
                }
                textView.setTextColor(an.getColor(R.color.common_color_10159));
            } else {
                textView.setTextColor(an.getColor(R.color.cp_cont_d));
            }
            textView.setText(valueOf);
        }
    }

    private long k(EditText editText) {
        return com.baidu.tieba.write.c.a.u(editText.getText().toString().trim());
    }

    protected void deD() {
        this.mtn = (SpanGroupEditText) findViewById(R.id.post_content);
        this.mtn.setDrawingCacheEnabled(false);
        this.mtn.setOnClickListener(this.mtM);
        this.mtn.setTransLink(!this.mrc);
        if (this.evx != null) {
            this.evx.setSpanGroupManager(this.mtn.getSpanGroupManager());
        }
        if (this.lvi != null) {
            this.lvi.setSpanGroupManager(this.mtn.getSpanGroupManager());
        }
        if (this.lvi.getContent() != null && this.lvi.getContent().length() > 0) {
            this.mtn.setText(TbFaceManager.bgy().ak(getPageContext().getPageActivity(), this.lvi.getContent()));
            if (this.mtn.getText() != null) {
                this.mtn.setSelection(this.mtn.getText().length());
            }
        } else if (this.lvi.getType() == 2) {
            if (this.mud) {
                if (this.mue != null && this.mue.length() > 0) {
                    this.mtn.setText(getPageContext().getPageActivity().getString(R.string.reply_sub_floor, new Object[]{this.mue}));
                    this.mtn.setSelection(this.mtn.getText().length());
                }
            } else if (this.lvi.getFloorNum() > 0) {
                this.mtn.setText(String.format(getPageContext().getString(R.string.reply_x_floor), Integer.valueOf(this.lvi.getFloorNum())));
                this.mtn.setSelection(this.mtn.getText().length());
            }
        }
        this.mtn.setOnFocusChangeListener(this.gbk);
        this.mtn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.write.write.WriteActivity.30
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    view.requestFocus();
                    WriteActivity.this.etN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    WriteActivity.this.mtn.requestFocus();
                    return false;
                }
                return false;
            }
        });
        this.mtn.addTextChangedListener(this.mtP);
        if (this.lvi.getType() == 0) {
            this.muG = true;
        } else {
            vX(true);
            this.muG = false;
        }
        if (this.lvi.isUserFeedback()) {
            this.mtn.setHint(R.string.write_input_content);
        } else {
            this.mtn.setHint(R.string.main_body);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ResourceAsColor"})
    public void vX(final boolean z) {
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleChooseActivityConfig.class) && !this.mtD && !this.mrc && dsZ() != null) {
            dsZ().setPadding(0, 0, 0, 0);
            dsZ().setBackgroundDrawable(null);
            an.setBackgroundColor(dsZ(), R.color.cp_bg_line_d);
            if (TextUtils.isEmpty(this.jAv) || this.mts != null) {
                return;
            }
            if (this.muI == null || !this.muI.isVisible()) {
                com.baidu.adp.lib.e.c.ln().a(this.jAv, 19, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.write.write.WriteActivity.31
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.e.b
                    public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                        super.onLoaded((AnonymousClass31) aVar, str, i);
                        if (aVar != null && aVar.getRawBitmap() != null && aVar.getPadding() != null) {
                            if (WriteActivity.this.muI == null || !WriteActivity.this.muI.isVisible()) {
                                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(TbadkCoreApplication.getInst().getResources(), aVar.getRawBitmap(), aVar.getRawBitmap().getNinePatchChunk(), aVar.getPadding(), null);
                                if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
                                    ninePatchDrawable.getPaint().setAlpha(TbConfig.ALPHA_80);
                                }
                                WriteActivity.this.dsZ().setBackgroundDrawable(ninePatchDrawable);
                                if (z) {
                                    com.baidu.tieba.tbadkCore.b.a.a(WriteActivity.this.getPageContext(), WriteActivity.this.dsZ(), true, WriteActivity.this.knN);
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

    private void dts() {
        if (dsZ() != null) {
            dsZ().setPadding(0, 0, 0, 0);
            dsZ().setBackgroundDrawable(null);
            an.setBackgroundColor(dsZ(), R.color.cp_bg_line_d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dsY() {
        int i = 5000;
        if (this.mts != null) {
            i = 1000;
        }
        return dsZ().getText() != null && dsZ().getText().length() >= i;
    }

    private void yx(String str) {
        if (!StringUtils.isNull(str)) {
            int i = -1;
            Editable editable = null;
            if ("from_content".equals(this.mth)) {
                this.mth = "";
                dsZ().requestFocus();
                if (dsZ().getText() != null && dsZ().getText().length() + str.length() > 5000) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dsZ().getSelectionStart();
                    editable = dsZ().getText();
                }
            } else if ("from_title".equals(this.mth)) {
                this.mth = "";
                dta().requestFocus();
                if (dta().getText() != null && dta().getText().length() + str.length() > 31) {
                    showToast(R.string.over_limit_tip);
                    return;
                } else {
                    i = dta().getSelectionStart();
                    editable = dta().getText();
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
    public void vU(boolean z) {
        if (!com.baidu.tbadk.plugins.b.l(getPageContext())) {
            HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_HOT_SELECT, HotSelectActivityConfig.FROM_POST_THREAD);
            if (this.lvi != null) {
                hotSelectActivityConfig.setForumExtra(com.baidu.adp.lib.f.b.toLong(this.lvi.getForumId(), 0L), this.lvi.getFirstDir(), this.lvi.getSecondDir());
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotSelectActivityConfig));
        }
    }

    protected void e(q qVar) {
        if (((ImageSpan[]) dsZ().getText().getSpans(0, dsZ().getText().length(), ImageSpan.class)).length >= 10) {
            if (this.mtr == null) {
                this.mtr = Toast.makeText(getPageContext().getPageActivity(), (int) R.string.too_many_face, 0);
            }
            this.mtr.show();
            return;
        }
        com.baidu.tieba.face.b.b(this, qVar, dsZ());
    }

    EditText dsZ() {
        return this.mtD ? this.mul : this.mtn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EditText dta() {
        return this.mtD ? this.mup : this.lvA;
    }

    protected void dtb() {
        if (dsZ().getSelectionStart() > 0) {
            String substring = dsZ().getText().toString().substring(0, dsZ().getSelectionStart());
            Matcher matcher = com.baidu.tieba.face.a.hlN.matcher(substring);
            if (matcher.find()) {
                dsZ().getText().delete(dsZ().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), dsZ().getSelectionStart());
                return;
            }
            dsZ().onKeyDown(67, this.hlO);
        }
    }

    private void o(Boolean bool) {
        String str = null;
        if (this.lvi != null) {
            str = this.lvi.getForumName();
        }
        if (getPageContext().getString(R.string.feedback_bar_name).equals(str)) {
            this.mtW = true;
        }
    }

    private void dtt() {
        getVoiceManager().onCreate(getPageContext());
    }

    private void dtu() {
        this.muK = (RelativeLayout) this.mRootView.findViewById(R.id.vote_layout_root);
        this.muJ = new com.baidu.tieba.write.write.vote.a(getPageContext(), this.muK);
        ao(getIntent());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.eDA.setCancelListener(null);
        this.eDA.setTipString(R.string.sending);
        this.eDA.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        this.eDA.setDialogVisiable(false);
    }

    private Boolean dtv() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(WriteActivityConfig.ENABLE_AUDIO)) {
                this.muf = intent.getBooleanExtra(WriteActivityConfig.ENABLE_AUDIO, true);
            }
            if (intent.hasExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE)) {
                this.evB = intent.getStringExtra(WriteActivityConfig.DISABLE_AUDIO_MESSAGE);
            }
        }
        return Boolean.valueOf(this.muf);
    }

    public void deC() {
        this.muL = false;
        if (this.lvi != null) {
            String str = "";
            String str2 = "";
            if (dta() != null) {
                str = dta().getText().toString();
            }
            if (dsZ() != null) {
                str2 = dsZ().getText().toString().trim();
            }
            String trim = str.trim();
            if (this.lvi.getType() == 0 || this.lvi.getType() == 9 || this.lvi.getType() == 7) {
                if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
                    if (this.lvj == com.baidu.tbadk.core.util.w.getCount(this.mPrefixData.getPrefixs()) - 1) {
                        if (TextUtils.isEmpty(trim)) {
                            this.lvi.setIsNoTitle(true);
                        } else if (this.mtm.getVisibility() == 0) {
                            this.lvi.setIsNoTitle(false);
                            vV(true);
                            return;
                        }
                    } else if (this.mtm.getVisibility() == 0) {
                        this.lvi.setIsNoTitle(false);
                        vV(true);
                        return;
                    }
                } else if (TextUtils.isEmpty(trim)) {
                    this.lvi.setIsNoTitle(true);
                } else if (this.mtm.getVisibility() == 0) {
                    this.lvi.setIsNoTitle(false);
                    vV(true);
                    return;
                }
            }
            if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0) {
                if (!this.mtD) {
                    vV(true);
                    return;
                } else if (this.writeImagesInfo.size() >= 1) {
                    vV(true);
                }
            }
            if (this.lvi.getType() == 4) {
                vV(m(this.mul) && l(this.mup));
            } else if (this.lvi.getType() == 5) {
                vV(m(this.mul));
            } else if (!TextUtils.isEmpty(str2) || this.mVoiceModel != null) {
                vV(true);
            } else if (this.lvi.getVideoInfo() != null) {
                vV(this.lvi.getVideoInfo().isVideoMixFinished());
            } else if (dtI()) {
                vV(true);
                this.muL = true;
            } else {
                vV(false);
            }
        }
    }

    public void vV(boolean z) {
        this.lvF.setEnabled(z);
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
        this.evx = new NewWriteModel(this);
        this.evx.b(this.evL);
        registerListener(this.muM);
        this.hqD = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.write.WriteActivity.33
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                WriteActivity.this.destroyWaitingDialog();
                WriteActivity.this.det();
            }
        };
        this.lvi = new WriteData();
        if (bundle != null) {
            this.lvi.setType(bundle.getInt("type", 0));
            this.lvi.setForumId(bundle.getString("forum_id"));
            this.lvi.setForumName(bundle.getString("forum_name"));
            this.lvi.setFirstDir(bundle.getString("forum_first_dir"));
            this.lvi.setSecondDir(bundle.getString("forum_second_dir"));
            this.lvi.setThreadId(bundle.getString("thread_id"));
            this.lvi.setFloor(bundle.getString(WriteActivityConfig.FLOOR_ID));
            this.lvi.setFloorNum(bundle.getInt("floor_num", 0));
            this.mtW = bundle.getBoolean(WriteActivityConfig.FEED_BACK, false);
            this.mtX = bundle.getBoolean(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.mtY = bundle.getBoolean(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.mud = bundle.getBoolean(WriteActivityConfig.REPLY_SUB_PB, false);
            this.mue = bundle.getString(WriteActivityConfig.SUB_USER_NAME);
            String string = bundle.getString("KEY_WRITE_IMAGES_INFO_STRING");
            this.evv = bundle.getString(WriteActivityConfig.PHOTO_NAME);
            String string2 = bundle.getString("addition_data");
            if (!StringUtils.isNull(string2)) {
                this.mts = (AdditionData) OrmObject.objectWithJsonStr(string2, AdditionData.class);
            }
            this.lvi.setIsAddition(this.mts != null);
            String string3 = bundle.getString("prefix_data");
            if (!StringUtils.isNull(string3)) {
                this.mPrefixData = (PostPrefixData) OrmObject.objectWithJsonStr(string3, PostPrefixData.class);
            }
            String string4 = bundle.getString("hot_topic");
            if (!StringUtils.isNull(string4)) {
                this.mPostTopicData = (PostTopicData) OrmObject.objectWithJsonStr(string4, PostTopicData.class);
            }
            this.mug = bundle.getInt(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = bundle.getString("from");
            this.forumLevel = bundle.getInt("key_write_level", -1);
            this.privateThread = bundle.getInt("private_thread", -1);
            this.lvi.setTitle(bundle.getString("write_title"));
            this.lvi.setContent(bundle.getString("write_content"));
            this.mList = (List) bundle.getSerializable("hot_topic_forum_list");
            this.mTopicId = bundle.getString(WriteActivityConfig.HOT_TOPIC_ID);
            this.lvi.setTopicId(this.mTopicId);
            this.ici = bundle.getString("KEY_CALL_FROM");
            this.biz = bundle.getInt("album_thread");
            this.mnb = (FrsTabInfoData) bundle.getSerializable("tab_list");
            this.lvi.setVideoInfo((VideoInfo) bundle.getSerializable(WriteVideoActivityConfig.VIDEO_INFO));
            str = string;
        } else {
            Intent intent = getIntent();
            this.lvi.setType(intent.getIntExtra("type", 0));
            this.lvi.setForumId(intent.getStringExtra("forum_id"));
            this.lvi.setForumName(intent.getStringExtra("forum_name"));
            this.lvi.setFirstDir(intent.getStringExtra("forum_first_dir"));
            this.lvi.setSecondDir(intent.getStringExtra("forum_second_dir"));
            this.lvi.setThreadId(intent.getStringExtra("thread_id"));
            this.lvi.setFloor(intent.getStringExtra(WriteActivityConfig.FLOOR_ID));
            this.lvi.setFloorNum(intent.getIntExtra("floor_num", 0));
            this.mtW = intent.getBooleanExtra(WriteActivityConfig.FEED_BACK, false);
            this.mtX = intent.getBooleanExtra(WriteActivityConfig.KEY_SHOW_HOMEPAGE_TEST_BTN, false);
            this.mtY = intent.getBooleanExtra(WriteActivityConfig.VCODE_FEED_BACK, false);
            this.mud = intent.getBooleanExtra(WriteActivityConfig.REPLY_SUB_PB, false);
            this.mue = intent.getStringExtra(WriteActivityConfig.SUB_USER_NAME);
            this.forumLevel = intent.getIntExtra("key_write_level", -1);
            this.privateThread = intent.getIntExtra("private_thread", 0);
            this.mts = (AdditionData) intent.getSerializableExtra("addition_data");
            this.lvi.setIsAddition(this.mts != null);
            this.lvi.setProZone(intent.getIntExtra(WriteActivityConfig.KEY_PROFESSION_ZONE, -1));
            this.mPrefixData = (PostPrefixData) intent.getSerializableExtra("prefix_data");
            this.mPostTopicData = (PostTopicData) intent.getSerializableExtra("hot_topic");
            this.mug = intent.getIntExtra(WriteActivityConfig.MEMBER_TYPE, 0);
            this.mFrom = intent.getStringExtra("from");
            this.hxF = intent.getStringExtra("more_forum_img");
            this.hxG = intent.getStringExtra("more_forum_title");
            this.hxE = intent.getStringExtra("more_forum_url");
            this.lvi.setTitle(intent.getStringExtra("write_title"));
            this.lvi.setContent(intent.getStringExtra("write_content"));
            this.mList = (List) intent.getSerializableExtra("hot_topic_forum_list");
            this.mTopicId = intent.getStringExtra(WriteActivityConfig.HOT_TOPIC_ID);
            this.lvi.setTopicId(this.mTopicId);
            this.ici = intent.getStringExtra("KEY_CALL_FROM");
            this.biz = intent.getIntExtra("album_thread", 0);
            String stringExtra = intent.getStringExtra("KEY_WRITE_IMAGES_INFO_STRING");
            this.mnb = (FrsTabInfoData) intent.getSerializableExtra("tab_list");
            this.lvi.setVideoInfo((VideoInfo) intent.getSerializableExtra(WriteVideoActivityConfig.VIDEO_INFO));
            str = stringExtra;
        }
        if ("main_tab".equals(this.mFrom) || AlbumActivityConfig.FROM_PERSON.equals(this.mFrom)) {
            this.lvi.mDynamicImageTextData = new ImageTextUploadData();
            this.mrc = true;
        }
        if (this.lvi.getType() == 9) {
            this.lvi.setEntranceType(1);
        } else if (this.lvi.getType() == 10) {
            this.lvi.setEntranceType(2);
            this.lvi.setType(9);
        } else if (this.lvi.getType() == 0) {
            this.lvi.setEntranceType(3);
        }
        this.lvi.setIsUserFeedback(this.mtW);
        if (this.writeImagesInfo == null) {
            this.writeImagesInfo = new WriteImagesInfo();
        }
        if (str != null) {
            this.writeImagesInfo.parseJson(str);
            this.writeImagesInfo.updateQuality();
        }
        this.writeImagesInfo.setMaxImagesAllowed(this.lvi.getType() == 4 ? 6 : 9);
        this.lvi.setWriteImagesInfo(this.writeImagesInfo);
        if (this.lvi.getType() == 0 || this.lvi.getType() == 9) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                if (this.mrc) {
                    w.d(this.lvi.getForumId(), this);
                } else {
                    w.c(this.lvi.getForumId(), this);
                }
            }
        } else if (this.lvi.getType() == 7) {
            if (getIntent().getBooleanExtra("need_save_draft", true)) {
                w.c("24591571", this);
            }
        } else if (this.lvi.getType() == 1) {
            w.a(this.lvi.getThreadId(), this);
        } else if (this.lvi.getType() == 4) {
            w.c(this.lvi.getForumId() + "photolive", this);
        } else if (this.lvi.getType() == 5) {
            w.a(this.lvi.getThreadId() + "updatephotolive", this);
        }
        if (this.mPrefixData != null && this.mPrefixData.getPrefixs().size() > 0) {
            this.mPrefixData.getPrefixs().add(getPageContext().getString(R.string.write_no_prefix));
        }
        this.jAv = TbadkCoreApplication.getInst().getDefaultBubble();
        if (this.lvi != null && this.lvi.getForumName() != null && TbadkCoreApplication.getInst().getYijianfankuiFname() != null && this.lvi.getForumName().equals(TbadkCoreApplication.getInst().getYijianfankuiFname())) {
            this.mtk = true;
        }
        dsT();
        try {
            this.muv = dtE();
        } catch (Throwable th) {
            this.muv = null;
        }
    }

    private void dtc() {
        HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.w.getItem(this.mList, 0);
        if (hotTopicBussinessData != null && !TextUtils.isEmpty(hotTopicBussinessData.mTopicName)) {
            this.lvA.setText(com.baidu.tbadk.plugins.b.zb(com.baidu.tbadk.plugins.b.zc(hotTopicBussinessData.mTopicName)));
            this.lvA.setMovementMethod(com.baidu.tieba.view.c.dqq());
        }
    }

    private void a(HotTopicBussinessData hotTopicBussinessData) {
        HotTopicBussinessData hotTopicBussinessData2;
        if (hotTopicBussinessData != null && (hotTopicBussinessData2 = (HotTopicBussinessData) com.baidu.tbadk.core.util.w.getItem(this.mList, 0)) != null && !TextUtils.isEmpty(hotTopicBussinessData2.mTopicName)) {
            SpannableString zb = com.baidu.tbadk.plugins.b.zb(com.baidu.tbadk.plugins.b.zc(hotTopicBussinessData.mTopicName));
            if (zb != null) {
                this.lvA.setText(zb);
            }
            this.mtF.setText(hotTopicBussinessData.mForumName);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.w.a
    public void a(WriteData writeData) {
        int i = 0;
        if (!WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom)) {
            if (writeData != null) {
                if (this.lvi != null) {
                    boolean z = this.lvi.getVideoInfo() != null && this.lvi.getVideoInfo().isEditVideoDataLegal();
                    boolean z2 = (this.lvi.getWriteImagesInfo() == null || com.baidu.tbadk.core.util.w.isEmpty(this.lvi.getWriteImagesInfo().getChosedFiles())) ? false : true;
                    boolean z3 = !com.baidu.adp.lib.util.k.isEmpty(dta().getText().toString());
                    boolean z4 = !com.baidu.adp.lib.util.k.isEmpty(dsZ().getText().toString());
                    boolean z5 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getTitle());
                    boolean z6 = !com.baidu.adp.lib.util.k.isEmpty(writeData.getContent());
                    boolean z7 = ar.isEmpty(writeData.getTitle()) && !e(TbFaceManager.bgy().a(getPageContext().getPageActivity(), writeData.getContent(), this.mtK));
                    if (!z || z7) {
                        this.lvi.setHaveDraft(true);
                        if (!z2 && !z) {
                            f(writeData);
                        }
                        if (!z && (!z3 || this.muC || ((this.mtW || this.mtk) && z5))) {
                            g(writeData);
                        }
                        if (z6 && (!z4 || this.mtW || this.mtk)) {
                            h(writeData);
                        }
                        if (this.lvi != null && !this.lvi.getHaveDraft()) {
                            dsS();
                        }
                        if (writeData.getType() == 4 || writeData.getType() == 5) {
                            dtw();
                        }
                        deC();
                        int categoryTo = writeData.getCategoryTo();
                        if (categoryTo >= 0 && this.fyR != null) {
                            this.mtA = this.mtx.hDR;
                            this.mtz = this.mtx.name;
                            while (true) {
                                if (i == this.fyR.size()) {
                                    break;
                                }
                                ad adVar = this.fyR.get(i);
                                if (categoryTo != adVar.hDR) {
                                    i++;
                                } else {
                                    this.mtA = categoryTo;
                                    this.mtz = adVar.name;
                                    this.lvi.setCategoryTo(this.mtA);
                                    break;
                                }
                            }
                            if (this.mtB != null) {
                                this.mtB.setText(this.mtz);
                                this.mtB.setCategoryContainerData(this.fyR, this.mtx, this.mtA);
                            }
                        }
                        this.etN.bdC();
                        return;
                    }
                    return;
                }
                return;
            }
            dtw();
            dsS();
        }
    }

    private void f(WriteData writeData) {
        if (writeData.getVideoInfo() != null && writeData.getVideoInfo().isAvaliable()) {
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.copy(writeData.getVideoInfo());
            this.lvi.setVideoInfo(videoInfo);
            vW(false);
            return;
        }
        if (writeData.getWriteImagesInfo() != null) {
            this.writeImagesInfo = writeData.getWriteImagesInfo();
        }
        this.lvi.setWriteImagesInfo(this.writeImagesInfo);
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() > 0) {
            dth();
        }
        vY(false);
        vW(true);
    }

    private void g(WriteData writeData) {
        String str;
        String zc;
        if (com.baidu.adp.lib.util.k.isEmpty(this.lvi.getTitle())) {
            this.lvi.setTitle(writeData.getTitle());
        }
        if (!com.baidu.tbadk.core.util.w.isEmpty(this.mList)) {
            HotTopicBussinessData hotTopicBussinessData = (HotTopicBussinessData) com.baidu.tbadk.core.util.w.getItem(this.mList, 0);
            if (hotTopicBussinessData == null) {
                str = null;
            } else {
                str = hotTopicBussinessData.mTopicName;
            }
            if (StringUtils.isNull(str)) {
                zc = this.lvi.getTitle();
            } else {
                zc = com.baidu.tbadk.plugins.b.zc(str);
            }
            SpannableString zb = com.baidu.tbadk.plugins.b.zb(zc);
            if (zb != null) {
                dta().setText(zb);
                dta().setSelection(zb.length() > zc.length() ? zc.length() : zb.length());
                return;
            }
            return;
        }
        SpannableString zb2 = com.baidu.tbadk.plugins.b.zb(this.lvi.getTitle());
        if (zb2 != null) {
            dta().setText(zb2);
            dta().setSelection(this.lvi.getTitle().length() > zb2.length() ? zb2.length() : this.lvi.getTitle().length());
        }
    }

    private void h(WriteData writeData) {
        this.lvi.setContent(writeData.getContent());
        dsZ().setText(TbFaceManager.bgy().a(getPageContext().getPageActivity(), this.lvi.getContent(), this.mtK));
        if (dsZ().getText() != null) {
            dsZ().setSelection(dsZ().getText().length());
        }
        if (this.mtD) {
            a(this.mur, this.mul);
        }
    }

    private void dtw() {
        if ((!this.mtD || this.muk != null) && this.muj != null) {
            this.muk.b(this.writeImagesInfo);
            dtA();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("type", this.lvi.getType());
        bundle.putString("forum_id", this.lvi.getForumId());
        bundle.putString("forum_name", this.lvi.getForumName());
        bundle.putString("forum_first_dir", this.lvi.getFirstDir());
        bundle.putString("forum_second_dir", this.lvi.getSecondDir());
        bundle.putString("thread_id", this.lvi.getThreadId());
        bundle.putString(WriteActivityConfig.FLOOR_ID, this.lvi.getFloor());
        bundle.putInt("floor_num", this.lvi.getFloorNum());
        bundle.putBoolean(WriteActivityConfig.REPLY_SUB_PB, this.mud);
        if (this.mtW) {
            bundle.putBoolean(WriteActivityConfig.FEED_BACK, true);
        }
        if (this.writeImagesInfo != null) {
            bundle.putString("KEY_WRITE_IMAGES_INFO_STRING", this.writeImagesInfo.toJsonString());
        }
        bundle.putString(WriteActivityConfig.PHOTO_NAME, this.evv);
        if (this.mts != null) {
            bundle.putString("addition_data", OrmObject.jsonStrWithObject(this.mts));
        }
        if (this.mPrefixData != null) {
            bundle.putString("prefix_data", OrmObject.jsonStrWithObject(this.mPrefixData));
        }
        if (this.mPostTopicData != null) {
            bundle.putString("hot_topic", OrmObject.jsonStrWithObject(this.mPostTopicData));
        }
        bundle.putInt(WriteActivityConfig.MEMBER_TYPE, this.mug);
        bundle.putString("from", this.mFrom);
        bundle.putString("KEY_CALL_FROM", this.ici);
        bundle.putInt("album_thread", this.biz);
        bundle.putInt("private_thread", this.privateThread);
        bundle.putSerializable("tab_list", this.mnb);
        super.onSaveInstanceState(bundle);
        getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String obj = dsZ().getEditableText().toString();
        if (obj != null) {
            dsZ().setText(TbFaceManager.bgy().a(getPageContext().getPageActivity(), obj, this.mtK));
            dsZ().setSelection(dsZ().getText().length());
        }
    }

    private String getContent() {
        return (dsZ() == null || dsZ().getText() == null) ? "" : dsZ().getText().toString();
    }

    private String dte() {
        if (this.lvi == null || dta() == null || dta().getVisibility() != 0 || dta().getText() == null) {
            return "";
        }
        String obj = dta().getText().toString();
        if (this.mPrefixData != null && com.baidu.tbadk.core.util.w.getCount(this.mPrefixData.getPrefixs()) > 0 && this.lvj != com.baidu.tbadk.core.util.w.getCount(this.mPrefixData.getPrefixs()) - 1 && this.lvi.getType() != 4 && this.lvG != null && this.lvG.getText() != null) {
            this.lvi.setPostPrefix(this.lvG.getText().toString());
        }
        if (this.mPrefixData != null && !StringUtils.isNull(this.mPrefixData.getImplicitTitle())) {
            return this.mPrefixData.getImplicitTitle() + this.lvi.getTitle();
        }
        return obj;
    }

    private void Pl(String str) {
        if (this.lvi != null && this.mtm != null) {
            if (this.mtm.getVisibility() == 0) {
                if (StringUtils.isNull(str)) {
                    this.lvi.setIsNoTitle(true);
                    this.lvi.setTitle("");
                    return;
                }
                this.lvi.setIsNoTitle(false);
                this.lvi.setTitle(str);
                return;
            }
            this.lvi.setIsNoTitle(true);
            this.lvi.setTitle("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccb() {
        if (this.muI.isVisible() && dsZ() != null && dsZ().getText() != null) {
            int length = dsZ().getText().toString().length();
            if (this.lvJ != null && this.lvJ.getVisibility() == 0 && this.lvj != com.baidu.tbadk.core.util.w.getCount(this.mPrefixData.getPrefixs()) - 1 && this.lvG != null) {
                length += this.lvG.length();
            }
            if (length > com.baidu.tieba.write.video.b.mrh) {
                Pk(String.format(getString(R.string.write_video_title_too_long), Integer.valueOf(com.baidu.tieba.write.video.b.mrh)));
                return;
            }
        }
        det();
        this.lvi.setContent(getContent());
        Pl(dte());
        if (this.mtW || this.mtk) {
            String string = getResources().getString(R.string.android_feedback);
            if (TextUtils.isEmpty(this.lvi.getTitle()) || !this.lvi.getTitle().startsWith(string)) {
                Pl(string + this.lvi.getTitle());
            }
            String str = getResources().getString(R.string.app_name) + getResources().getString(R.string.tieba_client);
            if (TextUtils.isEmpty(this.lvi.getContent()) || !this.lvi.getContent().startsWith(str)) {
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
                sb.append(this.lvi.getContent());
                this.lvi.setContent(sb.toString());
            }
        }
        if (this.mtX) {
            this.lvi.setContent(String.format(getResources().getString(R.string.homepage_test_post_suffix), Build.MODEL, TbadkCoreApplication.getInst().getVersionName(), com.baidu.adp.lib.util.j.netTypeNameInUpperCase(), Build.VERSION.RELEASE) + "\n" + this.lvi.getContent());
        }
        if (this.mty >= 0) {
            this.lvi.setCategoryFrom(this.mty);
        }
        if (this.mtA >= 0) {
            this.lvi.setCategoryTo(this.mtA);
        }
        this.lvi.setWriteImagesInfo(this.writeImagesInfo);
        if (this.muJ != null) {
            this.lvi.setWriteVoteData(this.muJ.getWriteVoteData());
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
            this.lvi.setTakePhotoNum(i);
        }
        this.lvi.setHasLocationData(this.evw != null && this.evw.bKs());
        if (this.writeImagesInfo != null) {
            this.evx.uN(this.writeImagesInfo.size() > 0);
        }
        if (!com.baidu.tbadk.core.util.w.isEmpty(this.mList) && this.mtE != null && this.mtE.mIsGlobalBlock == 0) {
            this.lvi.setForumId(String.valueOf(this.mtE.mForumId));
            this.lvi.setForumName(this.mtE.mForumName);
        }
        dsb();
        this.evx.d(this.lvi);
        this.lvi.setContent(this.lvi.getContent().replaceAll("\u0000\n", ""));
        this.lvi.setContent(this.lvi.getContent().replaceAll("\u0000", ""));
        this.lvi.setVcode(null);
        if (this.mVoiceModel != null) {
            if (this.mVoiceModel.getId() != null) {
                this.evx.dev().setVoice(this.mVoiceModel.getId());
                this.evx.dev().setVoiceDuringTime(this.mVoiceModel.duration);
            } else {
                this.evx.dev().setVoice(null);
                this.evx.dev().setVoiceDuringTime(-1);
            }
        } else {
            this.evx.dev().setVoice(null);
            this.evx.dev().setVoiceDuringTime(-1);
        }
        if (!this.evx.djq()) {
            showToast(R.string.write_img_limit);
        } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
        } else if (this.lvi.mDynamicImageTextData != null) {
            dsa();
        } else {
            showLoadingDialog(getPageContext().getString(R.string.sending), this.hqD);
            this.evx.djn();
        }
    }

    private void dsb() {
        FrsTabItemData selectedTabItemData;
        if (this.lvi != null && this.mry != null && (selectedTabItemData = this.mry.getSelectedTabItemData()) != null) {
            this.lvi.setTabId(selectedTabItemData.tabId);
            this.lvi.setTabName(selectedTabItemData.name);
            this.lvi.setIsGeneralTab(selectedTabItemData.isGeneralTab);
        }
    }

    public void dsa() {
        if (this.lvi.mDynamicImageTextData != null) {
            showLoadingDialog(getPageContext().getString(R.string.sending), (DialogInterface.OnCancelListener) null);
            com.baidu.tieba.write.b.a.a(this.lvi, new a.InterfaceC0764a() { // from class: com.baidu.tieba.write.write.WriteActivity.35
                @Override // com.baidu.tieba.write.b.a.InterfaceC0764a
                public void a(BaseUploadData baseUploadData) {
                    com.baidu.tieba.write.b.c.b.drM().a((ImageTextUploadData) baseUploadData, new b.a() { // from class: com.baidu.tieba.write.write.WriteActivity.35.1
                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onSuccess(String str) {
                            w.e(WriteActivity.this.lvi.getForumId(), (WriteData) null);
                            com.baidu.tieba.write.b.a.drD();
                            WriteActivity.this.closeLoadingDialog();
                            com.baidu.tieba.tbadkCore.writeModel.c.f(WriteActivity.this.getPageContext().getPageActivity(), null, null, null);
                            WriteActivity.this.in(true);
                            Intent intent = new Intent();
                            intent.putExtras(new Bundle());
                            WriteActivity.this.setResult(-1, intent);
                            WriteActivity.this.finish();
                        }

                        @Override // com.baidu.tieba.write.b.c.b.a
                        public void onFail(String str) {
                            com.baidu.tieba.write.b.a.drD();
                            WriteActivity.this.closeLoadingDialog();
                            if (TextUtils.isEmpty(str)) {
                                str = TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error);
                            }
                            l.showToast(TbadkCoreApplication.getInst(), str);
                        }
                    });
                }

                @Override // com.baidu.tieba.write.b.a.InterfaceC0764a
                public void onError() {
                    WriteActivity.this.closeLoadingDialog();
                    l.showToast(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error));
                }
            });
        }
    }

    private void E(boolean z, String str) {
        int i;
        int i2;
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (z) {
            if (this.mts != null) {
                i2 = this.mts.getTotalCount();
                i = this.mts.getAlreadyCount() + 1;
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
                if (this.lvA == getCurrentFocus()) {
                    dsZ().clearFocus();
                    this.lvA.requestFocus();
                    if (this.etN != null) {
                        this.etN.bdC();
                    }
                    ShowSoftKeyPadDelay(this.lvA);
                } else {
                    dsZ().requestFocus();
                    if (this.etN != null) {
                        this.etN.bdC();
                    }
                    ShowSoftKeyPadDelay(this.mtn);
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
                            dsZ().getText().insert(dsZ().getSelectionStart(), sb.toString());
                            return;
                        }
                    }
                }
            } else if (i == 12006) {
                PostWriteCallBackData postWriteCallBackData2 = (intent == null || intent.getExtras() == null || !(intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData)) ? null : (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data");
                cbY();
                dtp();
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
                                dtB();
                            } else {
                                ar(intent);
                            }
                        } else if (intExtra == 1) {
                            as(intent);
                        } else {
                            ap(intent);
                            com.baidu.adp.lib.f.e.lt().post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.36
                                @Override // java.lang.Runnable
                                public void run() {
                                    l.hideSoftKeyPad(WriteActivity.this.getActivity(), WriteActivity.this.getCurrentFocus());
                                }
                            });
                        }
                        vW(com.baidu.tbadk.core.util.w.getCount(this.writeImagesInfo.getChosedFiles()) > 0);
                        if (this.muG) {
                            vX(true);
                            this.muG = false;
                        }
                    }
                } else if (i == 12012) {
                    if (!this.mtD) {
                        D(intent);
                        deC();
                        return;
                    }
                    aq(intent);
                } else if (i == 13010) {
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.parseFromIntent(intent);
                    if (videoInfo.isAvaliable()) {
                        this.lvi.setVideoInfo(videoInfo);
                        this.etN.b(new com.baidu.tbadk.editortools.a(2, 19, " "));
                        this.etN.b(new com.baidu.tbadk.editortools.a(28, 20, videoInfo));
                    } else {
                        this.etN.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    }
                    deC();
                } else if (i == 23004) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.BUBBLE_LIST_REFRESH));
                } else if (i == 25004) {
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                        if (!StringUtils.isNull(stringExtra)) {
                            StringBuilder sb2 = new StringBuilder();
                            if (this.mti) {
                                sb2.append(com.baidu.tbadk.plugins.b.eCT);
                                this.mti = false;
                            }
                            sb2.append(stringExtra);
                            yx(sb2.toString());
                        }
                    }
                } else if (i == 25005 && intent != null && !com.baidu.tbadk.core.util.w.isEmpty(this.mList)) {
                    if (!com.baidu.tbadk.core.util.w.isEmpty(this.mList) && intent.getIntExtra("hot_topic_change_fourm", 0) < this.mList.size()) {
                        this.mtE = this.mList.get(intent.getIntExtra("hot_topic_change_fourm", 0));
                        a(this.mtE);
                    }
                } else if (i == 25048) {
                    ao(intent);
                } else if (i == 25049 && intent != null) {
                    String str = intent.getStringExtra(AddLinkActivityConfig.NEW_LINK_CONTENT) + " ";
                    int selectionStart = this.mtn.getSelectionStart();
                    int selectionEnd = this.mtn.getSelectionEnd();
                    if (selectionStart >= 0) {
                        Editable text = this.mtn.getText();
                        if (selectionEnd > selectionStart) {
                            text.replace(selectionStart, selectionEnd, str);
                        } else {
                            text.insert(selectionStart, str);
                        }
                    }
                }
            }
        } else if (i2 == 0) {
            if (this.etN != null && !this.etN.bfc()) {
                this.mtn.requestFocus();
                this.mInputManager.toggleSoftInput(0, 2);
                this.etN.bdC();
            }
            switch (i) {
                case 12001:
                    bfK();
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null && intent.hasExtra("last_album_id")) {
                        this.writeImagesInfo.setLastAlbumId(intent.getStringExtra("last_album_id"));
                    }
                    dtz();
                    if (this.muG) {
                        vX(true);
                        this.muG = false;
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_AT_SELECT /* 12004 */:
                    if (this.lvA == getCurrentFocus()) {
                        dsZ().clearFocus();
                        this.lvA.requestFocus();
                        if (this.etN != null) {
                            this.etN.bdC();
                        }
                        ShowSoftKeyPadDelay(this.lvA);
                        return;
                    }
                    dsZ().requestFocus();
                    if (this.etN != null) {
                        this.etN.bdC();
                    }
                    ShowSoftKeyPadDelay(this.mtn);
                    return;
                case RequestResponseCode.REQUEST_VCODE /* 12006 */:
                    if (intent != null && intent.getExtras() != null && (intent.getExtras().getSerializable("post_write_callback_data") instanceof PostWriteCallBackData) && (postWriteCallBackData = (PostWriteCallBackData) intent.getExtras().getSerializable("post_write_callback_data")) != null && postWriteCallBackData.isSensitiveError()) {
                        showToast(postWriteCallBackData.getErrorString());
                        this.mtI.OM(postWriteCallBackData.getErrorString());
                        this.mtI.aY(postWriteCallBackData.getSensitiveWords());
                        this.mtI.b(this.lvA, this.mtn);
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                default:
                    return;
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.evv = String.valueOf(System.currentTimeMillis());
                    am.a(getPageContext(), this.evv);
                    return;
                case RequestResponseCode.REQUEST_MOTU_IMAGE /* 12012 */:
                    dtz();
                    return;
                case RequestResponseCode.REQUEST_HOT_SELECT /* 25004 */:
                    if ("from_title".equals(this.mth)) {
                        dta().requestFocus();
                        return;
                    } else if ("from_content".equals(this.mth)) {
                        dsZ().requestFocus();
                        return;
                    } else {
                        return;
                    }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtf() {
        if ("1".equals(this.ici)) {
            this.lvi.setCanNoForum(true);
            this.lvi.setTransmitForumData("[]");
        } else if ("2".equals(this.ici)) {
            this.lvi.setCanNoForum(false);
        }
        dtg();
        this.lvi.setPrivacy(this.isPrivacy);
        dtx();
        this.lvi.setToDynamic(this.isToDynamic);
        this.lvi.setCallFrom(this.ici);
        if (this.lvi.getVideoInfo() != null) {
            TiebaStatic.log("c10063");
        }
        ccb();
    }

    private void dtg() {
        if (this.etN != null) {
            this.etN.b(new com.baidu.tbadk.editortools.a(54, 15, null));
        }
    }

    private void dtx() {
        if (this.etN != null) {
            this.etN.b(new com.baidu.tbadk.editortools.a(57, 15, null));
        }
    }

    private void dty() {
        ImageFileInfo imageFileInfo;
        if (this.writeImagesInfo != null && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() > 0 && (imageFileInfo = this.writeImagesInfo.getChosedFiles().get(this.writeImagesInfo.size() - 1)) != null && !TextUtils.isEmpty(imageFileInfo.getFilePath()) && imageFileInfo.getFilePath().startsWith("android.resource://")) {
            this.writeImagesInfo.getChosedFiles().remove(this.writeImagesInfo.size() - 1);
        }
    }

    private void dtz() {
        if (this.mtD) {
            this.muk.b(this.writeImagesInfo);
            dtA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtA() {
        this.muk.notifyDataSetChanged();
        this.muj.invalidate();
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.37
            @Override // java.lang.Runnable
            public void run() {
                WriteActivity.this.muk.notifyDataSetChanged();
                WriteActivity.this.muj.invalidateViews();
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
        deC();
    }

    private void ap(Intent intent) {
        if (this.mtD) {
            aq(intent);
            dtz();
        } else {
            at(intent);
        }
        deC();
    }

    private void aq(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("album_result");
            if (stringExtra != null) {
                this.writeImagesInfo.parseJson(stringExtra);
                this.writeImagesInfo.updateQuality();
            }
            dtz();
            vY(true);
        }
    }

    private void ar(Intent intent) {
        if (this.writeImagesInfo != null) {
            C(intent);
            int size = this.writeImagesInfo.size() - 1;
            if (size > -1 && this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.size() >= 1) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteMulitImageActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MOTU_IMAGE, this.writeImagesInfo, size)));
            }
        }
    }

    private void dtB() {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, (int) RequestResponseCode.REQUEST_CAMERA_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, 0.56f, "from_photo_live")));
        }
    }

    private void as(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra("album_result")) != null) {
            this.muh.parseJson(stringExtra);
            this.muh.updateQuality();
            if (this.muh.getChosedFiles() != null && this.muh.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, TbadkCoreApplication.getCurrentAccountObj(), 1, this.muh.getChosedFiles().get(0).getFilePath(), 0.56f, "from_photo_live")));
            }
            this.muh.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        HidenSoftKeyPad(this.mInputManager, dta());
        HidenSoftKeyPad(this.mInputManager, dsZ());
        super.onPause();
        getVoiceManager().onPause(getPageContext());
        if (this.muI != null) {
            this.muI.onPause();
        }
        if (this.etN.bfc()) {
            this.etN.bdC();
        }
    }

    private void at(Intent intent) {
        c(intent, true);
    }

    private void C(Intent intent) {
        this.evv = intent.getStringExtra("camera_photo_name");
        String str = Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/cameras/" + this.evv;
        if (!TextUtils.isEmpty(str)) {
            try {
                int readPictureDegree = BitmapHelper.readPictureDegree(str);
                if (readPictureDegree != 0) {
                    Bitmap loadResizedBitmap = BitmapHelper.loadResizedBitmap(str, l.dip2px(getPageContext().getPageActivity(), l.getEquipmentWidth(getPageContext().getPageActivity())), l.dip2px(getPageContext().getPageActivity(), l.getEquipmentHeight(getPageContext().getPageActivity())));
                    Bitmap rotateBitmapBydegree = BitmapHelper.rotateBitmapBydegree(loadResizedBitmap, readPictureDegree);
                    if (loadResizedBitmap != rotateBitmapBydegree) {
                        loadResizedBitmap.recycle();
                    }
                    n.a("cameras", this.evv, rotateBitmapBydegree, 100);
                    rotateBitmapBydegree.recycle();
                }
            } catch (Exception e) {
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            this.writeImagesInfo.addChooseFile(imageFileInfo);
            this.writeImagesInfo.updateQuality();
            dtC();
            dth();
        }
        vY(true);
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
                dtC();
                if (this.writeImagesInfo.getChosedFiles() != null) {
                    dth();
                }
            }
            vY(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dtC() {
        if (this.etN.nB(10) != null) {
            this.etN.setToolEnabled(this.writeImagesInfo == null || com.baidu.tbadk.core.util.w.getCount(this.writeImagesInfo.getChosedFiles()) < this.writeImagesInfo.getMaxImagesAllowed(), 10);
        }
    }

    private void bfK() {
        new BdAsyncTask<Void, Integer, Void>() { // from class: com.baidu.tieba.write.write.WriteActivity.38
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public Void doInBackground(Void... voidArr) {
                n.deleteFile(new File(Environment.getExternalStorageDirectory() + "/" + TbConfig.getTempDirName() + "/" + WriteActivity.this.evv));
                return null;
            }
        }.execute(new Void[0]);
    }

    private void dtD() {
        if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.mFrom) && !StringUtils.isNull(this.hxF)) {
            if (this.mCurrentPermissionJudgePolicy == null) {
                this.mCurrentPermissionJudgePolicy = new PermissionJudgePolicy();
            }
            this.mCurrentPermissionJudgePolicy.clearRequestPermissionList();
            this.mCurrentPermissionJudgePolicy.appendRequestPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mCurrentPermissionJudgePolicy.startRequestPermission(this)) {
                o oVar = new o(this, this.hxF, new o.a() { // from class: com.baidu.tieba.write.write.WriteActivity.39
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
                            WriteActivity.this.vY(true);
                        }
                    }
                });
                oVar.setFrom(1);
                oVar.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vY(boolean z) {
        String forumId = this.lvi == null ? "" : this.lvi.getForumId();
        if (this.mui != null) {
            this.mui.a(this.writeImagesInfo, this.mFrom, forumId);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public synchronized VoiceManager getVoiceManager() {
        if (this.hzJ == null) {
            this.hzJ = VoiceManager.instance();
        }
        return this.hzJ;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bYw() {
        this.hzJ = getVoiceManager();
        this.hzJ.stopPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null) {
            String errorString = postWriteCallBackData.getErrorString();
            if (AntiHelper.bA(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString())) {
                if (AntiHelper.a(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getErrorCode(), this.hAZ) != null) {
                    TiebaStatic.log(new ao(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ag("obj_locate", av.a.LOCATE_WRITE));
                }
            } else if (postWriteCallBackData.getErrorCode() != 0) {
                String errorString2 = postWriteCallBackData.getErrorString();
                if (TextUtils.isEmpty(errorString2)) {
                    errorString2 = getPageContext().getPageActivity().getString(R.string.sand_fail);
                }
                showToast(errorString2);
            } else if (this.lvi.getType() != 7) {
                if (this.mts == null) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
                    return;
                }
                E(z, errorString);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z, String str) {
        this.evC = i;
        if (this.etN != null) {
            this.etN.b(new com.baidu.tbadk.editortools.a(19, 15, new com.baidu.tbadk.editortools.d.a(i, z, str)));
        }
    }

    private void dth() {
        if (!this.mtD) {
            if (this.etN != null) {
                this.etN.b(new com.baidu.tbadk.editortools.a(12, -1, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
                this.etN.b(new com.baidu.tbadk.editortools.a(12, 11, new com.baidu.tbadk.editortools.imagetool.a(this.writeImagesInfo, true)));
            }
            String forumId = this.lvi == null ? "" : this.lvi.getForumId();
            if (this.mui != null) {
                this.mui.a(this.writeImagesInfo, this.mFrom, forumId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void in(boolean z) {
        if (this.etN != null) {
            this.etN.b(new com.baidu.tbadk.editortools.a(9, -1, Boolean.valueOf(z)));
        }
    }

    private void GU(int i) {
        if (i < this.mtq.size()) {
            for (int i2 = 0; i2 < this.mtq.size(); i2++) {
                this.mtq.get(i2).vJ(false);
            }
            this.mtq.get(i).vJ(true);
        }
    }

    @Override // com.baidu.tieba.write.i.a
    public void Ez(int i) {
        if (i == com.baidu.tbadk.core.util.w.getCount(this.mPrefixData.getPrefixs()) - 1) {
            TiebaStatic.log(new ao("c13014").ag("obj_type", 1));
        } else {
            TiebaStatic.log(new ao("c13014").ag("obj_type", 2));
        }
        this.lvj = i;
        this.lvH.setCurrentIndex(i);
        GU(i);
        this.lvG.setText(this.mPrefixData.getPrefixs().get(i));
        deC();
        com.baidu.adp.lib.f.g.dismissPopupWindow(this.lvH, getPageContext().getPageActivity());
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.lvJ.setSelected(false);
        an.setImageResource(this.lvI, R.drawable.icon_arrow_gray_down);
        ShowSoftKeyPadDelay(this.mtn);
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
        if (this.lvi != null) {
            if (this.lvi.getType() == 4) {
                return PageStayDurationConstants.PageName.PHOTOLIVE_WRITE;
            }
            if (this.lvi.getType() == 5) {
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
            bfE();
        } else if (i == 1) {
            ArrayMap<String, Boolean> transformPermissionResult = ac.transformPermissionResult(strArr, iArr);
            if (ac.checkCamera(getApplicationContext())) {
                am.a(getPageContext(), this.evv);
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
        this.aXk = z;
        if (this.muA && System.currentTimeMillis() - this.muB < 800) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), getCurrentFocus());
            this.muA = false;
        }
        if (this.mtH != null && !z) {
            this.mtH.bSk();
        }
        if (this.mtJ != null && !z) {
            dsK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pm(String str) {
        if (!com.baidu.adp.lib.util.k.isEmpty(str) && this.mux != null) {
            Pn(str);
            this.mux.dismiss();
        }
    }

    private void fz(Context context) {
        muz = l.getEquipmentHeight(context);
    }

    private void Pn(String str) {
        if (this.writeImagesInfo.getChosedFiles() != null && this.writeImagesInfo.getChosedFiles().size() >= this.writeImagesInfo.getMaxImagesAllowed()) {
            showToast(String.format(getPageContext().getContext().getString(R.string.max_choose_image_count), Integer.valueOf(this.writeImagesInfo.getMaxImagesAllowed())));
            return;
        }
        this.writeImagesInfo.addChooseFileFromCamera(str);
        this.writeImagesInfo.updateQuality();
        this.muA = true;
        dtC();
        if (this.writeImagesInfo.getChosedFiles() != null) {
            dth();
        }
        vY(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [4952=4] */
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

    private File dtE() {
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

    private void dtF() {
        if (this.muv != null && this.lvi.getType() == 0 && this.lvi.getType() == 9) {
            fz(getActivity());
            this.mBubbleView = getPageContext().getPageActivity().getLayoutInflater().inflate(R.layout.rec_dialog, (ViewGroup) null);
            this.mBubbleView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.WriteActivity.40
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (WriteActivity.this.muv != null) {
                        WriteActivity.this.Pm(WriteActivity.this.muv.getAbsolutePath());
                    }
                }
            });
            this.muw = (TbImageView) this.mBubbleView.findViewById(R.id.rec_img_view);
            this.muy = (LinearLayout) this.mBubbleView.findViewById(R.id.rec_bubble_layout);
            if (!com.baidu.tbadk.core.sharedPref.b.aVP().getString(SharedPrefConfig.WRITE_REC_PIC_PATH, "").equalsIgnoreCase(this.muv.getAbsolutePath())) {
                com.baidu.tbadk.core.sharedPref.b.aVP().putString(SharedPrefConfig.WRITE_REC_PIC_PATH, this.muv.getAbsolutePath());
                Bitmap g = g(this.muv.getAbsolutePath(), getResources().getDimensionPixelSize(R.dimen.ds160));
                if (g != null) {
                    this.muw.setImageBitmap(g);
                    this.muw.setDrawBorder(true);
                    this.muw.setBorderWidth(2);
                    this.muw.setBorderColor(an.getColor(R.color.common_color_10264));
                    this.mux = new Dialog(getActivity(), R.style.bubble_dialog);
                    this.mux.setCanceledOnTouchOutside(true);
                    this.mux.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.write.write.WriteActivity.41
                        @Override // android.content.DialogInterface.OnDismissListener
                        public void onDismiss(DialogInterface dialogInterface) {
                            if (WriteActivity.this.muA) {
                                l.hideSoftKeyPad(WriteActivity.this.getPageContext().getPageActivity(), WriteActivity.this.getCurrentFocus());
                                WriteActivity.this.muB = System.currentTimeMillis();
                            }
                        }
                    });
                    this.mux.setContentView(this.mBubbleView);
                    this.mux.show();
                    Window window = this.mux.getWindow();
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    window.setGravity(83);
                    attributes.x = getResources().getDimensionPixelSize(R.dimen.ds28);
                    attributes.y = (muz / 18) + getResources().getDimensionPixelSize(R.dimen.ds12);
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
        if (this.aXk && charSequence != null && i2 == 1 && i < charSequence.length() && i >= 0) {
            this.mti = false;
            this.mth = "";
            if ("from_content".equals(str)) {
                this.mth = "from_content";
            } else if ("from_title".equals(str)) {
                this.mth = "from_title";
            }
            if (com.baidu.tbadk.plugins.b.za(String.valueOf(charSequence.charAt(i)))) {
                vU(false);
            }
        }
    }

    public void cZC() {
        if (this.mtW || !com.baidu.tbadk.core.util.w.isEmpty(this.mList) || !StringUtils.isNull(this.lvi.getTitle())) {
            this.mtm.setVisibility(0);
            this.mtm.requestFocus();
            return;
        }
        this.mtm.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtG() {
        if (this.etN != null) {
            this.etN.post(new Runnable() { // from class: com.baidu.tieba.write.write.WriteActivity.42
                @Override // java.lang.Runnable
                public void run() {
                    if (!WriteActivity.this.mrc && WriteActivity.this.etN != null && WriteActivity.this.etN.etQ != null) {
                        String clipBoardContent = UtilHelper.getClipBoardContent();
                        if (ar.isEmpty(clipBoardContent) || !bc.aWU().j(clipBoardContent)) {
                            WriteActivity.this.mtH.cRN();
                            return;
                        }
                        if (WriteActivity.this.msj == null) {
                            WriteActivity.this.msj = new FindNewLinkBubbleController(WriteActivity.this.getPageContext(), WriteActivity.this.muN);
                        }
                        WriteActivity.this.msj.a(WriteActivity.this.etN.etQ.nz(31), clipBoardContent, FindNewLinkBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
                    }
                }
            });
        }
    }

    public String getCallFrom() {
        return this.ici;
    }

    public WriteData dev() {
        return this.lvi;
    }

    public FrsTabInfoData dtH() {
        return this.mnb;
    }

    public String getFrom() {
        return this.mFrom;
    }

    private boolean dtI() {
        return (this.muJ == null || this.muK == null || this.muJ.getWriteVoteData() == null || this.muK.getVisibility() != 0) ? false : true;
    }
}
