package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.content.Intent;
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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
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
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.h;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.pb.PbEditorData;
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
import com.baidu.tbadk.widget.richText.c;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.data.ContriInfo;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.av;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.pb.pb.sub.a;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes6.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.e, com.baidu.tieba.pb.pb.a<NewSubPbActivity> {
    private static final String ggk = com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon";
    private static String ghE = "tbgametype";
    private View.OnLongClickListener aTo;
    private com.baidu.adp.lib.e.b<ImageView> brD;
    private com.baidu.adp.lib.e.b<TextView> brE;
    private com.baidu.adp.lib.e.b<View> brF;
    private com.baidu.adp.lib.e.b<LinearLayout> brG;
    private com.baidu.adp.lib.e.b<RelativeLayout> brH;
    private com.baidu.adp.lib.e.b<GifView> brI;
    private com.baidu.tbadk.core.util.b.a bzf;
    private h dIO;
    private VoiceManager dIc;
    private com.baidu.tieba.pb.pb.report.a fSV;
    private com.baidu.tbadk.baseEditMark.a fSW;
    private com.baidu.tieba.pb.pb.main.b.a fSY;
    private y fTd;
    private com.baidu.adp.base.e fTp;
    private g fTq;
    private av fTt;
    private com.baidu.adp.widget.ImageView.a fTu;
    private String fTv;
    private TbRichTextMemeInfo fTw;
    private b.InterfaceC0158b fUf;
    private PostWriteCallBackData fXG;
    public aj ffd;
    private com.baidu.tbadk.editortools.pb.g ffl;
    private EditText geQ;
    private SubPbModel ghF;
    private ForumManageModel ghG;
    private b ghH;
    private AbsListView.OnScrollListener ghI;
    private TbRichTextView.i ghJ;
    private TbRichTextView.h ghK;
    private SubPbModel.a ghL;
    private com.baidu.adp.base.d ghM;
    private BdUniqueId ghR;
    private com.baidu.tieba.pb.pb.sub.a ghT;
    private com.baidu.tieba.write.b ghU;
    private com.baidu.tieba.pb.d<j> ghV;
    private View.OnClickListener mCommonClickListener;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int fUc = 0;
    PostData fUe = null;
    private a.InterfaceC0154a fTZ = null;
    private a ghN = null;
    private a ghO = null;
    private boolean ghP = false;
    private boolean ghQ = false;
    private boolean ghS = false;
    private boolean aYF = false;
    private com.baidu.tbadk.editortools.pb.c aZY = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.1
        @Override // com.baidu.tbadk.editortools.pb.c
        public void Mv() {
            NewSubPbActivity.this.ghH.bmz();
        }
    };
    private com.baidu.tbadk.editortools.pb.b aZZ = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.12
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean Mu() {
            if (!NewSubPbActivity.this.ghU.bMW()) {
                return (NewSubPbActivity.this.ffd == null || NewSubPbActivity.this.ghF == null || NewSubPbActivity.this.ghF.azX() == null || NewSubPbActivity.this.ffd.x(NewSubPbActivity.this.ghF.azX().replyPrivateFlag, aj.aBX)) ? false : true;
            }
            NewSubPbActivity.this.showToast(NewSubPbActivity.this.ghU.bMY());
            if (NewSubPbActivity.this.ffl.MK()) {
                NewSubPbActivity.this.ffl.a(NewSubPbActivity.this.fXG);
            }
            NewSubPbActivity.this.lL(true);
            return true;
        }
    };
    private NewWriteModel.d ghW = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.23
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
            if (z && NewSubPbActivity.this.ffl != null && NewSubPbActivity.this.ffl.LX() != null) {
                NewSubPbActivity.this.ffl.LX().hide();
                if (NewSubPbActivity.this.ghF.bmT()) {
                    TiebaStatic.log(new am("c10367").aA("post_id", NewSubPbActivity.this.ghF.Ms()));
                }
            }
            if (z) {
                NewSubPbActivity.this.ghU.xr(null);
                NewSubPbActivity.this.ghU.az(null);
                NewSubPbActivity.this.ghU.oq(false);
                if (postWriteCallBackData != null && postWriteCallBackData.getContriInfo() != null && postWriteCallBackData.getContriInfo().isShowToast()) {
                    NewSubPbActivity.this.a(postWriteCallBackData.getContriInfo());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                NewSubPbActivity.this.ghU.az(postWriteCallBackData.getSensitiveWords());
                NewSubPbActivity.this.ghU.xr(postWriteCallBackData.getErrorString());
                if (!v.I(NewSubPbActivity.this.ghU.bMU())) {
                    NewSubPbActivity.this.fXG = postWriteCallBackData;
                    if (NewSubPbActivity.this.ffl.MK()) {
                        NewSubPbActivity.this.ffl.a(NewSubPbActivity.this.fXG);
                    }
                    NewSubPbActivity.this.lL(true);
                } else {
                    return;
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && NewSubPbActivity.this.ffd != null) {
                NewSubPbActivity.this.ffd.a(postWriteCallBackData.getReplyPrivacyTip());
            }
            NewSubPbActivity.this.ghH.bmA();
        }
    };
    private CustomMessageListener fTS = new CustomMessageListener(2001427) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.ghR) {
                NewSubPbActivity.this.ghH.akP();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fTq.e(NewSubPbActivity.this.fTp.getResources().getString(e.j.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = NewSubPbActivity.this.fTp.getResources().getString(e.j.mute_error_beyond_limit);
                    }
                    NewSubPbActivity.this.hT(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    NewSubPbActivity.this.bin();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (ao.isEmpty(errorString2)) {
                        errorString2 = NewSubPbActivity.this.fTp.getResources().getString(e.j.mute_fail);
                    }
                    NewSubPbActivity.this.fTq.f(errorString2);
                }
            }
        }
    };
    private CustomMessageListener fTT = new CustomMessageListener(2001428) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.ghR) {
                NewSubPbActivity.this.ghH.akP();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    NewSubPbActivity.this.fTq.e(NewSubPbActivity.this.fTp.getResources().getString(e.j.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (ao.isEmpty(muteMessage)) {
                    muteMessage = NewSubPbActivity.this.fTp.getResources().getString(e.j.un_mute_fail);
                }
                NewSubPbActivity.this.fTq.f(muteMessage);
            }
        }
    };
    private CustomMessageListener fTU = new CustomMessageListener(2001426) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == NewSubPbActivity.this.ghR) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                NewSubPbActivity.this.ghH.akP();
                SparseArray<Object> sparseArray = (SparseArray) NewSubPbActivity.this.mExtra;
                DataRes dataRes = aVar.hzw;
                if (aVar.error == 0 && dataRes != null) {
                    boolean z2 = com.baidu.adp.lib.g.b.l(dataRes.is_mute, 0) == 1;
                    sparseArray.put(e.g.tag_user_mute_visible, true);
                    sparseArray.put(e.g.tag_user_mute_msg, dataRes.mute_confirm);
                    z = z2;
                } else {
                    sparseArray.put(e.g.tag_user_mute_visible, false);
                    z = false;
                }
                int intValue = sparseArray.get(e.g.tag_from) instanceof Integer ? ((Integer) sparseArray.get(e.g.tag_from)).intValue() : 0;
                if (intValue == 0) {
                    NewSubPbActivity.this.a(z, sparseArray);
                } else if (intValue == 1) {
                    NewSubPbActivity.this.ghH.a(sparseArray, z);
                }
            }
        }
    };
    boolean fUd = false;
    private final b.InterfaceC0158b fUg = new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.15
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            bVar.dismiss();
            if (NewSubPbActivity.this.fTu != null && !TextUtils.isEmpty(NewSubPbActivity.this.fTv)) {
                if (i == 0) {
                    if (NewSubPbActivity.this.fTw == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.fTv));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = NewSubPbActivity.this.fTv;
                        aVar.pkgId = NewSubPbActivity.this.fTw.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.fTw.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (NewSubPbActivity.this.bzf == null) {
                        NewSubPbActivity.this.bzf = new com.baidu.tbadk.core.util.b.a();
                    }
                    NewSubPbActivity.this.bzf.Et();
                    NewSubPbActivity.this.bzf.c(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!NewSubPbActivity.this.bzf.A(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                        if (NewSubPbActivity.this.fTt == null) {
                            NewSubPbActivity.this.fTt = new av(NewSubPbActivity.this.getPageContext());
                        }
                        NewSubPbActivity.this.fTt.i(NewSubPbActivity.this.fTv, NewSubPbActivity.this.fTu.os());
                    } else {
                        return;
                    }
                }
                NewSubPbActivity.this.fTu = null;
                NewSubPbActivity.this.fTv = null;
            }
        }
    };
    private CustomMessageListener eJa = new CustomMessageListener(2001332) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a)) {
                c.a aVar = (c.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.c.a(NewSubPbActivity.this.getPageContext(), aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    CustomMessageListener dJl = new CustomMessageListener(2016485) { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.j)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    com.baidu.tbadk.data.j jVar = (com.baidu.tbadk.data.j) customResponsedMessage.getData();
                    if (NewSubPbActivity.this.ghF.bmN() != null && NewSubPbActivity.this.ghF.bmN().bgQ() != null && NewSubPbActivity.this.ghF.bmN().bgQ().zG() != null && currentAccount.equals(NewSubPbActivity.this.ghF.bmN().bgQ().zG().getUserId()) && NewSubPbActivity.this.ghF.bmN().bgQ().zG().getPendantData() != null) {
                        NewSubPbActivity.this.ghF.bmN().bgQ().zG().getPendantData().ej(jVar.ys());
                        NewSubPbActivity.this.ghF.bmN().bgQ().zG().getPendantData().ao(jVar.LE());
                        NewSubPbActivity.this.ghH.a(NewSubPbActivity.this.ghF.bmN().bgQ(), NewSubPbActivity.this.ghF.bmN().aTB(), NewSubPbActivity.this.ghF.bmN().wq(), NewSubPbActivity.this.ghF.bgv(), NewSubPbActivity.this.ghF.bmZ() != null);
                    }
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        void m(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        H(bundle);
        if (this.aYF) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.fTp = getPageContext();
        this.ghQ = true;
        this.ghU = new com.baidu.tieba.write.b();
        this.ghU.wW(e.d.cp_cont_h_alpha85);
        this.ghU.wV(e.d.cp_cont_i);
        aEW();
        bmq();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        bmp();
        this.fTq = new g();
        this.fTq.aHc = 1000L;
        registerListener(this.fTU);
        registerListener(this.fTS);
        registerListener(this.fTT);
        this.ghR = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.ghR;
        userMuteAddAndDelCustomMessage.setTag(this.ghR);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        userMuteCheckCustomMessage.mId = this.ghR;
        userMuteCheckCustomMessage.setTag(this.ghR);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        this.ffd = new aj(getPageContext());
        this.ffd.a(new aj.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.36
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z) {
                    NewSubPbActivity.this.ffl.MP();
                }
            }
        });
        this.fSV = new com.baidu.tieba.pb.pb.report.a(this);
        this.fSV.o(getUniqueId());
        this.fSY = new com.baidu.tieba.pb.pb.main.b.a(this);
    }

    private void bmp() {
        if (this.ghH != null && this.ghF != null && this.ghF.bms()) {
            this.ghT = new com.baidu.tieba.pb.pb.sub.a(this, getListView(), this.ghH.abU());
            this.ghT.aFb();
            this.ghT.a(new a.InterfaceC0290a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.37
                private boolean dWp = false;

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0290a
                public void aEX() {
                    NewSubPbActivity.this.ghH.hg(false);
                    this.dWp = true;
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0290a
                public void aEY() {
                }

                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0290a
                public boolean aEZ() {
                    if (!this.dWp) {
                        return NewSubPbActivity.this.ghH.aFn() != null && NewSubPbActivity.this.ghH.aFn().getTop() == 0;
                    }
                    this.dWp = false;
                    return false;
                }
            });
            this.ghH.e(this.ghT);
            this.ghH.hg(true);
        }
    }

    public void initUI() {
        this.ghH = new b(this, this.mCommonClickListener);
        this.ghH.a(this.ghF);
        setContentView(this.ghH.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.ghH.setOnScrollListener(this.ghI);
        this.ghH.a(this);
        this.ghH.setOnLinkImageClickListener(this.ghJ);
        this.ghH.setOnImageClickListener(this.ghK);
        this.ghH.kz(true);
        this.ghH.setOnLongClickListener(this.aTo);
        this.ghH.c(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (NewSubPbActivity.this.ghF != null) {
                    NewSubPbActivity.this.ghF.Ow();
                }
            }
        });
        this.ghH.a(this.ghN);
        this.ghH.b(this.ghO);
        if (this.ghF != null && this.ghF.bms() && !this.ghF.bmY()) {
            this.ghH.bmE().setVisibility(8);
        } else {
            this.ghH.bmE().setVisibility(0);
        }
        if (this.ghF != null && !this.ghF.bms()) {
            this.ghH.setIsFromPb(false);
        }
    }

    private boolean H(Bundle bundle) {
        if (bundle != null) {
            this.aYF = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.aYF = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.aYF;
    }

    public void initData(Bundle bundle) {
        this.ghF = new SubPbModel(getPageContext());
        this.ghF.b(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.2
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void l(PostData postData) {
                NewSubPbActivity.this.ghH.n(postData);
                NewSubPbActivity.this.ghH.a((BdListView.e) null);
            }
        });
        this.ghG = new ForumManageModel(getPageContext());
        this.ghG.setLoadDataCallBack(this.ghM);
        this.dIc = new VoiceManager();
        this.dIc.onCreate(getPageContext());
        this.fSW = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.fSW != null) {
            this.fSW.a(this.fTZ);
        }
        if (bundle != null) {
            this.ghF.initWithBundle(bundle);
        } else {
            this.ghF.initWithIntent(getIntent());
        }
        this.ghF.a(this.ghL);
        if (this.ghF.bms()) {
            this.ghF.Ow();
        } else {
            this.ghF.bmS();
        }
    }

    public void bmq() {
        this.ghL = new SubPbModel.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.3
            @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.a
            public void a(boolean z, int i, String str, j jVar) {
                if (NewSubPbActivity.this.ghH != null) {
                    NewSubPbActivity.this.ghH.bmA();
                }
                if (NewSubPbActivity.this.ghT != null && NewSubPbActivity.this.ghT.aFc()) {
                    NewSubPbActivity.this.ghT.mO(e.d.cp_bg_line_k_alpha40);
                }
                if (!z) {
                    NewSubPbActivity.this.ae(i, str);
                    return;
                }
                NewSubPbActivity.this.ghH.hideNoDataView();
                if (jVar != null) {
                    if (jVar.bgQ() != null || NewSubPbActivity.this.ghF != null) {
                        jVar.bgQ().a(NewSubPbActivity.this.ghF.bmX());
                    }
                    if (NewSubPbActivity.this.ghH != null) {
                        NewSubPbActivity.this.ghH.a(jVar, NewSubPbActivity.this.ghF.bgv(), NewSubPbActivity.this.ghF.bmZ() != null);
                        if (NewSubPbActivity.this.ghQ) {
                            NewSubPbActivity.this.bmr();
                            NewSubPbActivity.this.ghQ = false;
                        }
                    }
                    if (NewSubPbActivity.this.ffl != null) {
                        NewSubPbActivity.this.ffl.a(jVar.azX());
                    }
                    if (NewSubPbActivity.this.ghV == null) {
                        NewSubPbActivity.this.ghV = new com.baidu.tieba.pb.d();
                    }
                    NewSubPbActivity.this.ghV.setData(jVar);
                    NewSubPbActivity.this.ghV.setType(0);
                    NewSubPbActivity.this.ffd.a(NewSubPbActivity.this.ghF.bnc());
                }
            }
        };
        this.fTZ = new a.InterfaceC0154a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.4
            @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0154a
            public void a(boolean z, boolean z2, String str) {
                if (z) {
                    if (NewSubPbActivity.this.fSW != null) {
                        NewSubPbActivity.this.fSW.aP(z2);
                    }
                    MarkData wt = NewSubPbActivity.this.fSW.wt();
                    com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                    dVar.setType(2);
                    if (z2) {
                        dVar.setData(wt);
                        if (NewSubPbActivity.this.fSW != null) {
                            if (wt != null) {
                                NewSubPbActivity.this.ghF.lN(true);
                                NewSubPbActivity.this.ghF.tr(NewSubPbActivity.this.ghF.Ms());
                                NewSubPbActivity.this.showToast(e.j.add_mark_on_pb);
                            } else {
                                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(e.j.add_mark));
                            }
                            if (NewSubPbActivity.this.ghH != null) {
                                NewSubPbActivity.this.ghH.lM(true);
                            }
                        }
                    } else {
                        dVar.setData(null);
                        NewSubPbActivity.this.ghF.lN(false);
                        NewSubPbActivity.this.ghF.tr(null);
                        NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(e.j.remove_mark));
                        if (NewSubPbActivity.this.ghH != null) {
                            NewSubPbActivity.this.ghH.lM(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
                    return;
                }
                NewSubPbActivity.this.showToast(NewSubPbActivity.this.getPageContext().getString(e.j.update_mark_failed));
            }
        };
        this.ghN = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.5
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (NewSubPbActivity.this.ghF.bmN() != null && NewSubPbActivity.this.ghF.bmN().ZR() != null && NewSubPbActivity.this.ghF.bmN().ZR().zG() != null) {
                    str = String.valueOf(NewSubPbActivity.this.ghF.bmN().ZR().zG().getUserId());
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
                NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), NewSubPbActivity.this.ghF.bmN().bgW().getId(), NewSubPbActivity.this.ghF.bmN().bgW().getName(), NewSubPbActivity.this.ghF.bmN().ZR().getId(), str, str4, str2, str5, str3)));
            }
        };
        this.ghO = new a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.6
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.a
            public void m(Object obj) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (!NewSubPbActivity.this.ghG.bEc() && objArr != null && objArr.length >= 4) {
                        String valueOf = String.valueOf(objArr[0]);
                        int l = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[1]), 0);
                        boolean g = com.baidu.adp.lib.g.b.g(String.valueOf(objArr[2]), false);
                        int l2 = com.baidu.adp.lib.g.b.l(String.valueOf(objArr[3]), 0);
                        if (NewSubPbActivity.this.ghF != null && NewSubPbActivity.this.ghF.bmN() != null && NewSubPbActivity.this.ghF.bmN().bgW() != null && NewSubPbActivity.this.ghF.bmN().ZR() != null) {
                            if (objArr.length > 4) {
                                NewSubPbActivity.this.ghG.vJ(String.valueOf(objArr[4]));
                            }
                            NewSubPbActivity.this.ghG.a(NewSubPbActivity.this.ghF.bmN().bgW().getId(), NewSubPbActivity.this.ghF.bmN().bgW().getName(), NewSubPbActivity.this.ghF.bmN().ZR().getId(), valueOf, l2, l, g);
                            return;
                        }
                        return;
                    }
                    return;
                }
                TbadkCoreApplication.getInst().login(NewSubPbActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) NewSubPbActivity.this.getPageContext().getPageActivity(), true, 11017)));
            }
        };
        this.ghM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.7
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj == null) {
                    NewSubPbActivity.this.ghH.a(NewSubPbActivity.this.ghG.getLoadDataMode(), false, (String) null, false);
                    return;
                }
                switch (NewSubPbActivity.this.ghG.getLoadDataMode()) {
                    case 0:
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        if (bVar.giK != 1002 || bVar.eni) {
                            z = true;
                        }
                        NewSubPbActivity.this.a(bVar, z);
                        return;
                    case 1:
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        NewSubPbActivity.this.ghH.a(1, dVar.HZ, dVar.hnI, true);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public boolean bv(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void aEW() {
        registerListener(this.dJl);
        this.mCommonClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.8
            /* JADX DEBUG: Multi-variable search result rejected for r2v48, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view != null || NewSubPbActivity.this.ghH != null) {
                    if (view == NewSubPbActivity.this.ghH.bmK()) {
                        NewSubPbActivity.this.ghH.bll();
                        String str = view.getTag(e.g.tag_user_id) instanceof String ? (String) view.getTag(e.g.tag_user_id) : null;
                        String str2 = view.getTag(e.g.tag_user_name) instanceof String ? (String) view.getTag(e.g.tag_user_name) : null;
                        String str3 = view.getTag(e.g.tag_virtual_user_url) instanceof String ? (String) view.getTag(e.g.tag_virtual_user_url) : null;
                        if (str3 != null) {
                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                ay.Ef().c(NewSubPbActivity.this.getPageContext(), new String[]{str3});
                            }
                        } else if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), str, str2, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                        }
                    } else if (view != NewSubPbActivity.this.ghH.aFo()) {
                        if (view != NewSubPbActivity.this.ghH.bmD()) {
                            if (view != NewSubPbActivity.this.ghH.bmC()) {
                                if (view == NewSubPbActivity.this.ghH.bmy()) {
                                    NewSubPbActivity.this.ghH.bll();
                                    if (NewSubPbActivity.this.ghF.Ow()) {
                                        NewSubPbActivity.this.ghH.bmw();
                                    }
                                } else if (view == NewSubPbActivity.this.ghH.bmE() || view == NewSubPbActivity.this.ghH.bmF() || view == NewSubPbActivity.this.ghH.bmH()) {
                                    if (NewSubPbActivity.this.ghS) {
                                        NewSubPbActivity.this.ghS = false;
                                        return;
                                    }
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(NewSubPbActivity.this.getActivity()).createNormalCfg(NewSubPbActivity.this.ghF.bjd(), NewSubPbActivity.this.ghF.Ms(), "");
                                    if (!StringUtils.isNull(NewSubPbActivity.this.ghF.getFromForumId())) {
                                        createNormalCfg.setForumId(NewSubPbActivity.this.ghF.getFromForumId());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                } else if (NewSubPbActivity.this.ghH.bmI() == null || view != NewSubPbActivity.this.ghH.bmI().bjP()) {
                                    if (NewSubPbActivity.this.ghH.bmI() == null || view != NewSubPbActivity.this.ghH.bmI().bjS()) {
                                        if (NewSubPbActivity.this.ghH.bmI() == null || view != NewSubPbActivity.this.ghH.bmI().bjQ()) {
                                            if (NewSubPbActivity.this.ghH.bmI() == null || view != NewSubPbActivity.this.ghH.bmI().bjR()) {
                                                if (NewSubPbActivity.this.ghH.bmI() == null || view != NewSubPbActivity.this.ghH.bmI().bjT()) {
                                                    if (view == NewSubPbActivity.this.ghH.bmB() || view == NewSubPbActivity.this.ghH.bmH()) {
                                                        if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                            if (NewSubPbActivity.this.ffl.MS()) {
                                                                NewSubPbActivity.this.ffl.MT();
                                                                return;
                                                            } else {
                                                                NewSubPbActivity.this.ffl.hU(null);
                                                                return;
                                                            }
                                                        }
                                                        return;
                                                    } else if (view == null || !(view.getTag() instanceof com.baidu.tieba.pb.pb.main.j)) {
                                                        if (NewSubPbActivity.this.fTd == null || view != NewSubPbActivity.this.fTd.bjR()) {
                                                            if (NewSubPbActivity.this.fTd == null || view != NewSubPbActivity.this.fTd.bjP()) {
                                                                if (NewSubPbActivity.this.fTd == null || view != NewSubPbActivity.this.fTd.bjS()) {
                                                                    if (NewSubPbActivity.this.fTd == null || view != NewSubPbActivity.this.fTd.bjT()) {
                                                                        if (NewSubPbActivity.this.fTd == null || view != NewSubPbActivity.this.fTd.bjV()) {
                                                                            if (NewSubPbActivity.this.fTd == null || view != NewSubPbActivity.this.fTd.bjW()) {
                                                                                if (NewSubPbActivity.this.fTd != null && view == NewSubPbActivity.this.fTd.bjQ()) {
                                                                                    if (!com.baidu.adp.lib.util.j.kV()) {
                                                                                        NewSubPbActivity.this.showToast(e.j.network_not_available);
                                                                                        return;
                                                                                    }
                                                                                    SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                                                                                    if (sparseArray != null) {
                                                                                        boolean booleanValue = ((Boolean) sparseArray.get(e.g.tag_should_manage_visible)).booleanValue();
                                                                                        boolean booleanValue2 = ((Boolean) sparseArray.get(e.g.tag_should_delete_visible)).booleanValue();
                                                                                        boolean booleanValue3 = ((Boolean) sparseArray.get(e.g.tag_user_mute_visible)).booleanValue();
                                                                                        if (booleanValue) {
                                                                                            if (booleanValue3) {
                                                                                                sparseArray.put(e.g.tag_from, 1);
                                                                                                sparseArray.put(e.g.tag_check_mute_from, 2);
                                                                                                NewSubPbActivity.this.b(sparseArray);
                                                                                                return;
                                                                                            }
                                                                                            sparseArray.put(e.g.tag_check_mute_from, 2);
                                                                                            NewSubPbActivity.this.ghH.bC(view);
                                                                                            return;
                                                                                        } else if (booleanValue2) {
                                                                                            NewSubPbActivity.this.ghH.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                                            return;
                                                                                        } else {
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                int id = view.getId();
                                                                                if (id == e.g.pb_item_tail_content) {
                                                                                    if (ba.bJ(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                        String string = TbadkCoreApplication.getInst().getString(e.j.tail_web_view_title);
                                                                                        String string2 = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("tail_link", "");
                                                                                        if (!StringUtils.isNull(string2)) {
                                                                                            TiebaStatic.log("c10056");
                                                                                            com.baidu.tbadk.browser.a.a(view.getContext(), string, string2, true, true, true);
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else if (id == e.g.richText && (view.getTag() instanceof SparseArray)) {
                                                                                    Object obj = ((SparseArray) view.getTag()).get(e.g.tag_clip_board);
                                                                                    if (obj instanceof PostData) {
                                                                                        PostData postData = (PostData) obj;
                                                                                        if (postData.getType() != PostData.hlo && !TextUtils.isEmpty(postData.getBimg_url()) && i.xE().xI()) {
                                                                                            NewSubPbActivity.this.to(postData.getId());
                                                                                            return;
                                                                                        }
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (NewSubPbActivity.this.fTu != null && !TextUtils.isEmpty(NewSubPbActivity.this.fTv)) {
                                                                                if (NewSubPbActivity.this.bzf == null) {
                                                                                    NewSubPbActivity.this.bzf = new com.baidu.tbadk.core.util.b.a();
                                                                                }
                                                                                NewSubPbActivity.this.bzf.Et();
                                                                                NewSubPbActivity.this.bzf.c(NewSubPbActivity.this.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (!NewSubPbActivity.this.bzf.A(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                                                    if (NewSubPbActivity.this.fTt == null) {
                                                                                        NewSubPbActivity.this.fTt = new av(NewSubPbActivity.this.getPageContext());
                                                                                    }
                                                                                    NewSubPbActivity.this.fTt.i(NewSubPbActivity.this.fTv, NewSubPbActivity.this.fTu.os());
                                                                                    NewSubPbActivity.this.fTu = null;
                                                                                    NewSubPbActivity.this.fTv = null;
                                                                                    return;
                                                                                }
                                                                                return;
                                                                            } else {
                                                                                return;
                                                                            }
                                                                        } else if (NewSubPbActivity.this.fTu != null && !TextUtils.isEmpty(NewSubPbActivity.this.fTv)) {
                                                                            if (NewSubPbActivity.this.fTw == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, NewSubPbActivity.this.fTv));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.url = NewSubPbActivity.this.fTv;
                                                                                aVar.pkgId = NewSubPbActivity.this.fTw.memeInfo.pck_id.intValue() < 0 ? "" : "" + NewSubPbActivity.this.fTw.memeInfo.pck_id;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            NewSubPbActivity.this.fTu = null;
                                                                            NewSubPbActivity.this.fTv = null;
                                                                            return;
                                                                        } else {
                                                                            return;
                                                                        }
                                                                    } else if (NewSubPbActivity.this.fUe != null) {
                                                                        NewSubPbActivity.this.fUe.cZ(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                                        NewSubPbActivity.this.fUe = null;
                                                                        return;
                                                                    } else {
                                                                        return;
                                                                    }
                                                                }
                                                                SparseArray sparseArray2 = (SparseArray) view.getTag();
                                                                if (sparseArray2 != null && (sparseArray2.get(e.g.tag_del_post_type) instanceof Integer) && (sparseArray2.get(e.g.tag_del_post_id) instanceof String) && (sparseArray2.get(e.g.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(e.g.tag_del_post_is_self) instanceof Boolean)) {
                                                                    NewSubPbActivity.this.ghH.a(((Integer) sparseArray2.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray2.get(e.g.tag_del_post_id), ((Integer) sparseArray2.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(e.g.tag_del_post_is_self)).booleanValue());
                                                                    return;
                                                                }
                                                                return;
                                                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                                NewSubPbActivity.this.bu(view);
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (!com.baidu.adp.lib.util.j.kV()) {
                                                            NewSubPbActivity.this.showToast(e.j.network_not_available);
                                                            return;
                                                        } else {
                                                            Object tag = view.getTag();
                                                            if (tag instanceof String) {
                                                                NewSubPbActivity.this.sQ((String) tag);
                                                                return;
                                                            } else if (tag instanceof SparseArray) {
                                                                SparseArray<Object> sparseArray3 = (SparseArray) tag;
                                                                if ((sparseArray3.get(e.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray3.get(e.g.tag_user_mute_visible)).booleanValue()) {
                                                                    sparseArray3.put(e.g.tag_from, 0);
                                                                    sparseArray3.put(e.g.tag_check_mute_from, 2);
                                                                    NewSubPbActivity.this.b(sparseArray3);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    } else if (ba.bJ(NewSubPbActivity.this.getPageContext().getPageActivity())) {
                                                        if (NewSubPbActivity.this.ghS) {
                                                            NewSubPbActivity.this.ghS = false;
                                                            return;
                                                        } else if (NewSubPbActivity.this.ffd == null || NewSubPbActivity.this.ghF == null || NewSubPbActivity.this.ghF.azX() == null || NewSubPbActivity.this.ffd.dK(NewSubPbActivity.this.ghF.azX().replyPrivateFlag)) {
                                                            if (NewSubPbActivity.this.ghT != null) {
                                                                NewSubPbActivity.this.ghT.aFa();
                                                            }
                                                            SparseArray sparseArray4 = (SparseArray) view.getTag(e.g.tag_from);
                                                            if (sparseArray4 != null && (sparseArray4.get(e.g.tag_clip_board) instanceof PostData)) {
                                                                PostData postData2 = (PostData) sparseArray4.get(e.g.tag_clip_board);
                                                                if (postData2 != null && postData2.zG() != null) {
                                                                    MetaData zG = postData2.zG();
                                                                    NewSubPbActivity.this.ffl.setReplyId(zG.getUserId());
                                                                    if (!(sparseArray4.get(e.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray4.get(e.g.tag_is_subpb)).booleanValue() : true)) {
                                                                        NewSubPbActivity.this.ffl.hX("");
                                                                    } else {
                                                                        NewSubPbActivity.this.ffl.hX(zG.getName_show());
                                                                    }
                                                                }
                                                                NewSubPbActivity.this.ghH.bmu();
                                                                return;
                                                            }
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    } else {
                                                        return;
                                                    }
                                                } else if (view.getTag() != null && (view.getTag() instanceof SparseArray)) {
                                                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                                                    if (sparseArray5.get(e.g.tag_clip_board) instanceof PostData) {
                                                        ((PostData) sparseArray5.get(e.g.tag_clip_board)).cZ(NewSubPbActivity.this.getPageContext().getPageActivity());
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                            TiebaStatic.log(new am("c11739").x("obj_locate", 4));
                                            if (!com.baidu.adp.lib.util.j.kV()) {
                                                NewSubPbActivity.this.showToast(e.j.network_not_available);
                                                return;
                                            }
                                            Object tag2 = view.getTag();
                                            NewSubPbActivity.this.ghH.bll();
                                            if (tag2 instanceof String) {
                                                String str4 = (String) tag2;
                                                if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                    NewSubPbActivity.this.sQ(str4);
                                                    return;
                                                }
                                                return;
                                            } else if (tag2 instanceof SparseArray) {
                                                SparseArray<Object> sparseArray6 = (SparseArray) tag2;
                                                if ((sparseArray6.get(e.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray6.get(e.g.tag_user_mute_visible)).booleanValue()) {
                                                    sparseArray6.put(e.g.tag_from, 0);
                                                    sparseArray6.put(e.g.tag_check_mute_from, 2);
                                                    NewSubPbActivity.this.b(sparseArray6);
                                                    return;
                                                }
                                                return;
                                            } else {
                                                return;
                                            }
                                        } else if (com.baidu.adp.lib.util.j.kV()) {
                                            NewSubPbActivity.this.ghH.bll();
                                            if (NewSubPbActivity.this.checkUpIsLogin()) {
                                                NewSubPbActivity.this.bG(view);
                                                return;
                                            }
                                            return;
                                        } else {
                                            NewSubPbActivity.this.showToast(e.j.network_not_available);
                                            return;
                                        }
                                    }
                                    NewSubPbActivity.this.ghH.bll();
                                    SparseArray sparseArray7 = (SparseArray) view.getTag();
                                    if (sparseArray7 != null) {
                                        NewSubPbActivity.this.ghH.a(((Integer) sparseArray7.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray7.get(e.g.tag_del_post_id), ((Integer) sparseArray7.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray7.get(e.g.tag_del_post_is_self)).booleanValue());
                                    }
                                } else {
                                    TiebaStatic.log(new am("c11739").x("obj_locate", 2));
                                    NewSubPbActivity.this.ghH.bll();
                                    if (NewSubPbActivity.this.checkUpIsLogin() && NewSubPbActivity.this.ghF.bmN() != null) {
                                        NewSubPbActivity.this.f(NewSubPbActivity.this.ghF.bmN().bgQ());
                                    }
                                }
                            } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                                NewSubPbActivity.this.ghH.bmt();
                                NewSubPbActivity.this.ghH.bmu();
                                if (NewSubPbActivity.this.ffl != null) {
                                    NewSubPbActivity.this.ffl.MV();
                                    if (NewSubPbActivity.this.ghT != null) {
                                        NewSubPbActivity.this.ghT.aFa();
                                    }
                                }
                            }
                        } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                            NewSubPbActivity.this.ghH.bmt();
                            NewSubPbActivity.this.ghH.bmu();
                            if (NewSubPbActivity.this.ffl != null) {
                                NewSubPbActivity.this.ffl.MU();
                                if (NewSubPbActivity.this.ghT != null) {
                                    NewSubPbActivity.this.ghT.aFa();
                                }
                            }
                        }
                    } else if (NewSubPbActivity.this.checkUpIsLogin()) {
                        if (NewSubPbActivity.this.ffd == null || NewSubPbActivity.this.ghF == null || NewSubPbActivity.this.ghF.azX() == null || NewSubPbActivity.this.ffd.dK(NewSubPbActivity.this.ghF.azX().replyPrivateFlag)) {
                            if (NewSubPbActivity.this.ffl.MK()) {
                                NewSubPbActivity.this.ffl.a((PostWriteCallBackData) null);
                                return;
                            }
                            NewSubPbActivity.this.ghH.bmt();
                            NewSubPbActivity.this.ghH.bmu();
                            if (NewSubPbActivity.this.ffl != null) {
                                NewSubPbActivity.this.ffl.MW();
                                if (NewSubPbActivity.this.ghT != null) {
                                    NewSubPbActivity.this.ghT.aFa();
                                }
                            }
                        }
                    }
                }
            }
        };
        this.ghI = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2 || i == 1) {
                    NewSubPbActivity.this.ghH.bll();
                }
                NewSubPbActivity.this.ffl.MT();
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                NewSubPbActivity.this.ghH.bmJ();
            }
        };
        this.fUf = new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.10
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
            public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                bVar.dismiss();
                PostData postData = null;
                if (NewSubPbActivity.this.ghF.bmN() != null) {
                    postData = NewSubPbActivity.this.ghF.bmN().bgQ();
                }
                if (postData != null) {
                    if (i == 0) {
                        postData.cZ(NewSubPbActivity.this.getPageContext().getPageActivity());
                    } else if (i == 1) {
                        NewSubPbActivity.this.f(postData);
                    }
                }
            }
        };
        this.aTo = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.11
            /* JADX WARN: Removed duplicated region for block: B:111:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
            /* JADX WARN: Removed duplicated region for block: B:92:0x02a3  */
            @Override // android.view.View.OnLongClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onLongClick(View view) {
                SparseArray<Object> sparseArray;
                SparseArray<Object> sparseArray2;
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null && NewSubPbActivity.this.bv(view)) {
                    if (view instanceof TbImageView) {
                        NewSubPbActivity.this.fTu = ((TbImageView) view).getBdImage();
                        NewSubPbActivity.this.fTv = ((TbImageView) view).getUrl();
                        if (NewSubPbActivity.this.fTu != null && !TextUtils.isEmpty(NewSubPbActivity.this.fTv)) {
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.fTw = null;
                            } else {
                                NewSubPbActivity.this.fTw = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                            if (!(view.getParent() instanceof TbRichTextView)) {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                                } catch (ClassCastException e2) {
                                    e2.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                                NewSubPbActivity.this.ghH.a(NewSubPbActivity.this.fUg, NewSubPbActivity.this.fTu.isGif());
                            } else {
                                try {
                                    sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                                } catch (ClassCastException e3) {
                                    e3.printStackTrace();
                                    sparseArray2 = sparseArray;
                                }
                            }
                            if (sparseArray2 != null) {
                                NewSubPbActivity.this.fUe = (PostData) sparseArray2.get(e.g.tag_clip_board);
                                if (NewSubPbActivity.this.fUe != null && NewSubPbActivity.this.fSW != null) {
                                    if (NewSubPbActivity.this.fSW != null) {
                                        NewSubPbActivity.this.fSW.aP(NewSubPbActivity.this.ghF.isMarked());
                                    }
                                    boolean z = NewSubPbActivity.this.fSW.wq() && NewSubPbActivity.this.fUe.getId() != null && NewSubPbActivity.this.fUe.getId().equals(NewSubPbActivity.this.ghF.bmU());
                                    if (NewSubPbActivity.this.fTd == null) {
                                        NewSubPbActivity.this.fTd = new y(NewSubPbActivity.this.getPageContext(), NewSubPbActivity.this.mCommonClickListener);
                                        NewSubPbActivity.this.ghH.bE(NewSubPbActivity.this.fTd.getView());
                                        NewSubPbActivity.this.fTd.kY(NewSubPbActivity.this.mIsLogin);
                                    }
                                    NewSubPbActivity.this.fTd.showDialog();
                                    boolean isLogin = NewSubPbActivity.this.isLogin() & NewSubPbActivity.this.kG(sparseArray2.get(e.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(e.g.tag_del_post_is_self)).booleanValue() : false);
                                    boolean booleanValue = sparseArray2.get(e.g.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(e.g.tag_is_subpb)).booleanValue() : false;
                                    if (z) {
                                        NewSubPbActivity.this.fTd.bjP().setText(e.j.remove_mark);
                                    } else {
                                        NewSubPbActivity.this.fTd.bjP().setText(e.j.mark);
                                    }
                                    if (booleanValue) {
                                        NewSubPbActivity.this.fTd.bjP().setVisibility(8);
                                    } else {
                                        NewSubPbActivity.this.fTd.bjP().setVisibility(0);
                                    }
                                    if (NewSubPbActivity.this.bv(view)) {
                                        if (NewSubPbActivity.this.fTu != null && !NewSubPbActivity.this.fTu.isGif()) {
                                            sparseArray2.put(e.g.tag_richtext_image, true);
                                        } else {
                                            sparseArray2.put(e.g.tag_richtext_image, false);
                                        }
                                        sparseArray2.put(e.g.tag_richtext_emotion, true);
                                    } else {
                                        sparseArray2.put(e.g.tag_richtext_image, false);
                                        sparseArray2.put(e.g.tag_richtext_emotion, false);
                                    }
                                    NewSubPbActivity.this.fTd.a(sparseArray2, NewSubPbActivity.this.bgv(), isLogin);
                                    NewSubPbActivity.this.fTd.refreshUI();
                                }
                            }
                        }
                        return true;
                    }
                    if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            NewSubPbActivity.this.fTu = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                NewSubPbActivity.this.fTv = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                NewSubPbActivity.this.fTw = null;
                            } else {
                                NewSubPbActivity.this.fTw = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                            }
                        }
                        return true;
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        NewSubPbActivity.this.fTu = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            NewSubPbActivity.this.fTv = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            NewSubPbActivity.this.fTw = null;
                        } else {
                            NewSubPbActivity.this.fTw = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                        }
                    }
                    if (!(view.getParent() instanceof TbRichTextView)) {
                    }
                    if (sparseArray2 != null) {
                    }
                    return true;
                }
                sparseArray2 = sparseArray;
                if (sparseArray2 != null) {
                }
                return true;
            }
        };
        this.ghJ = new TbRichTextView.i() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.13
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.i
            public void e(View view, String str) {
                NewSubPbActivity.this.l(null, str, "LINK_IMAGE");
            }
        };
        this.ghK = new TbRichTextView.h() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.14
            /* JADX DEBUG: Multi-variable search result rejected for r2v19, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
            /* JADX DEBUG: Multi-variable search result rejected for r2v44, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.widget.richText.TbRichTextView.h
            public void a(View view, String str, int i, boolean z) {
                String str2;
                boolean z2;
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap;
                int i2;
                boolean z3;
                ArrayList<String> arrayList;
                String str3;
                boolean z4;
                ConcurrentHashMap<String, ImageUrlData> concurrentHashMap2;
                boolean z5;
                try {
                    if (view.getTag(e.g.tag_rich_text_meme_info) == null || !(view.getTag(e.g.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                        j bmN = NewSubPbActivity.this.ghF.bmN();
                        TbRichText aL = NewSubPbActivity.this.aL(str, i);
                        TbRichTextData tbRichTextData = null;
                        if (aL != null && aL.RZ() != null) {
                            tbRichTextData = aL.RZ().get(NewSubPbActivity.this.fUc);
                        }
                        if (tbRichTextData != null) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            ConcurrentHashMap<String, ImageUrlData> concurrentHashMap3 = new ConcurrentHashMap<>();
                            if (!tbRichTextData.Sf().Sr()) {
                                String b = NewSubPbActivity.this.b(tbRichTextData);
                                arrayList2.add(b);
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = str;
                                imageUrlData.urlType = NewSubPbActivity.this.mIsFromCDN ? 17 : 18;
                                concurrentHashMap3.put(b, imageUrlData);
                                String str4 = null;
                                String str5 = null;
                                String str6 = null;
                                if (bmN == null) {
                                    str3 = null;
                                    z4 = false;
                                } else {
                                    if (bmN.bgW() != null) {
                                        str4 = bmN.bgW().getName();
                                        str5 = bmN.bgW().getId();
                                    }
                                    if (bmN.ZR() != null) {
                                        str6 = bmN.ZR().getId();
                                    }
                                    str3 = str6;
                                    z4 = true;
                                }
                                if (NewSubPbActivity.this.ghF.bmZ() != null) {
                                    concurrentHashMap2 = NewSubPbActivity.this.ghF.bmZ();
                                    z5 = NewSubPbActivity.this.ghF.bnb();
                                    arrayList2 = NewSubPbActivity.this.ghF.bna();
                                } else {
                                    concurrentHashMap2 = concurrentHashMap3;
                                    z5 = z4;
                                }
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(v.d(arrayList2, 0));
                                NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList3, 0, str4, str5, str3, z5, arrayList2.get(0), true, concurrentHashMap2, true, false, false)));
                                return;
                            }
                            NewSubPbActivity.this.fUd = false;
                            String str7 = "";
                            TbRichText bDt = bmN.bgQ().bDt();
                            int size = arrayList2.size();
                            int a2 = NewSubPbActivity.this.a(bDt, aL, i, i, arrayList2, concurrentHashMap3);
                            int size2 = arrayList2.size();
                            if (size != size2) {
                                str7 = arrayList2.get(size2 - 1);
                            }
                            String str8 = null;
                            String str9 = null;
                            String str10 = null;
                            if (bmN == null) {
                                str2 = null;
                                z2 = false;
                            } else {
                                if (bmN.bgW() != null) {
                                    str8 = bmN.bgW().getName();
                                    str9 = bmN.bgW().getId();
                                }
                                if (bmN.ZR() != null) {
                                    str10 = bmN.ZR().getId();
                                }
                                str2 = str10;
                                z2 = true;
                            }
                            if (NewSubPbActivity.this.ghF.bmZ() != null) {
                                concurrentHashMap = NewSubPbActivity.this.ghF.bmZ();
                                z3 = NewSubPbActivity.this.ghF.bnb();
                                arrayList = NewSubPbActivity.this.ghF.bna();
                                i2 = a2 + NewSubPbActivity.this.ghF.getOffset();
                            } else {
                                concurrentHashMap = concurrentHashMap3;
                                i2 = a2;
                                z3 = z2;
                                arrayList = arrayList2;
                            }
                            ArrayList arrayList4 = new ArrayList();
                            arrayList4.add(v.d(arrayList, i2));
                            NewSubPbActivity.this.sendMessage(new CustomMessage(2010000, new ImageViewerConfig(NewSubPbActivity.this.getPageContext().getPageActivity()).createConfig(arrayList4, 0, str8, str9, str2, z3, str7, true, concurrentHashMap, true, false, false)));
                            return;
                        }
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(e.g.tag_rich_text_meme_info);
                    boolean isGif = ((TbImageView) view).isGif();
                    if (tbRichTextMemeInfo != null && tbRichTextMemeInfo.memeInfo != null) {
                        NewSubPbActivity.this.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(NewSubPbActivity.this.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                    }
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(e.g.tag_clip_board)) != null) {
            f(postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo Sf;
        if (tbRichText == tbRichText2) {
            this.fUd = true;
        }
        if (tbRichText != null && tbRichText.RZ() != null) {
            int size = tbRichText.RZ().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.RZ().get(i6) != null && tbRichText.RZ().get(i6).getType() == 8) {
                    i5++;
                    int aR = (int) l.aR(TbadkCoreApplication.getInst());
                    int width = tbRichText.RZ().get(i6).Sf().getWidth() * aR;
                    int height = tbRichText.RZ().get(i6).Sf().getHeight() * aR;
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.RZ().get(i6).Sf().Sr()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.RZ().get(i6);
                        String b = b(tbRichTextData);
                        arrayList.add(b);
                        if (!TextUtils.isEmpty(b) && tbRichTextData != null && (Sf = tbRichTextData.Sf()) != null) {
                            String Su = Sf.Su();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Su;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(b, imageUrlData);
                            }
                        }
                        if (!this.fUd) {
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
        if (this.fTd != null) {
            this.fTd.kY(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo Sf = tbRichTextData.Sf();
        if (Sf != null) {
            if (!StringUtils.isNull(Sf.Sq())) {
                return Sf.Sq();
            }
            if (Sf.getHeight() * Sf.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Sf.getHeight() * Sf.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Sf.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Sf.getHeight())));
            } else {
                float width = Sf.getWidth() / Sf.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ao.bx(Sf.Ss()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText aL(String str, int i) {
        if (this.ghF == null || this.ghF.bmN() == null || str == null || i < 0) {
            return null;
        }
        j bmN = this.ghF.bmN();
        TbRichText a2 = a(bmN.bgQ(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(bmN.bgQ(), str, i);
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
        TbRichText bDt = postData.bDt();
        if (bDt != null) {
            ArrayList<TbRichTextData> RZ = bDt.RZ();
            int size = RZ.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (RZ.get(i3) != null && RZ.get(i3).getType() == 8) {
                    i2++;
                    if (RZ.get(i3).Sf().Su().equals(str)) {
                        int aR = (int) l.aR(TbadkCoreApplication.getInst());
                        int width = RZ.get(i3).Sf().getWidth() * aR;
                        int height = RZ.get(i3).Sf().getHeight() * aR;
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.fUc = i3;
                        return bDt;
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
    public boolean kG(boolean z) {
        if (this.ghF == null) {
            return false;
        }
        return ((bgv() != 0) || this.ghF.bmN() == null || this.ghF.bmN().ZR() == null || this.ghF.bmN().ZR().zG() == null || TextUtils.equals(this.ghF.bmN().ZR().zG().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Context context, String str, String str2) {
        long templateId = this.ghF.bmN().bgQ().bDA() != null ? this.ghF.bmN().bgQ().bDA().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && ay.Ef().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.ghF.bmN().bgW().getId(), this.ghF.bmN().bgW().getName(), this.ghF.bmN().ZR().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ae(int i, String str) {
        if (this.ghF.bmO()) {
            showToast(str);
        } else if (l.ll()) {
            if (i == 4) {
                this.ghH.oo(str + "(4)");
            } else {
                this.ghH.jX(e.j.no_data_text);
            }
        } else {
            this.ghH.jX(e.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.ffl = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().bM(getActivity());
        if (this.ffl != null) {
            this.ffl.setContext(getPageContext());
            this.ffl.b(this.ghF);
            this.ffl.b(this.ghW);
            this.ffl.a(this.aZY);
            this.ffl.a(this.aZZ);
            this.ffl.LX().cq(true);
            this.ffl.d(getPageContext());
        }
        if (this.ghH != null) {
            this.ghH.g(this.ffl);
        }
        if (this.ffl != null && this.ghF != null) {
            this.ffl.a(this.ghF.azX());
            this.ffl.MT();
        }
        if (this.ffl != null) {
            this.geQ = this.ffl.MX().getInputView();
            this.geQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.16
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    if (NewSubPbActivity.this.ghU != null) {
                        if (!NewSubPbActivity.this.ghU.bMX()) {
                            NewSubPbActivity.this.lL(false);
                        }
                        NewSubPbActivity.this.ghU.or(false);
                    }
                }
            });
        }
    }

    public void bmr() {
        if (!TbadkCoreApplication.isLogin()) {
            this.ffl.MT();
        } else if (!StringUtils.isNull(this.ghF.bmV())) {
            if (this.ghH.bmx() && l.ll()) {
                this.ghH.axf();
            } else {
                this.ghH.bmA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bG(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(e.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(e.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(e.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(e.g.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(e.g.tag_from, 1);
                    b(sparseArray);
                } else {
                    this.ghH.bC(view);
                }
            } else if (booleanValue2) {
                this.ghH.a(((Integer) sparseArray.get(e.g.tag_del_post_type)).intValue(), (String) sparseArray.get(e.g.tag_del_post_id), ((Integer) sparseArray.get(e.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(e.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.g.a(this.ghH.bmG(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        final String str;
        if (!(sparseArray.get(e.g.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(e.g.tag_user_mute_mute_userid);
        }
        if (((Boolean) sparseArray.get(e.g.tag_user_mute_visible)).booleanValue()) {
            String[] strArr = new String[1];
            strArr[0] = z ? getResources().getString(e.j.un_mute) : getResources().getString(e.j.mute);
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            bVar.de(e.j.operation);
            bVar.a(strArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.17
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    switch (i) {
                        case 0:
                            String str2 = "";
                            String str3 = "";
                            String str4 = "";
                            String str5 = "";
                            String str6 = "";
                            if (sparseArray.get(e.g.tag_user_mute_mute_username) instanceof String) {
                                str2 = (String) sparseArray.get(e.g.tag_user_mute_mute_username);
                            }
                            if (sparseArray.get(e.g.tag_user_mute_thread_id) instanceof String) {
                                str3 = (String) sparseArray.get(e.g.tag_user_mute_thread_id);
                            }
                            if (sparseArray.get(e.g.tag_user_mute_post_id) instanceof String) {
                                str4 = (String) sparseArray.get(e.g.tag_user_mute_post_id);
                            }
                            if (sparseArray.get(e.g.tag_user_mute_msg) instanceof String) {
                                str5 = (String) sparseArray.get(e.g.tag_user_mute_msg);
                            }
                            if (sparseArray.get(e.g.tag_user_mute_mute_nameshow) instanceof String) {
                                str6 = (String) sparseArray.get(e.g.tag_user_mute_mute_nameshow);
                            }
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, NewSubPbActivity.this.ghR);
                            userMuteAddAndDelCustomMessage.setTag(NewSubPbActivity.this.ghR);
                            NewSubPbActivity.this.a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
                            break;
                    }
                    bVar2.dismiss();
                }
            });
            bVar.d(getPageContext()).BI();
        }
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(e.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(e.g.tag_user_mute_mute_userid);
        }
        this.ghH.showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.d(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.d(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.ghR;
        userMuteCheckCustomMessage.setTag(this.ghR);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        int i = 0;
        if (bVar != null) {
            this.ghH.a(0, bVar.HZ, bVar.hnI, z);
            if (bVar.HZ) {
                if (bVar.hnG == 1) {
                    if (this.ghH.getListView() instanceof BdTypeListView) {
                        List<com.baidu.adp.widget.ListView.h> data = ((BdTypeListView) this.ghH.getListView()).getData();
                        if (!v.I(data)) {
                            while (i < data.size() && (!(data.get(i) instanceof PostData) || !bVar.mPostId.equals(((PostData) data.get(i)).getId()))) {
                                i++;
                            }
                            data.remove(i);
                            this.ghH.notifyDataSetChanged();
                        }
                    }
                } else if (bVar.hnG == 2) {
                    this.ghF.tq(bVar.mPostId);
                    this.ghH.a(this.ghF.bmN(), this.ghF.bgv(), this.ghF.bmZ() != null);
                    if (this.ghF.bmW()) {
                        this.ghF.lO(false);
                        this.ghH.bmv();
                        this.ghF.Ow();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, dVar));
            }
        }
    }

    public void sQ(String str) {
        this.fSV.tm(str);
    }

    public void f(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.ghF.isMarked() && postData.getId() != null && postData.getId().equals(this.ghF.bmU())) {
                z = true;
            }
            MarkData h = this.ghF.h(postData);
            if (h != null) {
                this.ghH.bll();
                if (this.fSW != null) {
                    this.fSW.a(h);
                    if (!z) {
                        this.fSW.ws();
                    } else {
                        this.fSW.wr();
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.ghF != null) {
            this.ghF.G(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 25035) {
            d(i2, intent);
        }
        if (this.ffl != null) {
            this.ffl.onActivityResult(i, i2, intent);
        }
    }

    private void d(int i, Intent intent) {
        this.ffl.LX().Kw();
        this.ffl.MT();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.ffl.b(writeData);
                this.ffl.setVoiceModel(pbEditorData.getVoiceModel());
                k fK = this.ffl.LX().fK(6);
                if (fK != null && fK.aYi != null) {
                    fK.aYi.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.ffl.MP();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.dIc != null) {
            this.dIc.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.ghP = true;
        super.onPause();
        if (this.dIc != null) {
            this.dIc.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.eJa);
        this.ghH.aEa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.ghP = false;
        super.onResume();
        if (this.dIc != null) {
            this.dIc.onResume(getPageContext());
        }
        registerListener(this.eJa);
        this.ghH.aEb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.dIc != null) {
            this.dIc.onStop(getPageContext());
        }
        this.ffl.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.ghV));
        this.ghF.cancelLoadData();
        this.ghF.destory();
        this.ghG.cancelLoadData();
        if (this.dIc != null) {
            this.dIc.onDestory(getPageContext());
        }
        this.ghH.bll();
        this.ghH.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.fTS);
        MessageManager.getInstance().unRegisterListener(this.fTT);
        MessageManager.getInstance().unRegisterListener(this.fTU);
        MessageManager.getInstance().unRegisterListener(this.ghR);
        this.fTp = null;
        this.fTq = null;
        if (this.dIO != null) {
            this.dIO.onDestroy();
        }
        if (this.ffd != null) {
            this.ffd.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ghH.onChangeSkinType(i);
        if (this.dIO != null) {
            this.dIO.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.dIc;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View bmB = this.ghH.bmB();
        if (bmB == null || (findViewWithTag = bmB.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean tf(String str) {
        Map<String, String> fN;
        if (!TextUtils.isEmpty(str) && (fN = ay.fN(ay.fO(str))) != null) {
            this.ghS = true;
            String str2 = fN.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return tf(com.baidu.adp.lib.util.k.by(str2));
            }
            String str3 = fN.get(ghE);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void e(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (tf(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            if (z) {
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.tbadk.data.i iVar = new com.baidu.tbadk.data.i();
                    iVar.mLink = str;
                    iVar.type = 3;
                    iVar.aXm = "2";
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, iVar));
                }
            } else {
                ay.Ef().c(getPageContext(), new String[]{str});
            }
            this.ghS = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void an(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.ghS = true;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ao(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ap(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void aq(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void i(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public ListView getListView() {
        if (this.ghH != null) {
            return this.ghH.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public int SG() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<TextView> SI() {
        if (this.brE == null) {
            this.brE = TbRichTextView.n(getPageContext().getPageActivity(), 8);
        }
        return this.brE;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<GifView> SJ() {
        if (this.brI == null) {
            this.brI = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<GifView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.19
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bit */
                public GifView jz() {
                    return new GifView(NewSubPbActivity.this.getPageContext().getPageActivity());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: g */
                public void u(GifView gifView) {
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: h */
                public GifView v(GifView gifView) {
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: i */
                public GifView w(GifView gifView) {
                    return gifView;
                }
            }, 20, 0);
        }
        return this.brI;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<ImageView> SH() {
        if (this.brD == null) {
            this.brD = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<ImageView>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.20
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: alU */
                public ImageView jz() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(NewSubPbActivity.this.getPageContext().getPageActivity());
                    boolean xI = i.xE().xI();
                    foreDrawableImageView.setDefaultBg(al.getDrawable(e.d.common_color_10220));
                    if (xI) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(e.f.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: c */
                public void u(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(e.d.cp_bg_line_c);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: b */
                public ImageView v(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (i.xE().xI()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(e.f.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public ImageView w(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(e.d.cp_bg_line_c);
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.brD;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<View> SK() {
        if (this.brF == null) {
            this.brF = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<View>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.21
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: biu */
                public View jz() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(NewSubPbActivity.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setPlayTimeTextView(e.C0210e.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bx */
                public void u(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: by */
                public View v(View view) {
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: bz */
                public View w(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.brF;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<LinearLayout> SL() {
        if (this.brG == null) {
            this.brG = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<LinearLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.22
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: biw */
                public LinearLayout jz() {
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
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: d */
                public void u(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: e */
                public LinearLayout v(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.e.c
                /* renamed from: f */
                public LinearLayout w(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.brG;
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public com.baidu.adp.lib.e.b<RelativeLayout> SM() {
        this.brH = new com.baidu.adp.lib.e.b<>(new com.baidu.adp.lib.e.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: biv */
            public RelativeLayout jz() {
                return new RelativeLayout(NewSubPbActivity.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: c */
            public void u(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: d */
            public RelativeLayout v(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.e.c
            /* renamed from: e */
            public RelativeLayout w(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.brH;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public com.baidu.tieba.pb.pb.main.b.a bhc() {
        return this.fSY;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean bhd() {
        return (this.ghF == null || this.ghF.bmN() == null || this.ghF.bmN().ZR() == null || this.ghF.bmN().ZR().AR()) ? false : true;
    }

    @Override // com.baidu.tieba.pb.pb.a
    public String bhe() {
        if (this.ghF == null || this.ghF.bmN() == null || this.ghF.bmN().ZR() == null) {
            return null;
        }
        return this.ghF.bmN().ZR().zM();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public int bhf() {
        if (this.ghF == null) {
            return 0;
        }
        return this.ghF.bgv();
    }

    @Override // com.baidu.tieba.pb.pb.a
    public boolean sN(String str) {
        if (StringUtils.isNull(str) || this.ghF == null || this.ghF.bmN() == null || this.ghF.bmN().ZR() == null || this.ghF.bmN().ZR().zG() == null) {
            return false;
        }
        return str.equals(this.ghF.bmN().ZR().zG().getUserId());
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.ghH.bmx() && l.ll()) {
            this.ghF.Ow();
        } else {
            this.ghH.bmA();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (sparseArray.get(e.g.tag_user_mute_mute_username) instanceof String) {
            str3 = (String) sparseArray.get(e.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(e.g.tag_user_mute_thread_id) instanceof String) {
            str4 = (String) sparseArray.get(e.g.tag_user_mute_thread_id);
        }
        if (!(sparseArray.get(e.g.tag_user_mute_post_id) instanceof String)) {
            str2 = "";
        } else {
            str2 = (String) sparseArray.get(e.g.tag_user_mute_post_id);
        }
        String str7 = sparseArray.get(e.g.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(e.g.tag_user_mute_msg) : str2;
        if (sparseArray.get(e.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(e.g.tag_user_mute_msg);
        }
        if (sparseArray.get(e.g.tag_user_mute_mute_nameshow) instanceof String) {
            str6 = (String) sparseArray.get(e.g.tag_user_mute_mute_nameshow);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str7, 1, str5, this.ghR);
        userMuteAddAndDelCustomMessage.setTag(this.ghR);
        a(z, userMuteAddAndDelCustomMessage, str5, str3, str6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void to(String str) {
        if (!StringUtils.isNull(str) && ba.bJ(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("bubble_link", "");
            if (!StringUtils.isNull(string)) {
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                    return;
                }
                com.baidu.tbadk.browser.a.a(getPageContext().getPageActivity(), getResources().getString(e.j.editor_privilege), string + "?props_id=" + str, true, true, true);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.e
    public void ar(Context context, String str) {
        l(context, str, "BUTTON");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a007";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new com.baidu.tbadk.pageStayDuration.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.25
            @Override // com.baidu.tbadk.pageStayDuration.b
            public boolean OM() {
                return false;
            }

            @Override // com.baidu.tbadk.pageStayDuration.b
            public int ON() {
                return com.baidu.tbadk.pageStayDuration.e.OR().OT();
            }
        };
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.ghF != null) {
            if (this.ghF.bmN() != null && this.ghF.bmN().bgW() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.d(this.ghF.bmN().bgW().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.d(this.ghF.bjd(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean isPaused() {
        return this.ghP;
    }

    public boolean bms() {
        if (this.ghF != null) {
            return this.ghF.bms();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            this.ghH.showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fTp.getPageActivity());
        if (ao.isEmpty(str)) {
            aVar.eB(this.fTp.getResources().getString(e.j.block_mute_message_alert, str3));
        } else {
            aVar.eB(str);
        }
        aVar.a(e.j.confirm, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.26
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                NewSubPbActivity.this.ghH.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.27
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fTp).BF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hT(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fTp.getPageActivity());
        aVar.eB(str);
        aVar.b(e.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.28
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fTp).BF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bin() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.eB(getResources().getString(e.j.mute_is_super_member_function));
        aVar.a(e.j.open_now, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.29
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar2.dismiss();
                    ((TbPageContext) NewSubPbActivity.this.fTp).showToast(e.j.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) NewSubPbActivity.this.fTp.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        });
        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.30
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.fTp).BF();
    }

    public int bgv() {
        if (this.ghF != null) {
            return this.ghF.bgv();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.aYF) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.aYF) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }

    public void lL(boolean z) {
        if (this.geQ != null && this.geQ.getText() != null) {
            int selectionEnd = this.geQ.getSelectionEnd();
            SpannableStringBuilder b = this.ghU.b(this.geQ.getText());
            if (b != null) {
                this.ghU.or(true);
                this.geQ.setText(b);
                if (z && this.ghU.bMV() >= 0) {
                    this.geQ.requestFocus();
                    this.geQ.setSelection(this.ghU.bMV());
                } else {
                    this.geQ.setSelection(selectionEnd);
                }
                this.ghU.oq(this.ghU.bMV() >= 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ContriInfo contriInfo) {
        if (this.dIO == null) {
            this.dIO = new h(getPageContext());
            this.dIO.a(new h.a() { // from class: com.baidu.tieba.pb.pb.sub.NewSubPbActivity.32
                @Override // com.baidu.tbadk.core.dialog.h.a
                public void bn(boolean z) {
                    if (z) {
                        TiebaStatic.log(new am("c13061"));
                    }
                }
            });
        }
        this.dIO.a(contriInfo, -1L);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.ffl != null && this.ffl.LX() != null && this.ffl.LX().Ma()) {
            this.ffl.LX().Kw();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, com.baidu.adp.base.h
    public void onPreLoad(com.baidu.adp.widget.ListView.k kVar) {
        ad.a(kVar, getUniqueId(), 3);
        com.baidu.tbadk.core.util.e.d.a(kVar, getUniqueId(), this);
    }
}
