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
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.core.util.ag;
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
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.m;
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
/* loaded from: classes22.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, i, com.baidu.tieba.pb.pb.a<NewSubPbActivity> {
    private static String lBY = "tbgametype";
    private View.OnClickListener aYF;
    private e eLc;
    private com.baidu.tbadk.core.message.a eLs;
    private bd eqG;
    private com.baidu.adp.lib.d.b<TextView> fDm;
    private com.baidu.adp.lib.d.b<View> fDn;
    private com.baidu.adp.lib.d.b<LinearLayout> fDo;
    private com.baidu.adp.lib.d.b<RelativeLayout> fDp;
    private com.baidu.adp.lib.d.b<ImageView> fzV;
    private com.baidu.adp.lib.d.b<GifView> fzW;
    private VoiceManager iBr;
    private com.baidu.tieba.frs.profession.permission.c iFN;
    private com.baidu.tieba.write.c jEj;
    private EditText jEk;
    public am kpC;
    private h kpI;
    private SubPbModel lBZ;
    private ForumManageModel lCa;
    private com.baidu.tieba.pb.pb.sub.a lCb;
    private ah lCc;
    private AbsListView.OnScrollListener lCd;
    private TbRichTextView.i lCe;
    private SubPbModel.a lCf;
    private com.baidu.adp.base.d lCg;
    private BdUniqueId lCk;
    private com.baidu.tieba.pb.e<p> lCm;
    private boolean lCn;
    private n lCo;
    private com.baidu.tieba.pb.pb.main.b.a ljT;
    private com.baidu.tieba.pb.pb.report.a lnN;
    private com.baidu.tbadk.baseEditMark.a lnO;
    private com.baidu.adp.base.e lok;
    private com.baidu.tbadk.core.view.c lol;
    private com.baidu.adp.widget.ImageView.a lop;
    private String loq;
    private TbRichTextMemeInfo lor;
    private PostWriteCallBackData lpZ;
    private String lwM;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int lpc = 0;
    PostData jER = null;
    private a.InterfaceC0561a loY = null;
    private a lCh = null;
    private a lCi = null;
    private boolean mIsPaused = false;
    private boolean lCj = false;
    private boolean lCl = false;
    private boolean fhR = false;
    private com.baidu.tbadk.editortools.pb.c fjX = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bxD() {
            NewSubPbActivity.this.lCb.dna();
        }
    };
    private int ljp = 0;
    private boolean mIsFromSchema = false;
    private BdUniqueId lCp = BdUniqueId.gen();
    private boolean llm = com.baidu.tbadk.a.d.bfv();
    private boolean lCq = true;
    private com.baidu.tbadk.editortools.pb.b fjY = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bxC() {
            if (!NewSubPbActivity.this.jEj.dQt()) {
                return (NewSubPbActivity.this.kpC == null || NewSubPbActivity.this.lBZ == null || NewSubPbActivity.this.lBZ.cuM() == null || NewSubPbActivity.this.kpC.aN(NewSubPbActivity.this.lBZ.cuM().replyPrivateFlag, am.eHy)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.jEj.dQv());
            if (NewSubPbActivity.this.kpI.bxU()) {
                NewSubPbActivity.this.kpI.a(NewSubPbActivity.this.lpZ);
            }
            NewSubPbActivity.this.qY(true);
            return true;
        }
    };
    private CustomMessageListener lCr = new CustomMessageListener(2921481) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && NewSubPbActivity.this.lBZ != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && at.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), NewSubPbActivity.this.lBZ.diV())) {
                if (NewSubPbActivity.this.jEj != null) {
                    NewSubPbActivity.this.jEj.Uj(null);
                    NewSubPbActivity.this.jEj.bk(null);
                    NewSubPbActivity.this.jEj.yg(false);
                }
                if (NewSubPbActivity.this.kpI != null) {
                    NewSubPbActivity.this.kpI.bye();
                    NewSubPbActivity.this.kpI.reset();
                }
                NewSubPbActivity.this.lBZ.bxz();
            }
        }
    };
    private NewWriteModel.d jEq = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.kpI != null && NewSubPbActivity.this.kpI.bwY() != null) {
                NewSubPbActivity.this.kpI.bwY().hide();
                if (NewSubPbActivity.this.lBZ.dnB()) {
                    TiebaStatic.log(new aq("c10367").dR("post_id", NewSubPbActivity.this.lBZ.bxA()));
                }
            }
            if (z) {
                NewSubPbActivity.this.jEj.Uj(null);
                NewSubPbActivity.this.jEj.bk(null);
                NewSubPbActivity.this.jEj.yg(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(NewSubPbActivity.this.getPageContext(), postWriteCallBackData);
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.jEj.bk(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.jEj.Uj(postWriteCallBackData.getErrorString());
                if (!y.isEmpty(NewSubPbActivity.this.jEj.dQr())) {
                    NewSubPbActivity.this.lpZ = postWriteCallBackData;
                    if (NewSubPbActivity.this.kpI.bxU()) {
                        NewSubPbActivity.this.kpI.a(NewSubPbActivity.this.lpZ);
                    }
                    NewSubPbActivity.this.qY(true);
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
                    aVar.Ba(NewSubPbActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Ba(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new aq("c13746").aj("obj_locate", 1).aj("obj_type", 2));
                    }
                });
                aVar.b(NewSubPbActivity.this.getPageContext()).bmC();
                TiebaStatic.log(new aq("c13745").aj("obj_locate", 1).aj("obj_type", 2));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.kpC != null) {
                NewSubPbActivity.this.kpC.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.lCb.dnb();
        }
    };
    private CustomMessageListener loN = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.lCk) {
                NewSubPbActivity.this.lCb.ceD();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.lol.showSuccessToast(NewSubPbActivity.this.lok.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.lok.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.DF(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.diu();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (at.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.lok.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.lol.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener loO = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.lCk) {
                NewSubPbActivity.this.lCb.ceD();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.lol.showSuccessToast(NewSubPbActivity.this.lok.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (at.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.lok.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.lol.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener loP = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.lCk) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.lCb.ceD();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.nfE;
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
                    NewSubPbActivity.this.lCb.a(sparseArray, z);
                }
            }
        }
    };
    private final f.c gkz = new f.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (NewSubPbActivity.this.lBZ != null) {
                NewSubPbActivity.this.lBZ.dnz();
            }
        }
    };
    boolean lpd = false;
    private final b.InterfaceC0564b lpf = new b.InterfaceC0564b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0564b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.lop != null && !TextUtils.isEmpty(NewSubPbActivity.this.loq)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.lor == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.loq));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.loq;
                        aVar.pkgId = NewSubPbActivity.this.lor.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.lor.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.eqG == null) {
                            NewSubPbActivity.this.eqG = new bd(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.eqG.j(NewSubPbActivity.this.loq, NewSubPbActivity.this.lop.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.lop = null;
                NewSubPbActivity.this.loq = null;
            }
        }
    };
    private CustomMessageListener jQR = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener iCX = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    m mVar = (m) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.lBZ.dnt() != null && NewSubPbActivity.this.lBZ.dnt().dgy() != null && NewSubPbActivity.this.lBZ.dnt().dgy().bka() != null && currentAccount.equals(NewSubPbActivity.this.lBZ.dnt().dgy().bka().getUserId()) && NewSubPbActivity.this.lBZ.dnt().dgy().bka().getPendantData() != null) {
                        NewSubPbActivity.this.lBZ.dnt().dgy().bka().getPendantData().AJ(mVar.bhW());
                        NewSubPbActivity.this.lBZ.dnt().dgy().bka().getPendantData().dj(mVar.bwx());
                        NewSubPbActivity.this.lCb.a(NewSubPbActivity.this.lBZ.dnt(), NewSubPbActivity.this.lBZ.dnt().dgy(), NewSubPbActivity.this.lBZ.dnt().TQ(), NewSubPbActivity.this.lBZ.dnt().bfV(), NewSubPbActivity.this.lBZ.dfX(), NewSubPbActivity.this.lBZ.dnH() != null);
                    }
                }
            }
        }
    };

    /* loaded from: classes22.dex */
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
        this.lok = getPageContext();
        this.lCj = true;
        this.jEj = new com.baidu.tieba.write.c();
        this.jEj.KU(R.color.cp_cont_h_alpha85);
        this.jEj.KT(R.color.cp_cont_a);
        bTF();
        dmQ();
        initData(bundle);
        initUI();
        ((SubPbView) this.lCb.getRootView()).show();
        su(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lCb.vd(this.mIsFromSchema);
        this.lol = new com.baidu.tbadk.core.view.c();
        this.lol.toastTime = 1000L;
        registerListener(this.loP);
        registerListener(this.loN);
        registerListener(this.loO);
        registerListener(this.lCr);
        this.lCk = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.lCk;
        userMuteAddAndDelCustomMessage.setTag(this.lCk);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.lCk;
        userMuteCheckCustomMessage.setTag(this.lCk);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.kpC = new am(getPageContext());
        this.kpC.a(new am.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.kpI.byc();
                }
            }
        });
        this.lnN = new com.baidu.tieba.pb.pb.report.a(this);
        this.lnN.w(getUniqueId());
        this.ljT = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.lCb = new com.baidu.tieba.pb.pb.sub.a(this, this.aYF);
        this.lCb.a(this.lBZ);
        setContentView(this.lCb.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.lCb.setOnScrollListener(this.lCd);
        this.lCb.b(this);
        this.lCb.setOnImageClickListener(this.lCe);
        this.lCb.setOnLongClickListener(this.mOnLongClickListener);
        this.lCb.f(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.lBZ != null) {
                    NewSubPbActivity.this.lBZ.loadData();
                }
            }
        });
        this.lCb.a(this.lCh);
        this.lCb.b(this.lCi);
        this.lCb.setListPullRefreshListener(this.gkz);
        if (this.lBZ != null && this.lBZ.dmS() && !this.lBZ.dnG()) {
            this.lCb.dng().setVisibility(8);
        } else {
            this.lCb.dng().setVisibility(0);
        }
        if (this.lBZ != null && !this.lBZ.dmS()) {
            this.lCb.setIsFromPb(false);
        }
    }

    private boolean aD(Bundle bundle) {
        if (bundle != null) {
            this.fhR = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.fhR = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.fhR;
    }

    public void initData(Bundle bundle) {
        this.lBZ = new SubPbModel(getPageContext());
        this.lBZ.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                NewSubPbActivity.this.lCb.u(postData);
                NewSubPbActivity.this.lCb.b((BdListView.e) null);
            }
        });
        this.lCa = new ForumManageModel(getPageContext());
        this.lCa.setLoadDataCallBack(this.lCg);
        this.iBr = new VoiceManager();
        this.iBr.onCreate(getPageContext());
        this.lnO = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.lnO != null) {
            this.lnO.a(this.loY);
        }
        if (bundle != null) {
            this.lBZ.initWithBundle(bundle);
        } else {
            this.lBZ.initWithIntent(getIntent());
        }
        this.lBZ.a(this.lCf);
        if (this.lBZ.dmS() && !this.lBZ.dnM()) {
            this.lBZ.loadData();
        } else {
            this.lBZ.dny();
        }
    }

    public void dmQ() {
        this.lCf = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, final p pVar) {
                if (NewSubPbActivity.this.lCb != null) {
                    NewSubPbActivity.this.lCb.dnb();
                    if (!z) {
                        NewSubPbActivity.this.bI(i, str);
                        return;
                    }
                    NewSubPbActivity.this.lCb.hideNoDataView();
                    if (pVar != null) {
                        if (pVar.dgy() != null || NewSubPbActivity.this.lBZ != null) {
                            pVar.dgy().a(NewSubPbActivity.this.lBZ.dnF());
                        }
                        if (NewSubPbActivity.this.lCb != null) {
                            NewSubPbActivity.this.su(pVar.bhz() != null && pVar.bhz().isBjh());
                            if (NewSubPbActivity.this.kpI != null && NewSubPbActivity.this.kpI.bwY() != null) {
                                NewSubPbActivity.this.kpI.bwY().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.lCb.a(pVar, NewSubPbActivity.this.lBZ.dfX(), NewSubPbActivity.this.lBZ.dnH() != null, NewSubPbActivity.this.lCj);
                            if (NewSubPbActivity.this.lCj) {
                                NewSubPbActivity.this.lCb.getListView().setSelectionFromTop(NewSubPbActivity.this.lCb.getListView().getHeaderViewsCount() + 1, -l.getDimens(NewSubPbActivity.this, R.dimen.tbds18));
                                NewSubPbActivity.this.dmR();
                                NewSubPbActivity.this.lCj = false;
                            }
                        }
                        if (NewSubPbActivity.this.kpI != null) {
                            NewSubPbActivity.this.kpI.a(pVar.cuM());
                            NewSubPbActivity.this.kpI.setThreadData(pVar.bhz());
                            if (NewSubPbActivity.this.getIntent() != null && NewSubPbActivity.this.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && NewSubPbActivity.this.lCq) {
                                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        NewSubPbActivity.this.lCq = false;
                                        NewSubPbActivity.this.c(pVar.dgy(), false);
                                    }
                                }, 200L);
                            }
                        }
                        if (NewSubPbActivity.this.lCm == null) {
                            NewSubPbActivity.this.lCm = new com.baidu.tieba.pb.e();
                        }
                        NewSubPbActivity.this.lCm.setData(pVar);
                        NewSubPbActivity.this.lCm.setType(0);
                        NewSubPbActivity.this.kpC.a(NewSubPbActivity.this.lBZ.dnK());
                    }
                }
            }
        };
        this.loY = new a.InterfaceC0561a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0561a
            public void d(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.lnO != null) {
                        NewSubPbActivity.this.lnO.ih(z2);
                    }
                    MarkData bfY = NewSubPbActivity.this.lnO.bfY();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(bfY);
                        if (NewSubPbActivity.this.lnO != null) {
                            if (bfY != null) {
                                NewSubPbActivity.this.lBZ.vf(true);
                                NewSubPbActivity.this.lBZ.PP(NewSubPbActivity.this.lBZ.bxA());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.lCb != null) {
                                NewSubPbActivity.this.lCb.ve(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.lBZ.vf(false);
                        NewSubPbActivity.this.lBZ.PP(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.lCb != null) {
                            NewSubPbActivity.this.lCb.ve(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.lCh = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.lBZ.dnt() != null && NewSubPbActivity.this.lBZ.dnt().bhz() != null && NewSubPbActivity.this.lBZ.dnt().bhz().bka() != null) {
                    str = String.valueOf(NewSubPbActivity.this.lBZ.dnt().bhz().bka().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.lBZ.dnt().bya().getId(), NewSubPbActivity.this.lBZ.dnt().bya().getName(), NewSubPbActivity.this.lBZ.dnt().bhz().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.lCi = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.lCa.dIi() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.lBZ != null && NewSubPbActivity.this.lBZ.dnt() != null && NewSubPbActivity.this.lBZ.dnt().bya() != null && NewSubPbActivity.this.lBZ.dnt().bhz() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.lCa.SC(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.lCa.a(NewSubPbActivity.this.lBZ.dnt().bya().getId(), NewSubPbActivity.this.lBZ.dnt().bya().getName(), NewSubPbActivity.this.lBZ.dnt().bhz().getId(), valueOf, i2, i, z, NewSubPbActivity.this.lBZ.dnt().bhz().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.lCg = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.lCb.a(NewSubPbActivity.this.lCa.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.lCa.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.lDo != 1002 || bVar.gKL) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.lCb.a(1, dVar.QP, dVar.mTG, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean df(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void bTF() {
        registerListener(this.iCX);
        this.aYF = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
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
                if (view != null || NewSubPbActivity.this.lCb != null) {
                    if (view == NewSubPbActivity.this.lCb.dnm()) {
                        NewSubPbActivity.this.lCb.dly();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                be.boR().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.lCb.cAL()) {
                        if (view != NewSubPbActivity.this.lCb.dnf()) {
                            if (view == NewSubPbActivity.this.lCb.dne()) {
                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                    NewSubPbActivity.this.lCb.dmU();
                                    NewSubPbActivity.this.lCb.dmV();
                                    if (NewSubPbActivity.this.kpI != null) {
                                        NewSubPbActivity.this.kpI.byi();
                                    }
                                }
                            } else if (view.getId() != R.id.pb_floor_feedback) {
                                if (view == NewSubPbActivity.this.lCb.dmZ()) {
                                    NewSubPbActivity.this.lCb.dly();
                                    if (NewSubPbActivity.this.lBZ.loadData()) {
                                        NewSubPbActivity.this.lCb.dmX();
                                    }
                                } else if (view == NewSubPbActivity.this.lCb.dng() || view == NewSubPbActivity.this.lCb.dnh() || view == NewSubPbActivity.this.lCb.dnj()) {
                                    if (NewSubPbActivity.this.lCl) {
                                        NewSubPbActivity.this.lCl = false;
                                        return;
                                    }
                                    if (NewSubPbActivity.this.lBZ.dnt() != null && NewSubPbActivity.this.lBZ.dnt().bhz() != null) {
                                        z2 = ay.a(NewSubPbActivity.this.lBZ.dnt().bhz().getBaijiahaoData());
                                    }
                                    if (z2) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.lBZ.diV(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.lBZ.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.lBZ.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.lBZ.dnt() != null && NewSubPbActivity.this.lBZ.dnt().bhz() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.lBZ.dnt().bhz().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.lBZ.diV(), NewSubPbActivity.this.lBZ.bxA(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.lBZ.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.lBZ.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.lCb.dnk() == null || view != NewSubPbActivity.this.lCb.dnk().djU()) {
                                    if (NewSubPbActivity.this.lCb.dnk() == null || view != NewSubPbActivity.this.lCb.dnk().djX()) {
                                        if (NewSubPbActivity.this.lCb.dnk() == null || view != NewSubPbActivity.this.lCb.dnk().djV()) {
                                            if (NewSubPbActivity.this.lCb.dnk() == null || view != NewSubPbActivity.this.lCb.dnk().djW()) {
                                                if (NewSubPbActivity.this.lCb.dnk() == null || view != NewSubPbActivity.this.lCb.dnk().djY()) {
                                                    if (view == NewSubPbActivity.this.lCb.dnd() || view == NewSubPbActivity.this.lCb.dnj()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.kpI.byf()) {
                                                                NewSubPbActivity.this.kpI.byg();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.kpI.DG(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view != null && (view.getTag() instanceof n)) {
                                                        NewSubPbActivity.this.lCo = (n) view.getTag();
                                                        if (bg.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.lCl) {
                                                                NewSubPbActivity.this.lCl = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.kpC == null || NewSubPbActivity.this.lBZ == null || NewSubPbActivity.this.lBZ.cuM() == null || NewSubPbActivity.this.kpC.oJ(NewSubPbActivity.this.lBZ.cuM().replyPrivateFlag)) && (sparseArray2 = (SparseArray) view.getTag(R.id.tag_from)) != null) {
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
                                                        if (NewSubPbActivity.this.lCc == null || view != NewSubPbActivity.this.lCc.djW()) {
                                                            if (NewSubPbActivity.this.lCc == null || view != NewSubPbActivity.this.lCc.djU()) {
                                                                if (NewSubPbActivity.this.lCc == null || view != NewSubPbActivity.this.lCc.djX()) {
                                                                    if (NewSubPbActivity.this.lCc == null || view != NewSubPbActivity.this.lCc.djY()) {
                                                                        if (NewSubPbActivity.this.lCc == null || view != NewSubPbActivity.this.lCc.dka()) {
                                                                            if (NewSubPbActivity.this.lCc == null || view != NewSubPbActivity.this.lCc.dkb()) {
                                                                                if (NewSubPbActivity.this.lCc == null || view != NewSubPbActivity.this.lCc.dkc()) {
                                                                                    if (NewSubPbActivity.this.lCc != null && view == NewSubPbActivity.this.lCc.djV()) {
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
                                                                                                NewSubPbActivity.this.lCb.dk(view);
                                                                                                return;
                                                                                            } else if (booleanValue2) {
                                                                                                NewSubPbActivity.this.lCb.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                                            String string2 = com.baidu.tbadk.core.sharedPref.b.bnH().getString("tail_link", "");
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
                                                                                            if (postData2.getType() != PostData.eya && !TextUtils.isEmpty(postData2.getBimg_url()) && k.bhh().isShowImages()) {
                                                                                                NewSubPbActivity.this.PM(postData2.getId());
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
                                                                                    if (postData3.blR() != null) {
                                                                                        NewSubPbActivity.this.d(postData3.blR());
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.lop != null && !TextUtils.isEmpty(NewSubPbActivity.this.loq)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.eqG == null) {
                                                                                        NewSubPbActivity.this.eqG = new bd(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.eqG.j(NewSubPbActivity.this.loq, NewSubPbActivity.this.lop.getImageByte());
                                                                                    NewSubPbActivity.this.lop = null;
                                                                                    NewSubPbActivity.this.loq = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.lop != null && !TextUtils.isEmpty(NewSubPbActivity.this.loq)) {
                                                                            if (NewSubPbActivity.this.lor == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.loq));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.loq;
                                                                                aVar.pkgId = NewSubPbActivity.this.lor.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.lor.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.lop = null;
                                                                            NewSubPbActivity.this.loq = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.jER != null) {
                                                                        NewSubPbActivity.this.jER.fT(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.jER = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                if (sparseArray5 != null && (sparseArray5.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_id) instanceof String) && (sparseArray5.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.lCb.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.de(view);
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
                                                                NewSubPbActivity.this.Pj((String) tag);
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
                                                            if (NewSubPbActivity.this.lBZ != null) {
                                                                TiebaStatic.log(new aq("c13700").dR("tid", NewSubPbActivity.this.lBZ.diW()).dR("fid", NewSubPbActivity.this.lBZ.getFromForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).aj("obj_type", 3));
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
                                                        ((PostData) sparseArray8.get(R.id.tag_clip_board)).fT(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new aq("c11739").aj("obj_locate", 4));
                                            if (!j.isNetWorkAvailable()) {
                                                NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.lCb.dly();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.Pj(str4);
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
                                            NewSubPbActivity.this.lCb.dly();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.dn(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.lCb.dly();
                                    SparseArray sparseArray10 = (SparseArray) view.getTag();
                                    if (sparseArray10 != null) {
                                        NewSubPbActivity.this.lCb.a(((Integer) sparseArray10.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray10.get(R.id.tag_del_post_id), ((Integer) sparseArray10.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new aq("c11739").aj("obj_locate", 2));
                                    NewSubPbActivity.this.lCb.dly();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.lBZ.dnt() != null) {
                                        NewSubPbActivity.this.n(NewSubPbActivity.this.lBZ.dnt().dgy());
                                    }
                                }
                            } else {
                                try {
                                    sparseArray3 = (SparseArray) view.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                }
                                if (sparseArray3 != null && ((PostData) sparseArray3.get(R.id.tag_clip_board)) != null) {
                                    if (NewSubPbActivity.this.lCc == null) {
                                        NewSubPbActivity.this.lCc = new ah(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aYF);
                                        NewSubPbActivity.this.lCb.m41do(NewSubPbActivity.this.lCc.getView());
                                        NewSubPbActivity.this.lCc.up(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.lCc.PJ();
                                    if (NewSubPbActivity.this.ua(sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin()) {
                                        z2 = true;
                                    }
                                    NewSubPbActivity.this.lCc.a(sparseArray3, NewSubPbActivity.this.dfX(), z2);
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.lCb.dmU();
                            NewSubPbActivity.this.lCb.dmV();
                            if (NewSubPbActivity.this.kpI != null) {
                                NewSubPbActivity.this.kpI.byh();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.dhT();
                        if (NewSubPbActivity.this.lBZ != null && NewSubPbActivity.this.lBZ.dnt() != null && NewSubPbActivity.this.lBZ.dnt().bhz() != null && NewSubPbActivity.this.lBZ.dnt().bhz().bka() != null) {
                            TiebaStatic.log(new aq("c13402").dR("tid", NewSubPbActivity.this.lBZ.diV()).w("fid", NewSubPbActivity.this.lBZ.dnt().bhz().getFid()).aj("obj_locate", 5).dR("uid", NewSubPbActivity.this.lBZ.dnt().bhz().bka().getUserId()));
                        }
                    }
                }
            }
        };
        this.lCd = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.lCb.dly();
                    if (NewSubPbActivity.this.ljp != 2 && NewSubPbActivity.this.ljp != 1) {
                        NewSubPbActivity.this.lCb.dnp();
                    }
                }
                NewSubPbActivity.this.kpI.byg();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.lCb.dnl();
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
                if (NewSubPbActivity.this.lCb != null && NewSubPbActivity.this.lCb.dnc()) {
                    return false;
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null && NewSubPbActivity.this.df(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.lop = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.loq = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.lop == null || TextUtils.isEmpty(NewSubPbActivity.this.loq)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lor = null;
                        } else {
                            NewSubPbActivity.this.lor = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.lop = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.loq = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lor = null;
                        } else {
                            NewSubPbActivity.this.lor = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.lop = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.loq = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lor = null;
                        } else {
                            NewSubPbActivity.this.lor = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        NewSubPbActivity.this.lCb.a(NewSubPbActivity.this.lpf, NewSubPbActivity.this.lop.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.jER = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.jER == null || NewSubPbActivity.this.lnO == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.lnO != null) {
                            NewSubPbActivity.this.lnO.ih(NewSubPbActivity.this.lBZ.dnA());
                        }
                        boolean z2 = NewSubPbActivity.this.lnO.bfV() && NewSubPbActivity.this.jER.getId() != null && NewSubPbActivity.this.jER.getId().equals(NewSubPbActivity.this.lBZ.dnC());
                        if (NewSubPbActivity.this.lCc == null) {
                            NewSubPbActivity.this.lCc = new ah(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aYF);
                            NewSubPbActivity.this.lCb.m41do(NewSubPbActivity.this.lCc.getView());
                            NewSubPbActivity.this.lCc.up(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.lCc.PJ();
                        boolean z3 = NewSubPbActivity.this.ua(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z4 = (NewSubPbActivity.this.lBZ.dnt() == null || NewSubPbActivity.this.lBZ.dnt().bhz() == null || !NewSubPbActivity.this.lBZ.dnt().bhz().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z2) {
                            NewSubPbActivity.this.lCc.djU().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.lCc.djU().setText(R.string.mark);
                        }
                        if (booleanValue || z4) {
                            NewSubPbActivity.this.lCc.djU().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.lCc.djU().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.df(view)) {
                            if (NewSubPbActivity.this.lop != null && !NewSubPbActivity.this.lop.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        ah ahVar = NewSubPbActivity.this.lCc;
                        int dfX = NewSubPbActivity.this.dfX();
                        if (NewSubPbActivity.this.llm && NewSubPbActivity.this.jER.mRL) {
                            z = true;
                        }
                        ahVar.a(sparseArray2, dfX, z3, z);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.lCe = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
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
                        p dnt = NewSubPbActivity.this.lBZ.dnt();
                        TbRichText bx = NewSubPbActivity.this.bx(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bx != null && bx.bDj() != null) {
                            tbRichTextData = bx.bDj().get(NewSubPbActivity.this.lpc);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!tbRichTextData.bDp().bDD()) {
                                String c = NewSubPbActivity.this.c(tbRichTextData);
                                arrayList.add(c);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap.put(c, imageUrlData);
                                String str5 = null;
                                String str6 = null;
                                String str7 = null;
                                if (dnt == null) {
                                    str4 = null;
                                    z4 = false;
                                } else {
                                    if (dnt.bya() != null) {
                                        str5 = dnt.bya().getName();
                                        str6 = dnt.bya().getId();
                                    }
                                    if (dnt.bhz() != null) {
                                        str7 = dnt.bhz().getId();
                                    }
                                    str4 = str7;
                                    z4 = true;
                                }
                                if (NewSubPbActivity.this.lBZ.dnH() != null) {
                                    concurrentHashMap = NewSubPbActivity.this.lBZ.dnH();
                                    z4 = NewSubPbActivity.this.lBZ.dnJ();
                                    arrayList = NewSubPbActivity.this.lBZ.dnI();
                                }
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(y.getItem(arrayList, 0));
                                ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                                aVar.x(arrayList2).Aq(str5).Ar(str6).As(str4).io(z4).At(arrayList.get(0)).ip(true).a(concurrentHashMap).iq(true).ir(false).is(false).s(NewSubPbActivity.this.bhz()).Au(String.valueOf(bx.getPostId())).Av(NewSubPbActivity.this.lBZ.getFromForumId());
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar.dU(NewSubPbActivity.this.getPageContext().getPageActivity())));
                                return;
                            }
                            NewSubPbActivity.this.lpd = false;
                            TbRichText dHz = dnt.dgy().dHz();
                            int size = arrayList.size();
                            int a2 = NewSubPbActivity.this.a(dHz, bx, i, i, arrayList, concurrentHashMap);
                            int size2 = arrayList.size();
                            if (size == size2) {
                                str2 = "";
                            } else {
                                str2 = arrayList.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (dnt == null) {
                                str3 = null;
                                z3 = false;
                            } else {
                                if (dnt.bya() != null) {
                                    str8 = dnt.bya().getName();
                                    str9 = dnt.bya().getId();
                                }
                                if (dnt.bhz() != null) {
                                    str10 = dnt.bhz().getId();
                                }
                                str3 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.lBZ.dnH() != null) {
                                concurrentHashMap = NewSubPbActivity.this.lBZ.dnH();
                                z3 = NewSubPbActivity.this.lBZ.dnJ();
                                arrayList = NewSubPbActivity.this.lBZ.dnI();
                                a2 += NewSubPbActivity.this.lBZ.getOffset();
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(y.getItem(arrayList, a2));
                            ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                            aVar2.x(arrayList3).Aq(str8).Ar(str9).As(str3).io(z3).At(str2).ip(true).a(concurrentHashMap).iq(true).ir(false).is(false).s(NewSubPbActivity.this.bhz()).Au(String.valueOf(bx.getPostId())).Av(NewSubPbActivity.this.lBZ.getFromForumId());
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar2.dU(NewSubPbActivity.this.getPageContext().getPageActivity())));
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
    public bw bhz() {
        if (this.lBZ == null || this.lBZ.dnt() == null) {
            return null;
        }
        return this.lBZ.dnt().bhz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(View view) {
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
            if (postData.bka() != null) {
                MetaData bka = postData.bka();
                this.kpI.setReplyId(bka.getUserId());
                boolean z2 = postData.mRL;
                String str = "";
                if (postData.dHz() != null) {
                    str = postData.dHz().toString();
                }
                this.kpI.DI(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bka().getName_show(), str));
                if (z2) {
                    if (!z) {
                        this.kpI.DH("");
                    }
                } else if (!z) {
                    this.kpI.DH(bka.getName_show());
                }
            }
            this.lCb.dmV();
        }
        if (this.lCn) {
            vc(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eLs == null) {
                this.eLs = new com.baidu.tbadk.core.message.a();
            }
            if (this.eLc == null) {
                this.eLc = new e();
                this.eLc.uniqueId = this.lCp;
            }
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.etA = 12;
            cVar.etG = 9;
            cVar.etF = 3;
            if (dmT() != null) {
                cVar.etE = dmT().dnL();
            }
            if (cVar != null) {
                cVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (cVar != null) {
                        cVar.etH = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (cVar != null) {
                        cVar.etH = 1;
                        i = 0;
                    }
                }
                this.eLs.a(agreeData, i, getUniqueId(), false);
                this.eLs.a(agreeData, this.eLc);
                if (dmT() == null && dmT().dnt() != null) {
                    this.eLs.a(this, cVar, agreeData, dmT().dnt().bhz());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (cVar != null) {
                cVar.etH = 1;
            }
            i = 0;
            this.eLs.a(agreeData, i, getUniqueId(), false);
            this.eLs.a(agreeData, this.eLc);
            if (dmT() == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bDp;
        if (tbRichText == tbRichText2) {
            this.lpd = true;
        }
        if (tbRichText != null && tbRichText.bDj() != null) {
            int size = tbRichText.bDj().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.bDj().get(i6) != null && tbRichText.bDj().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.bDj().get(i6).bDp().getWidth() * equipmentDensity;
                    int height = tbRichText.bDj().get(i6).bDp().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.bDj().get(i6).bDp().bDD()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.bDj().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (bDp = tbRichTextData.bDp()) != null) {
                            String bDF = bDp.bDF();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = bDF;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.lpd) {
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
        if (this.lCc != null) {
            this.lCc.up(z);
        }
        if (this.lCb != null) {
            this.lCb.up(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bDp = tbRichTextData.bDp();
        if (bDp != null) {
            if (!StringUtils.isNull(bDp.bDC())) {
                return bDp.bDC();
            }
            if (bDp.getHeight() * bDp.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bDp.getHeight() * bDp.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bDp.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bDp.getHeight())));
            } else {
                float width = bDp.getWidth() / bDp.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(at.getUrlEncode(bDp.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bx(String str, int i) {
        if (this.lBZ == null || this.lBZ.dnt() == null || str == null || i < 0) {
            return null;
        }
        p dnt = this.lBZ.dnt();
        TbRichText a2 = a(dnt.dgy(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(dnt.dgy(), str, i);
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
        TbRichText dHz = postData.dHz();
        if (dHz != null) {
            ArrayList<TbRichTextData> bDj = dHz.bDj();
            int size = bDj.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (bDj.get(i3) != null && bDj.get(i3).getType() == 8) {
                    i2++;
                    if (bDj.get(i3).bDp().bDF().equals(str)) {
                        int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = bDj.get(i3).bDp().getWidth() * equipmentDensity;
                        int height = bDj.get(i3).bDp().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.lpc = i3;
                        return dHz;
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
    public void dhT() {
        Intent intent = getIntent();
        if (intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false) {
            if (this.kpC == null || this.lBZ == null || this.lBZ.cuM() == null || this.kpC.oJ(this.lBZ.cuM().replyPrivateFlag)) {
                if (this.kpI.bxU()) {
                    this.kpI.a((PostWriteCallBackData) null);
                    return;
                }
                this.lCb.dmU();
                this.lCb.dmV();
                if (this.kpI != null) {
                    this.kpI.byj();
                    return;
                }
                return;
            }
            return;
        }
        if (this.iFN == null) {
            this.iFN = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.iFN.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void pz(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void C(boolean z, int i) {
                }

                /* JADX WARN: Removed duplicated region for block: B:26:0x00bf  */
                /* JADX WARN: Removed duplicated region for block: B:27:0x00ca  */
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void pA(boolean z) {
                    String str;
                    if (z) {
                        if (NewSubPbActivity.this.kpC == null || NewSubPbActivity.this.lBZ == null || NewSubPbActivity.this.lBZ.cuM() == null || NewSubPbActivity.this.kpC.oJ(NewSubPbActivity.this.lBZ.cuM().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.lBZ != null && NewSubPbActivity.this.lBZ.dnt() != null && NewSubPbActivity.this.lBZ.dnt().dgy() != null) {
                                PostData dgy = NewSubPbActivity.this.lBZ.dnt().dgy();
                                if (dgy.dHz() != null && dgy.bka() != null) {
                                    str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), dgy.bka().getName_show(), dgy.dHz().toString());
                                    NewSubPbActivity.this.kpI.bwY().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                                    if (!NewSubPbActivity.this.kpI.bxU()) {
                                        NewSubPbActivity.this.kpI.a((PostWriteCallBackData) null);
                                        return;
                                    }
                                    NewSubPbActivity.this.lCb.dmU();
                                    NewSubPbActivity.this.lCb.dmV();
                                    if (NewSubPbActivity.this.kpI != null) {
                                        NewSubPbActivity.this.kpI.byj();
                                        return;
                                    }
                                    return;
                                }
                            }
                            str = null;
                            NewSubPbActivity.this.kpI.bwY().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                            if (!NewSubPbActivity.this.kpI.bxU()) {
                            }
                        }
                    }
                }
            });
        }
        if (this.lBZ != null && this.lBZ.dnt() != null && this.lBZ.dnt().bya() != null) {
            this.iFN.G(this.lBZ.dnt().bya().getId(), com.baidu.adp.lib.f.b.toLong(this.lBZ.diV(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ua(boolean z) {
        if (this.lBZ == null) {
            return false;
        }
        return ((dfX() != 0) || this.lBZ.dnt() == null || this.lBZ.dnt().bhz() == null || this.lBZ.dnt().bhz().bka() == null || this.lBZ.dnt().bhz().biK() || TextUtils.equals(this.lBZ.dnt().bhz().bka().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bI(int i, String str) {
        if (this.lBZ.dnu()) {
            showToast(str);
        } else if (l.isNetOk()) {
            if (i == 4) {
                this.lCb.IC(str + "(4)");
            } else {
                this.lCb.CD(R.string.no_data_text);
            }
        } else {
            this.lCb.CD(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void su(boolean z) {
        this.kpI = (h) new com.baidu.tbadk.editortools.pb.i(z).ei(getActivity());
        if (this.kpI != null) {
            this.kpI.a(getPageContext());
            this.kpI.b(this.lBZ);
            this.kpI.b(this.jEq);
            this.kpI.setFrom(2);
            this.kpI.a(this.fjX);
            this.kpI.a(this.fjY);
            this.kpI.bwY().jS(true);
            this.kpI.j(getPageContext());
        }
        if (this.lCb != null) {
            this.lCb.i(this.kpI);
        }
        if (this.kpI != null && this.lBZ != null) {
            this.kpI.a(this.lBZ.cuM());
            this.kpI.byg();
        }
        if (this.kpI != null) {
            this.kpI.byk().setDefaultHint(dkM());
            this.kpI.byk().setHint(dkM());
            this.jEk = this.kpI.byk().getInputView();
            this.jEk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.jEj != null) {
                        if (!NewSubPbActivity.this.jEj.dQu()) {
                            NewSubPbActivity.this.qY(false);
                        }
                        NewSubPbActivity.this.jEj.yh(false);
                    }
                }
            });
        }
    }

    public void dmR() {
        if (!TbadkCoreApplication.isLogin()) {
            this.kpI.byg();
        } else if (!StringUtils.isNull(this.lBZ.dnD())) {
            if (this.lCb.dmY() && l.isNetOk()) {
                this.lCb.csK();
            } else {
                this.lCb.dnb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dn(View view) {
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
                    this.lCb.dk(view);
                }
            } else if (booleanValue2) {
                this.lCb.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.lCb.dni(), getPageContext().getPageActivity());
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
            bVar.or(R.string.operation);
            bVar.a(strArr, new b.InterfaceC0564b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0564b
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.lCk);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.lCk);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).bmE();
        }
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.lCb.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.lCk;
        userMuteCheckCustomMessage.setTag(this.lCk);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.lCb.a(0, bVar.QP, bVar.mTG, z);
            if (bVar.QP) {
                if (bVar.iij == 1) {
                    if (this.lCb.getListView() instanceof BdTypeListView) {
                        List<q> data = ((BdTypeListView) this.lCb.getListView()).getData();
                        if (!y.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.lCb.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.iij == 2) {
                    this.lBZ.PO(bVar.mPostId);
                    this.lCb.a(this.lBZ.dnt(), this.lBZ.dfX(), this.lBZ.dnH() != null, false);
                    if (this.lBZ.dnE()) {
                        this.lBZ.vg(false);
                        this.lCb.dmW();
                        this.lBZ.loadData();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void Pj(String str) {
        if (this.lBZ != null && this.lBZ.dnt() != null && this.lBZ.dnt().bhz() != null && this.lBZ.dnt().bhz().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lBZ.diV(), str);
            bw bhz = this.lBZ.dnt().bhz();
            if (bhz.biI()) {
                format = format + "&channelid=33833";
            } else if (bhz.blU()) {
                format = format + "&channelid=33842";
            } else if (bhz.biJ()) {
                format = format + "&channelid=33840";
            }
            Pk(format);
            return;
        }
        this.lnN.PK(str);
    }

    private void Pk(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void n(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.lBZ.dnA() && postData.getId() != null && postData.getId().equals(this.lBZ.dnC())) {
                z = true;
            }
            MarkData o = this.lBZ.o(postData);
            if (o != null) {
                this.lCb.dly();
                if (this.lnO != null) {
                    this.lnO.a(o);
                    if (!z) {
                        this.lnO.bfX();
                    } else {
                        this.lnO.bfW();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.lBZ != null) {
            this.lBZ.aC(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.kpI != null) {
            this.kpI.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.kpI.bwY().bvv();
        this.kpI.byg();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.kpI.b(writeData);
                this.kpI.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.m ra = this.kpI.bwY().ra(6);
                if (ra != null && ra.fhv != null) {
                    ra.fhv.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.kpI.byc();
                }
                this.lCb.dnp();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iBr != null) {
            this.iBr.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.mIsPaused = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.bdF().bdQ();
        if (this.iBr != null) {
            this.iBr.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.jQR);
        this.lCb.cCZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.mIsPaused = false;
        super.onResume();
        diy();
        if (this.iBr != null) {
            this.iBr.onResume(getPageContext());
        }
        registerListener(this.jQR);
        this.lCb.cDa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.iBr != null) {
            this.iBr.onStop(getPageContext());
        }
        this.kpI.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.lCm));
        this.lBZ.cancelLoadData();
        this.lBZ.destory();
        this.lCa.cancelLoadData();
        if (this.iBr != null) {
            this.iBr.onDestory(getPageContext());
        }
        this.lCb.dly();
        this.lCb.cBk();
        MessageManager.getInstance().unRegisterListener(this.loN);
        MessageManager.getInstance().unRegisterListener(this.loO);
        MessageManager.getInstance().unRegisterListener(this.loP);
        MessageManager.getInstance().unRegisterListener(this.lCk);
        this.lok = null;
        this.lol = null;
        if (this.kpC != null) {
            this.kpC.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lCb.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.iBr;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View dnd = this.lCb.dnd();
        if (dnd == null || (findViewWithTag = dnd.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean PC(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = be.getParamPair(be.getParamStr(str))) != null) {
            this.lCl = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return PC(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(lBY);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (PC(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                    lVar.mLink = str;
                    lVar.type = 3;
                    lVar.fgu = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
                }
            } else {
                be.boR().b(getPageContext(), new String[]{str});
            }
            this.lCl = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ax(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.lCl = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ay(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void az(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aA(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void u(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView getListView() {
        if (this.lCb != null) {
            return this.lCb.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int bDU() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> bDW() {
        if (this.fDm == null) {
            this.fDm = TbRichTextView.A(getPageContext().getPageActivity(), 8);
        }
        return this.fDm;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> bDX() {
        if (this.fzW == null) {
            this.fzW = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cqr */
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
        return this.fzW;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> bDV() {
        if (this.fzV == null) {
            this.fzV = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bEh */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = k.bhh().isShowImages();
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
                        if (k.bhh().isShowImages()) {
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
        return this.fzV;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> bDY() {
        if (this.fDn == null) {
            this.fDn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: diF */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(NewSubPbActivity.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dg */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dh */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: di */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fDn;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> bDZ() {
        if (this.fDo == null) {
            this.fDo = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: diH */
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
        return this.fDo;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> bEa() {
        this.fDp = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: diG */
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
        return this.fDp;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a dgN() {
        return this.ljT;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean dgO() {
        return (this.lBZ == null || this.lBZ.dnt() == null || this.lBZ.dnt().bhz() == null || this.lBZ.dnt().bhz().blx()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String dgP() {
        if (this.lBZ == null || this.lBZ.dnt() == null || this.lBZ.dnt().bhz() == null) {
            return null;
        }
        return this.lBZ.dnt().bhz().bke();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int dgQ() {
        if (this.lBZ == null) {
            return 0;
        }
        return this.lBZ.dfX();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Pd(String str) {
        if (StringUtils.isNull(str) || this.lBZ == null || this.lBZ.dnt() == null || this.lBZ.dnt().bhz() == null || this.lBZ.dnt().bhz().bka() == null) {
            return false;
        }
        return str.equals(this.lBZ.dnt().bhz().bka().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.lCb.dmY() && l.isNetOk()) {
            this.lBZ.loadData();
        } else {
            this.lCb.dnb();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.lCk);
        userMuteAddAndDelCustomMessage.setTag(this.lCk);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PM(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bnH().getString("bubble_link", "");
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
    public void aB(Context context, String str) {
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
                return com.baidu.tbadk.m.e.bzH().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.lBZ != null) {
            if (this.lBZ.dnt() != null && this.lBZ.dnt().bya() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.lBZ.dnt().bya().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.lBZ.diV(), 0L));
            if (this.lBZ.dnt() != null && this.lBZ.dnt().bhz() != null) {
                pageStayDurationItem.setNid(this.lBZ.dnt().bhz().getNid());
            }
            pageStayDurationItem.setPid(com.baidu.adp.lib.f.b.toLong(this.lBZ.bxA(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public boolean dmS() {
        if (this.lBZ != null) {
            return this.lBZ.dmS();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.lCb.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lok.getPageActivity());
        if (at.isEmpty(str)) {
            aVar.Ba(this.lok.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Ba(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.lCb.showLoadingDialog();
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
        aVar.b(this.lok).bmC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DF(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lok.getPageActivity());
        aVar.Ba(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lok).bmC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void diu() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.Ba(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.lok).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.lok.getPageActivity(), 2, true, 4);
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
        aVar.b(this.lok).bmC();
    }

    public SubPbModel dmT() {
        return this.lBZ;
    }

    public int dfX() {
        if (this.lBZ != null) {
            return this.lBZ.dfX();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.fhR && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fhR && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void qY(boolean z) {
        if (this.jEk != null && this.jEk.getText() != null) {
            int selectionEnd = this.jEk.getSelectionEnd();
            SpannableStringBuilder c = this.jEj.c(this.jEk.getText());
            if (c != null) {
                this.jEj.yh(true);
                this.jEk.setText(c);
                if (z && this.jEj.dQs() >= 0) {
                    this.jEk.requestFocus();
                    this.jEk.setSelection(this.jEj.dQs());
                } else {
                    this.jEk.setSelection(selectionEnd);
                }
                this.jEj.yg(this.jEj.dQs() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kpI != null && this.kpI.bwY() != null && this.kpI.bwY().bxc()) {
            this.kpI.bwY().bvv();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(t tVar) {
        ag.a(tVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    public String dkM() {
        if (!at.isEmpty(this.lwM)) {
            return this.lwM;
        }
        this.lwM = getResources().getString(com.baidu.tieba.pb.pb.main.ay.dkB());
        return this.lwM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.lCn = z;
        vc(true);
    }

    private void vc(boolean z) {
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
        if (this.lCb != null && this.lCb.getListView() != null && this.lCo != null && this.lCo.mPosition != -1) {
            final int headerViewsCount = this.lCo.mPosition + this.lCb.getListView().getHeaderViewsCount();
            if (this.lCo.getView() != null) {
                final int height = this.lCo.getView().getHeight();
                final int height2 = ((rect.height() - this.lCb.dno()) - this.lCb.getNavigationBarHeight()) - this.lCb.dnn();
                final int i = height - height2;
                if (i > 0) {
                    this.lCb.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.lCb != null && NewSubPbActivity.this.lCb.getListView() != null) {
                                NewSubPbActivity.this.lCb.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.lCb.getNavigationBarHeight() - i);
                            }
                        }
                    });
                } else {
                    this.lCb.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.lCb != null && NewSubPbActivity.this.lCb.getListView() != null) {
                                NewSubPbActivity.this.lCb.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.lCb.getNavigationBarHeight() + (height2 - height));
                            }
                        }
                    });
                }
            }
        }
    }

    private void diy() {
        if (this.lBZ != null && !at.isEmpty(this.lBZ.diV())) {
            com.baidu.tbadk.BdToken.c.bdF().q(com.baidu.tbadk.BdToken.b.ekj, com.baidu.adp.lib.f.b.toLong(this.lBZ.diV(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.lBZ == null || at.isEmpty(this.lBZ.diV())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.lBZ.diV(), 0L);
    }
}
