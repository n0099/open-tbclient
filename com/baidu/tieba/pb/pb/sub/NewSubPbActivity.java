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
    private static String lHU = "tbgametype";
    private View.OnClickListener aZX;
    private e eQR;
    private com.baidu.tbadk.core.message.a eRh;
    private bd ewz;
    private com.baidu.adp.lib.d.b<ImageView> fFL;
    private com.baidu.adp.lib.d.b<GifView> fFM;
    private com.baidu.adp.lib.d.b<TextView> fJc;
    private com.baidu.adp.lib.d.b<View> fJd;
    private com.baidu.adp.lib.d.b<LinearLayout> fJe;
    private com.baidu.adp.lib.d.b<RelativeLayout> fJf;
    private VoiceManager iHo;
    private com.baidu.tieba.frs.profession.permission.c iLK;
    private com.baidu.tieba.write.c jKh;
    private EditText jKi;
    private h kvE;
    public am kvy;
    private String lCJ;
    private SubPbModel lHV;
    private ForumManageModel lHW;
    private com.baidu.tieba.pb.pb.sub.a lHX;
    private ah lHY;
    private AbsListView.OnScrollListener lHZ;
    private TbRichTextView.i lIa;
    private SubPbModel.a lIb;
    private com.baidu.adp.base.d lIc;
    private BdUniqueId lIg;
    private com.baidu.tieba.pb.e<p> lIi;
    private boolean lIj;
    private n lIk;
    private com.baidu.tieba.pb.pb.main.b.a lpU;
    private com.baidu.tieba.pb.pb.report.a ltO;
    private com.baidu.tbadk.baseEditMark.a ltP;
    private com.baidu.adp.base.e luj;
    private com.baidu.tbadk.core.view.c luk;
    private com.baidu.adp.widget.ImageView.a lun;
    private String luo;
    private TbRichTextMemeInfo lup;
    private PostWriteCallBackData lvW;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int luZ = 0;
    PostData jKP = null;
    private a.InterfaceC0573a luV = null;
    private a lId = null;
    private a lIe = null;
    private boolean mIsPaused = false;
    private boolean lIf = false;
    private boolean lIh = false;
    private boolean fnL = false;
    private com.baidu.tbadk.editortools.pb.c fpP = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bAc() {
            NewSubPbActivity.this.lHX.dpD();
        }
    };
    private int lpq = 0;
    private boolean mIsFromSchema = false;
    private BdUniqueId lIl = BdUniqueId.gen();
    private boolean lrn = com.baidu.tbadk.a.d.bhV();
    private boolean lIm = true;
    private com.baidu.tbadk.editortools.pb.b fpQ = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bAb() {
            if (!NewSubPbActivity.this.jKh.dSV()) {
                return (NewSubPbActivity.this.kvy == null || NewSubPbActivity.this.lHV == null || NewSubPbActivity.this.lHV.cxn() == null || NewSubPbActivity.this.kvy.aN(NewSubPbActivity.this.lHV.cxn().replyPrivateFlag, am.eNn)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.jKh.dSX());
            if (NewSubPbActivity.this.kvE.bAt()) {
                NewSubPbActivity.this.kvE.a(NewSubPbActivity.this.lvW);
            }
            NewSubPbActivity.this.rh(true);
            return true;
        }
    };
    private CustomMessageListener lIn = new CustomMessageListener(2921481) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && NewSubPbActivity.this.lHV != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && at.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), NewSubPbActivity.this.lHV.dlx())) {
                if (NewSubPbActivity.this.jKh != null) {
                    NewSubPbActivity.this.jKh.UA(null);
                    NewSubPbActivity.this.jKh.bk(null);
                    NewSubPbActivity.this.jKh.yp(false);
                }
                if (NewSubPbActivity.this.kvE != null) {
                    NewSubPbActivity.this.kvE.bAD();
                    NewSubPbActivity.this.kvE.reset();
                }
                NewSubPbActivity.this.lHV.bzY();
            }
        }
    };
    private NewWriteModel.d jKo = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.kvE != null && NewSubPbActivity.this.kvE.bzx() != null) {
                NewSubPbActivity.this.kvE.bzx().hide();
                if (NewSubPbActivity.this.lHV.dqd()) {
                    TiebaStatic.log(new aq("c10367").dR("post_id", NewSubPbActivity.this.lHV.bzZ()));
                }
            }
            if (z) {
                NewSubPbActivity.this.jKh.UA(null);
                NewSubPbActivity.this.jKh.bk(null);
                NewSubPbActivity.this.jKh.yp(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(NewSubPbActivity.this.getPageContext(), postWriteCallBackData);
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.jKh.bk(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.jKh.UA(postWriteCallBackData.getErrorString());
                if (!y.isEmpty(NewSubPbActivity.this.jKh.dST())) {
                    NewSubPbActivity.this.lvW = postWriteCallBackData;
                    if (NewSubPbActivity.this.kvE.bAt()) {
                        NewSubPbActivity.this.kvE.a(NewSubPbActivity.this.lvW);
                    }
                    NewSubPbActivity.this.rh(true);
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
                    aVar.Bo(NewSubPbActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Bo(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new aq("c13746").al("obj_locate", 1).al("obj_type", 2));
                    }
                });
                aVar.b(NewSubPbActivity.this.getPageContext()).bpc();
                TiebaStatic.log(new aq("c13745").al("obj_locate", 1).al("obj_type", 2));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.kvy != null) {
                NewSubPbActivity.this.kvy.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.lHX.dpE();
        }
    };
    private CustomMessageListener luK = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.lIg) {
                NewSubPbActivity.this.lHX.chg();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.luk.showSuccessToast(NewSubPbActivity.this.luj.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.luj.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.DT(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.dkW();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (at.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.luj.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.luk.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener luL = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.lIg) {
                NewSubPbActivity.this.lHX.chg();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.luk.showSuccessToast(NewSubPbActivity.this.luj.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (at.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.luj.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.luk.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener luM = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.lIg) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.lHX.chg();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.nlA;
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
                    NewSubPbActivity.this.lHX.a(sparseArray, z);
                }
            }
        }
    };
    private final f.c gqm = new f.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (NewSubPbActivity.this.lHV != null) {
                NewSubPbActivity.this.lHV.dqb();
            }
        }
    };
    boolean lva = false;
    private final b.InterfaceC0576b lvc = new b.InterfaceC0576b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0576b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.lun != null && !TextUtils.isEmpty(NewSubPbActivity.this.luo)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.lup == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.luo));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.luo;
                        aVar.pkgId = NewSubPbActivity.this.lup.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.lup.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.ewz == null) {
                            NewSubPbActivity.this.ewz = new bd(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.ewz.j(NewSubPbActivity.this.luo, NewSubPbActivity.this.lun.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.lun = null;
                NewSubPbActivity.this.luo = null;
            }
        }
    };
    private CustomMessageListener jWO = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener iIU = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof m)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    m mVar = (m) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.lHV.dpV() != null && NewSubPbActivity.this.lHV.dpV().dja() != null && NewSubPbActivity.this.lHV.dpV().dja().bmA() != null && currentAccount.equals(NewSubPbActivity.this.lHV.dpV().dja().bmA().getUserId()) && NewSubPbActivity.this.lHV.dpV().dja().bmA().getPendantData() != null) {
                        NewSubPbActivity.this.lHV.dpV().dja().bmA().getPendantData().AX(mVar.bkw());
                        NewSubPbActivity.this.lHV.dpV().dja().bmA().getPendantData().dF(mVar.byW());
                        NewSubPbActivity.this.lHX.a(NewSubPbActivity.this.lHV.dpV(), NewSubPbActivity.this.lHV.dpV().dja(), NewSubPbActivity.this.lHV.dpV().Wq(), NewSubPbActivity.this.lHV.dpV().biv(), NewSubPbActivity.this.lHV.diz(), NewSubPbActivity.this.lHV.dqj() != null);
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
        this.luj = getPageContext();
        this.lIf = true;
        this.jKh = new com.baidu.tieba.write.c();
        this.jKh.Lh(R.color.cp_cont_h_alpha85);
        this.jKh.Lg(R.color.cp_cont_a);
        bWm();
        dpt();
        initData(bundle);
        initUI();
        ((SubPbView) this.lHX.getRootView()).show();
        sD(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lHX.vm(this.mIsFromSchema);
        this.luk = new com.baidu.tbadk.core.view.c();
        this.luk.toastTime = 1000L;
        registerListener(this.luM);
        registerListener(this.luK);
        registerListener(this.luL);
        registerListener(this.lIn);
        this.lIg = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.lIg;
        userMuteAddAndDelCustomMessage.setTag(this.lIg);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.lIg;
        userMuteCheckCustomMessage.setTag(this.lIg);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.kvy = new am(getPageContext());
        this.kvy.a(new am.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.kvE.bAB();
                }
            }
        });
        this.ltO = new com.baidu.tieba.pb.pb.report.a(this);
        this.ltO.w(getUniqueId());
        this.lpU = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.lHX = new com.baidu.tieba.pb.pb.sub.a(this, this.aZX);
        this.lHX.a(this.lHV);
        setContentView(this.lHX.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.lHX.setOnScrollListener(this.lHZ);
        this.lHX.b(this);
        this.lHX.setOnImageClickListener(this.lIa);
        this.lHX.setOnLongClickListener(this.mOnLongClickListener);
        this.lHX.g(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.lHV != null) {
                    NewSubPbActivity.this.lHV.loadData();
                }
            }
        });
        this.lHX.a(this.lId);
        this.lHX.b(this.lIe);
        this.lHX.setListPullRefreshListener(this.gqm);
        if (this.lHV != null && this.lHV.dpv() && !this.lHV.dqi()) {
            this.lHX.dpJ().setVisibility(8);
        } else {
            this.lHX.dpJ().setVisibility(0);
        }
        if (this.lHV != null && !this.lHV.dpv()) {
            this.lHX.setIsFromPb(false);
        }
    }

    private boolean aD(Bundle bundle) {
        if (bundle != null) {
            this.fnL = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.fnL = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.fnL;
    }

    public void initData(Bundle bundle) {
        this.lHV = new SubPbModel(getPageContext());
        this.lHV.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                NewSubPbActivity.this.lHX.u(postData);
                NewSubPbActivity.this.lHX.b((BdListView.e) null);
            }
        });
        this.lHW = new ForumManageModel(getPageContext());
        this.lHW.setLoadDataCallBack(this.lIc);
        this.iHo = new VoiceManager();
        this.iHo.onCreate(getPageContext());
        this.ltP = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.ltP != null) {
            this.ltP.a(this.luV);
        }
        if (bundle != null) {
            this.lHV.initWithBundle(bundle);
        } else {
            this.lHV.initWithIntent(getIntent());
        }
        this.lHV.a(this.lIb);
        if (this.lHV.dpv() && !this.lHV.dqo()) {
            this.lHV.loadData();
        } else {
            this.lHV.dqa();
        }
    }

    public void dpt() {
        this.lIb = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, final p pVar) {
                if (NewSubPbActivity.this.lHX != null) {
                    NewSubPbActivity.this.lHX.dpE();
                    if (!z) {
                        NewSubPbActivity.this.bM(i, str);
                        return;
                    }
                    NewSubPbActivity.this.lHX.hideNoDataView();
                    if (pVar != null) {
                        if (pVar.dja() != null || NewSubPbActivity.this.lHV != null) {
                            pVar.dja().a(NewSubPbActivity.this.lHV.dqh());
                        }
                        if (NewSubPbActivity.this.lHX != null) {
                            NewSubPbActivity.this.sD(pVar.bjZ() != null && pVar.bjZ().isBjh());
                            if (NewSubPbActivity.this.kvE != null && NewSubPbActivity.this.kvE.bzx() != null) {
                                NewSubPbActivity.this.kvE.bzx().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.lHX.a(pVar, NewSubPbActivity.this.lHV.diz(), NewSubPbActivity.this.lHV.dqj() != null, NewSubPbActivity.this.lIf);
                            if (NewSubPbActivity.this.lIf) {
                                NewSubPbActivity.this.lHX.getListView().setSelectionFromTop(NewSubPbActivity.this.lHX.getListView().getHeaderViewsCount() + 1, -l.getDimens(NewSubPbActivity.this, R.dimen.tbds18));
                                NewSubPbActivity.this.dpu();
                                NewSubPbActivity.this.lIf = false;
                            }
                        }
                        if (NewSubPbActivity.this.kvE != null) {
                            NewSubPbActivity.this.kvE.a(pVar.cxn());
                            NewSubPbActivity.this.kvE.setThreadData(pVar.bjZ());
                            if (NewSubPbActivity.this.getIntent() != null && NewSubPbActivity.this.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && NewSubPbActivity.this.lIm) {
                                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        NewSubPbActivity.this.lIm = false;
                                        NewSubPbActivity.this.c(pVar.dja(), false);
                                    }
                                }, 200L);
                            }
                        }
                        if (NewSubPbActivity.this.lIi == null) {
                            NewSubPbActivity.this.lIi = new com.baidu.tieba.pb.e();
                        }
                        NewSubPbActivity.this.lIi.setData(pVar);
                        NewSubPbActivity.this.lIi.setType(0);
                        NewSubPbActivity.this.kvy.a(NewSubPbActivity.this.lHV.dqm());
                    }
                }
            }
        };
        this.luV = new a.InterfaceC0573a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0573a
            public void d(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.ltP != null) {
                        NewSubPbActivity.this.ltP.iq(z2);
                    }
                    MarkData biy = NewSubPbActivity.this.ltP.biy();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(biy);
                        if (NewSubPbActivity.this.ltP != null) {
                            if (biy != null) {
                                NewSubPbActivity.this.lHV.vo(true);
                                NewSubPbActivity.this.lHV.Qg(NewSubPbActivity.this.lHV.bzZ());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.lHX != null) {
                                NewSubPbActivity.this.lHX.vn(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.lHV.vo(false);
                        NewSubPbActivity.this.lHV.Qg(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.lHX != null) {
                            NewSubPbActivity.this.lHX.vn(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.lId = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.lHV.dpV() != null && NewSubPbActivity.this.lHV.dpV().bjZ() != null && NewSubPbActivity.this.lHV.dpV().bjZ().bmA() != null) {
                    str = String.valueOf(NewSubPbActivity.this.lHV.dpV().bjZ().bmA().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.lHV.dpV().bAz().getId(), NewSubPbActivity.this.lHV.dpV().bAz().getName(), NewSubPbActivity.this.lHV.dpV().bjZ().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.lIe = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.lHW.dKK() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.lHV != null && NewSubPbActivity.this.lHV.dpV() != null && NewSubPbActivity.this.lHV.dpV().bAz() != null && NewSubPbActivity.this.lHV.dpV().bjZ() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.lHW.ST(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.lHW.a(NewSubPbActivity.this.lHV.dpV().bAz().getId(), NewSubPbActivity.this.lHV.dpV().bAz().getName(), NewSubPbActivity.this.lHV.dpV().bjZ().getId(), valueOf, i2, i, z, NewSubPbActivity.this.lHV.dpV().bjZ().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.lIc = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.lHX.a(NewSubPbActivity.this.lHW.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.lHW.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.lJk != 1002 || bVar.gQx) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.lHX.a(1, dVar.QP, dVar.mZE, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean dk(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void bWm() {
        registerListener(this.iIU);
        this.aZX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
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
                if (view != null || NewSubPbActivity.this.lHX != null) {
                    if (view == NewSubPbActivity.this.lHX.dpP()) {
                        NewSubPbActivity.this.lHX.dob();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                be.brr().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.lHX.cDm()) {
                        if (view != NewSubPbActivity.this.lHX.dpI()) {
                            if (view == NewSubPbActivity.this.lHX.dpH()) {
                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                    NewSubPbActivity.this.lHX.dpx();
                                    NewSubPbActivity.this.lHX.dpy();
                                    if (NewSubPbActivity.this.kvE != null) {
                                        NewSubPbActivity.this.kvE.bAH();
                                    }
                                }
                            } else if (view.getId() != R.id.pb_floor_feedback) {
                                if (view == NewSubPbActivity.this.lHX.dpC()) {
                                    NewSubPbActivity.this.lHX.dob();
                                    if (NewSubPbActivity.this.lHV.loadData()) {
                                        NewSubPbActivity.this.lHX.dpA();
                                    }
                                } else if (view == NewSubPbActivity.this.lHX.dpJ() || view == NewSubPbActivity.this.lHX.dpK() || view == NewSubPbActivity.this.lHX.dpM()) {
                                    if (NewSubPbActivity.this.lIh) {
                                        NewSubPbActivity.this.lIh = false;
                                        return;
                                    }
                                    if (NewSubPbActivity.this.lHV.dpV() != null && NewSubPbActivity.this.lHV.dpV().bjZ() != null) {
                                        z2 = ay.a(NewSubPbActivity.this.lHV.dpV().bjZ().getBaijiahaoData());
                                    }
                                    if (z2) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.lHV.dlx(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.lHV.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.lHV.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.lHV.dpV() != null && NewSubPbActivity.this.lHV.dpV().bjZ() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.lHV.dpV().bjZ().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.lHV.dlx(), NewSubPbActivity.this.lHV.bzZ(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.lHV.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.lHV.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.lHX.dpN() == null || view != NewSubPbActivity.this.lHX.dpN().dmw()) {
                                    if (NewSubPbActivity.this.lHX.dpN() == null || view != NewSubPbActivity.this.lHX.dpN().dmz()) {
                                        if (NewSubPbActivity.this.lHX.dpN() == null || view != NewSubPbActivity.this.lHX.dpN().dmx()) {
                                            if (NewSubPbActivity.this.lHX.dpN() == null || view != NewSubPbActivity.this.lHX.dpN().dmy()) {
                                                if (NewSubPbActivity.this.lHX.dpN() == null || view != NewSubPbActivity.this.lHX.dpN().dmA()) {
                                                    if (view == NewSubPbActivity.this.lHX.dpG() || view == NewSubPbActivity.this.lHX.dpM()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.kvE.bAE()) {
                                                                NewSubPbActivity.this.kvE.bAF();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.kvE.DU(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view != null && (view.getTag() instanceof n)) {
                                                        NewSubPbActivity.this.lIk = (n) view.getTag();
                                                        if (bg.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.lIh) {
                                                                NewSubPbActivity.this.lIh = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.kvy == null || NewSubPbActivity.this.lHV == null || NewSubPbActivity.this.lHV.cxn() == null || NewSubPbActivity.this.kvy.oT(NewSubPbActivity.this.lHV.cxn().replyPrivateFlag)) && (sparseArray2 = (SparseArray) view.getTag(R.id.tag_from)) != null) {
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
                                                        if (NewSubPbActivity.this.lHY == null || view != NewSubPbActivity.this.lHY.dmy()) {
                                                            if (NewSubPbActivity.this.lHY == null || view != NewSubPbActivity.this.lHY.dmw()) {
                                                                if (NewSubPbActivity.this.lHY == null || view != NewSubPbActivity.this.lHY.dmz()) {
                                                                    if (NewSubPbActivity.this.lHY == null || view != NewSubPbActivity.this.lHY.dmA()) {
                                                                        if (NewSubPbActivity.this.lHY == null || view != NewSubPbActivity.this.lHY.dmC()) {
                                                                            if (NewSubPbActivity.this.lHY == null || view != NewSubPbActivity.this.lHY.dmD()) {
                                                                                if (NewSubPbActivity.this.lHY == null || view != NewSubPbActivity.this.lHY.dmE()) {
                                                                                    if (NewSubPbActivity.this.lHY != null && view == NewSubPbActivity.this.lHY.dmx()) {
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
                                                                                                NewSubPbActivity.this.lHX.dp(view);
                                                                                                return;
                                                                                            } else if (booleanValue2) {
                                                                                                NewSubPbActivity.this.lHX.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                                            String string2 = com.baidu.tbadk.core.sharedPref.b.bqh().getString("tail_link", "");
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
                                                                                            if (postData2.getType() != PostData.eDR && !TextUtils.isEmpty(postData2.getBimg_url()) && k.bjH().isShowImages()) {
                                                                                                NewSubPbActivity.this.Qd(postData2.getId());
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
                                                                                    if (postData3.bor() != null) {
                                                                                        NewSubPbActivity.this.d(postData3.bor());
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.lun != null && !TextUtils.isEmpty(NewSubPbActivity.this.luo)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.ewz == null) {
                                                                                        NewSubPbActivity.this.ewz = new bd(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.ewz.j(NewSubPbActivity.this.luo, NewSubPbActivity.this.lun.getImageByte());
                                                                                    NewSubPbActivity.this.lun = null;
                                                                                    NewSubPbActivity.this.luo = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.lun != null && !TextUtils.isEmpty(NewSubPbActivity.this.luo)) {
                                                                            if (NewSubPbActivity.this.lup == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.luo));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.luo;
                                                                                aVar.pkgId = NewSubPbActivity.this.lup.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.lup.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.lun = null;
                                                                            NewSubPbActivity.this.luo = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.jKP != null) {
                                                                        NewSubPbActivity.this.jKP.fT(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.jKP = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                if (sparseArray5 != null && (sparseArray5.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_id) instanceof String) && (sparseArray5.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.lHX.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.dj(view);
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
                                                                NewSubPbActivity.this.PA((String) tag);
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
                                                            if (NewSubPbActivity.this.lHV != null) {
                                                                TiebaStatic.log(new aq("c13700").dR("tid", NewSubPbActivity.this.lHV.dly()).dR("fid", NewSubPbActivity.this.lHV.getFromForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).al("obj_type", 3));
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
                                            TiebaStatic.log(new aq("c11739").al("obj_locate", 4));
                                            if (!j.isNetWorkAvailable()) {
                                                NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.lHX.dob();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.PA(str4);
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
                                            NewSubPbActivity.this.lHX.dob();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.ds(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.lHX.dob();
                                    SparseArray sparseArray10 = (SparseArray) view.getTag();
                                    if (sparseArray10 != null) {
                                        NewSubPbActivity.this.lHX.a(((Integer) sparseArray10.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray10.get(R.id.tag_del_post_id), ((Integer) sparseArray10.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new aq("c11739").al("obj_locate", 2));
                                    NewSubPbActivity.this.lHX.dob();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.lHV.dpV() != null) {
                                        NewSubPbActivity.this.n(NewSubPbActivity.this.lHV.dpV().dja());
                                    }
                                }
                            } else {
                                try {
                                    sparseArray3 = (SparseArray) view.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                }
                                if (sparseArray3 != null && ((PostData) sparseArray3.get(R.id.tag_clip_board)) != null) {
                                    if (NewSubPbActivity.this.lHY == null) {
                                        NewSubPbActivity.this.lHY = new ah(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aZX);
                                        NewSubPbActivity.this.lHX.dt(NewSubPbActivity.this.lHY.getView());
                                        NewSubPbActivity.this.lHY.uy(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.lHY.Qj();
                                    if (NewSubPbActivity.this.uj(sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin()) {
                                        z2 = true;
                                    }
                                    NewSubPbActivity.this.lHY.a(sparseArray3, NewSubPbActivity.this.diz(), z2);
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.lHX.dpx();
                            NewSubPbActivity.this.lHX.dpy();
                            if (NewSubPbActivity.this.kvE != null) {
                                NewSubPbActivity.this.kvE.bAG();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.dkv();
                        if (NewSubPbActivity.this.lHV != null && NewSubPbActivity.this.lHV.dpV() != null && NewSubPbActivity.this.lHV.dpV().bjZ() != null && NewSubPbActivity.this.lHV.dpV().bjZ().bmA() != null) {
                            TiebaStatic.log(new aq("c13402").dR("tid", NewSubPbActivity.this.lHV.dlx()).w("fid", NewSubPbActivity.this.lHV.dpV().bjZ().getFid()).al("obj_locate", 5).dR("uid", NewSubPbActivity.this.lHV.dpV().bjZ().bmA().getUserId()));
                        }
                    }
                }
            }
        };
        this.lHZ = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.lHX.dob();
                    if (NewSubPbActivity.this.lpq != 2 && NewSubPbActivity.this.lpq != 1) {
                        NewSubPbActivity.this.lHX.dpS();
                    }
                }
                NewSubPbActivity.this.kvE.bAF();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.lHX.dpO();
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
                if (NewSubPbActivity.this.lHX != null && NewSubPbActivity.this.lHX.dpF()) {
                    return false;
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null && NewSubPbActivity.this.dk(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.lun = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.luo = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.lun == null || TextUtils.isEmpty(NewSubPbActivity.this.luo)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lup = null;
                        } else {
                            NewSubPbActivity.this.lup = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.lun = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.luo = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lup = null;
                        } else {
                            NewSubPbActivity.this.lup = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.lun = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.luo = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lup = null;
                        } else {
                            NewSubPbActivity.this.lup = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        NewSubPbActivity.this.lHX.a(NewSubPbActivity.this.lvc, NewSubPbActivity.this.lun.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.jKP = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.jKP == null || NewSubPbActivity.this.ltP == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.ltP != null) {
                            NewSubPbActivity.this.ltP.iq(NewSubPbActivity.this.lHV.dqc());
                        }
                        boolean z2 = NewSubPbActivity.this.ltP.biv() && NewSubPbActivity.this.jKP.getId() != null && NewSubPbActivity.this.jKP.getId().equals(NewSubPbActivity.this.lHV.dqe());
                        if (NewSubPbActivity.this.lHY == null) {
                            NewSubPbActivity.this.lHY = new ah(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.aZX);
                            NewSubPbActivity.this.lHX.dt(NewSubPbActivity.this.lHY.getView());
                            NewSubPbActivity.this.lHY.uy(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.lHY.Qj();
                        boolean z3 = NewSubPbActivity.this.uj(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z4 = (NewSubPbActivity.this.lHV.dpV() == null || NewSubPbActivity.this.lHV.dpV().bjZ() == null || !NewSubPbActivity.this.lHV.dpV().bjZ().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z2) {
                            NewSubPbActivity.this.lHY.dmw().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.lHY.dmw().setText(R.string.mark);
                        }
                        if (booleanValue || z4) {
                            NewSubPbActivity.this.lHY.dmw().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.lHY.dmw().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.dk(view)) {
                            if (NewSubPbActivity.this.lun != null && !NewSubPbActivity.this.lun.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        ah ahVar = NewSubPbActivity.this.lHY;
                        int diz = NewSubPbActivity.this.diz();
                        if (NewSubPbActivity.this.lrn && NewSubPbActivity.this.jKP.mXO) {
                            z = true;
                        }
                        ahVar.a(sparseArray2, diz, z3, z);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.lIa = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
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
                        p dpV = NewSubPbActivity.this.lHV.dpV();
                        TbRichText bz = NewSubPbActivity.this.bz(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bz != null && bz.bFI() != null) {
                            tbRichTextData = bz.bFI().get(NewSubPbActivity.this.luZ);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!tbRichTextData.bFO().bGc()) {
                                String c = NewSubPbActivity.this.c(tbRichTextData);
                                arrayList.add(c);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap.put(c, imageUrlData);
                                String str5 = null;
                                String str6 = null;
                                String str7 = null;
                                if (dpV == null) {
                                    str4 = null;
                                    z4 = false;
                                } else {
                                    if (dpV.bAz() != null) {
                                        str5 = dpV.bAz().getName();
                                        str6 = dpV.bAz().getId();
                                    }
                                    if (dpV.bjZ() != null) {
                                        str7 = dpV.bjZ().getId();
                                    }
                                    str4 = str7;
                                    z4 = true;
                                }
                                if (NewSubPbActivity.this.lHV.dqj() != null) {
                                    concurrentHashMap = NewSubPbActivity.this.lHV.dqj();
                                    z4 = NewSubPbActivity.this.lHV.dql();
                                    arrayList = NewSubPbActivity.this.lHV.dqk();
                                }
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(y.getItem(arrayList, 0));
                                ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                                aVar.x(arrayList2).AE(str5).AF(str6).AG(str4).ix(z4).AH(arrayList.get(0)).iy(true).a(concurrentHashMap).iz(true).iA(false).iB(false).s(NewSubPbActivity.this.bjZ()).AI(String.valueOf(bz.getPostId())).AJ(NewSubPbActivity.this.lHV.getFromForumId());
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar.dU(NewSubPbActivity.this.getPageContext().getPageActivity())));
                                return;
                            }
                            NewSubPbActivity.this.lva = false;
                            TbRichText dKb = dpV.dja().dKb();
                            int size = arrayList.size();
                            int a2 = NewSubPbActivity.this.a(dKb, bz, i, i, arrayList, concurrentHashMap);
                            int size2 = arrayList.size();
                            if (size == size2) {
                                str2 = "";
                            } else {
                                str2 = arrayList.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (dpV == null) {
                                str3 = null;
                                z3 = false;
                            } else {
                                if (dpV.bAz() != null) {
                                    str8 = dpV.bAz().getName();
                                    str9 = dpV.bAz().getId();
                                }
                                if (dpV.bjZ() != null) {
                                    str10 = dpV.bjZ().getId();
                                }
                                str3 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.lHV.dqj() != null) {
                                concurrentHashMap = NewSubPbActivity.this.lHV.dqj();
                                z3 = NewSubPbActivity.this.lHV.dql();
                                arrayList = NewSubPbActivity.this.lHV.dqk();
                                a2 += NewSubPbActivity.this.lHV.getOffset();
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(y.getItem(arrayList, a2));
                            ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                            aVar2.x(arrayList3).AE(str8).AF(str9).AG(str3).ix(z3).AH(str2).iy(true).a(concurrentHashMap).iz(true).iA(false).iB(false).s(NewSubPbActivity.this.bjZ()).AI(String.valueOf(bz.getPostId())).AJ(NewSubPbActivity.this.lHV.getFromForumId());
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
    public bw bjZ() {
        if (this.lHV == null || this.lHV.dpV() == null) {
            return null;
        }
        return this.lHV.dpV().bjZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dj(View view) {
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
            if (postData.bmA() != null) {
                MetaData bmA = postData.bmA();
                this.kvE.setReplyId(bmA.getUserId());
                boolean z2 = postData.mXO;
                String str = "";
                if (postData.dKb() != null) {
                    str = postData.dKb().toString();
                }
                this.kvE.DW(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bmA().getName_show(), str));
                if (z2) {
                    if (!z) {
                        this.kvE.DV("");
                    }
                } else if (!z) {
                    this.kvE.DV(bmA.getName_show());
                }
            }
            this.lHX.dpy();
        }
        if (this.lIj) {
            vl(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eRh == null) {
                this.eRh = new com.baidu.tbadk.core.message.a();
            }
            if (this.eQR == null) {
                this.eQR = new e();
                this.eQR.uniqueId = this.lIl;
            }
            com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
            cVar.ezt = 12;
            cVar.ezz = 9;
            cVar.ezy = 3;
            if (dpw() != null) {
                cVar.ezx = dpw().dqn();
            }
            if (cVar != null) {
                cVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (cVar != null) {
                        cVar.ezA = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (cVar != null) {
                        cVar.ezA = 1;
                        i = 0;
                    }
                }
                this.eRh.a(agreeData, i, getUniqueId(), false);
                this.eRh.a(agreeData, this.eQR);
                if (dpw() == null && dpw().dpV() != null) {
                    this.eRh.a(this, cVar, agreeData, dpw().dpV().bjZ());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (cVar != null) {
                cVar.ezA = 1;
            }
            i = 0;
            this.eRh.a(agreeData, i, getUniqueId(), false);
            this.eRh.a(agreeData, this.eQR);
            if (dpw() == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bFO;
        if (tbRichText == tbRichText2) {
            this.lva = true;
        }
        if (tbRichText != null && tbRichText.bFI() != null) {
            int size = tbRichText.bFI().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.bFI().get(i6) != null && tbRichText.bFI().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.bFI().get(i6).bFO().getWidth() * equipmentDensity;
                    int height = tbRichText.bFI().get(i6).bFO().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.bFI().get(i6).bFO().bGc()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.bFI().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (bFO = tbRichTextData.bFO()) != null) {
                            String bGe = bFO.bGe();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = bGe;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.lva) {
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
        if (this.lHY != null) {
            this.lHY.uy(z);
        }
        if (this.lHX != null) {
            this.lHX.uy(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bFO = tbRichTextData.bFO();
        if (bFO != null) {
            if (!StringUtils.isNull(bFO.bGb())) {
                return bFO.bGb();
            }
            if (bFO.getHeight() * bFO.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bFO.getHeight() * bFO.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bFO.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bFO.getHeight())));
            } else {
                float width = bFO.getWidth() / bFO.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(at.getUrlEncode(bFO.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bz(String str, int i) {
        if (this.lHV == null || this.lHV.dpV() == null || str == null || i < 0) {
            return null;
        }
        p dpV = this.lHV.dpV();
        TbRichText a2 = a(dpV.dja(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(dpV.dja(), str, i);
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
        TbRichText dKb = postData.dKb();
        if (dKb != null) {
            ArrayList<TbRichTextData> bFI = dKb.bFI();
            int size = bFI.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (bFI.get(i3) != null && bFI.get(i3).getType() == 8) {
                    i2++;
                    if (bFI.get(i3).bFO().bGe().equals(str)) {
                        int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = bFI.get(i3).bFO().getWidth() * equipmentDensity;
                        int height = bFI.get(i3).bFO().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.luZ = i3;
                        return dKb;
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
    public void dkv() {
        Intent intent = getIntent();
        if (intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false) {
            if (this.kvy == null || this.lHV == null || this.lHV.cxn() == null || this.kvy.oT(this.lHV.cxn().replyPrivateFlag)) {
                if (this.kvE.bAt()) {
                    this.kvE.a((PostWriteCallBackData) null);
                    return;
                }
                this.lHX.dpx();
                this.lHX.dpy();
                if (this.kvE != null) {
                    this.kvE.bAI();
                    return;
                }
                return;
            }
            return;
        }
        if (this.iLK == null) {
            this.iLK = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
            this.iLK.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void pI(boolean z) {
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
                public void pJ(boolean z) {
                    String str;
                    if (z) {
                        if (NewSubPbActivity.this.kvy == null || NewSubPbActivity.this.lHV == null || NewSubPbActivity.this.lHV.cxn() == null || NewSubPbActivity.this.kvy.oT(NewSubPbActivity.this.lHV.cxn().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.lHV != null && NewSubPbActivity.this.lHV.dpV() != null && NewSubPbActivity.this.lHV.dpV().dja() != null) {
                                PostData dja = NewSubPbActivity.this.lHV.dpV().dja();
                                if (dja.dKb() != null && dja.bmA() != null) {
                                    str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), dja.bmA().getName_show(), dja.dKb().toString());
                                    NewSubPbActivity.this.kvE.bzx().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                                    if (!NewSubPbActivity.this.kvE.bAt()) {
                                        NewSubPbActivity.this.kvE.a((PostWriteCallBackData) null);
                                        return;
                                    }
                                    NewSubPbActivity.this.lHX.dpx();
                                    NewSubPbActivity.this.lHX.dpy();
                                    if (NewSubPbActivity.this.kvE != null) {
                                        NewSubPbActivity.this.kvE.bAI();
                                        return;
                                    }
                                    return;
                                }
                            }
                            str = null;
                            NewSubPbActivity.this.kvE.bzx().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                            if (!NewSubPbActivity.this.kvE.bAt()) {
                            }
                        }
                    }
                }
            });
        }
        if (this.lHV != null && this.lHV.dpV() != null && this.lHV.dpV().bAz() != null) {
            this.iLK.G(this.lHV.dpV().bAz().getId(), com.baidu.adp.lib.f.b.toLong(this.lHV.dlx(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uj(boolean z) {
        if (this.lHV == null) {
            return false;
        }
        return ((diz() != 0) || this.lHV.dpV() == null || this.lHV.dpV().bjZ() == null || this.lHV.dpV().bjZ().bmA() == null || this.lHV.dpV().bjZ().blk() || TextUtils.equals(this.lHV.dpV().bjZ().bmA().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(int i, String str) {
        if (this.lHV.dpW()) {
            showToast(str);
        } else if (l.isNetOk()) {
            if (i == 4) {
                this.lHX.IT(str + "(4)");
            } else {
                this.lHX.CQ(R.string.no_data_text);
            }
        } else {
            this.lHX.CQ(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sD(boolean z) {
        this.kvE = (h) new com.baidu.tbadk.editortools.pb.i(z).ei(getActivity());
        if (this.kvE != null) {
            this.kvE.a(getPageContext());
            this.kvE.b(this.lHV);
            this.kvE.b(this.jKo);
            this.kvE.setFrom(2);
            this.kvE.a(this.fpP);
            this.kvE.a(this.fpQ);
            this.kvE.bzx().kb(true);
            this.kvE.j(getPageContext());
        }
        if (this.lHX != null) {
            this.lHX.i(this.kvE);
        }
        if (this.kvE != null && this.lHV != null) {
            this.kvE.a(this.lHV.cxn());
            this.kvE.bAF();
        }
        if (this.kvE != null) {
            this.kvE.bAJ().setDefaultHint(dno());
            this.kvE.bAJ().setHint(dno());
            this.jKi = this.kvE.bAJ().getInputView();
            this.jKi.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.jKh != null) {
                        if (!NewSubPbActivity.this.jKh.dSW()) {
                            NewSubPbActivity.this.rh(false);
                        }
                        NewSubPbActivity.this.jKh.yq(false);
                    }
                }
            });
        }
    }

    public void dpu() {
        if (!TbadkCoreApplication.isLogin()) {
            this.kvE.bAF();
        } else if (!StringUtils.isNull(this.lHV.dqf())) {
            if (this.lHX.dpB() && l.isNetOk()) {
                this.lHX.cvl();
            } else {
                this.lHX.dpE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ds(View view) {
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
                    this.lHX.dp(view);
                }
            } else if (booleanValue2) {
                this.lHX.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.lHX.dpL(), getPageContext().getPageActivity());
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
            bVar.oB(R.string.operation);
            bVar.a(strArr, new b.InterfaceC0576b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0576b
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.lIg);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.lIg);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).bpe();
        }
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.lHX.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.lIg;
        userMuteCheckCustomMessage.setTag(this.lIg);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.lHX.a(0, bVar.QP, bVar.mZE, z);
            if (bVar.QP) {
                if (bVar.ioi == 1) {
                    if (this.lHX.getListView() instanceof BdTypeListView) {
                        List<q> data = ((BdTypeListView) this.lHX.getListView()).getData();
                        if (!y.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.lHX.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.ioi == 2) {
                    this.lHV.Qf(bVar.mPostId);
                    this.lHX.a(this.lHV.dpV(), this.lHV.diz(), this.lHV.dqj() != null, false);
                    if (this.lHV.dqg()) {
                        this.lHV.vp(false);
                        this.lHX.dpz();
                        this.lHV.loadData();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void PA(String str) {
        if (this.lHV != null && this.lHV.dpV() != null && this.lHV.dpV().bjZ() != null && this.lHV.dpV().bjZ().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lHV.dlx(), str);
            bw bjZ = this.lHV.dpV().bjZ();
            if (bjZ.bli()) {
                format = format + "&channelid=33833";
            } else if (bjZ.bou()) {
                format = format + "&channelid=33842";
            } else if (bjZ.blj()) {
                format = format + "&channelid=33840";
            }
            PB(format);
            return;
        }
        this.ltO.Qb(str);
    }

    private void PB(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void n(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.lHV.dqc() && postData.getId() != null && postData.getId().equals(this.lHV.dqe())) {
                z = true;
            }
            MarkData o = this.lHV.o(postData);
            if (o != null) {
                this.lHX.dob();
                if (this.ltP != null) {
                    this.ltP.a(o);
                    if (!z) {
                        this.ltP.bix();
                    } else {
                        this.ltP.biw();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.lHV != null) {
            this.lHV.aC(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.kvE != null) {
            this.kvE.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.kvE.bzx().bxU();
        this.kvE.bAF();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.kvE.b(writeData);
                this.kvE.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.m rk = this.kvE.bzx().rk(6);
                if (rk != null && rk.fnp != null) {
                    rk.fnp.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.kvE.bAB();
                }
                this.lHX.dpS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iHo != null) {
            this.iHo.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.mIsPaused = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.bgf().bgq();
        if (this.iHo != null) {
            this.iHo.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.jWO);
        this.lHX.cFA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.mIsPaused = false;
        super.onResume();
        dla();
        if (this.iHo != null) {
            this.iHo.onResume(getPageContext());
        }
        registerListener(this.jWO);
        this.lHX.cFB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.iHo != null) {
            this.iHo.onStop(getPageContext());
        }
        this.kvE.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.lIi));
        this.lHV.cancelLoadData();
        this.lHV.destory();
        this.lHW.cancelLoadData();
        if (this.iHo != null) {
            this.iHo.onDestory(getPageContext());
        }
        this.lHX.dob();
        this.lHX.cDL();
        MessageManager.getInstance().unRegisterListener(this.luK);
        MessageManager.getInstance().unRegisterListener(this.luL);
        MessageManager.getInstance().unRegisterListener(this.luM);
        MessageManager.getInstance().unRegisterListener(this.lIg);
        this.luj = null;
        this.luk = null;
        if (this.kvy != null) {
            this.kvy.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lHX.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.iHo;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View dpG = this.lHX.dpG();
        if (dpG == null || (findViewWithTag = dpG.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean PT(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = be.getParamPair(be.getParamStr(str))) != null) {
            this.lIh = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return PT(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(lHU);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (PT(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                    lVar.mLink = str;
                    lVar.type = 3;
                    lVar.fmn = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
                }
            } else {
                be.brr().b(getPageContext(), new String[]{str});
            }
            this.lIh = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ax(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.lIh = true;
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
        if (this.lHX != null) {
            return this.lHX.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int bGt() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> bGv() {
        if (this.fJc == null) {
            this.fJc = TbRichTextView.A(getPageContext().getPageActivity(), 8);
        }
        return this.fJc;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> bGw() {
        if (this.fFM == null) {
            this.fFM = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: csS */
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
        return this.fFM;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> bGu() {
        if (this.fFL == null) {
            this.fFL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bGG */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = k.bjH().isShowImages();
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
                        if (k.bjH().isShowImages()) {
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
        return this.fFL;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> bGx() {
        if (this.fJd == null) {
            this.fJd = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dlh */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(NewSubPbActivity.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dl */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dm */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dn */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fJd;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> bGy() {
        if (this.fJe == null) {
            this.fJe = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dlj */
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
        return this.fJe;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> bGz() {
        this.fJf = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dli */
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
        return this.fJf;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a djp() {
        return this.lpU;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean djq() {
        return (this.lHV == null || this.lHV.dpV() == null || this.lHV.dpV().bjZ() == null || this.lHV.dpV().bjZ().bnX()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String djr() {
        if (this.lHV == null || this.lHV.dpV() == null || this.lHV.dpV().bjZ() == null) {
            return null;
        }
        return this.lHV.dpV().bjZ().bmE();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int djs() {
        if (this.lHV == null) {
            return 0;
        }
        return this.lHV.diz();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Pu(String str) {
        if (StringUtils.isNull(str) || this.lHV == null || this.lHV.dpV() == null || this.lHV.dpV().bjZ() == null || this.lHV.dpV().bjZ().bmA() == null) {
            return false;
        }
        return str.equals(this.lHV.dpV().bjZ().bmA().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.lHX.dpB() && l.isNetOk()) {
            this.lHV.loadData();
        } else {
            this.lHX.dpE();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.lIg);
        userMuteAddAndDelCustomMessage.setTag(this.lIg);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qd(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bqh().getString("bubble_link", "");
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
                return com.baidu.tbadk.m.e.bCg().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.lHV != null) {
            if (this.lHV.dpV() != null && this.lHV.dpV().bAz() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.lHV.dpV().bAz().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.lHV.dlx(), 0L));
            if (this.lHV.dpV() != null && this.lHV.dpV().bjZ() != null) {
                pageStayDurationItem.setNid(this.lHV.dpV().bjZ().getNid());
            }
            pageStayDurationItem.setPid(com.baidu.adp.lib.f.b.toLong(this.lHV.bzZ(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public boolean dpv() {
        if (this.lHV != null) {
            return this.lHV.dpv();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.lHX.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.luj.getPageActivity());
        if (at.isEmpty(str)) {
            aVar.Bo(this.luj.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Bo(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.lHX.showLoadingDialog();
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
        aVar.b(this.luj).bpc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DT(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.luj.getPageActivity());
        aVar.Bo(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.luj).bpc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dkW() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.Bo(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.luj).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.luj.getPageActivity(), 2, true, 4);
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
        aVar.b(this.luj).bpc();
    }

    public SubPbModel dpw() {
        return this.lHV;
    }

    public int diz() {
        if (this.lHV != null) {
            return this.lHV.diz();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.fnL && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fnL && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void rh(boolean z) {
        if (this.jKi != null && this.jKi.getText() != null) {
            int selectionEnd = this.jKi.getSelectionEnd();
            SpannableStringBuilder c = this.jKh.c(this.jKi.getText());
            if (c != null) {
                this.jKh.yq(true);
                this.jKi.setText(c);
                if (z && this.jKh.dSU() >= 0) {
                    this.jKi.requestFocus();
                    this.jKi.setSelection(this.jKh.dSU());
                } else {
                    this.jKi.setSelection(selectionEnd);
                }
                this.jKh.yp(this.jKh.dSU() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kvE != null && this.kvE.bzx() != null && this.kvE.bzx().bzB()) {
            this.kvE.bzx().bxU();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(t tVar) {
        ag.a(tVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    public String dno() {
        if (!at.isEmpty(this.lCJ)) {
            return this.lCJ;
        }
        this.lCJ = getResources().getString(com.baidu.tieba.pb.pb.main.ay.dnd());
        return this.lCJ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.lIj = z;
        vl(true);
    }

    private void vl(boolean z) {
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
        if (this.lHX != null && this.lHX.getListView() != null && this.lIk != null && this.lIk.mPosition != -1) {
            final int headerViewsCount = this.lIk.mPosition + this.lHX.getListView().getHeaderViewsCount();
            if (this.lIk.getView() != null) {
                final int height = this.lIk.getView().getHeight();
                final int height2 = ((rect.height() - this.lHX.dpR()) - this.lHX.getNavigationBarHeight()) - this.lHX.dpQ();
                final int i = height - height2;
                if (i > 0) {
                    this.lHX.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.lHX != null && NewSubPbActivity.this.lHX.getListView() != null) {
                                NewSubPbActivity.this.lHX.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.lHX.getNavigationBarHeight() - i);
                            }
                        }
                    });
                } else {
                    this.lHX.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.lHX != null && NewSubPbActivity.this.lHX.getListView() != null) {
                                NewSubPbActivity.this.lHX.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.lHX.getNavigationBarHeight() + (height2 - height));
                            }
                        }
                    });
                }
            }
        }
    }

    private void dla() {
        if (this.lHV != null && !at.isEmpty(this.lHV.dlx())) {
            com.baidu.tbadk.BdToken.c.bgf().p(com.baidu.tbadk.BdToken.b.eqd, com.baidu.adp.lib.f.b.toLong(this.lHV.dlx(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.lHV == null || at.isEmpty(this.lHV.dlx())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.lHV.dlx(), 0L);
    }
}
