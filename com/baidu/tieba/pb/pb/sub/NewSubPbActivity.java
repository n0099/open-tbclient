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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.dy;
import com.baidu.tieba.pb.pb.sub.ao;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.f.a;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.i;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.l {
    private com.baidu.adp.lib.f.b<ImageView> aFO;
    private com.baidu.adp.lib.f.b<TextView> aFP;
    private com.baidu.adp.lib.f.b<View> aFQ;
    private com.baidu.adp.lib.f.b<LinearLayout> aFR;
    private View.OnLongClickListener anJ;
    private VoiceManager ben;
    private View.OnClickListener bmy;
    private com.baidu.tbadk.baseEditMark.a cMG;
    private c.b cNn;
    private com.baidu.tieba.tbadkCore.f.a cTA;
    private w cTB;
    private AbsListView.OnScrollListener cTC;
    private TbRichTextView.e cTD;
    private TbRichTextView.d cTE;
    private ao.a cTF;
    private com.baidu.adp.base.g cTG;
    private ao cTz;
    private com.baidu.tbadk.editortools.d.p cnC;
    private static final String cSD = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String cMz = "tbgametype";
    private boolean mIsFromCDN = true;
    private int cNk = 0;
    private com.baidu.tieba.usermute.i cMJ = null;
    private a.InterfaceC0041a cNf = null;
    private a cTH = null;
    private a cTI = null;
    private UserMuteAddAndDelModel cMI = null;
    private i.a cNc = new com.baidu.tieba.pb.pb.sub.a(this);
    private com.baidu.tbadk.editortools.d.c avf = new l(this);
    private a.d cTJ = new p(this);
    boolean cNl = false;
    private CustomMessageListener bPU = new q(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    public final TbRichTextView.c cSG = new r(this);

    /* loaded from: classes.dex */
    public interface a {
        void d(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Xr();
        arY();
        initData(bundle);
        qD();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        arZ();
    }

    public void qD() {
        this.cTB = new w(this, this.bmy);
        addContentView(this.cTB.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.cTB.setOnScrollListener(this.cTC);
        this.cTB.d(this);
        this.cTB.setOnLinkImageClickListener(this.cTD);
        this.cTB.setOnImageClickListener(this.cTE);
        this.cTB.setOnEmotionClickListener(this.cSG);
        this.cTB.fg(true);
        this.cTB.fh(com.baidu.tbadk.core.l.rn().rp());
        this.cTB.setOnLongClickListener(this.anJ);
        this.cTB.f(new s(this));
        this.cTB.a(this.cTH);
        this.cTB.b(this.cTI);
        if (this.cTz != null && this.cTz.arS() && !this.cTz.asL()) {
            this.cTB.asj().setVisibility(8);
        } else {
            this.cTB.asj().setVisibility(0);
        }
    }

    public void initData(Bundle bundle) {
        this.cMJ = new com.baidu.tieba.usermute.i(getPageContext(), this.cNc);
        this.cMI = new UserMuteAddAndDelModel(getPageContext());
        this.cTz = new ao(getPageContext());
        this.cTA = new com.baidu.tieba.tbadkCore.f.a(this);
        this.cTA.setLoadDataCallBack(this.cTG);
        this.ben = new VoiceManager();
        this.ben.onCreate(getPageContext());
        this.cMG = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.cMG != null) {
            this.cMG.a(this.cNf);
        }
        if (bundle != null) {
            this.cTz.initWithBundle(bundle);
        } else {
            this.cTz.initWithIntent(getIntent());
        }
        this.cTz.a(this.cTF);
        if (this.cTz.arS()) {
            this.cTz.ET();
        } else {
            this.cTz.asC();
        }
    }

    public void arY() {
        this.cTF = new t(this);
        this.cNf = new u(this);
        this.cTH = new v(this);
        this.cTI = new b(this);
        this.cTG = new c(this);
    }

    public void Xr() {
        this.bmy = new d(this);
        this.cTC = new e(this);
        this.cNn = new f(this);
        this.anJ = new g(this);
        this.cTD = new h(this);
        this.cTE = new i(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.f GX;
        if (aVar == aVar2) {
            this.cNl = true;
        }
        if (aVar != null) {
            int size = aVar.GS().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.GS().get(i6) != null && aVar.GS().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.GS().get(i6).GX().getWidth();
                    int height = aVar.GS().get(i6).GX().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.GS().get(i6).GX().Hh()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.GS().get(i6);
                        String e = e(cVar);
                        arrayList.add(e);
                        if (!TextUtils.isEmpty(e) && cVar != null && (GX = cVar.GX()) != null) {
                            String Hi = GX.Hi();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = Hi;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(e, imageUrlData);
                            }
                        }
                        if (!this.cNl) {
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
    public String e(com.baidu.tbadk.widget.richText.c cVar) {
        if (cVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(150);
        com.baidu.tbadk.widget.richText.f GX = cVar.GX();
        if (GX != null) {
            if (!StringUtils.isNull(GX.Hg())) {
                return GX.Hg();
            }
            if (GX.getHeight() * GX.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (GX.getHeight() * GX.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (GX.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * GX.getHeight())));
            } else {
                float width = GX.getWidth() / GX.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(aw.aS(GX.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a ae(String str, int i) {
        if (this.cTz == null || this.cTz.asw() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.a.d asw = this.cTz.asw();
        com.baidu.tbadk.widget.richText.a a2 = a(asw.aoQ(), str, i);
        if (a2 == null) {
            com.baidu.tbadk.widget.richText.a a3 = a(asw.aoQ(), str, i);
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
        com.baidu.tbadk.widget.richText.a aiT = rVar.aiT();
        ArrayList<com.baidu.tbadk.widget.richText.c> GS = aiT.GS();
        int size = GS.size();
        int i2 = -1;
        int i3 = 0;
        while (i3 < size) {
            if (GS.get(i3) != null && GS.get(i3).getType() == 8) {
                i2++;
                if (GS.get(i3).GX().Hi().equals(str)) {
                    int width = GS.get(i3).GX().getWidth();
                    int height = GS.get(i3).GX().getHeight();
                    if (width < 80 || height < 80 || height * width < 10000) {
                        return null;
                    }
                    this.cNk = i3;
                    return aiT;
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
    public void h(Context context, String str, String str2) {
        long templateId = this.cTz.asw().aoQ().aMF() != null ? this.cTz.asw().aoQ().aMF().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && be.wt().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.a.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.cTz.asw().aoX().getId(), this.cTz.asw().aoX().getName(), this.cTz.asw().Ki().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(int i, String str) {
        if (!this.cTz.asx()) {
            if (com.baidu.adp.lib.util.k.jq()) {
                if (i == 4) {
                    this.cTB.hw(String.valueOf(str) + "(4)");
                    return;
                } else {
                    this.cTB.fU(t.j.no_data_text);
                    return;
                }
            }
            this.cTB.fU(t.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.cnC = (com.baidu.tbadk.editortools.d.p) new com.baidu.tbadk.editortools.d.t().ak(getActivity());
        this.cnC.a(getPageContext());
        this.cnC.b(this.cTz);
        this.cnC.b(this.cTJ);
        this.cnC.a(this.avf);
        this.cnC.e(getPageContext());
        if (this.cTB != null) {
            this.cTB.e(this.cnC);
        }
        if (this.cnC != null && this.cTz != null) {
            this.cnC.a(this.cTz.ajb());
        }
    }

    public void arZ() {
        if (!TbadkCoreApplication.isLogin()) {
            this.cnC.DI();
        } else if (this.cTz.asH()) {
            if (!StringUtils.isNull(this.cTz.asE()) && !StringUtils.isNull(this.cTz.asI())) {
                new Handler().postDelayed(new j(this), 500L);
            } else {
                this.cnC.fx(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(View view) {
        SparseArray<Object> sparseArray;
        if (view != null && (sparseArray = (SparseArray) view.getTag()) != null) {
            boolean booleanValue = sparseArray.get(t.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(t.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(t.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(t.g.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(t.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(t.g.tag_user_mute_visible)).booleanValue() : false;
            if (booleanValue) {
                if (booleanValue3) {
                    sparseArray.put(t.g.tag_from, 1);
                    d(sparseArray);
                } else {
                    this.cTB.aF(view);
                }
            } else if (booleanValue2) {
                this.cTB.a(((Integer) sparseArray.get(t.g.tag_del_post_type)).intValue(), (String) sparseArray.get(t.g.tag_del_post_id), ((Integer) sparseArray.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(t.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.h.j.a(this.cTB.asl(), getPageContext().getPageActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, SparseArray<Object> sparseArray) {
        String str;
        String[] strArr;
        if (!(sparseArray.get(t.g.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(t.g.tag_user_mute_mute_userid);
        }
        if (((Boolean) sparseArray.get(t.g.tag_user_mute_visible)).booleanValue()) {
            String[] strArr2 = new String[2];
            strArr2[0] = getResources().getString(t.j.delete);
            strArr2[1] = z ? getResources().getString(t.j.un_mute) : getResources().getString(t.j.mute);
            strArr = strArr2;
        } else {
            strArr = new String[]{getResources().getString(t.j.delete)};
        }
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.cb(t.j.operation);
        cVar.a(strArr, new k(this, sparseArray, z, str));
        cVar.d(getPageContext()).un();
    }

    public void d(SparseArray<Object> sparseArray) {
        String str;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!(sparseArray.get(t.g.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(t.g.tag_user_mute_mute_userid);
        }
        this.cTB.agV();
        this.cMJ.a(com.baidu.adp.lib.h.b.c(currentAccount, 0L), com.baidu.adp.lib.h.b.c(str, 0L), sparseArray);
    }

    public void a(a.b bVar) {
        if (bVar != null) {
            this.cTB.a(0, bVar.AD, bVar.dZa, true);
            if (bVar.AD) {
                if (bVar.dYY == 1) {
                    finish();
                } else if (bVar.dYY == 2) {
                    this.cTz.kU(bVar.mPostId);
                    this.cTB.a(this.cTz.asw(), this.cTz.aoJ(), this.cTz.asM() != null);
                }
                com.baidu.tieba.pb.e eVar = new com.baidu.tieba.pb.e();
                eVar.setData(bVar);
                eVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, eVar));
            }
        }
    }

    public void kA(String str) {
        if (!StringUtils.isNull(str) && this.cTz != null) {
            String threadID = this.cTz.getThreadID();
            String CZ = this.cTz.CZ();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(t.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + CZ + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void d(com.baidu.tieba.tbadkCore.data.r rVar) {
        if (rVar != null) {
            boolean z = false;
            if (this.cTz.isMarked() && rVar.getId() != null && rVar.getId().equals(this.cTz.asG())) {
                z = true;
            }
            MarkData e = this.cTz.e(rVar);
            if (e != null) {
                this.cTB.ajp();
                if (this.cMG != null) {
                    this.cMG.a(e);
                    if (!z) {
                        this.cMG.qi();
                    } else {
                        this.cMG.qh();
                    }
                }
            }
        }
    }

    public void replyPost(View view) {
        if (this.cTB.asl() == null || this.cTB.ask() == null) {
            this.cTB.apm();
        }
        if (this.cTB.asl().getIsIntercepted()) {
            this.cTB.asl().setIsIntercepted(false);
            return;
        }
        if (view != null && view.getTag() != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.r rVar = sparseArray.get(t.g.tag_load_sub_data) instanceof com.baidu.tieba.tbadkCore.data.r ? (com.baidu.tieba.tbadkCore.data.r) sparseArray.get(t.g.tag_load_sub_data) : null;
            View view2 = sparseArray.get(t.g.tag_load_sub_view) instanceof View ? (View) sparseArray.get(t.g.tag_load_sub_view) : null;
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(t.g.tag_load_sub_data, rVar);
            sparseArray2.put(t.g.tag_load_sub_view, view2);
            this.cTB.ask().aqO().setTag(sparseArray2);
            SparseArray sparseArray3 = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.r rVar2 = sparseArray3.get(t.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.r ? (com.baidu.tieba.tbadkCore.data.r) sparseArray3.get(t.g.tag_clip_board) : null;
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(t.g.tag_clip_board, rVar2);
            sparseArray4.put(t.g.tag_is_subpb, false);
            this.cTB.ask().aql().setTag(sparseArray4);
            SparseArray sparseArray5 = (SparseArray) view.getTag();
            boolean booleanValue = sparseArray5.get(t.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(t.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray5.get(t.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(t.g.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray5.get(t.g.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(t.g.tag_should_delete_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray5.get(t.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray5.get(t.g.tag_del_post_is_self)).booleanValue() : false;
            if (sparseArray5.get(t.g.tag_forbid_user_post_id) instanceof String) {
                String str = (String) sparseArray5.get(t.g.tag_forbid_user_post_id);
            }
            if (booleanValue) {
                SparseArray sparseArray6 = new SparseArray();
                sparseArray6.put(t.g.tag_should_manage_visible, true);
                sparseArray6.put(t.g.tag_manage_user_identity, sparseArray5.get(t.g.tag_manage_user_identity));
                sparseArray6.put(t.g.tag_del_post_is_self, sparseArray5.get(t.g.tag_del_post_is_self));
                sparseArray6.put(t.g.tag_del_post_id, sparseArray5.get(t.g.tag_del_post_id));
                sparseArray6.put(t.g.tag_del_post_type, sparseArray5.get(t.g.tag_del_post_type));
                sparseArray6.put(t.g.tag_forbid_user_name, sparseArray5.get(t.g.tag_forbid_user_name));
                sparseArray6.put(t.g.tag_forbid_user_post_id, sparseArray5.get(t.g.tag_forbid_user_post_id));
                if (booleanValue2) {
                    sparseArray6.put(t.g.tag_user_mute_visible, true);
                    sparseArray6.put(t.g.tag_is_mem, sparseArray5.get(t.g.tag_is_mem));
                    sparseArray6.put(t.g.tag_user_mute_mute_userid, sparseArray5.get(t.g.tag_user_mute_mute_userid));
                    sparseArray6.put(t.g.tag_user_mute_mute_username, sparseArray5.get(t.g.tag_user_mute_mute_username));
                    sparseArray6.put(t.g.tag_user_mute_post_id, sparseArray5.get(t.g.tag_user_mute_post_id));
                    sparseArray6.put(t.g.tag_user_mute_thread_id, sparseArray5.get(t.g.tag_user_mute_thread_id));
                } else {
                    sparseArray6.put(t.g.tag_user_mute_visible, false);
                }
                if (booleanValue3) {
                    sparseArray6.put(t.g.tag_should_delete_visible, true);
                    sparseArray6.put(t.g.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                    sparseArray6.put(t.g.tag_del_post_id, sparseArray5.get(t.g.tag_del_post_id));
                    sparseArray6.put(t.g.tag_del_post_type, sparseArray5.get(t.g.tag_del_post_type));
                } else {
                    sparseArray6.put(t.g.tag_should_delete_visible, false);
                }
                this.cTB.ask().aqP().setTag(sparseArray6);
                if (!"".equals(sparseArray5.get(t.g.tag_forbid_user_name)) && !"".equals(sparseArray5.get(t.g.tag_del_post_id))) {
                    ar.c(this.cTB.ask().aqP(), t.f.icon_pb_set_n);
                } else {
                    ar.c(this.cTB.ask().aqP(), t.f.icon_pb_del_n);
                }
                this.cTB.ask().aqP().setVisibility(0);
            } else if (booleanValue3) {
                SparseArray sparseArray7 = new SparseArray();
                sparseArray7.put(t.g.tag_should_manage_visible, false);
                sparseArray7.put(t.g.tag_user_mute_visible, false);
                sparseArray7.put(t.g.tag_should_delete_visible, true);
                sparseArray7.put(t.g.tag_manage_user_identity, sparseArray5.get(t.g.tag_manage_user_identity));
                sparseArray7.put(t.g.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                sparseArray7.put(t.g.tag_del_post_id, sparseArray5.get(t.g.tag_del_post_id));
                sparseArray7.put(t.g.tag_del_post_type, sparseArray5.get(t.g.tag_del_post_type));
                this.cTB.ask().aqP().setTag(sparseArray7);
                ar.c(this.cTB.ask().aqP(), t.f.icon_pb_del_n);
                this.cTB.ask().aqP().setVisibility(0);
            } else {
                this.cTB.ask().aqP().setVisibility(8);
            }
            SparseArray sparseArray8 = (SparseArray) view.getTag();
            boolean booleanValue5 = sparseArray8.get(t.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray8.get(t.g.tag_user_mute_visible)).booleanValue() : false;
            if (!((Boolean) sparseArray8.get(t.g.tag_should_manage_visible)).booleanValue() && booleanValue5) {
                SparseArray sparseArray9 = new SparseArray();
                sparseArray9.put(t.g.tag_user_mute_visible, true);
                sparseArray9.put(t.g.tag_is_mem, sparseArray8.get(t.g.tag_is_mem));
                sparseArray9.put(t.g.tag_user_mute_mute_userid, sparseArray8.get(t.g.tag_user_mute_mute_userid));
                sparseArray9.put(t.g.tag_user_mute_mute_username, sparseArray8.get(t.g.tag_user_mute_mute_username));
                sparseArray9.put(t.g.tag_user_mute_post_id, sparseArray8.get(t.g.tag_user_mute_post_id));
                sparseArray9.put(t.g.tag_user_mute_thread_id, sparseArray8.get(t.g.tag_user_mute_thread_id));
                sparseArray9.put(t.g.tag_del_post_is_self, sparseArray8.get(t.g.tag_del_post_is_self));
                sparseArray9.put(t.g.tag_del_post_type, sparseArray8.get(t.g.tag_del_post_type));
                sparseArray9.put(t.g.tag_del_post_id, sparseArray8.get(t.g.tag_del_post_id));
                sparseArray9.put(t.g.tag_manage_user_identity, sparseArray8.get(t.g.tag_manage_user_identity));
                this.cTB.ask().aqQ().setTag(sparseArray9);
                this.cTB.ask().aqQ().setVisibility(0);
                this.cTB.ask().aqP().setVisibility(8);
                ar.c(this.cTB.ask().aqQ(), t.f.icon_pb_gag);
            } else {
                boolean booleanValue6 = sparseArray8.get(t.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray8.get(t.g.tag_del_post_is_self)).booleanValue() : false;
                String str2 = sparseArray8.get(t.g.tag_forbid_user_post_id) instanceof String ? (String) sparseArray8.get(t.g.tag_forbid_user_post_id) : null;
                if (dy.g(sparseArray8.get(t.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.r ? (com.baidu.tieba.tbadkCore.data.r) sparseArray8.get(t.g.tag_clip_board) : null) ? false : fl(booleanValue6) & isLogin()) {
                    this.cTB.ask().aqQ().setVisibility(0);
                    this.cTB.ask().aqQ().setTag(str2);
                } else {
                    this.cTB.ask().aqQ().setVisibility(8);
                }
            }
        }
        if (this.cTz.isMarked()) {
            this.cTB.ask().aql().setText(t.j.marked);
            this.cTB.ask().aql().setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.cTB.ask().aql().setText(t.j.mark);
            this.cTB.ask().aql().setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.cTB.ask().fw(false);
        this.cTB.asl().reLayoutWidth();
        if (view != null) {
            this.cTB.asl().showWindowInLeftCenterOfHost(view, false);
        }
    }

    private boolean fl(boolean z) {
        return (this.cTz == null || this.cTz.asw() == null || z || this.cTz.aoJ() != 0 || this.cTz.asw().Ki() == null || this.cTz.asw().Ki().getAuthor() == null || !this.mIsLogin || TextUtils.equals(this.cTz.asw().Ki().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.cTz != null) {
            this.cTz.m(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.cnC != null) {
            this.cnC.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.ben != null) {
            this.ben.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.ben != null) {
            this.ben.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.bPU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.ben != null) {
            this.ben.onResume(getPageContext());
        }
        registerListener(this.bPU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.ben != null) {
            this.ben.onStop(getPageContext());
        }
        this.cnC.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.cMJ.onDestroy();
        this.cTz.cancelLoadData();
        this.cTz.destory();
        this.cTA.cancelLoadData();
        if (this.ben != null) {
            this.ben.onDestory(getPageContext());
        }
        this.cTB.ajp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cTB.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.ben;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View asi = this.cTB.asi();
        if (asi == null || (findViewWithTag = asi.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean kB(String str) {
        Map<String, String> dB;
        if (!TextUtils.isEmpty(str) && (dB = be.dB(be.dC(str))) != null) {
            String str2 = dB.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return kB(com.baidu.adp.lib.util.j.aT(str2));
            }
            String str3 = dB.get(cMz);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void I(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (kB(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                be.wt().c(getPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void H(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void J(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void K(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void L(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void g(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public int Hr() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<TextView> Ht() {
        if (this.aFP == null) {
            this.aFP = TbRichTextView.g(getPageContext().getPageActivity(), 8);
        }
        return this.aFP;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<GifView> Hu() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<ImageView> Hs() {
        if (this.aFO == null) {
            this.aFO = new com.baidu.adp.lib.f.b<>(new m(this), 8, 0);
        }
        return this.aFO;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<View> Hv() {
        if (this.aFQ == null) {
            this.aFQ = new com.baidu.adp.lib.f.b<>(new n(this), 8, 0);
        }
        return this.aFQ;
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public com.baidu.adp.lib.f.b<LinearLayout> Hw() {
        if (this.aFR == null) {
            this.aFR = new com.baidu.adp.lib.f.b<>(new o(this), 15, 0);
        }
        return this.aFR;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nv() {
        if (this.cTB.ase() && com.baidu.adp.lib.util.k.jq()) {
            this.cTz.ET();
        } else {
            this.cTB.ash();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        if (sparseArray.get(t.g.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(t.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(t.g.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(t.g.tag_user_mute_thread_id);
        }
        if (sparseArray.get(t.g.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(t.g.tag_user_mute_post_id);
        }
        this.cMI.a(z, str, str2, str3, str4, UserMuteAddAndDelModel.From.PB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kR(String str) {
        String string;
        if (!StringUtils.isNull(str) && bi.ah(getPageContext().getPageActivity())) {
            if (!StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.uO().getString("bubble_link", ""))) {
                com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(t.j.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.l
    public void M(Context context, String str) {
        h(context, str, "BUTTON");
    }
}
