package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.dj;
import com.baidu.tieba.pb.pb.sub.ao;
import com.baidu.tieba.tbadkCore.f.a;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.i;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.l {
    private com.baidu.adp.lib.f.b<ImageView> aEW;
    private com.baidu.adp.lib.f.b<TextView> aEX;
    private com.baidu.adp.lib.f.b<View> aEY;
    private com.baidu.adp.lib.f.b<LinearLayout> aEZ;
    private View.OnLongClickListener amQ;
    private View.OnClickListener bjD;
    private c.b cFP;
    private com.baidu.tbadk.baseEditMark.a cFm;
    private ao cKR;
    private com.baidu.tieba.tbadkCore.f.a cKS;
    private w cKT;
    private AbsListView.OnScrollListener cKU;
    private TbRichTextView.e cKV;
    private TbRichTextView.d cKW;
    private ao.a cKX;
    private com.baidu.adp.base.g cKY;
    private com.baidu.tbadk.editortools.d.p cjc;
    private VoiceManager mVoiceManager;
    private static final String cKl = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String cFg = "tbgametype";
    private boolean mIsFromCDN = true;
    private int cFM = 0;
    private com.baidu.tieba.usermute.i cFp = null;
    private a.InterfaceC0040a cFH = null;
    private a cKZ = null;
    private a cLa = null;
    private UserMuteAddAndDelModel cFo = null;
    private i.a cFF = new com.baidu.tieba.pb.pb.sub.a(this);
    private com.baidu.tbadk.editortools.d.c aun = new l(this);
    private a.d cLb = new p(this);
    boolean cFN = false;
    private CustomMessageListener richTextIntentClickListener = new q(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    public final TbRichTextView.c cKo = new r(this);

    /* loaded from: classes.dex */
    public interface a {
        void d(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Vm();
        anv();
        initData(bundle);
        initUI();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        anw();
    }

    public void initUI() {
        this.cKT = new w(this, this.bjD);
        addContentView(this.cKT.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.cKT.setOnScrollListener(this.cKU);
        this.cKT.d(this);
        this.cKT.setOnLinkImageClickListener(this.cKV);
        this.cKT.setOnImageClickListener(this.cKW);
        this.cKT.setOnEmotionClickListener(this.cKo);
        this.cKT.eS(true);
        this.cKT.eU(com.baidu.tbadk.core.m.qQ().qS());
        this.cKT.setOnLongClickListener(this.amQ);
        this.cKT.b(new s(this));
        this.cKT.a(this.cKZ);
        this.cKT.b(this.cLa);
        if (this.cKR != null && this.cKR.ans() && !this.cKR.aof()) {
            this.cKT.anG().setVisibility(8);
        } else {
            this.cKT.anG().setVisibility(0);
        }
    }

    public void initData(Bundle bundle) {
        this.cFp = new com.baidu.tieba.usermute.i(getPageContext(), this.cFF);
        this.cFo = new UserMuteAddAndDelModel(getPageContext());
        this.cKR = new ao(getPageContext());
        this.cKS = new com.baidu.tieba.tbadkCore.f.a(this);
        this.cKS.setLoadDataCallBack(this.cKY);
        this.mVoiceManager = new VoiceManager();
        this.mVoiceManager.onCreate(getPageContext());
        this.cFm = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.cFm != null) {
            this.cFm.a(this.cFH);
        }
        if (bundle != null) {
            this.cKR.initWithBundle(bundle);
        } else {
            this.cKR.initWithIntent(getIntent());
        }
        this.cKR.a(this.cKX);
        if (this.cKR.ans()) {
            this.cKR.Dy();
        } else {
            this.cKR.anX();
        }
    }

    public void anv() {
        this.cKX = new t(this);
        this.cFH = new u(this);
        this.cKZ = new v(this);
        this.cLa = new b(this);
        this.cKY = new c(this);
    }

    public void Vm() {
        this.bjD = new d(this);
        this.cKU = new e(this);
        this.cFP = new f(this);
        this.amQ = new g(this);
        this.cKV = new h(this);
        this.cKW = new i(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.f FF;
        if (aVar == aVar2) {
            this.cFN = true;
        }
        if (aVar != null) {
            int size = aVar.FA().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.FA().get(i6) != null && aVar.FA().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.FA().get(i6).FF().getWidth();
                    int height = aVar.FA().get(i6).FF().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.FA().get(i6).FF().FP()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.FA().get(i6);
                        String d = d(cVar);
                        arrayList.add(d);
                        if (!TextUtils.isEmpty(d) && cVar != null && (FF = cVar.FF()) != null) {
                            String FQ = FF.FQ();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = FQ;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(d, imageUrlData);
                            }
                        }
                        if (!this.cFN) {
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
    public String d(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        com.baidu.tbadk.widget.richText.f FF = cVar.FF();
        if (FF != null) {
            if (!StringUtils.isNull(FF.FO())) {
                return FF.FO();
            }
            if (FF.getHeight() * FF.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (FF.getHeight() * FF.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (FF.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * FF.getHeight())));
            } else {
                float width = FF.getWidth() / FF.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ax.aT(FF.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a ac(String str, int i) {
        if (this.cKR == null || this.cKR.anR() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.a.d anR = this.cKR.anR();
        com.baidu.tbadk.widget.richText.a a2 = a(anR.akS(), str, i);
        if (a2 == null) {
            com.baidu.tbadk.widget.richText.a a3 = a(anR.akS(), str, i);
            if (a3 != null) {
            }
            return a3;
        }
        return a2;
    }

    private com.baidu.tbadk.widget.richText.a a(com.baidu.tieba.tbadkCore.data.r rVar, String str, int i) {
        if (rVar == null) {
            return null;
        }
        com.baidu.tbadk.widget.richText.a aFr = rVar.aFr();
        ArrayList<com.baidu.tbadk.widget.richText.c> FA = aFr.FA();
        int size = FA.size();
        int i2 = -1;
        int i3 = 0;
        while (i3 < size) {
            if (FA.get(i3) != null && FA.get(i3).getType() == 8) {
                i2++;
                if (FA.get(i3).FF().FQ().equals(str)) {
                    int width = FA.get(i3).FF().getWidth();
                    int height = FA.get(i3).FF().getHeight();
                    if (width < 80 || height < 80 || height * width < 10000) {
                        return null;
                    }
                    this.cFM = i3;
                    return aFr;
                } else if (i2 > i) {
                    break;
                }
            }
            i3++;
            i2 = i2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Context context, String str, String str2) {
        long templateId = this.cKR.anR().akS().aFA() != null ? this.cKR.anR().akS().aFA().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && bf.vn().b(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.cKR.anR().akZ().getId(), this.cKR.anR().akZ().getName(), this.cKR.anR().Iv().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i, String str) {
        if (!this.cKR.anS()) {
            if (com.baidu.adp.lib.util.k.jh()) {
                if (i == 4) {
                    this.cKT.hw(String.valueOf(str) + "(4)");
                    return;
                } else {
                    this.cKT.fv(n.j.no_data_text);
                    return;
                }
            }
            this.cKT.fv(n.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.cjc = (com.baidu.tbadk.editortools.d.p) new com.baidu.tbadk.editortools.d.t().ak(getActivity());
        this.cjc.a(getPageContext());
        this.cjc.b(this.cKR);
        this.cjc.b(this.cLb);
        this.cjc.a(this.aun);
        this.cjc.e(getPageContext());
        if (this.cKT != null) {
            this.cKT.e(this.cjc);
        }
        if (this.cjc != null && this.cKR != null) {
            this.cjc.a(this.cKR.ala());
        }
    }

    public void anw() {
        if (!TbadkCoreApplication.isLogin()) {
            this.cjc.Cs();
        } else if (this.cKR.aoc()) {
            if (!StringUtils.isNull(this.cKR.anZ()) && !StringUtils.isNull(this.cKR.aod())) {
                new Handler().postDelayed(new j(this), 500L);
            } else {
                this.cjc.fz(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(n.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(n.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(n.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(n.g.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(n.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(n.g.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(n.g.tag_from, 1);
                    d(sparseArray);
                } else {
                    this.cKT.ap(view);
                }
            } else if (booleanValue2) {
                this.cKT.a(((Integer) sparseArray.get(n.g.tag_del_post_type)).intValue(), (String) sparseArray.get(n.g.tag_del_post_id), ((Integer) sparseArray.get(n.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(n.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.h.j.a(this.cKT.anI(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        String str;
        String[] strArr;
        if (!(sparseArray.get(n.g.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(n.g.tag_user_mute_mute_userid);
        }
        if (((Boolean) sparseArray.get(n.g.tag_user_mute_visible)).booleanValue()) {
            String[] strArr2 = new String[2];
            strArr2[0] = getResources().getString(n.j.delete);
            strArr2[1] = z ? getResources().getString(n.j.un_mute) : getResources().getString(n.j.mute);
            strArr = strArr2;
        } else {
            strArr = new String[]{getResources().getString(n.j.delete)};
        }
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bJ(n.j.operation);
        cVar.a(strArr, new k(this, sparseArray, z, str));
        cVar.d(getPageContext()).tj();
    }

    public void d(SparseArray<Object> sparseArray) {
        String str;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!(sparseArray.get(n.g.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(n.g.tag_user_mute_mute_userid);
        }
        this.cKT.adL();
        this.cFp.a(com.baidu.adp.lib.h.b.c(currentAccount, 0L), com.baidu.adp.lib.h.b.c(str, 0L), sparseArray);
    }

    public void a(a.b bVar) {
        if (bVar != null) {
            this.cKT.a(0, bVar.Av, bVar.dJa, true);
            if (bVar.Av) {
                if (bVar.dIY == 1) {
                    finish();
                } else if (bVar.dIY == 2) {
                    this.cKR.kO(bVar.mPostId);
                    this.cKT.a(this.cKR.anR(), this.cKR.akL());
                }
                aq aqVar = new aq();
                aqVar.setData(bVar);
                aqVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, aqVar));
            }
        }
    }

    public void kw(String str) {
        if (!StringUtils.isNull(str) && this.cKR != null) {
            String threadID = this.cKR.getThreadID();
            String BJ = this.cKR.BJ();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(n.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + BJ + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void c(com.baidu.tieba.tbadkCore.data.r rVar) {
        if (rVar != null) {
            boolean z = false;
            if (this.cKR.isMarked() && rVar.getId() != null && rVar.getId().equals(this.cKR.aob())) {
                z = true;
            }
            MarkData d = this.cKR.d(rVar);
            if (d != null) {
                this.cKT.ana();
                if (this.cFm != null) {
                    this.cFm.a(d);
                    if (!z) {
                        this.cFm.pP();
                    } else {
                        this.cFm.pO();
                    }
                }
            }
        }
    }

    public void replyPost(View view) {
        if (this.cKT.anI() == null || this.cKT.anH() == null) {
            this.cKT.alj();
        }
        if (this.cKT.anI().getIsIntercepted()) {
            this.cKT.anI().setIsIntercepted(false);
            return;
        }
        if (view != null && view.getTag() != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.r rVar = sparseArray.get(n.g.tag_load_sub_data) instanceof com.baidu.tieba.tbadkCore.data.r ? (com.baidu.tieba.tbadkCore.data.r) sparseArray.get(n.g.tag_load_sub_data) : null;
            View view2 = sparseArray.get(n.g.tag_load_sub_view) instanceof View ? (View) sparseArray.get(n.g.tag_load_sub_view) : null;
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(n.g.tag_load_sub_data, rVar);
            sparseArray2.put(n.g.tag_load_sub_view, view2);
            this.cKT.anH().amu().setTag(sparseArray2);
            SparseArray sparseArray3 = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.r rVar2 = sparseArray3.get(n.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.r ? (com.baidu.tieba.tbadkCore.data.r) sparseArray3.get(n.g.tag_clip_board) : null;
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(n.g.tag_clip_board, rVar2);
            sparseArray4.put(n.g.tag_is_subpb, false);
            this.cKT.anH().amf().setTag(sparseArray4);
            SparseArray sparseArray5 = (SparseArray) view.getTag();
            boolean booleanValue = sparseArray5.get(n.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(n.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray5.get(n.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(n.g.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray5.get(n.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(n.g.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray5.get(n.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray5.get(n.g.tag_del_post_is_self)).booleanValue() : false;
            if (sparseArray5.get(n.g.tag_forbid_user_post_id) instanceof String) {
                String str = (String) sparseArray5.get(n.g.tag_forbid_user_post_id);
            }
            if (booleanValue) {
                SparseArray sparseArray6 = new SparseArray();
                sparseArray6.put(n.g.tag_should_manage_visible, true);
                sparseArray6.put(n.g.tag_manage_user_identity, sparseArray5.get(n.g.tag_manage_user_identity));
                sparseArray6.put(n.g.tag_del_post_is_self, sparseArray5.get(n.g.tag_del_post_is_self));
                sparseArray6.put(n.g.tag_del_post_id, sparseArray5.get(n.g.tag_del_post_id));
                sparseArray6.put(n.g.tag_del_post_type, sparseArray5.get(n.g.tag_del_post_type));
                sparseArray6.put(n.g.tag_forbid_user_name, sparseArray5.get(n.g.tag_forbid_user_name));
                sparseArray6.put(n.g.tag_forbid_user_post_id, sparseArray5.get(n.g.tag_forbid_user_post_id));
                if (booleanValue2) {
                    sparseArray6.put(n.g.tag_user_mute_visible, true);
                    sparseArray6.put(n.g.tag_is_mem, sparseArray5.get(n.g.tag_is_mem));
                    sparseArray6.put(n.g.tag_user_mute_mute_userid, sparseArray5.get(n.g.tag_user_mute_mute_userid));
                    sparseArray6.put(n.g.tag_user_mute_mute_username, sparseArray5.get(n.g.tag_user_mute_mute_username));
                    sparseArray6.put(n.g.tag_user_mute_post_id, sparseArray5.get(n.g.tag_user_mute_post_id));
                    sparseArray6.put(n.g.tag_user_mute_thread_id, sparseArray5.get(n.g.tag_user_mute_thread_id));
                } else {
                    sparseArray6.put(n.g.tag_user_mute_visible, false);
                }
                if (booleanValue3) {
                    sparseArray6.put(n.g.tag_should_delete_visible, true);
                    sparseArray6.put(n.g.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                    sparseArray6.put(n.g.tag_del_post_id, sparseArray5.get(n.g.tag_del_post_id));
                    sparseArray6.put(n.g.tag_del_post_type, sparseArray5.get(n.g.tag_del_post_type));
                } else {
                    sparseArray6.put(n.g.tag_should_delete_visible, false);
                }
                this.cKT.anH().amv().setTag(sparseArray6);
                if (!"".equals(sparseArray5.get(n.g.tag_forbid_user_name)) && !"".equals(sparseArray5.get(n.g.tag_del_post_id))) {
                    as.c(this.cKT.anH().amv(), n.f.icon_pb_set_n);
                } else {
                    as.c(this.cKT.anH().amv(), n.f.icon_pb_del_n);
                }
                this.cKT.anH().amv().setVisibility(0);
            } else if (booleanValue3) {
                SparseArray sparseArray7 = new SparseArray();
                sparseArray7.put(n.g.tag_should_manage_visible, false);
                sparseArray7.put(n.g.tag_user_mute_visible, false);
                sparseArray7.put(n.g.tag_should_delete_visible, true);
                sparseArray7.put(n.g.tag_manage_user_identity, sparseArray5.get(n.g.tag_manage_user_identity));
                sparseArray7.put(n.g.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                sparseArray7.put(n.g.tag_del_post_id, sparseArray5.get(n.g.tag_del_post_id));
                sparseArray7.put(n.g.tag_del_post_type, sparseArray5.get(n.g.tag_del_post_type));
                this.cKT.anH().amv().setTag(sparseArray7);
                as.c(this.cKT.anH().amv(), n.f.icon_pb_del_n);
                this.cKT.anH().amv().setVisibility(0);
            } else {
                this.cKT.anH().amv().setVisibility(8);
            }
            SparseArray sparseArray8 = (SparseArray) view.getTag();
            boolean booleanValue5 = sparseArray8.get(n.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray8.get(n.g.tag_user_mute_visible)).booleanValue() : false;
            if (!((Boolean) sparseArray8.get(n.g.tag_should_manage_visible)).booleanValue() && booleanValue5) {
                SparseArray sparseArray9 = new SparseArray();
                sparseArray9.put(n.g.tag_user_mute_visible, true);
                sparseArray9.put(n.g.tag_is_mem, sparseArray8.get(n.g.tag_is_mem));
                sparseArray9.put(n.g.tag_user_mute_mute_userid, sparseArray8.get(n.g.tag_user_mute_mute_userid));
                sparseArray9.put(n.g.tag_user_mute_mute_username, sparseArray8.get(n.g.tag_user_mute_mute_username));
                sparseArray9.put(n.g.tag_user_mute_post_id, sparseArray8.get(n.g.tag_user_mute_post_id));
                sparseArray9.put(n.g.tag_user_mute_thread_id, sparseArray8.get(n.g.tag_user_mute_thread_id));
                sparseArray9.put(n.g.tag_del_post_is_self, sparseArray8.get(n.g.tag_del_post_is_self));
                sparseArray9.put(n.g.tag_del_post_type, sparseArray8.get(n.g.tag_del_post_type));
                sparseArray9.put(n.g.tag_del_post_id, sparseArray8.get(n.g.tag_del_post_id));
                sparseArray9.put(n.g.tag_manage_user_identity, sparseArray8.get(n.g.tag_manage_user_identity));
                this.cKT.anH().amw().setTag(sparseArray9);
                this.cKT.anH().amw().setVisibility(0);
                this.cKT.anH().amv().setVisibility(8);
                as.c(this.cKT.anH().amw(), n.f.icon_pb_gag);
            } else {
                boolean booleanValue6 = sparseArray8.get(n.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray8.get(n.g.tag_del_post_is_self)).booleanValue() : false;
                String str2 = sparseArray8.get(n.g.tag_forbid_user_post_id) instanceof String ? (String) sparseArray8.get(n.g.tag_forbid_user_post_id) : null;
                if (dj.e(sparseArray8.get(n.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.r ? (com.baidu.tieba.tbadkCore.data.r) sparseArray8.get(n.g.tag_clip_board) : null) ? false : eX(booleanValue6) & isLogin()) {
                    this.cKT.anH().amw().setVisibility(0);
                    this.cKT.anH().amw().setTag(str2);
                } else {
                    this.cKT.anH().amw().setVisibility(8);
                }
            }
        }
        if (this.cKR.isMarked()) {
            this.cKT.anH().amf().setText(n.j.marked);
            this.cKT.anH().amf().setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.cKT.anH().amf().setText(n.j.mark);
            this.cKT.anH().amf().setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.cKT.anH().fh(false);
        this.cKT.anI().reLayoutWidth();
        if (view != null) {
            this.cKT.anI().showWindowInLeftCenterOfHost(view, false);
        }
    }

    private boolean eX(boolean z) {
        return (this.cKR == null || this.cKR.anR() == null || z || this.cKR.akL() != 0 || this.cKR.anR().Iv() == null || this.cKR.anR().Iv().getAuthor() == null || !this.mIsLogin || TextUtils.equals(this.cKR.anR().Iv().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.cKR != null) {
            this.cKR.saveToBundle(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.cjc != null) {
            this.cjc.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.richTextIntentClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onResume(getPageContext());
        }
        registerListener(this.richTextIntentClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onStop(getPageContext());
        }
        this.cjc.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cFp.onDestroy();
        this.cKR.cancelLoadData();
        this.cKR.destory();
        this.cKS.cancelLoadData();
        if (this.mVoiceManager != null) {
            this.mVoiceManager.onDestory(getPageContext());
        }
        this.cKT.ana();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cKT.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.mVoiceManager;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b getRealView(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View anF = this.cKT.anF();
        if (anF == null || (findViewWithTag = anF.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean kx(String str) {
        Map<String, String> dE;
        if (!TextUtils.isEmpty(str) && (dE = bf.dE(bf.dF(str))) != null) {
            String str2 = dE.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return kx(com.baidu.adp.lib.util.j.aU(str2));
            }
            String str3 = dE.get(cFg);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onLinkClicked(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (kx(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                bf.vn().b(getPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onAtClicked(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onVideoClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onSongClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onVideoP2PClicked(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onPhoneClicked(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public int getRichTextViewId() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<TextView> getTextViewPool() {
        if (this.aEX == null) {
            this.aEX = TbRichTextView.i(getPageContext().getPageActivity(), 8);
        }
        return this.aEX;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<GifView> getGifViewPool() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<ImageView> getImageViewPool() {
        if (this.aEW == null) {
            this.aEW = new com.baidu.adp.lib.f.b<>(new m(this), 8, 0);
        }
        return this.aEW;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<View> getVoiceViewPool() {
        if (this.aEY == null) {
            this.aEY = new com.baidu.adp.lib.f.b<>(new n(this), 8, 0);
        }
        return this.aEY;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<LinearLayout> getTextVoiceViewPool() {
        if (this.aEZ == null) {
            this.aEZ = new com.baidu.adp.lib.f.b<>(new o(this), 15, 0);
        }
        return this.aEZ;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.cKT.anB() && com.baidu.adp.lib.util.k.jh()) {
            this.cKR.Dy();
        } else {
            this.cKT.anE();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        if (sparseArray.get(n.g.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(n.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(n.g.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(n.g.tag_user_mute_thread_id);
        }
        if (sparseArray.get(n.g.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(n.g.tag_user_mute_post_id);
        }
        this.cFo.a(z, str, str2, str3, str4, UserMuteAddAndDelModel.From.PB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kL(String str) {
        String string;
        if (!StringUtils.isNull(str) && bj.ah(getPageContext().getPageActivity())) {
            if (!StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.tJ().getString("bubble_link", ""))) {
                com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(n.j.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void onLinkButtonClicked(Context context, String str) {
        g(context, str, "BUTTON");
    }
}
