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
import com.baidu.tbadk.core.data.by;
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
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
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
/* loaded from: classes22.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, h, com.baidu.tieba.pb.pb.a<NewSubPbActivity> {
    private static String lWg = "tbgametype";
    private View.OnClickListener bbH;
    private bd eBS;
    private e eXh;
    private com.baidu.tbadk.core.message.a eXx;
    private com.baidu.adp.lib.d.b<ImageView> fMZ;
    private com.baidu.adp.lib.d.b<GifView> fNa;
    private com.baidu.adp.lib.d.b<TextView> fQq;
    private com.baidu.adp.lib.d.b<View> fQr;
    private com.baidu.adp.lib.d.b<LinearLayout> fQs;
    private com.baidu.adp.lib.d.b<RelativeLayout> fQt;
    private VoiceManager iSU;
    private com.baidu.tieba.frs.profession.permission.c iXo;
    private com.baidu.tieba.write.c jYv;
    private EditText jYw;
    public am kJC;
    private com.baidu.tbadk.editortools.pb.h kJI;
    private com.baidu.tieba.pb.pb.main.b.a lDS;
    private com.baidu.tieba.pb.pb.report.a lHR;
    private com.baidu.tbadk.baseEditMark.a lHS;
    private com.baidu.adp.base.e lIm;
    private com.baidu.tbadk.core.view.c lIn;
    private com.baidu.adp.widget.ImageView.a lIq;
    private String lIr;
    private TbRichTextMemeInfo lIs;
    private PostWriteCallBackData lJZ;
    private String lQP;
    private SubPbModel lWh;
    private ForumManageModel lWi;
    private com.baidu.tieba.pb.pb.sub.a lWj;
    private ah lWk;
    private AbsListView.OnScrollListener lWl;
    private TbRichTextView.i lWm;
    private SubPbModel.a lWn;
    private com.baidu.adp.base.d lWo;
    private BdUniqueId lWs;
    private com.baidu.tieba.pb.e<p> lWu;
    private boolean lWv;
    private n lWw;
    private Object mExtra;
    private View.OnLongClickListener mOnLongClickListener;
    private PermissionJudgePolicy mPermissionJudgement;
    private boolean mIsFromCDN = true;
    private int lJc = 0;
    PostData jZd = null;
    private a.InterfaceC0583a lIY = null;
    private a lWp = null;
    private a lWq = null;
    private boolean mIsPaused = false;
    private boolean lWr = false;
    private boolean lWt = false;
    private boolean fux = false;
    private com.baidu.tbadk.editortools.pb.c fwB = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bCS() {
            NewSubPbActivity.this.lWj.duu();
        }
    };
    private int lDo = 0;
    private boolean mIsFromSchema = false;
    private BdUniqueId lWx = BdUniqueId.gen();
    private boolean lHP = com.baidu.tbadk.a.d.bkr();
    private boolean lWy = true;
    private com.baidu.tbadk.editortools.pb.b fwC = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bCR() {
            if (!NewSubPbActivity.this.jYv.dYo()) {
                return (NewSubPbActivity.this.kJC == null || NewSubPbActivity.this.lWh == null || NewSubPbActivity.this.lWh.cBe() == null || NewSubPbActivity.this.kJC.aQ(NewSubPbActivity.this.lWh.cBe().replyPrivateFlag, am.eTy)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.jYv.dYq());
            if (NewSubPbActivity.this.kJI.bDj()) {
                NewSubPbActivity.this.kJI.a(NewSubPbActivity.this.lJZ);
            }
            NewSubPbActivity.this.rM(true);
            return true;
        }
    };
    private CustomMessageListener lWz = new CustomMessageListener(2921481) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && NewSubPbActivity.this.lWh != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && au.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), NewSubPbActivity.this.lWh.dqj())) {
                if (NewSubPbActivity.this.jYv != null) {
                    NewSubPbActivity.this.jYv.VA(null);
                    NewSubPbActivity.this.jYv.bn(null);
                    NewSubPbActivity.this.jYv.zb(false);
                }
                if (NewSubPbActivity.this.kJI != null) {
                    NewSubPbActivity.this.kJI.bDt();
                    NewSubPbActivity.this.kJI.reset();
                }
                NewSubPbActivity.this.lWh.bCO();
            }
        }
    };
    private NewWriteModel.d jYC = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.ah ahVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.kJI != null && NewSubPbActivity.this.kJI.bCn() != null) {
                NewSubPbActivity.this.kJI.bCn().hide();
                if (NewSubPbActivity.this.lWh.duU()) {
                    TiebaStatic.log(new ar("c10367").dY("post_id", NewSubPbActivity.this.lWh.bCP()));
                }
            }
            if (z) {
                NewSubPbActivity.this.jYv.VA(null);
                NewSubPbActivity.this.jYv.bn(null);
                NewSubPbActivity.this.jYv.zb(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(NewSubPbActivity.this.getPageContext(), postWriteCallBackData);
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.jYv.bn(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.jYv.VA(postWriteCallBackData.getErrorString());
                if (!y.isEmpty(NewSubPbActivity.this.jYv.dYm())) {
                    NewSubPbActivity.this.lJZ = postWriteCallBackData;
                    if (NewSubPbActivity.this.kJI.bDj()) {
                        NewSubPbActivity.this.kJI.a(NewSubPbActivity.this.lJZ);
                    }
                    NewSubPbActivity.this.rM(true);
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
                    aVar.Bq(NewSubPbActivity.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.Bq(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new ar("c13746").al("obj_locate", 1).al("obj_type", 2));
                    }
                });
                aVar.b(NewSubPbActivity.this.getPageContext()).brv();
                TiebaStatic.log(new ar("c13745").al("obj_locate", 1).al("obj_type", 2));
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.kJC != null) {
                NewSubPbActivity.this.kJC.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.lWj.duv();
        }
    };
    private CustomMessageListener lIN = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.lWs) {
                NewSubPbActivity.this.lWj.ckt();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.lIn.showSuccessToast(NewSubPbActivity.this.lIm.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.lIm.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.Ea(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.dpI();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (au.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.lIm.getResources().getString(R.string.mute_fail);
                    }
                    NewSubPbActivity.this.lIn.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lIO = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.lWs) {
                NewSubPbActivity.this.lWj.ckt();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.lIn.showSuccessToast(NewSubPbActivity.this.lIm.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (au.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.lIm.getResources().getString(R.string.un_mute_fail);
                }
                NewSubPbActivity.this.lIn.showFailToast(muteMessage);
            }
        }
    };
    private CustomMessageListener lIP = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.lWs) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.lWj.ckt();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.nAK;
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
                    NewSubPbActivity.this.lWj.a(sparseArray, z);
                }
            }
        }
    };
    private final f.c gyc = new f.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (NewSubPbActivity.this.lWh != null) {
                NewSubPbActivity.this.lWh.duS();
            }
        }
    };
    boolean lJd = false;
    private final b.InterfaceC0586b lJf = new b.InterfaceC0586b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0586b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.lIq != null && !TextUtils.isEmpty(NewSubPbActivity.this.lIr)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.lIs == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.lIr));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.lIr;
                        aVar.pkgId = NewSubPbActivity.this.lIs.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.lIs.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.mPermissionJudgement == null) {
                        NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                    NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.eBS == null) {
                            NewSubPbActivity.this.eBS = new bd(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.eBS.j(NewSubPbActivity.this.lIr, NewSubPbActivity.this.lIq.getImageByte());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.lIq = null;
                NewSubPbActivity.this.lIr = null;
            }
        }
    };
    private CustomMessageListener jhb = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener iUA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.n)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    com.baidu.tbadk.data.n nVar = (com.baidu.tbadk.data.n) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.lWh.duM() != null && NewSubPbActivity.this.lWh.duM().dnM() != null && NewSubPbActivity.this.lWh.duM().dnM().boP() != null && currentAccount.equals(NewSubPbActivity.this.lWh.duM().dnM().boP().getUserId()) && NewSubPbActivity.this.lWh.duM().dnM().boP().getPendantData() != null) {
                        NewSubPbActivity.this.lWh.duM().dnM().boP().getPendantData().AZ(nVar.bmL());
                        NewSubPbActivity.this.lWh.duM().dnM().boP().getPendantData().ee(nVar.bBM());
                        NewSubPbActivity.this.lWj.a(NewSubPbActivity.this.lWh.duM(), NewSubPbActivity.this.lWh.duM().dnM(), NewSubPbActivity.this.lWh.duM().Yh(), NewSubPbActivity.this.lWh.duM().bkY(), NewSubPbActivity.this.lWh.dni(), NewSubPbActivity.this.lWh.dva() != null);
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
        aE(bundle);
        if (getIntent() != null) {
            this.mIsFromSchema = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_FROM_SCHEMA, false);
        }
        super.onCreate(bundle);
        this.lIm = getPageContext();
        this.lWr = true;
        this.jYv = new com.baidu.tieba.write.c();
        this.jYv.MC(R.color.cp_cont_h_alpha85);
        this.jYv.MB(R.color.CAM_X0101);
        bZp();
        duk();
        initData(bundle);
        initUI();
        ((SubPbView) this.lWj.getRootView()).show();
        ti(false);
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        this.lWj.vS(this.mIsFromSchema);
        this.lIn = new com.baidu.tbadk.core.view.c();
        this.lIn.toastTime = 1000L;
        registerListener(this.lIP);
        registerListener(this.lIN);
        registerListener(this.lIO);
        registerListener(this.lWz);
        this.lWs = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.lWs;
        userMuteAddAndDelCustomMessage.setTag(this.lWs);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.lWs;
        userMuteCheckCustomMessage.setTag(this.lWs);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.kJC = new am(getPageContext());
        this.kJC.a(new am.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.39
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.kJI.bDr();
                }
            }
        });
        this.lHR = new com.baidu.tieba.pb.pb.report.a(this);
        this.lHR.w(getUniqueId());
        this.lDS = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    public void initUI() {
        this.lWj = new com.baidu.tieba.pb.pb.sub.a(this, this.bbH);
        this.lWj.a(this.lWh);
        setContentView(this.lWj.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.lWj.setOnScrollListener(this.lWl);
        this.lWj.b(this);
        this.lWj.setOnImageClickListener(this.lWm);
        this.lWj.setOnLongClickListener(this.mOnLongClickListener);
        this.lWj.g(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.lWh != null) {
                    NewSubPbActivity.this.lWh.loadData();
                }
            }
        });
        this.lWj.a(this.lWp);
        this.lWj.b(this.lWq);
        this.lWj.setListPullRefreshListener(this.gyc);
        if (this.lWh != null && this.lWh.dum() && !this.lWh.duZ()) {
            this.lWj.duA().setVisibility(8);
        } else {
            this.lWj.duA().setVisibility(0);
        }
        if (this.lWh != null && !this.lWh.dum()) {
            this.lWj.setIsFromPb(false);
        }
    }

    private boolean aE(Bundle bundle) {
        if (bundle != null) {
            this.fux = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.fux = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.fux;
    }

    public void initData(Bundle bundle) {
        this.lWh = new SubPbModel(getPageContext());
        this.lWh.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                NewSubPbActivity.this.lWj.v(postData);
                NewSubPbActivity.this.lWj.b((BdListView.e) null);
            }
        });
        this.lWi = new ForumManageModel(getPageContext());
        this.lWi.setLoadDataCallBack(this.lWo);
        this.iSU = new VoiceManager();
        this.iSU.onCreate(getPageContext());
        this.lHS = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.lHS != null) {
            this.lHS.a(this.lIY);
        }
        if (bundle != null) {
            this.lWh.initWithBundle(bundle);
        } else {
            this.lWh.initWithIntent(getIntent());
        }
        this.lWh.a(this.lWn);
        if (this.lWh.dum() && !this.lWh.dvf()) {
            this.lWh.loadData();
        } else {
            this.lWh.duR();
        }
    }

    public void duk() {
        this.lWn = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, final p pVar) {
                if (NewSubPbActivity.this.lWj != null) {
                    NewSubPbActivity.this.lWj.duv();
                    if (!z) {
                        NewSubPbActivity.this.bK(i, str);
                        return;
                    }
                    NewSubPbActivity.this.lWj.hideNoDataView();
                    if (pVar != null) {
                        if (pVar.dnM() != null || NewSubPbActivity.this.lWh != null) {
                            pVar.dnM().a(NewSubPbActivity.this.lWh.duY());
                        }
                        if (NewSubPbActivity.this.lWj != null) {
                            NewSubPbActivity.this.ti(pVar.bmn() != null && pVar.bmn().isBjh());
                            if (NewSubPbActivity.this.kJI != null && NewSubPbActivity.this.kJI.bCn() != null) {
                                NewSubPbActivity.this.kJI.bCn().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                            }
                            NewSubPbActivity.this.lWj.a(pVar, NewSubPbActivity.this.lWh.dni(), NewSubPbActivity.this.lWh.dva() != null, NewSubPbActivity.this.lWr);
                            if (NewSubPbActivity.this.lWr) {
                                NewSubPbActivity.this.lWj.getListView().setSelectionFromTop(NewSubPbActivity.this.lWj.getListView().getHeaderViewsCount() + 1, -l.getDimens(NewSubPbActivity.this, R.dimen.tbds18));
                                NewSubPbActivity.this.dul();
                                NewSubPbActivity.this.lWr = false;
                            }
                        }
                        if (NewSubPbActivity.this.kJI != null) {
                            NewSubPbActivity.this.kJI.a(pVar.cBe());
                            NewSubPbActivity.this.kJI.setThreadData(pVar.bmn());
                            if (NewSubPbActivity.this.getIntent() != null && NewSubPbActivity.this.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && NewSubPbActivity.this.lWy) {
                                com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        NewSubPbActivity.this.lWy = false;
                                        NewSubPbActivity.this.c(pVar.dnM(), false);
                                    }
                                }, 200L);
                            }
                        }
                        if (NewSubPbActivity.this.lWu == null) {
                            NewSubPbActivity.this.lWu = new com.baidu.tieba.pb.e();
                        }
                        NewSubPbActivity.this.lWu.setData(pVar);
                        NewSubPbActivity.this.lWu.setType(0);
                        NewSubPbActivity.this.kJC.a(NewSubPbActivity.this.lWh.dvd());
                    }
                }
            }
        };
        this.lIY = new a.InterfaceC0583a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0583a
            public void d(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.lHS != null) {
                        NewSubPbActivity.this.lHS.iH(z2);
                    }
                    MarkData blb = NewSubPbActivity.this.lHS.blb();
                    com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                    eVar.setType(2);
                    if (z2) {
                        eVar.setData(blb);
                        if (NewSubPbActivity.this.lHS != null) {
                            if (blb != null) {
                                NewSubPbActivity.this.lWh.vU(true);
                                NewSubPbActivity.this.lWh.QK(NewSubPbActivity.this.lWh.bCP());
                                NewSubPbActivity.this.showToast(R.string.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.add_mark));
                            }
                            if (NewSubPbActivity.this.lWj != null) {
                                NewSubPbActivity.this.lWj.vT(true);
                            }
                        }
                    } else {
                        eVar.setData(null);
                        NewSubPbActivity.this.lWh.vU(false);
                        NewSubPbActivity.this.lWh.QK(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.remove_mark));
                        if (NewSubPbActivity.this.lWj != null) {
                            NewSubPbActivity.this.lWj.vT(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(R.string.update_mark_failed));
            }
        };
        this.lWp = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.lWh.duM() != null && NewSubPbActivity.this.lWh.duM().bmn() != null && NewSubPbActivity.this.lWh.duM().bmn().boP() != null) {
                    str = String.valueOf(NewSubPbActivity.this.lWh.duM().bmn().boP().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.lWh.duM().bDp().getId(), NewSubPbActivity.this.lWh.duM().bDp().getName(), NewSubPbActivity.this.lWh.duM().bmn().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.lWq = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void callback(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.lWi.dQb() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int i = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[1]), 0);
                        boolean z = com.baidu.adp.lib.f.b.toBoolean(String.valueOf(objArr[2]), false);
                        int i2 = com.baidu.adp.lib.f.b.toInt(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.lWh != null && NewSubPbActivity.this.lWh.duM() != null && NewSubPbActivity.this.lWh.duM().bDp() != null && NewSubPbActivity.this.lWh.duM().bmn() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.lWi.TT(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.lWi.a(NewSubPbActivity.this.lWh.duM().bDp().getId(), NewSubPbActivity.this.lWh.duM().bDp().getName(), NewSubPbActivity.this.lWh.duM().bmn().getId(), valueOf, i2, i, z, NewSubPbActivity.this.lWh.duM().bmn().getBaijiahaoData());
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            }
        };
        this.lWo = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.lWj.a(NewSubPbActivity.this.lWi.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.lWi.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.lXw != 1002 || bVar.gZr) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.lWj.a(1, dVar.mSuccess, dVar.noI, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean dy(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void bZp() {
        registerListener(this.iUA);
        this.bbH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
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
                if (view != null || NewSubPbActivity.this.lWj != null) {
                    if (view == NewSubPbActivity.this.lWj.duG()) {
                        NewSubPbActivity.this.lWj.dsR();
                        String str = view.getTag(R.id.tag_user_id) instanceof String ? (String) view.getTag(R.id.tag_user_id) : null;
                        String str2 = view.getTag(R.id.tag_user_name) instanceof String ? (String) view.getTag(R.id.tag_user_name) : null;
                        String str3 = view.getTag(R.id.tag_virtual_user_url) instanceof String ? (String) view.getTag(R.id.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                bf.bua().b(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.lWj.cIb()) {
                        if (view != NewSubPbActivity.this.lWj.duz()) {
                            if (view == NewSubPbActivity.this.lWj.duy()) {
                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                    NewSubPbActivity.this.lWj.duo();
                                    NewSubPbActivity.this.lWj.dup();
                                    if (NewSubPbActivity.this.kJI != null) {
                                        NewSubPbActivity.this.kJI.bDx();
                                    }
                                }
                            } else if (view.getId() != R.id.pb_floor_feedback) {
                                if (view == NewSubPbActivity.this.lWj.dut()) {
                                    NewSubPbActivity.this.lWj.dsR();
                                    if (NewSubPbActivity.this.lWh.loadData()) {
                                        NewSubPbActivity.this.lWj.dur();
                                    }
                                } else if (view == NewSubPbActivity.this.lWj.duA() || view == NewSubPbActivity.this.lWj.duB() || view == NewSubPbActivity.this.lWj.duD()) {
                                    if (NewSubPbActivity.this.lWt) {
                                        NewSubPbActivity.this.lWt = false;
                                        return;
                                    }
                                    if (NewSubPbActivity.this.lWh.duM() != null && NewSubPbActivity.this.lWh.duM().bmn() != null) {
                                        z2 = az.a(NewSubPbActivity.this.lWh.duM().bmn().getBaijiahaoData());
                                    }
                                    if (z2) {
                                        PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.lWh.dqj(), null, "");
                                        if (!StringUtils.isNull(NewSubPbActivity.this.lWh.getFromForumId())) {
                                            createNormalCfg.setForumId(NewSubPbActivity.this.lWh.getFromForumId());
                                        }
                                        if (NewSubPbActivity.this.lWh.duM() != null && NewSubPbActivity.this.lWh.duM().bmn() != null) {
                                            createNormalCfg.setBjhData(NewSubPbActivity.this.lWh.duM().bmn().getBaijiahaoData());
                                        }
                                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.lWh.dqj(), NewSubPbActivity.this.lWh.bCP(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.lWh.getFromForumId())) {
                                        createNormalCfg2.setForumId(NewSubPbActivity.this.lWh.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
                                } else if (NewSubPbActivity.this.lWj.duE() == null || view != NewSubPbActivity.this.lWj.duE().drk()) {
                                    if (NewSubPbActivity.this.lWj.duE() == null || view != NewSubPbActivity.this.lWj.duE().drn()) {
                                        if (NewSubPbActivity.this.lWj.duE() == null || view != NewSubPbActivity.this.lWj.duE().drl()) {
                                            if (NewSubPbActivity.this.lWj.duE() == null || view != NewSubPbActivity.this.lWj.duE().drm()) {
                                                if (NewSubPbActivity.this.lWj.duE() == null || view != NewSubPbActivity.this.lWj.duE().dro()) {
                                                    if (view == NewSubPbActivity.this.lWj.dux() || view == NewSubPbActivity.this.lWj.duD()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.kJI.bDu()) {
                                                                NewSubPbActivity.this.kJI.bDv();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.kJI.Eb(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view != null && (view.getTag() instanceof n)) {
                                                        NewSubPbActivity.this.lWw = (n) view.getTag();
                                                        if (bh.checkUpIsLogin(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                            if (NewSubPbActivity.this.lWt) {
                                                                NewSubPbActivity.this.lWt = false;
                                                                return;
                                                            } else if ((NewSubPbActivity.this.kJC == null || NewSubPbActivity.this.lWh == null || NewSubPbActivity.this.lWh.cBe() == null || NewSubPbActivity.this.kJC.pP(NewSubPbActivity.this.lWh.cBe().replyPrivateFlag)) && (sparseArray2 = (SparseArray) view.getTag(R.id.tag_from)) != null) {
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
                                                        if (NewSubPbActivity.this.lWk == null || view != NewSubPbActivity.this.lWk.drm()) {
                                                            if (NewSubPbActivity.this.lWk == null || view != NewSubPbActivity.this.lWk.drk()) {
                                                                if (NewSubPbActivity.this.lWk == null || view != NewSubPbActivity.this.lWk.drn()) {
                                                                    if (NewSubPbActivity.this.lWk == null || view != NewSubPbActivity.this.lWk.dro()) {
                                                                        if (NewSubPbActivity.this.lWk == null || view != NewSubPbActivity.this.lWk.drq()) {
                                                                            if (NewSubPbActivity.this.lWk == null || view != NewSubPbActivity.this.lWk.drr()) {
                                                                                if (NewSubPbActivity.this.lWk == null || view != NewSubPbActivity.this.lWk.drs()) {
                                                                                    if (NewSubPbActivity.this.lWk != null && view == NewSubPbActivity.this.lWk.drl()) {
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
                                                                                                NewSubPbActivity.this.lWj.dD(view);
                                                                                                return;
                                                                                            } else if (booleanValue2) {
                                                                                                NewSubPbActivity.this.lWj.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
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
                                                                                            String string2 = com.baidu.tbadk.core.sharedPref.b.bsO().getString("tail_link", "");
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
                                                                                            if (postData2.getType() != PostData.eJk && !TextUtils.isEmpty(postData2.getBimg_url()) && k.blV().isShowImages()) {
                                                                                                NewSubPbActivity.this.QH(postData2.getId());
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
                                                                                    if (postData3.bqI() != null) {
                                                                                        NewSubPbActivity.this.d(postData3.bqI());
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.lIq != null && !TextUtils.isEmpty(NewSubPbActivity.this.lIr)) {
                                                                                if (NewSubPbActivity.this.mPermissionJudgement == null) {
                                                                                    NewSubPbActivity.this.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                NewSubPbActivity.this.mPermissionJudgement.clearRequestPermissionList();
                                                                                NewSubPbActivity.this.mPermissionJudgement.appendRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.mPermissionJudgement.startRequestPermission(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.eBS == null) {
                                                                                        NewSubPbActivity.this.eBS = new bd(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.eBS.j(NewSubPbActivity.this.lIr, NewSubPbActivity.this.lIq.getImageByte());
                                                                                    NewSubPbActivity.this.lIq = null;
                                                                                    NewSubPbActivity.this.lIr = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.lIq != null && !TextUtils.isEmpty(NewSubPbActivity.this.lIr)) {
                                                                            if (NewSubPbActivity.this.lIs == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, NewSubPbActivity.this.lIr));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.lIr;
                                                                                aVar.pkgId = NewSubPbActivity.this.lIs.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.lIs.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.lIq = null;
                                                                            NewSubPbActivity.this.lIr = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.jZd != null) {
                                                                        NewSubPbActivity.this.jZd.gD(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.jZd = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                                if (sparseArray5 != null && (sparseArray5.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_id) instanceof String) && (sparseArray5.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.lWj.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.dw(view);
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
                                                                NewSubPbActivity.this.Qe((String) tag);
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
                                                            if (NewSubPbActivity.this.lWh != null) {
                                                                TiebaStatic.log(new ar("c13700").dY("tid", NewSubPbActivity.this.lWh.dqk()).dY("fid", NewSubPbActivity.this.lWh.getFromForumId()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("post_id", postData.getId()).al("obj_source", 1).al("obj_type", 3));
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
                                                        ((PostData) sparseArray8.get(R.id.tag_clip_board)).gD(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new ar("c11739").al("obj_locate", 4));
                                            if (!j.isNetWorkAvailable()) {
                                                NewSubPbActivity.this.showToast(R.string.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.lWj.dsR();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.Qe(str4);
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
                                            NewSubPbActivity.this.lWj.dsR();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.dG(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(R.string.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.lWj.dsR();
                                    SparseArray sparseArray10 = (SparseArray) view.getTag();
                                    if (sparseArray10 != null) {
                                        NewSubPbActivity.this.lWj.a(((Integer) sparseArray10.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray10.get(R.id.tag_del_post_id), ((Integer) sparseArray10.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray10.get(R.id.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new ar("c11739").al("obj_locate", 2));
                                    NewSubPbActivity.this.lWj.dsR();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.lWh.duM() != null) {
                                        NewSubPbActivity.this.n(NewSubPbActivity.this.lWh.duM().dnM());
                                    }
                                }
                            } else {
                                try {
                                    sparseArray3 = (SparseArray) view.getTag();
                                } catch (ClassCastException e) {
                                    e.printStackTrace();
                                }
                                if (sparseArray3 != null && ((PostData) sparseArray3.get(R.id.tag_clip_board)) != null) {
                                    if (NewSubPbActivity.this.lWk == null) {
                                        NewSubPbActivity.this.lWk = new ah(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.bbH);
                                        NewSubPbActivity.this.lWj.dH(NewSubPbActivity.this.lWk.getView());
                                        NewSubPbActivity.this.lWk.vd(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.lWk.RU();
                                    if (NewSubPbActivity.this.uO(sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin()) {
                                        z2 = true;
                                    }
                                    NewSubPbActivity.this.lWk.a(sparseArray3, NewSubPbActivity.this.dni(), z2);
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.lWj.duo();
                            NewSubPbActivity.this.lWj.dup();
                            if (NewSubPbActivity.this.kJI != null) {
                                NewSubPbActivity.this.kJI.bDw();
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        NewSubPbActivity.this.dph();
                        if (NewSubPbActivity.this.lWh != null && NewSubPbActivity.this.lWh.duM() != null && NewSubPbActivity.this.lWh.duM().bmn() != null && NewSubPbActivity.this.lWh.duM().bmn().boP() != null) {
                            TiebaStatic.log(new ar("c13402").dY("tid", NewSubPbActivity.this.lWh.dqj()).w("fid", NewSubPbActivity.this.lWh.duM().bmn().getFid()).al("obj_locate", 5).dY("uid", NewSubPbActivity.this.lWh.duM().bmn().boP().getUserId()));
                        }
                    }
                }
            }
        };
        this.lWl = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.lWj.dsR();
                    if (NewSubPbActivity.this.lDo != 2 && NewSubPbActivity.this.lDo != 1) {
                        NewSubPbActivity.this.lWj.duJ();
                    }
                }
                NewSubPbActivity.this.kJI.bDv();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.lWj.duF();
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
                if (NewSubPbActivity.this.lWj != null && NewSubPbActivity.this.lWj.duw()) {
                    return false;
                }
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null && NewSubPbActivity.this.dy(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.lIq = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.lIr = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.lIq == null || TextUtils.isEmpty(NewSubPbActivity.this.lIr)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lIs = null;
                        } else {
                            NewSubPbActivity.this.lIs = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() == null) {
                            return true;
                        }
                        NewSubPbActivity.this.lIq = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.lIr = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lIs = null;
                        } else {
                            NewSubPbActivity.this.lIs = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.lIq = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.lIr = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.lIs = null;
                        } else {
                            NewSubPbActivity.this.lIs = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        NewSubPbActivity.this.lWj.a(NewSubPbActivity.this.lJf, NewSubPbActivity.this.lIq.isGif());
                    } else {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray2 = sparseArray;
                        }
                    }
                    if (sparseArray2 == null) {
                        NewSubPbActivity.this.jZd = (PostData) sparseArray2.get(R.id.tag_clip_board);
                        if (NewSubPbActivity.this.jZd == null || NewSubPbActivity.this.lHS == null) {
                            return true;
                        }
                        if (NewSubPbActivity.this.lHS != null) {
                            NewSubPbActivity.this.lHS.iH(NewSubPbActivity.this.lWh.duT());
                        }
                        boolean z2 = NewSubPbActivity.this.lHS.bkY() && NewSubPbActivity.this.jZd.getId() != null && NewSubPbActivity.this.jZd.getId().equals(NewSubPbActivity.this.lWh.duV());
                        if (NewSubPbActivity.this.lWk == null) {
                            NewSubPbActivity.this.lWk = new ah(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.bbH);
                            NewSubPbActivity.this.lWj.dH(NewSubPbActivity.this.lWk.getView());
                            NewSubPbActivity.this.lWk.vd(NewSubPbActivity.this.mIsLogin);
                        }
                        NewSubPbActivity.this.lWk.RU();
                        boolean z3 = NewSubPbActivity.this.uO(sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue() : false) && NewSubPbActivity.this.isLogin();
                        boolean z4 = (NewSubPbActivity.this.lWh.duM() == null || NewSubPbActivity.this.lWh.duM().bmn() == null || !NewSubPbActivity.this.lWh.duM().bmn().isBjh()) ? false : true;
                        boolean booleanValue = sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue() : false;
                        if (z2) {
                            NewSubPbActivity.this.lWk.drk().setText(R.string.remove_mark);
                        } else {
                            NewSubPbActivity.this.lWk.drk().setText(R.string.mark);
                        }
                        if (booleanValue || z4) {
                            NewSubPbActivity.this.lWk.drk().setVisibility(8);
                        } else {
                            NewSubPbActivity.this.lWk.drk().setVisibility(0);
                        }
                        if (NewSubPbActivity.this.dy(view)) {
                            if (NewSubPbActivity.this.lIq != null && !NewSubPbActivity.this.lIq.isGif()) {
                                sparseArray2.put(R.id.tag_richtext_image, true);
                            } else {
                                sparseArray2.put(R.id.tag_richtext_image, false);
                            }
                            sparseArray2.put(R.id.tag_richtext_emotion, true);
                        } else {
                            sparseArray2.put(R.id.tag_richtext_image, false);
                            sparseArray2.put(R.id.tag_richtext_emotion, false);
                        }
                        ah ahVar = NewSubPbActivity.this.lWk;
                        int dni = NewSubPbActivity.this.dni();
                        if (NewSubPbActivity.this.lHP && NewSubPbActivity.this.jZd.nmE) {
                            z = true;
                        }
                        ahVar.a(sparseArray2, dni, z3, z);
                        return true;
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 == null) {
                }
            }
        };
        this.lWm = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
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
                        p duM = NewSubPbActivity.this.lWh.duM();
                        TbRichText bz = NewSubPbActivity.this.bz(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (bz != null && bz.bIC() != null) {
                            tbRichTextData = bz.bIC().get(NewSubPbActivity.this.lJc);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                            if (!tbRichTextData.bII().bIV()) {
                                String c = NewSubPbActivity.this.c(tbRichTextData);
                                arrayList.add(c);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap.put(c, imageUrlData);
                                String str5 = null;
                                String str6 = null;
                                String str7 = null;
                                if (duM == null) {
                                    str4 = null;
                                    z4 = false;
                                } else {
                                    if (duM.bDp() != null) {
                                        str5 = duM.bDp().getName();
                                        str6 = duM.bDp().getId();
                                    }
                                    if (duM.bmn() != null) {
                                        str7 = duM.bmn().getId();
                                    }
                                    str4 = str7;
                                    z4 = true;
                                }
                                if (NewSubPbActivity.this.lWh.dva() != null) {
                                    concurrentHashMap = NewSubPbActivity.this.lWh.dva();
                                    z4 = NewSubPbActivity.this.lWh.dvc();
                                    arrayList = NewSubPbActivity.this.lWh.dvb();
                                }
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(y.getItem(arrayList, 0));
                                ImageViewerConfig.a aVar = new ImageViewerConfig.a();
                                aVar.x(arrayList2).AG(str5).AH(str6).AI(str4).iN(z4).AJ(arrayList.get(0)).iO(true).a(concurrentHashMap).iP(true).iQ(false).iR(false).s(NewSubPbActivity.this.bmn()).AK(String.valueOf(bz.getPostId())).AL(NewSubPbActivity.this.lWh.getFromForumId());
                                NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar.ez(NewSubPbActivity.this.getPageContext().getPageActivity())));
                                return;
                            }
                            NewSubPbActivity.this.lJd = false;
                            TbRichText dPi = duM.dnM().dPi();
                            int size = arrayList.size();
                            int a2 = NewSubPbActivity.this.a(dPi, bz, i, i, arrayList, concurrentHashMap);
                            int size2 = arrayList.size();
                            if (size == size2) {
                                str2 = "";
                            } else {
                                str2 = arrayList.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (duM == null) {
                                str3 = null;
                                z3 = false;
                            } else {
                                if (duM.bDp() != null) {
                                    str8 = duM.bDp().getName();
                                    str9 = duM.bDp().getId();
                                }
                                if (duM.bmn() != null) {
                                    str10 = duM.bmn().getId();
                                }
                                str3 = str10;
                                z3 = true;
                            }
                            if (NewSubPbActivity.this.lWh.dva() != null) {
                                concurrentHashMap = NewSubPbActivity.this.lWh.dva();
                                z3 = NewSubPbActivity.this.lWh.dvc();
                                arrayList = NewSubPbActivity.this.lWh.dvb();
                                a2 += NewSubPbActivity.this.lWh.getOffset();
                            }
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(y.getItem(arrayList, a2));
                            ImageViewerConfig.a aVar2 = new ImageViewerConfig.a();
                            aVar2.x(arrayList3).AG(str8).AH(str9).AI(str3).iN(z3).AJ(str2).iO(true).a(concurrentHashMap).iP(true).iQ(false).iR(false).s(NewSubPbActivity.this.bmn()).AK(String.valueOf(bz.getPostId())).AL(NewSubPbActivity.this.lWh.getFromForumId());
                            NewSubPbActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, aVar2.ez(NewSubPbActivity.this.getPageContext().getPageActivity())));
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
    public by bmn() {
        if (this.lWh == null || this.lWh.duM() == null) {
            return null;
        }
        return this.lWh.duM().bmn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dw(View view) {
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
        if (!dpg()) {
            if (postData != null) {
                if (postData.boP() != null) {
                    MetaData boP = postData.boP();
                    this.kJI.setReplyId(boP.getUserId());
                    boolean z2 = postData.nmE;
                    String str = "";
                    if (postData.dPi() != null) {
                        str = postData.dPi().toString();
                    }
                    this.kJI.Ed(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.boP().getName_show(), str));
                    if (z2) {
                        if (!z) {
                            this.kJI.Ec("");
                        }
                    } else if (!z) {
                        this.kJI.Ec(boP.getName_show());
                    }
                }
                this.lWj.dup();
            }
            if (this.lWv) {
                vR(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(AgreeData agreeData) {
        com.baidu.tbadk.pageExtra.c eX;
        int i = 1;
        if (agreeData != null) {
            if (this.eXx == null) {
                this.eXx = new com.baidu.tbadk.core.message.a();
            }
            if (this.eXh == null) {
                this.eXh = new e();
                this.eXh.uniqueId = this.lWx;
            }
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eEJ = 12;
            dVar.eEP = 9;
            dVar.eEO = 3;
            if (dun() != null) {
                dVar.eEN = dun().dve();
            }
            if (dVar != null) {
                dVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (dVar != null) {
                        dVar.eEQ = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (dVar != null) {
                        dVar.eEQ = 1;
                        i = 0;
                    }
                }
                eX = com.baidu.tbadk.pageExtra.d.eX(getActivity());
                if (eX != null) {
                    agreeData.objSource = eX.getCurrentPageKey();
                }
                this.eXx.a(agreeData, i, getUniqueId(), false);
                this.eXx.a(agreeData, this.eXh);
                if (dun() == null && dun().duM() != null) {
                    this.eXx.a(this, dVar, agreeData, dun().duM().bmn());
                    return;
                }
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (dVar != null) {
                dVar.eEQ = 1;
            }
            i = 0;
            eX = com.baidu.tbadk.pageExtra.d.eX(getActivity());
            if (eX != null) {
            }
            this.eXx.a(agreeData, i, getUniqueId(), false);
            this.eXx.a(agreeData, this.eXh);
            if (dun() == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo bII;
        if (tbRichText == tbRichText2) {
            this.lJd = true;
        }
        if (tbRichText != null && tbRichText.bIC() != null) {
            int size = tbRichText.bIC().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.bIC().get(i6) != null && tbRichText.bIC().get(i6).getType() == 8) {
                    i5++;
                    int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                    int width = tbRichText.bIC().get(i6).bII().getWidth() * equipmentDensity;
                    int height = tbRichText.bIC().get(i6).bII().getHeight() * equipmentDensity;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.bIC().get(i6).bII().bIV()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.bIC().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (bII = tbRichTextData.bII()) != null) {
                            String bIX = bII.bIX();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = bIX;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.lJd) {
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
        if (this.lWk != null) {
            this.lWk.vd(z);
        }
        if (this.lWj != null) {
            this.lWj.vd(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        TbRichTextImageInfo bII = tbRichTextData.bII();
        if (bII != null) {
            if (!StringUtils.isNull(bII.bIU())) {
                return bII.bIU();
            }
            if (bII.getHeight() * bII.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (bII.getHeight() * bII.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (bII.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * bII.getHeight())));
            } else {
                float width = bII.getWidth() / bII.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(au.getUrlEncode(bII.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText bz(String str, int i) {
        if (this.lWh == null || this.lWh.duM() == null || str == null || i < 0) {
            return null;
        }
        p duM = this.lWh.duM();
        TbRichText a2 = a(duM.dnM(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(duM.dnM(), str, i);
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
        TbRichText dPi = postData.dPi();
        if (dPi != null) {
            ArrayList<TbRichTextData> bIC = dPi.bIC();
            int size = bIC.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (bIC.get(i3) != null && bIC.get(i3).getType() == 8) {
                    i2++;
                    if (bIC.get(i3).bII().bIX().equals(str)) {
                        int equipmentDensity = (int) l.getEquipmentDensity(TbadkCoreApplication.getInst());
                        int width = bIC.get(i3).bII().getWidth() * equipmentDensity;
                        int height = bIC.get(i3).bII().getHeight() * equipmentDensity;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.lJc = i3;
                        return dPi;
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

    private boolean dpg() {
        if (this.lWh == null) {
            return false;
        }
        return AntiHelper.a(getPageContext(), this.lWh.cBe());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dph() {
        Intent intent = getIntent();
        boolean booleanExtra = intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false;
        if (!dpg()) {
            if (booleanExtra) {
                if (this.kJC == null || this.lWh == null || this.lWh.cBe() == null || this.kJC.pP(this.lWh.cBe().replyPrivateFlag)) {
                    if (this.kJI.bDj()) {
                        this.kJI.a((PostWriteCallBackData) null);
                        return;
                    }
                    this.lWj.duo();
                    this.lWj.dup();
                    if (this.kJI != null) {
                        this.kJI.bDy();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.iXo == null) {
                this.iXo = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.iXo.a(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qi(boolean z) {
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
                    public void qj(boolean z) {
                        String str;
                        if (z) {
                            if (NewSubPbActivity.this.kJC == null || NewSubPbActivity.this.lWh == null || NewSubPbActivity.this.lWh.cBe() == null || NewSubPbActivity.this.kJC.pP(NewSubPbActivity.this.lWh.cBe().replyPrivateFlag)) {
                                if (NewSubPbActivity.this.lWh != null && NewSubPbActivity.this.lWh.duM() != null && NewSubPbActivity.this.lWh.duM().dnM() != null) {
                                    PostData dnM = NewSubPbActivity.this.lWh.duM().dnM();
                                    if (dnM.dPi() != null && dnM.boP() != null) {
                                        str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), dnM.boP().getName_show(), dnM.dPi().toString());
                                        NewSubPbActivity.this.kJI.bCn().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                                        if (!NewSubPbActivity.this.kJI.bDj()) {
                                            NewSubPbActivity.this.kJI.a((PostWriteCallBackData) null);
                                            return;
                                        }
                                        NewSubPbActivity.this.lWj.duo();
                                        NewSubPbActivity.this.lWj.dup();
                                        if (NewSubPbActivity.this.kJI != null) {
                                            NewSubPbActivity.this.kJI.bDy();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                str = null;
                                NewSubPbActivity.this.kJI.bCn().b(new com.baidu.tbadk.editortools.a(45, 27, str));
                                if (!NewSubPbActivity.this.kJI.bDj()) {
                                }
                            }
                        }
                    }
                });
            }
            if (this.lWh != null && this.lWh.duM() != null && this.lWh.duM().bDp() != null) {
                this.iXo.G(this.lWh.duM().bDp().getId(), com.baidu.adp.lib.f.b.toLong(this.lWh.dqj(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uO(boolean z) {
        if (this.lWh == null) {
            return false;
        }
        return ((dni() != 0) || this.lWh.duM() == null || this.lWh.duM().bmn() == null || this.lWh.duM().bmn().boP() == null || this.lWh.duM().bmn().bnz() || TextUtils.equals(this.lWh.duM().bmn().boP().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(int i, String str) {
        if (this.lWh.duN()) {
            showToast(str);
        } else if (l.isNetOk()) {
            if (i == 4) {
                this.lWj.Jk(str + "(4)");
            } else {
                this.lWj.Ed(R.string.no_data_text);
            }
        } else {
            this.lWj.Ed(R.string.recommend_pb_no_net_text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti(boolean z) {
        this.kJI = (com.baidu.tbadk.editortools.pb.h) new i(z).eN(getActivity());
        if (this.kJI != null) {
            this.kJI.a(getPageContext());
            this.kJI.b(this.lWh);
            this.kJI.b(this.jYC);
            this.kJI.setFrom(2);
            this.kJI.a(this.fwB);
            this.kJI.a(this.fwC);
            this.kJI.bCn().ks(true);
            this.kJI.j(getPageContext());
        }
        if (this.lWj != null) {
            this.lWj.i(this.kJI);
        }
        if (this.kJI != null && this.lWh != null) {
            this.kJI.a(this.lWh.cBe());
            this.kJI.bDv();
        }
        if (this.kJI != null) {
            this.kJI.bDz().setDefaultHint(dsd());
            this.kJI.bDz().setHint(dsd());
            this.jYw = this.kJI.bDz().getInputView();
            this.jYw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.jYv != null) {
                        if (!NewSubPbActivity.this.jYv.dYp()) {
                            NewSubPbActivity.this.rM(false);
                        }
                        NewSubPbActivity.this.jYv.zc(false);
                    }
                }
            });
        }
    }

    public void dul() {
        if (!TbadkCoreApplication.isLogin()) {
            this.kJI.bDv();
        } else if (!StringUtils.isNull(this.lWh.duW())) {
            if (this.lWj.dus() && l.isNetOk()) {
                this.lWj.czd();
            } else {
                this.lWj.duv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dG(View view) {
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
                    this.lWj.dD(view);
                }
            } else if (booleanValue2) {
                this.lWj.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
            }
            g.dismissPopupWindow(this.lWj.duC(), getPageContext().getPageActivity());
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
            bVar.oV(R.string.operation);
            bVar.a(strArr, new b.InterfaceC0586b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0586b
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
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.lWs);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.lWs);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).brx();
        }
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
        }
        this.lWj.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.lWs;
        userMuteCheckCustomMessage.setTag(this.lWs);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.lWj.a(0, bVar.mSuccess, bVar.noI, z);
            if (bVar.mSuccess) {
                if (bVar.izO == 1) {
                    if (this.lWj.getListView() instanceof BdTypeListView) {
                        List<q> data = ((BdTypeListView) this.lWj.getListView()).getData();
                        if (!y.isEmpty(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            if (i < data.size()) {
                                data.remove(i);
                            }
                            this.lWj.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.izO == 2) {
                    this.lWh.QJ(bVar.mPostId);
                    this.lWj.a(this.lWh.duM(), this.lWh.dni(), this.lWh.dva() != null, false);
                    if (this.lWh.duX()) {
                        this.lWh.vV(false);
                        this.lWj.duq();
                        this.lWh.loadData();
                    }
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void Qe(String str) {
        if (this.lWh != null && this.lWh.duM() != null && this.lWh.duM().bmn() != null && this.lWh.duM().bmn().isBjh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lWh.dqj(), str);
            by bmn = this.lWh.duM().bmn();
            if (bmn.bnx()) {
                format = format + "&channelid=33833";
            } else if (bmn.bqL()) {
                format = format + "&channelid=33842";
            } else if (bmn.bny()) {
                format = format + "&channelid=33840";
            }
            Qf(format);
            return;
        }
        this.lHR.QF(str);
    }

    private void Qf(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void n(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.lWh.duT() && postData.getId() != null && postData.getId().equals(this.lWh.duV())) {
                z = true;
            }
            MarkData o = this.lWh.o(postData);
            if (o != null) {
                this.lWj.dsR();
                if (this.lHS != null) {
                    this.lHS.a(o);
                    if (!z) {
                        this.lHS.bla();
                    } else {
                        this.lHS.bkZ();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.lWh != null) {
            this.lWh.aD(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.kJI != null) {
            this.kJI.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.kJI.bCn().bAK();
        this.kJI.bDv();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.kJI.b(writeData);
                this.kJI.setVoiceModel(pbEditorData.getVoiceModel());
                m sj = this.kJI.bCn().sj(6);
                if (sj != null && sj.fub != null) {
                    sj.fub.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.kJI.bDr();
                }
                this.lWj.duJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.iSU != null) {
            this.iSU.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.mIsPaused = true;
        super.onPause();
        com.baidu.tbadk.BdToken.c.biD().biO();
        if (this.iSU != null) {
            this.iSU.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.jhb);
        this.lWj.cKu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.mIsPaused = false;
        super.onResume();
        dpM();
        if (this.iSU != null) {
            this.iSU.onResume(getPageContext());
        }
        registerListener(this.jhb);
        this.lWj.cKv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.iSU != null) {
            this.iSU.onStop(getPageContext());
        }
        this.kJI.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, this.lWu));
        this.lWh.cancelLoadData();
        this.lWh.destory();
        this.lWi.cancelLoadData();
        if (this.iSU != null) {
            this.iSU.onDestory(getPageContext());
        }
        this.lWj.dsR();
        this.lWj.cIC();
        MessageManager.getInstance().unRegisterListener(this.lIN);
        MessageManager.getInstance().unRegisterListener(this.lIO);
        MessageManager.getInstance().unRegisterListener(this.lIP);
        MessageManager.getInstance().unRegisterListener(this.lWs);
        this.lIm = null;
        this.lIn = null;
        if (this.kJC != null) {
            this.kJC.onDestroy();
        }
        com.baidu.tbadk.pageExtra.d.En(getCurrentPageKey());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.lWj.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.iSU;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View dux = this.lWj.dux();
        if (dux == null || (findViewWithTag = dux.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean Qx(String str) {
        Map<String, String> paramPair;
        if (!TextUtils.isEmpty(str) && (paramPair = bf.getParamPair(bf.getParamStr(str))) != null) {
            this.lWt = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return Qx(com.baidu.adp.lib.util.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(lWg);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (Qx(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.m mVar = new com.baidu.tbadk.data.m();
                    mVar.mLink = str;
                    mVar.type = 3;
                    mVar.fsY = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, mVar));
                }
            } else {
                bf.bua().b(getPageContext(), new String[]{str});
            }
            this.lWt = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ax(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.lWt = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ay(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void az(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aA(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void u(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        if (this.lWj != null) {
            return this.lWj.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bJm() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bJo() {
        if (this.fQq == null) {
            this.fQq = TbRichTextView.J(getPageContext().getPageActivity(), 8);
        }
        return this.fQq;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bJp() {
        if (this.fNa == null) {
            this.fNa = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cwK */
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
        return this.fNa;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bJn() {
        if (this.fMZ == null) {
            this.fMZ = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bJz */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean isShowImages = k.blV().isShowImages();
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
                        foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: b */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (k.blV().isShowImages()) {
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
                        foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.fMZ;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bJq() {
        if (this.fQr == null) {
            this.fQr = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dpT */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(NewSubPbActivity.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dz */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dA */
                public View activateObject(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dB */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fQr;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bJr() {
        if (this.fQs == null) {
            this.fQs = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dpV */
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
        return this.fQs;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bJs() {
        this.fQt = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dpU */
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
        return this.fQt;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a dob() {
        return this.lDS;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean doc() {
        return (this.lWh == null || this.lWh.duM() == null || this.lWh.duM().bmn() == null || this.lWh.duM().bmn().bqo()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String dod() {
        if (this.lWh == null || this.lWh.duM() == null || this.lWh.duM().bmn() == null) {
            return null;
        }
        return this.lWh.duM().bmn().boT();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int doe() {
        if (this.lWh == null) {
            return 0;
        }
        return this.lWh.dni();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean PY(String str) {
        if (StringUtils.isNull(str) || this.lWh == null || this.lWh.duM() == null || this.lWh.duM().bmn() == null || this.lWh.duM().bmn().boP() == null) {
            return false;
        }
        return str.equals(this.lWh.duM().bmn().boP().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.lWj.dus() && l.isNetOk()) {
            this.lWh.loadData();
        } else {
            this.lWj.duv();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.lWs);
        userMuteAddAndDelCustomMessage.setTag(this.lWs);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QH(String str) {
        if (!StringUtils.isNull(str) && bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString("bubble_link", "");
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
                return com.baidu.tbadk.m.e.bEZ().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.lWh != null) {
            if (this.lWh.duM() != null && this.lWh.duM().bDp() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.lWh.duM().bDp().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.f.b.toLong(this.lWh.dqj(), 0L));
            if (this.lWh.duM() != null && this.lWh.duM().bmn() != null) {
                pageStayDurationItem.setNid(this.lWh.duM().bmn().getNid());
            }
            pageStayDurationItem.setPid(com.baidu.adp.lib.f.b.toLong(this.lWh.bCP(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public boolean dum() {
        if (this.lWh != null) {
            return this.lWh.dum();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.lWj.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lIm.getPageActivity());
        if (au.isEmpty(str)) {
            aVar.Bq(this.lIm.getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Bq(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.lWj.showLoadingDialog();
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
        aVar.b(this.lIm).brv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ea(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lIm.getPageActivity());
        aVar.Bq(str);
        aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lIm).brv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dpI() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.Bq(getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.lIm).showToast(R.string.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.lIm.getPageActivity(), 2, true, 4);
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
        aVar.b(this.lIm).brv();
    }

    public SubPbModel dun() {
        return this.lWh;
    }

    public int dni() {
        if (this.lWh != null) {
            return this.lWh.dni();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.fux && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.fux && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        } else {
            super.closeAnimation();
        }
    }

    public void rM(boolean z) {
        if (this.jYw != null && this.jYw.getText() != null) {
            int selectionEnd = this.jYw.getSelectionEnd();
            SpannableStringBuilder c = this.jYv.c(this.jYw.getText());
            if (c != null) {
                this.jYv.zc(true);
                this.jYw.setText(c);
                if (z && this.jYv.dYn() >= 0) {
                    this.jYw.requestFocus();
                    this.jYw.setSelection(this.jYv.dYn());
                } else {
                    this.jYw.setSelection(selectionEnd);
                }
                this.jYv.zb(this.jYv.dYn() >= 0);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.kJI != null && this.kJI.bCn() != null && this.kJI.bCn().bCr()) {
            this.kJI.bCn().bAK();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(t tVar) {
        ag.a(tVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.f.c.a(tVar, getUniqueId(), this);
    }

    public String dsd() {
        if (!au.isEmpty(this.lQP)) {
            return this.lQP;
        }
        this.lQP = getResources().getString(ay.drT());
        return this.lQP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        this.lWv = z;
        vR(true);
    }

    private void vR(boolean z) {
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
        if (this.lWj != null && this.lWj.getListView() != null && this.lWw != null && this.lWw.mPosition != -1) {
            final int headerViewsCount = this.lWw.mPosition + this.lWj.getListView().getHeaderViewsCount();
            if (this.lWw.getView() != null) {
                final int height = this.lWw.getView().getHeight();
                final int height2 = ((rect.height() - this.lWj.duI()) - this.lWj.getNavigationBarHeight()) - this.lWj.duH();
                final int i = height - height2;
                if (i > 0) {
                    this.lWj.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.lWj != null && NewSubPbActivity.this.lWj.getListView() != null) {
                                NewSubPbActivity.this.lWj.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.lWj.getNavigationBarHeight() - i);
                            }
                        }
                    });
                } else {
                    this.lWj.getListView().post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
                        @Override // java.lang.Runnable
                        public void run() {
                            if (NewSubPbActivity.this.lWj != null && NewSubPbActivity.this.lWj.getListView() != null) {
                                NewSubPbActivity.this.lWj.getListView().setSelectionFromTop(headerViewsCount, NewSubPbActivity.this.lWj.getNavigationBarHeight() + (height2 - height));
                            }
                        }
                    });
                }
            }
        }
    }

    private void dpM() {
        if (this.lWh != null && !au.isEmpty(this.lWh.dqj())) {
            com.baidu.tbadk.BdToken.c.biD().p(com.baidu.tbadk.BdToken.b.evv, com.baidu.adp.lib.f.b.toLong(this.lWh.dqj(), 0L));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        if (this.lWh == null || au.isEmpty(this.lWh.dqj())) {
            return 0L;
        }
        return com.baidu.adp.lib.f.b.toLong(this.lWh.dqj(), 0L);
    }
}
