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
import com.baidu.adp.base.f;
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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.WriteTipBubbleController;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.n;
import com.baidu.tbadk.editortools.m;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.i;
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
import com.baidu.tbadk.widget.richText.h;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.pb.data.q;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.main.ao;
import com.baidu.tieba.pb.pb.main.at;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.e;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
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
/* loaded from: classes2.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, h, com.baidu.tieba.pb.pb.a<NewSubPbActivity> {
    private static String mfU = "tbgametype";
    private View.OnClickListener bbI;
    private at eIQ;
    private com.baidu.adp.lib.d.b<ImageView> fUl;
    private com.baidu.adp.lib.d.b<GifView> fUm;
    private com.baidu.adp.lib.d.b<TextView> fXB;
    private com.baidu.adp.lib.d.b<View> fXC;
    private com.baidu.adp.lib.d.b<LinearLayout> fXD;
    private com.baidu.adp.lib.d.b<RelativeLayout> fXE;
    private com.baidu.tbadk.core.message.a feF;
    private e fep;
    private VoiceManager jgg;
    private com.baidu.tieba.frs.profession.permission.c jkC;
    public am kSl;
    private com.baidu.tbadk.editortools.pb.h kSr;
    private com.baidu.tieba.write.c kpk;
    private EditText kpl;
    private com.baidu.tieba.pb.pb.main.b.a lNj;
    private boolean lNo;
    private com.baidu.tieba.pb.pb.report.a lRA;
    private com.baidu.tbadk.baseEditMark.a lRB;
    private f lRV;
    private com.baidu.tbadk.core.view.c lRW;
    private com.baidu.adp.widget.ImageView.a lRZ;
    private String lSa;
    private TbRichTextMemeInfo lSb;
    private PostWriteCallBackData lTH;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private String may;
    private SubPbModel mfV;
    private ForumManageModel mfW;
    private com.baidu.tieba.pb.pb.sub.a mfX;
    private aa mfY;
    private AbsListView.OnScrollListener mfZ;
    private TbRichTextView.i mga;
    private SubPbModel.a mgb;
    private com.baidu.adp.base.e mgc;
    private BdUniqueId mgg;
    private com.baidu.tieba.pb.e<q> mgi;
    private boolean mgj;
    private PbCommenFloorItemViewHolder mgk;
    private boolean mIsFromCDN = true;
    private int lSL = 0;
    PostData kpS = null;
    private a.InterfaceC0554a lSH = null;
    private a mgd = null;
    private a mge = null;
    private boolean mIsPaused = false;
    private boolean mgf = false;
    private boolean mgh = false;
    private boolean fBK = false;
    private com.baidu.tbadk.editortools.pb.c fDO = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bBM() {
            NewSubPbActivity.this.mfX.dsH();
        }
    };
    private int lMF = 0;
    private boolean mIsFromSchema = false;
    private BdUniqueId mgl = BdUniqueId.gen();
    private boolean lRy = com.baidu.tbadk.a.d.biY();
    private boolean mgm = true;
    private com.baidu.tbadk.editortools.pb.b fDP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBL() {
            if (!NewSubPbActivity.this.kpk.dWp()) {
                return (NewSubPbActivity.this.kSl == null || NewSubPbActivity.this.mfV == null || NewSubPbActivity.this.mfV.cBs() == null || NewSubPbActivity.this.kSl.aK(NewSubPbActivity.this.mfV.cBs().replyPrivateFlag, am.faB)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.kpk.dWr());
            if (NewSubPbActivity.this.kSr.bCd()) {
                NewSubPbActivity.this.kSr.a(NewSubPbActivity.this.lTH);
            }
            NewSubPbActivity.this.ss(true);
            return true;
        }
    };
    private CustomMessageListener mgn = new CustomMessageListener(2921481) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && NewSubPbActivity.this.mfV != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && au.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), NewSubPbActivity.this.mfV.dot())) {
                if (NewSubPbActivity.this.kpk != null) {
                    NewSubPbActivity.this.kpk.UV(null);
                    NewSubPbActivity.this.kpk.bg(null);
                    NewSubPbActivity.this.kpk.zt(false);
                }
                if (NewSubPbActivity.this.kSr != null) {
                    NewSubPbActivity.this.kSr.bCo();
                    NewSubPbActivity.this.kSr.reset();
                }
                NewSubPbActivity.this.mfV.bBI();
            }
        }
    };
    private NewWriteModel.d kpr = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.kSr != null && NewSubPbActivity.this.kSr.bBh() != null) {
                NewSubPbActivity.this.kSr.bBh().hide();
                if (NewSubPbActivity.this.mfV.dth()) {
                    TiebaStatic.log(new ar("c10367").dR("post_id", NewSubPbActivity.this.mfV.bBJ()));
                }
            }
            if (z) {
                NewSubPbActivity.this.kpk.UV(null);
                NewSubPbActivity.this.kpk.bg(null);
                NewSubPbActivity.this.kpk.zt(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(NewSubPbActivity.this.getPageContext(), postWriteCallBackData);
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.kpk.bg(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.kpk.UV(postWriteCallBackData.getErrorString());
                if (!y.isEmpty(NewSubPbActivity.this.kpk.dWn())) {
                    NewSubPbActivity.this.lTH = postWriteCallBackData;
                    if (NewSubPbActivity.this.kSr.bCd()) {
                        NewSubPbActivity.this.kSr.a(NewSubPbActivity.this.lTH);
                    }
                    NewSubPbActivity.this.ss(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(NewSubPbActivity.this.getActivity(), NewSubPbActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(NewSubPbActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(NewSubPbActivity.this.getActivity());
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Au(NewSubPbActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Au(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new ar("c13746").ap("obj_locate", 1).ap("obj_type", 2));
                    }
                });
                aVar.b(NewSubPbActivity.this.getPageContext()).bqx();
                TiebaStatic.log(new ar("c13745").ap("obj_locate", 1).ap("obj_type", 2));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.kSl != null) {
                NewSubPbActivity.this.kSl.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.mfX.dsI();
        }
    };
    private CustomMessageListener lSw = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.mgg) {
                NewSubPbActivity.this.mfX.ckq();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.lRW.showSuccessToast(NewSubPbActivity.this.lRV.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.lRV.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.Dc(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.dnS();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (au.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.lRV.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.lRW.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lSx = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.mgg) {
                NewSubPbActivity.this.mfX.ckq();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.lRW.showSuccessToast(NewSubPbActivity.this.lRV.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (au.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.lRV.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.lRW.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener lSy = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.mgg) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.mfX.ckq();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.nJZ;
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
                    NewSubPbActivity.this.mfX.a(sparseArray, z);
                }
            }
        }
    };
    private final f.c gHl = new f.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (NewSubPbActivity.this.mfV != null) {
                NewSubPbActivity.this.mfV.dtf();
            }
        }
    };
    boolean lSM = false;
    private final b.InterfaceC0558b lSO = new b.InterfaceC0558b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0558b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.lRZ != null && !TextUtils.isEmpty(NewSubPbActivity.this.lSa)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.lSb == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.lSa));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.lSa;
                        aVar.pkgId = NewSubPbActivity.this.lSb.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.lSb.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.eIQ == null) {
                            NewSubPbActivity.this.eIQ = new at(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.eIQ.p(NewSubPbActivity.this.lSa, NewSubPbActivity.this.lRZ.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.lRZ = null;
                NewSubPbActivity.this.lSa = null;
            }
        }
    };
    private CustomMessageListener juD = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener jhN = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    n nVar = (n) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.mfV.dsZ() != null && NewSubPbActivity.this.mfV.dsZ().dlR() != null && NewSubPbActivity.this.mfV.dsZ().dlR().bnQ() != null && currentAccount.equals(NewSubPbActivity.this.mfV.dsZ().dlR().bnQ().getUserId()) && NewSubPbActivity.this.mfV.dsZ().dlR().bnQ().getPendantData() != null) {
                        NewSubPbActivity.this.mfV.dsZ().dlR().bnQ().getPendantData().Ad(nVar.getImgUrl());
                        NewSubPbActivity.this.mfV.dsZ().dlR().bnQ().getPendantData().ek(nVar.bAG());
                        NewSubPbActivity.this.mfX.a(NewSubPbActivity.this.mfV.dsZ(), NewSubPbActivity.this.mfV.dsZ().dlR(), NewSubPbActivity.this.mfV.dsZ().Xg(), NewSubPbActivity.this.mfV.dsZ().bjZ(), NewSubPbActivity.this.mfV.dlo(), NewSubPbActivity.this.mfV.dtn() != null);
                    }
                }
            }
        }
    };

    /* loaded from: classes2.dex */
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
        this.lRV = getPageContext();
        this.mgf = true;
        this.kpk = new com.baidu.tieba.write.c();
        this.kpk.Ld(R.color.cp_cont_h_alpha85);
        this.kpk.Lc(R.color.CAM_X0101);
        bZe();
        dsx();
        initData(bundle);
        initUI();
        ((SubPbView) this.mfX.getRootView()).show();
        ts(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mfX.wf(this.mIsFromSchema);
        this.lRW = new com.baidu.tbadk.core.view.c();
        this.lRW.toastTime = 1000L;
        registerListener(this.lSy);
        registerListener(this.lSw);
        registerListener(this.lSx);
        registerListener(this.mgn);
        this.mgg = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.mgg;
        userMuteAddAndDelCustomMessage.setTag(this.mgg);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.mgg;
        userMuteCheckCustomMessage.setTag(this.mgg);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.kSl = new am(getPageContext());
        this.kSl.a(new am.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.40
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.kSr.bCm();
                }
            }
        });
        this.lRA = new com.baidu.tieba.pb.pb.report.a(this);
        this.lRA.x(getUniqueId());
        this.lNj = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.mfX = new com.baidu.tieba.pb.pb.sub.a(this, this.bbI);
        this.mfX.a(this.mfV);
        setContentView(this.mfX.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.mfX.setOnScrollListener(this.mfZ);
        this.mfX.b(this);
        this.mfX.setOnImageClickListener(this.mga);
        this.mfX.setOnLongClickListener(this.mOnLongClickListener);
        this.mfX.h(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.mfV != null) {
                    NewSubPbActivity.this.mfV.loadData();
                }
            }
        });
        this.mfX.a(this.mgd);
        this.mfX.b(this.mge);
        this.mfX.setListPullRefreshListener(this.gHl);
        if (this.mfV != null && this.mfV.dsz() && !this.mfV.dtm()) {
            this.mfX.dsN().setVisibility(8);
        } else {
            this.mfX.dsN().setVisibility(0);
        }
        if (this.mfV != null && !this.mfV.dsz()) {
            this.mfX.setIsFromPb(false);
        }
    }

    private boolean aE(Bundle bundle) {
        if (bundle != null) {
            this.fBK = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.fBK = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.fBK;
    }

    public void initData(Bundle bundle) {
        this.mfV = new SubPbModel(getPageContext());
        this.mfV.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                NewSubPbActivity.this.mfX.v(postData);
                NewSubPbActivity.this.mfX.b((BdListView.e) null);
            }
        });
        this.mfW = new ForumManageModel(getPageContext());
        this.mfW.setLoadDataCallBack(this.mgc);
        this.jgg = new VoiceManager();
        this.jgg.onCreate(getPageContext());
        this.lRB = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.lRB != null) {
            this.lRB.a(this.lSH);
        }
        if (bundle != null) {
            this.mfV.initWithBundle(bundle);
        } else {
            this.mfV.initWithIntent(getIntent());
        }
        this.mfV.a(this.mgb);
        if (this.mfV.dsz() && !this.mfV.dts()) {
            this.mfV.loadData();
        } else if (!TextUtils.isEmpty(getIntent().getStringExtra("key_open_editor_tips"))) {
            this.mfV.loadData();
        } else {
            this.mfV.dte();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final com.baidu.tbadk.editortools.pb.h hVar, String str) {
        new WriteTipBubbleController(getPageContext(), new WriteTipBubbleController.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.a
            public void g(View view2, String str2) {
                view.performClick();
                hVar.bCo();
                hVar.bCu().getInputView().setText(str2);
                Editable text = hVar.bCu().getInputView().getText();
                if (!TextUtils.isEmpty(text)) {
                    hVar.bCu().getInputView().setSelection(text.length());
                }
            }
        }).a(view, getString(R.string.open_editor_tips), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
    }

    public void dsx() {
        this.mgb = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, final q qVar) {
                if (NewSubPbActivity.this.mfX != null) {
                    NewSubPbActivity.this.mfX.dsI();
                    if (!z) {
                        NewSubPbActivity.this.bR(i, str);
                        return;
                    }
                    NewSubPbActivity.this.mfX.hideNoDataView();
                    if (qVar != null) {
                        if (qVar.dlR() != null || NewSubPbActivity.this.mfV != null) {
                            qVar.dlR().a(NewSubPbActivity.this.mfV.dtl());
                        }
                        if (NewSubPbActivity.this.mfX != null) {
                            NewSubPbActivity.this.ts(qVar.bln() != null && qVar.bln().isBjh());
                            if (NewSubPbActivity.this.kSr != null && NewSubPbActivity.this.kSr.bBh() != null) {
                                NewSubPbActivity.this.kSr.bBh().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.mfX.a(qVar, NewSubPbActivity.this.mfV.dlo(), NewSubPbActivity.this.mfV.dtn() != null, NewSubPbActivity.this.mgf);
                            if (NewSubPbActivity.this.mgf) {
                                NewSubPbActivity.this.mfX.getListView().setSelectionFromTop(NewSubPbActivity.this.mfX.getListView().getHeaderViewsCount() + 1, -l.getDimens(NewSubPbActivity.this, R.dimen.tbds18));
                                NewSubPbActivity.this.dsy();
                                NewSubPbActivity.this.mgf = false;
                            }
                        }
                        if (NewSubPbActivity.this.kSr != null) {
                            NewSubPbActivity.this.kSr.a(qVar.cBs());
                            NewSubPbActivity.this.kSr.setThreadData(qVar.bln());
                            if (NewSubPbActivity.this.getIntent() != null && NewSubPbActivity.this.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && NewSubPbActivity.this.mgm) {
                                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        NewSubPbActivity.this.mgm = false;
                                        NewSubPbActivity.this.c(qVar.dlR(), false);
                                    }
                                }, 200L);
                            }
                        }
                        if (NewSubPbActivity.this.mgi == null) {
                            NewSubPbActivity.this.mgi = new com.baidu.tieba.pb.e();
                        }
                        NewSubPbActivity.this.mgi.setData(qVar);
                        NewSubPbActivity.this.mgi.setType(0);
                        NewSubPbActivity.this.kSl.a(NewSubPbActivity.this.mfV.dtq());
                    }
                    String stringExtra = NewSubPbActivity.this.getIntent().getStringExtra("key_open_editor_tips");
                    if (!TextUtils.isEmpty(stringExtra) && !NewSubPbActivity.this.lNo) {
                        NewSubPbActivity.this.lNo = true;
                        NewSubPbActivity.this.a(NewSubPbActivity.this.mfX.cIy(), NewSubPbActivity.this.kSr, stringExtra);
                    }
                }
            }
        };
        this.lSH = new a.InterfaceC0554a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0554a
            public void g(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.lRB != null) {
                        NewSubPbActivity.this.lRB.ja(z2);
                    }
                    MarkData bkc = NewSubPbActivity.this.lRB.bkc();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(bkc);
                        if (NewSubPbActivity.this.lRB != null) {
                            if (bkc != null) {
                                NewSubPbActivity.this.mfV.wh(true);
                                NewSubPbActivity.this.mfV.PZ(NewSubPbActivity.this.mfV.bBJ());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.mfX != null) {
                                NewSubPbActivity.this.mfX.wg(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.mfV.wh(false);
                        NewSubPbActivity.this.mfV.PZ(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.mfX != null) {
                            NewSubPbActivity.this.mfX.wg(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.mgd = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.mfV.dsZ() != null && NewSubPbActivity.this.mfV.dsZ().bln() != null && NewSubPbActivity.this.mfV.dsZ().bln().bnQ() != null) {
                    str = String.valueOf(NewSubPbActivity.this.mfV.dsZ().bln().bnQ().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.mfV.dsZ().bCk().getId(), NewSubPbActivity.this.mfV.dsZ().bCk().getName(), NewSubPbActivity.this.mfV.dsZ().bln().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.mge = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.mfW.dOs() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.mfV != null && NewSubPbActivity.this.mfV.dsZ() != null && NewSubPbActivity.this.mfV.dsZ().bCk() != null && NewSubPbActivity.this.mfV.dsZ().bln() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.mfW.Ts(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.mfW.a(NewSubPbActivity.this.mfV.dsZ().bCk().getId(), NewSubPbActivity.this.mfV.dsZ().bCk().getName(), NewSubPbActivity.this.mfV.dsZ().bln().getId(), valueOf, i2, i, z, NewSubPbActivity.this.mfV.dsZ().bln().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.mgc = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.mfX.a(NewSubPbActivity.this.mfW.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.mfW.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.mhl != 1002 || bVar.hkR) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.mfX.a(1, dVar.mSuccess, dVar.nzx, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean dG(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void bZe() {
        registerListener(this.jhN);
        this.bbI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            /* JADX DEBUG: Multi-variable search result rejected for r2v68, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PostData postData;
                SparseArray sparseArray;
                SparseArray sparseArray2;
                boolean z = true;
                boolean z2 = false;
                SparseArray<Object> sparseArray3 = null;
                if (view != null || NewSubPbActivity.this.mfX != null) {
                    if (view == NewSubPbActivity.this.mfX.dsT()) {
                        NewSubPbActivity.this.mfX.drd();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                bf.bsV().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.mfX.cIy()) {
                        if (view != NewSubPbActivity.this.mfX.dsM()) {
                            if (view == NewSubPbActivity.this.mfX.dsL()) {
                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                    NewSubPbActivity.this.mfX.dsB();
                                    NewSubPbActivity.this.mfX.dsC();
                                    if (NewSubPbActivity.this.kSr != null) {
                                        NewSubPbActivity.this.kSr.bCs();
                                    }
                                }
                            } else if (view.getId() != R.id.pb_floor_feedback) {
                                if (view == NewSubPbActivity.this.mfX.dsG()) {
                                    NewSubPbActivity.this.mfX.drd();
                                    if (NewSubPbActivity.this.mfV.loadData()) {
                                        NewSubPbActivity.this.mfX.dsE();
                                    }
                                } else if (view == NewSubPbActivity.this.mfX.dsN() || view == NewSubPbActivity.this.mfX.dsO() || view == NewSubPbActivity.this.mfX.dsQ()) {
                                    if (NewSubPbActivity.this.mgh) {
                                        NewSubPbActivity.this.mgh = false;
                                        return;
                                    }
                                    if (NewSubPbActivity.this.mfV.dsZ() != null && NewSubPbActivity.this.mfV.dsZ().bln() != null) {
                                        z2 = az.a(NewSubPbActivity.this.mfV.dsZ().bln().getBaijiahaoData());
                                    }
                                    if (z2) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.mfV.dot(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.mfV.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.mfV.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.mfV.dsZ() != null && NewSubPbActivity.this.mfV.dsZ().bln() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.mfV.dsZ().bln().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.mfV.dot(), NewSubPbActivity.this.mfV.bBJ(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.mfV.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.mfV.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.mfX.dsR() == null || view != NewSubPbActivity.this.mfX.dsR().dpu()) {
                                    if (NewSubPbActivity.this.mfX.dsR() == null || view != NewSubPbActivity.this.mfX.dsR().dpx()) {
                                        if (NewSubPbActivity.this.mfX.dsR() == null || view != NewSubPbActivity.this.mfX.dsR().dpv()) {
                                            if (NewSubPbActivity.this.mfX.dsR() == null || view != NewSubPbActivity.this.mfX.dsR().dpw()) {
                                                if (NewSubPbActivity.this.mfX.dsR() == null || view != NewSubPbActivity.this.mfX.dsR().dpy()) {
                                                    if (view == NewSubPbActivity.this.mfX.dsK() || view == NewSubPbActivity.this.mfX.dsQ()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.kSr.bCp()) {
                                                                NewSubPbActivity.this.kSr.bCq();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.kSr.Dd(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view != null && (view.getTag() instanceof PbCommenFloorItemViewHolder)) {
                                                        NewSubPbActivity.this.mgk = (PbCommenFloorItemViewHolder) view.getTag();
                                                        if (bh.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.mgh) {
                                                                NewSubPbActivity.this.mgh = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.kSl == null || NewSubPbActivity.this.mfV == null || NewSubPbActivity.this.mfV.cBs() == null || NewSubPbActivity.this.kSl.ox(NewSubPbActivity.this.mfV.cBs().replyPrivateFlag)) && (sparseArray2 = (SparseArray) view.getTag(R.id.tag_from)) != null) {
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
                                                        if (NewSubPbActivity.this.mfY == null || view != NewSubPbActivity.this.mfY.dpw()) {
                                                            if (NewSubPbActivity.this.mfY == null || view != NewSubPbActivity.this.mfY.dpu()) {
                                                                if (NewSubPbActivity.this.mfY == null || view != NewSubPbActivity.this.mfY.dpx()) {
                                                                    if (NewSubPbActivity.this.mfY == null || view != NewSubPbActivity.this.mfY.dpy()) {
                                                                        if (NewSubPbActivity.this.mfY == null || view != NewSubPbActivity.this.mfY.dpA()) {
                                                                            if (NewSubPbActivity.this.mfY == null || view != NewSubPbActivity.this.mfY.dpB()) {
                                                                                if (NewSubPbActivity.this.mfY == null || view != NewSubPbActivity.this.mfY.dpC()) {
                                                                                    if (NewSubPbActivity.this.mfY != null && view == NewSubPbActivity.this.mfY.dpv()) {
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
                                                                                                    NewSubPbActivity.this.f(sparseArray4);
                                                                                                    return;
                                                                                                }
                                                                                                sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                                                                NewSubPbActivity.this.mfX.dL(view);
                                                                                                return;
                                                                                            } else if (booleanValue2) {
                                                                                                NewSubPbActivity.this.mfX.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                                                return;
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    int id = view.getId();
                                                                                    if (id == R.id.pb_item_tail_content) {
                                                                                        if (bh.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                            String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                                                                                            String string2 = com.baidu.tbadk.core.sharedPref.b.brQ().getString("tail_link", "");
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
                                                                                            if (postData2.getType() != PostData.eQE && !TextUtils.isEmpty(postData2.getBimg_url()) && k.bkT().isShowImages()) {
                                                                                                NewSubPbActivity.this.PW(postData2.getId());
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
                                                                                    if (postData3.bpJ() != null) {
                                                                                        NewSubPbActivity.this.d(postData3.bpJ());
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.lRZ != null && !TextUtils.isEmpty(NewSubPbActivity.this.lSa)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.eIQ == null) {
                                                                                        NewSubPbActivity.this.eIQ = new at(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.eIQ.p(NewSubPbActivity.this.lSa, NewSubPbActivity.this.lRZ.getImageByte());
                                                                                    NewSubPbActivity.this.lRZ = null;
                                                                                    NewSubPbActivity.this.lSa = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.lRZ != null && !TextUtils.isEmpty(NewSubPbActivity.this.lSa)) {
                                                                            if (NewSubPbActivity.this.lSb == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.lSa));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.lSa;
                                                                                aVar.pkgId = NewSubPbActivity.this.lSb.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.lSb.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.lRZ = null;
                                                                            NewSubPbActivity.this.lSa = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.kpS != null) {
                                                                        NewSubPbActivity.this.kpS.gW(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.kpS = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                if (sparseArray5 != null && (sparseArray5.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_id) instanceof String) && (sparseArray5.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.mfX.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.dE(view);
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
                                                                NewSubPbActivity.this.Pt((String) tag);
                                                                return;
                                                            } else if (tag instanceof SparseArray) {
                                                                SparseArray<Object> sparseArray6 = (SparseArray) tag;
                                                                if ((sparseArray6.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                                    sparseArray6.put(R.id.tag_from, 0);
                                                                    sparseArray6.put(R.id.tag_check_mute_from, 2);
                                                                    NewSubPbActivity.this.f(sparseArray6);
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
                                                            if (NewSubPbActivity.this.mfV != null) {
                                                                TiebaStatic.log(new ar("c13700").dR("tid", NewSubPbActivity.this.mfV.dou()).dR("fid", NewSubPbActivity.this.mfV.getFromForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).ap("obj_source", 1).ap("obj_type", 3));
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
                                                        ((PostData) sparseArray8.get(R.id.tag_clip_board)).gW(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new ar("c11739").ap("obj_locate", 4));
                                            if (!j.isNetWorkAvailable()) {
                                                NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.mfX.drd();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.Pt(str4);
                                                    return;
                                                }
                                                return;
                                            } else if (tag2 instanceof SparseArray) {
                                                SparseArray<Object> sparseArray9 = (SparseArray) tag2;
                                                if ((sparseArray9.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray9.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray9.put(R.id.tag_from, 0);
                                                    sparseArray9.put(R.id.tag_check_mute_from, 2);
                                                    NewSubPbActivity.this.f(sparseArray9);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                        } else if (j.isNetWorkAvailable()) {
                                            NewSubPbActivity.this.mfX.drd();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.dO(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.mfX.drd();
                                    SparseArray sparseArray10 = (SparseArray) view.getTag();
                                    if (sparseArray10 != null) {
                                        NewSubPbActivity.this.mfX.a(((Integer) sparseArray10.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray10.get(R.id.tag_del_post_id), ((Integer) sparseArray10.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new ar("c11739").ap("obj_locate", 2));
                                    NewSubPbActivity.this.mfX.drd();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.mfV.dsZ() != null) {
                                        NewSubPbActivity.this.n(NewSubPbActivity.this.mfV.dsZ().dlR());
                                    }
                                }
                            } else {
                                try {
                                    sparseArray3 = (SparseArray) view.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                }
                                if (sparseArray3 != null && ((PostData) sparseArray3.get(R.id.tag_clip_board)) != null) {
                                    if (NewSubPbActivity.this.mfY == null) {
                                        NewSubPbActivity.this.mfY = new aa(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.bbI);
                                        NewSubPbActivity.this.mfX.dP(NewSubPbActivity.this.mfY.getView());
                                        NewSubPbActivity.this.mfY.vp(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.mfY.QE();
                                    if (NewSubPbActivity.this.va(sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin()) {
                                        z2 = true;
                                    }
                                    NewSubPbActivity.this.mfY.a(sparseArray3, NewSubPbActivity.this.dlo(), z2);
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.mfX.dsB();
                            NewSubPbActivity.this.mfX.dsC();
                            if (NewSubPbActivity.this.kSr != null) {
                                NewSubPbActivity.this.kSr.bCr();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.dnq();
                        if (NewSubPbActivity.this.mfV != null && NewSubPbActivity.this.mfV.dsZ() != null && NewSubPbActivity.this.mfV.dsZ().bln() != null && NewSubPbActivity.this.mfV.dsZ().bln().bnQ() != null) {
                            TiebaStatic.log(new ar("c13402").dR("tid", NewSubPbActivity.this.mfV.dot()).v("fid", NewSubPbActivity.this.mfV.dsZ().bln().getFid()).ap("obj_locate", 5).dR("uid", NewSubPbActivity.this.mfV.dsZ().bln().bnQ().getUserId()));
                        }
                    }
                }
            }
        };
        this.mfZ = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.mfX.drd();
                    if (NewSubPbActivity.this.lMF != 2 && NewSubPbActivity.this.lMF != 1) {
                        NewSubPbActivity.this.mfX.dsW();
                    }
                }
                NewSubPbActivity.this.kSr.bCq();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.mfX.dsS();
            }
        };
        this.mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
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
                if (NewSubPbActivity.this.mfX != null && NewSubPbActivity.this.mfX.dsJ()) {
                    return false;
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null && NewSubPbActivity.this.dG(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.lRZ = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.lSa = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.lRZ == null || TextUtils.isEmpty(NewSubPbActivity.this.lSa)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lSb = null;
                        } else {
                            NewSubPbActivity.this.lSb = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.lRZ = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.lSa = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lSb = null;
                        } else {
                            NewSubPbActivity.this.lSb = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.lRZ = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.lSa = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lSb = null;
                        } else {
                            NewSubPbActivity.this.lSb = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        NewSubPbActivity.this.mfX.a(NewSubPbActivity.this.lSO, NewSubPbActivity.this.lRZ.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.kpS = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.kpS == null || NewSubPbActivity.this.lRB == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.lRB != null) {
                            NewSubPbActivity.this.lRB.ja(NewSubPbActivity.this.mfV.dtg());
                        }
                        boolean z2 = NewSubPbActivity.this.lRB.bjZ() && NewSubPbActivity.this.kpS.getId() != null && NewSubPbActivity.this.kpS.getId().equals(NewSubPbActivity.this.mfV.dti());
                        if (NewSubPbActivity.this.mfY == null) {
                            NewSubPbActivity.this.mfY = new aa(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.bbI);
                            NewSubPbActivity.this.mfX.dP(NewSubPbActivity.this.mfY.getView());
                            NewSubPbActivity.this.mfY.vp(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.mfY.QE();
                        boolean z3 = NewSubPbActivity.this.va(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z4 = (NewSubPbActivity.this.mfV.dsZ() == null || NewSubPbActivity.this.mfV.dsZ().bln() == null || !NewSubPbActivity.this.mfV.dsZ().bln().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z2) {
                            NewSubPbActivity.this.mfY.dpu().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.mfY.dpu().setText(R.string.mark);
                        }
                        if (booleanValue || z4) {
                            NewSubPbActivity.this.mfY.dpu().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.mfY.dpu().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.dG(view)) {
                            if (NewSubPbActivity.this.lRZ != null && !NewSubPbActivity.this.lRZ.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        aa aaVar = NewSubPbActivity.this.mfY;
                        int dlo = NewSubPbActivity.this.dlo();
                        if (NewSubPbActivity.this.lRy && NewSubPbActivity.this.kpS.nxv) {
                            z = true;
                        }
                        aaVar.a(sparseArray2, dlo, z3, z);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.mga = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
            /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
            /* JADX DEBUG: Multi-variable search result rejected for r8v7, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$a */
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
                        q dsZ = NewSubPbActivity.this.mfV.dsZ();
                        TbRichText bH = NewSubPbActivity.this.bH(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bH != null && bH.bHz() != null) {
                            tbRichTextData = bH.bHz().get(NewSubPbActivity.this.lSL);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!tbRichTextData.bHF().bHQ()) {
                                String c = NewSubPbActivity.this.c(tbRichTextData);
                                arrayList.add(c);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap.put(c, imageUrlData);
                                String str5 = null;
                                String str6 = null;
                                String str7 = null;
                                boolean z5 = false;
                                if (dsZ == null) {
                                    str4 = null;
                                } else {
                                    if (dsZ.bCk() != null) {
                                        str5 = dsZ.bCk().getName();
                                        str6 = dsZ.bCk().getId();
                                    }
                                    if (dsZ.bln() != null) {
                                        str7 = dsZ.bln().getId();
                                    }
                                    z5 = true;
                                    str4 = str7;
                                }
                                if (NewSubPbActivity.this.mfV.dtn() != null) {
                                    concurrentHashMap = NewSubPbActivity.this.mfV.dtn();
                                    z4 = NewSubPbActivity.this.mfV.dtp();
                                    arrayList = NewSubPbActivity.this.mfV.dto();
                                } else {
                                    z4 = z5;
                                }
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(y.getItem(arrayList, 0));
                                ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                                aVar.s(arrayList2).zJ(str5).zK(str6).zL(str4).jg(z4).zM(arrayList.get(0)).jh(true).d(concurrentHashMap).ji(true).jj(false).jk(false).s(NewSubPbActivity.this.bln()).zN(String.valueOf(bH.getPostId())).zO(NewSubPbActivity.this.mfV.getFromForumId());
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar.eP(NewSubPbActivity.this.getPageContext().getPageActivity())));
                                return;
                            }
                            NewSubPbActivity.this.lSM = false;
                            TbRichText dNz = dsZ.dlR().dNz();
                            int size = arrayList.size();
                            int a2 = NewSubPbActivity.this.a(dNz, bH, i, i, arrayList, concurrentHashMap);
                            int size2 = arrayList.size();
                            if (size == size2) {
                                str2 = "";
                            } else {
                                str2 = arrayList.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            boolean z6 = false;
                            if (dsZ == null) {
                                str3 = null;
                            } else {
                                if (dsZ.bCk() != null) {
                                    str8 = dsZ.bCk().getName();
                                    str9 = dsZ.bCk().getId();
                                }
                                if (dsZ.bln() != null) {
                                    str10 = dsZ.bln().getId();
                                }
                                z6 = true;
                                str3 = str10;
                            }
                            if (NewSubPbActivity.this.mfV.dtn() != null) {
                                concurrentHashMap = NewSubPbActivity.this.mfV.dtn();
                                z3 = NewSubPbActivity.this.mfV.dtp();
                                arrayList = NewSubPbActivity.this.mfV.dto();
                                a2 = NewSubPbActivity.this.mfV.getOffset() + a2;
                            } else {
                                z3 = z6;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(y.getItem(arrayList, a2));
                            ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                            aVar2.s(arrayList3).zJ(str8).zK(str9).zL(str3).jg(z3).zM(str2).jh(true).d(concurrentHashMap).ji(true).jj(false).jk(false).s(NewSubPbActivity.this.bln()).zN(String.valueOf(bH.getPostId())).zO(NewSubPbActivity.this.mfV.getFromForumId());
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar2.eP(NewSubPbActivity.this.getPageContext().getPageActivity())));
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
    public cb bln() {
        if (this.mfV == null || this.mfV.dsZ() == null) {
            return null;
        }
        return this.mfV.dsZ().bln();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dE(View view) {
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
        if (!dnp()) {
            if (postData != null) {
                if (postData.bnQ() != null) {
                    MetaData bnQ = postData.bnQ();
                    this.kSr.setReplyId(bnQ.getUserId());
                    boolean z2 = postData.nxv;
                    String str = "";
                    if (postData.dNz() != null) {
                        str = postData.dNz().toString();
                    }
                    this.kSr.Df(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bnQ().getName_show(), str));
                    if (z2) {
                        if (!z) {
                            this.kSr.De("");
                        }
                    } else if (!z) {
                        this.kSr.De(bnQ.getName_show());
                    }
                }
                this.mfX.dsC();
            }
            if (this.mgj) {
                we(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(AgreeData agreeData) {
        com.baidu.tbadk.pageExtra.c fq;
        int i = 1;
        if (agreeData != null) {
            if (this.feF == null) {
                this.feF = new com.baidu.tbadk.core.message.a();
            }
            if (this.fep == null) {
                this.fep = new e();
                this.fep.uniqueId = this.mgl;
            }
            com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
            eVar.eMa = 12;
            eVar.eMg = 9;
            eVar.eMf = 3;
            if (dsA() != null) {
                eVar.eMe = dsA().dtr();
            }
            if (eVar != null) {
                eVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (eVar != null) {
                        eVar.eMh = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (eVar != null) {
                        eVar.eMh = 1;
                        i = 0;
                    }
                }
                fq = com.baidu.tbadk.pageExtra.d.fq(getActivity());
                if (fq != null) {
                    agreeData.objSource = fq.getCurrentPageKey();
                }
                this.feF.a(agreeData, i, getUniqueId(), false);
                this.feF.a(agreeData, this.fep);
                if (dsA() == null && dsA().dsZ() != null) {
                    this.feF.a(this, eVar, agreeData, dsA().dsZ().bln());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (eVar != null) {
                eVar.eMh = 1;
            }
            i = 0;
            fq = com.baidu.tbadk.pageExtra.d.fq(getActivity());
            if (fq != null) {
            }
            this.feF.a(agreeData, i, getUniqueId(), false);
            this.feF.a(agreeData, this.fep);
            if (dsA() == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        TbRichTextImageInfo bHF;
        if (tbRichText == tbRichText2) {
            this.lSM = true;
        }
        if (tbRichText != null && tbRichText.bHz() != null) {
            int size = tbRichText.bHz().size();
            int i3 = -1;
            int i4 = 0;
            int i5 = i;
            while (i4 < size) {
                if (tbRichText.bHz().get(i4) != null && tbRichText.bHz().get(i4).getType() == 8) {
                    i3++;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.bHz().get(i4).bHF().getWidth() * equipmentDensity;
                    int height = tbRichText.bHz().get(i4).bHF().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.bHz().get(i4).bHF().bHQ()) {
                        if (tbRichText == tbRichText2 && i3 <= i2) {
                            i5--;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.bHz().get(i4);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (bHF = tbRichTextData.bHF()) != null) {
                            String bHS = bHF.bHS();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = bHS;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.lSM) {
                            i5++;
                        }
                    }
                }
                i4++;
                i3 = i3;
            }
            return i5;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (this.mfY != null) {
            this.mfY.vp(z);
        }
        if (this.mfX != null) {
            this.mfX.vp(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bHF = tbRichTextData.bHF();
        if (bHF != null) {
            if (!StringUtils.isNull(bHF.bHP())) {
                return bHF.bHP();
            }
            if (bHF.getHeight() * bHF.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bHF.getHeight() * bHF.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bHF.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bHF.getHeight())));
            } else {
                float width = bHF.getWidth() / bHF.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(au.getUrlEncode(bHF.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bH(String str, int i) {
        if (this.mfV == null || this.mfV.dsZ() == null || str == null || i < 0) {
            return null;
        }
        q dsZ = this.mfV.dsZ();
        TbRichText a2 = a(dsZ.dlR(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(dsZ.dlR(), str, i);
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
        TbRichText dNz = postData.dNz();
        if (dNz != null) {
            ArrayList<TbRichTextData> bHz = dNz.bHz();
            int size = bHz.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (bHz.get(i3) != null && bHz.get(i3).getType() == 8) {
                    i2++;
                    if (bHz.get(i3).bHF().bHS().equals(str)) {
                        int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = bHz.get(i3).bHF().getWidth() * equipmentDensity;
                        int height = bHz.get(i3).bHF().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.lSL = i3;
                        return dNz;
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

    private boolean dnp() {
        if (this.mfV == null) {
            return false;
        }
        return AntiHelper.a(getPageContext(), this.mfV.cBs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnq() {
        Intent intent = getIntent();
        boolean booleanExtra = intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false;
        if (!dnp()) {
            if (booleanExtra) {
                if (this.kSl == null || this.mfV == null || this.mfV.cBs() == null || this.kSl.ox(this.mfV.cBs().replyPrivateFlag)) {
                    if (this.kSr.bCd()) {
                        this.kSr.a((PostWriteCallBackData) null);
                        return;
                    }
                    this.mfX.dsB();
                    this.mfX.dsC();
                    if (this.kSr != null) {
                        this.kSr.bCt();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.jkC == null) {
                this.jkC = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jkC.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qM(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void B(boolean z, int i) {
                    }

                    /* JADX WARN: Removed duplicated region for block: B:26:0x00bf  */
                    /* JADX WARN: Removed duplicated region for block: B:27:0x00ca  */
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void qN(boolean z) {
                        String str;
                        if (z) {
                            if (NewSubPbActivity.this.kSl == null || NewSubPbActivity.this.mfV == null || NewSubPbActivity.this.mfV.cBs() == null || NewSubPbActivity.this.kSl.ox(NewSubPbActivity.this.mfV.cBs().replyPrivateFlag)) {
                                if (NewSubPbActivity.this.mfV != null && NewSubPbActivity.this.mfV.dsZ() != null && NewSubPbActivity.this.mfV.dsZ().dlR() != null) {
                                    PostData dlR = NewSubPbActivity.this.mfV.dsZ().dlR();
                                    if (dlR.dNz() != null && dlR.bnQ() != null) {
                                        str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), dlR.bnQ().getName_show(), dlR.dNz().toString());
                                        NewSubPbActivity.this.kSr.bBh().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                                        if (!NewSubPbActivity.this.kSr.bCd()) {
                                            NewSubPbActivity.this.kSr.a((PostWriteCallBackData) null);
                                            return;
                                        }
                                        NewSubPbActivity.this.mfX.dsB();
                                        NewSubPbActivity.this.mfX.dsC();
                                        if (NewSubPbActivity.this.kSr != null) {
                                            NewSubPbActivity.this.kSr.bCt();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                str = null;
                                NewSubPbActivity.this.kSr.bBh().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                                if (!NewSubPbActivity.this.kSr.bCd()) {
                                }
                            }
                        }
                    }
                });
            }
            if (this.mfV != null && this.mfV.dsZ() != null && this.mfV.dsZ().bCk() != null) {
                this.jkC.G(this.mfV.dsZ().bCk().getId(), com.baidu.adp.lib.f.b.toLong(this.mfV.dot(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean va(boolean z) {
        if (this.mfV == null) {
            return false;
        }
        return ((dlo() != 0) || this.mfV.dsZ() == null || this.mfV.dsZ().bln() == null || this.mfV.dsZ().bln().bnQ() == null || this.mfV.dsZ().bln().bmz() || TextUtils.equals(this.mfV.dsZ().bln().bnQ().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bR(int i, String str) {
        if (this.mfV.dta()) {
            showToast(str);
        } else if (l.isNetOk()) {
            if (i == 4) {
                this.mfX.aY(str + "(4)", true);
            } else if (!TextUtils.isEmpty(str)) {
                this.mfX.aY(str + "(" + i + ")", true);
            } else {
                this.mfX.CY(R.string.no_data_text);
            }
        } else {
            this.mfX.CY(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ts(boolean z) {
        this.kSr = (com.baidu.tbadk.editortools.pb.h) new i(z).fg(getActivity());
        if (this.kSr != null) {
            this.kSr.a(getPageContext());
            this.kSr.b(this.mfV);
            this.kSr.b(this.kpr);
            this.kSr.setFrom(2);
            this.kSr.a(this.fDO);
            this.kSr.a(this.fDP);
            this.kSr.bBh().kN(true);
            this.kSr.j(getPageContext());
        }
        if (this.mfX != null) {
            this.mfX.i(this.kSr);
        }
        if (this.kSr != null && this.mfV != null) {
            this.kSr.a(this.mfV.cBs());
            this.kSr.bCq();
        }
        if (this.kSr != null) {
            this.kSr.bCu().setDefaultHint(dqn());
            this.kSr.bCu().setHint(dqn());
            this.kpl = this.kSr.bCu().getInputView();
            this.kpl.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.kpk != null) {
                        if (!NewSubPbActivity.this.kpk.dWq()) {
                            NewSubPbActivity.this.ss(false);
                        }
                        NewSubPbActivity.this.kpk.zu(false);
                    }
                }
            });
        }
    }

    public void dsy() {
        if (!TbadkCoreApplication.isLogin()) {
            this.kSr.bCq();
        } else if (!StringUtils.isNull(this.mfV.dtj())) {
            if (this.mfX.dsF() && l.isNetOk()) {
                this.mfX.czr();
            } else {
                this.mfX.dsI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dO(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(R.id.tag_from, 1);
                    f(sparseArray);
                } else {
                    this.mfX.dL(view);
                }
            } else if (booleanValue2) {
                this.mfX.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.mfX.dsP(), getPageContext().getPageActivity());
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
            bVar.nC(R.string.operation);
            bVar.a(strArr, new b.InterfaceC0558b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0558b
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.mgg);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.mgg);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).bqz();
        }
    }

    public void f(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.mfX.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.mgg;
        userMuteCheckCustomMessage.setTag(this.mgg);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.mfX.a(0, bVar.mSuccess, bVar.nzx, z);
            if (bVar.mSuccess) {
                if (bVar.iNf == 1) {
                    if (this.mfX.getListView() instanceof BdTypeListView) {
                        List<com.baidu.adp.widget.ListView.n> data = ((BdTypeListView) this.mfX.getListView()).getData();
                        if (!y.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.mfX.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.iNf == 2) {
                    this.mfV.PY(bVar.mPostId);
                    this.mfX.a(this.mfV.dsZ(), this.mfV.dlo(), this.mfV.dtn() != null, false);
                    if (this.mfV.dtk()) {
                        this.mfV.wi(false);
                        this.mfX.dsD();
                        this.mfV.loadData();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void Pt(String str) {
        if (this.mfV != null && this.mfV.dsZ() != null && this.mfV.dsZ().bln() != null && this.mfV.dsZ().bln().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.mfV.dot(), str);
            cb bln = this.mfV.dsZ().bln();
            if (bln.bmx()) {
                format = format + "&channelid=33833";
            } else if (bln.bpM()) {
                format = format + "&channelid=33842";
            } else if (bln.bmy()) {
                format = format + "&channelid=33840";
            }
            Pu(format);
            return;
        }
        this.lRA.PU(str);
    }

    private void Pu(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void n(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.mfV.dtg() && postData.getId() != null && postData.getId().equals(this.mfV.dti())) {
                z = true;
            }
            MarkData o = this.mfV.o(postData);
            if (o != null) {
                this.mfX.drd();
                if (this.lRB != null) {
                    this.lRB.a(o);
                    if (!z) {
                        this.lRB.bkb();
                    } else {
                        this.lRB.bka();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.mfV != null) {
            this.mfV.aD(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.kSr != null) {
            this.kSr.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.kSr.bBh().bzD();
        this.kSr.bCq();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.kSr.c(writeData);
                this.kSr.setVoiceModel(pbEditorData.getVoiceModel());
                m qU = this.kSr.bBh().qU(6);
                if (qU != null && qU.fBo != null) {
                    qU.fBo.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.kSr.bCm();
                }
                this.mfX.dsW();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.jgg != null) {
            this.jgg.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.mIsPaused = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.bhn().bhy();
        if (this.jgg != null) {
            this.jgg.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.juD);
        this.mfX.cKR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.mIsPaused = false;
        super.onResume();
        dnW();
        if (this.jgg != null) {
            this.jgg.onResume(getPageContext());
        }
        registerListener(this.juD);
        this.mfX.cKS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jgg != null) {
            this.jgg.onStop(getPageContext());
        }
        this.kSr.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.mgi));
        this.mfV.cancelLoadData();
        this.mfV.destory();
        this.mfW.cancelLoadData();
        if (this.jgg != null) {
            this.jgg.onDestory(getPageContext());
        }
        this.mfX.drd();
        this.mfX.cIZ();
        MessageManager.getInstance().unRegisterListener(this.lSw);
        MessageManager.getInstance().unRegisterListener(this.lSx);
        MessageManager.getInstance().unRegisterListener(this.lSy);
        MessageManager.getInstance().unRegisterListener(this.mgg);
        this.lRV = null;
        this.lRW = null;
        if (this.kSl != null) {
            this.kSl.onDestroy();
        }
        com.baidu.tbadk.pageExtra.d.Dp(getCurrentPageKey());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mfX.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.jgg;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View dsK = this.mfX.dsK();
        if (dsK == null || (findViewWithTag = dsK.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean PM(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = bf.getParamPair(bf.getParamStr(str))) != null) {
            this.mgh = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return PM(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(mfU);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (PM(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.m mVar = new com.baidu.tbadk.data.m();
                    mVar.mLink = str;
                    mVar.type = 3;
                    mVar.fAm = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, mVar));
                }
            } else {
                bf.bsV().b(getPageContext(), new String[]{str});
            }
            this.mgh = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.mgh = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aH(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void u(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        if (this.mfX != null) {
            return this.mfX.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bIg() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bIi() {
        if (this.fXB == null) {
            this.fXB = TbRichTextView.K(getPageContext().getPageActivity(), 8);
        }
        return this.fXB;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bIj() {
        if (this.fUm == null) {
            this.fUm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cwZ */
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
        return this.fUm;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bIh() {
        if (this.fUl == null) {
            this.fUl = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bIt */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = k.bkT().isShowImages();
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
                /* renamed from: c */
                public void destroyObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: d */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (k.bkT().isShowImages()) {
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
                /* renamed from: e */
                public ImageView passivateObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.fUl;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bIk() {
        if (this.fXC == null) {
            this.fXC = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dod */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(NewSubPbActivity.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dH */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dI */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dJ */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fXC;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bIl() {
        if (this.fXD == null) {
            this.fXD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dof */
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
        return this.fXD;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bIm() {
        this.fXE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: doe */
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
        return this.fXE;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a dmh() {
        return this.lNj;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean dmi() {
        return (this.mfV == null || this.mfV.dsZ() == null || this.mfV.dsZ().bln() == null || this.mfV.dsZ().bln().bpp()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String dmj() {
        if (this.mfV == null || this.mfV.dsZ() == null || this.mfV.dsZ().bln() == null) {
            return null;
        }
        return this.mfV.dsZ().bln().bnU();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int dmk() {
        if (this.mfV == null) {
            return 0;
        }
        return this.mfV.dlo();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Pn(String str) {
        if (StringUtils.isNull(str) || this.mfV == null || this.mfV.dsZ() == null || this.mfV.dsZ().bln() == null || this.mfV.dsZ().bln().bnQ() == null) {
            return false;
        }
        return str.equals(this.mfV.dsZ().bln().bnQ().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mfX.dsF() && l.isNetOk()) {
            this.mfV.loadData();
        } else {
            this.mfX.dsI();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.mgg);
        userMuteAddAndDelCustomMessage.setTag(this.mgg);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PW(String str) {
        if (!StringUtils.isNull(str) && bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString("bubble_link", "");
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

    @Override // com.baidu.tbadk.widget.richText.h
    public void aI(Context context, String str) {
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.PB_FLOOR;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.bDS().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.mfV != null) {
            if (this.mfV.dsZ() != null && this.mfV.dsZ().bCk() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.mfV.dsZ().bCk().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.mfV.dot(), 0L));
            if (this.mfV.dsZ() != null && this.mfV.dsZ().bln() != null) {
                pageStayDurationItem.setNid(this.mfV.dsZ().bln().bmo());
            }
            pageStayDurationItem.setPid(com.baidu.adp.lib.f.b.toLong(this.mfV.bBJ(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public boolean dsz() {
        if (this.mfV != null) {
            return this.mfV.dsz();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.mfX.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lRV.getPageActivity());
        if (au.isEmpty(str)) {
            aVar.Au(this.lRV.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Au(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.mfX.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lRV).bqx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dc(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lRV.getPageActivity());
        aVar.Au(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lRV).bqx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.Au(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.lRV).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.lRV.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lRV).bqx();
    }

    public SubPbModel dsA() {
        return this.mfV;
    }

    public int dlo() {
        if (this.mfV != null) {
            return this.mfV.dlo();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.fBK && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fBK && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void ss(boolean z) {
        if (this.kpl != null && this.kpl.getText() != null) {
            int selectionEnd = this.kpl.getSelectionEnd();
            SpannableStringBuilder d = this.kpk.d(this.kpl.getText());
            if (d != null) {
                this.kpk.zu(true);
                this.kpl.setText(d);
                if (z && this.kpk.dWo() >= 0) {
                    this.kpl.requestFocus();
                    this.kpl.setSelection(this.kpk.dWo());
                } else {
                    this.kpl.setSelection(selectionEnd);
                }
                this.kpk.zt(this.kpk.dWo() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kSr != null && this.kSr.bBh() != null && this.kSr.bBh().bBl()) {
            this.kSr.bBh().bzD();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.i
    public void onPreLoad(com.baidu.adp.widget.ListView.q qVar) {
        ag.a(qVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.c.a(qVar, getUniqueId(), this);
    }

    public String dqn() {
        if (!au.isEmpty(this.may)) {
            return this.may;
        }
        this.may = getResources().getString(ao.dqd());
        return this.may;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.mgj = z;
        we(true);
    }

    private void we(boolean z) {
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
        if (this.mfX != null && this.mfX.getListView() != null && this.mgk != null && this.mgk.mPosition != -1) {
            final int headerViewsCount = this.mgk.mPosition + this.mfX.getListView().getHeaderViewsCount();
            if (this.mgk.getView() != null) {
                final int height = this.mgk.getView().getHeight();
                final int height2 = ((rect.height() - this.mfX.dsV()) - this.mfX.getNavigationBarHeight()) - this.mfX.dsU();
                final int i = height - height2;
                if (i > 0) {
                    this.mfX.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.mfX != null && NewSubPbActivity.this.mfX.getListView() != null) {
                                NewSubPbActivity.this.mfX.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.mfX.getNavigationBarHeight() - i);
                            }
                        }
                    });
                } else {
                    this.mfX.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.mfX != null && NewSubPbActivity.this.mfX.getListView() != null) {
                                NewSubPbActivity.this.mfX.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.mfX.getNavigationBarHeight() + (height2 - height));
                            }
                        }
                    });
                }
            }
        }
    }

    private void dnW() {
        if (this.mfV != null && !au.isEmpty(this.mfV.dot())) {
            com.baidu.tbadk.BdToken.c.bhn().q(com.baidu.tbadk.BdToken.b.eCf, com.baidu.adp.lib.f.b.toLong(this.mfV.dot(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.mfV == null || au.isEmpty(this.mfV.dot())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.mfV.dot(), 0L);
    }
}
