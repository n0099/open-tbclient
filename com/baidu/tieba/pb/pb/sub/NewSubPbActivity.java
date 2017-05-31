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
    private static final String ewz = String.valueOf(com.baidu.tbadk.data.e.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String exM = "tbgametype";
    private com.baidu.adp.lib.e.b<ImageView> aNH;
    private com.baidu.adp.lib.e.b<TextView> aNI;
    private com.baidu.adp.lib.e.b<View> aNJ;
    private com.baidu.adp.lib.e.b<View> aNK;
    private com.baidu.adp.lib.e.b<LinearLayout> aNL;
    private com.baidu.adp.lib.e.b<GifView> aNM;
    private View.OnLongClickListener atb;
    private VoiceManager bTZ;
    private View.OnClickListener cvw;
    private com.baidu.tbadk.baseEditMark.a dHz;
    private com.baidu.tbadk.editortools.pb.n dnc;
    private c.b emT;
    private com.baidu.adp.base.g emk;
    private com.baidu.tbadk.core.view.h eml;
    private SubPbModel exN;
    private ForumManageModel exO;
    private ao exP;
    private AbsListView.OnScrollListener exQ;
    private TbRichTextView.f exR;
    private TbRichTextView.e exS;
    private SubPbModel.a exT;
    private com.baidu.adp.base.f exU;
    private BdUniqueId exZ;
    private b eyb;
    private Object mExtra;
    private boolean mIsFromCDN = true;
    private int emQ = 0;
    private a.InterfaceC0033a emL = null;
    private a exV = null;
    private a exW = null;
    private boolean exX = false;
    private boolean exY = false;
    private boolean eya = false;
    private boolean eyc = false;
    private com.baidu.tbadk.editortools.pb.b aAK = new h(this);
    private NewWriteModel.d eyd = new s(this);
    private CustomMessageListener emE = new ad(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener emF = new ai(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener emG = new aj(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    boolean emR = false;
    private CustomMessageListener cQv = new ak(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    public final TbRichTextView.d ewC = new al(this);
    CustomMessageListener bUQ = new am(this, CmdConfigCustom.CMD_UPDATE_PENDANT);

    /* loaded from: classes.dex */
    public interface a {
        void g(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        s(bundle);
        if (this.eyc) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.emk = getPageContext();
        this.exY = true;
        aiI();
        aNM();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        if (this.exN.aNP()) {
            this.eyb = new b(this, getListView(), this.exP.aaU());
            this.eyb.aNH();
            this.eyb.a(new an(this));
            this.exP.e(this.eyb);
            this.exP.jd(true);
        }
        this.eml = new com.baidu.tbadk.core.view.h();
        this.eml.aiM = 1000L;
        registerListener(this.emG);
        registerListener(this.emE);
        registerListener(this.emF);
        this.exZ = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.exZ;
        userMuteAddAndDelCustomMessage.setTag(this.exZ);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.exZ;
        userMuteCheckCustomMessage.setTag(this.exZ);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void initUI() {
        this.exP = new ao(this, this.cvw);
        this.exP.a(this.exN);
        addContentView(this.exP.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.exP.setOnScrollListener(this.exQ);
        this.exP.a(this);
        this.exP.setOnLinkImageClickListener(this.exR);
        this.exP.setOnImageClickListener(this.exS);
        this.exP.hZ(true);
        this.exP.setOnLongClickListener(this.atb);
        this.exP.f(new i(this));
        this.exP.a(this.exV);
        this.exP.b(this.exW);
        if (this.exN != null && this.exN.aNP() && !this.exN.aOC()) {
            this.exP.aOe().setVisibility(8);
        } else {
            this.exP.aOe().setVisibility(0);
        }
        if (this.exN != null && !this.exN.aNP()) {
            this.exP.setIsFromPb(false);
        }
    }

    private boolean s(Bundle bundle) {
        if (bundle != null) {
            this.eyc = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        } else {
            this.eyc = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        }
        return this.eyc;
    }

    public void initData(Bundle bundle) {
        this.exN = new SubPbModel(getPageContext());
        this.exN.b(new j(this));
        this.exO = new ForumManageModel(this);
        this.exO.setLoadDataCallBack(this.exU);
        this.bTZ = new VoiceManager();
        this.bTZ.onCreate(getPageContext());
        this.dHz = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dHz != null) {
            this.dHz.a(this.emL);
        }
        if (bundle != null) {
            this.exN.initWithBundle(bundle);
        } else {
            this.exN.initWithIntent(getIntent());
        }
        this.exN.a(this.exT);
        if (this.exN.aNP()) {
            this.exN.EA();
        } else {
            this.exN.aOs();
        }
    }

    public void aNM() {
        this.exT = new k(this);
        this.emL = new l(this);
        this.exV = new m(this);
        this.exW = new n(this);
        this.exU = new o(this);
    }

    public void aiI() {
        registerListener(this.bUQ);
        this.cvw = new p(this);
        this.exQ = new q(this);
        this.emT = new r(this);
        this.atb = new t(this);
        this.exR = new u(this);
        this.exS = new v(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(TbRichText tbRichText, TbRichText tbRichText2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        TbRichTextImageInfo HD;
        if (tbRichText == tbRichText2) {
            this.emR = true;
        }
        if (tbRichText != null && tbRichText.Hx() != null) {
            int size = tbRichText.Hx().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (tbRichText.Hx().get(i6) != null && tbRichText.Hx().get(i6).getType() == 8) {
                    i5++;
                    int width = tbRichText.Hx().get(i6).HD().getWidth();
                    int height = tbRichText.Hx().get(i6).HD().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !tbRichText.Hx().get(i6).HD().HP()) {
                        if (tbRichText == tbRichText2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        TbRichTextData tbRichTextData = tbRichText.Hx().get(i6);
                        String c = c(tbRichTextData);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && tbRichTextData != null && (HD = tbRichTextData.HD()) != null) {
                            String HR = HD.HR();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = HR;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.emR) {
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
        TbRichTextImageInfo HD = tbRichTextData.HD();
        if (HD != null) {
            if (!StringUtils.isNull(HD.HO())) {
                return HD.HO();
            }
            if (HD.getHeight() * HD.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (HD.getHeight() * HD.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (HD.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * HD.getHeight())));
            } else {
                float width = HD.getWidth() / HD.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(com.baidu.tbadk.core.util.au.aD(HD.HQ()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText an(String str, int i) {
        if (this.exN == null || this.exN.aOn() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.n aOn = this.exN.aOn();
        TbRichText a2 = a(aOn.aJj(), str, i);
        if (a2 == null) {
            TbRichText a3 = a(aOn.aJj(), str, i);
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
        TbRichText avd = postData.avd();
        if (avd != null) {
            ArrayList<TbRichTextData> Hx = avd.Hx();
            int size = Hx.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (Hx.get(i3) != null && Hx.get(i3).getType() == 8) {
                    i2++;
                    if (Hx.get(i3).HD().HR().equals(str)) {
                        int width = Hx.get(i3).HD().getWidth();
                        int height = Hx.get(i3).HD().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.emQ = i3;
                        return avd;
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
    public void j(Context context, String str, String str2) {
        long templateId = this.exN.aOn().aJj().bio() != null ? this.exN.aOn().aJj().bio().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && com.baidu.tbadk.core.util.bb.vy().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.exN.aOn().aJp().getId(), this.exN.aOn().aJp().getName(), this.exN.aOn().LH().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(int i, String str) {
        if (this.exN.aOo()) {
            showToast(str);
        } else if (com.baidu.adp.lib.util.k.hB()) {
            if (i == 4) {
                this.exP.oh(String.valueOf(str) + "(4)");
            } else {
                this.exP.gc(w.l.no_data_text);
            }
        } else {
            this.exP.gc(w.l.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.dnc = (com.baidu.tbadk.editortools.pb.n) new com.baidu.tbadk.editortools.pb.r().aQ(getActivity());
        this.dnc.a(getPageContext());
        this.dnc.b(this.exN);
        this.dnc.b(this.eyd);
        this.dnc.a(this.aAK);
        this.dnc.Cm().bA(true);
        this.dnc.f(getPageContext());
        if (this.exP != null) {
            this.exP.f(this.dnc);
        }
        if (this.dnc != null && this.exN != null) {
            this.dnc.a(this.exN.avj());
            this.dnc.Dk();
        }
    }

    public void aNN() {
        if (!TbadkCoreApplication.isLogin()) {
            this.dnc.Dk();
        } else if (!StringUtils.isNull(this.exN.aOx())) {
            this.exP.oi(this.exN.aOx());
            if (this.exP.aNY() && com.baidu.adp.lib.util.k.hB()) {
                this.exP.Zb();
            } else {
                this.exP.aOb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(View view) {
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
                    this.exP.aX(view);
                }
            } else if (booleanValue2) {
                this.exP.a(((Integer) sparseArray.get(w.h.tag_del_post_type)).intValue(), (String) sparseArray.get(w.h.tag_del_post_id), ((Integer) sparseArray.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(w.h.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.g.j.a(this.exP.aOg(), getPageContext().getPageActivity());
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
        cVar.cb(w.l.operation);
        cVar.a(strArr, new w(this, sparseArray, z, str));
        cVar.d(getPageContext()).tf();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(w.h.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(w.h.tag_user_mute_mute_userid);
        }
        this.exP.Pd();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.g.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.g.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.exZ;
        userMuteCheckCustomMessage.setTag(this.exZ);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(ForumManageModel.b bVar, boolean z) {
        if (bVar != null) {
            this.exP.a(0, bVar.AM, bVar.fEr, z);
            if (bVar.AM) {
                if (bVar.fEp == 1) {
                    finish();
                } else if (bVar.fEp == 2) {
                    this.exN.ol(bVar.mPostId);
                    this.exP.a(this.exN.aOn(), this.exN.aIM(), this.exN.aOD() != null);
                    if (this.exN.aOy()) {
                        this.exN.ji(false);
                        this.exP.aNW();
                        this.exN.EA();
                    }
                }
                com.baidu.tieba.pb.d dVar = new com.baidu.tieba.pb.d();
                dVar.setData(bVar);
                dVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, dVar));
            }
        }
    }

    public void nP(String str) {
        if (!StringUtils.isNull(str) && this.exN != null) {
            String threadID = this.exN.getThreadID();
            String CH = this.exN.CH();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(w.l.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + CH + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void g(PostData postData) {
        if (postData != null) {
            boolean z = false;
            if (this.exN.isMarked() && postData.getId() != null && postData.getId().equals(this.exN.aOv())) {
                z = true;
            }
            MarkData h = this.exN.h(postData);
            if (h != null) {
                this.exP.avy();
                if (this.dHz != null) {
                    this.dHz.a(h);
                    if (!z) {
                        this.dHz.nF();
                    } else {
                        this.dHz.nE();
                    }
                }
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.exN != null) {
            this.exN.p(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.dnc != null) {
            this.dnc.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bTZ != null) {
            this.bTZ.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.exX = true;
        super.onPause();
        if (this.bTZ != null) {
            this.bTZ.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cQv);
        this.exP.abV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.exX = false;
        super.onResume();
        if (this.bTZ != null) {
            this.bTZ.onResume(getPageContext());
        }
        registerListener(this.cQv);
        this.exP.abW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bTZ != null) {
            this.bTZ.onStop(getPageContext());
        }
        this.dnc.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.exN.cancelLoadData();
        this.exN.destory();
        this.exO.cancelLoadData();
        if (this.bTZ != null) {
            this.bTZ.onDestory(getPageContext());
        }
        this.exP.avy();
        this.exP.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.emE);
        MessageManager.getInstance().unRegisterListener(this.emF);
        MessageManager.getInstance().unRegisterListener(this.emG);
        MessageManager.getInstance().unRegisterListener(this.exZ);
        this.emk = null;
        this.eml = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.exP.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bTZ;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aOc = this.exP.aOc();
        if (aOc == null || (findViewWithTag = aOc.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean od(String str) {
        Map<String, String> dB;
        if (!TextUtils.isEmpty(str) && (dB = com.baidu.tbadk.core.util.bb.dB(com.baidu.tbadk.core.util.bb.dC(str))) != null) {
            this.eya = true;
            String str2 = dB.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return od(com.baidu.adp.lib.util.j.aE(str2));
            }
            String str3 = dB.get(exM);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Z(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (od(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
                return;
            }
            com.baidu.tbadk.core.util.bb.vy().c(getPageContext(), new String[]{str});
            this.eya = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void Y(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.eya = true;
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
        if (this.exP != null) {
            return this.exP.getListView();
        }
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public int Ia() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<TextView> Ic() {
        if (this.aNI == null) {
            this.aNI = TbRichTextView.l(getPageContext().getPageActivity(), 8);
        }
        return this.aNI;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<GifView> Id() {
        if (this.aNM == null) {
            this.aNM = new com.baidu.adp.lib.e.b<>(new x(this), 20, 0);
        }
        return this.aNM;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<ImageView> Ib() {
        if (this.aNH == null) {
            this.aNH = new com.baidu.adp.lib.e.b<>(new y(this), 8, 0);
        }
        return this.aNH;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Ie() {
        if (this.aNK == null) {
            this.aNK = new com.baidu.adp.lib.e.b<>(new z(this), 8, 0);
        }
        return this.aNK;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<LinearLayout> If() {
        if (this.aNL == null) {
            this.aNL = new com.baidu.adp.lib.e.b<>(new aa(this), 15, 0);
        }
        return this.aNL;
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public com.baidu.adp.lib.e.b<View> Ig() {
        if (this.aNJ == null) {
            this.aNJ = com.baidu.tieba.graffiti.d.o(getPageContext().getPageActivity(), 8);
        }
        return this.aNJ;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.exP.aNY() && com.baidu.adp.lib.util.k.hB()) {
            this.exN.EA();
        } else {
            this.exP.aOb();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.exZ);
        userMuteAddAndDelCustomMessage.setTag(this.exZ);
        a(z, userMuteAddAndDelCustomMessage, str5, str3);
    }

    @Override // com.baidu.tbadk.widget.richText.d
    public void ad(Context context, String str) {
        j(context, str, "BUTTON");
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
        if (pageStayDurationItem != null && this.exN != null) {
            if (this.exN.aOn() != null && this.exN.aOn().aJp() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.c(this.exN.aOn().aJp().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.g.b.c(this.exN.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aNO() {
        return this.exX;
    }

    public boolean aNP() {
        if (this.exN != null) {
            return this.exN.aNP();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.exP.Pd();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.emk.getPageActivity());
        if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
            aVar.cB(this.emk.getResources().getString(w.l.block_mute_message_alert, str2));
        } else {
            aVar.cB(str);
        }
        aVar.a(w.l.confirm, new ac(this, userMuteAddAndDelCustomMessage));
        aVar.b(w.l.cancel, new ae(this));
        aVar.b(this.emk).tc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fy(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.emk.getPageActivity());
        aVar.cB(str);
        aVar.b(w.l.know, new af(this));
        aVar.b(this.emk).tc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKi() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cB(getResources().getString(w.l.mute_is_super_member_function));
        aVar.a(w.l.open_now, new ag(this));
        aVar.b(w.l.cancel, new ah(this));
        aVar.b(this.emk).tc();
    }

    public String getThreadId() {
        if (this.exN != null) {
            return this.exN.getThreadID();
        }
        return null;
    }

    public String getPostId() {
        if (this.exN != null) {
            return this.exN.CH();
        }
        return null;
    }

    public int aIM() {
        if (this.exN != null) {
            return this.exN.aIM();
        }
        return 0;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        if (this.eyc) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        } else {
            super.enterExitAnimation();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        if (this.eyc) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        } else {
            super.closeAnimation();
        }
    }
}
