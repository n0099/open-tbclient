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
import com.baidu.adp.widget.ListView.q;
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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.dialog.WriteTipBubbleController;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.af;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.x;
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
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.aa;
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
    private static String lWP = "tbgametype";
    private View.OnClickListener aYB;
    private at eGK;
    private com.baidu.adp.lib.d.b<ImageView> fRW;
    private com.baidu.adp.lib.d.b<GifView> fRX;
    private com.baidu.adp.lib.d.b<TextView> fVl;
    private com.baidu.adp.lib.d.b<View> fVm;
    private com.baidu.adp.lib.d.b<LinearLayout> fVn;
    private com.baidu.adp.lib.d.b<RelativeLayout> fVo;
    private e fbZ;
    private com.baidu.tbadk.core.message.a fcq;
    private VoiceManager jaA;
    private com.baidu.tieba.frs.profession.permission.c jeV;
    public al kKi;
    private com.baidu.tbadk.editortools.pb.h kKo;
    private com.baidu.tieba.write.c khc;
    private EditText khd;
    private com.baidu.tieba.pb.pb.main.b.a lEu;
    private boolean lEz;
    private com.baidu.tieba.pb.pb.report.a lID;
    private com.baidu.tbadk.baseEditMark.a lIE;
    private f lIY;
    private com.baidu.tbadk.core.view.c lIZ;
    private com.baidu.adp.widget.ImageView.a lJc;
    private String lJd;
    private TbRichTextMemeInfo lJe;
    private PostWriteCallBackData lKL;
    private String lRz;
    private SubPbModel lWQ;
    private ForumManageModel lWR;
    private com.baidu.tieba.pb.pb.sub.a lWS;
    private aa lWT;
    private AbsListView.OnScrollListener lWU;
    private TbRichTextView.i lWV;
    private SubPbModel.a lWW;
    private com.baidu.adp.base.e lWX;
    private BdUniqueId lXb;
    private com.baidu.tieba.pb.e<p> lXd;
    private boolean lXe;
    private PbCommenFloorItemViewHolder lXf;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int lJO = 0;
    PostData khK = null;
    private a.InterfaceC0557a lJK = null;
    private a lWY = null;
    private a lWZ = null;
    private boolean mIsPaused = false;
    private boolean lXa = false;
    private boolean lXc = false;
    private boolean fzv = false;
    private com.baidu.tbadk.editortools.pb.c fBz = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bBu() {
            NewSubPbActivity.this.lWS.dqt();
        }
    };
    private int lDQ = 0;
    private boolean mIsFromSchema = false;
    private BdUniqueId lXg = BdUniqueId.gen();
    private boolean lIB = com.baidu.tbadk.a.d.biM();
    private boolean lXh = true;
    private com.baidu.tbadk.editortools.pb.b fBA = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBt() {
            if (!NewSubPbActivity.this.khc.dUb()) {
                return (NewSubPbActivity.this.kKi == null || NewSubPbActivity.this.lWQ == null || NewSubPbActivity.this.lWQ.cAh() == null || NewSubPbActivity.this.kKi.aN(NewSubPbActivity.this.lWQ.cAh().replyPrivateFlag, al.eYm)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.khc.dUd());
            if (NewSubPbActivity.this.kKo.bBL()) {
                NewSubPbActivity.this.kKo.a(NewSubPbActivity.this.lKL);
            }
            NewSubPbActivity.this.sf(true);
            return true;
        }
    };
    private CustomMessageListener lXi = new CustomMessageListener(2921481) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && NewSubPbActivity.this.lWQ != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && com.baidu.tbadk.core.util.at.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), NewSubPbActivity.this.lWQ.dme())) {
                if (NewSubPbActivity.this.khc != null) {
                    NewSubPbActivity.this.khc.TW(null);
                    NewSubPbActivity.this.khc.bh(null);
                    NewSubPbActivity.this.khc.yX(false);
                }
                if (NewSubPbActivity.this.kKo != null) {
                    NewSubPbActivity.this.kKo.bBW();
                    NewSubPbActivity.this.kKo.reset();
                }
                NewSubPbActivity.this.lWQ.bBq();
            }
        }
    };
    private NewWriteModel.d khj = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.kKo != null && NewSubPbActivity.this.kKo.bAP() != null) {
                NewSubPbActivity.this.kKo.bAP().hide();
                if (NewSubPbActivity.this.lWQ.dqT()) {
                    TiebaStatic.log(new aq("c10367").dW("post_id", NewSubPbActivity.this.lWQ.bBr()));
                }
            }
            if (z) {
                NewSubPbActivity.this.khc.TW(null);
                NewSubPbActivity.this.khc.bh(null);
                NewSubPbActivity.this.khc.yX(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(NewSubPbActivity.this.getPageContext(), postWriteCallBackData);
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.khc.bh(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.khc.TW(postWriteCallBackData.getErrorString());
                if (!x.isEmpty(NewSubPbActivity.this.khc.dTZ())) {
                    NewSubPbActivity.this.lKL = postWriteCallBackData;
                    if (NewSubPbActivity.this.kKo.bBL()) {
                        NewSubPbActivity.this.kKo.a(NewSubPbActivity.this.lKL);
                    }
                    NewSubPbActivity.this.sf(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (com.baidu.tbadk.core.util.at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(NewSubPbActivity.this.getActivity(), NewSubPbActivity.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(NewSubPbActivity.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(NewSubPbActivity.this.getActivity());
                if (com.baidu.tbadk.core.util.at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.Ad(NewSubPbActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Ad(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new aq("c13746").an("obj_locate", 1).an("obj_type", 2));
                    }
                });
                aVar.b(NewSubPbActivity.this.getPageContext()).bqe();
                TiebaStatic.log(new aq("c13745").an("obj_locate", 1).an("obj_type", 2));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.kKi != null) {
                NewSubPbActivity.this.kKi.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.lWS.dqu();
        }
    };
    private CustomMessageListener lJz = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.lXb) {
                NewSubPbActivity.this.lWS.cjr();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.lIZ.showSuccessToast(NewSubPbActivity.this.lIY.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.lIY.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.CL(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.dlD();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.at.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.lIY.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.lIZ.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lJA = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.lXb) {
                NewSubPbActivity.this.lWS.cjr();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.lIZ.showSuccessToast(NewSubPbActivity.this.lIY.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.at.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.lIY.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.lIZ.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener lJB = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.lXb) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.lWS.cjr();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.nAo;
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
                    NewSubPbActivity.this.lWS.a(sparseArray, z);
                }
            }
        }
    };
    private final f.c gEB = new f.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (NewSubPbActivity.this.lWQ != null) {
                NewSubPbActivity.this.lWQ.dqR();
            }
        }
    };
    boolean lJP = false;
    private final b.InterfaceC0561b lJR = new b.InterfaceC0561b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0561b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.lJc != null && !TextUtils.isEmpty(NewSubPbActivity.this.lJd)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.lJe == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.lJd));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.lJd;
                        aVar.pkgId = NewSubPbActivity.this.lJe.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.lJe.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.eGK == null) {
                            NewSubPbActivity.this.eGK = new at(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.eGK.p(NewSubPbActivity.this.lJd, NewSubPbActivity.this.lJc.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.lJc = null;
                NewSubPbActivity.this.lJd = null;
            }
        }
    };
    private CustomMessageListener joX = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener jch = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    n nVar = (n) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.lWQ.dqL() != null && NewSubPbActivity.this.lWQ.dqL().djF() != null && NewSubPbActivity.this.lWQ.dqL().djF().bnx() != null && currentAccount.equals(NewSubPbActivity.this.lWQ.dqL().djF().bnx().getUserId()) && NewSubPbActivity.this.lWQ.dqL().djF().bnx().getPendantData() != null) {
                        NewSubPbActivity.this.lWQ.dqL().djF().bnx().getPendantData().zM(nVar.getImgUrl());
                        NewSubPbActivity.this.lWQ.dqL().djF().bnx().getPendantData().ee(nVar.bAo());
                        NewSubPbActivity.this.lWS.a(NewSubPbActivity.this.lWQ.dqL(), NewSubPbActivity.this.lWQ.dqL().djF(), NewSubPbActivity.this.lWQ.dqL().Vx(), NewSubPbActivity.this.lWQ.dqL().bjE(), NewSubPbActivity.this.lWQ.djc(), NewSubPbActivity.this.lWQ.dqZ() != null);
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
        this.lIY = getPageContext();
        this.lXa = true;
        this.khc = new com.baidu.tieba.write.c();
        this.khc.KI(R.color.cp_cont_h_alpha85);
        this.khc.KH(R.color.CAM_X0101);
        bYg();
        dqj();
        initData(bundle);
        initUI();
        ((SubPbView) this.lWS.getRootView()).show();
        tf(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lWS.vP(this.mIsFromSchema);
        this.lIZ = new com.baidu.tbadk.core.view.c();
        this.lIZ.toastTime = 1000L;
        registerListener(this.lJB);
        registerListener(this.lJz);
        registerListener(this.lJA);
        registerListener(this.lXi);
        this.lXb = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.lXb;
        userMuteAddAndDelCustomMessage.setTag(this.lXb);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.lXb;
        userMuteCheckCustomMessage.setTag(this.lXb);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.kKi = new al(getPageContext());
        this.kKi.a(new al.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.40
            @Override // com.baidu.tbadk.core.util.al.a
            public void q(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.kKo.bBU();
                }
            }
        });
        this.lID = new com.baidu.tieba.pb.pb.report.a(this);
        this.lID.w(getUniqueId());
        this.lEu = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.lWS = new com.baidu.tieba.pb.pb.sub.a(this, this.aYB);
        this.lWS.a(this.lWQ);
        setContentView(this.lWS.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.lWS.setOnScrollListener(this.lWU);
        this.lWS.b(this);
        this.lWS.setOnImageClickListener(this.lWV);
        this.lWS.setOnLongClickListener(this.mOnLongClickListener);
        this.lWS.h(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.lWQ != null) {
                    NewSubPbActivity.this.lWQ.loadData();
                }
            }
        });
        this.lWS.a(this.lWY);
        this.lWS.b(this.lWZ);
        this.lWS.setListPullRefreshListener(this.gEB);
        if (this.lWQ != null && this.lWQ.dql() && !this.lWQ.dqY()) {
            this.lWS.dqz().setVisibility(8);
        } else {
            this.lWS.dqz().setVisibility(0);
        }
        if (this.lWQ != null && !this.lWQ.dql()) {
            this.lWS.setIsFromPb(false);
        }
    }

    private boolean aE(Bundle bundle) {
        if (bundle != null) {
            this.fzv = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.fzv = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.fzv;
    }

    public void initData(Bundle bundle) {
        this.lWQ = new SubPbModel(getPageContext());
        this.lWQ.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                NewSubPbActivity.this.lWS.v(postData);
                NewSubPbActivity.this.lWS.b((BdListView.e) null);
            }
        });
        this.lWR = new ForumManageModel(getPageContext());
        this.lWR.setLoadDataCallBack(this.lWX);
        this.jaA = new VoiceManager();
        this.jaA.onCreate(getPageContext());
        this.lIE = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.lIE != null) {
            this.lIE.a(this.lJK);
        }
        if (bundle != null) {
            this.lWQ.initWithBundle(bundle);
        } else {
            this.lWQ.initWithIntent(getIntent());
        }
        this.lWQ.a(this.lWW);
        if (this.lWQ.dql() && !this.lWQ.dre()) {
            this.lWQ.loadData();
        } else if (!TextUtils.isEmpty(getIntent().getStringExtra("key_open_editor_tips"))) {
            this.lWQ.loadData();
        } else {
            this.lWQ.dqQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final com.baidu.tbadk.editortools.pb.h hVar, String str) {
        new WriteTipBubbleController(getPageContext(), new WriteTipBubbleController.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.a
            public void f(View view2, String str2) {
                view.performClick();
                hVar.bBW();
                hVar.bCc().getInputView().setText(str2);
                Editable text = hVar.bCc().getInputView().getText();
                if (!TextUtils.isEmpty(text)) {
                    hVar.bCc().getInputView().setSelection(text.length());
                }
            }
        }).a(view, getString(R.string.open_editor_tips), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
    }

    public void dqj() {
        this.lWW = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, final p pVar) {
                if (NewSubPbActivity.this.lWS != null) {
                    NewSubPbActivity.this.lWS.dqu();
                    if (!z) {
                        NewSubPbActivity.this.bL(i, str);
                        return;
                    }
                    NewSubPbActivity.this.lWS.hideNoDataView();
                    if (pVar != null) {
                        if (pVar.djF() != null || NewSubPbActivity.this.lWQ != null) {
                            pVar.djF().a(NewSubPbActivity.this.lWQ.dqX());
                        }
                        if (NewSubPbActivity.this.lWS != null) {
                            NewSubPbActivity.this.tf(pVar.bkV() != null && pVar.bkV().isBjh());
                            if (NewSubPbActivity.this.kKo != null && NewSubPbActivity.this.kKo.bAP() != null) {
                                NewSubPbActivity.this.kKo.bAP().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.lWS.a(pVar, NewSubPbActivity.this.lWQ.djc(), NewSubPbActivity.this.lWQ.dqZ() != null, NewSubPbActivity.this.lXa);
                            if (NewSubPbActivity.this.lXa) {
                                NewSubPbActivity.this.lWS.getListView().setSelectionFromTop(NewSubPbActivity.this.lWS.getListView().getHeaderViewsCount() + 1, -l.getDimens(NewSubPbActivity.this, R.dimen.tbds18));
                                NewSubPbActivity.this.dqk();
                                NewSubPbActivity.this.lXa = false;
                            }
                        }
                        if (NewSubPbActivity.this.kKo != null) {
                            NewSubPbActivity.this.kKo.a(pVar.cAh());
                            NewSubPbActivity.this.kKo.setThreadData(pVar.bkV());
                            if (NewSubPbActivity.this.getIntent() != null && NewSubPbActivity.this.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && NewSubPbActivity.this.lXh) {
                                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        NewSubPbActivity.this.lXh = false;
                                        NewSubPbActivity.this.c(pVar.djF(), false);
                                    }
                                }, 200L);
                            }
                        }
                        if (NewSubPbActivity.this.lXd == null) {
                            NewSubPbActivity.this.lXd = new com.baidu.tieba.pb.e();
                        }
                        NewSubPbActivity.this.lXd.setData(pVar);
                        NewSubPbActivity.this.lXd.setType(0);
                        NewSubPbActivity.this.kKi.a(NewSubPbActivity.this.lWQ.drc());
                    }
                    String stringExtra = NewSubPbActivity.this.getIntent().getStringExtra("key_open_editor_tips");
                    if (!TextUtils.isEmpty(stringExtra) && !NewSubPbActivity.this.lEz) {
                        NewSubPbActivity.this.lEz = true;
                        NewSubPbActivity.this.a(NewSubPbActivity.this.lWS.cHl(), NewSubPbActivity.this.kKo, stringExtra);
                    }
                }
            }
        };
        this.lJK = new a.InterfaceC0557a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0557a
            public void g(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.lIE != null) {
                        NewSubPbActivity.this.lIE.iY(z2);
                    }
                    MarkData bjH = NewSubPbActivity.this.lIE.bjH();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(bjH);
                        if (NewSubPbActivity.this.lIE != null) {
                            if (bjH != null) {
                                NewSubPbActivity.this.lWQ.vR(true);
                                NewSubPbActivity.this.lWQ.Ph(NewSubPbActivity.this.lWQ.bBr());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.lWS != null) {
                                NewSubPbActivity.this.lWS.vQ(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.lWQ.vR(false);
                        NewSubPbActivity.this.lWQ.Ph(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.lWS != null) {
                            NewSubPbActivity.this.lWS.vQ(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.lWY = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.lWQ.dqL() != null && NewSubPbActivity.this.lWQ.dqL().bkV() != null && NewSubPbActivity.this.lWQ.dqL().bkV().bnx() != null) {
                    str = String.valueOf(NewSubPbActivity.this.lWQ.dqL().bkV().bnx().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.lWQ.dqL().bBS().getId(), NewSubPbActivity.this.lWQ.dqL().bBS().getName(), NewSubPbActivity.this.lWQ.dqL().bkV().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.lWZ = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.lWR.dMh() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.lWQ != null && NewSubPbActivity.this.lWQ.dqL() != null && NewSubPbActivity.this.lWQ.dqL().bBS() != null && NewSubPbActivity.this.lWQ.dqL().bkV() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.lWR.Su(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.lWR.a(NewSubPbActivity.this.lWQ.dqL().bBS().getId(), NewSubPbActivity.this.lWQ.dqL().bBS().getName(), NewSubPbActivity.this.lWQ.dqL().bkV().getId(), valueOf, i2, i, z, NewSubPbActivity.this.lWQ.dqL().bkV().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.lWX = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.lWS.a(NewSubPbActivity.this.lWR.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.lWR.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.lYg != 1002 || bVar.hgB) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.lWS.a(1, dVar.mSuccess, dVar.npN, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean dI(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void bYg() {
        registerListener(this.jch);
        this.aYB = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                if (view != null || NewSubPbActivity.this.lWS != null) {
                    if (view == NewSubPbActivity.this.lWS.dqF()) {
                        NewSubPbActivity.this.lWS.doP();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                be.bsB().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.lWS.cHl()) {
                        if (view != NewSubPbActivity.this.lWS.dqy()) {
                            if (view == NewSubPbActivity.this.lWS.dqx()) {
                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                    NewSubPbActivity.this.lWS.dqn();
                                    NewSubPbActivity.this.lWS.dqo();
                                    if (NewSubPbActivity.this.kKo != null) {
                                        NewSubPbActivity.this.kKo.bCa();
                                    }
                                }
                            } else if (view.getId() != R.id.pb_floor_feedback) {
                                if (view == NewSubPbActivity.this.lWS.dqs()) {
                                    NewSubPbActivity.this.lWS.doP();
                                    if (NewSubPbActivity.this.lWQ.loadData()) {
                                        NewSubPbActivity.this.lWS.dqq();
                                    }
                                } else if (view == NewSubPbActivity.this.lWS.dqz() || view == NewSubPbActivity.this.lWS.dqA() || view == NewSubPbActivity.this.lWS.dqC()) {
                                    if (NewSubPbActivity.this.lXc) {
                                        NewSubPbActivity.this.lXc = false;
                                        return;
                                    }
                                    if (NewSubPbActivity.this.lWQ.dqL() != null && NewSubPbActivity.this.lWQ.dqL().bkV() != null) {
                                        z2 = ay.a(NewSubPbActivity.this.lWQ.dqL().bkV().getBaijiahaoData());
                                    }
                                    if (z2) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.lWQ.dme(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.lWQ.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.lWQ.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.lWQ.dqL() != null && NewSubPbActivity.this.lWQ.dqL().bkV() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.lWQ.dqL().bkV().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.lWQ.dme(), NewSubPbActivity.this.lWQ.bBr(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.lWQ.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.lWQ.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.lWS.dqD() == null || view != NewSubPbActivity.this.lWS.dqD().dnf()) {
                                    if (NewSubPbActivity.this.lWS.dqD() == null || view != NewSubPbActivity.this.lWS.dqD().dni()) {
                                        if (NewSubPbActivity.this.lWS.dqD() == null || view != NewSubPbActivity.this.lWS.dqD().dng()) {
                                            if (NewSubPbActivity.this.lWS.dqD() == null || view != NewSubPbActivity.this.lWS.dqD().dnh()) {
                                                if (NewSubPbActivity.this.lWS.dqD() == null || view != NewSubPbActivity.this.lWS.dqD().dnj()) {
                                                    if (view == NewSubPbActivity.this.lWS.dqw() || view == NewSubPbActivity.this.lWS.dqC()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.kKo.bBX()) {
                                                                NewSubPbActivity.this.kKo.bBY();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.kKo.CM(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view != null && (view.getTag() instanceof PbCommenFloorItemViewHolder)) {
                                                        NewSubPbActivity.this.lXf = (PbCommenFloorItemViewHolder) view.getTag();
                                                        if (bg.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.lXc) {
                                                                NewSubPbActivity.this.lXc = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.kKi == null || NewSubPbActivity.this.lWQ == null || NewSubPbActivity.this.lWQ.cAh() == null || NewSubPbActivity.this.kKi.os(NewSubPbActivity.this.lWQ.cAh().replyPrivateFlag)) && (sparseArray2 = (SparseArray) view.getTag(R.id.tag_from)) != null) {
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
                                                        if (NewSubPbActivity.this.lWT == null || view != NewSubPbActivity.this.lWT.dnh()) {
                                                            if (NewSubPbActivity.this.lWT == null || view != NewSubPbActivity.this.lWT.dnf()) {
                                                                if (NewSubPbActivity.this.lWT == null || view != NewSubPbActivity.this.lWT.dni()) {
                                                                    if (NewSubPbActivity.this.lWT == null || view != NewSubPbActivity.this.lWT.dnj()) {
                                                                        if (NewSubPbActivity.this.lWT == null || view != NewSubPbActivity.this.lWT.dnl()) {
                                                                            if (NewSubPbActivity.this.lWT == null || view != NewSubPbActivity.this.lWT.dnm()) {
                                                                                if (NewSubPbActivity.this.lWT == null || view != NewSubPbActivity.this.lWT.dnn()) {
                                                                                    if (NewSubPbActivity.this.lWT != null && view == NewSubPbActivity.this.lWT.dng()) {
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
                                                                                                NewSubPbActivity.this.lWS.dN(view);
                                                                                                return;
                                                                                            } else if (booleanValue2) {
                                                                                                NewSubPbActivity.this.lWS.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                                            String string2 = com.baidu.tbadk.core.sharedPref.b.brx().getString("tail_link", "");
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
                                                                                            if (postData2.getType() != PostData.eOs && !TextUtils.isEmpty(postData2.getBimg_url()) && k.bkB().isShowImages()) {
                                                                                                NewSubPbActivity.this.Pe(postData2.getId());
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
                                                                                    if (postData3.bpr() != null) {
                                                                                        NewSubPbActivity.this.d(postData3.bpr());
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.lJc != null && !TextUtils.isEmpty(NewSubPbActivity.this.lJd)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.eGK == null) {
                                                                                        NewSubPbActivity.this.eGK = new at(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.eGK.p(NewSubPbActivity.this.lJd, NewSubPbActivity.this.lJc.getImageByte());
                                                                                    NewSubPbActivity.this.lJc = null;
                                                                                    NewSubPbActivity.this.lJd = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.lJc != null && !TextUtils.isEmpty(NewSubPbActivity.this.lJd)) {
                                                                            if (NewSubPbActivity.this.lJe == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.lJd));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.lJd;
                                                                                aVar.pkgId = NewSubPbActivity.this.lJe.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.lJe.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.lJc = null;
                                                                            NewSubPbActivity.this.lJd = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.khK != null) {
                                                                        NewSubPbActivity.this.khK.gT(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.khK = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                if (sparseArray5 != null && (sparseArray5.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_id) instanceof String) && (sparseArray5.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.lWS.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.dG(view);
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
                                                                NewSubPbActivity.this.OB((String) tag);
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
                                                            if (NewSubPbActivity.this.lWQ != null) {
                                                                TiebaStatic.log(new aq("c13700").dW("tid", NewSubPbActivity.this.lWQ.dmf()).dW("fid", NewSubPbActivity.this.lWQ.getFromForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dW("post_id", postData.getId()).an("obj_source", 1).an("obj_type", 3));
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
                                                        ((PostData) sparseArray8.get(R.id.tag_clip_board)).gT(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new aq("c11739").an("obj_locate", 4));
                                            if (!j.isNetWorkAvailable()) {
                                                NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.lWS.doP();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.OB(str4);
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
                                            NewSubPbActivity.this.lWS.doP();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.dQ(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.lWS.doP();
                                    SparseArray sparseArray10 = (SparseArray) view.getTag();
                                    if (sparseArray10 != null) {
                                        NewSubPbActivity.this.lWS.a(((Integer) sparseArray10.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray10.get(R.id.tag_del_post_id), ((Integer) sparseArray10.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new aq("c11739").an("obj_locate", 2));
                                    NewSubPbActivity.this.lWS.doP();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.lWQ.dqL() != null) {
                                        NewSubPbActivity.this.n(NewSubPbActivity.this.lWQ.dqL().djF());
                                    }
                                }
                            } else {
                                try {
                                    sparseArray3 = (SparseArray) view.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                }
                                if (sparseArray3 != null && ((PostData) sparseArray3.get(R.id.tag_clip_board)) != null) {
                                    if (NewSubPbActivity.this.lWT == null) {
                                        NewSubPbActivity.this.lWT = new aa(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aYB);
                                        NewSubPbActivity.this.lWS.dR(NewSubPbActivity.this.lWT.getView());
                                        NewSubPbActivity.this.lWT.va(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.lWT.Pd();
                                    if (NewSubPbActivity.this.uL(sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin()) {
                                        z2 = true;
                                    }
                                    NewSubPbActivity.this.lWT.a(sparseArray3, NewSubPbActivity.this.djc(), z2);
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.lWS.dqn();
                            NewSubPbActivity.this.lWS.dqo();
                            if (NewSubPbActivity.this.kKo != null) {
                                NewSubPbActivity.this.kKo.bBZ();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.dlc();
                        if (NewSubPbActivity.this.lWQ != null && NewSubPbActivity.this.lWQ.dqL() != null && NewSubPbActivity.this.lWQ.dqL().bkV() != null && NewSubPbActivity.this.lWQ.dqL().bkV().bnx() != null) {
                            TiebaStatic.log(new aq("c13402").dW("tid", NewSubPbActivity.this.lWQ.dme()).w("fid", NewSubPbActivity.this.lWQ.dqL().bkV().getFid()).an("obj_locate", 5).dW("uid", NewSubPbActivity.this.lWQ.dqL().bkV().bnx().getUserId()));
                        }
                    }
                }
            }
        };
        this.lWU = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.lWS.doP();
                    if (NewSubPbActivity.this.lDQ != 2 && NewSubPbActivity.this.lDQ != 1) {
                        NewSubPbActivity.this.lWS.dqI();
                    }
                }
                NewSubPbActivity.this.kKo.bBY();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.lWS.dqE();
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
                if (NewSubPbActivity.this.lWS != null && NewSubPbActivity.this.lWS.dqv()) {
                    return false;
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null && NewSubPbActivity.this.dI(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.lJc = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.lJd = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.lJc == null || TextUtils.isEmpty(NewSubPbActivity.this.lJd)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lJe = null;
                        } else {
                            NewSubPbActivity.this.lJe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.lJc = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.lJd = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lJe = null;
                        } else {
                            NewSubPbActivity.this.lJe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.lJc = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.lJd = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lJe = null;
                        } else {
                            NewSubPbActivity.this.lJe = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        NewSubPbActivity.this.lWS.a(NewSubPbActivity.this.lJR, NewSubPbActivity.this.lJc.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.khK = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.khK == null || NewSubPbActivity.this.lIE == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.lIE != null) {
                            NewSubPbActivity.this.lIE.iY(NewSubPbActivity.this.lWQ.dqS());
                        }
                        boolean z2 = NewSubPbActivity.this.lIE.bjE() && NewSubPbActivity.this.khK.getId() != null && NewSubPbActivity.this.khK.getId().equals(NewSubPbActivity.this.lWQ.dqU());
                        if (NewSubPbActivity.this.lWT == null) {
                            NewSubPbActivity.this.lWT = new aa(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aYB);
                            NewSubPbActivity.this.lWS.dR(NewSubPbActivity.this.lWT.getView());
                            NewSubPbActivity.this.lWT.va(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.lWT.Pd();
                        boolean z3 = NewSubPbActivity.this.uL(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z4 = (NewSubPbActivity.this.lWQ.dqL() == null || NewSubPbActivity.this.lWQ.dqL().bkV() == null || !NewSubPbActivity.this.lWQ.dqL().bkV().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z2) {
                            NewSubPbActivity.this.lWT.dnf().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.lWT.dnf().setText(R.string.mark);
                        }
                        if (booleanValue || z4) {
                            NewSubPbActivity.this.lWT.dnf().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.lWT.dnf().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.dI(view)) {
                            if (NewSubPbActivity.this.lJc != null && !NewSubPbActivity.this.lJc.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        aa aaVar = NewSubPbActivity.this.lWT;
                        int djc = NewSubPbActivity.this.djc();
                        if (NewSubPbActivity.this.lIB && NewSubPbActivity.this.khK.nnK) {
                            z = true;
                        }
                        aaVar.a(sparseArray2, djc, z3, z);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.lWV = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                        p dqL = NewSubPbActivity.this.lWQ.dqL();
                        TbRichText bG = NewSubPbActivity.this.bG(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bG != null && bG.bHf() != null) {
                            tbRichTextData = bG.bHf().get(NewSubPbActivity.this.lJO);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!tbRichTextData.bHl().bHw()) {
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
                                if (dqL == null) {
                                    str4 = null;
                                } else {
                                    if (dqL.bBS() != null) {
                                        str5 = dqL.bBS().getName();
                                        str6 = dqL.bBS().getId();
                                    }
                                    if (dqL.bkV() != null) {
                                        str7 = dqL.bkV().getId();
                                    }
                                    z5 = true;
                                    str4 = str7;
                                }
                                if (NewSubPbActivity.this.lWQ.dqZ() != null) {
                                    concurrentHashMap = NewSubPbActivity.this.lWQ.dqZ();
                                    z4 = NewSubPbActivity.this.lWQ.drb();
                                    arrayList = NewSubPbActivity.this.lWQ.dra();
                                } else {
                                    z4 = z5;
                                }
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(x.getItem(arrayList, 0));
                                ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                                aVar.s(arrayList2).zs(str5).zt(str6).zu(str4).je(z4).zv(arrayList.get(0)).jf(true).d(concurrentHashMap).jg(true).jh(false).ji(false).s(NewSubPbActivity.this.bkV()).zw(String.valueOf(bG.getPostId())).zx(NewSubPbActivity.this.lWQ.getFromForumId());
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar.eQ(NewSubPbActivity.this.getPageContext().getPageActivity())));
                                return;
                            }
                            NewSubPbActivity.this.lJP = false;
                            TbRichText dLo = dqL.djF().dLo();
                            int size = arrayList.size();
                            int a2 = NewSubPbActivity.this.a(dLo, bG, i, i, arrayList, concurrentHashMap);
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
                            if (dqL == null) {
                                str3 = null;
                            } else {
                                if (dqL.bBS() != null) {
                                    str8 = dqL.bBS().getName();
                                    str9 = dqL.bBS().getId();
                                }
                                if (dqL.bkV() != null) {
                                    str10 = dqL.bkV().getId();
                                }
                                z6 = true;
                                str3 = str10;
                            }
                            if (NewSubPbActivity.this.lWQ.dqZ() != null) {
                                concurrentHashMap = NewSubPbActivity.this.lWQ.dqZ();
                                z3 = NewSubPbActivity.this.lWQ.drb();
                                arrayList = NewSubPbActivity.this.lWQ.dra();
                                a2 = NewSubPbActivity.this.lWQ.getOffset() + a2;
                            } else {
                                z3 = z6;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(x.getItem(arrayList, a2));
                            ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                            aVar2.s(arrayList3).zs(str8).zt(str9).zu(str3).je(z3).zv(str2).jf(true).d(concurrentHashMap).jg(true).jh(false).ji(false).s(NewSubPbActivity.this.bkV()).zw(String.valueOf(bG.getPostId())).zx(NewSubPbActivity.this.lWQ.getFromForumId());
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar2.eQ(NewSubPbActivity.this.getPageContext().getPageActivity())));
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
    public bz bkV() {
        if (this.lWQ == null || this.lWQ.dqL() == null) {
            return null;
        }
        return this.lWQ.dqL().bkV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dG(View view) {
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
        if (!dlb()) {
            if (postData != null) {
                if (postData.bnx() != null) {
                    MetaData bnx = postData.bnx();
                    this.kKo.setReplyId(bnx.getUserId());
                    boolean z2 = postData.nnK;
                    String str = "";
                    if (postData.dLo() != null) {
                        str = postData.dLo().toString();
                    }
                    this.kKo.CO(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bnx().getName_show(), str));
                    if (z2) {
                        if (!z) {
                            this.kKo.CN("");
                        }
                    } else if (!z) {
                        this.kKo.CN(bnx.getName_show());
                    }
                }
                this.lWS.dqo();
            }
            if (this.lXe) {
                vO(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(AgreeData agreeData) {
        com.baidu.tbadk.pageExtra.c fr;
        int i = 1;
        if (agreeData != null) {
            if (this.fcq == null) {
                this.fcq = new com.baidu.tbadk.core.message.a();
            }
            if (this.fbZ == null) {
                this.fbZ = new e();
                this.fbZ.uniqueId = this.lXg;
            }
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eJO = 12;
            dVar.eJU = 9;
            dVar.eJT = 3;
            if (dqm() != null) {
                dVar.eJS = dqm().drd();
            }
            if (dVar != null) {
                dVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (dVar != null) {
                        dVar.eJV = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (dVar != null) {
                        dVar.eJV = 1;
                        i = 0;
                    }
                }
                fr = com.baidu.tbadk.pageExtra.d.fr(getActivity());
                if (fr != null) {
                    agreeData.objSource = fr.getCurrentPageKey();
                }
                this.fcq.a(agreeData, i, getUniqueId(), false);
                this.fcq.a(agreeData, this.fbZ);
                if (dqm() == null && dqm().dqL() != null) {
                    this.fcq.a(this, dVar, agreeData, dqm().dqL().bkV());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (dVar != null) {
                dVar.eJV = 1;
            }
            i = 0;
            fr = com.baidu.tbadk.pageExtra.d.fr(getActivity());
            if (fr != null) {
            }
            this.fcq.a(agreeData, i, getUniqueId(), false);
            this.fcq.a(agreeData, this.fbZ);
            if (dqm() == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        TbRichTextImageInfo bHl;
        if (tbRichText == tbRichText2) {
            this.lJP = true;
        }
        if (tbRichText != null && tbRichText.bHf() != null) {
            int size = tbRichText.bHf().size();
            int i3 = -1;
            int i4 = 0;
            int i5 = i;
            while (i4 < size) {
                if (tbRichText.bHf().get(i4) != null && tbRichText.bHf().get(i4).getType() == 8) {
                    i3++;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.bHf().get(i4).bHl().getWidth() * equipmentDensity;
                    int height = tbRichText.bHf().get(i4).bHl().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.bHf().get(i4).bHl().bHw()) {
                        if (tbRichText == tbRichText2 && i3 <= i2) {
                            i5--;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.bHf().get(i4);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (bHl = tbRichTextData.bHl()) != null) {
                            String bHy = bHl.bHy();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = bHy;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.lJP) {
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
        if (this.lWT != null) {
            this.lWT.va(z);
        }
        if (this.lWS != null) {
            this.lWS.va(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bHl = tbRichTextData.bHl();
        if (bHl != null) {
            if (!StringUtils.isNull(bHl.bHv())) {
                return bHl.bHv();
            }
            if (bHl.getHeight() * bHl.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bHl.getHeight() * bHl.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bHl.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bHl.getHeight())));
            } else {
                float width = bHl.getWidth() / bHl.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.at.getUrlEncode(bHl.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bG(String str, int i) {
        if (this.lWQ == null || this.lWQ.dqL() == null || str == null || i < 0) {
            return null;
        }
        p dqL = this.lWQ.dqL();
        TbRichText a2 = a(dqL.djF(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(dqL.djF(), str, i);
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
        TbRichText dLo = postData.dLo();
        if (dLo != null) {
            ArrayList<TbRichTextData> bHf = dLo.bHf();
            int size = bHf.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (bHf.get(i3) != null && bHf.get(i3).getType() == 8) {
                    i2++;
                    if (bHf.get(i3).bHl().bHy().equals(str)) {
                        int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = bHf.get(i3).bHl().getWidth() * equipmentDensity;
                        int height = bHf.get(i3).bHl().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.lJO = i3;
                        return dLo;
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

    private boolean dlb() {
        if (this.lWQ == null) {
            return false;
        }
        return AntiHelper.a(getPageContext(), this.lWQ.cAh());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlc() {
        Intent intent = getIntent();
        boolean booleanExtra = intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false;
        if (!dlb()) {
            if (booleanExtra) {
                if (this.kKi == null || this.lWQ == null || this.lWQ.cAh() == null || this.kKi.os(this.lWQ.cAh().replyPrivateFlag)) {
                    if (this.kKo.bBL()) {
                        this.kKo.a((PostWriteCallBackData) null);
                        return;
                    }
                    this.lWS.dqn();
                    this.lWS.dqo();
                    if (this.kKo != null) {
                        this.kKo.bCb();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.jeV == null) {
                this.jeV = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jeV.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qC(boolean z) {
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
                    public void qD(boolean z) {
                        String str;
                        if (z) {
                            if (NewSubPbActivity.this.kKi == null || NewSubPbActivity.this.lWQ == null || NewSubPbActivity.this.lWQ.cAh() == null || NewSubPbActivity.this.kKi.os(NewSubPbActivity.this.lWQ.cAh().replyPrivateFlag)) {
                                if (NewSubPbActivity.this.lWQ != null && NewSubPbActivity.this.lWQ.dqL() != null && NewSubPbActivity.this.lWQ.dqL().djF() != null) {
                                    PostData djF = NewSubPbActivity.this.lWQ.dqL().djF();
                                    if (djF.dLo() != null && djF.bnx() != null) {
                                        str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), djF.bnx().getName_show(), djF.dLo().toString());
                                        NewSubPbActivity.this.kKo.bAP().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                                        if (!NewSubPbActivity.this.kKo.bBL()) {
                                            NewSubPbActivity.this.kKo.a((PostWriteCallBackData) null);
                                            return;
                                        }
                                        NewSubPbActivity.this.lWS.dqn();
                                        NewSubPbActivity.this.lWS.dqo();
                                        if (NewSubPbActivity.this.kKo != null) {
                                            NewSubPbActivity.this.kKo.bCb();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                str = null;
                                NewSubPbActivity.this.kKo.bAP().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                                if (!NewSubPbActivity.this.kKo.bBL()) {
                                }
                            }
                        }
                    }
                });
            }
            if (this.lWQ != null && this.lWQ.dqL() != null && this.lWQ.dqL().bBS() != null) {
                this.jeV.H(this.lWQ.dqL().bBS().getId(), com.baidu.adp.lib.f.b.toLong(this.lWQ.dme(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uL(boolean z) {
        if (this.lWQ == null) {
            return false;
        }
        return ((djc() != 0) || this.lWQ.dqL() == null || this.lWQ.dqL().bkV() == null || this.lWQ.dqL().bkV().bnx() == null || this.lWQ.dqL().bkV().bmg() || TextUtils.equals(this.lWQ.dqL().bkV().bnx().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(int i, String str) {
        if (this.lWQ.dqM()) {
            showToast(str);
        } else if (l.isNetOk()) {
            if (i == 4) {
                this.lWS.HW(str + "(4)");
            } else {
                this.lWS.CH(R.string.no_data_text);
            }
        } else {
            this.lWS.CH(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tf(boolean z) {
        this.kKo = (com.baidu.tbadk.editortools.pb.h) new i(z).fh(getActivity());
        if (this.kKo != null) {
            this.kKo.a(getPageContext());
            this.kKo.b(this.lWQ);
            this.kKo.b(this.khj);
            this.kKo.setFrom(2);
            this.kKo.a(this.fBz);
            this.kKo.a(this.fBA);
            this.kKo.bAP().kK(true);
            this.kKo.j(getPageContext());
        }
        if (this.lWS != null) {
            this.lWS.i(this.kKo);
        }
        if (this.kKo != null && this.lWQ != null) {
            this.kKo.a(this.lWQ.cAh());
            this.kKo.bBY();
        }
        if (this.kKo != null) {
            this.kKo.bCc().setDefaultHint(dnZ());
            this.kKo.bCc().setHint(dnZ());
            this.khd = this.kKo.bCc().getInputView();
            this.khd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.khc != null) {
                        if (!NewSubPbActivity.this.khc.dUc()) {
                            NewSubPbActivity.this.sf(false);
                        }
                        NewSubPbActivity.this.khc.yY(false);
                    }
                }
            });
        }
    }

    public void dqk() {
        if (!TbadkCoreApplication.isLogin()) {
            this.kKo.bBY();
        } else if (!StringUtils.isNull(this.lWQ.dqV())) {
            if (this.lWS.dqr() && l.isNetOk()) {
                this.lWS.cyg();
            } else {
                this.lWS.dqu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQ(View view) {
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
                    this.lWS.dN(view);
                }
            } else if (booleanValue2) {
                this.lWS.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.lWS.dqB(), getPageContext().getPageActivity());
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
            bVar.nz(R.string.operation);
            bVar.a(strArr, new b.InterfaceC0561b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0561b
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.lXb);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.lXb);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).bqg();
        }
    }

    public void f(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.lWS.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.lXb;
        userMuteCheckCustomMessage.setTag(this.lXb);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.lWS.a(0, bVar.mSuccess, bVar.npN, z);
            if (bVar.mSuccess) {
                if (bVar.iHw == 1) {
                    if (this.lWS.getListView() instanceof BdTypeListView) {
                        List<com.baidu.adp.widget.ListView.n> data = ((BdTypeListView) this.lWS.getListView()).getData();
                        if (!x.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.lWS.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.iHw == 2) {
                    this.lWQ.Pg(bVar.mPostId);
                    this.lWS.a(this.lWQ.dqL(), this.lWQ.djc(), this.lWQ.dqZ() != null, false);
                    if (this.lWQ.dqW()) {
                        this.lWQ.vS(false);
                        this.lWS.dqp();
                        this.lWQ.loadData();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void OB(String str) {
        if (this.lWQ != null && this.lWQ.dqL() != null && this.lWQ.dqL().bkV() != null && this.lWQ.dqL().bkV().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lWQ.dme(), str);
            bz bkV = this.lWQ.dqL().bkV();
            if (bkV.bme()) {
                format = format + "&channelid=33833";
            } else if (bkV.bpu()) {
                format = format + "&channelid=33842";
            } else if (bkV.bmf()) {
                format = format + "&channelid=33840";
            }
            OC(format);
            return;
        }
        this.lID.Pc(str);
    }

    private void OC(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void n(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.lWQ.dqS() && postData.getId() != null && postData.getId().equals(this.lWQ.dqU())) {
                z = true;
            }
            MarkData o = this.lWQ.o(postData);
            if (o != null) {
                this.lWS.doP();
                if (this.lIE != null) {
                    this.lIE.a(o);
                    if (!z) {
                        this.lIE.bjG();
                    } else {
                        this.lIE.bjF();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.lWQ != null) {
            this.lWQ.aD(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.kKo != null) {
            this.kKo.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.kKo.bAP().bzl();
        this.kKo.bBY();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.kKo.c(writeData);
                this.kKo.setVoiceModel(pbEditorData.getVoiceModel());
                m qP = this.kKo.bAP().qP(6);
                if (qP != null && qP.fyZ != null) {
                    qP.fyZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.kKo.bBU();
                }
                this.lWS.dqI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.jaA != null) {
            this.jaA.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.mIsPaused = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.bha().bhl();
        if (this.jaA != null) {
            this.jaA.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.joX);
        this.lWS.cJE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.mIsPaused = false;
        super.onResume();
        dlH();
        if (this.jaA != null) {
            this.jaA.onResume(getPageContext());
        }
        registerListener(this.joX);
        this.lWS.cJF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jaA != null) {
            this.jaA.onStop(getPageContext());
        }
        this.kKo.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.lXd));
        this.lWQ.cancelLoadData();
        this.lWQ.destory();
        this.lWR.cancelLoadData();
        if (this.jaA != null) {
            this.jaA.onDestory(getPageContext());
        }
        this.lWS.doP();
        this.lWS.cHM();
        MessageManager.getInstance().unRegisterListener(this.lJz);
        MessageManager.getInstance().unRegisterListener(this.lJA);
        MessageManager.getInstance().unRegisterListener(this.lJB);
        MessageManager.getInstance().unRegisterListener(this.lXb);
        this.lIY = null;
        this.lIZ = null;
        if (this.kKi != null) {
            this.kKi.onDestroy();
        }
        com.baidu.tbadk.pageExtra.d.CY(getCurrentPageKey());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lWS.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.jaA;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View dqw = this.lWS.dqw();
        if (dqw == null || (findViewWithTag = dqw.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean OU(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = be.getParamPair(be.getParamStr(str))) != null) {
            this.lXc = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return OU(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(lWP);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (OU(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.m mVar = new com.baidu.tbadk.data.m();
                    mVar.mLink = str;
                    mVar.type = 3;
                    mVar.fxW = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, mVar));
                }
            } else {
                be.bsB().b(getPageContext(), new String[]{str});
            }
            this.lXc = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.lXc = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aH(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aI(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void u(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        if (this.lWS != null) {
            return this.lWS.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bHN() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bHP() {
        if (this.fVl == null) {
            this.fVl = TbRichTextView.K(getPageContext().getPageActivity(), 8);
        }
        return this.fVl;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bHQ() {
        if (this.fRX == null) {
            this.fRX = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cvN */
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
        return this.fRX;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bHO() {
        if (this.fRW == null) {
            this.fRW = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bIa */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = k.bkB().isShowImages();
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
                        if (k.bkB().isShowImages()) {
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
        return this.fRW;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bHR() {
        if (this.fVm == null) {
            this.fVm = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dlO */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(NewSubPbActivity.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dJ */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dK */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dL */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fVm;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bHS() {
        if (this.fVn == null) {
            this.fVn = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dlQ */
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
        return this.fVn;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bHT() {
        this.fVo = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dlP */
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
        return this.fVo;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a djU() {
        return this.lEu;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean djV() {
        return (this.lWQ == null || this.lWQ.dqL() == null || this.lWQ.dqL().bkV() == null || this.lWQ.dqL().bkV().boX()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String djW() {
        if (this.lWQ == null || this.lWQ.dqL() == null || this.lWQ.dqL().bkV() == null) {
            return null;
        }
        return this.lWQ.dqL().bkV().bnB();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int djX() {
        if (this.lWQ == null) {
            return 0;
        }
        return this.lWQ.djc();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Ov(String str) {
        if (StringUtils.isNull(str) || this.lWQ == null || this.lWQ.dqL() == null || this.lWQ.dqL().bkV() == null || this.lWQ.dqL().bkV().bnx() == null) {
            return false;
        }
        return str.equals(this.lWQ.dqL().bkV().bnx().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.lWS.dqr() && l.isNetOk()) {
            this.lWQ.loadData();
        } else {
            this.lWS.dqu();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.lXb);
        userMuteAddAndDelCustomMessage.setTag(this.lXb);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pe(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.brx().getString("bubble_link", "");
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
    public void aJ(Context context, String str) {
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
                return com.baidu.tbadk.m.e.bDA().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.lWQ != null) {
            if (this.lWQ.dqL() != null && this.lWQ.dqL().bBS() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.lWQ.dqL().bBS().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.lWQ.dme(), 0L));
            if (this.lWQ.dqL() != null && this.lWQ.dqL().bkV() != null) {
                pageStayDurationItem.setNid(this.lWQ.dqL().bkV().blV());
            }
            pageStayDurationItem.setPid(com.baidu.adp.lib.f.b.toLong(this.lWQ.bBr(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public boolean dql() {
        if (this.lWQ != null) {
            return this.lWQ.dql();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.lWS.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lIY.getPageActivity());
        if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
            aVar.Ad(this.lIY.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Ad(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.lWS.showLoadingDialog();
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
        aVar.b(this.lIY).bqe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CL(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lIY.getPageActivity());
        aVar.Ad(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lIY).bqe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlD() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.Ad(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.lIY).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.lIY.getPageActivity(), 2, true, 4);
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
        aVar.b(this.lIY).bqe();
    }

    public SubPbModel dqm() {
        return this.lWQ;
    }

    public int djc() {
        if (this.lWQ != null) {
            return this.lWQ.djc();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.fzv && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fzv && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void sf(boolean z) {
        if (this.khd != null && this.khd.getText() != null) {
            int selectionEnd = this.khd.getSelectionEnd();
            SpannableStringBuilder d = this.khc.d(this.khd.getText());
            if (d != null) {
                this.khc.yY(true);
                this.khd.setText(d);
                if (z && this.khc.dUa() >= 0) {
                    this.khd.requestFocus();
                    this.khd.setSelection(this.khc.dUa());
                } else {
                    this.khd.setSelection(selectionEnd);
                }
                this.khc.yX(this.khc.dUa() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kKo != null && this.kKo.bAP() != null && this.kKo.bAP().bAT()) {
            this.kKo.bAP().bzl();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.i
    public void onPreLoad(q qVar) {
        af.a(qVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.c.a(qVar, getUniqueId(), this);
    }

    public String dnZ() {
        if (!com.baidu.tbadk.core.util.at.isEmpty(this.lRz)) {
            return this.lRz;
        }
        this.lRz = getResources().getString(com.baidu.tieba.pb.pb.main.ao.dnP());
        return this.lRz;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.lXe = z;
        vO(true);
    }

    private void vO(boolean z) {
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
        if (this.lWS != null && this.lWS.getListView() != null && this.lXf != null && this.lXf.mPosition != -1) {
            final int headerViewsCount = this.lXf.mPosition + this.lWS.getListView().getHeaderViewsCount();
            if (this.lXf.getView() != null) {
                final int height = this.lXf.getView().getHeight();
                final int height2 = ((rect.height() - this.lWS.dqH()) - this.lWS.getNavigationBarHeight()) - this.lWS.dqG();
                final int i = height - height2;
                if (i > 0) {
                    this.lWS.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.lWS != null && NewSubPbActivity.this.lWS.getListView() != null) {
                                NewSubPbActivity.this.lWS.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.lWS.getNavigationBarHeight() - i);
                            }
                        }
                    });
                } else {
                    this.lWS.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.lWS != null && NewSubPbActivity.this.lWS.getListView() != null) {
                                NewSubPbActivity.this.lWS.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.lWS.getNavigationBarHeight() + (height2 - height));
                            }
                        }
                    });
                }
            }
        }
    }

    private void dlH() {
        if (this.lWQ != null && !com.baidu.tbadk.core.util.at.isEmpty(this.lWQ.dme())) {
            com.baidu.tbadk.BdToken.c.bha().p(com.baidu.tbadk.BdToken.b.ezZ, com.baidu.adp.lib.f.b.toLong(this.lWQ.dme(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.lWQ == null || com.baidu.tbadk.core.util.at.isEmpty(this.lWQ.dme())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.lWQ.dme(), 0L);
    }
}
