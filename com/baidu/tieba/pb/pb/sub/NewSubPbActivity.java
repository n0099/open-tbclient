package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.d {
    private static final String etZ = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String euU = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aNs;
    private com.baidu.adp.lib.e.b<TextView> aNt;
    private com.baidu.adp.lib.e.b<View> aNu;
    private com.baidu.adp.lib.e.b<View> aNv;
    private com.baidu.adp.lib.e.b<LinearLayout> aNw;
    private com.baidu.adp.lib.e.b<GifView> aNx;
    private View.OnLongClickListener atn;
    private VoiceManager bOT;
    private View.OnClickListener csa;
    private com.baidu.tbadk.baseEditMark.a dHE;
    private com.baidu.tbadk.editortools.pb.n dnB;
    private com.baidu.adp.base.g elx;
    private com.baidu.tbadk.core.view.h ely;
    private c.b emb;
    private SubPbModel euV;
    private ForumManageModel euW;
    private ao euX;
    private AbsListView.OnScrollListener euY;
    private TbRichTextView.f euZ;
    private TbRichTextView.e eva;
    private SubPbModel.a evb;
    private com.baidu.adp.base.f evc;
    private BdUniqueId evh;
    private b evj;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int elY = 0;
    private a.InterfaceC0028a elT = null;
    private a evd = null;
    private a eve = null;
    private boolean evf = false;
    private boolean evg = false;
    private boolean evi = false;
    private boolean evk = false;
    private com.baidu.tbadk.editortools.pb.b aBa = new h(this);
    private NewWriteModel.d evl = new s(this);
    private CustomMessageListener elN = new ad(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener elO = new ai(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener elP = new aj(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    boolean elZ = false;
    private CustomMessageListener cQV = new ak(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    public final TbRichTextView.d euc = new al(this);
    CustomMessageListener bPM = new am(this, CmdConfigCustom.CMD_UPDATE_PENDANT);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        s(bundle);
        if (this.evk) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.elx = getPageContext();
        this.evg = true;
        amp();
        aPo();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.euV.aPr()) {
            this.evj = new b(this, getListView(), this.euX.Kt());
            this.evj.aPj();
            this.evj.a(new an(this));
            this.euX.e(this.evj);
            this.euX.jh(true);
        }
        this.ely = new com.baidu.tbadk.core.view.h();
        this.ely.ajz = 1000L;
        registerListener(this.elP);
        registerListener(this.elN);
        registerListener(this.elO);
        this.evh = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.evh;
        userMuteAddAndDelCustomMessage.setTag(this.evh);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.evh;
        userMuteCheckCustomMessage.setTag(this.evh);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.euX = new ao(this, this.csa);
        this.euX.a(this.euV);
        addContentView(this.euX.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.euX.setOnScrollListener(this.euY);
        this.euX.a(this);
        this.euX.setOnLinkImageClickListener(this.euZ);
        this.euX.setOnImageClickListener(this.eva);
        this.euX.ik(true);
        this.euX.setOnLongClickListener(this.atn);
        this.euX.f(new i(this));
        this.euX.a(this.evd);
        this.euX.b(this.eve);
        if (this.euV != null && this.euV.aPr() && !this.euV.aQd()) {
            this.euX.aPF().setVisibility(8);
        } else {
            this.euX.aPF().setVisibility(0);
        }
        if (this.euV != null && !this.euV.aPr()) {
            this.euX.setIsFromPb(false);
        }
    }

    private boolean s(Bundle bundle) {
        if (bundle != null) {
            this.evk = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.evk = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.evk;
    }

    public void initData(Bundle bundle) {
        this.euV = new SubPbModel(getPageContext());
        this.euV.b(new j(this));
        this.euW = new ForumManageModel(this);
        this.euW.setLoadDataCallBack(this.evc);
        this.bOT = new VoiceManager();
        this.bOT.onCreate(getPageContext());
        this.dHE = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dHE != null) {
            this.dHE.a(this.elT);
        }
        if (bundle != null) {
            this.euV.initWithBundle(bundle);
        } else {
            this.euV.initWithIntent(getIntent());
        }
        this.euV.a(this.evb);
        if (this.euV.aPr()) {
            this.euV.FC();
        } else {
            this.euV.aPT();
        }
    }

    public void aPo() {
        this.evb = new k(this);
        this.elT = new l(this);
        this.evd = new m(this);
        this.eve = new n(this);
        this.evc = new o(this);
    }

    public void amp() {
        registerListener(this.bPM);
        this.csa = new p(this);
        this.euY = new q(this);
        this.emb = new r(this);
        this.atn = new t(this);
        this.euZ = new u(this);
        this.eva = new v(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo Iu;
        if (tbRichText == tbRichText2) {
            this.elZ = true;
        }
        if (tbRichText != null && tbRichText.Io() != null) {
            int size = tbRichText.Io().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.Io().get(i6) != null && tbRichText.Io().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.Io().get(i6).Iu().getWidth();
                    int height = tbRichText.Io().get(i6).Iu().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.Io().get(i6).Iu().IG()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.Io().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (Iu = tbRichTextData.Iu()) != null) {
                            String II = Iu.II();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = II;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.elZ) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public String c(TbRichTextData tbRichTextData) {
        if (tbRichTextData == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder((int) BaseActivity.SHOW_SOFT_KEYBOARD_DELAY);
        TbRichTextImageInfo Iu = tbRichTextData.Iu();
        if (Iu != null) {
            if (!StringUtils.isNull(Iu.IF())) {
                return Iu.IF();
            }
            if (Iu.getHeight() * Iu.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Iu.getHeight() * Iu.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Iu.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Iu.getHeight())));
            } else {
                float width = Iu.getWidth() / Iu.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.au.aD(Iu.IH()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText am(String str, int i) {
        if (this.euV == null || this.euV.aPO() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.j aPO = this.euV.aPO();
        TbRichText a2 = a(aPO.aKW(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(aPO.aKW(), str, i);
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
        TbRichText axm = postData.axm();
        if (axm != null) {
            ArrayList<TbRichTextData> Io = axm.Io();
            int size = Io.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (Io.get(i3) != null && Io.get(i3).getType() == 8) {
                    i2++;
                    if (Io.get(i3).Iu().II().equals(str)) {
                        int width = Io.get(i3).Iu().getWidth();
                        int height = Io.get(i3).Iu().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.elY = i3;
                        return axm;
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
    public void i(Context context, String str, String str2) {
        long templateId = this.euV.aPO().aKW().bjx() != null ? this.euV.aPO().aKW().bjx().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.bb.wn().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.euV.aPO().aLc().getId(), this.euV.aPO().aLc().getName(), this.euV.aPO().Kn().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i, String str) {
        if (this.euV.aPP()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.k.hB()) {
            if (i == 4) {
                this.euX.nN(String.valueOf(str) + "(4)");
            } else {
                this.euX.fV(w.l.no_data_text);
            }
        } else {
            this.euX.fV(w.l.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.dnB = (com.baidu.tbadk.editortools.pb.n) new com.baidu.tbadk.editortools.pb.r().aN(getActivity());
        this.dnB.a(getPageContext());
        this.dnB.b(this.euV);
        this.dnB.b(this.evl);
        this.dnB.a(this.aBa);
        this.dnB.Dn().bD(true);
        this.dnB.f(getPageContext());
        if (this.euX != null) {
            this.euX.f(this.dnB);
        }
        if (this.dnB != null && this.euV != null) {
            this.dnB.a(this.euV.axt());
            this.dnB.Em();
        }
    }

    public void aPp() {
        if (!TbadkCoreApplication.isLogin()) {
            this.dnB.Em();
        } else if (!StringUtils.isNull(this.euV.aPY())) {
            this.euX.nO(this.euV.aPY());
            if (this.euX.aPz() && com.baidu.adp.lib.util.k.hB()) {
                this.euX.Zh();
            } else {
                this.euX.aPC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bc(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(w.h.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(w.h.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(w.h.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(w.h.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(w.h.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(w.h.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(w.h.tag_from, 1);
                    d(sparseArray);
                } else {
                    this.euX.ba(view);
                }
            } else if (booleanValue2) {
                this.euX.a(((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray.get(w.h.tag_del_post_id), ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.j.a(this.euX.aPH(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        String str;
        String[] strArr;
        if (!(sparseArray.get(w.h.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(w.h.tag_user_mute_mute_userid);
        }
        if (((Boolean) sparseArray.get(w.h.tag_user_mute_visible)).booleanValue()) {
            String[] strArr2 = new String[2];
            strArr2[0] = getResources().getString(w.l.delete);
            strArr2[1] = z ? getResources().getString(w.l.un_mute) : getResources().getString(w.l.mute);
            strArr = strArr2;
        } else {
            strArr = new String[]{getResources().getString(w.l.delete)};
        }
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.cc(w.l.operation);
        cVar.a(strArr, new w(this, sparseArray, z, str));
        cVar.d(getPageContext()).tT();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(w.h.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(w.h.tag_user_mute_mute_userid);
        }
        this.euX.avw();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.evh;
        userMuteCheckCustomMessage.setTag(this.evh);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.euX.a(0, bVar.AM, bVar.fAq, z);
            if (bVar.AM) {
                if (bVar.fAo == 1) {
                    finish();
                } else if (bVar.fAo == 2) {
                    this.euV.nR(bVar.mPostId);
                    this.euX.a(this.euV.aPO(), this.euV.aKI(), this.euV.aQe() != null);
                    if (this.euV.aPZ()) {
                        this.euV.jl(false);
                        this.euX.aPx();
                        this.euV.FC();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
            }
        }
    }

    public void nw(String str) {
        if (!StringUtils.isNull(str) && this.euV != null) {
            String threadID = this.euV.getThreadID();
            String DJ = this.euV.DJ();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(w.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + DJ + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void d(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.euV.isMarked() && postData.getId() != null && postData.getId().equals(this.euV.aPW())) {
                z = true;
            }
            MarkData e = this.euV.e(postData);
            if (e != null) {
                this.euX.axI();
                if (this.dHE != null) {
                    this.dHE.a(e);
                    if (!z) {
                        this.dHE.og();
                    } else {
                        this.dHE.of();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.euV != null) {
            this.euV.p(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dnB != null) {
            this.dnB.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bOT != null) {
            this.bOT.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.evf = true;
        super.onPause();
        if (this.bOT != null) {
            this.bOT.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cQV);
        this.euX.acE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.evf = false;
        super.onResume();
        if (this.bOT != null) {
            this.bOT.onResume(getPageContext());
        }
        registerListener(this.cQV);
        this.euX.acF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bOT != null) {
            this.bOT.onStop(getPageContext());
        }
        this.dnB.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.euV.cancelLoadData();
        this.euV.destory();
        this.euW.cancelLoadData();
        if (this.bOT != null) {
            this.bOT.onDestory(getPageContext());
        }
        this.euX.axI();
        this.euX.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.elN);
        MessageManager.getInstance().unRegisterListener(this.elO);
        MessageManager.getInstance().unRegisterListener(this.elP);
        MessageManager.getInstance().unRegisterListener(this.evh);
        this.elx = null;
        this.ely = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.euX.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bOT;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aPD = this.euX.aPD();
        if (aPD == null || (findViewWithTag = aPD.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean nL(String str) {
        Map<String, String> dG;
        if (!TextUtils.isEmpty(str) && (dG = com.baidu.tbadk.core.util.bb.dG(com.baidu.tbadk.core.util.bb.dH(str))) != null) {
            this.evi = true;
            String str2 = dG.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return nL(com.baidu.adp.lib.util.j.aE(str2));
            }
            String str3 = dG.get(euU);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (nL(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            com.baidu.tbadk.core.util.bb.wn().c(getPageContext(), new String[]{str});
            this.evi = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Y(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.evi = true;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void aa(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ab(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ac(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void f(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public ListView getListView() {
        if (this.euX != null) {
            return this.euX.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int IR() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> IT() {
        if (this.aNt == null) {
            this.aNt = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aNt;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> IU() {
        if (this.aNx == null) {
            this.aNx = new com.baidu.adp.lib.e.b<>(new x(this), 20, 0);
        }
        return this.aNx;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> IS() {
        if (this.aNs == null) {
            this.aNs = new com.baidu.adp.lib.e.b<>(new y(this), 8, 0);
        }
        return this.aNs;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IV() {
        if (this.aNv == null) {
            this.aNv = new com.baidu.adp.lib.e.b<>(new z(this), 8, 0);
        }
        return this.aNv;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> IW() {
        if (this.aNw == null) {
            this.aNw = new com.baidu.adp.lib.e.b<>(new aa(this), 15, 0);
        }
        return this.aNw;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> IX() {
        if (this.aNu == null) {
            this.aNu = com.baidu.tieba.graffiti.d.o(getPageContext().getPageActivity(), 8);
        }
        return this.aNu;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void lo() {
        if (this.euX.aPz() && com.baidu.adp.lib.util.k.hB()) {
            this.euV.FC();
        } else {
            this.euX.aPC();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (sparseArray.get(w.h.tag_user_mute_mute_username) instanceof String) {
            str3 = (String) sparseArray.get(w.h.tag_user_mute_mute_username);
        }
        if (sparseArray.get(w.h.tag_user_mute_thread_id) instanceof String) {
            str4 = (String) sparseArray.get(w.h.tag_user_mute_thread_id);
        }
        if (!(sparseArray.get(w.h.tag_user_mute_post_id) instanceof String)) {
            str2 = "";
        } else {
            str2 = (String) sparseArray.get(w.h.tag_user_mute_post_id);
        }
        String str6 = sparseArray.get(w.h.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(w.h.tag_user_mute_msg) : str2;
        if (sparseArray.get(w.h.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(w.h.tag_user_mute_msg);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.evh);
        userMuteAddAndDelCustomMessage.setTag(this.evh);
        a(z, userMuteAddAndDelCustomMessage, str5, str3);
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ad(Context context, String str) {
        i(context, str, "BUTTON");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a007";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new ab(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.euV != null) {
            if (this.euV.aPO() != null && this.euV.aPO().aLc() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.euV.aPO().aLc().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.euV.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aPq() {
        return this.evf;
    }

    public boolean aPr() {
        if (this.euV != null) {
            return this.euV.aPr();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.euX.avw();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.elx.getPageActivity());
        if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
            aVar.cE(this.elx.getResources().getString(w.l.block_mute_message_alert, str2));
        } else {
            aVar.cE(str);
        }
        aVar.a(w.l.confirm, new ac(this, userMuteAddAndDelCustomMessage));
        aVar.b(w.l.cancel, new ae(this));
        aVar.b(this.elx).tQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fD(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.elx.getPageActivity());
        aVar.cE(str);
        aVar.b(w.l.know, new af(this));
        aVar.b(this.elx).tQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLT() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cE(getResources().getString(w.l.mute_is_super_member_function));
        aVar.a(w.l.open_now, new ag(this));
        aVar.b(w.l.cancel, new ah(this));
        aVar.b(this.elx).tQ();
    }

    public String getThreadId() {
        if (this.euV != null) {
            return this.euV.getThreadID();
        }
        return null;
    }

    public String getPostId() {
        if (this.euV != null) {
            return this.euV.DJ();
        }
        return null;
    }

    public int aKI() {
        if (this.euV != null) {
            return this.euV.aKI();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.evk) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.evk) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }
}
