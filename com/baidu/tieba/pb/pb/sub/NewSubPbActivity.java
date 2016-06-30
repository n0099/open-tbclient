package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.sub.aw;
import com.baidu.tieba.tbadkCore.f.a;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.u;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.m {
    private com.baidu.adp.lib.f.b<ImageView> aFj;
    private com.baidu.adp.lib.f.b<TextView> aFk;
    private com.baidu.adp.lib.f.b<View> aFl;
    private com.baidu.adp.lib.f.b<View> aFm;
    private com.baidu.adp.lib.f.b<LinearLayout> aFn;
    private com.baidu.adp.lib.f.b<GifView> aFo;
    private View.OnClickListener aZG;
    private View.OnLongClickListener aku;
    private VoiceManager bBm;
    private com.baidu.adp.base.h dPa;
    private com.baidu.tbadk.core.view.h dPb;
    private c.b dPx;
    private aw dWC;
    private com.baidu.tieba.tbadkCore.f.a dWD;
    private af dWE;
    private AbsListView.OnScrollListener dWF;
    private TbRichTextView.e dWG;
    private TbRichTextView.d dWH;
    private aw.a dWI;
    private com.baidu.adp.base.g dWJ;
    private BdUniqueId dWN;
    private com.baidu.tbadk.editortools.d.p deA;
    private com.baidu.tbadk.baseEditMark.a dvH;
    private Object mExtra;
    private static final String dWf = String.valueOf(com.baidu.tbadk.data.d.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String dWB = "tbgametype";
    private boolean mIsFromCDN = true;
    private int dPu = 0;
    private a.InterfaceC0032a dPp = null;
    private a dWK = null;
    private a dWL = null;
    private boolean dWM = false;
    private com.baidu.tbadk.editortools.d.c asu = new com.baidu.tieba.pb.pb.sub.a(this);
    private a.d dWO = new l(this);
    private CustomMessageListener dPj = new w(this, CmdConfigCustom.CMD_USER_MUTE_ADD);
    private CustomMessageListener dPk = new z(this, CmdConfigCustom.CMD_USER_MUTE_DEL);
    private CustomMessageListener dPl = new aa(this, CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE);
    boolean dPv = false;
    private CustomMessageListener cGb = new ab(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    public final TbRichTextView.c dWi = new ac(this);

    /* loaded from: classes.dex */
    public interface a {
        void d(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dPa = getPageContext();
        aiS();
        aIh();
        initData(bundle);
        nl();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        aIi();
        this.dPb = new com.baidu.tbadk.core.view.h();
        this.dPb.abh = 1000L;
        registerListener(this.dPl);
        registerListener(this.dPj);
        registerListener(this.dPk);
        this.dWN = getUniqueId();
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
        userMuteAddAndDelCustomMessage.from = 1;
        userMuteAddAndDelCustomMessage.mId = this.dWN;
        userMuteAddAndDelCustomMessage.setTag(this.dWN);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
        userMuteCheckCustomMessage.mId = this.dWN;
        userMuteCheckCustomMessage.setTag(this.dWN);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void nl() {
        this.dWE = new af(this, this.aZG);
        addContentView(this.dWE.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.dWE.setOnScrollListener(this.dWF);
        this.dWE.d(this);
        this.dWE.setOnLinkImageClickListener(this.dWG);
        this.dWE.setOnImageClickListener(this.dWH);
        this.dWE.setOnEmotionClickListener(this.dWi);
        this.dWE.hg(true);
        this.dWE.hh(com.baidu.tbadk.core.l.nW().nY());
        this.dWE.setOnLongClickListener(this.aku);
        this.dWE.f(new ad(this));
        this.dWE.a(this.dWK);
        this.dWE.b(this.dWL);
        if (this.dWC != null && this.dWC.aIk() && !this.dWC.aIW()) {
            this.dWE.aIu().setVisibility(8);
        } else {
            this.dWE.aIu().setVisibility(0);
        }
    }

    public void initData(Bundle bundle) {
        this.dWC = new aw(getPageContext());
        this.dWD = new com.baidu.tieba.tbadkCore.f.a(this);
        this.dWD.setLoadDataCallBack(this.dWJ);
        this.bBm = new VoiceManager();
        this.bBm.onCreate(getPageContext());
        this.dvH = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.dvH != null) {
            this.dvH.a(this.dPp);
        }
        if (bundle != null) {
            this.dWC.initWithBundle(bundle);
        } else {
            this.dWC.initWithIntent(getIntent());
        }
        this.dWC.a(this.dWI);
        if (this.dWC.aIk()) {
            this.dWC.DH();
        } else {
            this.dWC.aIN();
        }
    }

    public void aIh() {
        this.dWI = new ae(this);
        this.dPp = new b(this);
        this.dWK = new c(this);
        this.dWL = new d(this);
        this.dWJ = new e(this);
    }

    public void aiS() {
        this.aZG = new f(this);
        this.dWF = new g(this);
        this.dPx = new h(this);
        this.aku = new i(this);
        this.dWG = new j(this);
        this.dWH = new k(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.g GK;
        if (aVar == aVar2) {
            this.dPv = true;
        }
        if (aVar != null && aVar.GF() != null) {
            int size = aVar.GF().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.GF().get(i6) != null && aVar.GF().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.GF().get(i6).GK().getWidth();
                    int height = aVar.GF().get(i6).GK().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.GF().get(i6).GK().GW()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.GF().get(i6);
                        String c = c(cVar);
                        arrayList.add(c);
                        if (!TextUtils.isEmpty(c) && cVar != null && (GK = cVar.GK()) != null) {
                            String GX = GK.GX();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = GX;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(c, imageUrlData);
                            }
                        }
                        if (!this.dPv) {
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
    public String c(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        com.baidu.tbadk.widget.richText.g GK = cVar.GK();
        if (GK != null) {
            if (!StringUtils.isNull(GK.GV())) {
                return GK.GV();
            }
            if (GK.getHeight() * GK.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (GK.getHeight() * GK.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (GK.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * GK.getHeight())));
            } else {
                float width = GK.getWidth() / GK.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ba.aN(GK.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a ay(String str, int i) {
        if (this.dWC == null || this.dWC.aIH() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.m aIH = this.dWC.aIH();
        com.baidu.tbadk.widget.richText.a a2 = a(aIH.aEe(), str, i);
        if (a2 == null) {
            com.baidu.tbadk.widget.richText.a a3 = a(aIH.aEe(), str, i);
            if (a3 != null) {
            }
            return a3;
        }
        return a2;
    }

    private com.baidu.tbadk.widget.richText.a a(com.baidu.tieba.tbadkCore.data.s sVar, String str, int i) {
        if (sVar == null) {
            return null;
        }
        com.baidu.tbadk.widget.richText.a auL = sVar.auL();
        if (auL != null) {
            ArrayList<com.baidu.tbadk.widget.richText.c> GF = auL.GF();
            int size = GF.size();
            int i2 = -1;
            int i3 = 0;
            while (i3 < size) {
                if (GF.get(i3) != null && GF.get(i3).getType() == 8) {
                    i2++;
                    if (GF.get(i3).GK().GX().equals(str)) {
                        int width = GF.get(i3).GK().getWidth();
                        int height = GF.get(i3).GK().getHeight();
                        if (width < 80 || height < 80 || height * width < 10000) {
                            return null;
                        }
                        this.dPu = i3;
                        return auL;
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
    public void e(Context context, String str, String str2) {
        long templateId = this.dWC.aIH().aEe().bcw() != null ? this.dWC.aIH().aEe().bcw().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && bi.us().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.dWC.aIH().aEl().getId(), this.dWC.aIH().aEl().getName(), this.dWC.aIH().Ix().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i, String str) {
        if (!this.dWC.aII()) {
            if (com.baidu.adp.lib.util.k.fI()) {
                if (i == 4) {
                    this.dWE.nK(String.valueOf(str) + "(4)");
                    return;
                } else {
                    this.dWE.fN(u.j.no_data_text);
                    return;
                }
            }
            this.dWE.fN(u.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.deA = (com.baidu.tbadk.editortools.d.p) new com.baidu.tbadk.editortools.d.t().af(getActivity());
        this.deA.a(getPageContext());
        this.deA.b(this.dWC);
        this.deA.b(this.dWO);
        this.deA.a(this.asu);
        this.deA.Bl().bu(true);
        this.deA.e(getPageContext());
        if (this.dWE != null) {
            this.dWE.e(this.deA);
        }
        if (this.deA != null && this.dWC != null) {
            this.deA.a(this.dWC.getAntiData());
        }
    }

    public void aIi() {
        if (!TbadkCoreApplication.isLogin()) {
            this.deA.Cu();
        } else if (this.dWC.aIS()) {
            if (!StringUtils.isNull(this.dWC.aIP()) && !StringUtils.isNull(this.dWC.aIT())) {
                new Handler().postDelayed(new m(this), 500L);
            } else {
                this.deA.fI(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(u.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(u.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(u.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(u.g.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(u.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(u.g.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(u.g.tag_from, 1);
                    d(sparseArray);
                } else {
                    this.dWE.aZ(view);
                }
            } else if (booleanValue2) {
                this.dWE.a(((Integer) sparseArray.get(u.g.tag_del_post_type)).intValue(), (String) sparseArray.get(u.g.tag_del_post_id), ((Integer) sparseArray.get(u.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(u.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.h.j.a(this.dWE.aIv(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        String str;
        String[] strArr;
        if (!(sparseArray.get(u.g.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(u.g.tag_user_mute_mute_userid);
        }
        if (((Boolean) sparseArray.get(u.g.tag_user_mute_visible)).booleanValue()) {
            String[] strArr2 = new String[2];
            strArr2[0] = getResources().getString(u.j.delete);
            strArr2[1] = z ? getResources().getString(u.j.un_mute) : getResources().getString(u.j.mute);
            strArr = strArr2;
        } else {
            strArr = new String[]{getResources().getString(u.j.delete)};
        }
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bP(u.j.operation);
        cVar.a(strArr, new n(this, sparseArray, z, str));
        cVar.d(getPageContext()).rW();
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String str = "";
        if (sparseArray.get(u.g.tag_user_mute_mute_userid) instanceof String) {
            str = (String) sparseArray.get(u.g.tag_user_mute_mute_userid);
        }
        this.dWE.asK();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.h.b.c(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.h.b.c(str, 0L);
        this.mExtra = sparseArray;
        userMuteCheckCustomMessage.mId = this.dWN;
        userMuteCheckCustomMessage.setTag(this.dWN);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void a(a.b bVar) {
        if (bVar != null) {
            this.dWE.a(0, bVar.rg, bVar.eZR, true);
            if (bVar.rg) {
                if (bVar.eZP == 1) {
                    finish();
                } else if (bVar.eZP == 2) {
                    this.dWC.nN(bVar.mPostId);
                    this.dWE.a(this.dWC.aIH(), this.dWC.aDU(), this.dWC.aIX() != null);
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void ns(String str) {
        if (!StringUtils.isNull(str) && this.dWC != null) {
            String threadID = this.dWC.getThreadID();
            String BL = this.dWC.BL();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(u.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + BL + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void c(com.baidu.tieba.tbadkCore.data.s sVar) {
        if (sVar != null) {
            boolean z = false;
            if (this.dWC.isMarked() && sVar.getId() != null && sVar.getId().equals(this.dWC.aIR())) {
                z = true;
            }
            MarkData d = this.dWC.d(sVar);
            if (d != null) {
                this.dWE.avf();
                if (this.dvH != null) {
                    this.dvH.a(d);
                    if (!z) {
                        this.dvH.mM();
                    } else {
                        this.dvH.mL();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hp(boolean z) {
        return (this.dWC == null || this.dWC.aIH() == null || z || this.dWC.aDU() != 0 || this.dWC.aIH().Ix() == null || this.dWC.aIH().Ix().getAuthor() == null || !this.mIsLogin || TextUtils.equals(this.dWC.aIH().Ix().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.dWC != null) {
            this.dWC.q(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.deA != null) {
            this.deA.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bBm != null) {
            this.bBm.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        this.dWM = true;
        super.onPause();
        if (this.bBm != null) {
            this.bBm.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cGb);
        this.dWE.Ye();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        this.dWM = false;
        super.onResume();
        if (this.bBm != null) {
            this.bBm.onResume(getPageContext());
        }
        registerListener(this.cGb);
        this.dWE.atv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bBm != null) {
            this.bBm.onStop(getPageContext());
        }
        this.deA.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dWC.cancelLoadData();
        this.dWC.destory();
        this.dWD.cancelLoadData();
        if (this.bBm != null) {
            this.bBm.onDestory(getPageContext());
        }
        this.dWE.avf();
        this.dWE.onActivityDestroy();
        MessageManager.getInstance().unRegisterListener(this.dPj);
        MessageManager.getInstance().unRegisterListener(this.dPk);
        MessageManager.getInstance().unRegisterListener(this.dPl);
        MessageManager.getInstance().unRegisterListener(this.dWN);
        this.dPa = null;
        this.dPb = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dWE.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bBm;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View aIt = this.dWE.aIt();
        if (aIt == null || (findViewWithTag = aIt.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean nG(String str) {
        Map<String, String> dE;
        if (!TextUtils.isEmpty(str) && (dE = bi.dE(bi.dF(str))) != null) {
            String str2 = dE.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return nG(com.baidu.adp.lib.util.j.aO(str2));
            }
            String str3 = dE.get(dWB);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void B(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (nG(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                bi.us().c(getPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void A(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void C(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void D(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void E(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void d(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public int Hg() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<TextView> Hi() {
        if (this.aFk == null) {
            this.aFk = TbRichTextView.h(getPageContext().getPageActivity(), 8);
        }
        return this.aFk;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<GifView> Hj() {
        if (this.aFo == null) {
            this.aFo = new com.baidu.adp.lib.f.b<>(new o(this), 20, 0);
        }
        return this.aFo;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<ImageView> Hh() {
        if (this.aFj == null) {
            this.aFj = new com.baidu.adp.lib.f.b<>(new p(this), 8, 0);
        }
        return this.aFj;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> Hk() {
        if (this.aFm == null) {
            this.aFm = new com.baidu.adp.lib.f.b<>(new q(this), 8, 0);
        }
        return this.aFm;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<LinearLayout> Hl() {
        if (this.aFn == null) {
            this.aFn = new com.baidu.adp.lib.f.b<>(new r(this), 15, 0);
        }
        return this.aFn;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> Hm() {
        if (this.aFl == null) {
            this.aFl = com.baidu.tieba.graffiti.e.createGraffitiViewPool(getPageContext().getPageActivity(), 8);
        }
        return this.aFl;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> fk(int i) {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jD() {
        if (this.dWE.aIp() && com.baidu.adp.lib.util.k.fI()) {
            this.dWC.DH();
        } else {
            this.dWE.aIs();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (sparseArray.get(u.g.tag_user_mute_mute_username) instanceof String) {
            str3 = (String) sparseArray.get(u.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(u.g.tag_user_mute_thread_id) instanceof String) {
            str4 = (String) sparseArray.get(u.g.tag_user_mute_thread_id);
        }
        if (!(sparseArray.get(u.g.tag_user_mute_post_id) instanceof String)) {
            str2 = "";
        } else {
            str2 = (String) sparseArray.get(u.g.tag_user_mute_post_id);
        }
        String str6 = sparseArray.get(u.g.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(u.g.tag_user_mute_msg) : str2;
        if (sparseArray.get(u.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(u.g.tag_user_mute_msg);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str3, str4, str6, 1, str5, this.dWN);
        userMuteAddAndDelCustomMessage.setTag(this.dWN);
        a(z, userMuteAddAndDelCustomMessage, str5, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nJ(String str) {
        String string;
        if (!StringUtils.isNull(str) && bn.ab(getPageContext().getPageActivity())) {
            if (!StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.sO().getString("bubble_link", ""))) {
                TiebaStatic.log("c10051");
                if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                    return;
                }
                com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(u.j.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void F(Context context, String str) {
        e(context, str, "BUTTON");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a007";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new s(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.dWC != null) {
            if (this.dWC.aIH() != null && this.dWC.aIH().aEl() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.h.b.c(this.dWC.aIH().aEl().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.h.b.c(this.dWC.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }

    public boolean aIj() {
        return this.dWM;
    }

    public boolean aIk() {
        if (this.dWC != null) {
            return this.dWC.aIk();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            this.dWE.asK();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPa.getPageActivity());
        if (ba.isEmpty(str)) {
            aVar.cz(this.dPa.getResources().getString(u.j.block_mute_message_alert, str2));
        } else {
            aVar.cz(str);
        }
        aVar.a(u.j.confirm, new t(this, userMuteAddAndDelCustomMessage));
        aVar.b(u.j.cancel, new u(this));
        aVar.b(this.dPa).rT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fH(String str) {
        if (str == null) {
            str = "";
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.dPa.getPageActivity());
        aVar.cz(str);
        aVar.b(u.j.know, new v(this));
        aVar.b(this.dPa).rT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFg() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        aVar.cz(getResources().getString(u.j.mute_is_super_member_function));
        aVar.a(u.j.open_now, new x(this));
        aVar.b(u.j.cancel, new y(this));
        aVar.b(this.dPa).rT();
    }
}
