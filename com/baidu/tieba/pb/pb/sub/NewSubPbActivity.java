package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.t;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.l;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.h;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tbadk.widget.richText.i;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.ah;
import com.baidu.tieba.pb.pb.main.ay;
import com.baidu.tieba.pb.pb.main.bd;
import com.baidu.tieba.pb.pb.main.n;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.e;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes16.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, i, com.baidu.tieba.pb.pb.a<NewSubPbActivity> {
    private static String kBS = "tbgametype";
    private View.OnClickListener aMH;
    private bd dKK;
    private com.baidu.adp.lib.d.b<ImageView> eRG;
    private com.baidu.adp.lib.d.b<GifView> eRH;
    private com.baidu.adp.lib.d.b<TextView> eUX;
    private com.baidu.adp.lib.d.b<View> eUY;
    private com.baidu.adp.lib.d.b<LinearLayout> eUZ;
    private com.baidu.adp.lib.d.b<RelativeLayout> eVa;
    private com.baidu.tbadk.core.message.a eeP;
    private e eez;
    private VoiceManager hFy;
    private com.baidu.tieba.frs.profession.permission.c hJL;
    private com.baidu.tieba.write.c iFa;
    private EditText iFb;
    private h jqF;
    public al jqz;
    private SubPbModel kBT;
    private ForumManageModel kBU;
    private com.baidu.tieba.pb.pb.sub.a kBV;
    private ah kBW;
    private AbsListView.OnScrollListener kBX;
    private TbRichTextView.i kBY;
    private SubPbModel.a kBZ;
    private com.baidu.adp.base.d kCa;
    private BdUniqueId kCe;
    private com.baidu.tieba.pb.e<p> kCg;
    private boolean kCh;
    private n kCi;
    private com.baidu.tieba.pb.pb.main.b.a kkn;
    private com.baidu.adp.base.e koA;
    private com.baidu.tbadk.core.view.c koB;
    private com.baidu.adp.widget.ImageView.a koE;
    private String koF;
    private TbRichTextMemeInfo koG;
    private com.baidu.tieba.pb.pb.report.a koe;
    private com.baidu.tbadk.baseEditMark.a kof;
    private PostWriteCallBackData kqm;
    private String kwK;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int kpp = 0;
    PostData iFI = null;
    private a.InterfaceC0489a kpl = null;
    private a kCb = null;
    private a kCc = null;
    private boolean mIsPaused = false;
    private boolean kCd = false;
    private boolean kCf = false;
    private boolean eAv = false;
    private com.baidu.tbadk.editortools.pb.c eBX = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bjj() {
            NewSubPbActivity.this.kBV.cRP();
        }
    };
    private int kjJ = 0;
    private boolean mIsFromSchema = false;
    private BdUniqueId kCj = BdUniqueId.gen();
    private boolean klG = com.baidu.tbadk.a.d.aRO();
    private boolean kCk = true;
    private com.baidu.tbadk.editortools.pb.b eBY = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bji() {
            if (!NewSubPbActivity.this.iFa.dub()) {
                return (NewSubPbActivity.this.jqz == null || NewSubPbActivity.this.kBT == null || NewSubPbActivity.this.kBT.cax() == null || NewSubPbActivity.this.jqz.aG(NewSubPbActivity.this.kBT.cax().replyPrivateFlag, al.eaQ)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.iFa.dud());
            if (NewSubPbActivity.this.jqF.bjA()) {
                NewSubPbActivity.this.jqF.a(NewSubPbActivity.this.kqm);
            }
            NewSubPbActivity.this.pk(true);
            return true;
        }
    };
    private NewWriteModel.d iFh = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.jqF != null && NewSubPbActivity.this.jqF.biJ() != null) {
                NewSubPbActivity.this.jqF.biJ().hide();
                if (NewSubPbActivity.this.kBT.cSo()) {
                    TiebaStatic.log(new ap("c10367").dn("post_id", NewSubPbActivity.this.kBT.bjg()));
                }
            }
            if (z) {
                NewSubPbActivity.this.iFa.Py(null);
                NewSubPbActivity.this.iFa.aZ(null);
                NewSubPbActivity.this.iFa.wi(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.iFa.aZ(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.iFa.Py(postWriteCallBackData.getErrorString());
                if (!x.isEmpty(NewSubPbActivity.this.iFa.dtZ())) {
                    NewSubPbActivity.this.kqm = postWriteCallBackData;
                    if (NewSubPbActivity.this.jqF.bjA()) {
                        NewSubPbActivity.this.jqF.a(NewSubPbActivity.this.kqm);
                    }
                    NewSubPbActivity.this.pk(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (as.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(NewSubPbActivity.this.getActivity(), NewSubPbActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(NewSubPbActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(NewSubPbActivity.this.getActivity());
                if (as.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.xl(NewSubPbActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.xl(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(NewSubPbActivity.this.getActivity(), 0, 26, 2)));
                        TiebaStatic.log(new ap("c13746").ah("obj_locate", 1).ah("obj_type", 2));
                    }
                });
                aVar.b(NewSubPbActivity.this.getPageContext()).aYL();
                TiebaStatic.log(new ap("c13745").ah("obj_locate", 1).ah("obj_type", 2));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.jqz != null) {
                NewSubPbActivity.this.jqz.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.kBV.cRQ();
        }
    };
    private CustomMessageListener kpb = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.kCe) {
                NewSubPbActivity.this.kBV.bMt();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.koB.showSuccessToast(NewSubPbActivity.this.koA.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.koA.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.zN(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.cNm();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (as.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.koA.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.koB.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener kpc = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.kCe) {
                NewSubPbActivity.this.kBV.bMt();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.koB.showSuccessToast(NewSubPbActivity.this.koA.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (as.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.koA.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.koB.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener kpd = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.kCe) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.kBV.bMt();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.mbC;
                if (aVar.error == 0 && dataRes != null) {
                    boolean z2 = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0) == 1;
                    sparseArray.put(R.id.tag_user_mute_visible, true);
                    sparseArray.put(R.id.tag_user_mute_msg, dataRes.mute_confirm);
                    z = z2;
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, false);
                    z = false;
                }
                int intValue = sparseArray.get(R.id.tag_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_from)).intValue() : 0;
                if (intValue == 0) {
                    NewSubPbActivity.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    NewSubPbActivity.this.kBV.a(sparseArray, z);
                }
            }
        }
    };
    boolean kpq = false;
    private final b.InterfaceC0492b kps = new b.InterfaceC0492b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0492b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.koE != null && !TextUtils.isEmpty(NewSubPbActivity.this.koF)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.koG == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.koF));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.koF;
                        aVar.pkgId = NewSubPbActivity.this.koG.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.koG.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.dKK == null) {
                            NewSubPbActivity.this.dKK = new bd(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.dKK.j(NewSubPbActivity.this.koF, NewSubPbActivity.this.koE.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.koE = null;
                NewSubPbActivity.this.koF = null;
            }
        }
    };
    private CustomMessageListener iRM = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener hHe = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    l lVar = (l) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.kBT.cSh() != null && NewSubPbActivity.this.kBT.cSh().cLt() != null && NewSubPbActivity.this.kBT.cSh().cLt().aWl() != null && currentAccount.equals(NewSubPbActivity.this.kBT.cSh().cLt().aWl().getUserId()) && NewSubPbActivity.this.kBT.cSh().cLt().aWl().getPendantData() != null) {
                        NewSubPbActivity.this.kBT.cSh().cLt().aWl().getPendantData().wU(lVar.aUh());
                        NewSubPbActivity.this.kBT.cSh().cLt().aWl().getPendantData().cN(lVar.bin());
                        NewSubPbActivity.this.kBV.a(NewSubPbActivity.this.kBT.cSh(), NewSubPbActivity.this.kBT.cSh().cLt(), NewSubPbActivity.this.kBT.cSh().cwL(), NewSubPbActivity.this.kBT.cSh().aSj(), NewSubPbActivity.this.kBT.cKM(), NewSubPbActivity.this.kBT.cSu() != null);
                    }
                }
            }
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void callback(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        aE(bundle);
        if (getIntent() != null) {
            this.mIsFromSchema = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_FROM_SCHEMA, false);
        }
        super.onCreate(bundle);
        this.koA = getPageContext();
        this.kCd = true;
        this.iFa = new com.baidu.tieba.write.c();
        this.iFa.GW(R.color.cp_cont_h_alpha85);
        this.iFa.GV(R.color.cp_cont_a);
        bCM();
        cRF();
        initData(bundle);
        initUI();
        ((SubPbView) this.kBV.getRootView()).show();
        qG(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.kBV.tm(this.mIsFromSchema);
        this.koB = new com.baidu.tbadk.core.view.c();
        this.koB.toastTime = 1000L;
        registerListener(this.kpd);
        registerListener(this.kpb);
        registerListener(this.kpc);
        this.kCe = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.kCe;
        userMuteAddAndDelCustomMessage.setTag(this.kCe);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.kCe;
        userMuteCheckCustomMessage.setTag(this.kCe);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.jqz = new al(getPageContext());
        this.jqz.a(new al.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
            @Override // com.baidu.tbadk.core.util.al.a
            public void q(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.jqF.bjI();
                }
            }
        });
        this.koe = new com.baidu.tieba.pb.pb.report.a(this);
        this.koe.x(getUniqueId());
        this.kkn = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.kBV = new com.baidu.tieba.pb.pb.sub.a(this, this.aMH);
        this.kBV.a(this.kBT);
        setContentView(this.kBV.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.kBV.setOnScrollListener(this.kBX);
        this.kBV.b(this);
        this.kBV.setOnImageClickListener(this.kBY);
        this.kBV.setOnLongClickListener(this.mOnLongClickListener);
        this.kBV.f(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.kBT != null) {
                    NewSubPbActivity.this.kBT.loadData();
                }
            }
        });
        this.kBV.a(this.kCb);
        this.kBV.b(this.kCc);
        if (this.kBT != null && this.kBT.cRH() && !this.kBT.cSt()) {
            this.kBV.cRV().setVisibility(8);
        } else {
            this.kBV.cRV().setVisibility(0);
        }
        if (this.kBT != null && !this.kBT.cRH()) {
            this.kBV.setIsFromPb(false);
        }
    }

    private boolean aE(Bundle bundle) {
        if (bundle != null) {
            this.eAv = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.eAv = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.eAv;
    }

    public void initData(Bundle bundle) {
        this.kBT = new SubPbModel(getPageContext());
        this.kBT.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                NewSubPbActivity.this.kBV.u(postData);
                NewSubPbActivity.this.kBV.b((BdListView.e) null);
            }
        });
        this.kBU = new ForumManageModel(getPageContext());
        this.kBU.setLoadDataCallBack(this.kCa);
        this.hFy = new VoiceManager();
        this.hFy.onCreate(getPageContext());
        this.kof = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.kof != null) {
            this.kof.a(this.kpl);
        }
        if (bundle != null) {
            this.kBT.initWithBundle(bundle);
        } else {
            this.kBT.initWithIntent(getIntent());
        }
        this.kBT.a(this.kBZ);
        if (this.kBT.cRH()) {
            this.kBT.loadData();
        } else {
            this.kBT.cSm();
        }
    }

    public void cRF() {
        this.kBZ = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, final p pVar) {
                if (NewSubPbActivity.this.kBV != null) {
                    NewSubPbActivity.this.kBV.cRQ();
                    if (!z) {
                        NewSubPbActivity.this.bw(i, str);
                        return;
                    }
                    NewSubPbActivity.this.kBV.hideNoDataView();
                    if (pVar != null) {
                        if (pVar.cLt() != null || NewSubPbActivity.this.kBT != null) {
                            pVar.cLt().a(NewSubPbActivity.this.kBT.cSs());
                        }
                        if (NewSubPbActivity.this.kBV != null) {
                            NewSubPbActivity.this.qG(pVar.aTN() != null && pVar.aTN().isBjh());
                            if (NewSubPbActivity.this.jqF != null && NewSubPbActivity.this.jqF.biJ() != null) {
                                NewSubPbActivity.this.jqF.biJ().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.kBV.a(pVar, NewSubPbActivity.this.kBT.cKM(), NewSubPbActivity.this.kBT.cSu() != null);
                            if (NewSubPbActivity.this.kCd) {
                                NewSubPbActivity.this.kBV.getListView().setSelectionFromTop(NewSubPbActivity.this.kBV.getListView().getHeaderViewsCount() + 1, -com.baidu.adp.lib.util.l.getDimens(NewSubPbActivity.this, R.dimen.tbds18));
                                NewSubPbActivity.this.cRG();
                                NewSubPbActivity.this.kCd = false;
                            }
                        }
                        if (NewSubPbActivity.this.jqF != null) {
                            NewSubPbActivity.this.jqF.a(pVar.cax());
                            NewSubPbActivity.this.jqF.setThreadData(pVar.aTN());
                            if (NewSubPbActivity.this.getIntent() != null && NewSubPbActivity.this.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && NewSubPbActivity.this.kCk) {
                                com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        NewSubPbActivity.this.kCk = false;
                                        NewSubPbActivity.this.c(pVar.cLt(), false);
                                    }
                                }, 200L);
                            }
                        }
                        if (NewSubPbActivity.this.kCg == null) {
                            NewSubPbActivity.this.kCg = new com.baidu.tieba.pb.e();
                        }
                        NewSubPbActivity.this.kCg.setData(pVar);
                        NewSubPbActivity.this.kCg.setType(0);
                        NewSubPbActivity.this.jqz.a(NewSubPbActivity.this.kBT.cSx());
                    }
                }
            }
        };
        this.kpl = new a.InterfaceC0489a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0489a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.kof != null) {
                        NewSubPbActivity.this.kof.he(z2);
                    }
                    MarkData aSm = NewSubPbActivity.this.kof.aSm();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(aSm);
                        if (NewSubPbActivity.this.kof != null) {
                            if (aSm != null) {
                                NewSubPbActivity.this.kBT.to(true);
                                NewSubPbActivity.this.kBT.Lh(NewSubPbActivity.this.kBT.bjg());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.kBV != null) {
                                NewSubPbActivity.this.kBV.tn(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.kBT.to(false);
                        NewSubPbActivity.this.kBT.Lh(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.kBV != null) {
                            NewSubPbActivity.this.kBV.tn(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.kCb = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.kBT.cSh() != null && NewSubPbActivity.this.kBT.cSh().aTN() != null && NewSubPbActivity.this.kBT.cSh().aTN().aWl() != null) {
                    str = String.valueOf(NewSubPbActivity.this.kBT.cSh().aTN().aWl().getUserId());
                }
                String str4 = "";
                if (objArr.length > 1) {
                    str4 = String.valueOf(objArr[1]);
                }
                String str5 = "";
                if (objArr.length > 2) {
                    str5 = String.valueOf(objArr[2]);
                }
                if (objArr.length > 3) {
                    str2 = String.valueOf(objArr[3]);
                }
                if (objArr.length > 4) {
                    str3 = String.valueOf(objArr[4]);
                }
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.kBT.cSh().bjG().getId(), NewSubPbActivity.this.kBT.cSh().bjG().getName(), NewSubPbActivity.this.kBT.cSh().aTN().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.kCc = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.kBU.dlV() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.kBT != null && NewSubPbActivity.this.kBT.cSh() != null && NewSubPbActivity.this.kBT.cSh().bjG() != null && NewSubPbActivity.this.kBT.cSh().aTN() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.kBU.NR(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.kBU.a(NewSubPbActivity.this.kBT.cSh().bjG().getId(), NewSubPbActivity.this.kBT.cSh().bjG().getName(), NewSubPbActivity.this.kBT.cSh().aTN().getId(), valueOf, i2, i, z, NewSubPbActivity.this.kBT.cSh().aTN().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.kCa = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.kBV.a(NewSubPbActivity.this.kBU.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.kBU.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.kDh != 1002 || bVar.fVs) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.kBV.a(1, dVar.Pv, dVar.lPQ, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean cK(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void bCM() {
        registerListener(this.hHe);
        this.aMH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r2v67, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostData postData;
                SparseArray sparseArray;
                SparseArray sparseArray2;
                boolean z = true;
                boolean z2 = false;
                SparseArray<Object> sparseArray3 = null;
                if (view != null || NewSubPbActivity.this.kBV != null) {
                    if (view == NewSubPbActivity.this.kBV.cSb()) {
                        NewSubPbActivity.this.kBV.cQo();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                com.baidu.tbadk.core.util.bd.baV().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.kBV.cgo()) {
                        if (view != NewSubPbActivity.this.kBV.cRU()) {
                            if (view == NewSubPbActivity.this.kBV.cRT()) {
                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                    NewSubPbActivity.this.kBV.cRJ();
                                    NewSubPbActivity.this.kBV.cRK();
                                    if (NewSubPbActivity.this.jqF != null) {
                                        NewSubPbActivity.this.jqF.bjO();
                                    }
                                }
                            } else if (view.getId() != R.id.pb_floor_feedback) {
                                if (view == NewSubPbActivity.this.kBV.cRO()) {
                                    NewSubPbActivity.this.kBV.cQo();
                                    if (NewSubPbActivity.this.kBT.loadData()) {
                                        NewSubPbActivity.this.kBV.cRM();
                                    }
                                } else if (view == NewSubPbActivity.this.kBV.cRV() || view == NewSubPbActivity.this.kBV.cRW() || view == NewSubPbActivity.this.kBV.cRY()) {
                                    if (NewSubPbActivity.this.kCf) {
                                        NewSubPbActivity.this.kCf = false;
                                        return;
                                    }
                                    if (NewSubPbActivity.this.kBT.cSh() != null && NewSubPbActivity.this.kBT.cSh().aTN() != null) {
                                        z2 = ax.a(NewSubPbActivity.this.kBT.cSh().aTN().getBaijiahaoData());
                                    }
                                    if (z2) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.kBT.cNL(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.kBT.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.kBT.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.kBT.cSh() != null && NewSubPbActivity.this.kBT.cSh().aTN() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.kBT.cSh().aTN().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.kBT.cNL(), NewSubPbActivity.this.kBT.bjg(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.kBT.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.kBT.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.kBV.cRZ() == null || view != NewSubPbActivity.this.kBV.cRZ().cOK()) {
                                    if (NewSubPbActivity.this.kBV.cRZ() == null || view != NewSubPbActivity.this.kBV.cRZ().cON()) {
                                        if (NewSubPbActivity.this.kBV.cRZ() == null || view != NewSubPbActivity.this.kBV.cRZ().cOL()) {
                                            if (NewSubPbActivity.this.kBV.cRZ() == null || view != NewSubPbActivity.this.kBV.cRZ().cOM()) {
                                                if (NewSubPbActivity.this.kBV.cRZ() == null || view != NewSubPbActivity.this.kBV.cRZ().cOO()) {
                                                    if (view == NewSubPbActivity.this.kBV.cRS() || view == NewSubPbActivity.this.kBV.cRY()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.jqF.bjL()) {
                                                                NewSubPbActivity.this.jqF.bjM();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.jqF.zO(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view != null && (view.getTag() instanceof n)) {
                                                        NewSubPbActivity.this.kCi = (n) view.getTag();
                                                        if (bf.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.kCf) {
                                                                NewSubPbActivity.this.kCf = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.jqz == null || NewSubPbActivity.this.kBT == null || NewSubPbActivity.this.kBT.cax() == null || NewSubPbActivity.this.jqz.lJ(NewSubPbActivity.this.kBT.cax().replyPrivateFlag)) && (sparseArray2 = (SparseArray) view.getTag(R.id.tag_from)) != null) {
                                                                if (!(view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) || view.getTag(R.id.tag_subpb_ban_display_keyboard) != Boolean.TRUE) {
                                                                    z = false;
                                                                }
                                                                NewSubPbActivity.this.b(sparseArray2, z);
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view.getId() != R.id.post_info_commont_img && view.getId() != R.id.pb_floor_comment_container) {
                                                        if (NewSubPbActivity.this.kBW == null || view != NewSubPbActivity.this.kBW.cOM()) {
                                                            if (NewSubPbActivity.this.kBW == null || view != NewSubPbActivity.this.kBW.cOK()) {
                                                                if (NewSubPbActivity.this.kBW == null || view != NewSubPbActivity.this.kBW.cON()) {
                                                                    if (NewSubPbActivity.this.kBW == null || view != NewSubPbActivity.this.kBW.cOO()) {
                                                                        if (NewSubPbActivity.this.kBW == null || view != NewSubPbActivity.this.kBW.cOQ()) {
                                                                            if (NewSubPbActivity.this.kBW == null || view != NewSubPbActivity.this.kBW.cOR()) {
                                                                                if (NewSubPbActivity.this.kBW == null || view != NewSubPbActivity.this.kBW.cOS()) {
                                                                                    if (NewSubPbActivity.this.kBW != null && view == NewSubPbActivity.this.kBW.cOL()) {
                                                                                        if (!j.isNetWorkAvailable()) {
                                                                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                                                            return;
                                                                                        }
                                                                                        SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                                                                                        if (sparseArray4 != null) {
                                                                                            boolean booleanValue = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                                                                                            boolean booleanValue2 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                                                                                            boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                                                                                            if (booleanValue) {
                                                                                                if (booleanValue3) {
                                                                                                    sparseArray4.put(R.id.tag_from, 1);
                                                                                                    sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                                                                    NewSubPbActivity.this.c(sparseArray4);
                                                                                                    return;
                                                                                                }
                                                                                                sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                                                                NewSubPbActivity.this.kBV.cP(view);
                                                                                                return;
                                                                                            } else if (booleanValue2) {
                                                                                                NewSubPbActivity.this.kBV.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                                return;
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    int id = view.getId();
                                                                                    if (id == R.id.pb_item_tail_content) {
                                                                                        if (bf.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                            String string2 = com.baidu.tbadk.core.sharedPref.b.aZP().getString("tail_link", "");
                                                                                            if (!StringUtils.isNull(string2)) {
                                                                                                TiebaStatic.log("c10056");
                                                                                                com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    } else if (id == R.id.richText && (view.getTag() instanceof SparseArray)) {
                                                                                        Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
                                                                                        if (obj instanceof PostData) {
                                                                                            PostData postData2 = (PostData) obj;
                                                                                            if (postData2.getType() != PostData.dRN && !TextUtils.isEmpty(postData2.getBimg_url()) && k.aTv().isShowImages()) {
                                                                                                NewSubPbActivity.this.Le(postData2.getId());
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    } else {
                                                                                        return;
                                                                                    }
                                                                                } else if (NewSubPbActivity.this.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                                                                                    PostData postData3 = (PostData) sparseArray.get(R.id.tag_clip_board);
                                                                                    if (postData3.aYc() != null) {
                                                                                        NewSubPbActivity.this.d(postData3.aYc());
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.koE != null && !TextUtils.isEmpty(NewSubPbActivity.this.koF)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.dKK == null) {
                                                                                        NewSubPbActivity.this.dKK = new bd(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.dKK.j(NewSubPbActivity.this.koF, NewSubPbActivity.this.koE.getImageByte());
                                                                                    NewSubPbActivity.this.koE = null;
                                                                                    NewSubPbActivity.this.koF = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.koE != null && !TextUtils.isEmpty(NewSubPbActivity.this.koF)) {
                                                                            if (NewSubPbActivity.this.koG == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.koF));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.koF;
                                                                                aVar.pkgId = NewSubPbActivity.this.koG.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.koG.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.koE = null;
                                                                            NewSubPbActivity.this.koF = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.iFI != null) {
                                                                        NewSubPbActivity.this.iFI.fs(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.iFI = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                if (sparseArray5 != null && (sparseArray5.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_id) instanceof String) && (sparseArray5.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.kBV.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.cJ(view);
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (!j.isNetWorkAvailable()) {
                                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                            return;
                                                        } else {
                                                            Object tag = view.getTag();
                                                            if (tag instanceof String) {
                                                                NewSubPbActivity.this.KB((String) tag);
                                                                return;
                                                            } else if (tag instanceof SparseArray) {
                                                                SparseArray<Object> sparseArray6 = (SparseArray) tag;
                                                                if ((sparseArray6.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                                    sparseArray6.put(R.id.tag_from, 0);
                                                                    sparseArray6.put(R.id.tag_check_mute_from, 2);
                                                                    NewSubPbActivity.this.c(sparseArray6);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    } else if (NewSubPbActivity.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                        SparseArray sparseArray7 = (SparseArray) view.getTag();
                                                        if ((sparseArray7.get(R.id.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray7.get(R.id.tag_load_sub_data)) != null) {
                                                            if (NewSubPbActivity.this.kBT != null) {
                                                                TiebaStatic.log(new ap("c13700").dn("tid", NewSubPbActivity.this.kBT.cNM()).dn("fid", NewSubPbActivity.this.kBT.getFromForumId()).t("uid", TbadkCoreApplication.getCurrentAccountId()).dn("post_id", postData.getId()).ah("obj_type", 3));
                                                            }
                                                            if (!(view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) || view.getTag(R.id.tag_subpb_ban_display_keyboard) != Boolean.TRUE) {
                                                                z = false;
                                                            }
                                                            NewSubPbActivity.this.c(postData, z);
                                                            return;
                                                        }
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (view.getTag() != null && (view.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                    if (sparseArray8.get(R.id.tag_clip_board) instanceof PostData) {
                                                        ((PostData) sparseArray8.get(R.id.tag_clip_board)).fs(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new ap("c11739").ah("obj_locate", 4));
                                            if (!j.isNetWorkAvailable()) {
                                                NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.kBV.cQo();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.KB(str4);
                                                    return;
                                                }
                                                return;
                                            } else if (tag2 instanceof SparseArray) {
                                                SparseArray<Object> sparseArray9 = (SparseArray) tag2;
                                                if ((sparseArray9.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray9.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray9.put(R.id.tag_from, 0);
                                                    sparseArray9.put(R.id.tag_check_mute_from, 2);
                                                    NewSubPbActivity.this.c(sparseArray9);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                        } else if (j.isNetWorkAvailable()) {
                                            NewSubPbActivity.this.kBV.cQo();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.cT(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.kBV.cQo();
                                    SparseArray sparseArray10 = (SparseArray) view.getTag();
                                    if (sparseArray10 != null) {
                                        NewSubPbActivity.this.kBV.a(((Integer) sparseArray10.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray10.get(R.id.tag_del_post_id), ((Integer) sparseArray10.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new ap("c11739").ah("obj_locate", 2));
                                    NewSubPbActivity.this.kBV.cQo();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.kBT.cSh() != null) {
                                        NewSubPbActivity.this.n(NewSubPbActivity.this.kBT.cSh().cLt());
                                    }
                                }
                            } else {
                                try {
                                    sparseArray3 = (SparseArray) view.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                }
                                if (sparseArray3 != null && ((PostData) sparseArray3.get(R.id.tag_clip_board)) != null) {
                                    if (NewSubPbActivity.this.kBW == null) {
                                        NewSubPbActivity.this.kBW = new ah(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aMH);
                                        NewSubPbActivity.this.kBV.cU(NewSubPbActivity.this.kBW.getView());
                                        NewSubPbActivity.this.kBW.sz(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.kBW.showDialog();
                                    if (NewSubPbActivity.this.sm(sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin()) {
                                        z2 = true;
                                    }
                                    NewSubPbActivity.this.kBW.a(sparseArray3, NewSubPbActivity.this.cKM(), z2);
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.kBV.cRJ();
                            NewSubPbActivity.this.kBV.cRK();
                            if (NewSubPbActivity.this.jqF != null) {
                                NewSubPbActivity.this.jqF.bjN();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.cML();
                        if (NewSubPbActivity.this.kBT != null && NewSubPbActivity.this.kBT.cSh() != null && NewSubPbActivity.this.kBT.cSh().aTN() != null && NewSubPbActivity.this.kBT.cSh().aTN().aWl() != null) {
                            TiebaStatic.log(new ap("c13402").dn("tid", NewSubPbActivity.this.kBT.cNL()).t("fid", NewSubPbActivity.this.kBT.cSh().aTN().getFid()).ah("obj_locate", 5).dn("uid", NewSubPbActivity.this.kBT.cSh().aTN().aWl().getUserId()));
                        }
                    }
                }
            }
        };
        this.kBX = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.kBV.cQo();
                    if (NewSubPbActivity.this.kjJ != 2 && NewSubPbActivity.this.kjJ != 1) {
                        NewSubPbActivity.this.kBV.cSe();
                    }
                }
                NewSubPbActivity.this.jqF.bjM();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.kBV.cSa();
            }
        };
        this.mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
            @Override // android.view.View.OnLongClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onLongClick(View view) {
                SparseArray<Object> sparseArray;
                SparseArray<Object> sparseArray2;
                boolean z = false;
                if (NewSubPbActivity.this.kBV != null && NewSubPbActivity.this.kBV.cRR()) {
                    return false;
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null && NewSubPbActivity.this.cK(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.koE = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.koF = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.koE == null || TextUtils.isEmpty(NewSubPbActivity.this.koF)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.koG = null;
                        } else {
                            NewSubPbActivity.this.koG = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.koE = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.koF = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.koG = null;
                        } else {
                            NewSubPbActivity.this.koG = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.koE = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.koF = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.koG = null;
                        } else {
                            NewSubPbActivity.this.koG = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    }
                    if (view.getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                        } catch (ClassCastException e2) {
                            e2.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                        NewSubPbActivity.this.kBV.a(NewSubPbActivity.this.kps, NewSubPbActivity.this.koE.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.iFI = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.iFI == null || NewSubPbActivity.this.kof == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.kof != null) {
                            NewSubPbActivity.this.kof.he(NewSubPbActivity.this.kBT.cSn());
                        }
                        boolean z2 = NewSubPbActivity.this.kof.aSj() && NewSubPbActivity.this.iFI.getId() != null && NewSubPbActivity.this.iFI.getId().equals(NewSubPbActivity.this.kBT.cSp());
                        if (NewSubPbActivity.this.kBW == null) {
                            NewSubPbActivity.this.kBW = new ah(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aMH);
                            NewSubPbActivity.this.kBV.cU(NewSubPbActivity.this.kBW.getView());
                            NewSubPbActivity.this.kBW.sz(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.kBW.showDialog();
                        boolean z3 = NewSubPbActivity.this.sm(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z4 = (NewSubPbActivity.this.kBT.cSh() == null || NewSubPbActivity.this.kBT.cSh().aTN() == null || !NewSubPbActivity.this.kBT.cSh().aTN().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z2) {
                            NewSubPbActivity.this.kBW.cOK().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.kBW.cOK().setText(R.string.mark);
                        }
                        if (booleanValue || z4) {
                            NewSubPbActivity.this.kBW.cOK().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.kBW.cOK().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.cK(view)) {
                            if (NewSubPbActivity.this.koE != null && !NewSubPbActivity.this.koE.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        ah ahVar = NewSubPbActivity.this.kBW;
                        int cKM = NewSubPbActivity.this.cKM();
                        if (NewSubPbActivity.this.klG && NewSubPbActivity.this.iFI.lOa) {
                            z = true;
                        }
                        ahVar.a(sparseArray2, cKM, z3, z);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.kBY = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
            /* JADX DEBUG: Multi-variable search result rejected for r8v6, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void a(View view, String str, int i, boolean z, boolean z2) {
                String str2;
                String str3;
                boolean z3;
                String str4;
                boolean z4;
                try {
                    if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                        p cSh = NewSubPbActivity.this.kBT.cSh();
                        TbRichText br = NewSubPbActivity.this.br(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (br != null && br.boJ() != null) {
                            tbRichTextData = br.boJ().get(NewSubPbActivity.this.kpp);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!tbRichTextData.boP().bpc()) {
                                String c = NewSubPbActivity.this.c(tbRichTextData);
                                arrayList.add(c);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap.put(c, imageUrlData);
                                String str5 = null;
                                String str6 = null;
                                String str7 = null;
                                if (cSh == null) {
                                    str4 = null;
                                    z4 = false;
                                } else {
                                    if (cSh.bjG() != null) {
                                        str5 = cSh.bjG().getName();
                                        str6 = cSh.bjG().getId();
                                    }
                                    if (cSh.aTN() != null) {
                                        str7 = cSh.aTN().getId();
                                    }
                                    str4 = str7;
                                    z4 = true;
                                }
                                if (NewSubPbActivity.this.kBT.cSu() != null) {
                                    concurrentHashMap = NewSubPbActivity.this.kBT.cSu();
                                    z4 = NewSubPbActivity.this.kBT.cSw();
                                    arrayList = NewSubPbActivity.this.kBT.cSv();
                                }
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(x.getItem(arrayList, 0));
                                ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                                aVar.s(arrayList2).wE(str5).wF(str6).wG(str4).hl(z4).wH(arrayList.get(0)).hm(true).a(concurrentHashMap).hn(true).ho(false).hp(false).r(NewSubPbActivity.this.aTN()).wI(String.valueOf(br.getPostId()));
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar.dI(NewSubPbActivity.this.getPageContext().getPageActivity())));
                                return;
                            }
                            NewSubPbActivity.this.kpq = false;
                            TbRichText dlk = cSh.cLt().dlk();
                            int size = arrayList.size();
                            int a2 = NewSubPbActivity.this.a(dlk, br, i, i, arrayList, concurrentHashMap);
                            int size2 = arrayList.size();
                            if (size == size2) {
                                str2 = "";
                            } else {
                                str2 = arrayList.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (cSh == null) {
                                str3 = null;
                                z3 = false;
                            } else {
                                if (cSh.bjG() != null) {
                                    str8 = cSh.bjG().getName();
                                    str9 = cSh.bjG().getId();
                                }
                                if (cSh.aTN() != null) {
                                    str10 = cSh.aTN().getId();
                                }
                                str3 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.kBT.cSu() != null) {
                                concurrentHashMap = NewSubPbActivity.this.kBT.cSu();
                                z3 = NewSubPbActivity.this.kBT.cSw();
                                arrayList = NewSubPbActivity.this.kBT.cSv();
                                a2 += NewSubPbActivity.this.kBT.getOffset();
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(x.getItem(arrayList, a2));
                            ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                            aVar2.s(arrayList3).wE(str8).wF(str9).wG(str3).hl(z3).wH(str2).hm(true).a(concurrentHashMap).hn(true).ho(false).hp(false).r(NewSubPbActivity.this.aTN()).wI(String.valueOf(br.getPostId()));
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar2.dI(NewSubPbActivity.this.getPageContext().getPageActivity())));
                            return;
                        }
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    boolean isGif = ((TbImageView) view).isGif();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EmotionDetailActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS, isGif)));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public bv aTN() {
        if (this.kBT == null || this.kBT.cSh() == null) {
            return null;
        }
        return this.kBT.cSh().aTN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJ(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            n(postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SparseArray<Object> sparseArray, boolean z) {
        if (sparseArray != null) {
            if (sparseArray.get(R.id.tag_clip_board) instanceof PostData) {
                c((PostData) sparseArray.get(R.id.tag_clip_board), z);
            } else {
                c((PostData) null, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PostData postData, boolean z) {
        if (postData != null) {
            if (postData.aWl() != null) {
                MetaData aWl = postData.aWl();
                this.jqF.setReplyId(aWl.getUserId());
                boolean z2 = postData.lOa;
                String str = "";
                if (postData.dlk() != null) {
                    str = postData.dlk().toString();
                }
                this.jqF.zQ(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.aWl().getName_show(), str));
                if (z2) {
                    if (!z) {
                        this.jqF.zP("");
                    }
                } else if (!z) {
                    this.jqF.zP(aWl.getName_show());
                }
            }
            this.kBV.cRK();
        }
        if (this.kCh) {
            tl(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eeP == null) {
                this.eeP = new com.baidu.tbadk.core.message.a();
            }
            if (this.eez == null) {
                this.eez = new e();
                this.eez.uniqueId = this.kCj;
            }
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dNB = 12;
            cVar.dNH = 9;
            cVar.dNG = 3;
            if (cRI() != null) {
                cVar.dNF = cRI().cSy();
            }
            if (cVar != null) {
                cVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (cVar != null) {
                        cVar.dNI = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (cVar != null) {
                        cVar.dNI = 1;
                        i = 0;
                    }
                }
                this.eeP.a(agreeData, i, getUniqueId(), false);
                this.eeP.a(agreeData, this.eez);
                if (cRI() == null && cRI().cSh() != null) {
                    this.eeP.a(this, cVar, agreeData, cRI().cSh().aTN());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (cVar != null) {
                cVar.dNI = 1;
            }
            i = 0;
            this.eeP.a(agreeData, i, getUniqueId(), false);
            this.eeP.a(agreeData, this.eez);
            if (cRI() == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo boP;
        if (tbRichText == tbRichText2) {
            this.kpq = true;
        }
        if (tbRichText != null && tbRichText.boJ() != null) {
            int size = tbRichText.boJ().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.boJ().get(i6) != null && tbRichText.boJ().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.boJ().get(i6).boP().getWidth() * equipmentDensity;
                    int height = tbRichText.boJ().get(i6).boP().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.boJ().get(i6).boP().bpc()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.boJ().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (boP = tbRichTextData.boP()) != null) {
                            String bpe = boP.bpe();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = bpe;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.kpq) {
                            i4 = i7 + 1;
                            i3 = i5;
                        }
                    }
                    i6++;
                    i7 = i4;
                    i5 = i3;
                }
                i3 = i5;
                i4 = i7;
                i6++;
                i7 = i4;
                i5 = i3;
            }
            return i7;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (this.kBW != null) {
            this.kBW.sz(z);
        }
        if (this.kBV != null) {
            this.kBV.sz(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo boP = tbRichTextData.boP();
        if (boP != null) {
            if (!StringUtils.isNull(boP.bpb())) {
                return boP.bpb();
            }
            if (boP.getHeight() * boP.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (boP.getHeight() * boP.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (boP.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * boP.getHeight())));
            } else {
                float width = boP.getWidth() / boP.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(as.getUrlEncode(boP.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText br(String str, int i) {
        if (this.kBT == null || this.kBT.cSh() == null || str == null || i < 0) {
            return null;
        }
        p cSh = this.kBT.cSh();
        TbRichText a2 = a(cSh.cLt(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(cSh.cLt(), str, i);
            if (a3 != null) {
            }
            return a3;
        }
        return a2;
    }

    private TbRichText a(PostData postData, String str, int i) {
        if (postData == null) {
            return null;
        }
        TbRichText dlk = postData.dlk();
        if (dlk != null) {
            ArrayList<TbRichTextData> boJ = dlk.boJ();
            int size = boJ.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (boJ.get(i3) != null && boJ.get(i3).getType() == 8) {
                    i2++;
                    if (boJ.get(i3).boP().bpe().equals(str)) {
                        int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = boJ.get(i3).boP().getWidth() * equipmentDensity;
                        int height = boJ.get(i3).boP().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.kpp = i3;
                        return dlk;
                    } else if (i2 > i) {
                        break;
                    }
                }
                i3++;
                i2 = i2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cML() {
        Intent intent = getIntent();
        if (intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false) {
            if (this.jqz == null || this.kBT == null || this.kBT.cax() == null || this.jqz.lJ(this.kBT.cax().replyPrivateFlag)) {
                if (this.jqF.bjA()) {
                    this.jqF.a((PostWriteCallBackData) null);
                    return;
                }
                this.kBV.cRJ();
                this.kBV.cRK();
                if (this.jqF != null) {
                    this.jqF.bjP();
                    return;
                }
                return;
            }
            return;
        }
        if (this.hJL == null) {
            this.hJL = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.hJL.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void nQ(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void z(boolean z, int i) {
                }

                /* JADX WARN: Removed duplicated region for block: B:26:0x00bf  */
                /* JADX WARN: Removed duplicated region for block: B:27:0x00ca  */
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void nR(boolean z) {
                    String str;
                    if (z) {
                        if (NewSubPbActivity.this.jqz == null || NewSubPbActivity.this.kBT == null || NewSubPbActivity.this.kBT.cax() == null || NewSubPbActivity.this.jqz.lJ(NewSubPbActivity.this.kBT.cax().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.kBT != null && NewSubPbActivity.this.kBT.cSh() != null && NewSubPbActivity.this.kBT.cSh().cLt() != null) {
                                PostData cLt = NewSubPbActivity.this.kBT.cSh().cLt();
                                if (cLt.dlk() != null && cLt.aWl() != null) {
                                    str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), cLt.aWl().getName_show(), cLt.dlk().toString());
                                    NewSubPbActivity.this.jqF.biJ().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                                    if (!NewSubPbActivity.this.jqF.bjA()) {
                                        NewSubPbActivity.this.jqF.a((PostWriteCallBackData) null);
                                        return;
                                    }
                                    NewSubPbActivity.this.kBV.cRJ();
                                    NewSubPbActivity.this.kBV.cRK();
                                    if (NewSubPbActivity.this.jqF != null) {
                                        NewSubPbActivity.this.jqF.bjP();
                                        return;
                                    }
                                    return;
                                }
                            }
                            str = null;
                            NewSubPbActivity.this.jqF.biJ().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                            if (!NewSubPbActivity.this.jqF.bjA()) {
                            }
                        }
                    }
                }
            });
        }
        if (this.kBT != null && this.kBT.cSh() != null && this.kBT.cSh().bjG() != null) {
            this.hJL.B(this.kBT.cSh().bjG().getId(), com.baidu.adp.lib.f.b.toLong(this.kBT.cNL(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sm(boolean z) {
        if (this.kBT == null) {
            return false;
        }
        return ((cKM() != 0) || this.kBT.cSh() == null || this.kBT.cSh().aTN() == null || this.kBT.cSh().aTN().aWl() == null || this.kBT.cSh().aTN().aUV() || TextUtils.equals(this.kBT.cSh().aTN().aWl().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw(int i, String str) {
        if (this.kBT.cSi()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.isNetOk()) {
            if (i == 4) {
                this.kBV.Et(str + "(4)");
            } else {
                this.kBV.yK(R.string.no_data_text);
            }
        } else {
            this.kBV.yK(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qG(boolean z) {
        this.jqF = (h) new com.baidu.tbadk.editortools.pb.i(z).dT(getActivity());
        if (this.jqF != null) {
            this.jqF.a(getPageContext());
            this.jqF.b(this.kBT);
            this.jqF.b(this.iFh);
            this.jqF.a(this.eBX);
            this.jqF.a(this.eBY);
            this.jqF.biJ().iJ(true);
            this.jqF.j(getPageContext());
        }
        if (this.kBV != null) {
            this.kBV.i(this.jqF);
        }
        if (this.jqF != null && this.kBT != null) {
            this.jqF.a(this.kBT.cax());
            this.jqF.bjM();
        }
        if (this.jqF != null) {
            this.jqF.bjQ().setDefaultHint(cPC());
            this.jqF.bjQ().setHint(cPC());
            this.iFb = this.jqF.bjQ().getInputView();
            this.iFb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.iFa != null) {
                        if (!NewSubPbActivity.this.iFa.duc()) {
                            NewSubPbActivity.this.pk(false);
                        }
                        NewSubPbActivity.this.iFa.wj(false);
                    }
                }
            });
        }
    }

    public void cRG() {
        if (!TbadkCoreApplication.isLogin()) {
            this.jqF.bjM();
        } else if (!StringUtils.isNull(this.kBT.cSq())) {
            if (this.kBV.cRN() && com.baidu.adp.lib.util.l.isNetOk()) {
                this.kBV.bYv();
            } else {
                this.kBV.cRQ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(R.id.tag_from, 1);
                    c(sparseArray);
                } else {
                    this.kBV.cP(view);
                }
            } else if (booleanValue2) {
                this.kBV.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.kBV.cRX(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        final String str;
        if (!(sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
            String[] strArr = new String[1];
            strArr[0] = z ? getResources().getString(R.string.un_mute) : getResources().getString(R.string.mute);
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            bVar.lr(R.string.operation);
            bVar.a(strArr, new b.InterfaceC0492b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0492b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    switch (i) {
                        case 0:
                            String str2 = "";
                            String str3 = "";
                            String str4 = "";
                            String str5 = "";
                            String str6 = "";
                            if (sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String) {
                                str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            }
                            if (sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String) {
                                str3 = (String) sparseArray.get(R.id.tag_user_mute_thread_id);
                            }
                            if (sparseArray.get(R.id.tag_user_mute_post_id) instanceof String) {
                                str4 = (String) sparseArray.get(R.id.tag_user_mute_post_id);
                            }
                            if (sparseArray.get(R.id.tag_user_mute_msg) instanceof String) {
                                str5 = (String) sparseArray.get(R.id.tag_user_mute_msg);
                            }
                            if (sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String) {
                                str6 = (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow);
                            }
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.kCe);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.kCe);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).aYN();
        }
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.kBV.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.kCe;
        userMuteCheckCustomMessage.setTag(this.kCe);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.kBV.a(0, bVar.Pv, bVar.lPQ, z);
            if (bVar.Pv) {
                if (bVar.hmP == 1) {
                    if (this.kBV.getListView() instanceof BdTypeListView) {
                        List<q> data = ((BdTypeListView) this.kBV.getListView()).getData();
                        if (!x.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.kBV.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.hmP == 2) {
                    this.kBT.Lg(bVar.mPostId);
                    this.kBV.a(this.kBT.cSh(), this.kBT.cKM(), this.kBT.cSu() != null);
                    if (this.kBT.cSr()) {
                        this.kBT.tp(false);
                        this.kBV.cRL();
                        this.kBT.loadData();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void KB(String str) {
        if (this.kBT != null && this.kBT.cSh() != null && this.kBT.cSh().aTN() != null && this.kBT.cSh().aTN().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.kBT.cNL(), str);
            bv aTN = this.kBT.cSh().aTN();
            if (aTN.aUT()) {
                format = format + "&channelid=33833";
            } else if (aTN.aYf()) {
                format = format + "&channelid=33842";
            } else if (aTN.aUU()) {
                format = format + "&channelid=33840";
            }
            KC(format);
            return;
        }
        this.koe.Lc(str);
    }

    private void KC(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void n(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.kBT.cSn() && postData.getId() != null && postData.getId().equals(this.kBT.cSp())) {
                z = true;
            }
            MarkData o = this.kBT.o(postData);
            if (o != null) {
                this.kBV.cQo();
                if (this.kof != null) {
                    this.kof.a(o);
                    if (!z) {
                        this.kof.aSl();
                    } else {
                        this.kof.aSk();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.kBT != null) {
            this.kBT.aD(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.jqF != null) {
            this.jqF.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.jqF.biJ().bhl();
        this.jqF.bjM();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.jqF.b(writeData);
                this.jqF.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l nT = this.jqF.biJ().nT(6);
                if (nT != null && nT.ezZ != null) {
                    nT.ezZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.jqF.bjI();
                }
                this.kBV.cSe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hFy != null) {
            this.hFy.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.mIsPaused = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.aQc().aQm();
        if (this.hFy != null) {
            this.hFy.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.iRM);
        this.kBV.ciz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.mIsPaused = false;
        super.onResume();
        cNp();
        if (this.hFy != null) {
            this.hFy.onResume(getPageContext());
        }
        registerListener(this.iRM);
        this.kBV.ciA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hFy != null) {
            this.hFy.onStop(getPageContext());
        }
        this.jqF.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.kCg));
        this.kBT.cancelLoadData();
        this.kBT.destory();
        this.kBU.cancelLoadData();
        if (this.hFy != null) {
            this.hFy.onDestory(getPageContext());
        }
        this.kBV.cQo();
        this.kBV.cgL();
        MessageManager.getInstance().unRegisterListener(this.kpb);
        MessageManager.getInstance().unRegisterListener(this.kpc);
        MessageManager.getInstance().unRegisterListener(this.kpd);
        MessageManager.getInstance().unRegisterListener(this.kCe);
        this.koA = null;
        this.koB = null;
        if (this.jqz != null) {
            this.jqz.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kBV.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hFy;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View cRS = this.kBV.cRS();
        if (cRS == null || (findViewWithTag = cRS.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean KU(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = com.baidu.tbadk.core.util.bd.getParamPair(com.baidu.tbadk.core.util.bd.getParamStr(str))) != null) {
            this.kCf = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return KU(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(kBS);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (KU(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                    kVar.mLink = str;
                    kVar.type = 3;
                    kVar.ezd = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
                }
            } else {
                com.baidu.tbadk.core.util.bd.baV().b(getPageContext(), new String[]{str});
            }
            this.kCf = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void am(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.kCf = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void an(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ap(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void r(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView getListView() {
        if (this.kBV != null) {
            return this.kBV.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int bpt() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> bpv() {
        if (this.eUX == null) {
            this.eUX = TbRichTextView.w(getPageContext().getPageActivity(), 8);
        }
        return this.eUX;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> bpw() {
        if (this.eRH == null) {
            this.eRH = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bWl */
                public GifView makeObject() {
                    return new GifView(NewSubPbActivity.this.getPageContext().getPageActivity());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: g */
                public void destroyObject(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: h */
                public GifView activateObject(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: i */
                public GifView passivateObject(GifView gifView) {
                    return gifView;
                }
            }, 20, 0);
        }
        return this.eRH;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> bpu() {
        if (this.eRG == null) {
            this.eRG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bpG */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = k.aTv().isShowImages();
                    foreDrawableImageView.setDefaultBg(ao.getDrawable(R.color.common_color_10220));
                    if (isShowImages) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: a */
                public void destroyObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.cp_bg_line_c);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: b */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (k.aTv().isShowImages()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(R.drawable.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: c */
                public ImageView passivateObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.eRG;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> bpx() {
        if (this.eUY == null) {
            this.eUY = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cNw */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(NewSubPbActivity.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cL */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cM */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cN */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.eUY;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> bpy() {
        if (this.eUZ == null) {
            this.eUZ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cNy */
                public LinearLayout makeObject() {
                    LinearLayout linearLayout = new LinearLayout(NewSubPbActivity.this.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setGravity(16);
                    linearLayout.setBaselineAligned(true);
                    linearLayout.setOrientation(1);
                    linearLayout.setLayoutParams(layoutParams);
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: d */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: e */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: f */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.eUZ;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> bpz() {
        this.eVa = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cNx */
            public RelativeLayout makeObject() {
                return new RelativeLayout(NewSubPbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public RelativeLayout activateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public RelativeLayout passivateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.eVa;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a cLE() {
        return this.kkn;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cLF() {
        return (this.kBT == null || this.kBT.cSh() == null || this.kBT.cSh().aTN() == null || this.kBT.cSh().aTN().aXI()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cLG() {
        if (this.kBT == null || this.kBT.cSh() == null || this.kBT.cSh().aTN() == null) {
            return null;
        }
        return this.kBT.cSh().aTN().aWp();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int cLH() {
        if (this.kBT == null) {
            return 0;
        }
        return this.kBT.cKM();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Kv(String str) {
        if (StringUtils.isNull(str) || this.kBT == null || this.kBT.cSh() == null || this.kBT.cSh().aTN() == null || this.kBT.cSh().aTN().aWl() == null) {
            return false;
        }
        return str.equals(this.kBT.cSh().aTN().aWl().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.kBV.cRN() && com.baidu.adp.lib.util.l.isNetOk()) {
            this.kBT.loadData();
        } else {
            this.kBV.cRQ();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String) {
            str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
        }
        if (sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String) {
            str4 = (String) sparseArray.get(R.id.tag_user_mute_thread_id);
        }
        if (!(sparseArray.get(R.id.tag_user_mute_post_id) instanceof String)) {
            str2 = "";
        } else {
            str2 = (String) sparseArray.get(R.id.tag_user_mute_post_id);
        }
        String str7 = sparseArray.get(R.id.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_msg) : str2;
        if (sparseArray.get(R.id.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(R.id.tag_user_mute_msg);
        }
        if (sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String) {
            str6 = (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.kCe);
        userMuteAddAndDelCustomMessage.setTag(this.kCe);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Le(String str) {
        if (!StringUtils.isNull(str) && bf.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aZP().getString("bubble_link", "");
            if (!StringUtils.isNull(string)) {
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                    return;
                }
                com.baidu.tbadk.browser.a.startWebActivity(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), string + "?props_id=" + str, true, true, true);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aq(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB_FLOOR;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.blm().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.kBT != null) {
            if (this.kBT.cSh() != null && this.kBT.cSh().bjG() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.kBT.cSh().bjG().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.kBT.cNL(), 0L));
            if (this.kBT.cSh() != null && this.kBT.cSh().aTN() != null) {
                pageStayDurationItem.setNid(this.kBT.cSh().aTN().getNid());
            }
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public boolean cRH() {
        if (this.kBT != null) {
            return this.kBT.cRH();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.kBV.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.koA.getPageActivity());
        if (as.isEmpty(str)) {
            aVar.xl(this.koA.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.xl(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.kBV.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.koA).aYL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zN(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.koA.getPageActivity());
        aVar.xl(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.koA).aYL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNm() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.xl(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.koA).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.koA.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.koA).aYL();
    }

    public SubPbModel cRI() {
        return this.kBT;
    }

    public int cKM() {
        if (this.kBT != null) {
            return this.kBT.cKM();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eAv && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eAv && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void pk(boolean z) {
        if (this.iFb != null && this.iFb.getText() != null) {
            int selectionEnd = this.iFb.getSelectionEnd();
            SpannableStringBuilder d = this.iFa.d(this.iFb.getText());
            if (d != null) {
                this.iFa.wj(true);
                this.iFb.setText(d);
                if (z && this.iFa.dua() >= 0) {
                    this.iFb.requestFocus();
                    this.iFb.setSelection(this.iFa.dua());
                } else {
                    this.iFb.setSelection(selectionEnd);
                }
                this.iFa.wi(this.iFa.dua() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jqF != null && this.jqF.biJ() != null && this.jqF.biJ().biL()) {
            this.jqF.biJ().bhl();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(t tVar) {
        af.a(tVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    public String cPC() {
        if (!as.isEmpty(this.kwK)) {
            return this.kwK;
        }
        this.kwK = getResources().getString(ay.cPr());
        return this.kwK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.kCh = z;
        tl(true);
    }

    private void tl(boolean z) {
        View childAt;
        Rect rect = new Rect();
        FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
        if (frameLayout != null && (childAt = frameLayout.getChildAt(0)) != null) {
            frameLayout.getWindowVisibleDisplayFrame(rect);
            if (z) {
                ((FrameLayout.LayoutParams) childAt.getLayoutParams()).height = rect.height();
                childAt.requestLayout();
            }
        }
        if (this.kBV != null && this.kBV.getListView() != null && this.kCi != null && this.kCi.mPosition != -1) {
            final int headerViewsCount = this.kCi.mPosition + this.kBV.getListView().getHeaderViewsCount();
            if (this.kCi.getView() != null) {
                final int height = this.kCi.getView().getHeight();
                final int height2 = ((rect.height() - this.kBV.cSd()) - this.kBV.getNavigationBarHeight()) - this.kBV.cSc();
                final int i = height - height2;
                if (i > 0) {
                    this.kBV.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.kBV != null && NewSubPbActivity.this.kBV.getListView() != null) {
                                NewSubPbActivity.this.kBV.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.kBV.getNavigationBarHeight() - i);
                            }
                        }
                    });
                } else {
                    this.kBV.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.kBV != null && NewSubPbActivity.this.kBV.getListView() != null) {
                                NewSubPbActivity.this.kBV.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.kBV.getNavigationBarHeight() + (height2 - height));
                            }
                        }
                    });
                }
            }
        }
    }

    private void cNp() {
        if (this.kBT != null && !as.isEmpty(this.kBT.cNL())) {
            com.baidu.tbadk.BdToken.c.aQc().p(com.baidu.tbadk.BdToken.b.dEx, com.baidu.adp.lib.f.b.toLong(this.kBT.cNL(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.kBT == null || as.isEmpty(this.kBT.cNL())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.kBT.cNL(), 0L);
    }
}
