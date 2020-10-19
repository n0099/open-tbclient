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
    private static String lpz = "tbgametype";
    private View.OnClickListener aXk;
    private e eCG;
    private com.baidu.tbadk.core.message.a eCW;
    private bd eii;
    private com.baidu.adp.lib.d.b<ImageView> fry;
    private com.baidu.adp.lib.d.b<GifView> frz;
    private com.baidu.adp.lib.d.b<TextView> fuR;
    private com.baidu.adp.lib.d.b<View> fuS;
    private com.baidu.adp.lib.d.b<LinearLayout> fuT;
    private com.baidu.adp.lib.d.b<RelativeLayout> fuU;
    private VoiceManager ioV;
    private com.baidu.tieba.frs.profession.permission.c itr;
    private com.baidu.tieba.write.c jrJ;
    private EditText jrK;
    private com.baidu.tieba.pb.pb.main.b.a kXu;
    public am kdd;
    private h kdj;
    private com.baidu.adp.base.e lbJ;
    private com.baidu.tbadk.core.view.c lbK;
    private com.baidu.adp.widget.ImageView.a lbN;
    private String lbO;
    private TbRichTextMemeInfo lbP;
    private com.baidu.tieba.pb.pb.report.a lbo;
    private com.baidu.tbadk.baseEditMark.a lbp;
    private PostWriteCallBackData ldw;
    private String lkj;
    private SubPbModel lpA;
    private ForumManageModel lpB;
    private com.baidu.tieba.pb.pb.sub.a lpC;
    private ah lpD;
    private AbsListView.OnScrollListener lpE;
    private TbRichTextView.i lpF;
    private SubPbModel.a lpG;
    private com.baidu.adp.base.d lpH;
    private BdUniqueId lpL;
    private com.baidu.tieba.pb.e<p> lpN;
    private boolean lpO;
    private n lpP;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int lcz = 0;
    PostData jsr = null;
    private a.InterfaceC0547a lcv = null;
    private a lpI = null;
    private a lpJ = null;
    private boolean mIsPaused = false;
    private boolean lpK = false;
    private boolean lpM = false;
    private boolean eZv = false;
    private com.baidu.tbadk.editortools.pb.c fby = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bvK() {
            NewSubPbActivity.this.lpC.djT();
        }
    };
    private int kWQ = 0;
    private boolean mIsFromSchema = false;
    private BdUniqueId lpQ = BdUniqueId.gen();
    private boolean kYN = com.baidu.tbadk.a.d.bdC();
    private boolean lpR = true;
    private com.baidu.tbadk.editortools.pb.b fbz = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bvJ() {
            if (!NewSubPbActivity.this.jrJ.dNl()) {
                return (NewSubPbActivity.this.kdd == null || NewSubPbActivity.this.lpA == null || NewSubPbActivity.this.lpA.crF() == null || NewSubPbActivity.this.kdd.aM(NewSubPbActivity.this.lpA.crF().replyPrivateFlag, am.ezc)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.jrJ.dNn());
            if (NewSubPbActivity.this.kdj.bwb()) {
                NewSubPbActivity.this.kdj.a(NewSubPbActivity.this.ldw);
            }
            NewSubPbActivity.this.qG(true);
            return true;
        }
    };
    private CustomMessageListener lpS = new CustomMessageListener(2921481) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && NewSubPbActivity.this.lpA != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && at.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), NewSubPbActivity.this.lpA.dfO())) {
                if (NewSubPbActivity.this.jrJ != null) {
                    NewSubPbActivity.this.jrJ.TK(null);
                    NewSubPbActivity.this.jrJ.bh(null);
                    NewSubPbActivity.this.jrJ.xP(false);
                }
                if (NewSubPbActivity.this.kdj != null) {
                    NewSubPbActivity.this.kdj.bwl();
                    NewSubPbActivity.this.kdj.reset();
                }
                NewSubPbActivity.this.lpA.bvG();
            }
        }
    };
    private NewWriteModel.d jrQ = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.kdj != null && NewSubPbActivity.this.kdj.bvf() != null) {
                NewSubPbActivity.this.kdj.bvf().hide();
                if (NewSubPbActivity.this.lpA.dkt()) {
                    TiebaStatic.log(new aq("c10367").dK("post_id", NewSubPbActivity.this.lpA.bvH()));
                }
            }
            if (z) {
                NewSubPbActivity.this.jrJ.TK(null);
                NewSubPbActivity.this.jrJ.bh(null);
                NewSubPbActivity.this.jrJ.xP(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(NewSubPbActivity.this.getPageContext(), postWriteCallBackData);
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.jrJ.bh(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.jrJ.TK(postWriteCallBackData.getErrorString());
                if (!y.isEmpty(NewSubPbActivity.this.jrJ.dNj())) {
                    NewSubPbActivity.this.ldw = postWriteCallBackData;
                    if (NewSubPbActivity.this.kdj.bwb()) {
                        NewSubPbActivity.this.kdj.a(NewSubPbActivity.this.ldw);
                    }
                    NewSubPbActivity.this.qG(true);
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
                    aVar.AH(NewSubPbActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.AH(postWriteCallBackData.getErrorString());
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
                aVar.b(NewSubPbActivity.this.getPageContext()).bkJ();
                TiebaStatic.log(new aq("c13745").aj("obj_locate", 1).aj("obj_type", 2));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.kdd != null) {
                NewSubPbActivity.this.kdd.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.lpC.djU();
        }
    };
    private CustomMessageListener lck = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.lpL) {
                NewSubPbActivity.this.lpC.cbz();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.lbK.showSuccessToast(NewSubPbActivity.this.lbJ.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.lbJ.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.Dm(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.dfn();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (at.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.lbJ.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.lbK.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lcl = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.lpL) {
                NewSubPbActivity.this.lpC.cbz();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.lbK.showSuccessToast(NewSubPbActivity.this.lbJ.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (at.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.lbJ.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.lbK.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener lcm = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.lpL) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.lpC.cbz();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.mTb;
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
                    NewSubPbActivity.this.lpC.a(sparseArray, z);
                }
            }
        }
    };
    private final f.c gav = new f.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (NewSubPbActivity.this.lpA != null) {
                NewSubPbActivity.this.lpA.dkr();
            }
        }
    };
    boolean lcA = false;
    private final b.InterfaceC0550b lcC = new b.InterfaceC0550b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0550b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.lbN != null && !TextUtils.isEmpty(NewSubPbActivity.this.lbO)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.lbP == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.lbO));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.lbO;
                        aVar.pkgId = NewSubPbActivity.this.lbP.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.lbP.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.eii == null) {
                            NewSubPbActivity.this.eii = new bd(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.eii.j(NewSubPbActivity.this.lbO, NewSubPbActivity.this.lbN.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.lbN = null;
                NewSubPbActivity.this.lbO = null;
            }
        }
    };
    private CustomMessageListener jEs = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener iqB = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    m mVar = (m) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.lpA.dkl() != null && NewSubPbActivity.this.lpA.dkl().ddq() != null && NewSubPbActivity.this.lpA.dkl().ddq().bih() != null && currentAccount.equals(NewSubPbActivity.this.lpA.dkl().ddq().bih().getUserId()) && NewSubPbActivity.this.lpA.dkl().ddq().bih().getPendantData() != null) {
                        NewSubPbActivity.this.lpA.dkl().ddq().bih().getPendantData().Aq(mVar.bgd());
                        NewSubPbActivity.this.lpA.dkl().ddq().bih().getPendantData().dh(mVar.buE());
                        NewSubPbActivity.this.lpC.a(NewSubPbActivity.this.lpA.dkl(), NewSubPbActivity.this.lpA.dkl().ddq(), NewSubPbActivity.this.lpA.dkl().SR(), NewSubPbActivity.this.lpA.dkl().bec(), NewSubPbActivity.this.lpA.dcP(), NewSubPbActivity.this.lpA.dkz() != null);
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
        this.lbJ = getPageContext();
        this.lpK = true;
        this.jrJ = new com.baidu.tieba.write.c();
        this.jrJ.KC(R.color.cp_cont_h_alpha85);
        this.jrJ.KB(R.color.cp_cont_a);
        bQI();
        djJ();
        initData(bundle);
        initUI();
        ((SubPbView) this.lpC.getRootView()).show();
        sc(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lpC.uM(this.mIsFromSchema);
        this.lbK = new com.baidu.tbadk.core.view.c();
        this.lbK.toastTime = 1000L;
        registerListener(this.lcm);
        registerListener(this.lck);
        registerListener(this.lcl);
        registerListener(this.lpS);
        this.lpL = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.lpL;
        userMuteAddAndDelCustomMessage.setTag(this.lpL);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.lpL;
        userMuteCheckCustomMessage.setTag(this.lpL);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.kdd = new am(getPageContext());
        this.kdd.a(new am.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.kdj.bwj();
                }
            }
        });
        this.lbo = new com.baidu.tieba.pb.pb.report.a(this);
        this.lbo.w(getUniqueId());
        this.kXu = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.lpC = new com.baidu.tieba.pb.pb.sub.a(this, this.aXk);
        this.lpC.a(this.lpA);
        setContentView(this.lpC.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.lpC.setOnScrollListener(this.lpE);
        this.lpC.b(this);
        this.lpC.setOnImageClickListener(this.lpF);
        this.lpC.setOnLongClickListener(this.mOnLongClickListener);
        this.lpC.f(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.lpA != null) {
                    NewSubPbActivity.this.lpA.loadData();
                }
            }
        });
        this.lpC.a(this.lpI);
        this.lpC.b(this.lpJ);
        this.lpC.setListPullRefreshListener(this.gav);
        if (this.lpA != null && this.lpA.djL() && !this.lpA.dky()) {
            this.lpC.djZ().setVisibility(8);
        } else {
            this.lpC.djZ().setVisibility(0);
        }
        if (this.lpA != null && !this.lpA.djL()) {
            this.lpC.setIsFromPb(false);
        }
    }

    private boolean aD(Bundle bundle) {
        if (bundle != null) {
            this.eZv = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.eZv = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.eZv;
    }

    public void initData(Bundle bundle) {
        this.lpA = new SubPbModel(getPageContext());
        this.lpA.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                NewSubPbActivity.this.lpC.u(postData);
                NewSubPbActivity.this.lpC.b((BdListView.e) null);
            }
        });
        this.lpB = new ForumManageModel(getPageContext());
        this.lpB.setLoadDataCallBack(this.lpH);
        this.ioV = new VoiceManager();
        this.ioV.onCreate(getPageContext());
        this.lbp = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.lbp != null) {
            this.lbp.a(this.lcv);
        }
        if (bundle != null) {
            this.lpA.initWithBundle(bundle);
        } else {
            this.lpA.initWithIntent(getIntent());
        }
        this.lpA.a(this.lpG);
        if (this.lpA.djL() && !this.lpA.dkE()) {
            this.lpA.loadData();
        } else {
            this.lpA.dkq();
        }
    }

    public void djJ() {
        this.lpG = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, final p pVar) {
                if (NewSubPbActivity.this.lpC != null) {
                    NewSubPbActivity.this.lpC.djU();
                    if (!z) {
                        NewSubPbActivity.this.bH(i, str);
                        return;
                    }
                    NewSubPbActivity.this.lpC.hideNoDataView();
                    if (pVar != null) {
                        if (pVar.ddq() != null || NewSubPbActivity.this.lpA != null) {
                            pVar.ddq().a(NewSubPbActivity.this.lpA.dkx());
                        }
                        if (NewSubPbActivity.this.lpC != null) {
                            NewSubPbActivity.this.sc(pVar.bfG() != null && pVar.bfG().isBjh());
                            if (NewSubPbActivity.this.kdj != null && NewSubPbActivity.this.kdj.bvf() != null) {
                                NewSubPbActivity.this.kdj.bvf().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.lpC.a(pVar, NewSubPbActivity.this.lpA.dcP(), NewSubPbActivity.this.lpA.dkz() != null, NewSubPbActivity.this.lpK);
                            if (NewSubPbActivity.this.lpK) {
                                NewSubPbActivity.this.lpC.getListView().setSelectionFromTop(NewSubPbActivity.this.lpC.getListView().getHeaderViewsCount() + 1, -l.getDimens(NewSubPbActivity.this, R.dimen.tbds18));
                                NewSubPbActivity.this.djK();
                                NewSubPbActivity.this.lpK = false;
                            }
                        }
                        if (NewSubPbActivity.this.kdj != null) {
                            NewSubPbActivity.this.kdj.a(pVar.crF());
                            NewSubPbActivity.this.kdj.setThreadData(pVar.bfG());
                            if (NewSubPbActivity.this.getIntent() != null && NewSubPbActivity.this.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && NewSubPbActivity.this.lpR) {
                                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        NewSubPbActivity.this.lpR = false;
                                        NewSubPbActivity.this.c(pVar.ddq(), false);
                                    }
                                }, 200L);
                            }
                        }
                        if (NewSubPbActivity.this.lpN == null) {
                            NewSubPbActivity.this.lpN = new com.baidu.tieba.pb.e();
                        }
                        NewSubPbActivity.this.lpN.setData(pVar);
                        NewSubPbActivity.this.lpN.setType(0);
                        NewSubPbActivity.this.kdd.a(NewSubPbActivity.this.lpA.dkC());
                    }
                }
            }
        };
        this.lcv = new a.InterfaceC0547a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0547a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.lbp != null) {
                        NewSubPbActivity.this.lbp.hU(z2);
                    }
                    MarkData bef = NewSubPbActivity.this.lbp.bef();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(bef);
                        if (NewSubPbActivity.this.lbp != null) {
                            if (bef != null) {
                                NewSubPbActivity.this.lpA.uO(true);
                                NewSubPbActivity.this.lpA.Pr(NewSubPbActivity.this.lpA.bvH());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.lpC != null) {
                                NewSubPbActivity.this.lpC.uN(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.lpA.uO(false);
                        NewSubPbActivity.this.lpA.Pr(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.lpC != null) {
                            NewSubPbActivity.this.lpC.uN(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.lpI = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.lpA.dkl() != null && NewSubPbActivity.this.lpA.dkl().bfG() != null && NewSubPbActivity.this.lpA.dkl().bfG().bih() != null) {
                    str = String.valueOf(NewSubPbActivity.this.lpA.dkl().bfG().bih().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.lpA.dkl().bwh().getId(), NewSubPbActivity.this.lpA.dkl().bwh().getName(), NewSubPbActivity.this.lpA.dkl().bfG().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.lpJ = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.lpB.dFa() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.lpA != null && NewSubPbActivity.this.lpA.dkl() != null && NewSubPbActivity.this.lpA.dkl().bwh() != null && NewSubPbActivity.this.lpA.dkl().bfG() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.lpB.Sd(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.lpB.a(NewSubPbActivity.this.lpA.dkl().bwh().getId(), NewSubPbActivity.this.lpA.dkl().bwh().getName(), NewSubPbActivity.this.lpA.dkl().bfG().getId(), valueOf, i2, i, z, NewSubPbActivity.this.lpA.dkl().bfG().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.lpH = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.lpC.a(NewSubPbActivity.this.lpB.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.lpB.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.lqP != 1002 || bVar.gyX) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.lpC.a(1, dVar.QO, dVar.mGW, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean db(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void bQI() {
        registerListener(this.iqB);
        this.aXk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
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
                if (view != null || NewSubPbActivity.this.lpC != null) {
                    if (view == NewSubPbActivity.this.lpC.dkf()) {
                        NewSubPbActivity.this.lpC.dir();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                be.bmY().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.lpC.cxE()) {
                        if (view != NewSubPbActivity.this.lpC.djY()) {
                            if (view == NewSubPbActivity.this.lpC.djX()) {
                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                    NewSubPbActivity.this.lpC.djN();
                                    NewSubPbActivity.this.lpC.djO();
                                    if (NewSubPbActivity.this.kdj != null) {
                                        NewSubPbActivity.this.kdj.bwp();
                                    }
                                }
                            } else if (view.getId() != R.id.pb_floor_feedback) {
                                if (view == NewSubPbActivity.this.lpC.djS()) {
                                    NewSubPbActivity.this.lpC.dir();
                                    if (NewSubPbActivity.this.lpA.loadData()) {
                                        NewSubPbActivity.this.lpC.djQ();
                                    }
                                } else if (view == NewSubPbActivity.this.lpC.djZ() || view == NewSubPbActivity.this.lpC.dka() || view == NewSubPbActivity.this.lpC.dkc()) {
                                    if (NewSubPbActivity.this.lpM) {
                                        NewSubPbActivity.this.lpM = false;
                                        return;
                                    }
                                    if (NewSubPbActivity.this.lpA.dkl() != null && NewSubPbActivity.this.lpA.dkl().bfG() != null) {
                                        z2 = ay.a(NewSubPbActivity.this.lpA.dkl().bfG().getBaijiahaoData());
                                    }
                                    if (z2) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.lpA.dfO(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.lpA.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.lpA.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.lpA.dkl() != null && NewSubPbActivity.this.lpA.dkl().bfG() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.lpA.dkl().bfG().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.lpA.dfO(), NewSubPbActivity.this.lpA.bvH(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.lpA.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.lpA.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.lpC.dkd() == null || view != NewSubPbActivity.this.lpC.dkd().dgN()) {
                                    if (NewSubPbActivity.this.lpC.dkd() == null || view != NewSubPbActivity.this.lpC.dkd().dgQ()) {
                                        if (NewSubPbActivity.this.lpC.dkd() == null || view != NewSubPbActivity.this.lpC.dkd().dgO()) {
                                            if (NewSubPbActivity.this.lpC.dkd() == null || view != NewSubPbActivity.this.lpC.dkd().dgP()) {
                                                if (NewSubPbActivity.this.lpC.dkd() == null || view != NewSubPbActivity.this.lpC.dkd().dgR()) {
                                                    if (view == NewSubPbActivity.this.lpC.djW() || view == NewSubPbActivity.this.lpC.dkc()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.kdj.bwm()) {
                                                                NewSubPbActivity.this.kdj.bwn();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.kdj.Dn(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view != null && (view.getTag() instanceof n)) {
                                                        NewSubPbActivity.this.lpP = (n) view.getTag();
                                                        if (bg.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.lpM) {
                                                                NewSubPbActivity.this.lpM = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.kdd == null || NewSubPbActivity.this.lpA == null || NewSubPbActivity.this.lpA.crF() == null || NewSubPbActivity.this.kdd.oy(NewSubPbActivity.this.lpA.crF().replyPrivateFlag)) && (sparseArray2 = (SparseArray) view.getTag(R.id.tag_from)) != null) {
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
                                                        if (NewSubPbActivity.this.lpD == null || view != NewSubPbActivity.this.lpD.dgP()) {
                                                            if (NewSubPbActivity.this.lpD == null || view != NewSubPbActivity.this.lpD.dgN()) {
                                                                if (NewSubPbActivity.this.lpD == null || view != NewSubPbActivity.this.lpD.dgQ()) {
                                                                    if (NewSubPbActivity.this.lpD == null || view != NewSubPbActivity.this.lpD.dgR()) {
                                                                        if (NewSubPbActivity.this.lpD == null || view != NewSubPbActivity.this.lpD.dgT()) {
                                                                            if (NewSubPbActivity.this.lpD == null || view != NewSubPbActivity.this.lpD.dgU()) {
                                                                                if (NewSubPbActivity.this.lpD == null || view != NewSubPbActivity.this.lpD.dgV()) {
                                                                                    if (NewSubPbActivity.this.lpD != null && view == NewSubPbActivity.this.lpD.dgO()) {
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
                                                                                                NewSubPbActivity.this.lpC.dg(view);
                                                                                                return;
                                                                                            } else if (booleanValue2) {
                                                                                                NewSubPbActivity.this.lpC.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                                            String string2 = com.baidu.tbadk.core.sharedPref.b.blO().getString("tail_link", "");
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
                                                                                            if (postData2.getType() != PostData.epC && !TextUtils.isEmpty(postData2.getBimg_url()) && k.bfo().isShowImages()) {
                                                                                                NewSubPbActivity.this.Po(postData2.getId());
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
                                                                                    if (postData3.bjY() != null) {
                                                                                        NewSubPbActivity.this.d(postData3.bjY());
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.lbN != null && !TextUtils.isEmpty(NewSubPbActivity.this.lbO)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.eii == null) {
                                                                                        NewSubPbActivity.this.eii = new bd(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.eii.j(NewSubPbActivity.this.lbO, NewSubPbActivity.this.lbN.getImageByte());
                                                                                    NewSubPbActivity.this.lbN = null;
                                                                                    NewSubPbActivity.this.lbO = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.lbN != null && !TextUtils.isEmpty(NewSubPbActivity.this.lbO)) {
                                                                            if (NewSubPbActivity.this.lbP == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.lbO));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.lbO;
                                                                                aVar.pkgId = NewSubPbActivity.this.lbP.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.lbP.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.lbN = null;
                                                                            NewSubPbActivity.this.lbO = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.jsr != null) {
                                                                        NewSubPbActivity.this.jsr.fS(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.jsr = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                if (sparseArray5 != null && (sparseArray5.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_id) instanceof String) && (sparseArray5.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.lpC.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.da(view);
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
                                                                NewSubPbActivity.this.OL((String) tag);
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
                                                            if (NewSubPbActivity.this.lpA != null) {
                                                                TiebaStatic.log(new aq("c13700").dK("tid", NewSubPbActivity.this.lpA.dfP()).dK("fid", NewSubPbActivity.this.lpA.getFromForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dK("post_id", postData.getId()).aj("obj_type", 3));
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
                                                        ((PostData) sparseArray8.get(R.id.tag_clip_board)).fS(NewSubPbActivity.this.getPageContext().getPageActivity());
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
                                            NewSubPbActivity.this.lpC.dir();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.OL(str4);
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
                                            NewSubPbActivity.this.lpC.dir();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.dj(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.lpC.dir();
                                    SparseArray sparseArray10 = (SparseArray) view.getTag();
                                    if (sparseArray10 != null) {
                                        NewSubPbActivity.this.lpC.a(((Integer) sparseArray10.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray10.get(R.id.tag_del_post_id), ((Integer) sparseArray10.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new aq("c11739").aj("obj_locate", 2));
                                    NewSubPbActivity.this.lpC.dir();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.lpA.dkl() != null) {
                                        NewSubPbActivity.this.n(NewSubPbActivity.this.lpA.dkl().ddq());
                                    }
                                }
                            } else {
                                try {
                                    sparseArray3 = (SparseArray) view.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                }
                                if (sparseArray3 != null && ((PostData) sparseArray3.get(R.id.tag_clip_board)) != null) {
                                    if (NewSubPbActivity.this.lpD == null) {
                                        NewSubPbActivity.this.lpD = new ah(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aXk);
                                        NewSubPbActivity.this.lpC.dk(NewSubPbActivity.this.lpD.getView());
                                        NewSubPbActivity.this.lpD.tY(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.lpD.Pd();
                                    if (NewSubPbActivity.this.tJ(sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin()) {
                                        z2 = true;
                                    }
                                    NewSubPbActivity.this.lpD.a(sparseArray3, NewSubPbActivity.this.dcP(), z2);
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.lpC.djN();
                            NewSubPbActivity.this.lpC.djO();
                            if (NewSubPbActivity.this.kdj != null) {
                                NewSubPbActivity.this.kdj.bwo();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.deM();
                        if (NewSubPbActivity.this.lpA != null && NewSubPbActivity.this.lpA.dkl() != null && NewSubPbActivity.this.lpA.dkl().bfG() != null && NewSubPbActivity.this.lpA.dkl().bfG().bih() != null) {
                            TiebaStatic.log(new aq("c13402").dK("tid", NewSubPbActivity.this.lpA.dfO()).u("fid", NewSubPbActivity.this.lpA.dkl().bfG().getFid()).aj("obj_locate", 5).dK("uid", NewSubPbActivity.this.lpA.dkl().bfG().bih().getUserId()));
                        }
                    }
                }
            }
        };
        this.lpE = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.lpC.dir();
                    if (NewSubPbActivity.this.kWQ != 2 && NewSubPbActivity.this.kWQ != 1) {
                        NewSubPbActivity.this.lpC.dki();
                    }
                }
                NewSubPbActivity.this.kdj.bwn();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.lpC.dke();
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
                if (NewSubPbActivity.this.lpC != null && NewSubPbActivity.this.lpC.djV()) {
                    return false;
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null && NewSubPbActivity.this.db(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.lbN = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.lbO = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.lbN == null || TextUtils.isEmpty(NewSubPbActivity.this.lbO)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lbP = null;
                        } else {
                            NewSubPbActivity.this.lbP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.lbN = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.lbO = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lbP = null;
                        } else {
                            NewSubPbActivity.this.lbP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.lbN = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.lbO = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lbP = null;
                        } else {
                            NewSubPbActivity.this.lbP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        NewSubPbActivity.this.lpC.a(NewSubPbActivity.this.lcC, NewSubPbActivity.this.lbN.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.jsr = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.jsr == null || NewSubPbActivity.this.lbp == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.lbp != null) {
                            NewSubPbActivity.this.lbp.hU(NewSubPbActivity.this.lpA.dks());
                        }
                        boolean z2 = NewSubPbActivity.this.lbp.bec() && NewSubPbActivity.this.jsr.getId() != null && NewSubPbActivity.this.jsr.getId().equals(NewSubPbActivity.this.lpA.dku());
                        if (NewSubPbActivity.this.lpD == null) {
                            NewSubPbActivity.this.lpD = new ah(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aXk);
                            NewSubPbActivity.this.lpC.dk(NewSubPbActivity.this.lpD.getView());
                            NewSubPbActivity.this.lpD.tY(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.lpD.Pd();
                        boolean z3 = NewSubPbActivity.this.tJ(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z4 = (NewSubPbActivity.this.lpA.dkl() == null || NewSubPbActivity.this.lpA.dkl().bfG() == null || !NewSubPbActivity.this.lpA.dkl().bfG().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z2) {
                            NewSubPbActivity.this.lpD.dgN().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.lpD.dgN().setText(R.string.mark);
                        }
                        if (booleanValue || z4) {
                            NewSubPbActivity.this.lpD.dgN().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.lpD.dgN().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.db(view)) {
                            if (NewSubPbActivity.this.lbN != null && !NewSubPbActivity.this.lbN.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        ah ahVar = NewSubPbActivity.this.lpD;
                        int dcP = NewSubPbActivity.this.dcP();
                        if (NewSubPbActivity.this.kYN && NewSubPbActivity.this.jsr.mFf) {
                            z = true;
                        }
                        ahVar.a(sparseArray2, dcP, z3, z);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.lpF = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
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
                        p dkl = NewSubPbActivity.this.lpA.dkl();
                        TbRichText bw = NewSubPbActivity.this.bw(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bw != null && bw.bBq() != null) {
                            tbRichTextData = bw.bBq().get(NewSubPbActivity.this.lcz);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!tbRichTextData.bBw().bBK()) {
                                String c = NewSubPbActivity.this.c(tbRichTextData);
                                arrayList.add(c);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap.put(c, imageUrlData);
                                String str5 = null;
                                String str6 = null;
                                String str7 = null;
                                if (dkl == null) {
                                    str4 = null;
                                    z4 = false;
                                } else {
                                    if (dkl.bwh() != null) {
                                        str5 = dkl.bwh().getName();
                                        str6 = dkl.bwh().getId();
                                    }
                                    if (dkl.bfG() != null) {
                                        str7 = dkl.bfG().getId();
                                    }
                                    str4 = str7;
                                    z4 = true;
                                }
                                if (NewSubPbActivity.this.lpA.dkz() != null) {
                                    concurrentHashMap = NewSubPbActivity.this.lpA.dkz();
                                    z4 = NewSubPbActivity.this.lpA.dkB();
                                    arrayList = NewSubPbActivity.this.lpA.dkA();
                                }
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(y.getItem(arrayList, 0));
                                ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                                aVar.x(arrayList2).zX(str5).zY(str6).zZ(str4).ib(z4).Aa(arrayList.get(0)).ic(true).a(concurrentHashMap).id(true).ie(false).m36if(false).s(NewSubPbActivity.this.bfG()).Ab(String.valueOf(bw.getPostId())).Ac(NewSubPbActivity.this.lpA.getFromForumId());
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar.dU(NewSubPbActivity.this.getPageContext().getPageActivity())));
                                return;
                            }
                            NewSubPbActivity.this.lcA = false;
                            TbRichText dEr = dkl.ddq().dEr();
                            int size = arrayList.size();
                            int a2 = NewSubPbActivity.this.a(dEr, bw, i, i, arrayList, concurrentHashMap);
                            int size2 = arrayList.size();
                            if (size == size2) {
                                str2 = "";
                            } else {
                                str2 = arrayList.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (dkl == null) {
                                str3 = null;
                                z3 = false;
                            } else {
                                if (dkl.bwh() != null) {
                                    str8 = dkl.bwh().getName();
                                    str9 = dkl.bwh().getId();
                                }
                                if (dkl.bfG() != null) {
                                    str10 = dkl.bfG().getId();
                                }
                                str3 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.lpA.dkz() != null) {
                                concurrentHashMap = NewSubPbActivity.this.lpA.dkz();
                                z3 = NewSubPbActivity.this.lpA.dkB();
                                arrayList = NewSubPbActivity.this.lpA.dkA();
                                a2 += NewSubPbActivity.this.lpA.getOffset();
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(y.getItem(arrayList, a2));
                            ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                            aVar2.x(arrayList3).zX(str8).zY(str9).zZ(str3).ib(z3).Aa(str2).ic(true).a(concurrentHashMap).id(true).ie(false).m36if(false).s(NewSubPbActivity.this.bfG()).Ab(String.valueOf(bw.getPostId())).Ac(NewSubPbActivity.this.lpA.getFromForumId());
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
    public bw bfG() {
        if (this.lpA == null || this.lpA.dkl() == null) {
            return null;
        }
        return this.lpA.dkl().bfG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da(View view) {
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
            if (postData.bih() != null) {
                MetaData bih = postData.bih();
                this.kdj.setReplyId(bih.getUserId());
                boolean z2 = postData.mFf;
                String str = "";
                if (postData.dEr() != null) {
                    str = postData.dEr().toString();
                }
                this.kdj.Dp(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bih().getName_show(), str));
                if (z2) {
                    if (!z) {
                        this.kdj.Do("");
                    }
                } else if (!z) {
                    this.kdj.Do(bih.getName_show());
                }
            }
            this.lpC.djO();
        }
        if (this.lpO) {
            uL(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eCW == null) {
                this.eCW = new com.baidu.tbadk.core.message.a();
            }
            if (this.eCG == null) {
                this.eCG = new e();
                this.eCG.uniqueId = this.lpQ;
            }
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.ela = 12;
            cVar.elg = 9;
            cVar.elf = 3;
            if (djM() != null) {
                cVar.ele = djM().dkD();
            }
            if (cVar != null) {
                cVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (cVar != null) {
                        cVar.elh = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (cVar != null) {
                        cVar.elh = 1;
                        i = 0;
                    }
                }
                this.eCW.a(agreeData, i, getUniqueId(), false);
                this.eCW.a(agreeData, this.eCG);
                if (djM() == null && djM().dkl() != null) {
                    this.eCW.a(this, cVar, agreeData, djM().dkl().bfG());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (cVar != null) {
                cVar.elh = 1;
            }
            i = 0;
            this.eCW.a(agreeData, i, getUniqueId(), false);
            this.eCW.a(agreeData, this.eCG);
            if (djM() == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bBw;
        if (tbRichText == tbRichText2) {
            this.lcA = true;
        }
        if (tbRichText != null && tbRichText.bBq() != null) {
            int size = tbRichText.bBq().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.bBq().get(i6) != null && tbRichText.bBq().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.bBq().get(i6).bBw().getWidth() * equipmentDensity;
                    int height = tbRichText.bBq().get(i6).bBw().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.bBq().get(i6).bBw().bBK()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.bBq().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (bBw = tbRichTextData.bBw()) != null) {
                            String bBM = bBw.bBM();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = bBM;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.lcA) {
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
        if (this.lpD != null) {
            this.lpD.tY(z);
        }
        if (this.lpC != null) {
            this.lpC.tY(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bBw = tbRichTextData.bBw();
        if (bBw != null) {
            if (!StringUtils.isNull(bBw.bBJ())) {
                return bBw.bBJ();
            }
            if (bBw.getHeight() * bBw.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bBw.getHeight() * bBw.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bBw.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bBw.getHeight())));
            } else {
                float width = bBw.getWidth() / bBw.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(at.getUrlEncode(bBw.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bw(String str, int i) {
        if (this.lpA == null || this.lpA.dkl() == null || str == null || i < 0) {
            return null;
        }
        p dkl = this.lpA.dkl();
        TbRichText a2 = a(dkl.ddq(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(dkl.ddq(), str, i);
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
        TbRichText dEr = postData.dEr();
        if (dEr != null) {
            ArrayList<TbRichTextData> bBq = dEr.bBq();
            int size = bBq.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (bBq.get(i3) != null && bBq.get(i3).getType() == 8) {
                    i2++;
                    if (bBq.get(i3).bBw().bBM().equals(str)) {
                        int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = bBq.get(i3).bBw().getWidth() * equipmentDensity;
                        int height = bBq.get(i3).bBw().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.lcz = i3;
                        return dEr;
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
    public void deM() {
        Intent intent = getIntent();
        if (intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false) {
            if (this.kdd == null || this.lpA == null || this.lpA.crF() == null || this.kdd.oy(this.lpA.crF().replyPrivateFlag)) {
                if (this.kdj.bwb()) {
                    this.kdj.a((PostWriteCallBackData) null);
                    return;
                }
                this.lpC.djN();
                this.lpC.djO();
                if (this.kdj != null) {
                    this.kdj.bwq();
                    return;
                }
                return;
            }
            return;
        }
        if (this.itr == null) {
            this.itr = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.itr.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void ph(boolean z) {
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
                public void pi(boolean z) {
                    String str;
                    if (z) {
                        if (NewSubPbActivity.this.kdd == null || NewSubPbActivity.this.lpA == null || NewSubPbActivity.this.lpA.crF() == null || NewSubPbActivity.this.kdd.oy(NewSubPbActivity.this.lpA.crF().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.lpA != null && NewSubPbActivity.this.lpA.dkl() != null && NewSubPbActivity.this.lpA.dkl().ddq() != null) {
                                PostData ddq = NewSubPbActivity.this.lpA.dkl().ddq();
                                if (ddq.dEr() != null && ddq.bih() != null) {
                                    str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), ddq.bih().getName_show(), ddq.dEr().toString());
                                    NewSubPbActivity.this.kdj.bvf().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                                    if (!NewSubPbActivity.this.kdj.bwb()) {
                                        NewSubPbActivity.this.kdj.a((PostWriteCallBackData) null);
                                        return;
                                    }
                                    NewSubPbActivity.this.lpC.djN();
                                    NewSubPbActivity.this.lpC.djO();
                                    if (NewSubPbActivity.this.kdj != null) {
                                        NewSubPbActivity.this.kdj.bwq();
                                        return;
                                    }
                                    return;
                                }
                            }
                            str = null;
                            NewSubPbActivity.this.kdj.bvf().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                            if (!NewSubPbActivity.this.kdj.bwb()) {
                            }
                        }
                    }
                }
            });
        }
        if (this.lpA != null && this.lpA.dkl() != null && this.lpA.dkl().bwh() != null) {
            this.itr.D(this.lpA.dkl().bwh().getId(), com.baidu.adp.lib.f.b.toLong(this.lpA.dfO(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tJ(boolean z) {
        if (this.lpA == null) {
            return false;
        }
        return ((dcP() != 0) || this.lpA.dkl() == null || this.lpA.dkl().bfG() == null || this.lpA.dkl().bfG().bih() == null || this.lpA.dkl().bfG().bgR() || TextUtils.equals(this.lpA.dkl().bfG().bih().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bH(int i, String str) {
        if (this.lpA.dkm()) {
            showToast(str);
        } else if (l.isNetOk()) {
            if (i == 4) {
                this.lpC.Id(str + "(4)");
            } else {
                this.lpC.Ck(R.string.no_data_text);
            }
        } else {
            this.lpC.Ck(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(boolean z) {
        this.kdj = (h) new com.baidu.tbadk.editortools.pb.i(z).ei(getActivity());
        if (this.kdj != null) {
            this.kdj.a(getPageContext());
            this.kdj.b(this.lpA);
            this.kdj.b(this.jrQ);
            this.kdj.setFrom(2);
            this.kdj.a(this.fby);
            this.kdj.a(this.fbz);
            this.kdj.bvf().jF(true);
            this.kdj.j(getPageContext());
        }
        if (this.lpC != null) {
            this.lpC.i(this.kdj);
        }
        if (this.kdj != null && this.lpA != null) {
            this.kdj.a(this.lpA.crF());
            this.kdj.bwn();
        }
        if (this.kdj != null) {
            this.kdj.bwr().setDefaultHint(dhF());
            this.kdj.bwr().setHint(dhF());
            this.jrK = this.kdj.bwr().getInputView();
            this.jrK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.jrJ != null) {
                        if (!NewSubPbActivity.this.jrJ.dNm()) {
                            NewSubPbActivity.this.qG(false);
                        }
                        NewSubPbActivity.this.jrJ.xQ(false);
                    }
                }
            });
        }
    }

    public void djK() {
        if (!TbadkCoreApplication.isLogin()) {
            this.kdj.bwn();
        } else if (!StringUtils.isNull(this.lpA.dkv())) {
            if (this.lpC.djR() && l.isNetOk()) {
                this.lpC.cpD();
            } else {
                this.lpC.djU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dj(View view) {
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
                    this.lpC.dg(view);
                }
            } else if (booleanValue2) {
                this.lpC.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.lpC.dkb(), getPageContext().getPageActivity());
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
            bVar.og(R.string.operation);
            bVar.a(strArr, new b.InterfaceC0550b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0550b
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.lpL);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.lpL);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).bkL();
        }
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.lpC.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.lpL;
        userMuteCheckCustomMessage.setTag(this.lpL);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.lpC.a(0, bVar.QO, bVar.mGW, z);
            if (bVar.QO) {
                if (bVar.hVJ == 1) {
                    if (this.lpC.getListView() instanceof BdTypeListView) {
                        List<q> data = ((BdTypeListView) this.lpC.getListView()).getData();
                        if (!y.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.lpC.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.hVJ == 2) {
                    this.lpA.Pq(bVar.mPostId);
                    this.lpC.a(this.lpA.dkl(), this.lpA.dcP(), this.lpA.dkz() != null, false);
                    if (this.lpA.dkw()) {
                        this.lpA.uP(false);
                        this.lpC.djP();
                        this.lpA.loadData();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void OL(String str) {
        if (this.lpA != null && this.lpA.dkl() != null && this.lpA.dkl().bfG() != null && this.lpA.dkl().bfG().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lpA.dfO(), str);
            bw bfG = this.lpA.dkl().bfG();
            if (bfG.bgP()) {
                format = format + "&channelid=33833";
            } else if (bfG.bkb()) {
                format = format + "&channelid=33842";
            } else if (bfG.bgQ()) {
                format = format + "&channelid=33840";
            }
            OM(format);
            return;
        }
        this.lbo.Pm(str);
    }

    private void OM(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void n(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.lpA.dks() && postData.getId() != null && postData.getId().equals(this.lpA.dku())) {
                z = true;
            }
            MarkData o = this.lpA.o(postData);
            if (o != null) {
                this.lpC.dir();
                if (this.lbp != null) {
                    this.lbp.a(o);
                    if (!z) {
                        this.lbp.bee();
                    } else {
                        this.lbp.bed();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.lpA != null) {
            this.lpA.aC(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.kdj != null) {
            this.kdj.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.kdj.bvf().btC();
        this.kdj.bwn();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.kdj.b(writeData);
                this.kdj.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.m qP = this.kdj.bvf().qP(6);
                if (qP != null && qP.eYZ != null) {
                    qP.eYZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.kdj.bwj();
                }
                this.lpC.dki();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.ioV != null) {
            this.ioV.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.mIsPaused = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.bbM().bbX();
        if (this.ioV != null) {
            this.ioV.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.jEs);
        this.lpC.czS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.mIsPaused = false;
        super.onResume();
        dfr();
        if (this.ioV != null) {
            this.ioV.onResume(getPageContext());
        }
        registerListener(this.jEs);
        this.lpC.czT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ioV != null) {
            this.ioV.onStop(getPageContext());
        }
        this.kdj.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.lpN));
        this.lpA.cancelLoadData();
        this.lpA.destory();
        this.lpB.cancelLoadData();
        if (this.ioV != null) {
            this.ioV.onDestory(getPageContext());
        }
        this.lpC.dir();
        this.lpC.cyd();
        MessageManager.getInstance().unRegisterListener(this.lck);
        MessageManager.getInstance().unRegisterListener(this.lcl);
        MessageManager.getInstance().unRegisterListener(this.lcm);
        MessageManager.getInstance().unRegisterListener(this.lpL);
        this.lbJ = null;
        this.lbK = null;
        if (this.kdd != null) {
            this.kdd.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lpC.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.ioV;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View djW = this.lpC.djW();
        if (djW == null || (findViewWithTag = djW.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean Pe(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = be.getParamPair(be.getParamStr(str))) != null) {
            this.lpM = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Pe(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(lpz);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (Pe(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                    lVar.mLink = str;
                    lVar.type = 3;
                    lVar.eXY = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
                }
            } else {
                be.bmY().b(getPageContext(), new String[]{str});
            }
            this.lpM = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aw(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.lpM = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ax(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ay(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void az(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void u(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView getListView() {
        if (this.lpC != null) {
            return this.lpC.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int bCb() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> bCd() {
        if (this.fuR == null) {
            this.fuR = TbRichTextView.A(getPageContext().getPageActivity(), 8);
        }
        return this.fuR;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> bCe() {
        if (this.frz == null) {
            this.frz = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cnk */
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
        return this.frz;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> bCc() {
        if (this.fry == null) {
            this.fry = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bCo */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = k.bfo().isShowImages();
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
                        if (k.bfo().isShowImages()) {
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
        return this.fry;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> bCf() {
        if (this.fuS == null) {
            this.fuS = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dfy */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(NewSubPbActivity.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dc */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dd */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: de */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fuS;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> bCg() {
        if (this.fuT == null) {
            this.fuT = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dfA */
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
        return this.fuT;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> bCh() {
        this.fuU = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dfz */
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
        return this.fuU;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a ddF() {
        return this.kXu;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean ddG() {
        return (this.lpA == null || this.lpA.dkl() == null || this.lpA.dkl().bfG() == null || this.lpA.dkl().bfG().bjE()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String ddH() {
        if (this.lpA == null || this.lpA.dkl() == null || this.lpA.dkl().bfG() == null) {
            return null;
        }
        return this.lpA.dkl().bfG().bil();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int ddI() {
        if (this.lpA == null) {
            return 0;
        }
        return this.lpA.dcP();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean OF(String str) {
        if (StringUtils.isNull(str) || this.lpA == null || this.lpA.dkl() == null || this.lpA.dkl().bfG() == null || this.lpA.dkl().bfG().bih() == null) {
            return false;
        }
        return str.equals(this.lpA.dkl().bfG().bih().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.lpC.djR() && l.isNetOk()) {
            this.lpA.loadData();
        } else {
            this.lpC.djU();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.lpL);
        userMuteAddAndDelCustomMessage.setTag(this.lpL);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Po(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.blO().getString("bubble_link", "");
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
    public void aA(Context context, String str) {
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
                return com.baidu.tbadk.m.e.bxO().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.lpA != null) {
            if (this.lpA.dkl() != null && this.lpA.dkl().bwh() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.lpA.dkl().bwh().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.lpA.dfO(), 0L));
            if (this.lpA.dkl() != null && this.lpA.dkl().bfG() != null) {
                pageStayDurationItem.setNid(this.lpA.dkl().bfG().getNid());
            }
            pageStayDurationItem.setPid(com.baidu.adp.lib.f.b.toLong(this.lpA.bvH(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public boolean djL() {
        if (this.lpA != null) {
            return this.lpA.djL();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.lpC.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lbJ.getPageActivity());
        if (at.isEmpty(str)) {
            aVar.AH(this.lbJ.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.AH(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.lpC.showLoadingDialog();
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
        aVar.b(this.lbJ).bkJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dm(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lbJ.getPageActivity());
        aVar.AH(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lbJ).bkJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfn() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.AH(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.lbJ).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.lbJ.getPageActivity(), 2, true, 4);
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
        aVar.b(this.lbJ).bkJ();
    }

    public SubPbModel djM() {
        return this.lpA;
    }

    public int dcP() {
        if (this.lpA != null) {
            return this.lpA.dcP();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eZv && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eZv && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void qG(boolean z) {
        if (this.jrK != null && this.jrK.getText() != null) {
            int selectionEnd = this.jrK.getSelectionEnd();
            SpannableStringBuilder c = this.jrJ.c(this.jrK.getText());
            if (c != null) {
                this.jrJ.xQ(true);
                this.jrK.setText(c);
                if (z && this.jrJ.dNk() >= 0) {
                    this.jrK.requestFocus();
                    this.jrK.setSelection(this.jrJ.dNk());
                } else {
                    this.jrK.setSelection(selectionEnd);
                }
                this.jrJ.xP(this.jrJ.dNk() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kdj != null && this.kdj.bvf() != null && this.kdj.bvf().bvj()) {
            this.kdj.bvf().btC();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(t tVar) {
        ag.a(tVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    public String dhF() {
        if (!at.isEmpty(this.lkj)) {
            return this.lkj;
        }
        this.lkj = getResources().getString(com.baidu.tieba.pb.pb.main.ay.dhu());
        return this.lkj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.lpO = z;
        uL(true);
    }

    private void uL(boolean z) {
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
        if (this.lpC != null && this.lpC.getListView() != null && this.lpP != null && this.lpP.mPosition != -1) {
            final int headerViewsCount = this.lpP.mPosition + this.lpC.getListView().getHeaderViewsCount();
            if (this.lpP.getView() != null) {
                final int height = this.lpP.getView().getHeight();
                final int height2 = ((rect.height() - this.lpC.dkh()) - this.lpC.getNavigationBarHeight()) - this.lpC.dkg();
                final int i = height - height2;
                if (i > 0) {
                    this.lpC.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.lpC != null && NewSubPbActivity.this.lpC.getListView() != null) {
                                NewSubPbActivity.this.lpC.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.lpC.getNavigationBarHeight() - i);
                            }
                        }
                    });
                } else {
                    this.lpC.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.lpC != null && NewSubPbActivity.this.lpC.getListView() != null) {
                                NewSubPbActivity.this.lpC.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.lpC.getNavigationBarHeight() + (height2 - height));
                            }
                        }
                    });
                }
            }
        }
    }

    private void dfr() {
        if (this.lpA != null && !at.isEmpty(this.lpA.dfO())) {
            com.baidu.tbadk.BdToken.c.bbM().q(com.baidu.tbadk.BdToken.b.ebN, com.baidu.adp.lib.f.b.toLong(this.lpA.dfO(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.lpA == null || at.isEmpty(this.lpA.dfO())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.lpA.dfO(), 0L);
    }
}
