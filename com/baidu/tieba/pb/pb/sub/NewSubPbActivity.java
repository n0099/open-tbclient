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
/* loaded from: classes21.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, i, com.baidu.tieba.pb.pb.a<NewSubPbActivity> {
    private static String lah = "tbgametype";
    private View.OnClickListener aTZ;
    private bd dWg;
    private com.baidu.tbadk.core.message.a eqK;
    private e equ;
    private com.baidu.adp.lib.d.b<ImageView> ffj;
    private com.baidu.adp.lib.d.b<GifView> ffk;
    private com.baidu.adp.lib.d.b<TextView> fiD;
    private com.baidu.adp.lib.d.b<View> fiE;
    private com.baidu.adp.lib.d.b<LinearLayout> fiF;
    private com.baidu.adp.lib.d.b<RelativeLayout> fiG;
    private VoiceManager hZU;
    private com.baidu.tieba.frs.profession.permission.c ieu;
    public am jOf;
    private h jOl;
    private com.baidu.tieba.write.c jcK;
    private EditText jcL;
    private com.baidu.tieba.pb.pb.main.b.a kIj;
    private com.baidu.adp.widget.ImageView.a kMB;
    private String kMC;
    private TbRichTextMemeInfo kMD;
    private com.baidu.tieba.pb.pb.report.a kMc;
    private com.baidu.tbadk.baseEditMark.a kMd;
    private com.baidu.adp.base.e kMx;
    private com.baidu.tbadk.core.view.c kMy;
    private PostWriteCallBackData kOk;
    private String kUW;
    private SubPbModel lai;
    private ForumManageModel laj;
    private com.baidu.tieba.pb.pb.sub.a lak;
    private ah lal;
    private AbsListView.OnScrollListener lam;
    private TbRichTextView.i lan;
    private SubPbModel.a lao;
    private com.baidu.adp.base.d lap;
    private BdUniqueId lau;
    private com.baidu.tieba.pb.e<p> law;
    private boolean lax;
    private n lay;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int kNn = 0;
    PostData jds = null;
    private a.InterfaceC0530a kNj = null;
    private a laq = null;
    private a lar = null;
    private boolean mIsPaused = false;
    private boolean las = false;
    private boolean lav = false;
    private boolean eNo = false;
    private com.baidu.tbadk.editortools.pb.c ePr = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bta() {
            NewSubPbActivity.this.lak.dgk();
        }
    };
    private int kHF = 0;
    private boolean mIsFromSchema = false;
    private BdUniqueId laz = BdUniqueId.gen();
    private boolean kJC = com.baidu.tbadk.a.d.baU();
    private boolean laA = true;
    private com.baidu.tbadk.editortools.pb.b ePs = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bsZ() {
            if (!NewSubPbActivity.this.jcK.dJz()) {
                return (NewSubPbActivity.this.jOf == null || NewSubPbActivity.this.lai == null || NewSubPbActivity.this.lai.coh() == null || NewSubPbActivity.this.jOf.aN(NewSubPbActivity.this.lai.coh().replyPrivateFlag, am.emS)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.jcK.dJB());
            if (NewSubPbActivity.this.jOl.btr()) {
                NewSubPbActivity.this.jOl.a(NewSubPbActivity.this.kOk);
            }
            NewSubPbActivity.this.qa(true);
            return true;
        }
    };
    private CustomMessageListener laB = new CustomMessageListener(2921481) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && NewSubPbActivity.this.lai != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && at.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), NewSubPbActivity.this.lai.dcf())) {
                if (NewSubPbActivity.this.jcK != null) {
                    NewSubPbActivity.this.jcK.SW(null);
                    NewSubPbActivity.this.jcK.bh(null);
                    NewSubPbActivity.this.jcK.xi(false);
                }
                if (NewSubPbActivity.this.jOl != null) {
                    NewSubPbActivity.this.jOl.btB();
                    NewSubPbActivity.this.jOl.reset();
                }
                NewSubPbActivity.this.lai.bsW();
            }
        }
    };
    private NewWriteModel.d jcR = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.jOl != null && NewSubPbActivity.this.jOl.bsv() != null) {
                NewSubPbActivity.this.jOl.bsv().hide();
                if (NewSubPbActivity.this.lai.dgK()) {
                    TiebaStatic.log(new aq("c10367").dF("post_id", NewSubPbActivity.this.lai.bsX()));
                }
            }
            if (z) {
                NewSubPbActivity.this.jcK.SW(null);
                NewSubPbActivity.this.jcK.bh(null);
                NewSubPbActivity.this.jcK.xi(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(NewSubPbActivity.this.getPageContext(), postWriteCallBackData);
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.jcK.bh(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.jcK.SW(postWriteCallBackData.getErrorString());
                if (!y.isEmpty(NewSubPbActivity.this.jcK.dJx())) {
                    NewSubPbActivity.this.kOk = postWriteCallBackData;
                    if (NewSubPbActivity.this.jOl.btr()) {
                        NewSubPbActivity.this.jOl.a(NewSubPbActivity.this.kOk);
                    }
                    NewSubPbActivity.this.qa(true);
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
                    aVar.zV(NewSubPbActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.zV(postWriteCallBackData.getErrorString());
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
                aVar.b(NewSubPbActivity.this.getPageContext()).bia();
                TiebaStatic.log(new aq("c13745").ai("obj_locate", 1).ai("obj_type", 2));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.jOf != null) {
                NewSubPbActivity.this.jOf.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.lak.dgl();
        }
    };
    private CustomMessageListener kMY = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.lau) {
                NewSubPbActivity.this.lak.bXZ();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.kMy.showSuccessToast(NewSubPbActivity.this.kMx.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.kMx.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.CA(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.dbE();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (at.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.kMx.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.kMy.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener kMZ = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.lau) {
                NewSubPbActivity.this.lak.bXZ();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.kMy.showSuccessToast(NewSubPbActivity.this.kMx.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (at.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.kMx.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.kMy.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener kNa = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.lau) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.lak.bXZ();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.mDo;
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
                    NewSubPbActivity.this.lak.a(sparseArray, z);
                }
            }
        }
    };
    private final f.c fOd = new f.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (NewSubPbActivity.this.lai != null) {
                NewSubPbActivity.this.lai.dgI();
            }
        }
    };
    boolean kNo = false;
    private final b.InterfaceC0533b kNq = new b.InterfaceC0533b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0533b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.kMB != null && !TextUtils.isEmpty(NewSubPbActivity.this.kMC)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.kMD == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.kMC));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.kMC;
                        aVar.pkgId = NewSubPbActivity.this.kMD.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.kMD.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.dWg == null) {
                            NewSubPbActivity.this.dWg = new bd(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.dWg.j(NewSubPbActivity.this.kMC, NewSubPbActivity.this.kMB.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.kMB = null;
                NewSubPbActivity.this.kMC = null;
            }
        }
    };
    private CustomMessageListener jpv = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener ibA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    m mVar = (m) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.lai.dgC() != null && NewSubPbActivity.this.lai.dgC().cZH() != null && NewSubPbActivity.this.lai.dgC().cZH().bfy() != null && currentAccount.equals(NewSubPbActivity.this.lai.dgC().cZH().bfy().getUserId()) && NewSubPbActivity.this.lai.dgC().cZH().bfy().getPendantData() != null) {
                        NewSubPbActivity.this.lai.dgC().cZH().bfy().getPendantData().zE(mVar.bdu());
                        NewSubPbActivity.this.lai.dgC().cZH().bfy().getPendantData().cZ(mVar.brU());
                        NewSubPbActivity.this.lak.a(NewSubPbActivity.this.lai.dgC(), NewSubPbActivity.this.lai.dgC().cZH(), NewSubPbActivity.this.lai.dgC().cLj(), NewSubPbActivity.this.lai.dgC().bbu(), NewSubPbActivity.this.lai.cZg(), NewSubPbActivity.this.lai.dgQ() != null);
                    }
                }
            }
        }
    };

    /* loaded from: classes21.dex */
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
        this.kMx = getPageContext();
        this.las = true;
        this.jcK = new com.baidu.tieba.write.c();
        this.jcK.JW(R.color.cp_cont_h_alpha85);
        this.jcK.JV(R.color.cp_cont_a);
        bNr();
        dga();
        initData(bundle);
        initUI();
        ((SubPbView) this.lak.getRootView()).show();
        rw(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lak.uf(this.mIsFromSchema);
        this.kMy = new com.baidu.tbadk.core.view.c();
        this.kMy.toastTime = 1000L;
        registerListener(this.kNa);
        registerListener(this.kMY);
        registerListener(this.kMZ);
        registerListener(this.laB);
        this.lau = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.lau;
        userMuteAddAndDelCustomMessage.setTag(this.lau);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.lau;
        userMuteCheckCustomMessage.setTag(this.lau);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.jOf = new am(getPageContext());
        this.jOf.a(new am.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.jOl.btz();
                }
            }
        });
        this.kMc = new com.baidu.tieba.pb.pb.report.a(this);
        this.kMc.w(getUniqueId());
        this.kIj = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.lak = new com.baidu.tieba.pb.pb.sub.a(this, this.aTZ);
        this.lak.a(this.lai);
        setContentView(this.lak.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.lak.setOnScrollListener(this.lam);
        this.lak.b(this);
        this.lak.setOnImageClickListener(this.lan);
        this.lak.setOnLongClickListener(this.mOnLongClickListener);
        this.lak.f(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.lai != null) {
                    NewSubPbActivity.this.lai.loadData();
                }
            }
        });
        this.lak.a(this.laq);
        this.lak.b(this.lar);
        this.lak.setListPullRefreshListener(this.fOd);
        if (this.lai != null && this.lai.dgc() && !this.lai.dgP()) {
            this.lak.dgq().setVisibility(8);
        } else {
            this.lak.dgq().setVisibility(0);
        }
        if (this.lai != null && !this.lai.dgc()) {
            this.lak.setIsFromPb(false);
        }
    }

    private boolean aD(Bundle bundle) {
        if (bundle != null) {
            this.eNo = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.eNo = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.eNo;
    }

    public void initData(Bundle bundle) {
        this.lai = new SubPbModel(getPageContext());
        this.lai.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                NewSubPbActivity.this.lak.u(postData);
                NewSubPbActivity.this.lak.b((BdListView.e) null);
            }
        });
        this.laj = new ForumManageModel(getPageContext());
        this.laj.setLoadDataCallBack(this.lap);
        this.hZU = new VoiceManager();
        this.hZU.onCreate(getPageContext());
        this.kMd = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.kMd != null) {
            this.kMd.a(this.kNj);
        }
        if (bundle != null) {
            this.lai.initWithBundle(bundle);
        } else {
            this.lai.initWithIntent(getIntent());
        }
        this.lai.a(this.lao);
        if (this.lai.dgc() && !this.lai.dgV()) {
            this.lai.loadData();
        } else {
            this.lai.dgH();
        }
    }

    public void dga() {
        this.lao = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, final p pVar) {
                if (NewSubPbActivity.this.lak != null) {
                    NewSubPbActivity.this.lak.dgl();
                    if (!z) {
                        NewSubPbActivity.this.bx(i, str);
                        return;
                    }
                    NewSubPbActivity.this.lak.hideNoDataView();
                    if (pVar != null) {
                        if (pVar.cZH() != null || NewSubPbActivity.this.lai != null) {
                            pVar.cZH().a(NewSubPbActivity.this.lai.dgO());
                        }
                        if (NewSubPbActivity.this.lak != null) {
                            NewSubPbActivity.this.rw(pVar.bcY() != null && pVar.bcY().isBjh());
                            if (NewSubPbActivity.this.jOl != null && NewSubPbActivity.this.jOl.bsv() != null) {
                                NewSubPbActivity.this.jOl.bsv().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.lak.a(pVar, NewSubPbActivity.this.lai.cZg(), NewSubPbActivity.this.lai.dgQ() != null, NewSubPbActivity.this.las);
                            if (NewSubPbActivity.this.las) {
                                NewSubPbActivity.this.lak.getListView().setSelectionFromTop(NewSubPbActivity.this.lak.getListView().getHeaderViewsCount() + 1, -l.getDimens(NewSubPbActivity.this, R.dimen.tbds18));
                                NewSubPbActivity.this.dgb();
                                NewSubPbActivity.this.las = false;
                            }
                        }
                        if (NewSubPbActivity.this.jOl != null) {
                            NewSubPbActivity.this.jOl.a(pVar.coh());
                            NewSubPbActivity.this.jOl.setThreadData(pVar.bcY());
                            if (NewSubPbActivity.this.getIntent() != null && NewSubPbActivity.this.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && NewSubPbActivity.this.laA) {
                                com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        NewSubPbActivity.this.laA = false;
                                        NewSubPbActivity.this.c(pVar.cZH(), false);
                                    }
                                }, 200L);
                            }
                        }
                        if (NewSubPbActivity.this.law == null) {
                            NewSubPbActivity.this.law = new com.baidu.tieba.pb.e();
                        }
                        NewSubPbActivity.this.law.setData(pVar);
                        NewSubPbActivity.this.law.setType(0);
                        NewSubPbActivity.this.jOf.a(NewSubPbActivity.this.lai.dgT());
                    }
                }
            }
        };
        this.kNj = new a.InterfaceC0530a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0530a
            public void c(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.kMd != null) {
                        NewSubPbActivity.this.kMd.hy(z2);
                    }
                    MarkData bbx = NewSubPbActivity.this.kMd.bbx();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(bbx);
                        if (NewSubPbActivity.this.kMd != null) {
                            if (bbx != null) {
                                NewSubPbActivity.this.lai.uh(true);
                                NewSubPbActivity.this.lai.OC(NewSubPbActivity.this.lai.bsX());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.lak != null) {
                                NewSubPbActivity.this.lak.ug(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.lai.uh(false);
                        NewSubPbActivity.this.lai.OC(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.lak != null) {
                            NewSubPbActivity.this.lak.ug(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.laq = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.lai.dgC() != null && NewSubPbActivity.this.lai.dgC().bcY() != null && NewSubPbActivity.this.lai.dgC().bcY().bfy() != null) {
                    str = String.valueOf(NewSubPbActivity.this.lai.dgC().bcY().bfy().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.lai.dgC().btx().getId(), NewSubPbActivity.this.lai.dgC().btx().getName(), NewSubPbActivity.this.lai.dgC().bcY().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.lar = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.laj.dBo() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.lai != null && NewSubPbActivity.this.lai.dgC() != null && NewSubPbActivity.this.lai.dgC().btx() != null && NewSubPbActivity.this.lai.dgC().bcY() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.laj.Rp(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.laj.a(NewSubPbActivity.this.lai.dgC().btx().getId(), NewSubPbActivity.this.lai.dgC().btx().getName(), NewSubPbActivity.this.lai.dgC().bcY().getId(), valueOf, i2, i, z, NewSubPbActivity.this.lai.dgC().bcY().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.lap = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.lak.a(NewSubPbActivity.this.laj.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.laj.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.lby != 1002 || bVar.gkE) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.lak.a(1, dVar.Qx, dVar.mro, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean cX(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void bNr() {
        registerListener(this.ibA);
        this.aTZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
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
                if (view != null || NewSubPbActivity.this.lak != null) {
                    if (view == NewSubPbActivity.this.lak.dgw()) {
                        NewSubPbActivity.this.lak.deI();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                be.bkp().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.lak.cuh()) {
                        if (view != NewSubPbActivity.this.lak.dgp()) {
                            if (view == NewSubPbActivity.this.lak.dgo()) {
                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                    NewSubPbActivity.this.lak.dge();
                                    NewSubPbActivity.this.lak.dgf();
                                    if (NewSubPbActivity.this.jOl != null) {
                                        NewSubPbActivity.this.jOl.btF();
                                    }
                                }
                            } else if (view.getId() != R.id.pb_floor_feedback) {
                                if (view == NewSubPbActivity.this.lak.dgj()) {
                                    NewSubPbActivity.this.lak.deI();
                                    if (NewSubPbActivity.this.lai.loadData()) {
                                        NewSubPbActivity.this.lak.dgh();
                                    }
                                } else if (view == NewSubPbActivity.this.lak.dgq() || view == NewSubPbActivity.this.lak.dgr() || view == NewSubPbActivity.this.lak.dgt()) {
                                    if (NewSubPbActivity.this.lav) {
                                        NewSubPbActivity.this.lav = false;
                                        return;
                                    }
                                    if (NewSubPbActivity.this.lai.dgC() != null && NewSubPbActivity.this.lai.dgC().bcY() != null) {
                                        z2 = ay.a(NewSubPbActivity.this.lai.dgC().bcY().getBaijiahaoData());
                                    }
                                    if (z2) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.lai.dcf(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.lai.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.lai.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.lai.dgC() != null && NewSubPbActivity.this.lai.dgC().bcY() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.lai.dgC().bcY().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.lai.dcf(), NewSubPbActivity.this.lai.bsX(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.lai.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.lai.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.lak.dgu() == null || view != NewSubPbActivity.this.lak.dgu().dde()) {
                                    if (NewSubPbActivity.this.lak.dgu() == null || view != NewSubPbActivity.this.lak.dgu().ddh()) {
                                        if (NewSubPbActivity.this.lak.dgu() == null || view != NewSubPbActivity.this.lak.dgu().ddf()) {
                                            if (NewSubPbActivity.this.lak.dgu() == null || view != NewSubPbActivity.this.lak.dgu().ddg()) {
                                                if (NewSubPbActivity.this.lak.dgu() == null || view != NewSubPbActivity.this.lak.dgu().ddi()) {
                                                    if (view == NewSubPbActivity.this.lak.dgn() || view == NewSubPbActivity.this.lak.dgt()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.jOl.btC()) {
                                                                NewSubPbActivity.this.jOl.btD();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.jOl.CB(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view != null && (view.getTag() instanceof n)) {
                                                        NewSubPbActivity.this.lay = (n) view.getTag();
                                                        if (bg.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.lav) {
                                                                NewSubPbActivity.this.lav = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.jOf == null || NewSubPbActivity.this.lai == null || NewSubPbActivity.this.lai.coh() == null || NewSubPbActivity.this.jOf.ob(NewSubPbActivity.this.lai.coh().replyPrivateFlag)) && (sparseArray2 = (SparseArray) view.getTag(R.id.tag_from)) != null) {
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
                                                        if (NewSubPbActivity.this.lal == null || view != NewSubPbActivity.this.lal.ddg()) {
                                                            if (NewSubPbActivity.this.lal == null || view != NewSubPbActivity.this.lal.dde()) {
                                                                if (NewSubPbActivity.this.lal == null || view != NewSubPbActivity.this.lal.ddh()) {
                                                                    if (NewSubPbActivity.this.lal == null || view != NewSubPbActivity.this.lal.ddi()) {
                                                                        if (NewSubPbActivity.this.lal == null || view != NewSubPbActivity.this.lal.ddk()) {
                                                                            if (NewSubPbActivity.this.lal == null || view != NewSubPbActivity.this.lal.ddl()) {
                                                                                if (NewSubPbActivity.this.lal == null || view != NewSubPbActivity.this.lal.ddm()) {
                                                                                    if (NewSubPbActivity.this.lal != null && view == NewSubPbActivity.this.lal.ddf()) {
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
                                                                                                NewSubPbActivity.this.lak.dc(view);
                                                                                                return;
                                                                                            } else if (booleanValue2) {
                                                                                                NewSubPbActivity.this.lak.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                                            String string2 = com.baidu.tbadk.core.sharedPref.b.bjf().getString("tail_link", "");
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
                                                                                            if (postData2.getType() != PostData.edx && !TextUtils.isEmpty(postData2.getBimg_url()) && k.bcG().isShowImages()) {
                                                                                                NewSubPbActivity.this.Oz(postData2.getId());
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
                                                                                    if (postData3.bhp() != null) {
                                                                                        NewSubPbActivity.this.d(postData3.bhp());
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.kMB != null && !TextUtils.isEmpty(NewSubPbActivity.this.kMC)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.dWg == null) {
                                                                                        NewSubPbActivity.this.dWg = new bd(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.dWg.j(NewSubPbActivity.this.kMC, NewSubPbActivity.this.kMB.getImageByte());
                                                                                    NewSubPbActivity.this.kMB = null;
                                                                                    NewSubPbActivity.this.kMC = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.kMB != null && !TextUtils.isEmpty(NewSubPbActivity.this.kMC)) {
                                                                            if (NewSubPbActivity.this.kMD == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.kMC));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.kMC;
                                                                                aVar.pkgId = NewSubPbActivity.this.kMD.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.kMD.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.kMB = null;
                                                                            NewSubPbActivity.this.kMC = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.jds != null) {
                                                                        NewSubPbActivity.this.jds.fL(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.jds = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                if (sparseArray5 != null && (sparseArray5.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_id) instanceof String) && (sparseArray5.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.lak.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.cW(view);
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
                                                                NewSubPbActivity.this.NW((String) tag);
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
                                                            if (NewSubPbActivity.this.lai != null) {
                                                                TiebaStatic.log(new aq("c13700").dF("tid", NewSubPbActivity.this.lai.dcg()).dF("fid", NewSubPbActivity.this.lai.getFromForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dF("post_id", postData.getId()).ai("obj_type", 3));
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
                                                        ((PostData) sparseArray8.get(R.id.tag_clip_board)).fL(NewSubPbActivity.this.getPageContext().getPageActivity());
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
                                            NewSubPbActivity.this.lak.deI();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.NW(str4);
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
                                            NewSubPbActivity.this.lak.deI();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.df(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.lak.deI();
                                    SparseArray sparseArray10 = (SparseArray) view.getTag();
                                    if (sparseArray10 != null) {
                                        NewSubPbActivity.this.lak.a(((Integer) sparseArray10.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray10.get(R.id.tag_del_post_id), ((Integer) sparseArray10.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new aq("c11739").ai("obj_locate", 2));
                                    NewSubPbActivity.this.lak.deI();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.lai.dgC() != null) {
                                        NewSubPbActivity.this.n(NewSubPbActivity.this.lai.dgC().cZH());
                                    }
                                }
                            } else {
                                try {
                                    sparseArray3 = (SparseArray) view.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                }
                                if (sparseArray3 != null && ((PostData) sparseArray3.get(R.id.tag_clip_board)) != null) {
                                    if (NewSubPbActivity.this.lal == null) {
                                        NewSubPbActivity.this.lal = new ah(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aTZ);
                                        NewSubPbActivity.this.lak.dg(NewSubPbActivity.this.lal.getView());
                                        NewSubPbActivity.this.lal.tr(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.lal.NY();
                                    if (NewSubPbActivity.this.tc(sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin()) {
                                        z2 = true;
                                    }
                                    NewSubPbActivity.this.lal.a(sparseArray3, NewSubPbActivity.this.cZg(), z2);
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.lak.dge();
                            NewSubPbActivity.this.lak.dgf();
                            if (NewSubPbActivity.this.jOl != null) {
                                NewSubPbActivity.this.jOl.btE();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.dbd();
                        if (NewSubPbActivity.this.lai != null && NewSubPbActivity.this.lai.dgC() != null && NewSubPbActivity.this.lai.dgC().bcY() != null && NewSubPbActivity.this.lai.dgC().bcY().bfy() != null) {
                            TiebaStatic.log(new aq("c13402").dF("tid", NewSubPbActivity.this.lai.dcf()).u("fid", NewSubPbActivity.this.lai.dgC().bcY().getFid()).ai("obj_locate", 5).dF("uid", NewSubPbActivity.this.lai.dgC().bcY().bfy().getUserId()));
                        }
                    }
                }
            }
        };
        this.lam = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.lak.deI();
                    if (NewSubPbActivity.this.kHF != 2 && NewSubPbActivity.this.kHF != 1) {
                        NewSubPbActivity.this.lak.dgz();
                    }
                }
                NewSubPbActivity.this.jOl.btD();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.lak.dgv();
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
                if (NewSubPbActivity.this.lak != null && NewSubPbActivity.this.lak.dgm()) {
                    return false;
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null && NewSubPbActivity.this.cX(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.kMB = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.kMC = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.kMB == null || TextUtils.isEmpty(NewSubPbActivity.this.kMC)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.kMD = null;
                        } else {
                            NewSubPbActivity.this.kMD = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.kMB = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.kMC = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.kMD = null;
                        } else {
                            NewSubPbActivity.this.kMD = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.kMB = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.kMC = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.kMD = null;
                        } else {
                            NewSubPbActivity.this.kMD = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        NewSubPbActivity.this.lak.a(NewSubPbActivity.this.kNq, NewSubPbActivity.this.kMB.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.jds = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.jds == null || NewSubPbActivity.this.kMd == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.kMd != null) {
                            NewSubPbActivity.this.kMd.hy(NewSubPbActivity.this.lai.dgJ());
                        }
                        boolean z2 = NewSubPbActivity.this.kMd.bbu() && NewSubPbActivity.this.jds.getId() != null && NewSubPbActivity.this.jds.getId().equals(NewSubPbActivity.this.lai.dgL());
                        if (NewSubPbActivity.this.lal == null) {
                            NewSubPbActivity.this.lal = new ah(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aTZ);
                            NewSubPbActivity.this.lak.dg(NewSubPbActivity.this.lal.getView());
                            NewSubPbActivity.this.lal.tr(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.lal.NY();
                        boolean z3 = NewSubPbActivity.this.tc(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z4 = (NewSubPbActivity.this.lai.dgC() == null || NewSubPbActivity.this.lai.dgC().bcY() == null || !NewSubPbActivity.this.lai.dgC().bcY().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z2) {
                            NewSubPbActivity.this.lal.dde().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.lal.dde().setText(R.string.mark);
                        }
                        if (booleanValue || z4) {
                            NewSubPbActivity.this.lal.dde().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.lal.dde().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.cX(view)) {
                            if (NewSubPbActivity.this.kMB != null && !NewSubPbActivity.this.kMB.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        ah ahVar = NewSubPbActivity.this.lal;
                        int cZg = NewSubPbActivity.this.cZg();
                        if (NewSubPbActivity.this.kJC && NewSubPbActivity.this.jds.mpy) {
                            z = true;
                        }
                        ahVar.a(sparseArray2, cZg, z3, z);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.lan = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
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
                        p dgC = NewSubPbActivity.this.lai.dgC();
                        TbRichText bv = NewSubPbActivity.this.bv(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bv != null && bv.byG() != null) {
                            tbRichTextData = bv.byG().get(NewSubPbActivity.this.kNn);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!tbRichTextData.byM().bza()) {
                                String c = NewSubPbActivity.this.c(tbRichTextData);
                                arrayList.add(c);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap.put(c, imageUrlData);
                                String str5 = null;
                                String str6 = null;
                                String str7 = null;
                                if (dgC == null) {
                                    str4 = null;
                                    z4 = false;
                                } else {
                                    if (dgC.btx() != null) {
                                        str5 = dgC.btx().getName();
                                        str6 = dgC.btx().getId();
                                    }
                                    if (dgC.bcY() != null) {
                                        str7 = dgC.bcY().getId();
                                    }
                                    str4 = str7;
                                    z4 = true;
                                }
                                if (NewSubPbActivity.this.lai.dgQ() != null) {
                                    concurrentHashMap = NewSubPbActivity.this.lai.dgQ();
                                    z4 = NewSubPbActivity.this.lai.dgS();
                                    arrayList = NewSubPbActivity.this.lai.dgR();
                                }
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(y.getItem(arrayList, 0));
                                ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                                aVar.x(arrayList2).zl(str5).zm(str6).zn(str4).hF(z4).zo(arrayList.get(0)).hG(true).a(concurrentHashMap).hH(true).hI(false).hJ(false).s(NewSubPbActivity.this.bcY()).zp(String.valueOf(bv.getPostId())).zq(NewSubPbActivity.this.lai.getFromForumId());
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar.dO(NewSubPbActivity.this.getPageContext().getPageActivity())));
                                return;
                            }
                            NewSubPbActivity.this.kNo = false;
                            TbRichText dAF = dgC.cZH().dAF();
                            int size = arrayList.size();
                            int a2 = NewSubPbActivity.this.a(dAF, bv, i, i, arrayList, concurrentHashMap);
                            int size2 = arrayList.size();
                            if (size == size2) {
                                str2 = "";
                            } else {
                                str2 = arrayList.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (dgC == null) {
                                str3 = null;
                                z3 = false;
                            } else {
                                if (dgC.btx() != null) {
                                    str8 = dgC.btx().getName();
                                    str9 = dgC.btx().getId();
                                }
                                if (dgC.bcY() != null) {
                                    str10 = dgC.bcY().getId();
                                }
                                str3 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.lai.dgQ() != null) {
                                concurrentHashMap = NewSubPbActivity.this.lai.dgQ();
                                z3 = NewSubPbActivity.this.lai.dgS();
                                arrayList = NewSubPbActivity.this.lai.dgR();
                                a2 += NewSubPbActivity.this.lai.getOffset();
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(y.getItem(arrayList, a2));
                            ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                            aVar2.x(arrayList3).zl(str8).zm(str9).zn(str3).hF(z3).zo(str2).hG(true).a(concurrentHashMap).hH(true).hI(false).hJ(false).s(NewSubPbActivity.this.bcY()).zp(String.valueOf(bv.getPostId())).zq(NewSubPbActivity.this.lai.getFromForumId());
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar2.dO(NewSubPbActivity.this.getPageContext().getPageActivity())));
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
    public bw bcY() {
        if (this.lai == null || this.lai.dgC() == null) {
            return null;
        }
        return this.lai.dgC().bcY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(View view) {
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
            if (postData.bfy() != null) {
                MetaData bfy = postData.bfy();
                this.jOl.setReplyId(bfy.getUserId());
                boolean z2 = postData.mpy;
                String str = "";
                if (postData.dAF() != null) {
                    str = postData.dAF().toString();
                }
                this.jOl.CD(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bfy().getName_show(), str));
                if (z2) {
                    if (!z) {
                        this.jOl.CC("");
                    }
                } else if (!z) {
                    this.jOl.CC(bfy.getName_show());
                }
            }
            this.lak.dgf();
        }
        if (this.lax) {
            ue(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eqK == null) {
                this.eqK = new com.baidu.tbadk.core.message.a();
            }
            if (this.equ == null) {
                this.equ = new e();
                this.equ.uniqueId = this.laz;
            }
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.dYY = 12;
            cVar.dZe = 9;
            cVar.dZd = 3;
            if (dgd() != null) {
                cVar.dZc = dgd().dgU();
            }
            if (cVar != null) {
                cVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (cVar != null) {
                        cVar.dZf = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (cVar != null) {
                        cVar.dZf = 1;
                        i = 0;
                    }
                }
                this.eqK.a(agreeData, i, getUniqueId(), false);
                this.eqK.a(agreeData, this.equ);
                if (dgd() == null && dgd().dgC() != null) {
                    this.eqK.a(this, cVar, agreeData, dgd().dgC().bcY());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (cVar != null) {
                cVar.dZf = 1;
            }
            i = 0;
            this.eqK.a(agreeData, i, getUniqueId(), false);
            this.eqK.a(agreeData, this.equ);
            if (dgd() == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo byM;
        if (tbRichText == tbRichText2) {
            this.kNo = true;
        }
        if (tbRichText != null && tbRichText.byG() != null) {
            int size = tbRichText.byG().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.byG().get(i6) != null && tbRichText.byG().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.byG().get(i6).byM().getWidth() * equipmentDensity;
                    int height = tbRichText.byG().get(i6).byM().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.byG().get(i6).byM().bza()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.byG().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (byM = tbRichTextData.byM()) != null) {
                            String bzc = byM.bzc();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = bzc;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.kNo) {
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
        if (this.lal != null) {
            this.lal.tr(z);
        }
        if (this.lak != null) {
            this.lak.tr(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo byM = tbRichTextData.byM();
        if (byM != null) {
            if (!StringUtils.isNull(byM.byZ())) {
                return byM.byZ();
            }
            if (byM.getHeight() * byM.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (byM.getHeight() * byM.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (byM.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * byM.getHeight())));
            } else {
                float width = byM.getWidth() / byM.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(at.getUrlEncode(byM.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bv(String str, int i) {
        if (this.lai == null || this.lai.dgC() == null || str == null || i < 0) {
            return null;
        }
        p dgC = this.lai.dgC();
        TbRichText a2 = a(dgC.cZH(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(dgC.cZH(), str, i);
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
        TbRichText dAF = postData.dAF();
        if (dAF != null) {
            ArrayList<TbRichTextData> byG = dAF.byG();
            int size = byG.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (byG.get(i3) != null && byG.get(i3).getType() == 8) {
                    i2++;
                    if (byG.get(i3).byM().bzc().equals(str)) {
                        int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = byG.get(i3).byM().getWidth() * equipmentDensity;
                        int height = byG.get(i3).byM().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.kNn = i3;
                        return dAF;
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
    public void dbd() {
        Intent intent = getIntent();
        if (intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false) {
            if (this.jOf == null || this.lai == null || this.lai.coh() == null || this.jOf.ob(this.lai.coh().replyPrivateFlag)) {
                if (this.jOl.btr()) {
                    this.jOl.a((PostWriteCallBackData) null);
                    return;
                }
                this.lak.dge();
                this.lak.dgf();
                if (this.jOl != null) {
                    this.jOl.btG();
                    return;
                }
                return;
            }
            return;
        }
        if (this.ieu == null) {
            this.ieu = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.ieu.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void oC(boolean z) {
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
                public void oD(boolean z) {
                    String str;
                    if (z) {
                        if (NewSubPbActivity.this.jOf == null || NewSubPbActivity.this.lai == null || NewSubPbActivity.this.lai.coh() == null || NewSubPbActivity.this.jOf.ob(NewSubPbActivity.this.lai.coh().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.lai != null && NewSubPbActivity.this.lai.dgC() != null && NewSubPbActivity.this.lai.dgC().cZH() != null) {
                                PostData cZH = NewSubPbActivity.this.lai.dgC().cZH();
                                if (cZH.dAF() != null && cZH.bfy() != null) {
                                    str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), cZH.bfy().getName_show(), cZH.dAF().toString());
                                    NewSubPbActivity.this.jOl.bsv().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                                    if (!NewSubPbActivity.this.jOl.btr()) {
                                        NewSubPbActivity.this.jOl.a((PostWriteCallBackData) null);
                                        return;
                                    }
                                    NewSubPbActivity.this.lak.dge();
                                    NewSubPbActivity.this.lak.dgf();
                                    if (NewSubPbActivity.this.jOl != null) {
                                        NewSubPbActivity.this.jOl.btG();
                                        return;
                                    }
                                    return;
                                }
                            }
                            str = null;
                            NewSubPbActivity.this.jOl.bsv().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                            if (!NewSubPbActivity.this.jOl.btr()) {
                            }
                        }
                    }
                }
            });
        }
        if (this.lai != null && this.lai.dgC() != null && this.lai.dgC().btx() != null) {
            this.ieu.D(this.lai.dgC().btx().getId(), com.baidu.adp.lib.f.b.toLong(this.lai.dcf(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tc(boolean z) {
        if (this.lai == null) {
            return false;
        }
        return ((cZg() != 0) || this.lai.dgC() == null || this.lai.dgC().bcY() == null || this.lai.dgC().bcY().bfy() == null || this.lai.dgC().bcY().bei() || TextUtils.equals(this.lai.dgC().bcY().bfy().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(int i, String str) {
        if (this.lai.dgD()) {
            showToast(str);
        } else if (l.isNetOk()) {
            if (i == 4) {
                this.lak.Hq(str + "(4)");
            } else {
                this.lak.BE(R.string.no_data_text);
            }
        } else {
            this.lak.BE(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rw(boolean z) {
        this.jOl = (h) new com.baidu.tbadk.editortools.pb.i(z).eb(getActivity());
        if (this.jOl != null) {
            this.jOl.a(getPageContext());
            this.jOl.b(this.lai);
            this.jOl.b(this.jcR);
            this.jOl.setFrom(2);
            this.jOl.a(this.ePr);
            this.jOl.a(this.ePs);
            this.jOl.bsv().jh(true);
            this.jOl.j(getPageContext());
        }
        if (this.lak != null) {
            this.lak.i(this.jOl);
        }
        if (this.jOl != null && this.lai != null) {
            this.jOl.a(this.lai.coh());
            this.jOl.btD();
        }
        if (this.jOl != null) {
            this.jOl.btH().setDefaultHint(ddW());
            this.jOl.btH().setHint(ddW());
            this.jcL = this.jOl.btH().getInputView();
            this.jcL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.jcK != null) {
                        if (!NewSubPbActivity.this.jcK.dJA()) {
                            NewSubPbActivity.this.qa(false);
                        }
                        NewSubPbActivity.this.jcK.xj(false);
                    }
                }
            });
        }
    }

    public void dgb() {
        if (!TbadkCoreApplication.isLogin()) {
            this.jOl.btD();
        } else if (!StringUtils.isNull(this.lai.dgM())) {
            if (this.lak.dgi() && l.isNetOk()) {
                this.lak.cmf();
            } else {
                this.lak.dgl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void df(View view) {
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
                    this.lak.dc(view);
                }
            } else if (booleanValue2) {
                this.lak.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.lak.dgs(), getPageContext().getPageActivity());
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
            bVar.nJ(R.string.operation);
            bVar.a(strArr, new b.InterfaceC0533b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0533b
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.lau);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.lau);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).bic();
        }
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.lak.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.lau;
        userMuteCheckCustomMessage.setTag(this.lau);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.lak.a(0, bVar.Qx, bVar.mro, z);
            if (bVar.Qx) {
                if (bVar.hGO == 1) {
                    if (this.lak.getListView() instanceof BdTypeListView) {
                        List<q> data = ((BdTypeListView) this.lak.getListView()).getData();
                        if (!y.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.lak.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.hGO == 2) {
                    this.lai.OB(bVar.mPostId);
                    this.lak.a(this.lai.dgC(), this.lai.cZg(), this.lai.dgQ() != null, false);
                    if (this.lai.dgN()) {
                        this.lai.ui(false);
                        this.lak.dgg();
                        this.lai.loadData();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void NW(String str) {
        if (this.lai != null && this.lai.dgC() != null && this.lai.dgC().bcY() != null && this.lai.dgC().bcY().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lai.dcf(), str);
            bw bcY = this.lai.dgC().bcY();
            if (bcY.beg()) {
                format = format + "&channelid=33833";
            } else if (bcY.bhs()) {
                format = format + "&channelid=33842";
            } else if (bcY.beh()) {
                format = format + "&channelid=33840";
            }
            NX(format);
            return;
        }
        this.kMc.Ox(str);
    }

    private void NX(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void n(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.lai.dgJ() && postData.getId() != null && postData.getId().equals(this.lai.dgL())) {
                z = true;
            }
            MarkData o = this.lai.o(postData);
            if (o != null) {
                this.lak.deI();
                if (this.kMd != null) {
                    this.kMd.a(o);
                    if (!z) {
                        this.kMd.bbw();
                    } else {
                        this.kMd.bbv();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.lai != null) {
            this.lai.aC(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.jOl != null) {
            this.jOl.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.jOl.bsv().bqS();
        this.jOl.btD();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.jOl.b(writeData);
                this.jOl.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.m qr = this.jOl.bsv().qr(6);
                if (qr != null && qr.eMS != null) {
                    qr.eMS.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.jOl.btz();
                }
                this.lak.dgz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.hZU != null) {
            this.hZU.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.mIsPaused = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.aZe().aZp();
        if (this.hZU != null) {
            this.hZU.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.jpv);
        this.lak.cwv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.mIsPaused = false;
        super.onResume();
        dbI();
        if (this.hZU != null) {
            this.hZU.onResume(getPageContext());
        }
        registerListener(this.jpv);
        this.lak.cww();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hZU != null) {
            this.hZU.onStop(getPageContext());
        }
        this.jOl.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.law));
        this.lai.cancelLoadData();
        this.lai.destory();
        this.laj.cancelLoadData();
        if (this.hZU != null) {
            this.hZU.onDestory(getPageContext());
        }
        this.lak.deI();
        this.lak.cuG();
        MessageManager.getInstance().unRegisterListener(this.kMY);
        MessageManager.getInstance().unRegisterListener(this.kMZ);
        MessageManager.getInstance().unRegisterListener(this.kNa);
        MessageManager.getInstance().unRegisterListener(this.lau);
        this.kMx = null;
        this.kMy = null;
        if (this.jOf != null) {
            this.jOf.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lak.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.hZU;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View dgn = this.lak.dgn();
        if (dgn == null || (findViewWithTag = dgn.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean Op(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = be.getParamPair(be.getParamStr(str))) != null) {
            this.lav = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Op(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(lah);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (Op(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                    lVar.mLink = str;
                    lVar.type = 3;
                    lVar.eLR = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
                }
            } else {
                be.bkp().b(getPageContext(), new String[]{str});
            }
            this.lav = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void at(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.lav = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void au(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void av(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aw(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void r(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView getListView() {
        if (this.lak != null) {
            return this.lak.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int bzr() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> bzt() {
        if (this.fiD == null) {
            this.fiD = TbRichTextView.A(getPageContext().getPageActivity(), 8);
        }
        return this.fiD;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> bzu() {
        if (this.ffk == null) {
            this.ffk = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cjO */
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
        return this.ffk;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> bzs() {
        if (this.ffj == null) {
            this.ffj = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bzE */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = k.bcG().isShowImages();
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
                        if (k.bcG().isShowImages()) {
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
        return this.ffj;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> bzv() {
        if (this.fiE == null) {
            this.fiE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dbP */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(NewSubPbActivity.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cY */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cZ */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: da */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fiE;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> bzw() {
        if (this.fiF == null) {
            this.fiF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dbR */
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
        return this.fiF;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> bzx() {
        this.fiG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dbQ */
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
        return this.fiG;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a cZW() {
        return this.kIj;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean cZX() {
        return (this.lai == null || this.lai.dgC() == null || this.lai.dgC().bcY() == null || this.lai.dgC().bcY().bgV()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String cZY() {
        if (this.lai == null || this.lai.dgC() == null || this.lai.dgC().bcY() == null) {
            return null;
        }
        return this.lai.dgC().bcY().bfC();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int cZZ() {
        if (this.lai == null) {
            return 0;
        }
        return this.lai.cZg();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean NQ(String str) {
        if (StringUtils.isNull(str) || this.lai == null || this.lai.dgC() == null || this.lai.dgC().bcY() == null || this.lai.dgC().bcY().bfy() == null) {
            return false;
        }
        return str.equals(this.lai.dgC().bcY().bfy().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.lak.dgi() && l.isNetOk()) {
            this.lai.loadData();
        } else {
            this.lak.dgl();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.lau);
        userMuteAddAndDelCustomMessage.setTag(this.lau);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oz(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bjf().getString("bubble_link", "");
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
    public void ax(Context context, String str) {
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
                return com.baidu.tbadk.m.e.bve().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.lai != null) {
            if (this.lai.dgC() != null && this.lai.dgC().btx() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.lai.dgC().btx().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.lai.dcf(), 0L));
            if (this.lai.dgC() != null && this.lai.dgC().bcY() != null) {
                pageStayDurationItem.setNid(this.lai.dgC().bcY().getNid());
            }
            pageStayDurationItem.setPid(com.baidu.adp.lib.f.b.toLong(this.lai.bsX(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public boolean dgc() {
        if (this.lai != null) {
            return this.lai.dgc();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.lak.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kMx.getPageActivity());
        if (at.isEmpty(str)) {
            aVar.zV(this.kMx.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.zV(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.lak.showLoadingDialog();
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
        aVar.b(this.kMx).bia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CA(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kMx.getPageActivity());
        aVar.zV(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.kMx).bia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbE() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.zV(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.kMx).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.kMx.getPageActivity(), 2, true, 4);
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
        aVar.b(this.kMx).bia();
    }

    public SubPbModel dgd() {
        return this.lai;
    }

    public int cZg() {
        if (this.lai != null) {
            return this.lai.cZg();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eNo && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eNo && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void qa(boolean z) {
        if (this.jcL != null && this.jcL.getText() != null) {
            int selectionEnd = this.jcL.getSelectionEnd();
            SpannableStringBuilder c = this.jcK.c(this.jcL.getText());
            if (c != null) {
                this.jcK.xj(true);
                this.jcL.setText(c);
                if (z && this.jcK.dJy() >= 0) {
                    this.jcL.requestFocus();
                    this.jcL.setSelection(this.jcK.dJy());
                } else {
                    this.jcL.setSelection(selectionEnd);
                }
                this.jcK.xi(this.jcK.dJy() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.jOl != null && this.jOl.bsv() != null && this.jOl.bsv().bsz()) {
            this.jOl.bsv().bqS();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(t tVar) {
        ag.a(tVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    public String ddW() {
        if (!at.isEmpty(this.kUW)) {
            return this.kUW;
        }
        this.kUW = getResources().getString(com.baidu.tieba.pb.pb.main.ay.ddL());
        return this.kUW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.lax = z;
        ue(true);
    }

    private void ue(boolean z) {
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
        if (this.lak != null && this.lak.getListView() != null && this.lay != null && this.lay.mPosition != -1) {
            final int headerViewsCount = this.lay.mPosition + this.lak.getListView().getHeaderViewsCount();
            if (this.lay.getView() != null) {
                final int height = this.lay.getView().getHeight();
                final int height2 = ((rect.height() - this.lak.dgy()) - this.lak.getNavigationBarHeight()) - this.lak.dgx();
                final int i = height - height2;
                if (i > 0) {
                    this.lak.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.lak != null && NewSubPbActivity.this.lak.getListView() != null) {
                                NewSubPbActivity.this.lak.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.lak.getNavigationBarHeight() - i);
                            }
                        }
                    });
                } else {
                    this.lak.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.lak != null && NewSubPbActivity.this.lak.getListView() != null) {
                                NewSubPbActivity.this.lak.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.lak.getNavigationBarHeight() + (height2 - height));
                            }
                        }
                    });
                }
            }
        }
    }

    private void dbI() {
        if (this.lai != null && !at.isEmpty(this.lai.dcf())) {
            com.baidu.tbadk.BdToken.c.aZe().p(com.baidu.tbadk.BdToken.b.dPM, com.baidu.adp.lib.f.b.toLong(this.lai.dcf(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.lai == null || at.isEmpty(this.lai.dcf())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.lai.dcf(), 0L);
    }
}
