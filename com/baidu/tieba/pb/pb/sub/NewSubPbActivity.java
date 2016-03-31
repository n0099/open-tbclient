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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.et;
import com.baidu.tieba.pb.pb.sub.ap;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.f.a;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
import com.baidu.tieba.usermute.k;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements BdListView.e, VoiceManager.c, com.baidu.tbadk.widget.richText.m {
    private com.baidu.adp.lib.f.b<ImageView> aIH;
    private com.baidu.adp.lib.f.b<TextView> aII;
    private com.baidu.adp.lib.f.b<View> aIJ;
    private com.baidu.adp.lib.f.b<View> aIK;
    private com.baidu.adp.lib.f.b<LinearLayout> aIL;
    private View.OnLongClickListener aoa;
    private VoiceManager bja;
    private View.OnClickListener brL;
    private com.baidu.tbadk.baseEditMark.a cOZ;
    private com.baidu.tbadk.editortools.d.p cye;
    private c.b dhm;
    private ap.a doA;
    private com.baidu.adp.base.g doB;
    private ap dou;
    private com.baidu.tieba.tbadkCore.f.a dov;
    private x dow;
    private AbsListView.OnScrollListener dox;
    private TbRichTextView.e doy;
    private TbRichTextView.d doz;
    private static final String dnv = String.valueOf(com.baidu.tbadk.data.c.SERVER_ADDRESS_WEB_VIEW) + "mo/q/icon/panelIcon";
    private static String dgt = "tbgametype";
    private boolean mIsFromCDN = true;
    private int dhj = 0;
    private com.baidu.tieba.usermute.k dgE = null;
    private a.InterfaceC0041a dhd = null;
    private a doC = null;
    private a doD = null;
    private UserMuteAddAndDelModel dgD = null;
    private k.a dgZ = new com.baidu.tieba.pb.pb.sub.a(this);
    private com.baidu.tbadk.editortools.d.c avF = new l(this);
    private a.d doE = new q(this);
    boolean dhk = false;
    private CustomMessageListener cam = new r(this, CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK);
    public final TbRichTextView.c dny = new s(this);

    /* loaded from: classes.dex */
    public interface a {
        void d(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aaR();
        azJ();
        initData(bundle);
        pU();
        initEditor();
        addGlobalLayoutListener();
        adjustResizeForSoftInput();
        azK();
    }

    public void pU() {
        this.dow = new x(this, this.brL);
        addContentView(this.dow.getRootView(), new FrameLayout.LayoutParams(-1, -1));
        this.dow.setOnScrollListener(this.dox);
        this.dow.d(this);
        this.dow.setOnLinkImageClickListener(this.doy);
        this.dow.setOnImageClickListener(this.doz);
        this.dow.setOnEmotionClickListener(this.dny);
        this.dow.fQ(true);
        this.dow.fR(com.baidu.tbadk.core.l.qE().qG());
        this.dow.setOnLongClickListener(this.aoa);
        this.dow.f(new t(this));
        this.dow.a(this.doC);
        this.dow.b(this.doD);
        if (this.dou != null && this.dou.azB() && !this.dou.aAv()) {
            this.dow.azU().setVisibility(8);
        } else {
            this.dow.azU().setVisibility(0);
        }
    }

    public void initData(Bundle bundle) {
        this.dgE = new com.baidu.tieba.usermute.k(getPageContext(), this.dgZ);
        this.dgD = new UserMuteAddAndDelModel(getPageContext());
        this.dou = new ap(getPageContext());
        this.dov = new com.baidu.tieba.tbadkCore.f.a(this);
        this.dov.setLoadDataCallBack(this.doB);
        this.bja = new VoiceManager();
        this.bja.onCreate(getPageContext());
        this.cOZ = com.baidu.tbadk.baseEditMark.a.a(this);
        if (this.cOZ != null) {
            this.cOZ.a(this.dhd);
        }
        if (bundle != null) {
            this.dou.initWithBundle(bundle);
        } else {
            this.dou.initWithIntent(getIntent());
        }
        this.dou.a(this.doA);
        if (this.dou.azB()) {
            this.dou.FG();
        } else {
            this.dou.aAm();
        }
    }

    public void azJ() {
        this.doA = new u(this);
        this.dhd = new v(this);
        this.doC = new w(this);
        this.doD = new b(this);
        this.doB = new c(this);
    }

    public void aaR() {
        this.brL = new d(this);
        this.dox = new e(this);
        this.dhm = new f(this);
        this.aoa = new g(this);
        this.doy = new h(this);
        this.doz = new i(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(com.baidu.tbadk.widget.richText.a aVar, com.baidu.tbadk.widget.richText.a aVar2, int i, int i2, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        int i3;
        int i4;
        com.baidu.tbadk.widget.richText.g Ir;
        if (aVar == aVar2) {
            this.dhk = true;
        }
        if (aVar != null) {
            int size = aVar.Im().size();
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            while (i6 < size) {
                if (aVar.Im().get(i6) != null && aVar.Im().get(i6).getType() == 8) {
                    i5++;
                    int width = aVar.Im().get(i6).Ir().getWidth();
                    int height = aVar.Im().get(i6).Ir().getHeight();
                    if ((width < 80 || height < 80 || height * width < 10000) || !aVar.Im().get(i6).Ir().IC()) {
                        if (aVar == aVar2 && i5 <= i2) {
                            i4 = i7 - 1;
                            i3 = i5;
                        }
                    } else {
                        com.baidu.tbadk.widget.richText.c cVar = aVar.Im().get(i6);
                        String e = e(cVar);
                        arrayList.add(e);
                        if (!TextUtils.isEmpty(e) && cVar != null && (Ir = cVar.Ir()) != null) {
                            String IE = Ir.IE();
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = IE;
                            imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                            if (concurrentHashMap != null) {
                                concurrentHashMap.put(e, imageUrlData);
                            }
                        }
                        if (!this.dhk) {
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
        com.baidu.tbadk.widget.richText.g Ir = cVar.Ir();
        if (Ir != null) {
            if (!StringUtils.isNull(Ir.IB())) {
                return Ir.IB();
            }
            if (Ir.getHeight() * Ir.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (Ir.getHeight() * Ir.getWidth()));
                sb.append("width=");
                sb.append(String.valueOf((int) (Ir.getWidth() * sqrt)));
                sb.append("&height=");
                sb.append(String.valueOf((int) (sqrt * Ir.getHeight())));
            } else {
                float width = Ir.getWidth() / Ir.getHeight();
                double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                sb.append("width=");
                sb.append(String.valueOf((int) (width * sqrt2)));
                sb.append("&height=");
                sb.append(String.valueOf((int) sqrt2));
            }
            sb.append("&src=");
            sb.append(ay.aU(Ir.getSrc()));
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.tbadk.widget.richText.a am(String str, int i) {
        if (this.dou == null || this.dou.aAg() == null || str == null || i < 0) {
            return null;
        }
        com.baidu.tieba.pb.data.g aAg = this.dou.aAg();
        com.baidu.tbadk.widget.richText.a a2 = a(aAg.avI(), str, i);
        if (a2 == null) {
            com.baidu.tbadk.widget.richText.a a3 = a(aAg.avI(), str, i);
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
        com.baidu.tbadk.widget.richText.a amn = sVar.amn();
        ArrayList<com.baidu.tbadk.widget.richText.c> Im = amn.Im();
        int size = Im.size();
        int i2 = -1;
        int i3 = 0;
        while (i3 < size) {
            if (Im.get(i3) != null && Im.get(i3).getType() == 8) {
                i2++;
                if (Im.get(i3).Ir().IE().equals(str)) {
                    int width = Im.get(i3).Ir().getWidth();
                    int height = Im.get(i3).Ir().getHeight();
                    if (width < 80 || height < 80 || height * width < 10000) {
                        return null;
                    }
                    this.dhj = i3;
                    return amn;
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
    public void e(Context context, String str, String str2) {
        long templateId = this.dou.aAg().avI().aTC() != null ? this.dou.aAg().avI().aTC().getTemplateId() : 0L;
        if (!TextUtils.isEmpty(str) && bg.wM().c(getPageContext(), new String[]{str}) && templateId != 0) {
            com.baidu.tieba.pb.b.a(templateId, str, "PB", str2, "CLICK", "ad_tpoint", this.dou.aAg().avP().getId(), this.dou.aAg().avP().getName(), this.dou.aAg().LC().getTid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(int i, String str) {
        if (!this.dou.aAh()) {
            if (com.baidu.adp.lib.util.k.jw()) {
                if (i == 4) {
                    this.dow.mf(String.valueOf(str) + "(4)");
                    return;
                } else {
                    this.dow.gk(t.j.no_data_text);
                    return;
                }
            }
            this.dow.gk(t.j.recommend_pb_no_net_text);
        }
    }

    private void initEditor() {
        this.cye = (com.baidu.tbadk.editortools.d.p) new com.baidu.tbadk.editortools.d.t().ah(getActivity());
        this.cye.a(getPageContext());
        this.cye.b(this.dou);
        this.cye.b(this.doE);
        this.cye.a(this.avF);
        this.cye.e(getPageContext());
        if (this.dow != null) {
            this.dow.e(this.cye);
        }
        if (this.cye != null && this.dou != null) {
            this.cye.a(this.dou.amu());
        }
    }

    public void azK() {
        if (!TbadkCoreApplication.isLogin()) {
            this.cye.Es();
        } else if (this.dou.aAr()) {
            if (!StringUtils.isNull(this.dou.aAo()) && !StringUtils.isNull(this.dou.aAs())) {
                new Handler().postDelayed(new j(this), 500L);
            } else {
                this.cye.fF(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aO(View view) {
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
                    this.dow.aN(view);
                }
            } else if (booleanValue2) {
                this.dow.a(((Integer) sparseArray.get(t.g.tag_del_post_type)).intValue(), (String) sparseArray.get(t.g.tag_del_post_id), ((Integer) sparseArray.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(t.g.tag_del_post_is_self)).booleanValue());
            }
            com.baidu.adp.lib.h.j.a(this.dow.azW(), getPageContext().getPageActivity());
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
        cVar.cd(t.j.operation);
        cVar.a(strArr, new k(this, sparseArray, z, str));
        cVar.d(getPageContext()).us();
    }

    public void d(SparseArray<Object> sparseArray) {
        String str;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!(sparseArray.get(t.g.tag_user_mute_mute_userid) instanceof String)) {
            str = "";
        } else {
            str = (String) sparseArray.get(t.g.tag_user_mute_mute_userid);
        }
        this.dow.akp();
        this.dgE.a(com.baidu.adp.lib.h.b.c(currentAccount, 0L), com.baidu.adp.lib.h.b.c(str, 0L), sparseArray);
    }

    public void a(a.b bVar) {
        if (bVar != null) {
            this.dow.a(0, bVar.AU, bVar.erS, true);
            if (bVar.AU) {
                if (bVar.erQ == 1) {
                    finish();
                } else if (bVar.erQ == 2) {
                    this.dou.mi(bVar.mPostId);
                    this.dow.a(this.dou.aAg(), this.dou.avB(), this.dou.aAw() != null);
                }
                com.baidu.tieba.pb.f fVar = new com.baidu.tieba.pb.f();
                fVar.setData(bVar);
                fVar.setType(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.UPDATE_PB_SUBPB_CMD, fVar));
            }
        }
    }

    public void lN(String str) {
        if (!StringUtils.isNull(str) && this.dou != null) {
            String threadID = this.dou.getThreadID();
            String DH = this.dou.DH();
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(getPageContext().getPageActivity(), getResources().getString(t.j.pb_web_view_report_title), "http://tieba.baidu.com/mo/q/postreport?fid=" + DH + "&tid=" + threadID + "&pid=" + str, true)));
        }
    }

    public void d(com.baidu.tieba.tbadkCore.data.s sVar) {
        if (sVar != null) {
            boolean z = false;
            if (this.dou.isMarked() && sVar.getId() != null && sVar.getId().equals(this.dou.aAq())) {
                z = true;
            }
            MarkData e = this.dou.e(sVar);
            if (e != null) {
                this.dow.amI();
                if (this.cOZ != null) {
                    this.cOZ.a(e);
                    if (!z) {
                        this.cOZ.pw();
                    } else {
                        this.cOZ.pv();
                    }
                }
            }
        }
    }

    public void replyPost(View view) {
        if (this.dow.azW() == null || this.dow.azV() == null) {
            this.dow.awl();
        }
        if (this.dow.azW().getIsIntercepted()) {
            this.dow.azW().setIsIntercepted(false);
            return;
        }
        if (view != null && view.getTag() != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.s sVar = sparseArray.get(t.g.tag_load_sub_data) instanceof com.baidu.tieba.tbadkCore.data.s ? (com.baidu.tieba.tbadkCore.data.s) sparseArray.get(t.g.tag_load_sub_data) : null;
            View view2 = sparseArray.get(t.g.tag_load_sub_view) instanceof View ? (View) sparseArray.get(t.g.tag_load_sub_view) : null;
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(t.g.tag_load_sub_data, sVar);
            sparseArray2.put(t.g.tag_load_sub_view, view2);
            this.dow.azV().aye().setTag(sparseArray2);
            SparseArray sparseArray3 = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.s sVar2 = sparseArray3.get(t.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.s ? (com.baidu.tieba.tbadkCore.data.s) sparseArray3.get(t.g.tag_clip_board) : null;
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(t.g.tag_clip_board, sVar2);
            sparseArray4.put(t.g.tag_is_subpb, false);
            this.dow.azV().axB().setTag(sparseArray4);
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
                this.dow.azV().ayf().setTag(sparseArray6);
                if (!"".equals(sparseArray5.get(t.g.tag_forbid_user_name)) && !"".equals(sparseArray5.get(t.g.tag_del_post_id))) {
                    at.c(this.dow.azV().ayf(), t.f.icon_pb_set_n);
                } else {
                    at.c(this.dow.azV().ayf(), t.f.icon_pb_del_n);
                }
                this.dow.azV().ayf().setVisibility(0);
            } else if (booleanValue3) {
                SparseArray sparseArray7 = new SparseArray();
                sparseArray7.put(t.g.tag_should_manage_visible, false);
                sparseArray7.put(t.g.tag_user_mute_visible, false);
                sparseArray7.put(t.g.tag_should_delete_visible, true);
                sparseArray7.put(t.g.tag_manage_user_identity, sparseArray5.get(t.g.tag_manage_user_identity));
                sparseArray7.put(t.g.tag_del_post_is_self, Boolean.valueOf(booleanValue4));
                sparseArray7.put(t.g.tag_del_post_id, sparseArray5.get(t.g.tag_del_post_id));
                sparseArray7.put(t.g.tag_del_post_type, sparseArray5.get(t.g.tag_del_post_type));
                this.dow.azV().ayf().setTag(sparseArray7);
                at.c(this.dow.azV().ayf(), t.f.icon_pb_del_n);
                this.dow.azV().ayf().setVisibility(0);
            } else {
                this.dow.azV().ayf().setVisibility(8);
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
                this.dow.azV().ayg().setTag(sparseArray9);
                this.dow.azV().ayg().setVisibility(0);
                this.dow.azV().ayf().setVisibility(8);
                at.c(this.dow.azV().ayg(), t.f.icon_pb_gag);
            } else {
                boolean booleanValue6 = sparseArray8.get(t.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray8.get(t.g.tag_del_post_is_self)).booleanValue() : false;
                String str2 = sparseArray8.get(t.g.tag_forbid_user_post_id) instanceof String ? (String) sparseArray8.get(t.g.tag_forbid_user_post_id) : null;
                if (et.g(sparseArray8.get(t.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.s ? (com.baidu.tieba.tbadkCore.data.s) sparseArray8.get(t.g.tag_clip_board) : null) ? false : fW(booleanValue6) & isLogin()) {
                    this.dow.azV().ayg().setVisibility(0);
                    this.dow.azV().ayg().setTag(str2);
                } else {
                    this.dow.azV().ayg().setVisibility(8);
                }
            }
        }
        if (this.dou.isMarked()) {
            this.dow.azV().axB().setText(t.j.marked);
            this.dow.azV().axB().setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_pb_collect_s), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.dow.azV().axB().setText(t.j.mark);
            this.dow.azV().axB().setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(t.f.icon_pb_collect_n), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.dow.azV().gg(false);
        this.dow.azW().reLayoutWidth();
        if (view != null) {
            this.dow.azW().showWindowInLeftCenterOfHost(view, true);
        }
    }

    private boolean fW(boolean z) {
        return (this.dou == null || this.dou.aAg() == null || z || this.dou.avB() != 0 || this.dou.aAg().LC() == null || this.dou.aAg().LC().getAuthor() == null || !this.mIsLogin || TextUtils.equals(this.dou.aAg().LC().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount())) ? false : true;
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null && this.dou != null) {
            this.dou.o(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.cye != null) {
            this.cye.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.bja != null) {
            this.bja.onStart(getPageContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.bja != null) {
            this.bja.onPause(getPageContext());
        }
        MessageManager.getInstance().unRegisterListener(this.cam);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bja != null) {
            this.bja.onResume(getPageContext());
        }
        registerListener(this.cam);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.bja != null) {
            this.bja.onStop(getPageContext());
        }
        this.cye.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dgE.onDestroy();
        this.dou.cancelLoadData();
        this.dou.destory();
        this.dov.cancelLoadData();
        if (this.bja != null) {
            this.bja.onDestory(getPageContext());
        }
        this.dow.amI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dow.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        return this.bja;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        View findViewWithTag;
        View azT = this.dow.azT();
        if (azT == null || (findViewWithTag = azT.findViewWithTag(voiceModel)) == null) {
            return null;
        }
        return (VoiceManager.b) findViewWithTag;
    }

    public boolean lO(String str) {
        Map<String, String> dE;
        if (!TextUtils.isEmpty(str) && (dE = bg.dE(bg.dF(str))) != null) {
            String str2 = dE.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return lO(com.baidu.adp.lib.util.j.aV(str2));
            }
            String str3 = dE.get(dgt);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void z(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (lO(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            } else {
                bg.wM().c(getPageContext(), new String[]{str});
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void y(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void A(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void B(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void C(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void d(Context context, String str, String str2) {
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public int IN() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<TextView> IP() {
        if (this.aII == null) {
            this.aII = TbRichTextView.g(getPageContext().getPageActivity(), 8);
        }
        return this.aII;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<GifView> IQ() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<ImageView> IO() {
        if (this.aIH == null) {
            this.aIH = new com.baidu.adp.lib.f.b<>(new m(this), 8, 0);
        }
        return this.aIH;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> IR() {
        if (this.aIK == null) {
            this.aIK = new com.baidu.adp.lib.f.b<>(new n(this), 8, 0);
        }
        return this.aIK;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<LinearLayout> IS() {
        if (this.aIL == null) {
            this.aIL = new com.baidu.adp.lib.f.b<>(new o(this), 15, 0);
        }
        return this.aIL;
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public com.baidu.adp.lib.f.b<View> IT() {
        if (this.aIJ == null) {
            this.aIJ = com.baidu.tieba.graffiti.e.j(getPageContext().getPageActivity(), 8);
        }
        return this.aIJ;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nm() {
        if (this.dow.azP() && com.baidu.adp.lib.util.k.jw()) {
            this.dou.FG();
        } else {
            this.dow.azS();
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        if (sparseArray.get(t.g.tag_user_mute_mute_username) instanceof String) {
            str3 = (String) sparseArray.get(t.g.tag_user_mute_mute_username);
        }
        if (sparseArray.get(t.g.tag_user_mute_thread_id) instanceof String) {
            str4 = (String) sparseArray.get(t.g.tag_user_mute_thread_id);
        }
        if (!(sparseArray.get(t.g.tag_user_mute_post_id) instanceof String)) {
            str2 = "";
        } else {
            str2 = (String) sparseArray.get(t.g.tag_user_mute_post_id);
        }
        String str6 = sparseArray.get(t.g.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(t.g.tag_user_mute_msg) : str2;
        if (sparseArray.get(t.g.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(t.g.tag_user_mute_msg);
        }
        this.dgD.a(z, str, str3, str4, str6, UserMuteAddAndDelModel.From.PB, str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void me(String str) {
        String string;
        if (!StringUtils.isNull(str) && bl.ad(getPageContext().getPageActivity())) {
            if (!StringUtils.isNull(com.baidu.tbadk.core.sharedPref.b.vk().getString("bubble_link", ""))) {
                com.baidu.tbadk.browser.f.a(getPageContext().getPageActivity(), getResources().getString(t.j.bubble_web_view_title), String.valueOf(string) + "?props_id=" + str, true, true, true);
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.m
    public void D(Context context, String str) {
        e(context, str, "BUTTON");
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a007";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new p(this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.pageStayDuration.d getPageStayDurationItem() {
        com.baidu.tbadk.pageStayDuration.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null && this.dou != null) {
            if (this.dou.aAg() != null && this.dou.aAg().avP() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.h.b.c(this.dou.aAg().avP().getId(), 0L));
            }
            pageStayDurationItem.setTid(com.baidu.adp.lib.h.b.c(this.dou.getThreadID(), 0L));
        }
        return pageStayDurationItem;
    }
}
