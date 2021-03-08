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
    private static String mim = "tbgametype";
    private View.OnClickListener bdi;
    private at eKr;
    private com.baidu.adp.lib.d.b<ImageView> fVL;
    private com.baidu.adp.lib.d.b<GifView> fVM;
    private com.baidu.adp.lib.d.b<TextView> fZb;
    private com.baidu.adp.lib.d.b<View> fZc;
    private com.baidu.adp.lib.d.b<LinearLayout> fZd;
    private com.baidu.adp.lib.d.b<RelativeLayout> fZe;
    private e ffO;
    private com.baidu.tbadk.core.message.a fge;
    private VoiceManager jie;
    private com.baidu.tieba.frs.profession.permission.c jmA;
    public am kUB;
    private com.baidu.tbadk.editortools.pb.h kUH;
    private com.baidu.tieba.write.c krA;
    private EditText krB;
    private com.baidu.tieba.pb.pb.main.b.a lPA;
    private boolean lPF;
    private com.baidu.tieba.pb.pb.report.a lTR;
    private com.baidu.tbadk.baseEditMark.a lTS;
    private f lUm;
    private com.baidu.tbadk.core.view.c lUn;
    private com.baidu.adp.widget.ImageView.a lUq;
    private String lUr;
    private TbRichTextMemeInfo lUs;
    private PostWriteCallBackData lVY;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private String mcP;
    private com.baidu.tieba.pb.e<q> miB;
    private boolean miC;
    private PbCommenFloorItemViewHolder miD;
    private SubPbModel mio;
    private ForumManageModel mip;
    private com.baidu.tieba.pb.pb.sub.a miq;
    private aa mir;
    private AbsListView.OnScrollListener mis;
    private TbRichTextView.i mit;
    private SubPbModel.a miu;
    private com.baidu.adp.base.e miv;
    private BdUniqueId miz;
    private boolean mIsFromCDN = true;
    private int lVc = 0;
    PostData ksi = null;
    private a.InterfaceC0560a lUY = null;
    private a miw = null;
    private a mix = null;
    private boolean mIsPaused = false;
    private boolean miy = false;
    private boolean miA = false;
    private boolean fDj = false;
    private com.baidu.tbadk.editortools.pb.c fFn = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bBP() {
            NewSubPbActivity.this.miq.dsX();
        }
    };
    private int lOW = 0;
    private boolean mIsFromSchema = false;
    private BdUniqueId miE = BdUniqueId.gen();
    private boolean lTP = com.baidu.tbadk.a.d.bja();
    private boolean miF = true;
    private com.baidu.tbadk.editortools.pb.b fFo = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBO() {
            if (!NewSubPbActivity.this.krA.dWF()) {
                return (NewSubPbActivity.this.kUB == null || NewSubPbActivity.this.mio == null || NewSubPbActivity.this.mio.cBF() == null || NewSubPbActivity.this.kUB.aK(NewSubPbActivity.this.mio.cBF().replyPrivateFlag, am.fca)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.krA.dWH());
            if (NewSubPbActivity.this.kUH.bCg()) {
                NewSubPbActivity.this.kUH.a(NewSubPbActivity.this.lVY);
            }
            NewSubPbActivity.this.ss(true);
            return true;
        }
    };
    private CustomMessageListener miG = new CustomMessageListener(2921481) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && NewSubPbActivity.this.mio != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && au.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), NewSubPbActivity.this.mio.doJ())) {
                if (NewSubPbActivity.this.krA != null) {
                    NewSubPbActivity.this.krA.Vo(null);
                    NewSubPbActivity.this.krA.bg(null);
                    NewSubPbActivity.this.krA.zs(false);
                }
                if (NewSubPbActivity.this.kUH != null) {
                    NewSubPbActivity.this.kUH.bCr();
                    NewSubPbActivity.this.kUH.reset();
                }
                NewSubPbActivity.this.mio.bBL();
            }
        }
    };
    private NewWriteModel.d krH = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.kUH != null && NewSubPbActivity.this.kUH.bBk() != null) {
                NewSubPbActivity.this.kUH.bBk().hide();
                if (NewSubPbActivity.this.mio.dtx()) {
                    TiebaStatic.log(new ar("c10367").dR("post_id", NewSubPbActivity.this.mio.bBM()));
                }
            }
            if (z) {
                NewSubPbActivity.this.krA.Vo(null);
                NewSubPbActivity.this.krA.bg(null);
                NewSubPbActivity.this.krA.zs(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(NewSubPbActivity.this.getPageContext(), postWriteCallBackData);
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.krA.bg(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.krA.Vo(postWriteCallBackData.getErrorString());
                if (!y.isEmpty(NewSubPbActivity.this.krA.dWD())) {
                    NewSubPbActivity.this.lVY = postWriteCallBackData;
                    if (NewSubPbActivity.this.kUH.bCg()) {
                        NewSubPbActivity.this.kUH.a(NewSubPbActivity.this.lVY);
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
                    aVar.AB(NewSubPbActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.AB(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new ar("c13746").aq("obj_locate", 1).aq("obj_type", 2));
                    }
                });
                aVar.b(NewSubPbActivity.this.getPageContext()).bqz();
                TiebaStatic.log(new ar("c13745").aq("obj_locate", 1).aq("obj_type", 2));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.kUB != null) {
                NewSubPbActivity.this.kUB.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.miq.dsY();
        }
    };
    private CustomMessageListener lUN = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.miz) {
                NewSubPbActivity.this.miq.ckD();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.lUn.showSuccessToast(NewSubPbActivity.this.lUm.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.lUm.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.Dh(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.doi();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (au.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.lUm.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.lUn.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lUO = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.miz) {
                NewSubPbActivity.this.miq.ckD();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.lUn.showSuccessToast(NewSubPbActivity.this.lUm.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (au.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.lUm.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.lUn.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener lUP = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.miz) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.miq.ckD();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.nME;
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
                    NewSubPbActivity.this.miq.a(sparseArray, z);
                }
            }
        }
    };
    private final f.c gJi = new f.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (NewSubPbActivity.this.mio != null) {
                NewSubPbActivity.this.mio.dtv();
            }
        }
    };
    boolean lVd = false;
    private final b.InterfaceC0564b lVf = new b.InterfaceC0564b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0564b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.lUq != null && !TextUtils.isEmpty(NewSubPbActivity.this.lUr)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.lUs == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.lUr));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.lUr;
                        aVar.pkgId = NewSubPbActivity.this.lUs.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.lUs.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.eKr == null) {
                            NewSubPbActivity.this.eKr = new at(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.eKr.o(NewSubPbActivity.this.lUr, NewSubPbActivity.this.lUq.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.lUq = null;
                NewSubPbActivity.this.lUr = null;
            }
        }
    };
    private CustomMessageListener jwA = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener jjL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof n)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    n nVar = (n) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.mio.dtp() != null && NewSubPbActivity.this.mio.dtp().dmh() != null && NewSubPbActivity.this.mio.dtp().dmh().bnS() != null && currentAccount.equals(NewSubPbActivity.this.mio.dtp().dmh().bnS().getUserId()) && NewSubPbActivity.this.mio.dtp().dmh().bnS().getPendantData() != null) {
                        NewSubPbActivity.this.mio.dtp().dmh().bnS().getPendantData().Ak(nVar.getImgUrl());
                        NewSubPbActivity.this.mio.dtp().dmh().bnS().getPendantData().ek(nVar.bAJ());
                        NewSubPbActivity.this.miq.a(NewSubPbActivity.this.mio.dtp(), NewSubPbActivity.this.mio.dtp().dmh(), NewSubPbActivity.this.mio.dtp().Xj(), NewSubPbActivity.this.mio.dtp().bkb(), NewSubPbActivity.this.mio.dlE(), NewSubPbActivity.this.mio.dtD() != null);
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
        this.lUm = getPageContext();
        this.miy = true;
        this.krA = new com.baidu.tieba.write.c();
        this.krA.Li(R.color.cp_cont_h_alpha85);
        this.krA.Lh(R.color.CAM_X0101);
        bZr();
        dsN();
        initData(bundle);
        initUI();
        ((SubPbView) this.miq.getRootView()).show();
        ts(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.miq.wf(this.mIsFromSchema);
        this.lUn = new com.baidu.tbadk.core.view.c();
        this.lUn.toastTime = 1000L;
        registerListener(this.lUP);
        registerListener(this.lUN);
        registerListener(this.lUO);
        registerListener(this.miG);
        this.miz = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.miz;
        userMuteAddAndDelCustomMessage.setTag(this.miz);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.miz;
        userMuteCheckCustomMessage.setTag(this.miz);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.kUB = new am(getPageContext());
        this.kUB.a(new am.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.40
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.kUH.bCp();
                }
            }
        });
        this.lTR = new com.baidu.tieba.pb.pb.report.a(this);
        this.lTR.y(getUniqueId());
        this.lPA = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.miq = new com.baidu.tieba.pb.pb.sub.a(this, this.bdi);
        this.miq.a(this.mio);
        setContentView(this.miq.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.miq.setOnScrollListener(this.mis);
        this.miq.b(this);
        this.miq.setOnImageClickListener(this.mit);
        this.miq.setOnLongClickListener(this.mOnLongClickListener);
        this.miq.h(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.mio != null) {
                    NewSubPbActivity.this.mio.loadData();
                }
            }
        });
        this.miq.a(this.miw);
        this.miq.b(this.mix);
        this.miq.setListPullRefreshListener(this.gJi);
        if (this.mio != null && this.mio.dsP() && !this.mio.dtC()) {
            this.miq.dtd().setVisibility(8);
        } else {
            this.miq.dtd().setVisibility(0);
        }
        if (this.mio != null && !this.mio.dsP()) {
            this.miq.setIsFromPb(false);
        }
    }

    private boolean aE(Bundle bundle) {
        if (bundle != null) {
            this.fDj = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.fDj = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.fDj;
    }

    public void initData(Bundle bundle) {
        this.mio = new SubPbModel(getPageContext());
        this.mio.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                NewSubPbActivity.this.miq.v(postData);
                NewSubPbActivity.this.miq.b((BdListView.e) null);
            }
        });
        this.mip = new ForumManageModel(getPageContext());
        this.mip.setLoadDataCallBack(this.miv);
        this.jie = new VoiceManager();
        this.jie.onCreate(getPageContext());
        this.lTS = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.lTS != null) {
            this.lTS.a(this.lUY);
        }
        if (bundle != null) {
            this.mio.initWithBundle(bundle);
        } else {
            this.mio.initWithIntent(getIntent());
        }
        this.mio.a(this.miu);
        if (this.mio.dsP() && !this.mio.dtI()) {
            this.mio.loadData();
        } else if (!TextUtils.isEmpty(getIntent().getStringExtra("key_open_editor_tips"))) {
            this.mio.loadData();
        } else {
            this.mio.dtu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final View view, final com.baidu.tbadk.editortools.pb.h hVar, String str) {
        new WriteTipBubbleController(getPageContext(), new WriteTipBubbleController.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.a
            public void g(View view2, String str2) {
                view.performClick();
                hVar.bCr();
                hVar.bCx().getInputView().setText(str2);
                Editable text = hVar.bCx().getInputView().getText();
                if (!TextUtils.isEmpty(text)) {
                    hVar.bCx().getInputView().setSelection(text.length());
                }
            }
        }).a(view, getString(R.string.open_editor_tips), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
    }

    public void dsN() {
        this.miu = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, final q qVar) {
                if (NewSubPbActivity.this.miq != null) {
                    NewSubPbActivity.this.miq.dsY();
                    if (!z) {
                        NewSubPbActivity.this.bR(i, str);
                        return;
                    }
                    NewSubPbActivity.this.miq.hideNoDataView();
                    if (qVar != null) {
                        if (qVar.dmh() != null || NewSubPbActivity.this.mio != null) {
                            qVar.dmh().a(NewSubPbActivity.this.mio.dtB());
                        }
                        if (NewSubPbActivity.this.miq != null) {
                            NewSubPbActivity.this.ts(qVar.blp() != null && qVar.blp().isBjh());
                            if (NewSubPbActivity.this.kUH != null && NewSubPbActivity.this.kUH.bBk() != null) {
                                NewSubPbActivity.this.kUH.bBk().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.miq.a(qVar, NewSubPbActivity.this.mio.dlE(), NewSubPbActivity.this.mio.dtD() != null, NewSubPbActivity.this.miy);
                            if (NewSubPbActivity.this.miy) {
                                NewSubPbActivity.this.miq.getListView().setSelectionFromTop(NewSubPbActivity.this.miq.getListView().getHeaderViewsCount() + 1, -l.getDimens(NewSubPbActivity.this, R.dimen.tbds18));
                                NewSubPbActivity.this.dsO();
                                NewSubPbActivity.this.miy = false;
                            }
                        }
                        if (NewSubPbActivity.this.kUH != null) {
                            NewSubPbActivity.this.kUH.a(qVar.cBF());
                            NewSubPbActivity.this.kUH.setThreadData(qVar.blp());
                            if (NewSubPbActivity.this.getIntent() != null && NewSubPbActivity.this.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && NewSubPbActivity.this.miF) {
                                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        NewSubPbActivity.this.miF = false;
                                        NewSubPbActivity.this.c(qVar.dmh(), false);
                                    }
                                }, 200L);
                            }
                        }
                        if (NewSubPbActivity.this.miB == null) {
                            NewSubPbActivity.this.miB = new com.baidu.tieba.pb.e();
                        }
                        NewSubPbActivity.this.miB.setData(qVar);
                        NewSubPbActivity.this.miB.setType(0);
                        NewSubPbActivity.this.kUB.a(NewSubPbActivity.this.mio.dtG());
                    }
                    String stringExtra = NewSubPbActivity.this.getIntent().getStringExtra("key_open_editor_tips");
                    if (!TextUtils.isEmpty(stringExtra) && !NewSubPbActivity.this.lPF) {
                        NewSubPbActivity.this.lPF = true;
                        NewSubPbActivity.this.a(NewSubPbActivity.this.miq.cIL(), NewSubPbActivity.this.kUH, stringExtra);
                    }
                }
            }
        };
        this.lUY = new a.InterfaceC0560a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0560a
            public void e(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.lTS != null) {
                        NewSubPbActivity.this.lTS.ja(z2);
                    }
                    MarkData bke = NewSubPbActivity.this.lTS.bke();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(bke);
                        if (NewSubPbActivity.this.lTS != null) {
                            if (bke != null) {
                                NewSubPbActivity.this.mio.wh(true);
                                NewSubPbActivity.this.mio.Qg(NewSubPbActivity.this.mio.bBM());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.miq != null) {
                                NewSubPbActivity.this.miq.wg(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.mio.wh(false);
                        NewSubPbActivity.this.mio.Qg(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.miq != null) {
                            NewSubPbActivity.this.miq.wg(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.miw = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.mio.dtp() != null && NewSubPbActivity.this.mio.dtp().blp() != null && NewSubPbActivity.this.mio.dtp().blp().bnS() != null) {
                    str = String.valueOf(NewSubPbActivity.this.mio.dtp().blp().bnS().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.mio.dtp().bCn().getId(), NewSubPbActivity.this.mio.dtp().bCn().getName(), NewSubPbActivity.this.mio.dtp().blp().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.mix = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.mip.dOJ() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.mio != null && NewSubPbActivity.this.mio.dtp() != null && NewSubPbActivity.this.mio.dtp().bCn() != null && NewSubPbActivity.this.mio.dtp().blp() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.mip.TL(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.mip.a(NewSubPbActivity.this.mio.dtp().bCn().getId(), NewSubPbActivity.this.mio.dtp().bCn().getName(), NewSubPbActivity.this.mio.dtp().blp().getId(), valueOf, i2, i, z, NewSubPbActivity.this.mio.dtp().blp().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.miv = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.miq.a(NewSubPbActivity.this.mip.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.mip.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.mjE != 1002 || bVar.hmO) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.miq.a(1, dVar.mSuccess, dVar.nCc, true);
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

    public void bZr() {
        registerListener(this.jjL);
        this.bdi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
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
                if (view != null || NewSubPbActivity.this.miq != null) {
                    if (view == NewSubPbActivity.this.miq.dtj()) {
                        NewSubPbActivity.this.miq.drt();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                bf.bsY().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.miq.cIL()) {
                        if (view != NewSubPbActivity.this.miq.dtc()) {
                            if (view == NewSubPbActivity.this.miq.dtb()) {
                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                    NewSubPbActivity.this.miq.dsR();
                                    NewSubPbActivity.this.miq.dsS();
                                    if (NewSubPbActivity.this.kUH != null) {
                                        NewSubPbActivity.this.kUH.bCv();
                                    }
                                }
                            } else if (view.getId() != R.id.pb_floor_feedback) {
                                if (view == NewSubPbActivity.this.miq.dsW()) {
                                    NewSubPbActivity.this.miq.drt();
                                    if (NewSubPbActivity.this.mio.loadData()) {
                                        NewSubPbActivity.this.miq.dsU();
                                    }
                                } else if (view == NewSubPbActivity.this.miq.dtd() || view == NewSubPbActivity.this.miq.dte() || view == NewSubPbActivity.this.miq.dtg()) {
                                    if (NewSubPbActivity.this.miA) {
                                        NewSubPbActivity.this.miA = false;
                                        return;
                                    }
                                    if (NewSubPbActivity.this.mio.dtp() != null && NewSubPbActivity.this.mio.dtp().blp() != null) {
                                        z2 = az.a(NewSubPbActivity.this.mio.dtp().blp().getBaijiahaoData());
                                    }
                                    if (z2) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.mio.doJ(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.mio.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.mio.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.mio.dtp() != null && NewSubPbActivity.this.mio.dtp().blp() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.mio.dtp().blp().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.mio.doJ(), NewSubPbActivity.this.mio.bBM(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.mio.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.mio.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.miq.dth() == null || view != NewSubPbActivity.this.miq.dth().dpK()) {
                                    if (NewSubPbActivity.this.miq.dth() == null || view != NewSubPbActivity.this.miq.dth().dpN()) {
                                        if (NewSubPbActivity.this.miq.dth() == null || view != NewSubPbActivity.this.miq.dth().dpL()) {
                                            if (NewSubPbActivity.this.miq.dth() == null || view != NewSubPbActivity.this.miq.dth().dpM()) {
                                                if (NewSubPbActivity.this.miq.dth() == null || view != NewSubPbActivity.this.miq.dth().dpO()) {
                                                    if (view == NewSubPbActivity.this.miq.dta() || view == NewSubPbActivity.this.miq.dtg()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.kUH.bCs()) {
                                                                NewSubPbActivity.this.kUH.bCt();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.kUH.Di(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view != null && (view.getTag() instanceof PbCommenFloorItemViewHolder)) {
                                                        NewSubPbActivity.this.miD = (PbCommenFloorItemViewHolder) view.getTag();
                                                        if (bh.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.miA) {
                                                                NewSubPbActivity.this.miA = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.kUB == null || NewSubPbActivity.this.mio == null || NewSubPbActivity.this.mio.cBF() == null || NewSubPbActivity.this.kUB.oy(NewSubPbActivity.this.mio.cBF().replyPrivateFlag)) && (sparseArray2 = (SparseArray) view.getTag(R.id.tag_from)) != null) {
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
                                                        if (NewSubPbActivity.this.mir == null || view != NewSubPbActivity.this.mir.dpM()) {
                                                            if (NewSubPbActivity.this.mir == null || view != NewSubPbActivity.this.mir.dpK()) {
                                                                if (NewSubPbActivity.this.mir == null || view != NewSubPbActivity.this.mir.dpN()) {
                                                                    if (NewSubPbActivity.this.mir == null || view != NewSubPbActivity.this.mir.dpO()) {
                                                                        if (NewSubPbActivity.this.mir == null || view != NewSubPbActivity.this.mir.dpQ()) {
                                                                            if (NewSubPbActivity.this.mir == null || view != NewSubPbActivity.this.mir.dpR()) {
                                                                                if (NewSubPbActivity.this.mir == null || view != NewSubPbActivity.this.mir.dpS()) {
                                                                                    if (NewSubPbActivity.this.mir != null && view == NewSubPbActivity.this.mir.dpL()) {
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
                                                                                                    NewSubPbActivity.this.d(sparseArray4);
                                                                                                    return;
                                                                                                }
                                                                                                sparseArray4.put(R.id.tag_check_mute_from, 2);
                                                                                                NewSubPbActivity.this.miq.dL(view);
                                                                                                return;
                                                                                            } else if (booleanValue2) {
                                                                                                NewSubPbActivity.this.miq.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                                            String string2 = com.baidu.tbadk.core.sharedPref.b.brR().getString("tail_link", "");
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
                                                                                            if (postData2.getType() != PostData.eSf && !TextUtils.isEmpty(postData2.getBimg_url()) && k.bkV().isShowImages()) {
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
                                                                                    if (postData3.bpL() != null) {
                                                                                        NewSubPbActivity.this.d(postData3.bpL());
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.lUq != null && !TextUtils.isEmpty(NewSubPbActivity.this.lUr)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.eKr == null) {
                                                                                        NewSubPbActivity.this.eKr = new at(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.eKr.o(NewSubPbActivity.this.lUr, NewSubPbActivity.this.lUq.getImageByte());
                                                                                    NewSubPbActivity.this.lUq = null;
                                                                                    NewSubPbActivity.this.lUr = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.lUq != null && !TextUtils.isEmpty(NewSubPbActivity.this.lUr)) {
                                                                            if (NewSubPbActivity.this.lUs == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.lUr));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.lUr;
                                                                                aVar.pkgId = NewSubPbActivity.this.lUs.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.lUs.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.lUq = null;
                                                                            NewSubPbActivity.this.lUr = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.ksi != null) {
                                                                        NewSubPbActivity.this.ksi.gV(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.ksi = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                if (sparseArray5 != null && (sparseArray5.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_id) instanceof String) && (sparseArray5.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.miq.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                NewSubPbActivity.this.PA((String) tag);
                                                                return;
                                                            } else if (tag instanceof SparseArray) {
                                                                SparseArray<Object> sparseArray6 = (SparseArray) tag;
                                                                if ((sparseArray6.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                                                    sparseArray6.put(R.id.tag_from, 0);
                                                                    sparseArray6.put(R.id.tag_check_mute_from, 2);
                                                                    NewSubPbActivity.this.d(sparseArray6);
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
                                                            if (NewSubPbActivity.this.mio != null) {
                                                                TiebaStatic.log(new ar("c13700").dR("tid", NewSubPbActivity.this.mio.doK()).dR("fid", NewSubPbActivity.this.mio.getFromForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData.getId()).aq("obj_source", 1).aq("obj_type", 3));
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
                                            TiebaStatic.log(new ar("c11739").aq("obj_locate", 4));
                                            if (!j.isNetWorkAvailable()) {
                                                NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.miq.drt();
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
                                                    NewSubPbActivity.this.d(sparseArray9);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                        } else if (j.isNetWorkAvailable()) {
                                            NewSubPbActivity.this.miq.drt();
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
                                    NewSubPbActivity.this.miq.drt();
                                    SparseArray sparseArray10 = (SparseArray) view.getTag();
                                    if (sparseArray10 != null) {
                                        NewSubPbActivity.this.miq.a(((Integer) sparseArray10.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray10.get(R.id.tag_del_post_id), ((Integer) sparseArray10.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new ar("c11739").aq("obj_locate", 2));
                                    NewSubPbActivity.this.miq.drt();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.mio.dtp() != null) {
                                        NewSubPbActivity.this.n(NewSubPbActivity.this.mio.dtp().dmh());
                                    }
                                }
                            } else {
                                try {
                                    sparseArray3 = (SparseArray) view.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                }
                                if (sparseArray3 != null && ((PostData) sparseArray3.get(R.id.tag_clip_board)) != null) {
                                    if (NewSubPbActivity.this.mir == null) {
                                        NewSubPbActivity.this.mir = new aa(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.bdi);
                                        NewSubPbActivity.this.miq.dP(NewSubPbActivity.this.mir.getView());
                                        NewSubPbActivity.this.mir.vp(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.mir.QH();
                                    if (NewSubPbActivity.this.va(sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin()) {
                                        z2 = true;
                                    }
                                    NewSubPbActivity.this.mir.a(sparseArray3, NewSubPbActivity.this.dlE(), z2);
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.miq.dsR();
                            NewSubPbActivity.this.miq.dsS();
                            if (NewSubPbActivity.this.kUH != null) {
                                NewSubPbActivity.this.kUH.bCu();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.dnH();
                        if (NewSubPbActivity.this.mio != null && NewSubPbActivity.this.mio.dtp() != null && NewSubPbActivity.this.mio.dtp().blp() != null && NewSubPbActivity.this.mio.dtp().blp().bnS() != null) {
                            TiebaStatic.log(new ar("c13402").dR("tid", NewSubPbActivity.this.mio.doJ()).v("fid", NewSubPbActivity.this.mio.dtp().blp().getFid()).aq("obj_locate", 5).dR("uid", NewSubPbActivity.this.mio.dtp().blp().bnS().getUserId()));
                        }
                    }
                }
            }
        };
        this.mis = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.miq.drt();
                    if (NewSubPbActivity.this.lOW != 2 && NewSubPbActivity.this.lOW != 1) {
                        NewSubPbActivity.this.miq.dtm();
                    }
                }
                NewSubPbActivity.this.kUH.bCt();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.miq.dti();
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
                if (NewSubPbActivity.this.miq != null && NewSubPbActivity.this.miq.dsZ()) {
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
                        NewSubPbActivity.this.lUq = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.lUr = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.lUq == null || TextUtils.isEmpty(NewSubPbActivity.this.lUr)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lUs = null;
                        } else {
                            NewSubPbActivity.this.lUs = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.lUq = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.lUr = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lUs = null;
                        } else {
                            NewSubPbActivity.this.lUs = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.lUq = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.lUr = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lUs = null;
                        } else {
                            NewSubPbActivity.this.lUs = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        NewSubPbActivity.this.miq.a(NewSubPbActivity.this.lVf, NewSubPbActivity.this.lUq.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.ksi = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.ksi == null || NewSubPbActivity.this.lTS == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.lTS != null) {
                            NewSubPbActivity.this.lTS.ja(NewSubPbActivity.this.mio.dtw());
                        }
                        boolean z2 = NewSubPbActivity.this.lTS.bkb() && NewSubPbActivity.this.ksi.getId() != null && NewSubPbActivity.this.ksi.getId().equals(NewSubPbActivity.this.mio.dty());
                        if (NewSubPbActivity.this.mir == null) {
                            NewSubPbActivity.this.mir = new aa(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.bdi);
                            NewSubPbActivity.this.miq.dP(NewSubPbActivity.this.mir.getView());
                            NewSubPbActivity.this.mir.vp(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.mir.QH();
                        boolean z3 = NewSubPbActivity.this.va(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z4 = (NewSubPbActivity.this.mio.dtp() == null || NewSubPbActivity.this.mio.dtp().blp() == null || !NewSubPbActivity.this.mio.dtp().blp().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z2) {
                            NewSubPbActivity.this.mir.dpK().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.mir.dpK().setText(R.string.mark);
                        }
                        if (booleanValue || z4) {
                            NewSubPbActivity.this.mir.dpK().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.mir.dpK().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.dG(view)) {
                            if (NewSubPbActivity.this.lUq != null && !NewSubPbActivity.this.lUq.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        aa aaVar = NewSubPbActivity.this.mir;
                        int dlE = NewSubPbActivity.this.dlE();
                        if (NewSubPbActivity.this.lTP && NewSubPbActivity.this.ksi.nAa) {
                            z = true;
                        }
                        aaVar.a(sparseArray2, dlE, z3, z);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.mit = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
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
                        q dtp = NewSubPbActivity.this.mio.dtp();
                        TbRichText bH = NewSubPbActivity.this.bH(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bH != null && bH.bHD() != null) {
                            tbRichTextData = bH.bHD().get(NewSubPbActivity.this.lVc);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!tbRichTextData.bHJ().bHU()) {
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
                                if (dtp == null) {
                                    str4 = null;
                                } else {
                                    if (dtp.bCn() != null) {
                                        str5 = dtp.bCn().getName();
                                        str6 = dtp.bCn().getId();
                                    }
                                    if (dtp.blp() != null) {
                                        str7 = dtp.blp().getId();
                                    }
                                    z5 = true;
                                    str4 = str7;
                                }
                                if (NewSubPbActivity.this.mio.dtD() != null) {
                                    concurrentHashMap = NewSubPbActivity.this.mio.dtD();
                                    z4 = NewSubPbActivity.this.mio.dtF();
                                    arrayList = NewSubPbActivity.this.mio.dtE();
                                } else {
                                    z4 = z5;
                                }
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(y.getItem(arrayList, 0));
                                ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                                aVar.s(arrayList2).zQ(str5).zR(str6).zS(str4).jg(z4).zT(arrayList.get(0)).jh(true).d(concurrentHashMap).ji(true).jj(false).jk(false).s(NewSubPbActivity.this.blp()).zU(String.valueOf(bH.getPostId())).zV(NewSubPbActivity.this.mio.getFromForumId());
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar.eO(NewSubPbActivity.this.getPageContext().getPageActivity())));
                                return;
                            }
                            NewSubPbActivity.this.lVd = false;
                            TbRichText dNQ = dtp.dmh().dNQ();
                            int size = arrayList.size();
                            int a2 = NewSubPbActivity.this.a(dNQ, bH, i, i, arrayList, concurrentHashMap);
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
                            if (dtp == null) {
                                str3 = null;
                            } else {
                                if (dtp.bCn() != null) {
                                    str8 = dtp.bCn().getName();
                                    str9 = dtp.bCn().getId();
                                }
                                if (dtp.blp() != null) {
                                    str10 = dtp.blp().getId();
                                }
                                z6 = true;
                                str3 = str10;
                            }
                            if (NewSubPbActivity.this.mio.dtD() != null) {
                                concurrentHashMap = NewSubPbActivity.this.mio.dtD();
                                z3 = NewSubPbActivity.this.mio.dtF();
                                arrayList = NewSubPbActivity.this.mio.dtE();
                                a2 = NewSubPbActivity.this.mio.getOffset() + a2;
                            } else {
                                z3 = z6;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(y.getItem(arrayList, a2));
                            ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                            aVar2.s(arrayList3).zQ(str8).zR(str9).zS(str3).jg(z3).zT(str2).jh(true).d(concurrentHashMap).ji(true).jj(false).jk(false).s(NewSubPbActivity.this.blp()).zU(String.valueOf(bH.getPostId())).zV(NewSubPbActivity.this.mio.getFromForumId());
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar2.eO(NewSubPbActivity.this.getPageContext().getPageActivity())));
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
    public cb blp() {
        if (this.mio == null || this.mio.dtp() == null) {
            return null;
        }
        return this.mio.dtp().blp();
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
        if (!dnG()) {
            if (postData != null) {
                if (postData.bnS() != null) {
                    MetaData bnS = postData.bnS();
                    this.kUH.setReplyId(bnS.getUserId());
                    boolean z2 = postData.nAa;
                    String str = "";
                    if (postData.dNQ() != null) {
                        str = postData.dNQ().toString();
                    }
                    this.kUH.Dk(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bnS().getName_show(), str));
                    if (z2) {
                        if (!z) {
                            this.kUH.Dj("");
                        }
                    } else if (!z) {
                        this.kUH.Dj(bnS.getName_show());
                    }
                }
                this.miq.dsS();
            }
            if (this.miC) {
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
        com.baidu.tbadk.pageExtra.c fp;
        int i = 1;
        if (agreeData != null) {
            if (this.fge == null) {
                this.fge = new com.baidu.tbadk.core.message.a();
            }
            if (this.ffO == null) {
                this.ffO = new e();
                this.ffO.uniqueId = this.miE;
            }
            com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
            eVar.eNB = 12;
            eVar.eNH = 9;
            eVar.eNG = 3;
            if (dsQ() != null) {
                eVar.eNF = dsQ().dtH();
            }
            if (eVar != null) {
                eVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (eVar != null) {
                        eVar.eNI = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (eVar != null) {
                        eVar.eNI = 1;
                        i = 0;
                    }
                }
                fp = com.baidu.tbadk.pageExtra.d.fp(getActivity());
                if (fp != null) {
                    agreeData.objSource = fp.getCurrentPageKey();
                }
                this.fge.a(agreeData, i, getUniqueId(), false);
                this.fge.a(agreeData, this.ffO);
                if (dsQ() == null && dsQ().dtp() != null) {
                    this.fge.a(this, eVar, agreeData, dsQ().dtp().blp());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (eVar != null) {
                eVar.eNI = 1;
            }
            i = 0;
            fp = com.baidu.tbadk.pageExtra.d.fp(getActivity());
            if (fp != null) {
            }
            this.fge.a(agreeData, i, getUniqueId(), false);
            this.fge.a(agreeData, this.ffO);
            if (dsQ() == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        TbRichTextImageInfo bHJ;
        if (tbRichText == tbRichText2) {
            this.lVd = true;
        }
        if (tbRichText != null && tbRichText.bHD() != null) {
            int size = tbRichText.bHD().size();
            int i3 = -1;
            int i4 = 0;
            int i5 = i;
            while (i4 < size) {
                if (tbRichText.bHD().get(i4) != null && tbRichText.bHD().get(i4).getType() == 8) {
                    i3++;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.bHD().get(i4).bHJ().getWidth() * equipmentDensity;
                    int height = tbRichText.bHD().get(i4).bHJ().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.bHD().get(i4).bHJ().bHU()) {
                        if (tbRichText == tbRichText2 && i3 <= i2) {
                            i5--;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.bHD().get(i4);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (bHJ = tbRichTextData.bHJ()) != null) {
                            String bHW = bHJ.bHW();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = bHW;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.lVd) {
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
        if (this.mir != null) {
            this.mir.vp(z);
        }
        if (this.miq != null) {
            this.miq.vp(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bHJ = tbRichTextData.bHJ();
        if (bHJ != null) {
            if (!StringUtils.isNull(bHJ.bHT())) {
                return bHJ.bHT();
            }
            if (bHJ.getHeight() * bHJ.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bHJ.getHeight() * bHJ.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bHJ.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bHJ.getHeight())));
            } else {
                float width = bHJ.getWidth() / bHJ.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(au.getUrlEncode(bHJ.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bH(String str, int i) {
        if (this.mio == null || this.mio.dtp() == null || str == null || i < 0) {
            return null;
        }
        q dtp = this.mio.dtp();
        TbRichText a2 = a(dtp.dmh(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(dtp.dmh(), str, i);
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
        TbRichText dNQ = postData.dNQ();
        if (dNQ != null) {
            ArrayList<TbRichTextData> bHD = dNQ.bHD();
            int size = bHD.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (bHD.get(i3) != null && bHD.get(i3).getType() == 8) {
                    i2++;
                    if (bHD.get(i3).bHJ().bHW().equals(str)) {
                        int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = bHD.get(i3).bHJ().getWidth() * equipmentDensity;
                        int height = bHD.get(i3).bHJ().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.lVc = i3;
                        return dNQ;
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

    private boolean dnG() {
        if (this.mio == null) {
            return false;
        }
        return AntiHelper.a(getPageContext(), this.mio.cBF());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnH() {
        Intent intent = getIntent();
        boolean booleanExtra = intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false;
        if (!dnG()) {
            if (booleanExtra) {
                if (this.kUB == null || this.mio == null || this.mio.cBF() == null || this.kUB.oy(this.mio.cBF().replyPrivateFlag)) {
                    if (this.kUH.bCg()) {
                        this.kUH.a((PostWriteCallBackData) null);
                        return;
                    }
                    this.miq.dsR();
                    this.miq.dsS();
                    if (this.kUH != null) {
                        this.kUH.bCw();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.jmA == null) {
                this.jmA = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jmA.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
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
                            if (NewSubPbActivity.this.kUB == null || NewSubPbActivity.this.mio == null || NewSubPbActivity.this.mio.cBF() == null || NewSubPbActivity.this.kUB.oy(NewSubPbActivity.this.mio.cBF().replyPrivateFlag)) {
                                if (NewSubPbActivity.this.mio != null && NewSubPbActivity.this.mio.dtp() != null && NewSubPbActivity.this.mio.dtp().dmh() != null) {
                                    PostData dmh = NewSubPbActivity.this.mio.dtp().dmh();
                                    if (dmh.dNQ() != null && dmh.bnS() != null) {
                                        str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), dmh.bnS().getName_show(), dmh.dNQ().toString());
                                        NewSubPbActivity.this.kUH.bBk().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                                        if (!NewSubPbActivity.this.kUH.bCg()) {
                                            NewSubPbActivity.this.kUH.a((PostWriteCallBackData) null);
                                            return;
                                        }
                                        NewSubPbActivity.this.miq.dsR();
                                        NewSubPbActivity.this.miq.dsS();
                                        if (NewSubPbActivity.this.kUH != null) {
                                            NewSubPbActivity.this.kUH.bCw();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                str = null;
                                NewSubPbActivity.this.kUH.bBk().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                                if (!NewSubPbActivity.this.kUH.bCg()) {
                                }
                            }
                        }
                    }
                });
            }
            if (this.mio != null && this.mio.dtp() != null && this.mio.dtp().bCn() != null) {
                this.jmA.G(this.mio.dtp().bCn().getId(), com.baidu.adp.lib.f.b.toLong(this.mio.doJ(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean va(boolean z) {
        if (this.mio == null) {
            return false;
        }
        return ((dlE() != 0) || this.mio.dtp() == null || this.mio.dtp().blp() == null || this.mio.dtp().blp().bnS() == null || this.mio.dtp().blp().bmB() || TextUtils.equals(this.mio.dtp().blp().bnS().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bR(int i, String str) {
        if (this.mio.dtq()) {
            showToast(str);
        } else if (l.isNetOk()) {
            if (i == 4) {
                this.miq.aY(str + "(4)", true);
            } else if (!TextUtils.isEmpty(str)) {
                this.miq.aY(str + "(" + i + ")", true);
            } else {
                this.miq.Db(R.string.no_data_text);
            }
        } else {
            this.miq.Db(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ts(boolean z) {
        this.kUH = (com.baidu.tbadk.editortools.pb.h) new i(z).ff(getActivity());
        if (this.kUH != null) {
            this.kUH.a(getPageContext());
            this.kUH.b(this.mio);
            this.kUH.b(this.krH);
            this.kUH.setFrom(2);
            this.kUH.a(this.fFn);
            this.kUH.a(this.fFo);
            this.kUH.bBk().kN(true);
            this.kUH.j(getPageContext());
        }
        if (this.miq != null) {
            this.miq.i(this.kUH);
        }
        if (this.kUH != null && this.mio != null) {
            this.kUH.a(this.mio.cBF());
            this.kUH.bCt();
        }
        if (this.kUH != null) {
            this.kUH.bCx().setDefaultHint(dqD());
            this.kUH.bCx().setHint(dqD());
            this.krB = this.kUH.bCx().getInputView();
            this.krB.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.krA != null) {
                        if (!NewSubPbActivity.this.krA.dWG()) {
                            NewSubPbActivity.this.ss(false);
                        }
                        NewSubPbActivity.this.krA.zt(false);
                    }
                }
            });
        }
    }

    public void dsO() {
        if (!TbadkCoreApplication.isLogin()) {
            this.kUH.bCt();
        } else if (!StringUtils.isNull(this.mio.dtz())) {
            if (this.miq.dsV() && l.isNetOk()) {
                this.miq.czE();
            } else {
                this.miq.dsY();
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
                    d(sparseArray);
                } else {
                    this.miq.dL(view);
                }
            } else if (booleanValue2) {
                this.miq.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.miq.dtf(), getPageContext().getPageActivity());
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
            bVar.nD(R.string.operation);
            bVar.a(strArr, new b.InterfaceC0564b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.miz);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.miz);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).bqB();
        }
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.miq.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.miz;
        userMuteCheckCustomMessage.setTag(this.miz);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.miq.a(0, bVar.mSuccess, bVar.nCc, z);
            if (bVar.mSuccess) {
                if (bVar.iPc == 1) {
                    if (this.miq.getListView() instanceof BdTypeListView) {
                        List<com.baidu.adp.widget.ListView.n> data = ((BdTypeListView) this.miq.getListView()).getData();
                        if (!y.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.miq.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.iPc == 2) {
                    this.mio.Qf(bVar.mPostId);
                    this.miq.a(this.mio.dtp(), this.mio.dlE(), this.mio.dtD() != null, false);
                    if (this.mio.dtA()) {
                        this.mio.wi(false);
                        this.miq.dsT();
                        this.mio.loadData();
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
        if (this.mio != null && this.mio.dtp() != null && this.mio.dtp().blp() != null && this.mio.dtp().blp().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.mio.doJ(), str);
            cb blp = this.mio.dtp().blp();
            if (blp.bmz()) {
                format = format + "&channelid=33833";
            } else if (blp.bpO()) {
                format = format + "&channelid=33842";
            } else if (blp.bmA()) {
                format = format + "&channelid=33840";
            }
            PB(format);
            return;
        }
        this.lTR.Qb(str);
    }

    private void PB(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void n(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.mio.dtw() && postData.getId() != null && postData.getId().equals(this.mio.dty())) {
                z = true;
            }
            MarkData o = this.mio.o(postData);
            if (o != null) {
                this.miq.drt();
                if (this.lTS != null) {
                    this.lTS.a(o);
                    if (!z) {
                        this.lTS.bkd();
                    } else {
                        this.lTS.bkc();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.mio != null) {
            this.mio.aD(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.kUH != null) {
            this.kUH.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.kUH.bBk().bzG();
        this.kUH.bCt();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.kUH.c(writeData);
                this.kUH.setVoiceModel(pbEditorData.getVoiceModel());
                m qV = this.kUH.bBk().qV(6);
                if (qV != null && qV.fCN != null) {
                    qV.fCN.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.kUH.bCp();
                }
                this.miq.dtm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.jie != null) {
            this.jie.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.mIsPaused = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.bhp().bhA();
        if (this.jie != null) {
            this.jie.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.jwA);
        this.miq.cLe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.mIsPaused = false;
        super.onResume();
        dom();
        if (this.jie != null) {
            this.jie.onResume(getPageContext());
        }
        registerListener(this.jwA);
        this.miq.cLf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.jie != null) {
            this.jie.onStop(getPageContext());
        }
        this.kUH.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.miB));
        this.mio.cancelLoadData();
        this.mio.destory();
        this.mip.cancelLoadData();
        if (this.jie != null) {
            this.jie.onDestory(getPageContext());
        }
        this.miq.drt();
        this.miq.cJm();
        MessageManager.getInstance().unRegisterListener(this.lUN);
        MessageManager.getInstance().unRegisterListener(this.lUO);
        MessageManager.getInstance().unRegisterListener(this.lUP);
        MessageManager.getInstance().unRegisterListener(this.miz);
        this.lUm = null;
        this.lUn = null;
        if (this.kUB != null) {
            this.kUB.onDestroy();
        }
        com.baidu.tbadk.pageExtra.d.Du(getCurrentPageKey());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.miq.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.jie;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View dta = this.miq.dta();
        if (dta == null || (findViewWithTag = dta.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean PT(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = bf.getParamPair(bf.getParamStr(str))) != null) {
            this.miA = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return PT(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(mim);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (PT(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.m mVar = new com.baidu.tbadk.data.m();
                    mVar.mLink = str;
                    mVar.type = 3;
                    mVar.fBL = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, mVar));
                }
            } else {
                bf.bsY().b(getPageContext(), new String[]{str});
            }
            this.miA = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.miA = true;
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
        if (this.miq != null) {
            return this.miq.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bIk() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bIm() {
        if (this.fZb == null) {
            this.fZb = TbRichTextView.K(getPageContext().getPageActivity(), 8);
        }
        return this.fZb;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bIn() {
        if (this.fVM == null) {
            this.fVM = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cxm */
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
        return this.fVM;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bIl() {
        if (this.fVL == null) {
            this.fVL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bIx */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = k.bkV().isShowImages();
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
                /* renamed from: b */
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
                /* renamed from: c */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (k.bkV().isShowImages()) {
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
                /* renamed from: d */
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
        return this.fVL;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bIo() {
        if (this.fZc == null) {
            this.fZc = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dot */
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
        return this.fZc;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bIp() {
        if (this.fZd == null) {
            this.fZd = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dov */
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
        return this.fZd;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bIq() {
        this.fZe = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dou */
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
        return this.fZe;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a dmx() {
        return this.lPA;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean dmy() {
        return (this.mio == null || this.mio.dtp() == null || this.mio.dtp().blp() == null || this.mio.dtp().blp().bpr()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String dmz() {
        if (this.mio == null || this.mio.dtp() == null || this.mio.dtp().blp() == null) {
            return null;
        }
        return this.mio.dtp().blp().bnW();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int dmA() {
        if (this.mio == null) {
            return 0;
        }
        return this.mio.dlE();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean Pu(String str) {
        if (StringUtils.isNull(str) || this.mio == null || this.mio.dtp() == null || this.mio.dtp().blp() == null || this.mio.dtp().blp().bnS() == null) {
            return false;
        }
        return str.equals(this.mio.dtp().blp().bnS().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.miq.dsV() && l.isNetOk()) {
            this.mio.loadData();
        } else {
            this.miq.dsY();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.miz);
        userMuteAddAndDelCustomMessage.setTag(this.miz);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qd(String str) {
        if (!StringUtils.isNull(str) && bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.brR().getString("bubble_link", "");
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
                return com.baidu.tbadk.m.e.bDW().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.mio != null) {
            if (this.mio.dtp() != null && this.mio.dtp().bCn() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.mio.dtp().bCn().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.mio.doJ(), 0L));
            if (this.mio.dtp() != null && this.mio.dtp().blp() != null) {
                pageStayDurationItem.setNid(this.mio.dtp().blp().bmq());
            }
            pageStayDurationItem.setPid(com.baidu.adp.lib.f.b.toLong(this.mio.bBM(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public boolean dsP() {
        if (this.mio != null) {
            return this.mio.dsP();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.miq.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lUm.getPageActivity());
        if (au.isEmpty(str)) {
            aVar.AB(this.lUm.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.AB(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.miq.showLoadingDialog();
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
        aVar.b(this.lUm).bqz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dh(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lUm.getPageActivity());
        aVar.AB(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lUm).bqz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doi() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.AB(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.lUm).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.lUm.getPageActivity(), 2, true, 4);
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
        aVar.b(this.lUm).bqz();
    }

    public SubPbModel dsQ() {
        return this.mio;
    }

    public int dlE() {
        if (this.mio != null) {
            return this.mio.dlE();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.fDj && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fDj && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void ss(boolean z) {
        if (this.krB != null && this.krB.getText() != null) {
            int selectionEnd = this.krB.getSelectionEnd();
            SpannableStringBuilder d = this.krA.d(this.krB.getText());
            if (d != null) {
                this.krA.zt(true);
                this.krB.setText(d);
                if (z && this.krA.dWE() >= 0) {
                    this.krB.requestFocus();
                    this.krB.setSelection(this.krA.dWE());
                } else {
                    this.krB.setSelection(selectionEnd);
                }
                this.krA.zs(this.krA.dWE() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kUH != null && this.kUH.bBk() != null && this.kUH.bBk().bBo()) {
            this.kUH.bBk().bzG();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.i
    public void onPreLoad(com.baidu.adp.widget.ListView.q qVar) {
        ag.a(qVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.g.c.a(qVar, getUniqueId(), this);
    }

    public String dqD() {
        if (!au.isEmpty(this.mcP)) {
            return this.mcP;
        }
        this.mcP = getResources().getString(ao.dqt());
        return this.mcP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.miC = z;
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
        if (this.miq != null && this.miq.getListView() != null && this.miD != null && this.miD.mPosition != -1) {
            final int headerViewsCount = this.miD.mPosition + this.miq.getListView().getHeaderViewsCount();
            if (this.miD.getView() != null) {
                final int height = this.miD.getView().getHeight();
                final int height2 = ((rect.height() - this.miq.dtl()) - this.miq.getNavigationBarHeight()) - this.miq.dtk();
                final int i = height - height2;
                if (i > 0) {
                    this.miq.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.miq != null && NewSubPbActivity.this.miq.getListView() != null) {
                                NewSubPbActivity.this.miq.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.miq.getNavigationBarHeight() - i);
                            }
                        }
                    });
                } else {
                    this.miq.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.miq != null && NewSubPbActivity.this.miq.getListView() != null) {
                                NewSubPbActivity.this.miq.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.miq.getNavigationBarHeight() + (height2 - height));
                            }
                        }
                    });
                }
            }
        }
    }

    private void dom() {
        if (this.mio != null && !au.isEmpty(this.mio.doJ())) {
            com.baidu.tbadk.BdToken.c.bhp().q(com.baidu.tbadk.BdToken.b.eDG, com.baidu.adp.lib.f.b.toLong(this.mio.doJ(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.mio == null || au.isEmpty(this.mio.doJ())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.mio.doJ(), 0L);
    }
}
