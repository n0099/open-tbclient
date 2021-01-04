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
    private static String mbx = "tbgametype";
    private View.OnClickListener bdp;
    private at eLv;
    private com.baidu.adp.lib.d.b<ImageView> fWD;
    private com.baidu.adp.lib.d.b<GifView> fWE;
    private com.baidu.adp.lib.d.b<TextView> fZS;
    private com.baidu.adp.lib.d.b<View> fZT;
    private com.baidu.adp.lib.d.b<LinearLayout> fZU;
    private com.baidu.adp.lib.d.b<RelativeLayout> fZV;
    private e fgI;
    private com.baidu.tbadk.core.message.a fgY;
    private VoiceManager jfh;
    private com.baidu.tieba.frs.profession.permission.c jjD;
    public al kON;
    private com.baidu.tbadk.editortools.pb.h kOT;
    private com.baidu.tieba.write.c klI;
    private EditText klJ;
    private com.baidu.tieba.pb.pb.main.b.a lJa;
    private boolean lJf;
    private f lND;
    private com.baidu.tbadk.core.view.c lNE;
    private com.baidu.adp.widget.ImageView.a lNH;
    private String lNI;
    private TbRichTextMemeInfo lNJ;
    private com.baidu.tieba.pb.pb.report.a lNi;
    private com.baidu.tbadk.baseEditMark.a lNj;
    private PostWriteCallBackData lPq;
    private String lWe;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private com.baidu.tieba.pb.pb.sub.a mbA;
    private aa mbB;
    private AbsListView.OnScrollListener mbC;
    private TbRichTextView.i mbD;
    private SubPbModel.a mbE;
    private com.baidu.adp.base.e mbF;
    private BdUniqueId mbJ;
    private com.baidu.tieba.pb.e<p> mbL;
    private boolean mbM;
    private PbCommenFloorItemViewHolder mbN;
    private SubPbModel mby;
    private ForumManageModel mbz;
    private boolean mIsFromCDN = true;
    private int lOt = 0;
    PostData kmq = null;
    private a.InterfaceC0574a lOp = null;
    private a mbG = null;
    private a mbH = null;
    private boolean mIsPaused = false;
    private boolean mbI = false;
    private boolean mbK = false;
    private boolean fEd = false;
    private com.baidu.tbadk.editortools.pb.c fGh = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bFn() {
            NewSubPbActivity.this.mbA.duk();
        }
    };
    private int lIw = 0;
    private boolean mIsFromSchema = false;
    private BdUniqueId mbO = BdUniqueId.gen();
    private boolean lNg = com.baidu.tbadk.a.d.bmF();
    private boolean mbP = true;
    private com.baidu.tbadk.editortools.pb.b fGi = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bFm() {
            if (!NewSubPbActivity.this.klI.dXS()) {
                return (NewSubPbActivity.this.kON == null || NewSubPbActivity.this.mby == null || NewSubPbActivity.this.mby.cDY() == null || NewSubPbActivity.this.kON.aN(NewSubPbActivity.this.mby.cDY().replyPrivateFlag, al.fcV)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.klI.dXU());
            if (NewSubPbActivity.this.kOT.bFE()) {
                NewSubPbActivity.this.kOT.a(NewSubPbActivity.this.lPq);
            }
            NewSubPbActivity.this.sj(true);
            return true;
        }
    };
    private CustomMessageListener mbQ = new CustomMessageListener(2921481) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && NewSubPbActivity.this.mby != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && com.baidu.tbadk.core.util.at.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), NewSubPbActivity.this.mby.dpW())) {
                if (NewSubPbActivity.this.klI != null) {
                    NewSubPbActivity.this.klI.Vf(null);
                    NewSubPbActivity.this.klI.bm(null);
                    NewSubPbActivity.this.klI.zb(false);
                }
                if (NewSubPbActivity.this.kOT != null) {
                    NewSubPbActivity.this.kOT.bFO();
                    NewSubPbActivity.this.kOT.reset();
                }
                NewSubPbActivity.this.mby.bFj();
            }
        }
    };
    private NewWriteModel.d klP = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.kOT != null && NewSubPbActivity.this.kOT.bEI() != null) {
                NewSubPbActivity.this.kOT.bEI().hide();
                if (NewSubPbActivity.this.mby.duK()) {
                    TiebaStatic.log(new aq("c10367").dX("post_id", NewSubPbActivity.this.mby.bFk()));
                }
            }
            if (z) {
                NewSubPbActivity.this.klI.Vf(null);
                NewSubPbActivity.this.klI.bm(null);
                NewSubPbActivity.this.klI.zb(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(NewSubPbActivity.this.getPageContext(), postWriteCallBackData);
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.klI.bm(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.klI.Vf(postWriteCallBackData.getErrorString());
                if (!x.isEmpty(NewSubPbActivity.this.klI.dXQ())) {
                    NewSubPbActivity.this.lPq = postWriteCallBackData;
                    if (NewSubPbActivity.this.kOT.bFE()) {
                        NewSubPbActivity.this.kOT.a(NewSubPbActivity.this.lPq);
                    }
                    NewSubPbActivity.this.sj(true);
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
                    aVar.Bp(NewSubPbActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Bp(postWriteCallBackData.getErrorString());
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
                aVar.b(NewSubPbActivity.this.getPageContext()).btX();
                TiebaStatic.log(new aq("c13745").an("obj_locate", 1).an("obj_type", 2));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.kON != null) {
                NewSubPbActivity.this.kON.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.mbA.dul();
        }
    };
    private CustomMessageListener lOe = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.mbJ) {
                NewSubPbActivity.this.mbA.cni();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.lNE.showSuccessToast(NewSubPbActivity.this.lND.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.lND.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.DX(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.dpv();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (com.baidu.tbadk.core.util.at.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.lND.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.lNE.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lOf = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.mbJ) {
                NewSubPbActivity.this.mbA.cni();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.lNE.showSuccessToast(NewSubPbActivity.this.lND.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (com.baidu.tbadk.core.util.at.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.lND.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.lNE.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener lOg = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.mbJ) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.mbA.cni();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.nEU;
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
                    NewSubPbActivity.this.mbA.a(sparseArray, z);
                }
            }
        }
    };
    private final f.c gJh = new f.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (NewSubPbActivity.this.mby != null) {
                NewSubPbActivity.this.mby.duI();
            }
        }
    };
    boolean lOu = false;
    private final b.InterfaceC0578b lOw = new b.InterfaceC0578b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0578b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.lNH != null && !TextUtils.isEmpty(NewSubPbActivity.this.lNI)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.lNJ == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.lNI));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.lNI;
                        aVar.pkgId = NewSubPbActivity.this.lNJ.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.lNJ.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.eLv == null) {
                            NewSubPbActivity.this.eLv = new at(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.eLv.p(NewSubPbActivity.this.lNI, NewSubPbActivity.this.lNH.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.lNH = null;
                NewSubPbActivity.this.lNI = null;
            }
        }
    };
    private CustomMessageListener jtD = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener jgO = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    n nVar = (n) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.mby.duC() != null && NewSubPbActivity.this.mby.duC().dnx() != null && NewSubPbActivity.this.mby.duC().dnx().brq() != null && currentAccount.equals(NewSubPbActivity.this.mby.duC().dnx().brq().getUserId()) && NewSubPbActivity.this.mby.duC().dnx().brq().getPendantData() != null) {
                        NewSubPbActivity.this.mby.duC().dnx().brq().getPendantData().AY(nVar.getImgUrl());
                        NewSubPbActivity.this.mby.duC().dnx().brq().getPendantData().ee(nVar.bEh());
                        NewSubPbActivity.this.mbA.a(NewSubPbActivity.this.mby.duC(), NewSubPbActivity.this.mby.duC().dnx(), NewSubPbActivity.this.mby.duC().Zp(), NewSubPbActivity.this.mby.duC().bnx(), NewSubPbActivity.this.mby.dmT(), NewSubPbActivity.this.mby.duQ() != null);
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
        this.lND = getPageContext();
        this.mbI = true;
        this.klI = new com.baidu.tieba.write.c();
        this.klI.Mp(R.color.cp_cont_h_alpha85);
        this.klI.Mo(R.color.CAM_X0101);
        cbX();
        dua();
        initData(bundle);
        initUI();
        ((SubPbView) this.mbA.getRootView()).show();
        tj(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.mbA.vT(this.mIsFromSchema);
        this.lNE = new com.baidu.tbadk.core.view.c();
        this.lNE.toastTime = 1000L;
        registerListener(this.lOg);
        registerListener(this.lOe);
        registerListener(this.lOf);
        registerListener(this.mbQ);
        this.mbJ = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.mbJ;
        userMuteAddAndDelCustomMessage.setTag(this.mbJ);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.mbJ;
        userMuteCheckCustomMessage.setTag(this.mbJ);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.kON = new al(getPageContext());
        this.kON.a(new al.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.40
            @Override // com.baidu.tbadk.core.util.al.a
            public void q(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.kOT.bFM();
                }
            }
        });
        this.lNi = new com.baidu.tieba.pb.pb.report.a(this);
        this.lNi.w(getUniqueId());
        this.lJa = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.mbA = new com.baidu.tieba.pb.pb.sub.a(this, this.bdp);
        this.mbA.a(this.mby);
        setContentView(this.mbA.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.mbA.setOnScrollListener(this.mbC);
        this.mbA.b(this);
        this.mbA.setOnImageClickListener(this.mbD);
        this.mbA.setOnLongClickListener(this.mOnLongClickListener);
        this.mbA.h(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.mby != null) {
                    NewSubPbActivity.this.mby.loadData();
                }
            }
        });
        this.mbA.a(this.mbG);
        this.mbA.b(this.mbH);
        this.mbA.setListPullRefreshListener(this.gJh);
        if (this.mby != null && this.mby.duc() && !this.mby.duP()) {
            this.mbA.duq().setVisibility(8);
        } else {
            this.mbA.duq().setVisibility(0);
        }
        if (this.mby != null && !this.mby.duc()) {
            this.mbA.setIsFromPb(false);
        }
    }

    private boolean aE(Bundle bundle) {
        if (bundle != null) {
            this.fEd = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.fEd = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.fEd;
    }

    public void initData(Bundle bundle) {
        this.mby = new SubPbModel(getPageContext());
        this.mby.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                NewSubPbActivity.this.mbA.v(postData);
                NewSubPbActivity.this.mbA.b((BdListView.e) null);
            }
        });
        this.mbz = new ForumManageModel(getPageContext());
        this.mbz.setLoadDataCallBack(this.mbF);
        this.jfh = new VoiceManager();
        this.jfh.onCreate(getPageContext());
        this.lNj = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.lNj != null) {
            this.lNj.a(this.lOp);
        }
        if (bundle != null) {
            this.mby.initWithBundle(bundle);
        } else {
            this.mby.initWithIntent(getIntent());
        }
        this.mby.a(this.mbE);
        if (this.mby.duc() && !this.mby.duV()) {
            this.mby.loadData();
        } else if (!TextUtils.isEmpty(getIntent().getStringExtra("key_open_editor_tips"))) {
            this.mby.loadData();
        } else {
            this.mby.duH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final com.baidu.tbadk.editortools.pb.h hVar, String str) {
        new WriteTipBubbleController(getPageContext(), new WriteTipBubbleController.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.a
            public void f(View view2, String str2) {
                view.performClick();
                hVar.bFO();
                hVar.bFU().getInputView().setText(str2);
                Editable text = hVar.bFU().getInputView().getText();
                if (!TextUtils.isEmpty(text)) {
                    hVar.bFU().getInputView().setSelection(text.length());
                }
            }
        }).a(view, getString(R.string.open_editor_tips), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
    }

    public void dua() {
        this.mbE = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, final p pVar) {
                if (NewSubPbActivity.this.mbA != null) {
                    NewSubPbActivity.this.mbA.dul();
                    if (!z) {
                        NewSubPbActivity.this.bK(i, str);
                        return;
                    }
                    NewSubPbActivity.this.mbA.hideNoDataView();
                    if (pVar != null) {
                        if (pVar.dnx() != null || NewSubPbActivity.this.mby != null) {
                            pVar.dnx().a(NewSubPbActivity.this.mby.duO());
                        }
                        if (NewSubPbActivity.this.mbA != null) {
                            NewSubPbActivity.this.tj(pVar.boO() != null && pVar.boO().isBjh());
                            if (NewSubPbActivity.this.kOT != null && NewSubPbActivity.this.kOT.bEI() != null) {
                                NewSubPbActivity.this.kOT.bEI().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.mbA.a(pVar, NewSubPbActivity.this.mby.dmT(), NewSubPbActivity.this.mby.duQ() != null, NewSubPbActivity.this.mbI);
                            if (NewSubPbActivity.this.mbI) {
                                NewSubPbActivity.this.mbA.getListView().setSelectionFromTop(NewSubPbActivity.this.mbA.getListView().getHeaderViewsCount() + 1, -l.getDimens(NewSubPbActivity.this, R.dimen.tbds18));
                                NewSubPbActivity.this.dub();
                                NewSubPbActivity.this.mbI = false;
                            }
                        }
                        if (NewSubPbActivity.this.kOT != null) {
                            NewSubPbActivity.this.kOT.a(pVar.cDY());
                            NewSubPbActivity.this.kOT.setThreadData(pVar.boO());
                            if (NewSubPbActivity.this.getIntent() != null && NewSubPbActivity.this.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && NewSubPbActivity.this.mbP) {
                                com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        NewSubPbActivity.this.mbP = false;
                                        NewSubPbActivity.this.c(pVar.dnx(), false);
                                    }
                                }, 200L);
                            }
                        }
                        if (NewSubPbActivity.this.mbL == null) {
                            NewSubPbActivity.this.mbL = new com.baidu.tieba.pb.e();
                        }
                        NewSubPbActivity.this.mbL.setData(pVar);
                        NewSubPbActivity.this.mbL.setType(0);
                        NewSubPbActivity.this.kON.a(NewSubPbActivity.this.mby.duT());
                    }
                    String stringExtra = NewSubPbActivity.this.getIntent().getStringExtra("key_open_editor_tips");
                    if (!TextUtils.isEmpty(stringExtra) && !NewSubPbActivity.this.lJf) {
                        NewSubPbActivity.this.lJf = true;
                        NewSubPbActivity.this.a(NewSubPbActivity.this.mbA.cLc(), NewSubPbActivity.this.kOT, stringExtra);
                    }
                }
            }
        };
        this.lOp = new a.InterfaceC0574a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0574a
            public void g(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.lNj != null) {
                        NewSubPbActivity.this.lNj.jc(z2);
                    }
                    MarkData bnA = NewSubPbActivity.this.lNj.bnA();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(bnA);
                        if (NewSubPbActivity.this.lNj != null) {
                            if (bnA != null) {
                                NewSubPbActivity.this.mby.vV(true);
                                NewSubPbActivity.this.mby.Qq(NewSubPbActivity.this.mby.bFk());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.mbA != null) {
                                NewSubPbActivity.this.mbA.vU(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.mby.vV(false);
                        NewSubPbActivity.this.mby.Qq(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.mbA != null) {
                            NewSubPbActivity.this.mbA.vU(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.mbG = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.mby.duC() != null && NewSubPbActivity.this.mby.duC().boO() != null && NewSubPbActivity.this.mby.duC().boO().brq() != null) {
                    str = String.valueOf(NewSubPbActivity.this.mby.duC().boO().brq().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.mby.duC().bFK().getId(), NewSubPbActivity.this.mby.duC().bFK().getName(), NewSubPbActivity.this.mby.duC().boO().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.mbH = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.mbz.dPY() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.mby != null && NewSubPbActivity.this.mby.duC() != null && NewSubPbActivity.this.mby.duC().bFK() != null && NewSubPbActivity.this.mby.duC().boO() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.mbz.TD(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.mbz.a(NewSubPbActivity.this.mby.duC().bFK().getId(), NewSubPbActivity.this.mby.duC().bFK().getName(), NewSubPbActivity.this.mby.duC().boO().getId(), valueOf, i2, i, z, NewSubPbActivity.this.mby.duC().boO().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.mbF = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.mbA.a(NewSubPbActivity.this.mbz.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.mbz.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.mcO != 1002 || bVar.hli) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.mbA.a(1, dVar.mSuccess, dVar.nuu, true);
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

    public void cbX() {
        registerListener(this.jgO);
        this.bdp = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                if (view != null || NewSubPbActivity.this.mbA != null) {
                    if (view == NewSubPbActivity.this.mbA.duw()) {
                        NewSubPbActivity.this.mbA.dsG();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                be.bwu().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.mbA.cLc()) {
                        if (view != NewSubPbActivity.this.mbA.dup()) {
                            if (view == NewSubPbActivity.this.mbA.duo()) {
                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                    NewSubPbActivity.this.mbA.due();
                                    NewSubPbActivity.this.mbA.duf();
                                    if (NewSubPbActivity.this.kOT != null) {
                                        NewSubPbActivity.this.kOT.bFS();
                                    }
                                }
                            } else if (view.getId() != R.id.pb_floor_feedback) {
                                if (view == NewSubPbActivity.this.mbA.duj()) {
                                    NewSubPbActivity.this.mbA.dsG();
                                    if (NewSubPbActivity.this.mby.loadData()) {
                                        NewSubPbActivity.this.mbA.duh();
                                    }
                                } else if (view == NewSubPbActivity.this.mbA.duq() || view == NewSubPbActivity.this.mbA.dur() || view == NewSubPbActivity.this.mbA.dut()) {
                                    if (NewSubPbActivity.this.mbK) {
                                        NewSubPbActivity.this.mbK = false;
                                        return;
                                    }
                                    if (NewSubPbActivity.this.mby.duC() != null && NewSubPbActivity.this.mby.duC().boO() != null) {
                                        z2 = ay.a(NewSubPbActivity.this.mby.duC().boO().getBaijiahaoData());
                                    }
                                    if (z2) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.mby.dpW(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.mby.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.mby.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.mby.duC() != null && NewSubPbActivity.this.mby.duC().boO() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.mby.duC().boO().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.mby.dpW(), NewSubPbActivity.this.mby.bFk(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.mby.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.mby.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.mbA.duu() == null || view != NewSubPbActivity.this.mbA.duu().dqX()) {
                                    if (NewSubPbActivity.this.mbA.duu() == null || view != NewSubPbActivity.this.mbA.duu().dra()) {
                                        if (NewSubPbActivity.this.mbA.duu() == null || view != NewSubPbActivity.this.mbA.duu().dqY()) {
                                            if (NewSubPbActivity.this.mbA.duu() == null || view != NewSubPbActivity.this.mbA.duu().dqZ()) {
                                                if (NewSubPbActivity.this.mbA.duu() == null || view != NewSubPbActivity.this.mbA.duu().drb()) {
                                                    if (view == NewSubPbActivity.this.mbA.dun() || view == NewSubPbActivity.this.mbA.dut()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.kOT.bFP()) {
                                                                NewSubPbActivity.this.kOT.bFQ();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.kOT.DY(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view != null && (view.getTag() instanceof PbCommenFloorItemViewHolder)) {
                                                        NewSubPbActivity.this.mbN = (PbCommenFloorItemViewHolder) view.getTag();
                                                        if (bg.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.mbK) {
                                                                NewSubPbActivity.this.mbK = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.kON == null || NewSubPbActivity.this.mby == null || NewSubPbActivity.this.mby.cDY() == null || NewSubPbActivity.this.kON.pZ(NewSubPbActivity.this.mby.cDY().replyPrivateFlag)) && (sparseArray2 = (SparseArray) view.getTag(R.id.tag_from)) != null) {
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
                                                        if (NewSubPbActivity.this.mbB == null || view != NewSubPbActivity.this.mbB.dqZ()) {
                                                            if (NewSubPbActivity.this.mbB == null || view != NewSubPbActivity.this.mbB.dqX()) {
                                                                if (NewSubPbActivity.this.mbB == null || view != NewSubPbActivity.this.mbB.dra()) {
                                                                    if (NewSubPbActivity.this.mbB == null || view != NewSubPbActivity.this.mbB.drb()) {
                                                                        if (NewSubPbActivity.this.mbB == null || view != NewSubPbActivity.this.mbB.drd()) {
                                                                            if (NewSubPbActivity.this.mbB == null || view != NewSubPbActivity.this.mbB.dre()) {
                                                                                if (NewSubPbActivity.this.mbB == null || view != NewSubPbActivity.this.mbB.drf()) {
                                                                                    if (NewSubPbActivity.this.mbB != null && view == NewSubPbActivity.this.mbB.dqY()) {
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
                                                                                                NewSubPbActivity.this.mbA.dN(view);
                                                                                                return;
                                                                                            } else if (booleanValue2) {
                                                                                                NewSubPbActivity.this.mbA.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                                            String string2 = com.baidu.tbadk.core.sharedPref.b.bvq().getString("tail_link", "");
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
                                                                                            if (postData2.getType() != PostData.eTd && !TextUtils.isEmpty(postData2.getBimg_url()) && k.bou().isShowImages()) {
                                                                                                NewSubPbActivity.this.Qn(postData2.getId());
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
                                                                                    if (postData3.btk() != null) {
                                                                                        NewSubPbActivity.this.d(postData3.btk());
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.lNH != null && !TextUtils.isEmpty(NewSubPbActivity.this.lNI)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.eLv == null) {
                                                                                        NewSubPbActivity.this.eLv = new at(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.eLv.p(NewSubPbActivity.this.lNI, NewSubPbActivity.this.lNH.getImageByte());
                                                                                    NewSubPbActivity.this.lNH = null;
                                                                                    NewSubPbActivity.this.lNI = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.lNH != null && !TextUtils.isEmpty(NewSubPbActivity.this.lNI)) {
                                                                            if (NewSubPbActivity.this.lNJ == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.lNI));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.lNI;
                                                                                aVar.pkgId = NewSubPbActivity.this.lNJ.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.lNJ.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.lNH = null;
                                                                            NewSubPbActivity.this.lNI = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.kmq != null) {
                                                                        NewSubPbActivity.this.kmq.gV(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.kmq = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                if (sparseArray5 != null && (sparseArray5.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_id) instanceof String) && (sparseArray5.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.mbA.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                NewSubPbActivity.this.PK((String) tag);
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
                                                            if (NewSubPbActivity.this.mby != null) {
                                                                TiebaStatic.log(new aq("c13700").dX("tid", NewSubPbActivity.this.mby.dpX()).dX("fid", NewSubPbActivity.this.mby.getFromForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("post_id", postData.getId()).an("obj_source", 1).an("obj_type", 3));
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
                                                        ((PostData) sparseArray8.get(R.id.tag_clip_board)).gV(NewSubPbActivity.this.getPageContext().getPageActivity());
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
                                            NewSubPbActivity.this.mbA.dsG();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.PK(str4);
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
                                            NewSubPbActivity.this.mbA.dsG();
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
                                    NewSubPbActivity.this.mbA.dsG();
                                    SparseArray sparseArray10 = (SparseArray) view.getTag();
                                    if (sparseArray10 != null) {
                                        NewSubPbActivity.this.mbA.a(((Integer) sparseArray10.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray10.get(R.id.tag_del_post_id), ((Integer) sparseArray10.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new aq("c11739").an("obj_locate", 2));
                                    NewSubPbActivity.this.mbA.dsG();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.mby.duC() != null) {
                                        NewSubPbActivity.this.n(NewSubPbActivity.this.mby.duC().dnx());
                                    }
                                }
                            } else {
                                try {
                                    sparseArray3 = (SparseArray) view.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                }
                                if (sparseArray3 != null && ((PostData) sparseArray3.get(R.id.tag_clip_board)) != null) {
                                    if (NewSubPbActivity.this.mbB == null) {
                                        NewSubPbActivity.this.mbB = new aa(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.bdp);
                                        NewSubPbActivity.this.mbA.dR(NewSubPbActivity.this.mbB.getView());
                                        NewSubPbActivity.this.mbB.ve(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.mbB.SY();
                                    if (NewSubPbActivity.this.uP(sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin()) {
                                        z2 = true;
                                    }
                                    NewSubPbActivity.this.mbB.a(sparseArray3, NewSubPbActivity.this.dmT(), z2);
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.mbA.due();
                            NewSubPbActivity.this.mbA.duf();
                            if (NewSubPbActivity.this.kOT != null) {
                                NewSubPbActivity.this.kOT.bFR();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.doU();
                        if (NewSubPbActivity.this.mby != null && NewSubPbActivity.this.mby.duC() != null && NewSubPbActivity.this.mby.duC().boO() != null && NewSubPbActivity.this.mby.duC().boO().brq() != null) {
                            TiebaStatic.log(new aq("c13402").dX("tid", NewSubPbActivity.this.mby.dpW()).w("fid", NewSubPbActivity.this.mby.duC().boO().getFid()).an("obj_locate", 5).dX("uid", NewSubPbActivity.this.mby.duC().boO().brq().getUserId()));
                        }
                    }
                }
            }
        };
        this.mbC = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.mbA.dsG();
                    if (NewSubPbActivity.this.lIw != 2 && NewSubPbActivity.this.lIw != 1) {
                        NewSubPbActivity.this.mbA.duz();
                    }
                }
                NewSubPbActivity.this.kOT.bFQ();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.mbA.duv();
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
                if (NewSubPbActivity.this.mbA != null && NewSubPbActivity.this.mbA.dum()) {
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
                        NewSubPbActivity.this.lNH = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.lNI = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.lNH == null || TextUtils.isEmpty(NewSubPbActivity.this.lNI)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lNJ = null;
                        } else {
                            NewSubPbActivity.this.lNJ = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.lNH = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.lNI = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lNJ = null;
                        } else {
                            NewSubPbActivity.this.lNJ = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.lNH = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.lNI = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lNJ = null;
                        } else {
                            NewSubPbActivity.this.lNJ = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        NewSubPbActivity.this.mbA.a(NewSubPbActivity.this.lOw, NewSubPbActivity.this.lNH.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.kmq = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.kmq == null || NewSubPbActivity.this.lNj == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.lNj != null) {
                            NewSubPbActivity.this.lNj.jc(NewSubPbActivity.this.mby.duJ());
                        }
                        boolean z2 = NewSubPbActivity.this.lNj.bnx() && NewSubPbActivity.this.kmq.getId() != null && NewSubPbActivity.this.kmq.getId().equals(NewSubPbActivity.this.mby.duL());
                        if (NewSubPbActivity.this.mbB == null) {
                            NewSubPbActivity.this.mbB = new aa(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.bdp);
                            NewSubPbActivity.this.mbA.dR(NewSubPbActivity.this.mbB.getView());
                            NewSubPbActivity.this.mbB.ve(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.mbB.SY();
                        boolean z3 = NewSubPbActivity.this.uP(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z4 = (NewSubPbActivity.this.mby.duC() == null || NewSubPbActivity.this.mby.duC().boO() == null || !NewSubPbActivity.this.mby.duC().boO().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z2) {
                            NewSubPbActivity.this.mbB.dqX().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.mbB.dqX().setText(R.string.mark);
                        }
                        if (booleanValue || z4) {
                            NewSubPbActivity.this.mbB.dqX().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.mbB.dqX().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.dI(view)) {
                            if (NewSubPbActivity.this.lNH != null && !NewSubPbActivity.this.lNH.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        aa aaVar = NewSubPbActivity.this.mbB;
                        int dmT = NewSubPbActivity.this.dmT();
                        if (NewSubPbActivity.this.lNg && NewSubPbActivity.this.kmq.nss) {
                            z = true;
                        }
                        aaVar.a(sparseArray2, dmT, z3, z);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.mbD = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                        p duC = NewSubPbActivity.this.mby.duC();
                        TbRichText bG = NewSubPbActivity.this.bG(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bG != null && bG.bKW() != null) {
                            tbRichTextData = bG.bKW().get(NewSubPbActivity.this.lOt);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!tbRichTextData.bLc().bLn()) {
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
                                if (duC == null) {
                                    str4 = null;
                                } else {
                                    if (duC.bFK() != null) {
                                        str5 = duC.bFK().getName();
                                        str6 = duC.bFK().getId();
                                    }
                                    if (duC.boO() != null) {
                                        str7 = duC.boO().getId();
                                    }
                                    z5 = true;
                                    str4 = str7;
                                }
                                if (NewSubPbActivity.this.mby.duQ() != null) {
                                    concurrentHashMap = NewSubPbActivity.this.mby.duQ();
                                    z4 = NewSubPbActivity.this.mby.duS();
                                    arrayList = NewSubPbActivity.this.mby.duR();
                                } else {
                                    z4 = z5;
                                }
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(x.getItem(arrayList, 0));
                                ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                                aVar.x(arrayList2).AE(str5).AF(str6).AG(str4).ji(z4).AH(arrayList.get(0)).jj(true).d(concurrentHashMap).jk(true).jl(false).jm(false).s(NewSubPbActivity.this.boO()).AI(String.valueOf(bG.getPostId())).AJ(NewSubPbActivity.this.mby.getFromForumId());
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar.eS(NewSubPbActivity.this.getPageContext().getPageActivity())));
                                return;
                            }
                            NewSubPbActivity.this.lOu = false;
                            TbRichText dPf = duC.dnx().dPf();
                            int size = arrayList.size();
                            int a2 = NewSubPbActivity.this.a(dPf, bG, i, i, arrayList, concurrentHashMap);
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
                            if (duC == null) {
                                str3 = null;
                            } else {
                                if (duC.bFK() != null) {
                                    str8 = duC.bFK().getName();
                                    str9 = duC.bFK().getId();
                                }
                                if (duC.boO() != null) {
                                    str10 = duC.boO().getId();
                                }
                                z6 = true;
                                str3 = str10;
                            }
                            if (NewSubPbActivity.this.mby.duQ() != null) {
                                concurrentHashMap = NewSubPbActivity.this.mby.duQ();
                                z3 = NewSubPbActivity.this.mby.duS();
                                arrayList = NewSubPbActivity.this.mby.duR();
                                a2 = NewSubPbActivity.this.mby.getOffset() + a2;
                            } else {
                                z3 = z6;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(x.getItem(arrayList, a2));
                            ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                            aVar2.x(arrayList3).AE(str8).AF(str9).AG(str3).ji(z3).AH(str2).jj(true).d(concurrentHashMap).jk(true).jl(false).jm(false).s(NewSubPbActivity.this.boO()).AI(String.valueOf(bG.getPostId())).AJ(NewSubPbActivity.this.mby.getFromForumId());
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar2.eS(NewSubPbActivity.this.getPageContext().getPageActivity())));
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
    public bz boO() {
        if (this.mby == null || this.mby.duC() == null) {
            return null;
        }
        return this.mby.duC().boO();
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
        if (!doT()) {
            if (postData != null) {
                if (postData.brq() != null) {
                    MetaData brq = postData.brq();
                    this.kOT.setReplyId(brq.getUserId());
                    boolean z2 = postData.nss;
                    String str = "";
                    if (postData.dPf() != null) {
                        str = postData.dPf().toString();
                    }
                    this.kOT.Ea(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.brq().getName_show(), str));
                    if (z2) {
                        if (!z) {
                            this.kOT.DZ("");
                        }
                    } else if (!z) {
                        this.kOT.DZ(brq.getName_show());
                    }
                }
                this.mbA.duf();
            }
            if (this.mbM) {
                vS(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(AgreeData agreeData) {
        com.baidu.tbadk.pageExtra.c ft;
        int i = 1;
        if (agreeData != null) {
            if (this.fgY == null) {
                this.fgY = new com.baidu.tbadk.core.message.a();
            }
            if (this.fgI == null) {
                this.fgI = new e();
                this.fgI.uniqueId = this.mbO;
            }
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eOz = 12;
            dVar.eOF = 9;
            dVar.eOE = 3;
            if (dud() != null) {
                dVar.eOD = dud().duU();
            }
            if (dVar != null) {
                dVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (dVar != null) {
                        dVar.eOG = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (dVar != null) {
                        dVar.eOG = 1;
                        i = 0;
                    }
                }
                ft = com.baidu.tbadk.pageExtra.d.ft(getActivity());
                if (ft != null) {
                    agreeData.objSource = ft.getCurrentPageKey();
                }
                this.fgY.a(agreeData, i, getUniqueId(), false);
                this.fgY.a(agreeData, this.fgI);
                if (dud() == null && dud().duC() != null) {
                    this.fgY.a(this, dVar, agreeData, dud().duC().boO());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (dVar != null) {
                dVar.eOG = 1;
            }
            i = 0;
            ft = com.baidu.tbadk.pageExtra.d.ft(getActivity());
            if (ft != null) {
            }
            this.fgY.a(agreeData, i, getUniqueId(), false);
            this.fgY.a(agreeData, this.fgI);
            if (dud() == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        TbRichTextImageInfo bLc;
        if (tbRichText == tbRichText2) {
            this.lOu = true;
        }
        if (tbRichText != null && tbRichText.bKW() != null) {
            int size = tbRichText.bKW().size();
            int i3 = -1;
            int i4 = 0;
            int i5 = i;
            while (i4 < size) {
                if (tbRichText.bKW().get(i4) != null && tbRichText.bKW().get(i4).getType() == 8) {
                    i3++;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.bKW().get(i4).bLc().getWidth() * equipmentDensity;
                    int height = tbRichText.bKW().get(i4).bLc().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.bKW().get(i4).bLc().bLn()) {
                        if (tbRichText == tbRichText2 && i3 <= i2) {
                            i5--;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.bKW().get(i4);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (bLc = tbRichTextData.bLc()) != null) {
                            String bLp = bLc.bLp();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = bLp;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.lOu) {
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
        if (this.mbB != null) {
            this.mbB.ve(z);
        }
        if (this.mbA != null) {
            this.mbA.ve(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bLc = tbRichTextData.bLc();
        if (bLc != null) {
            if (!StringUtils.isNull(bLc.bLm())) {
                return bLc.bLm();
            }
            if (bLc.getHeight() * bLc.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bLc.getHeight() * bLc.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bLc.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bLc.getHeight())));
            } else {
                float width = bLc.getWidth() / bLc.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.at.getUrlEncode(bLc.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bG(String str, int i) {
        if (this.mby == null || this.mby.duC() == null || str == null || i < 0) {
            return null;
        }
        p duC = this.mby.duC();
        TbRichText a2 = a(duC.dnx(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(duC.dnx(), str, i);
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
        TbRichText dPf = postData.dPf();
        if (dPf != null) {
            ArrayList<TbRichTextData> bKW = dPf.bKW();
            int size = bKW.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (bKW.get(i3) != null && bKW.get(i3).getType() == 8) {
                    i2++;
                    if (bKW.get(i3).bLc().bLp().equals(str)) {
                        int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = bKW.get(i3).bLc().getWidth() * equipmentDensity;
                        int height = bKW.get(i3).bLc().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.lOt = i3;
                        return dPf;
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

    private boolean doT() {
        if (this.mby == null) {
            return false;
        }
        return AntiHelper.a(getPageContext(), this.mby.cDY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doU() {
        Intent intent = getIntent();
        boolean booleanExtra = intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false;
        if (!doT()) {
            if (booleanExtra) {
                if (this.kON == null || this.mby == null || this.mby.cDY() == null || this.kON.pZ(this.mby.cDY().replyPrivateFlag)) {
                    if (this.kOT.bFE()) {
                        this.kOT.a((PostWriteCallBackData) null);
                        return;
                    }
                    this.mbA.due();
                    this.mbA.duf();
                    if (this.kOT != null) {
                        this.kOT.bFT();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.jjD == null) {
                this.jjD = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jjD.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qG(boolean z) {
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
                    public void qH(boolean z) {
                        String str;
                        if (z) {
                            if (NewSubPbActivity.this.kON == null || NewSubPbActivity.this.mby == null || NewSubPbActivity.this.mby.cDY() == null || NewSubPbActivity.this.kON.pZ(NewSubPbActivity.this.mby.cDY().replyPrivateFlag)) {
                                if (NewSubPbActivity.this.mby != null && NewSubPbActivity.this.mby.duC() != null && NewSubPbActivity.this.mby.duC().dnx() != null) {
                                    PostData dnx = NewSubPbActivity.this.mby.duC().dnx();
                                    if (dnx.dPf() != null && dnx.brq() != null) {
                                        str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), dnx.brq().getName_show(), dnx.dPf().toString());
                                        NewSubPbActivity.this.kOT.bEI().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                                        if (!NewSubPbActivity.this.kOT.bFE()) {
                                            NewSubPbActivity.this.kOT.a((PostWriteCallBackData) null);
                                            return;
                                        }
                                        NewSubPbActivity.this.mbA.due();
                                        NewSubPbActivity.this.mbA.duf();
                                        if (NewSubPbActivity.this.kOT != null) {
                                            NewSubPbActivity.this.kOT.bFT();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                str = null;
                                NewSubPbActivity.this.kOT.bEI().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                                if (!NewSubPbActivity.this.kOT.bFE()) {
                                }
                            }
                        }
                    }
                });
            }
            if (this.mby != null && this.mby.duC() != null && this.mby.duC().bFK() != null) {
                this.jjD.H(this.mby.duC().bFK().getId(), com.baidu.adp.lib.f.b.toLong(this.mby.dpW(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uP(boolean z) {
        if (this.mby == null) {
            return false;
        }
        return ((dmT() != 0) || this.mby.duC() == null || this.mby.duC().boO() == null || this.mby.duC().boO().brq() == null || this.mby.duC().boO().bpZ() || TextUtils.equals(this.mby.duC().boO().brq().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(int i, String str) {
        if (this.mby.duD()) {
            showToast(str);
        } else if (l.isNetOk()) {
            if (i == 4) {
                this.mbA.Ji(str + "(4)");
            } else {
                this.mbA.En(R.string.no_data_text);
            }
        } else {
            this.mbA.En(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(boolean z) {
        this.kOT = (com.baidu.tbadk.editortools.pb.h) new i(z).fj(getActivity());
        if (this.kOT != null) {
            this.kOT.a(getPageContext());
            this.kOT.b(this.mby);
            this.kOT.b(this.klP);
            this.kOT.setFrom(2);
            this.kOT.a(this.fGh);
            this.kOT.a(this.fGi);
            this.kOT.bEI().kO(true);
            this.kOT.j(getPageContext());
        }
        if (this.mbA != null) {
            this.mbA.i(this.kOT);
        }
        if (this.kOT != null && this.mby != null) {
            this.kOT.a(this.mby.cDY());
            this.kOT.bFQ();
        }
        if (this.kOT != null) {
            this.kOT.bFU().setDefaultHint(drQ());
            this.kOT.bFU().setHint(drQ());
            this.klJ = this.kOT.bFU().getInputView();
            this.klJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.klI != null) {
                        if (!NewSubPbActivity.this.klI.dXT()) {
                            NewSubPbActivity.this.sj(false);
                        }
                        NewSubPbActivity.this.klI.zc(false);
                    }
                }
            });
        }
    }

    public void dub() {
        if (!TbadkCoreApplication.isLogin()) {
            this.kOT.bFQ();
        } else if (!StringUtils.isNull(this.mby.duM())) {
            if (this.mbA.dui() && l.isNetOk()) {
                this.mbA.cBX();
            } else {
                this.mbA.dul();
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
                    this.mbA.dN(view);
                }
            } else if (booleanValue2) {
                this.mbA.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.mbA.dus(), getPageContext().getPageActivity());
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
            bVar.pf(R.string.operation);
            bVar.a(strArr, new b.InterfaceC0578b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0578b
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.mbJ);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.mbJ);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).btZ();
        }
    }

    public void f(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.mbA.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.mbJ;
        userMuteCheckCustomMessage.setTag(this.mbJ);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.mbA.a(0, bVar.mSuccess, bVar.nuu, z);
            if (bVar.mSuccess) {
                if (bVar.iMd == 1) {
                    if (this.mbA.getListView() instanceof BdTypeListView) {
                        List<com.baidu.adp.widget.ListView.n> data = ((BdTypeListView) this.mbA.getListView()).getData();
                        if (!x.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.mbA.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.iMd == 2) {
                    this.mby.Qp(bVar.mPostId);
                    this.mbA.a(this.mby.duC(), this.mby.dmT(), this.mby.duQ() != null, false);
                    if (this.mby.duN()) {
                        this.mby.vW(false);
                        this.mbA.dug();
                        this.mby.loadData();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void PK(String str) {
        if (this.mby != null && this.mby.duC() != null && this.mby.duC().boO() != null && this.mby.duC().boO().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.mby.dpW(), str);
            bz boO = this.mby.duC().boO();
            if (boO.bpX()) {
                format = format + "&channelid=33833";
            } else if (boO.btn()) {
                format = format + "&channelid=33842";
            } else if (boO.bpY()) {
                format = format + "&channelid=33840";
            }
            PL(format);
            return;
        }
        this.lNi.Ql(str);
    }

    private void PL(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void n(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.mby.duJ() && postData.getId() != null && postData.getId().equals(this.mby.duL())) {
                z = true;
            }
            MarkData o = this.mby.o(postData);
            if (o != null) {
                this.mbA.dsG();
                if (this.lNj != null) {
                    this.lNj.a(o);
                    if (!z) {
                        this.lNj.bnz();
                    } else {
                        this.lNj.bny();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.mby != null) {
            this.mby.aD(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.kOT != null) {
            this.kOT.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.kOT.bEI().bDe();
        this.kOT.bFQ();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.kOT.c(writeData);
                this.kOT.setVoiceModel(pbEditorData.getVoiceModel());
                m sv = this.kOT.bEI().sv(6);
                if (sv != null && sv.fDH != null) {
                    sv.fDH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.kOT.bFM();
                }
                this.mbA.duz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.jfh != null) {
            this.jfh.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.mIsPaused = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.bkT().ble();
        if (this.jfh != null) {
            this.jfh.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.jtD);
        this.mbA.cNv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.mIsPaused = false;
        super.onResume();
        dpz();
        if (this.jfh != null) {
            this.jfh.onResume(getPageContext());
        }
        registerListener(this.jtD);
        this.mbA.cNw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jfh != null) {
            this.jfh.onStop(getPageContext());
        }
        this.kOT.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.mbL));
        this.mby.cancelLoadData();
        this.mby.destory();
        this.mbz.cancelLoadData();
        if (this.jfh != null) {
            this.jfh.onDestory(getPageContext());
        }
        this.mbA.dsG();
        this.mbA.cLD();
        MessageManager.getInstance().unRegisterListener(this.lOe);
        MessageManager.getInstance().unRegisterListener(this.lOf);
        MessageManager.getInstance().unRegisterListener(this.lOg);
        MessageManager.getInstance().unRegisterListener(this.mbJ);
        this.lND = null;
        this.lNE = null;
        if (this.kON != null) {
            this.kON.onDestroy();
        }
        com.baidu.tbadk.pageExtra.d.Ek(getCurrentPageKey());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mbA.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.jfh;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View dun = this.mbA.dun();
        if (dun == null || (findViewWithTag = dun.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean Qd(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = be.getParamPair(be.getParamStr(str))) != null) {
            this.mbK = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Qd(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(mbx);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (Qd(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.m mVar = new com.baidu.tbadk.data.m();
                    mVar.mLink = str;
                    mVar.type = 3;
                    mVar.fCE = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, mVar));
                }
            } else {
                be.bwu().b(getPageContext(), new String[]{str});
            }
            this.mbK = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.mbK = true;
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
        if (this.mbA != null) {
            return this.mbA.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bLE() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bLG() {
        if (this.fZS == null) {
            this.fZS = TbRichTextView.K(getPageContext().getPageActivity(), 8);
        }
        return this.fZS;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bLH() {
        if (this.fWE == null) {
            this.fWE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: czE */
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
        return this.fWE;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bLF() {
        if (this.fWD == null) {
            this.fWD = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bLR */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = k.bou().isShowImages();
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
                        if (k.bou().isShowImages()) {
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
        return this.fWD;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bLI() {
        if (this.fZT == null) {
            this.fZT = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dpG */
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
        return this.fZT;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bLJ() {
        if (this.fZU == null) {
            this.fZU = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dpI */
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
        return this.fZU;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bLK() {
        this.fZV = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dpH */
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
        return this.fZV;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a dnM() {
        return this.lJa;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean dnN() {
        return (this.mby == null || this.mby.duC() == null || this.mby.duC().boO() == null || this.mby.duC().boO().bsQ()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String dnO() {
        if (this.mby == null || this.mby.duC() == null || this.mby.duC().boO() == null) {
            return null;
        }
        return this.mby.duC().boO().bru();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int dnP() {
        if (this.mby == null) {
            return 0;
        }
        return this.mby.dmT();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean PE(String str) {
        if (StringUtils.isNull(str) || this.mby == null || this.mby.duC() == null || this.mby.duC().boO() == null || this.mby.duC().boO().brq() == null) {
            return false;
        }
        return str.equals(this.mby.duC().boO().brq().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mbA.dui() && l.isNetOk()) {
            this.mby.loadData();
        } else {
            this.mbA.dul();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.mbJ);
        userMuteAddAndDelCustomMessage.setTag(this.mbJ);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qn(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bvq().getString("bubble_link", "");
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
                return com.baidu.tbadk.m.e.bHs().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.mby != null) {
            if (this.mby.duC() != null && this.mby.duC().bFK() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.mby.duC().bFK().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.mby.dpW(), 0L));
            if (this.mby.duC() != null && this.mby.duC().boO() != null) {
                pageStayDurationItem.setNid(this.mby.duC().boO().bpO());
            }
            pageStayDurationItem.setPid(com.baidu.adp.lib.f.b.toLong(this.mby.bFk(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public boolean duc() {
        if (this.mby != null) {
            return this.mby.duc();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.mbA.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lND.getPageActivity());
        if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
            aVar.Bp(this.lND.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Bp(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.mbA.showLoadingDialog();
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
        aVar.b(this.lND).btX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DX(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lND.getPageActivity());
        aVar.Bp(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lND).btX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpv() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.Bp(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.lND).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.lND.getPageActivity(), 2, true, 4);
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
        aVar.b(this.lND).btX();
    }

    public SubPbModel dud() {
        return this.mby;
    }

    public int dmT() {
        if (this.mby != null) {
            return this.mby.dmT();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.fEd && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fEd && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void sj(boolean z) {
        if (this.klJ != null && this.klJ.getText() != null) {
            int selectionEnd = this.klJ.getSelectionEnd();
            SpannableStringBuilder d = this.klI.d(this.klJ.getText());
            if (d != null) {
                this.klI.zc(true);
                this.klJ.setText(d);
                if (z && this.klI.dXR() >= 0) {
                    this.klJ.requestFocus();
                    this.klJ.setSelection(this.klI.dXR());
                } else {
                    this.klJ.setSelection(selectionEnd);
                }
                this.klI.zb(this.klI.dXR() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kOT != null && this.kOT.bEI() != null && this.kOT.bEI().bEM()) {
            this.kOT.bEI().bDe();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.i
    public void onPreLoad(q qVar) {
        af.a(qVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.c.a(qVar, getUniqueId(), this);
    }

    public String drQ() {
        if (!com.baidu.tbadk.core.util.at.isEmpty(this.lWe)) {
            return this.lWe;
        }
        this.lWe = getResources().getString(com.baidu.tieba.pb.pb.main.ao.drG());
        return this.lWe;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.mbM = z;
        vS(true);
    }

    private void vS(boolean z) {
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
        if (this.mbA != null && this.mbA.getListView() != null && this.mbN != null && this.mbN.mPosition != -1) {
            final int headerViewsCount = this.mbN.mPosition + this.mbA.getListView().getHeaderViewsCount();
            if (this.mbN.getView() != null) {
                final int height = this.mbN.getView().getHeight();
                final int height2 = ((rect.height() - this.mbA.duy()) - this.mbA.getNavigationBarHeight()) - this.mbA.dux();
                final int i = height - height2;
                if (i > 0) {
                    this.mbA.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.mbA != null && NewSubPbActivity.this.mbA.getListView() != null) {
                                NewSubPbActivity.this.mbA.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.mbA.getNavigationBarHeight() - i);
                            }
                        }
                    });
                } else {
                    this.mbA.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.mbA != null && NewSubPbActivity.this.mbA.getListView() != null) {
                                NewSubPbActivity.this.mbA.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.mbA.getNavigationBarHeight() + (height2 - height));
                            }
                        }
                    });
                }
            }
        }
    }

    private void dpz() {
        if (this.mby != null && !com.baidu.tbadk.core.util.at.isEmpty(this.mby.dpW())) {
            com.baidu.tbadk.BdToken.c.bkT().p(com.baidu.tbadk.BdToken.b.eEL, com.baidu.adp.lib.f.b.toLong(this.mby.dpW(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.mby == null || com.baidu.tbadk.core.util.at.isEmpty(this.mby.dpW())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.mby.dpW(), 0L);
    }
}
