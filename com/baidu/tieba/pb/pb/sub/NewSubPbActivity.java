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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ag;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.l;
import com.baidu.tbadk.editortools.m;
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
    private static String kRE = "tbgametype";
    private View.OnClickListener aRW;
    private bd dTW;
    private e eod;
    private com.baidu.tbadk.core.message.a eou;
    private com.baidu.adp.lib.d.b<ImageView> fcr;
    private com.baidu.adp.lib.d.b<GifView> fcs;
    private com.baidu.adp.lib.d.b<TextView> ffJ;
    private com.baidu.adp.lib.d.b<View> ffK;
    private com.baidu.adp.lib.d.b<LinearLayout> ffL;
    private com.baidu.adp.lib.d.b<RelativeLayout> ffM;
    private VoiceManager hSU;
    private com.baidu.tieba.frs.profession.permission.c hXq;
    private com.baidu.tieba.write.c iUe;
    private EditText iUf;
    public am jFD;
    private h jFJ;
    private com.baidu.tieba.pb.pb.report.a kDD;
    private com.baidu.tbadk.baseEditMark.a kDE;
    private com.baidu.adp.base.e kDY;
    private com.baidu.tbadk.core.view.c kDZ;
    private com.baidu.adp.widget.ImageView.a kEc;
    private String kEd;
    private TbRichTextMemeInfo kEe;
    private PostWriteCallBackData kFL;
    private String kMw;
    private SubPbModel kRF;
    private ForumManageModel kRG;
    private com.baidu.tieba.pb.pb.sub.a kRH;
    private ah kRI;
    private AbsListView.OnScrollListener kRJ;
    private TbRichTextView.i kRK;
    private SubPbModel.a kRL;
    private com.baidu.adp.base.d kRM;
    private BdUniqueId kRQ;
    private com.baidu.tieba.pb.e<p> kRS;
    private boolean kRT;
    private n kRU;
    private com.baidu.tieba.pb.pb.main.b.a kzM;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int kEO = 0;
    PostData iUM = null;
    private a.InterfaceC0535a kEK = null;
    private a kRN = null;
    private a kRO = null;
    private boolean mIsPaused = false;
    private boolean kRP = false;
    private boolean kRR = false;
    private boolean eKX = false;
    private com.baidu.tbadk.editortools.pb.c eMA = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void brW() {
            NewSubPbActivity.this.kRH.dcG();
        }
    };
    private int kzi = 0;
    private boolean mIsFromSchema = false;
    private BdUniqueId kRV = BdUniqueId.gen();
    private boolean kBf = com.baidu.tbadk.a.d.baf();
    private boolean kRW = true;
    private com.baidu.tbadk.editortools.pb.b eMB = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean brV() {
            if (!NewSubPbActivity.this.iUe.dFF()) {
                return (NewSubPbActivity.this.jFD == null || NewSubPbActivity.this.kRF == null || NewSubPbActivity.this.kRF.ckU() == null || NewSubPbActivity.this.jFD.aN(NewSubPbActivity.this.kRF.ckU().replyPrivateFlag, am.ekD)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.iUe.dFH());
            if (NewSubPbActivity.this.jFJ.bsn()) {
                NewSubPbActivity.this.jFJ.a(NewSubPbActivity.this.kFL);
            }
            NewSubPbActivity.this.pS(true);
            return true;
        }
    };
    private CustomMessageListener kRX = new CustomMessageListener(2921481) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && NewSubPbActivity.this.kRF != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && at.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), NewSubPbActivity.this.kRF.cYC())) {
                if (NewSubPbActivity.this.iUe != null) {
                    NewSubPbActivity.this.iUe.Sw(null);
                    NewSubPbActivity.this.iUe.bf(null);
                    NewSubPbActivity.this.iUe.wZ(false);
                }
                if (NewSubPbActivity.this.jFJ != null) {
                    NewSubPbActivity.this.jFJ.bsx();
                    NewSubPbActivity.this.jFJ.reset();
                }
                NewSubPbActivity.this.kRF.brS();
            }
        }
    };
    private NewWriteModel.d iUl = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.jFJ != null && NewSubPbActivity.this.jFJ.brw() != null) {
                NewSubPbActivity.this.jFJ.brw().hide();
                if (NewSubPbActivity.this.kRF.ddg()) {
                    TiebaStatic.log(new aq("c10367").dD("post_id", NewSubPbActivity.this.kRF.brT()));
                }
            }
            if (z) {
                NewSubPbActivity.this.iUe.Sw(null);
                NewSubPbActivity.this.iUe.bf(null);
                NewSubPbActivity.this.iUe.wZ(false);
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.iUe.bf(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.iUe.Sw(postWriteCallBackData.getErrorString());
                if (!y.isEmpty(NewSubPbActivity.this.iUe.dFD())) {
                    NewSubPbActivity.this.kFL = postWriteCallBackData;
                    if (NewSubPbActivity.this.jFJ.bsn()) {
                        NewSubPbActivity.this.jFJ.a(NewSubPbActivity.this.kFL);
                    }
                    NewSubPbActivity.this.pS(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(NewSubPbActivity.this.getActivity(), NewSubPbActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(NewSubPbActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(NewSubPbActivity.this.getActivity());
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.zA(NewSubPbActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.zA(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(NewSubPbActivity.this.getActivity(), 0, 26, 2)));
                        TiebaStatic.log(new aq("c13746").ai("obj_locate", 1).ai("obj_type", 2));
                    }
                });
                aVar.b(NewSubPbActivity.this.getPageContext()).bhg();
                TiebaStatic.log(new aq("c13745").ai("obj_locate", 1).ai("obj_type", 2));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.jFD != null) {
                NewSubPbActivity.this.jFD.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.kRH.dcH();
        }
    };
    private CustomMessageListener kEz = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.kRQ) {
                NewSubPbActivity.this.kRH.bWr();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.kDZ.showSuccessToast(NewSubPbActivity.this.kDY.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.kDY.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.Ce(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.cYb();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (at.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.kDY.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.kDZ.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener kEA = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.kRQ) {
                NewSubPbActivity.this.kRH.bWr();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.kDZ.showSuccessToast(NewSubPbActivity.this.kDY.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (at.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.kDY.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.kDZ.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener kEB = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.kRQ) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.kRH.bWr();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.mtF;
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
                    NewSubPbActivity.this.kRH.a(sparseArray, z);
                }
            }
        }
    };
    private final f.c fKP = new f.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (NewSubPbActivity.this.kRF != null) {
                NewSubPbActivity.this.kRF.dde();
            }
        }
    };
    boolean kEP = false;
    private final b.InterfaceC0538b kER = new b.InterfaceC0538b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.kEc != null && !TextUtils.isEmpty(NewSubPbActivity.this.kEd)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.kEe == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.kEd));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.kEd;
                        aVar.pkgId = NewSubPbActivity.this.kEe.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.kEe.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.dTW == null) {
                            NewSubPbActivity.this.dTW = new bd(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.dTW.j(NewSubPbActivity.this.kEd, NewSubPbActivity.this.kEc.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.kEc = null;
                NewSubPbActivity.this.kEd = null;
            }
        }
    };
    private CustomMessageListener jgP = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener hUA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof l)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    l lVar = (l) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.kRF.dcY() != null && NewSubPbActivity.this.kRF.dcY().cWi() != null && NewSubPbActivity.this.kRF.dcY().cWi().beE() != null && currentAccount.equals(NewSubPbActivity.this.kRF.dcY().cWi().beE().getUserId()) && NewSubPbActivity.this.kRF.dcY().cWi().beE().getPendantData() != null) {
                        NewSubPbActivity.this.kRF.dcY().cWi().beE().getPendantData().zj(lVar.bcA());
                        NewSubPbActivity.this.kRF.dcY().cWi().beE().getPendantData().cY(lVar.bra());
                        NewSubPbActivity.this.kRH.a(NewSubPbActivity.this.kRF.dcY(), NewSubPbActivity.this.kRF.dcY().cWi(), NewSubPbActivity.this.kRF.dcY().cHD(), NewSubPbActivity.this.kRF.dcY().baA(), NewSubPbActivity.this.kRF.cVB(), NewSubPbActivity.this.kRF.ddm() != null);
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
        aD(bundle);
        if (getIntent() != null) {
            this.mIsFromSchema = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_FROM_SCHEMA, false);
        }
        super.onCreate(bundle);
        this.kDY = getPageContext();
        this.kRP = true;
        this.iUe = new com.baidu.tieba.write.c();
        this.iUe.Js(R.color.cp_cont_h_alpha85);
        this.iUe.Jr(R.color.cp_cont_a);
        bMh();
        dcw();
        initData(bundle);
        initUI();
        ((SubPbView) this.kRH.getRootView()).show();
        ro(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.kRH.tX(this.mIsFromSchema);
        this.kDZ = new com.baidu.tbadk.core.view.c();
        this.kDZ.toastTime = 1000L;
        registerListener(this.kEB);
        registerListener(this.kEz);
        registerListener(this.kEA);
        registerListener(this.kRX);
        this.kRQ = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.kRQ;
        userMuteAddAndDelCustomMessage.setTag(this.kRQ);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.kRQ;
        userMuteCheckCustomMessage.setTag(this.kRQ);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.jFD = new am(getPageContext());
        this.jFD.a(new am.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.jFJ.bsv();
                }
            }
        });
        this.kDD = new com.baidu.tieba.pb.pb.report.a(this);
        this.kDD.x(getUniqueId());
        this.kzM = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.kRH = new com.baidu.tieba.pb.pb.sub.a(this, this.aRW);
        this.kRH.a(this.kRF);
        setContentView(this.kRH.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.kRH.setOnScrollListener(this.kRJ);
        this.kRH.b(this);
        this.kRH.setOnImageClickListener(this.kRK);
        this.kRH.setOnLongClickListener(this.mOnLongClickListener);
        this.kRH.f(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.kRF != null) {
                    NewSubPbActivity.this.kRF.loadData();
                }
            }
        });
        this.kRH.a(this.kRN);
        this.kRH.b(this.kRO);
        this.kRH.setListPullRefreshListener(this.fKP);
        if (this.kRF != null && this.kRF.dcy() && !this.kRF.ddl()) {
            this.kRH.dcM().setVisibility(8);
        } else {
            this.kRH.dcM().setVisibility(0);
        }
        if (this.kRF != null && !this.kRF.dcy()) {
            this.kRH.setIsFromPb(false);
        }
    }

    private boolean aD(Bundle bundle) {
        if (bundle != null) {
            this.eKX = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.eKX = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.eKX;
    }

    public void initData(Bundle bundle) {
        this.kRF = new SubPbModel(getPageContext());
        this.kRF.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                NewSubPbActivity.this.kRH.u(postData);
                NewSubPbActivity.this.kRH.b((BdListView.e) null);
            }
        });
        this.kRG = new ForumManageModel(getPageContext());
        this.kRG.setLoadDataCallBack(this.kRM);
        this.hSU = new VoiceManager();
        this.hSU.onCreate(getPageContext());
        this.kDE = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.kDE != null) {
            this.kDE.a(this.kEK);
        }
        if (bundle != null) {
            this.kRF.initWithBundle(bundle);
        } else {
            this.kRF.initWithIntent(getIntent());
        }
        this.kRF.a(this.kRL);
        if (this.kRF.dcy() && !this.kRF.ddr()) {
            this.kRF.loadData();
        } else {
            this.kRF.ddd();
        }
    }

    public void dcw() {
        this.kRL = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, final p pVar) {
                if (NewSubPbActivity.this.kRH != null) {
                    NewSubPbActivity.this.kRH.dcH();
                    if (!z) {
                        NewSubPbActivity.this.bt(i, str);
                        return;
                    }
                    NewSubPbActivity.this.kRH.hideNoDataView();
                    if (pVar != null) {
                        if (pVar.cWi() != null || NewSubPbActivity.this.kRF != null) {
                            pVar.cWi().a(NewSubPbActivity.this.kRF.ddk());
                        }
                        if (NewSubPbActivity.this.kRH != null) {
                            NewSubPbActivity.this.ro(pVar.bce() != null && pVar.bce().isBjh());
                            if (NewSubPbActivity.this.jFJ != null && NewSubPbActivity.this.jFJ.brw() != null) {
                                NewSubPbActivity.this.jFJ.brw().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.kRH.a(pVar, NewSubPbActivity.this.kRF.cVB(), NewSubPbActivity.this.kRF.ddm() != null, NewSubPbActivity.this.kRP);
                            if (NewSubPbActivity.this.kRP) {
                                NewSubPbActivity.this.kRH.getListView().setSelectionFromTop(NewSubPbActivity.this.kRH.getListView().getHeaderViewsCount() + 1, -com.baidu.adp.lib.util.l.getDimens(NewSubPbActivity.this, R.dimen.tbds18));
                                NewSubPbActivity.this.dcx();
                                NewSubPbActivity.this.kRP = false;
                            }
                        }
                        if (NewSubPbActivity.this.jFJ != null) {
                            NewSubPbActivity.this.jFJ.a(pVar.ckU());
                            NewSubPbActivity.this.jFJ.setThreadData(pVar.bce());
                            if (NewSubPbActivity.this.getIntent() != null && NewSubPbActivity.this.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && NewSubPbActivity.this.kRW) {
                                com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        NewSubPbActivity.this.kRW = false;
                                        NewSubPbActivity.this.c(pVar.cWi(), false);
                                    }
                                }, 200L);
                            }
                        }
                        if (NewSubPbActivity.this.kRS == null) {
                            NewSubPbActivity.this.kRS = new com.baidu.tieba.pb.e();
                        }
                        NewSubPbActivity.this.kRS.setData(pVar);
                        NewSubPbActivity.this.kRS.setType(0);
                        NewSubPbActivity.this.jFD.a(NewSubPbActivity.this.kRF.ddp());
                    }
                }
            }
        };
        this.kEK = new a.InterfaceC0535a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0535a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.kDE != null) {
                        NewSubPbActivity.this.kDE.hB(z2);
                    }
                    MarkData baD = NewSubPbActivity.this.kDE.baD();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(baD);
                        if (NewSubPbActivity.this.kDE != null) {
                            if (baD != null) {
                                NewSubPbActivity.this.kRF.tZ(true);
                                NewSubPbActivity.this.kRF.Ob(NewSubPbActivity.this.kRF.brT());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.kRH != null) {
                                NewSubPbActivity.this.kRH.tY(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.kRF.tZ(false);
                        NewSubPbActivity.this.kRF.Ob(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.kRH != null) {
                            NewSubPbActivity.this.kRH.tY(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.kRN = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.kRF.dcY() != null && NewSubPbActivity.this.kRF.dcY().bce() != null && NewSubPbActivity.this.kRF.dcY().bce().beE() != null) {
                    str = String.valueOf(NewSubPbActivity.this.kRF.dcY().bce().beE().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.kRF.dcY().bst().getId(), NewSubPbActivity.this.kRF.dcY().bst().getName(), NewSubPbActivity.this.kRF.dcY().bce().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.kRO = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.kRG.dxv() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.kRF != null && NewSubPbActivity.this.kRF.dcY() != null && NewSubPbActivity.this.kRF.dcY().bst() != null && NewSubPbActivity.this.kRF.dcY().bce() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.kRG.QP(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.kRG.a(NewSubPbActivity.this.kRF.dcY().bst().getId(), NewSubPbActivity.this.kRF.dcY().bst().getName(), NewSubPbActivity.this.kRF.dcY().bce().getId(), valueOf, i2, i, z, NewSubPbActivity.this.kRF.dcY().bce().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.kRM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.kRH.a(NewSubPbActivity.this.kRG.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.kRG.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.kSU != 1002 || bVar.ghv) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.kRH.a(1, dVar.Qf, dVar.mhO, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean cO(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void bMh() {
        registerListener(this.hUA);
        this.aRW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
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
                if (view != null || NewSubPbActivity.this.kRH != null) {
                    if (view == NewSubPbActivity.this.kRH.dcS()) {
                        NewSubPbActivity.this.kRH.dbf();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                be.bju().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.kRH.cqU()) {
                        if (view != NewSubPbActivity.this.kRH.dcL()) {
                            if (view == NewSubPbActivity.this.kRH.dcK()) {
                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                    NewSubPbActivity.this.kRH.dcA();
                                    NewSubPbActivity.this.kRH.dcB();
                                    if (NewSubPbActivity.this.jFJ != null) {
                                        NewSubPbActivity.this.jFJ.bsB();
                                    }
                                }
                            } else if (view.getId() != R.id.pb_floor_feedback) {
                                if (view == NewSubPbActivity.this.kRH.dcF()) {
                                    NewSubPbActivity.this.kRH.dbf();
                                    if (NewSubPbActivity.this.kRF.loadData()) {
                                        NewSubPbActivity.this.kRH.dcD();
                                    }
                                } else if (view == NewSubPbActivity.this.kRH.dcM() || view == NewSubPbActivity.this.kRH.dcN() || view == NewSubPbActivity.this.kRH.dcP()) {
                                    if (NewSubPbActivity.this.kRR) {
                                        NewSubPbActivity.this.kRR = false;
                                        return;
                                    }
                                    if (NewSubPbActivity.this.kRF.dcY() != null && NewSubPbActivity.this.kRF.dcY().bce() != null) {
                                        z2 = ay.a(NewSubPbActivity.this.kRF.dcY().bce().getBaijiahaoData());
                                    }
                                    if (z2) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.kRF.cYC(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.kRF.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.kRF.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.kRF.dcY() != null && NewSubPbActivity.this.kRF.dcY().bce() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.kRF.dcY().bce().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.kRF.cYC(), NewSubPbActivity.this.kRF.brT(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.kRF.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.kRF.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.kRH.dcQ() == null || view != NewSubPbActivity.this.kRH.dcQ().cZB()) {
                                    if (NewSubPbActivity.this.kRH.dcQ() == null || view != NewSubPbActivity.this.kRH.dcQ().cZE()) {
                                        if (NewSubPbActivity.this.kRH.dcQ() == null || view != NewSubPbActivity.this.kRH.dcQ().cZC()) {
                                            if (NewSubPbActivity.this.kRH.dcQ() == null || view != NewSubPbActivity.this.kRH.dcQ().cZD()) {
                                                if (NewSubPbActivity.this.kRH.dcQ() == null || view != NewSubPbActivity.this.kRH.dcQ().cZF()) {
                                                    if (view == NewSubPbActivity.this.kRH.dcJ() || view == NewSubPbActivity.this.kRH.dcP()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.jFJ.bsy()) {
                                                                NewSubPbActivity.this.jFJ.bsz();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.jFJ.Cf(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view != null && (view.getTag() instanceof n)) {
                                                        NewSubPbActivity.this.kRU = (n) view.getTag();
                                                        if (bg.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.kRR) {
                                                                NewSubPbActivity.this.kRR = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.jFD == null || NewSubPbActivity.this.kRF == null || NewSubPbActivity.this.kRF.ckU() == null || NewSubPbActivity.this.jFD.nP(NewSubPbActivity.this.kRF.ckU().replyPrivateFlag)) && (sparseArray2 = (SparseArray) view.getTag(R.id.tag_from)) != null) {
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
                                                        if (NewSubPbActivity.this.kRI == null || view != NewSubPbActivity.this.kRI.cZD()) {
                                                            if (NewSubPbActivity.this.kRI == null || view != NewSubPbActivity.this.kRI.cZB()) {
                                                                if (NewSubPbActivity.this.kRI == null || view != NewSubPbActivity.this.kRI.cZE()) {
                                                                    if (NewSubPbActivity.this.kRI == null || view != NewSubPbActivity.this.kRI.cZF()) {
                                                                        if (NewSubPbActivity.this.kRI == null || view != NewSubPbActivity.this.kRI.cZH()) {
                                                                            if (NewSubPbActivity.this.kRI == null || view != NewSubPbActivity.this.kRI.cZI()) {
                                                                                if (NewSubPbActivity.this.kRI == null || view != NewSubPbActivity.this.kRI.cZJ()) {
                                                                                    if (NewSubPbActivity.this.kRI != null && view == NewSubPbActivity.this.kRI.cZC()) {
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
                                                                                                NewSubPbActivity.this.kRH.cT(view);
                                                                                                return;
                                                                                            } else if (booleanValue2) {
                                                                                                NewSubPbActivity.this.kRH.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                                return;
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    int id = view.getId();
                                                                                    if (id == R.id.pb_item_tail_content) {
                                                                                        if (bg.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                            String string2 = com.baidu.tbadk.core.sharedPref.b.bik().getString("tail_link", "");
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
                                                                                            if (postData2.getType() != PostData.ebn && !TextUtils.isEmpty(postData2.getBimg_url()) && k.bbM().isShowImages()) {
                                                                                                NewSubPbActivity.this.NY(postData2.getId());
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
                                                                                    if (postData3.bgv() != null) {
                                                                                        NewSubPbActivity.this.d(postData3.bgv());
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.kEc != null && !TextUtils.isEmpty(NewSubPbActivity.this.kEd)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.dTW == null) {
                                                                                        NewSubPbActivity.this.dTW = new bd(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.dTW.j(NewSubPbActivity.this.kEd, NewSubPbActivity.this.kEc.getImageByte());
                                                                                    NewSubPbActivity.this.kEc = null;
                                                                                    NewSubPbActivity.this.kEd = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.kEc != null && !TextUtils.isEmpty(NewSubPbActivity.this.kEd)) {
                                                                            if (NewSubPbActivity.this.kEe == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.kEd));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.kEd;
                                                                                aVar.pkgId = NewSubPbActivity.this.kEe.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.kEe.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.kEc = null;
                                                                            NewSubPbActivity.this.kEd = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.iUM != null) {
                                                                        NewSubPbActivity.this.iUM.fF(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.iUM = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                if (sparseArray5 != null && (sparseArray5.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_id) instanceof String) && (sparseArray5.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.kRH.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.cN(view);
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
                                                                NewSubPbActivity.this.Nv((String) tag);
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
                                                            if (NewSubPbActivity.this.kRF != null) {
                                                                TiebaStatic.log(new aq("c13700").dD("tid", NewSubPbActivity.this.kRF.cYD()).dD("fid", NewSubPbActivity.this.kRF.getFromForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dD("post_id", postData.getId()).ai("obj_type", 3));
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
                                                        ((PostData) sparseArray8.get(R.id.tag_clip_board)).fF(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new aq("c11739").ai("obj_locate", 4));
                                            if (!j.isNetWorkAvailable()) {
                                                NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.kRH.dbf();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.Nv(str4);
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
                                            NewSubPbActivity.this.kRH.dbf();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.cX(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.kRH.dbf();
                                    SparseArray sparseArray10 = (SparseArray) view.getTag();
                                    if (sparseArray10 != null) {
                                        NewSubPbActivity.this.kRH.a(((Integer) sparseArray10.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray10.get(R.id.tag_del_post_id), ((Integer) sparseArray10.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new aq("c11739").ai("obj_locate", 2));
                                    NewSubPbActivity.this.kRH.dbf();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.kRF.dcY() != null) {
                                        NewSubPbActivity.this.n(NewSubPbActivity.this.kRF.dcY().cWi());
                                    }
                                }
                            } else {
                                try {
                                    sparseArray3 = (SparseArray) view.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                }
                                if (sparseArray3 != null && ((PostData) sparseArray3.get(R.id.tag_clip_board)) != null) {
                                    if (NewSubPbActivity.this.kRI == null) {
                                        NewSubPbActivity.this.kRI = new ah(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aRW);
                                        NewSubPbActivity.this.kRH.cY(NewSubPbActivity.this.kRI.getView());
                                        NewSubPbActivity.this.kRI.tk(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.kRI.Nv();
                                    if (NewSubPbActivity.this.sV(sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin()) {
                                        z2 = true;
                                    }
                                    NewSubPbActivity.this.kRI.a(sparseArray3, NewSubPbActivity.this.cVB(), z2);
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.kRH.dcA();
                            NewSubPbActivity.this.kRH.dcB();
                            if (NewSubPbActivity.this.jFJ != null) {
                                NewSubPbActivity.this.jFJ.bsA();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.cXA();
                        if (NewSubPbActivity.this.kRF != null && NewSubPbActivity.this.kRF.dcY() != null && NewSubPbActivity.this.kRF.dcY().bce() != null && NewSubPbActivity.this.kRF.dcY().bce().beE() != null) {
                            TiebaStatic.log(new aq("c13402").dD("tid", NewSubPbActivity.this.kRF.cYC()).u("fid", NewSubPbActivity.this.kRF.dcY().bce().getFid()).ai("obj_locate", 5).dD("uid", NewSubPbActivity.this.kRF.dcY().bce().beE().getUserId()));
                        }
                    }
                }
            }
        };
        this.kRJ = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.kRH.dbf();
                    if (NewSubPbActivity.this.kzi != 2 && NewSubPbActivity.this.kzi != 1) {
                        NewSubPbActivity.this.kRH.dcV();
                    }
                }
                NewSubPbActivity.this.jFJ.bsz();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.kRH.dcR();
            }
        };
        this.mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
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
                if (NewSubPbActivity.this.kRH != null && NewSubPbActivity.this.kRH.dcI()) {
                    return false;
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null && NewSubPbActivity.this.cO(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.kEc = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.kEd = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.kEc == null || TextUtils.isEmpty(NewSubPbActivity.this.kEd)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.kEe = null;
                        } else {
                            NewSubPbActivity.this.kEe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.kEc = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.kEd = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.kEe = null;
                        } else {
                            NewSubPbActivity.this.kEe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.kEc = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.kEd = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.kEe = null;
                        } else {
                            NewSubPbActivity.this.kEe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        NewSubPbActivity.this.kRH.a(NewSubPbActivity.this.kER, NewSubPbActivity.this.kEc.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.iUM = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.iUM == null || NewSubPbActivity.this.kDE == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.kDE != null) {
                            NewSubPbActivity.this.kDE.hB(NewSubPbActivity.this.kRF.ddf());
                        }
                        boolean z2 = NewSubPbActivity.this.kDE.baA() && NewSubPbActivity.this.iUM.getId() != null && NewSubPbActivity.this.iUM.getId().equals(NewSubPbActivity.this.kRF.ddh());
                        if (NewSubPbActivity.this.kRI == null) {
                            NewSubPbActivity.this.kRI = new ah(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aRW);
                            NewSubPbActivity.this.kRH.cY(NewSubPbActivity.this.kRI.getView());
                            NewSubPbActivity.this.kRI.tk(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.kRI.Nv();
                        boolean z3 = NewSubPbActivity.this.sV(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z4 = (NewSubPbActivity.this.kRF.dcY() == null || NewSubPbActivity.this.kRF.dcY().bce() == null || !NewSubPbActivity.this.kRF.dcY().bce().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z2) {
                            NewSubPbActivity.this.kRI.cZB().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.kRI.cZB().setText(R.string.mark);
                        }
                        if (booleanValue || z4) {
                            NewSubPbActivity.this.kRI.cZB().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.kRI.cZB().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.cO(view)) {
                            if (NewSubPbActivity.this.kEc != null && !NewSubPbActivity.this.kEc.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        ah ahVar = NewSubPbActivity.this.kRI;
                        int cVB = NewSubPbActivity.this.cVB();
                        if (NewSubPbActivity.this.kBf && NewSubPbActivity.this.iUM.mfZ) {
                            z = true;
                        }
                        ahVar.a(sparseArray2, cVB, z3, z);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.kRK = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
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
                        p dcY = NewSubPbActivity.this.kRF.dcY();
                        TbRichText bv = NewSubPbActivity.this.bv(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bv != null && bv.bxx() != null) {
                            tbRichTextData = bv.bxx().get(NewSubPbActivity.this.kEO);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!tbRichTextData.bxD().bxR()) {
                                String c = NewSubPbActivity.this.c(tbRichTextData);
                                arrayList.add(c);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap.put(c, imageUrlData);
                                String str5 = null;
                                String str6 = null;
                                String str7 = null;
                                if (dcY == null) {
                                    str4 = null;
                                    z4 = false;
                                } else {
                                    if (dcY.bst() != null) {
                                        str5 = dcY.bst().getName();
                                        str6 = dcY.bst().getId();
                                    }
                                    if (dcY.bce() != null) {
                                        str7 = dcY.bce().getId();
                                    }
                                    str4 = str7;
                                    z4 = true;
                                }
                                if (NewSubPbActivity.this.kRF.ddm() != null) {
                                    concurrentHashMap = NewSubPbActivity.this.kRF.ddm();
                                    z4 = NewSubPbActivity.this.kRF.ddo();
                                    arrayList = NewSubPbActivity.this.kRF.ddn();
                                }
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(y.getItem(arrayList, 0));
                                ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                                aVar.x(arrayList2).yQ(str5).yR(str6).yS(str4).hI(z4).yT(arrayList.get(0)).hJ(true).a(concurrentHashMap).hK(true).hL(false).hM(false).r(NewSubPbActivity.this.bce()).yU(String.valueOf(bv.getPostId())).yV(NewSubPbActivity.this.kRF.getFromForumId());
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar.dP(NewSubPbActivity.this.getPageContext().getPageActivity())));
                                return;
                            }
                            NewSubPbActivity.this.kEP = false;
                            TbRichText dwM = dcY.cWi().dwM();
                            int size = arrayList.size();
                            int a2 = NewSubPbActivity.this.a(dwM, bv, i, i, arrayList, concurrentHashMap);
                            int size2 = arrayList.size();
                            if (size == size2) {
                                str2 = "";
                            } else {
                                str2 = arrayList.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (dcY == null) {
                                str3 = null;
                                z3 = false;
                            } else {
                                if (dcY.bst() != null) {
                                    str8 = dcY.bst().getName();
                                    str9 = dcY.bst().getId();
                                }
                                if (dcY.bce() != null) {
                                    str10 = dcY.bce().getId();
                                }
                                str3 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.kRF.ddm() != null) {
                                concurrentHashMap = NewSubPbActivity.this.kRF.ddm();
                                z3 = NewSubPbActivity.this.kRF.ddo();
                                arrayList = NewSubPbActivity.this.kRF.ddn();
                                a2 += NewSubPbActivity.this.kRF.getOffset();
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(y.getItem(arrayList, a2));
                            ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                            aVar2.x(arrayList3).yQ(str8).yR(str9).yS(str3).hI(z3).yT(str2).hJ(true).a(concurrentHashMap).hK(true).hL(false).hM(false).r(NewSubPbActivity.this.bce()).yU(String.valueOf(bv.getPostId())).yV(NewSubPbActivity.this.kRF.getFromForumId());
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar2.dP(NewSubPbActivity.this.getPageContext().getPageActivity())));
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
    public bw bce() {
        if (this.kRF == null || this.kRF.dcY() == null) {
            return null;
        }
        return this.kRF.dcY().bce();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(View view) {
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
            if (postData.beE() != null) {
                MetaData beE = postData.beE();
                this.jFJ.setReplyId(beE.getUserId());
                boolean z2 = postData.mfZ;
                String str = "";
                if (postData.dwM() != null) {
                    str = postData.dwM().toString();
                }
                this.jFJ.Ch(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.beE().getName_show(), str));
                if (z2) {
                    if (!z) {
                        this.jFJ.Cg("");
                    }
                } else if (!z) {
                    this.jFJ.Cg(beE.getName_show());
                }
            }
            this.kRH.dcB();
        }
        if (this.kRT) {
            tW(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eou == null) {
                this.eou = new com.baidu.tbadk.core.message.a();
            }
            if (this.eod == null) {
                this.eod = new e();
                this.eod.uniqueId = this.kRV;
            }
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dWO = 12;
            cVar.dWU = 9;
            cVar.dWT = 3;
            if (dcz() != null) {
                cVar.dWS = dcz().ddq();
            }
            if (cVar != null) {
                cVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (cVar != null) {
                        cVar.dWV = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (cVar != null) {
                        cVar.dWV = 1;
                        i = 0;
                    }
                }
                this.eou.a(agreeData, i, getUniqueId(), false);
                this.eou.a(agreeData, this.eod);
                if (dcz() == null && dcz().dcY() != null) {
                    this.eou.a(this, cVar, agreeData, dcz().dcY().bce());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (cVar != null) {
                cVar.dWV = 1;
            }
            i = 0;
            this.eou.a(agreeData, i, getUniqueId(), false);
            this.eou.a(agreeData, this.eod);
            if (dcz() == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bxD;
        if (tbRichText == tbRichText2) {
            this.kEP = true;
        }
        if (tbRichText != null && tbRichText.bxx() != null) {
            int size = tbRichText.bxx().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.bxx().get(i6) != null && tbRichText.bxx().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.bxx().get(i6).bxD().getWidth() * equipmentDensity;
                    int height = tbRichText.bxx().get(i6).bxD().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.bxx().get(i6).bxD().bxR()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.bxx().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (bxD = tbRichTextData.bxD()) != null) {
                            String bxT = bxD.bxT();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = bxT;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.kEP) {
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
        if (this.kRI != null) {
            this.kRI.tk(z);
        }
        if (this.kRH != null) {
            this.kRH.tk(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bxD = tbRichTextData.bxD();
        if (bxD != null) {
            if (!StringUtils.isNull(bxD.bxQ())) {
                return bxD.bxQ();
            }
            if (bxD.getHeight() * bxD.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bxD.getHeight() * bxD.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bxD.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bxD.getHeight())));
            } else {
                float width = bxD.getWidth() / bxD.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(at.getUrlEncode(bxD.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bv(String str, int i) {
        if (this.kRF == null || this.kRF.dcY() == null || str == null || i < 0) {
            return null;
        }
        p dcY = this.kRF.dcY();
        TbRichText a2 = a(dcY.cWi(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(dcY.cWi(), str, i);
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
        TbRichText dwM = postData.dwM();
        if (dwM != null) {
            ArrayList<TbRichTextData> bxx = dwM.bxx();
            int size = bxx.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (bxx.get(i3) != null && bxx.get(i3).getType() == 8) {
                    i2++;
                    if (bxx.get(i3).bxD().bxT().equals(str)) {
                        int equipmentDensity = (int) com.baidu.adp.lib.util.l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = bxx.get(i3).bxD().getWidth() * equipmentDensity;
                        int height = bxx.get(i3).bxD().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.kEO = i3;
                        return dwM;
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
    public void cXA() {
        Intent intent = getIntent();
        if (intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false) {
            if (this.jFD == null || this.kRF == null || this.kRF.ckU() == null || this.jFD.nP(this.kRF.ckU().replyPrivateFlag)) {
                if (this.jFJ.bsn()) {
                    this.jFJ.a((PostWriteCallBackData) null);
                    return;
                }
                this.kRH.dcA();
                this.kRH.dcB();
                if (this.jFJ != null) {
                    this.jFJ.bsC();
                    return;
                }
                return;
            }
            return;
        }
        if (this.hXq == null) {
            this.hXq = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.hXq.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void ow(boolean z) {
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
                public void ox(boolean z) {
                    String str;
                    if (z) {
                        if (NewSubPbActivity.this.jFD == null || NewSubPbActivity.this.kRF == null || NewSubPbActivity.this.kRF.ckU() == null || NewSubPbActivity.this.jFD.nP(NewSubPbActivity.this.kRF.ckU().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.kRF != null && NewSubPbActivity.this.kRF.dcY() != null && NewSubPbActivity.this.kRF.dcY().cWi() != null) {
                                PostData cWi = NewSubPbActivity.this.kRF.dcY().cWi();
                                if (cWi.dwM() != null && cWi.beE() != null) {
                                    str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), cWi.beE().getName_show(), cWi.dwM().toString());
                                    NewSubPbActivity.this.jFJ.brw().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                                    if (!NewSubPbActivity.this.jFJ.bsn()) {
                                        NewSubPbActivity.this.jFJ.a((PostWriteCallBackData) null);
                                        return;
                                    }
                                    NewSubPbActivity.this.kRH.dcA();
                                    NewSubPbActivity.this.kRH.dcB();
                                    if (NewSubPbActivity.this.jFJ != null) {
                                        NewSubPbActivity.this.jFJ.bsC();
                                        return;
                                    }
                                    return;
                                }
                            }
                            str = null;
                            NewSubPbActivity.this.jFJ.brw().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                            if (!NewSubPbActivity.this.jFJ.bsn()) {
                            }
                        }
                    }
                }
            });
        }
        if (this.kRF != null && this.kRF.dcY() != null && this.kRF.dcY().bst() != null) {
            this.hXq.C(this.kRF.dcY().bst().getId(), com.baidu.adp.lib.f.b.toLong(this.kRF.cYC(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sV(boolean z) {
        if (this.kRF == null) {
            return false;
        }
        return ((cVB() != 0) || this.kRF.dcY() == null || this.kRF.dcY().bce() == null || this.kRF.dcY().bce().beE() == null || this.kRF.dcY().bce().bdo() || TextUtils.equals(this.kRF.dcY().bce().beE().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt(int i, String str) {
        if (this.kRF.dcZ()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.l.isNetOk()) {
            if (i == 4) {
                this.kRH.GT(str + "(4)");
            } else {
                this.kRH.Bd(R.string.no_data_text);
            }
        } else {
            this.kRH.Bd(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ro(boolean z) {
        this.jFJ = (h) new com.baidu.tbadk.editortools.pb.i(z).ec(getActivity());
        if (this.jFJ != null) {
            this.jFJ.a(getPageContext());
            this.jFJ.b(this.kRF);
            this.jFJ.b(this.iUl);
            this.jFJ.a(this.eMA);
            this.jFJ.a(this.eMB);
            this.jFJ.brw().jj(true);
            this.jFJ.j(getPageContext());
        }
        if (this.kRH != null) {
            this.kRH.i(this.jFJ);
        }
        if (this.jFJ != null && this.kRF != null) {
            this.jFJ.a(this.kRF.ckU());
            this.jFJ.bsz();
        }
        if (this.jFJ != null) {
            this.jFJ.bsD().setDefaultHint(dat());
            this.jFJ.bsD().setHint(dat());
            this.iUf = this.jFJ.bsD().getInputView();
            this.iUf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.iUe != null) {
                        if (!NewSubPbActivity.this.iUe.dFG()) {
                            NewSubPbActivity.this.pS(false);
                        }
                        NewSubPbActivity.this.iUe.xa(false);
                    }
                }
            });
        }
    }

    public void dcx() {
        if (!TbadkCoreApplication.isLogin()) {
            this.jFJ.bsz();
        } else if (!StringUtils.isNull(this.kRF.ddi())) {
            if (this.kRH.dcE() && com.baidu.adp.lib.util.l.isNetOk()) {
                this.kRH.ciS();
            } else {
                this.kRH.dcH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cX(View view) {
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
                    this.kRH.cT(view);
                }
            } else if (booleanValue2) {
                this.kRH.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.kRH.dcO(), getPageContext().getPageActivity());
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
            bVar.nx(R.string.operation);
            bVar.a(strArr, new b.InterfaceC0538b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.kRQ);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.kRQ);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).bhi();
        }
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.kRH.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.kRQ;
        userMuteCheckCustomMessage.setTag(this.kRQ);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.kRH.a(0, bVar.Qf, bVar.mhO, z);
            if (bVar.Qf) {
                if (bVar.hzM == 1) {
                    if (this.kRH.getListView() instanceof BdTypeListView) {
                        List<q> data = ((BdTypeListView) this.kRH.getListView()).getData();
                        if (!y.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.kRH.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.hzM == 2) {
                    this.kRF.Oa(bVar.mPostId);
                    this.kRH.a(this.kRF.dcY(), this.kRF.cVB(), this.kRF.ddm() != null, false);
                    if (this.kRF.ddj()) {
                        this.kRF.ua(false);
                        this.kRH.dcC();
                        this.kRF.loadData();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void Nv(String str) {
        if (this.kRF != null && this.kRF.dcY() != null && this.kRF.dcY().bce() != null && this.kRF.dcY().bce().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.kRF.cYC(), str);
            bw bce = this.kRF.dcY().bce();
            if (bce.bdm()) {
                format = format + "&channelid=33833";
            } else if (bce.bgy()) {
                format = format + "&channelid=33842";
            } else if (bce.bdn()) {
                format = format + "&channelid=33840";
            }
            Nw(format);
            return;
        }
        this.kDD.NW(str);
    }

    private void Nw(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void n(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.kRF.ddf() && postData.getId() != null && postData.getId().equals(this.kRF.ddh())) {
                z = true;
            }
            MarkData o = this.kRF.o(postData);
            if (o != null) {
                this.kRH.dbf();
                if (this.kDE != null) {
                    this.kDE.a(o);
                    if (!z) {
                        this.kDE.baC();
                    } else {
                        this.kDE.baB();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.kRF != null) {
            this.kRF.aC(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.jFJ != null) {
            this.jFJ.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.jFJ.brw().bpY();
        this.jFJ.bsz();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.jFJ.b(writeData);
                this.jFJ.setVoiceModel(pbEditorData.getVoiceModel());
                m qe = this.jFJ.brw().qe(6);
                if (qe != null && qe.eKB != null) {
                    qe.eKB.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.jFJ.bsv();
                }
                this.kRH.dcV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hSU != null) {
            this.hSU.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.mIsPaused = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.aYs().aYC();
        if (this.hSU != null) {
            this.hSU.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.jgP);
        this.kRH.cte();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.mIsPaused = false;
        super.onResume();
        cYf();
        if (this.hSU != null) {
            this.hSU.onResume(getPageContext());
        }
        registerListener(this.jgP);
        this.kRH.ctf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hSU != null) {
            this.hSU.onStop(getPageContext());
        }
        this.jFJ.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.kRS));
        this.kRF.cancelLoadData();
        this.kRF.destory();
        this.kRG.cancelLoadData();
        if (this.hSU != null) {
            this.hSU.onDestory(getPageContext());
        }
        this.kRH.dbf();
        this.kRH.crr();
        MessageManager.getInstance().unRegisterListener(this.kEz);
        MessageManager.getInstance().unRegisterListener(this.kEA);
        MessageManager.getInstance().unRegisterListener(this.kEB);
        MessageManager.getInstance().unRegisterListener(this.kRQ);
        this.kDY = null;
        this.kDZ = null;
        if (this.jFD != null) {
            this.jFD.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kRH.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hSU;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View dcJ = this.kRH.dcJ();
        if (dcJ == null || (findViewWithTag = dcJ.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean NO(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = be.getParamPair(be.getParamStr(str))) != null) {
            this.kRR = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return NO(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(kRE);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (NO(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.k kVar = new com.baidu.tbadk.data.k();
                    kVar.mLink = str;
                    kVar.type = 3;
                    kVar.eJF = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, kVar));
                }
            } else {
                be.bju().b(getPageContext(), new String[]{str});
            }
            this.kRR = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aq(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.kRR = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ar(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void as(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void at(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void r(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView getListView() {
        if (this.kRH != null) {
            return this.kRH.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int byi() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> byk() {
        if (this.ffJ == null) {
            this.ffJ = TbRichTextView.y(getPageContext().getPageActivity(), 8);
        }
        return this.ffJ;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> byl() {
        if (this.fcs == null) {
            this.fcs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cgz */
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
        return this.fcs;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> byj() {
        if (this.fcr == null) {
            this.fcr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: byv */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = k.bbM().isShowImages();
                    foreDrawableImageView.setDefaultBg(ap.getDrawable(R.color.common_color_10220));
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
                        if (k.bbM().isShowImages()) {
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
        return this.fcr;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> bym() {
        if (this.ffK == null) {
            this.ffK = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cYm */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(NewSubPbActivity.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cP */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cQ */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cR */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.ffK;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> byn() {
        if (this.ffL == null) {
            this.ffL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cYo */
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
        return this.ffL;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> byo() {
        this.ffM = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cYn */
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
        return this.ffM;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a cWt() {
        return this.kzM;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cWu() {
        return (this.kRF == null || this.kRF.dcY() == null || this.kRF.dcY().bce() == null || this.kRF.dcY().bce().bgb()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cWv() {
        if (this.kRF == null || this.kRF.dcY() == null || this.kRF.dcY().bce() == null) {
            return null;
        }
        return this.kRF.dcY().bce().beI();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int cWw() {
        if (this.kRF == null) {
            return 0;
        }
        return this.kRF.cVB();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Np(String str) {
        if (StringUtils.isNull(str) || this.kRF == null || this.kRF.dcY() == null || this.kRF.dcY().bce() == null || this.kRF.dcY().bce().beE() == null) {
            return false;
        }
        return str.equals(this.kRF.dcY().bce().beE().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.kRH.dcE() && com.baidu.adp.lib.util.l.isNetOk()) {
            this.kRF.loadData();
        } else {
            this.kRH.dcH();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.kRQ);
        userMuteAddAndDelCustomMessage.setTag(this.kRQ);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NY(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bik().getString("bubble_link", "");
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
    public void au(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB_FLOOR;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.bua().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.kRF != null) {
            if (this.kRF.dcY() != null && this.kRF.dcY().bst() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.kRF.dcY().bst().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.kRF.cYC(), 0L));
            if (this.kRF.dcY() != null && this.kRF.dcY().bce() != null) {
                pageStayDurationItem.setNid(this.kRF.dcY().bce().getNid());
            }
            pageStayDurationItem.setPid(com.baidu.adp.lib.f.b.toLong(this.kRF.brT(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public boolean dcy() {
        if (this.kRF != null) {
            return this.kRF.dcy();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.kRH.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kDY.getPageActivity());
        if (at.isEmpty(str)) {
            aVar.zA(this.kDY.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.zA(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.kRH.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.kDY).bhg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ce(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kDY.getPageActivity());
        aVar.zA(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.kDY).bhg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYb() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.zA(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.kDY).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.kDY.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.kDY).bhg();
    }

    public SubPbModel dcz() {
        return this.kRF;
    }

    public int cVB() {
        if (this.kRF != null) {
            return this.kRF.cVB();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eKX && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eKX && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void pS(boolean z) {
        if (this.iUf != null && this.iUf.getText() != null) {
            int selectionEnd = this.iUf.getSelectionEnd();
            SpannableStringBuilder c = this.iUe.c(this.iUf.getText());
            if (c != null) {
                this.iUe.xa(true);
                this.iUf.setText(c);
                if (z && this.iUe.dFE() >= 0) {
                    this.iUf.requestFocus();
                    this.iUf.setSelection(this.iUe.dFE());
                } else {
                    this.iUf.setSelection(selectionEnd);
                }
                this.iUe.wZ(this.iUe.dFE() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jFJ != null && this.jFJ.brw() != null && this.jFJ.brw().bry()) {
            this.jFJ.brw().bpY();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(t tVar) {
        com.baidu.tbadk.core.util.ag.a(tVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    public String dat() {
        if (!at.isEmpty(this.kMw)) {
            return this.kMw;
        }
        this.kMw = getResources().getString(com.baidu.tieba.pb.pb.main.ay.dai());
        return this.kMw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.kRT = z;
        tW(true);
    }

    private void tW(boolean z) {
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
        if (this.kRH != null && this.kRH.getListView() != null && this.kRU != null && this.kRU.mPosition != -1) {
            final int headerViewsCount = this.kRU.mPosition + this.kRH.getListView().getHeaderViewsCount();
            if (this.kRU.getView() != null) {
                final int height = this.kRU.getView().getHeight();
                final int height2 = ((rect.height() - this.kRH.dcU()) - this.kRH.getNavigationBarHeight()) - this.kRH.dcT();
                final int i = height - height2;
                if (i > 0) {
                    this.kRH.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.kRH != null && NewSubPbActivity.this.kRH.getListView() != null) {
                                NewSubPbActivity.this.kRH.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.kRH.getNavigationBarHeight() - i);
                            }
                        }
                    });
                } else {
                    this.kRH.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.kRH != null && NewSubPbActivity.this.kRH.getListView() != null) {
                                NewSubPbActivity.this.kRH.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.kRH.getNavigationBarHeight() + (height2 - height));
                            }
                        }
                    });
                }
            }
        }
    }

    private void cYf() {
        if (this.kRF != null && !at.isEmpty(this.kRF.cYC())) {
            com.baidu.tbadk.BdToken.c.aYs().p(com.baidu.tbadk.BdToken.b.dNJ, com.baidu.adp.lib.f.b.toLong(this.kRF.cYC(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.kRF == null || at.isEmpty(this.kRF.cYC())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.kRF.cYC(), 0L);
    }
}
