package com.baidu.tieba.pb.videopb.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tbadk.pageExtra.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.f;
import com.baidu.tieba.NEGFeedBack.h;
import com.baidu.tieba.NEGFeedBack.i;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.ac;
import com.baidu.tieba.pb.pb.main.ad;
import com.baidu.tieba.pb.pb.main.at;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.e;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
import tbclient.ForumToolPerm;
/* loaded from: classes2.dex */
public class a {
    public static int mcp = 3;
    public static int mcq = 0;
    public static int mcr = 3;
    public static int mcs = 4;
    public static int mct = 5;
    public static int mcu = 6;
    private at eKr;
    private e ffO;
    private com.baidu.tbadk.core.message.a fge;
    private List<CustomBlueCheckRadioButton> iBq;
    private f jSR;
    private String lPu;
    private com.baidu.tieba.pb.pb.report.a lTR;
    private i lTY;
    private k lTZ;
    private boolean lTl;
    public BdUniqueId lUo;
    private com.baidu.adp.widget.ImageView.a lUq;
    private String lUr;
    private TbRichTextMemeInfo lUs;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    private com.baidu.tieba.NEGFeedBack.i mcO;
    private PbFragment.b mdc;
    public VideoPbFragment mog;
    private Runnable runnable;
    private i mbH = null;
    private com.baidu.tbadk.core.dialog.a mbz = null;
    private Dialog mbA = null;
    private Dialog mbB = null;
    private View mbC = null;
    private LinearLayout mbD = null;
    private TextView mbE = null;
    private TextView mbF = null;
    private String mbG = null;
    private ScrollView mbK = null;
    private CompoundButton.OnCheckedChangeListener iBr = null;
    private i mby = null;
    private com.baidu.tbadk.core.view.a iFD = null;
    private com.baidu.tbadk.core.dialog.b lTr = null;
    private AlertDialog mhI = null;
    private ac mhJ = null;
    PostData ksi = null;
    private boolean lTP = d.bja();
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.12
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return a.this.dR(view);
        }
    };
    private k.c lUR = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (a.this.lTY != null) {
                a.this.lTY.dismiss();
            }
            a.this.FK(i);
            switch (i) {
                case -4:
                    View view2 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_share);
                    a.this.dD(view2);
                    if (view2 != null) {
                        view2.performClick();
                        return;
                    }
                    return;
                case -3:
                    View view3 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_reply);
                    a.this.dD(view3);
                    if (view3 != null) {
                        view3.performClick();
                        return;
                    }
                    return;
                case -2:
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    if (d.bjl() || d.bjm()) {
                        View view4 = (View) sparseArray2.get(R.id.pb_dialog_item_zan_2);
                        AgreeView agreeView = (AgreeView) view4;
                        a.this.dD(view4);
                        if (agreeView != null && agreeView.getImgDisagree() != null) {
                            agreeView.getImgDisagree().performClick();
                            return;
                        }
                        return;
                    }
                    View view5 = (View) sparseArray2.get(R.id.pb_dialog_item_zan_1);
                    AgreeView agreeView2 = (AgreeView) view5;
                    a.this.dD(view5);
                    if (agreeView2 != null && agreeView2.getImgDisagree() != null) {
                        agreeView2.getImgDisagree().performClick();
                        return;
                    }
                    return;
                case -1:
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (d.bjl() || d.bjm()) {
                        View view6 = (View) sparseArray3.get(R.id.pb_dialog_item_zan_2);
                        a.this.dD(view6);
                        AgreeView agreeView3 = (AgreeView) view6;
                        if (agreeView3 != null && agreeView3.getImgAgree() != null) {
                            agreeView3.getImgAgree().performClick();
                            return;
                        }
                        return;
                    }
                    View view7 = (View) sparseArray3.get(R.id.pb_dialog_item_zan_1);
                    a.this.dD(view7);
                    AgreeView agreeView4 = (AgreeView) view7;
                    if (agreeView4 != null && agreeView4.getImgAgree() != null) {
                        agreeView4.getImgAgree().performClick();
                        return;
                    }
                    return;
                case 0:
                default:
                    return;
                case 1:
                    if (a.this.lUq != null && !TextUtils.isEmpty(a.this.lUr)) {
                        if (a.this.lUs == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.lUr));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.lUr;
                            aVar.pkgId = a.this.lUs.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.lUs.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.lUq = null;
                        a.this.lUr = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.lUq != null && !TextUtils.isEmpty(a.this.lUr)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.mog.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.mog.getPageContext().getPageActivity())) {
                            if (a.this.eKr == null) {
                                a.this.eKr = new at(a.this.mog.getPageContext());
                            }
                            a.this.eKr.o(a.this.lUr, a.this.lUq.getImageByte());
                            a.this.lUq = null;
                            a.this.lUr = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.ksi != null) {
                        a.this.ksi.gV(a.this.mog.getPageContext().getPageActivity());
                        a.this.ksi = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new ar("c11739").aq("obj_locate", 2));
                    if (a.this.mog.checkUpIsLogin()) {
                        a.this.dE(view);
                        if (a.this.mog.dmG().getPbData().dlp() != null && a.this.mog.dmG().getPbData().dlp().bnS() != null && a.this.mog.dmG().getPbData().dlp().bnS().getUserId() != null && a.this.mog.duk() != null) {
                            int h = a.this.h(a.this.mog.dmG().getPbData());
                            cb dlp = a.this.mog.dmG().getPbData().dlp();
                            if (dlp.bmz()) {
                                i2 = 2;
                            } else if (dlp.bmA()) {
                                i2 = 3;
                            } else if (dlp.bpP()) {
                                i2 = 4;
                            } else {
                                i2 = dlp.bpQ() ? 5 : 1;
                            }
                            TiebaStatic.log(new ar("c12526").dR("tid", a.this.mog.dmG().doJ()).aq("obj_locate", 2).dR("obj_id", a.this.mog.dmG().getPbData().dlp().bnS().getUserId()).aq("obj_type", a.this.mog.duk().bkb() ? 0 : 1).aq("obj_source", h).aq("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.mog.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new ar("c13079"));
                        a.this.PA((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new ar("c11739").aq("obj_locate", 4));
                        SparseArray<Object> sparseArray4 = (SparseArray) tag;
                        if ((sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray4.put(R.id.tag_from, 0);
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            a.this.d(sparseArray4);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null && (sparseArray5.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_id) instanceof String) && (sparseArray5.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray5.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        a.this.a(((Integer) sparseArray5.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray5.get(R.id.tag_del_post_id), ((Integer) sparseArray5.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    if (!j.isNetWorkAvailable()) {
                        a.this.mog.showToast(R.string.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray6 = (SparseArray) view.getTag();
                    if (sparseArray6 != null) {
                        boolean booleanValue = ((Boolean) sparseArray6.get(R.id.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue2 = ((Boolean) sparseArray6.get(R.id.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue3 = ((Boolean) sparseArray6.get(R.id.tag_user_mute_visible)).booleanValue();
                        if (booleanValue) {
                            if (booleanValue3) {
                                sparseArray6.put(R.id.tag_from, 1);
                                sparseArray6.put(R.id.tag_check_mute_from, 2);
                                a.this.d(sparseArray6);
                                return;
                            }
                            sparseArray6.put(R.id.tag_check_mute_from, 2);
                            a.this.dL(view);
                            return;
                        } else if (booleanValue2) {
                            a.this.a(((Integer) sparseArray6.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray6.get(R.id.tag_del_post_id), ((Integer) sparseArray6.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray6.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 8:
                    if (bh.checkUpIsLogin(a.this.mog.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.bpL() != null) {
                            c bR = com.baidu.tbadk.pageExtra.d.bR(view);
                            if (bR != null) {
                                postData.bpL().objSource = bR.getCurrentPageKey();
                            }
                            a.this.d(postData.bpL());
                            return;
                        }
                        return;
                    }
                    return;
            }
        }
    };
    private final b.InterfaceC0564b lVf = new b.InterfaceC0564b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0564b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.lUq != null && !TextUtils.isEmpty(a.this.lUr)) {
                if (i == 0) {
                    if (a.this.lUs == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.lUr));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.lUr;
                        aVar.pkgId = a.this.lUs.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.lUs.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.mog.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.mog.getPageContext().getPageActivity())) {
                        if (a.this.eKr == null) {
                            a.this.eKr = new at(a.this.mog.getPageContext());
                        }
                        a.this.eKr.o(a.this.lUr, a.this.lUq.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.lUq = null;
                a.this.lUr = null;
            }
        }
    };

    public void dnM() {
        com.baidu.tieba.pb.data.f pbData;
        cb dlp;
        boolean z = true;
        if (this.mog != null && this.mog.dmG() != null && this.mog.dmG().getPbData() != null && (dlp = (pbData = this.mog.dmG().getPbData()).dlp()) != null && dlp.bnS() != null) {
            this.mog.dqx();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dlp.bnS().getUserId());
            ad adVar = new ad();
            int dlE = this.mog.dmG().getPbData().dlE();
            if (dlE == 1 || dlE == 3) {
                adVar.lZm = true;
                adVar.lZs = dlp.bnN() == 1;
            } else {
                adVar.lZm = false;
            }
            if (FM(dlE)) {
                adVar.lZn = true;
                adVar.lZr = dlp.bnO() == 1;
            } else {
                adVar.lZn = false;
            }
            if (dlE == 1002 && !equals) {
                adVar.lZt = true;
            }
            adVar.lZk = vb(equals);
            adVar.lZo = dnN();
            adVar.lZl = vc(equals);
            adVar.Ha = this.mog.dmG().doL();
            adVar.lZh = true;
            adVar.lZg = va(equals);
            adVar.lZq = TbadkCoreApplication.getInst().getSkinType() == 1;
            adVar.lZp = true;
            adVar.isHostOnly = this.mog.dmG().getHostMode();
            adVar.lZj = true;
            if (dlp.boj() == null) {
                adVar.lZi = true;
            } else {
                adVar.lZi = false;
            }
            if (pbData.dlS()) {
                adVar.lZh = false;
                adVar.lZj = false;
                adVar.lZi = false;
                adVar.lZm = false;
                adVar.lZn = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.dlS()) {
                z = false;
            }
            adVar.lZu = z;
            if (this.mog.L(this.mog.dmG().getPbData()) != null) {
                adVar.eWQ = this.mog.L(this.mog.dmG().getPbData()).nzP;
            }
            a(adVar);
        }
    }

    public boolean FM(int i) {
        boolean z;
        List<ForumToolPerm> forumToolAuth;
        switch (i) {
            case 1:
                return true;
            case 2:
            case 3:
            case 4:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (!z || this.mog.dmG().getPbData().getUserData() == null || (forumToolAuth = this.mog.dmG().getPbData().getUserData().getForumToolAuth()) == null) {
            return false;
        }
        for (int i2 = 0; i2 < forumToolAuth.size(); i2++) {
            ForumToolPerm forumToolPerm = forumToolAuth.get(i2);
            if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                return true;
            }
        }
        return false;
    }

    private boolean vb(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.ad adVar;
        if (this.mog == null || this.mog.dmG() == null || this.mog.dmG().getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.mog.dmG().getPbData();
        cb dlp = pbData.dlp();
        if (dlp != null) {
            if (dlp.bmz() || dlp.bmA()) {
                return false;
            }
            if (dlp.bpP() || dlp.bpQ()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (dlp == null || dlp.bnS() == null || !dlp.bnS().isForumBusinessAccount() || au.isOn()) {
            if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
                if (pbData.dlE() != 0) {
                    return pbData.dlE() != 3;
                }
                List<bx> dlM = pbData.dlM();
                if (y.getCount(dlM) > 0) {
                    for (bx bxVar : dlM) {
                        if (bxVar != null && (adVar = bxVar.eRn) != null && adVar.eOX && !adVar.eOY && (adVar.type == 1 || adVar.type == 2)) {
                            z2 = true;
                            break;
                        }
                    }
                }
                z2 = false;
                return z2;
            }
            return false;
        }
        return false;
    }

    private boolean vc(boolean z) {
        if (z || this.mog == null || this.mog.dmG() == null || this.mog.dmG().getPbData() == null) {
            return false;
        }
        if (this.mog.dmG().getPbData().getForum() == null || !this.mog.dmG().getPbData().getForum().isBlockBawuDelete) {
            com.baidu.tieba.pb.data.f pbData = this.mog.dmG().getPbData();
            return ((pbData.dlp() != null && pbData.dlp().bnS() != null && pbData.dlp().bnS().isForumBusinessAccount() && !au.isOn()) || this.mog.dmG().getPbData().dlE() == 0 || this.mog.dmG().getPbData().dlE() == 3) ? false : true;
        }
        return false;
    }

    private boolean dnN() {
        if (this.mog == null || this.mog.dmG() == null || !this.mog.dmG().doL()) {
            return false;
        }
        return this.mog.dmG().getPageData() == null || this.mog.dmG().getPageData().bmI() != 0;
    }

    public void a(ad adVar) {
        if (!this.mog.getBaseFragmentActivity().isProgressBarShown()) {
            this.mhJ = new ac(this.mog, this.mog.aFH);
            this.mhI = new AlertDialog.Builder(this.mog.getContext(), R.style.DialogTheme).create();
            this.mhI.setCanceledOnTouchOutside(true);
            g.showDialog(this.mhI, this.mog.getFragmentActivity());
            Window window = this.mhI.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mhJ.getView());
            this.mhJ.vq(adVar == null ? false : adVar.lZg);
            this.mhJ.vr(adVar == null ? false : adVar.lZk);
            this.mhJ.vs(adVar == null ? false : adVar.lZo);
            this.mhJ.vu(adVar == null ? false : adVar.lZl);
            this.mhJ.vv(adVar == null ? true : adVar.lZi);
            if (adVar == null) {
                this.mhJ.aq(false, false);
                this.mhJ.ar(false, false);
            } else {
                this.mhJ.aq(adVar.lZm, adVar.lZs);
                this.mhJ.ar(adVar.lZn, adVar.lZr);
            }
            boolean z = adVar == null ? false : adVar.Ha;
            boolean z2 = adVar == null ? false : adVar.isHostOnly;
            boolean z3 = adVar == null ? false : adVar.lZj;
            boolean z4 = adVar == null ? false : adVar.lZh;
            boolean z5 = adVar == null ? false : adVar.lZq;
            boolean z6 = adVar == null ? false : adVar.lZp;
            this.mhJ.ap(z3, z2);
            this.mhJ.as(z4, z);
            this.mhJ.at(z6, z5);
            if (adVar != null) {
                this.mhJ.lZd = adVar.lZt;
                if (adVar.lZt) {
                    this.mhJ.dpY().setText(R.string.report_text);
                    this.mhJ.vu(false);
                }
            }
            this.mhJ.vt(adVar != null ? adVar.lZu : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.mog.dmG() != null && this.mog.dmG().getPbData() != null && this.mog.dmG().getPbData().getThreadId() != null && this.mog.dmG().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.mhJ.dqb().setText(R.string.have_called_fans_short);
            }
            dsz();
        }
    }

    private void dsz() {
        if (this.mhJ != null) {
            this.mhJ.dqf();
        }
    }

    public void baP() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mhI != null) {
                        g.dismissDialog(a.this.mhI, a.this.mog.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.mA().postDelayed(this.runnable, 100L);
    }

    public void dsA() {
        if (this.mhI != null) {
            g.dismissDialog(this.mhI, this.mog.getPageContext().getPageActivity());
        }
    }

    public ac dsB() {
        return this.mhJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0091 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dR(View view) {
        boolean z;
        boolean z2;
        List<com.baidu.tbadk.core.dialog.g> list;
        com.baidu.tbadk.core.dialog.g gVar;
        SparseArray sparseArray;
        if (this.mog == null || !this.mog.isAdded()) {
            return true;
        }
        SparseArray sparseArray2 = null;
        try {
            sparseArray2 = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        if (sparseArray2 == null) {
            if (dG(view)) {
                if (view instanceof TbImageView) {
                    this.lUq = ((TbImageView) view).getBdImage();
                    this.lUr = ((TbImageView) view).getUrl();
                    if (this.lUq == null || TextUtils.isEmpty(this.lUr)) {
                        return true;
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lUs = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lUs = null;
                    }
                } else if (view instanceof GifView) {
                    if (((GifView) view).getBdImage() != null) {
                        this.lUq = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            this.lUr = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.lUs = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.lUs = null;
                        }
                    } else {
                        return true;
                    }
                } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                    this.lUq = ((TbMemeImageView) view).getBdImage();
                    if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                        this.lUr = ((TbMemeImageView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lUs = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lUs = null;
                    }
                }
                if (view.getParent() instanceof TbRichTextView) {
                    try {
                        sparseArray = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                    } catch (ClassCastException e2) {
                        e2.printStackTrace();
                        sparseArray = sparseArray2;
                    }
                } else if (view.getParent().getParent() instanceof TbRichTextView) {
                    try {
                        sparseArray = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                    } catch (ClassCastException e3) {
                        e3.printStackTrace();
                        sparseArray = sparseArray2;
                    }
                } else {
                    a(this.lVf, this.lUq.isGif());
                }
                if (sparseArray != null) {
                    return true;
                }
                sparseArray2 = sparseArray;
            }
            sparseArray = sparseArray2;
            if (sparseArray != null) {
            }
        }
        this.ksi = (PostData) sparseArray2.get(R.id.tag_clip_board);
        if (this.ksi == null || this.mog.duk() == null) {
            return true;
        }
        if (!this.mog.duk().bkb() || this.ksi.getId() == null || !this.ksi.getId().equals(this.mog.dmG().boa())) {
            z = false;
        } else {
            z = true;
        }
        boolean z3 = this.mog.dmG().getPbData() != null && this.mog.dmG().getPbData().dlS();
        if (this.lTZ == null) {
            this.lTZ = new k(this.mog.getContext());
            this.lTZ.a(this.lUR);
        }
        ArrayList arrayList = new ArrayList();
        if (view != null && sparseArray2 != null) {
            boolean z4 = dG(view) && !z3;
            boolean z5 = (!dG(view) || this.lUq == null || this.lUq.isGif()) ? false : true;
            boolean z6 = false;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String str = null;
            if (!(sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean)) {
                z2 = false;
            } else {
                z2 = ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue();
            }
            if (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                z6 = ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue();
            }
            if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                z7 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
            }
            if (sparseArray2.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                z8 = ((Boolean) sparseArray2.get(R.id.tag_should_manage_visible)).booleanValue();
            }
            if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                z9 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
            }
            if (sparseArray2.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                z10 = ((Boolean) sparseArray2.get(R.id.tag_should_delete_visible)).booleanValue();
            }
            if (sparseArray2.get(R.id.tag_forbid_user_post_id) instanceof String) {
                str = (String) sparseArray2.get(R.id.tag_forbid_user_post_id);
            }
            if (z4) {
                arrayList.add(new com.baidu.tbadk.core.dialog.g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), this.lTZ));
            }
            if (z5) {
                arrayList.add(new com.baidu.tbadk.core.dialog.g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), this.lTZ));
            }
            if (!z4 && !z5) {
                com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(3, TbadkCoreApplication.getInst().getString(R.string.copy), this.lTZ);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_clip_board, this.ksi);
                gVar2.eWK.setTag(sparseArray3);
                arrayList.add(gVar2);
            }
            if (!z2 && !z3) {
                if (z) {
                    gVar = new com.baidu.tbadk.core.dialog.g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), this.lTZ);
                } else {
                    gVar = new com.baidu.tbadk.core.dialog.g(4, TbadkCoreApplication.getInst().getString(R.string.mark), this.lTZ);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_clip_board, this.ksi);
                sparseArray4.put(R.id.tag_is_subpb, false);
                gVar.eWK.setTag(sparseArray4);
                arrayList.add(gVar);
            }
            if (TbadkCoreApplication.isLogin() && !this.lTP) {
                if (!z8 && z7) {
                    com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), this.lTZ);
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.tag_user_mute_visible, true);
                    sparseArray5.put(R.id.tag_is_mem, sparseArray2.get(R.id.tag_is_mem));
                    sparseArray5.put(R.id.tag_user_mute_mute_userid, sparseArray2.get(R.id.tag_user_mute_mute_userid));
                    sparseArray5.put(R.id.tag_user_mute_mute_username, sparseArray2.get(R.id.tag_user_mute_mute_username));
                    sparseArray5.put(R.id.tag_user_mute_mute_nameshow, sparseArray2.get(R.id.tag_user_mute_mute_nameshow));
                    sparseArray5.put(R.id.tag_user_mute_post_id, sparseArray2.get(R.id.tag_user_mute_post_id));
                    sparseArray5.put(R.id.tag_user_mute_thread_id, sparseArray2.get(R.id.tag_user_mute_thread_id));
                    sparseArray5.put(R.id.tag_del_post_is_self, sparseArray2.get(R.id.tag_del_post_is_self));
                    sparseArray5.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                    sparseArray5.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                    sparseArray5.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                    gVar3.eWK.setTag(sparseArray5);
                    arrayList.add(gVar3);
                } else {
                    if ((va(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), this.lTZ);
                        gVar4.eWK.setTag(str);
                        arrayList.add(gVar4);
                    }
                }
                com.baidu.tbadk.core.dialog.g gVar5 = null;
                com.baidu.tbadk.core.dialog.g gVar6 = null;
                if (z8) {
                    SparseArray sparseArray6 = new SparseArray();
                    sparseArray6.put(R.id.tag_should_manage_visible, true);
                    sparseArray6.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                    sparseArray6.put(R.id.tag_forbid_user_name, sparseArray2.get(R.id.tag_forbid_user_name));
                    sparseArray6.put(R.id.tag_forbid_user_name_show, sparseArray2.get(R.id.tag_forbid_user_name_show));
                    sparseArray6.put(R.id.tag_forbid_user_portrait, sparseArray2.get(R.id.tag_forbid_user_portrait));
                    sparseArray6.put(R.id.tag_forbid_user_post_id, str);
                    if (z9) {
                        sparseArray6.put(R.id.tag_user_mute_visible, true);
                        sparseArray6.put(R.id.tag_is_mem, sparseArray2.get(R.id.tag_is_mem));
                        sparseArray6.put(R.id.tag_user_mute_mute_userid, sparseArray2.get(R.id.tag_user_mute_mute_userid));
                        sparseArray6.put(R.id.tag_user_mute_mute_username, sparseArray2.get(R.id.tag_user_mute_mute_username));
                        sparseArray6.put(R.id.tag_user_mute_mute_nameshow, sparseArray2.get(R.id.tag_user_mute_mute_nameshow));
                        sparseArray6.put(R.id.tag_user_mute_post_id, sparseArray2.get(R.id.tag_user_mute_post_id));
                        sparseArray6.put(R.id.tag_user_mute_thread_id, sparseArray2.get(R.id.tag_user_mute_thread_id));
                    } else {
                        sparseArray6.put(R.id.tag_user_mute_visible, false);
                    }
                    if (z10) {
                        sparseArray6.put(R.id.tag_should_delete_visible, true);
                        sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                        sparseArray6.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                        sparseArray6.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.lTZ);
                        gVar6.eWK.setTag(sparseArray6);
                    } else {
                        sparseArray6.put(R.id.tag_should_delete_visible, false);
                    }
                    gVar5 = new com.baidu.tbadk.core.dialog.g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), this.lTZ);
                    gVar5.eWK.setTag(sparseArray6);
                } else if (z10) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.tag_should_manage_visible, false);
                    sparseArray7.put(R.id.tag_user_mute_visible, false);
                    sparseArray7.put(R.id.tag_should_delete_visible, true);
                    sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                    sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                    sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                    sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                    if (this.mog.dmG().getPbData().dlE() == 1002 && !z6) {
                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), this.lTZ);
                    } else {
                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.lTZ);
                    }
                    gVar6.eWK.setTag(sparseArray7);
                }
                if (gVar6 != null) {
                    arrayList.add(gVar6);
                }
                if (gVar5 != null) {
                    arrayList.add(gVar5);
                }
            }
            if (com.baidu.tbadk.a.d.bjo()) {
                list = com.baidu.tieba.pb.pb.main.d.a.fq(com.baidu.tieba.pb.pb.main.d.a.x(com.baidu.tieba.pb.pb.main.d.a.a(arrayList, this.ksi.bpL(), sparseArray2, this.lTZ), this.lTl));
                this.lTZ.a(com.baidu.tieba.pb.pb.main.d.a.t(this.ksi));
            } else {
                list = arrayList;
            }
            this.lTZ.k(list, true);
            this.lTY = new i(this.mog.getPageContext(), this.lTZ);
            this.lTY.QH();
            TiebaStatic.log(new ar("c13272").dR("tid", this.mog.dmG().doJ()).dR("fid", this.mog.dmG().getForumId()).dR("uid", this.mog.dmG().getPbData().dlp().bnS().getUserId()).dR("post_id", this.mog.dmG().bBM()).aq("obj_source", z2 ? 2 : 1));
        }
        return true;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.mog = videoPbFragment;
        this.lUo = videoPbFragment.getUniqueId();
        this.lTR = new com.baidu.tieba.pb.pb.report.a(this.mog.getContext());
        this.lTR.y(this.mog.getUniqueId());
        this.mdc = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.17
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.mog.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.mog.dmG().getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                String str3 = "";
                if (objArr.length > 3) {
                    str3 = String.valueOf(objArr[3]);
                }
                String str4 = "";
                if (objArr.length > 4) {
                    str4 = String.valueOf(objArr[4]);
                }
                a.this.mog.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.mog.getPageContext().getPageActivity(), a.this.mog.dmG().getPbData().getForum().getId(), a.this.mog.dmG().getPbData().getForum().getName(), a.this.mog.dmG().getPbData().dlp().getId(), valueOf, str, str3, str2, str4)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FK(int i) {
        TiebaStatic.log(new ar("c14000").dR("tid", this.mog.dmG().doJ()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("obj_type", String.valueOf(com.baidu.tieba.pb.pb.main.d.a.Gn(i))));
    }

    public void wu(boolean z) {
        this.lTl = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(View view) {
        if (view != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.lTl ? 2 : 3));
            view.setTag(sparseArray);
        }
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

    protected void n(PostData postData) {
        PostData L;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.mog.dmG().boa())) {
                z = true;
            }
            MarkData o = this.mog.dmG().o(postData);
            if (this.mog.dmG().getPbData() != null && this.mog.dmG().getPbData().dlS() && (L = this.mog.L(this.mog.dmG().getPbData())) != null) {
                o = this.mog.dmG().o(L);
            }
            if (o != null) {
                this.mog.dra();
                if (this.mog.duk() != null) {
                    this.mog.duk().a(o);
                    if (!z) {
                        this.mog.duk().bkd();
                    } else {
                        this.mog.duk().bkc();
                    }
                }
            }
        }
    }

    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlp() != null) {
            if (fVar.dlp().getThreadType() == 0) {
                return 1;
            }
            if (fVar.dlp().getThreadType() == 54) {
                return 2;
            }
            if (fVar.dlp().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    private boolean va(boolean z) {
        if (this.mog.dmG() == null || this.mog.dmG().getPbData() == null) {
            return false;
        }
        return ((this.mog.dmG().getPbData().dlE() != 0) || this.mog.dmG().getPbData().dlp() == null || this.mog.dmG().getPbData().dlp().bnS() == null || TextUtils.equals(this.mog.dmG().getPbData().dlp().bnS().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void PA(String str) {
        if (this.mog.dmG() != null && this.mog.dmG().getPbData() != null && this.mog.dmG().getPbData().dlS()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.mog.dmG().doJ(), str);
            cb dlp = this.mog.dmG().getPbData().dlp();
            if (dlp.bmz()) {
                format = format + "&channelid=33833";
            } else if (dlp.bpO()) {
                format = format + "&channelid=33842";
            } else if (dlp.bmA()) {
                format = format + "&channelid=33840";
            }
            PB(format);
            return;
        }
        this.lTR.Qb(str);
    }

    private void PB(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.mog.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.lTY != null && this.lTY.isShowing()) {
                this.lTY.dismiss();
                this.lTY = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.mog.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.19
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.lTY != null) {
                            a.this.lTY.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.lUo);
                            userMuteAddAndDelCustomMessage.setTag(a.this.lUo);
                            a.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                        }
                    }
                });
                ArrayList arrayList = new ArrayList();
                int i = -1;
                if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(0, TbadkCoreApplication.getInst().getResources().getString(R.string.delete), kVar));
                }
                if (z) {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, TbadkCoreApplication.getInst().getResources().getString(R.string.un_mute), kVar));
                } else {
                    arrayList.add(new com.baidu.tbadk.core.dialog.g(1, TbadkCoreApplication.getInst().getResources().getString(R.string.mute), kVar));
                }
                kVar.bw(arrayList);
                this.lTY = new i(this.mog.getPageContext(), kVar);
                this.lTY.QH();
            }
        }
    }

    public void doi() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mog.getPageContext().getPageActivity());
        aVar.AB(this.mog.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.20
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.mog.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.21
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mog.getPageContext()).bqz();
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, (String) null);
    }

    public void a(int i, String str, int i2, boolean z, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(mcq, Integer.valueOf(mcr));
        int i3 = R.string.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = R.string.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = R.string.report_thread_confirm;
            } else {
                i3 = R.string.del_thread_confirm;
            }
        }
        this.mbz = new com.baidu.tbadk.core.dialog.a(this.mog.getActivity());
        if (StringUtils.isNull(str2)) {
            this.mbz.ny(i3);
        } else {
            this.mbz.setOnlyMessageShowCenter(false);
            this.mbz.AB(str2);
        }
        this.mbz.setYesButtonTag(sparseArray);
        this.mbz.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.23
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.mog.a(aVar, (JSONArray) null);
            }
        });
        this.mbz.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.mbz.jF(true);
        this.mbz.b(this.mog.getPageContext());
        if (z) {
            this.mbz.bqz();
        } else if (dqU()) {
            h hVar = new h(this.mog.dmG().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.mog.dmG().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.mog.dmG().getPbData().dlY().has_forum_rule.intValue());
            hVar.eg(this.mog.dmG().getPbData().getForum().getId(), this.mog.dmG().getPbData().getForum().getName());
            hVar.setForumHeadUrl(this.mog.dmG().getPbData().getForum().getImage_url());
            hVar.setUserLevel(this.mog.dmG().getPbData().getForum().getUser_level());
            a(this.mbz, i, hVar, this.mog.dmG().getPbData().getUserData());
        } else {
            a(this.mbz, i);
        }
    }

    private boolean dqU() {
        if (this.mog == null || this.mog.dmG().getPbData().getForum().getDeletedReasonInfo() == null) {
            return false;
        }
        return 1 == this.mog.dmG().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.mog != null && aVar != null) {
            if (this.jSR == null && this.mog.getView() != null) {
                this.jSR = new f(this.mog.getPageContext(), this.mog.getView());
            }
            AntiData cBF = cBF();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cBF != null && cBF.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBF.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray);
            this.jSR.setDefaultReasonArray(new String[]{this.mog.getString(R.string.delete_thread_reason_1), this.mog.getString(R.string.delete_thread_reason_2), this.mog.getString(R.string.delete_thread_reason_3), this.mog.getString(R.string.delete_thread_reason_4), this.mog.getString(R.string.delete_thread_reason_5)});
            this.jSR.setData(avVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.jSR.Ey(str);
            this.jSR.a(new f.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void W(JSONArray jSONArray) {
                    a.this.mog.a(aVar, jSONArray);
                }
            });
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i, h hVar, UserData userData) {
        String str;
        if (this.mog != null && aVar != null) {
            if (this.mcO == null && this.mog.getView() != null) {
                this.mcO = new com.baidu.tieba.NEGFeedBack.i(this.mog.getPageContext(), this.mog.getView(), hVar, userData);
            }
            AntiData cBF = cBF();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cBF != null && cBF.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBF.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray);
            this.mcO.setDefaultReasonArray(new String[]{this.mog.getString(R.string.delete_thread_reason_1), this.mog.getString(R.string.delete_thread_reason_2), this.mog.getString(R.string.delete_thread_reason_3), this.mog.getString(R.string.delete_thread_reason_4), this.mog.getString(R.string.delete_thread_reason_5)});
            this.mcO.setData(avVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.mcO.Ey(str);
            this.mcO.a(new i.b() { // from class: com.baidu.tieba.pb.videopb.b.a.4
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void W(JSONArray jSONArray) {
                    a.this.mog.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData cBF() {
        if (this.mog.dmG() == null || this.mog.dmG().getPbData() == null) {
            return null;
        }
        return this.mog.dmG().getPbData().getAnti();
    }

    public void dL(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        k kVar = new k(this.mog.getContext());
        kVar.setTitleText(this.mog.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.5
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.mby.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 10:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 11:
                            if (a.this.mdc != null) {
                                a.this.mdc.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 12:
                            a.this.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
        if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
            if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.mog.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.mog.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.eWK.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(11, this.mog.getString(R.string.forbidden_person), kVar);
            gVar3.eWK.setTag(sparseArray3);
            arrayList.add(gVar3);
        }
        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
            sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
            sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
            sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
            sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
            sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
            sparseArray4.put(R.id.tag_user_mute_msg, sparseArray.get(R.id.tag_user_mute_msg));
            if (z) {
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.mog.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.mog.getString(R.string.mute), kVar);
            }
            gVar.eWK.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.bw(arrayList);
        if (this.mby == null) {
            this.mby = new com.baidu.tbadk.core.dialog.i(this.mog.getPageContext(), kVar);
        } else {
            this.mby.a(kVar);
        }
        this.mby.QH();
    }

    public void dnF() {
        if (this.lTr == null) {
            this.lTr = new com.baidu.tbadk.core.dialog.b(this.mog.getPageContext().getPageActivity());
            this.lTr.a(new String[]{this.mog.getPageContext().getString(R.string.call_phone), this.mog.getPageContext().getString(R.string.sms_phone), this.mog.getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0564b() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0564b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.mog.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.lPu = a.this.lPu.trim();
                        UtilHelper.callPhone(a.this.mog.getPageContext().getPageActivity(), a.this.lPu);
                        new com.baidu.tieba.pb.pb.main.b(a.this.mog.dmG().doJ(), a.this.lPu, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.mog.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.lPu = a.this.lPu.trim();
                        UtilHelper.smsPhone(a.this.mog.getPageContext().getPageActivity(), a.this.lPu);
                        new com.baidu.tieba.pb.pb.main.b(a.this.mog.dmG().doJ(), a.this.lPu, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.lPu = a.this.lPu.trim();
                        UtilHelper.startBaiDuBar(a.this.mog.getPageContext().getPageActivity(), a.this.lPu);
                        bVar.dismiss();
                    }
                }
            }).nE(b.a.BOTTOM_TO_TOP).nF(17).d(this.mog.getPageContext());
        }
    }

    public void dS(final View view) {
        String[] strArr;
        int i = 0;
        if (this.mog != null && this.mog.dmG() != null) {
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mog.getPageContext());
            if (this.mog.dmG().getPbData().lMo == null || this.mog.dmG().getPbData().lMo.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.mog.dmG().getPbData().lMo.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mog.dmG().getPbData().lMo.size()) {
                        break;
                    }
                    strArr2[i2] = this.mog.dmG().getPbData().lMo.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.mog.dmG().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.mog.dmG().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.mog.dmG().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.mog.dmG().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new ar("c12097").aq("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).aq("obj_type", i4));
                    if (a.this.mog.dmG().getPbData().lMo != null && a.this.mog.dmG().getPbData().lMo.size() > i3) {
                        i3 = a.this.mog.dmG().getPbData().lMo.get(i3).sort_type.intValue();
                    }
                    boolean FX = a.this.mog.dmG().FX(i3);
                    view.setTag(Integer.valueOf(a.this.mog.dmG().dpd()));
                    if (FX) {
                        a.this.mog.setIsLoading(true);
                    }
                }
            });
            iVar.QH();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mog.getActivity());
            aVar.AA(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.AB(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.jF(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new ar("c12528").dR("obj_id", metaData.getUserId()).aq("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new ar("c12528").dR("obj_id", metaData.getUserId()).aq("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.mog.duv() != null) {
                        a.this.mog.duv().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.mog.getPageContext().getUniqueId(), a.this.mog.dmG().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.mog.getPageContext()).bqz();
            TiebaStatic.log(new ar("c12527"));
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.lUo);
        userMuteAddAndDelCustomMessage.setTag(this.lUo);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void Dh(String str) {
        if (str == null) {
            str = "";
        }
        if (this.mog != null && this.mog.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mog.getPageContext().getPageActivity());
            aVar.AB(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mog.getPageContext()).bqz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mog.getBaseFragmentActivity());
        if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
            aVar.AB(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.AB(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.mog.getPageContext()).bqz();
    }

    public void showLoadingDialog() {
        if (this.iFD == null) {
            this.iFD = new com.baidu.tbadk.core.view.a(this.mog.getPageContext());
        }
        this.iFD.setDialogVisiable(true);
    }

    public void ckD() {
        if (this.iFD != null) {
            this.iFD.setDialogVisiable(false);
        }
    }

    public void g(SparseArray<Object> sparseArray) {
        PostData postData;
        boolean z;
        String str;
        com.baidu.tbadk.core.dialog.g gVar;
        if (this.mog != null && this.mog.dmG() != null && sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            if (this.lTZ == null) {
                this.lTZ = new k(this.mog.getContext());
                this.lTZ.a(this.lUR);
            }
            ArrayList arrayList = new ArrayList();
            boolean z2 = this.mog.dmG().getPbData() != null && this.mog.dmG().getPbData().dlS();
            if (sparseArray != null) {
                boolean z3 = false;
                boolean z4 = false;
                boolean z5 = false;
                boolean z6 = false;
                if (!(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                    z = false;
                } else {
                    z = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                }
                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z3 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                }
                if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                    z4 = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
                }
                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z5 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                }
                if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                    z6 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
                }
                if (!(sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String)) {
                    str = null;
                } else {
                    str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
                }
                if (postData.bpL() != null) {
                    com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(8, (postData.bpL().hasAgree && postData.bpv() == 5) ? this.mog.getString(R.string.action_cancel_dislike) : this.mog.getString(R.string.action_dislike), this.lTZ);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    gVar2.eWK.setTag(sparseArray2);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z4 && z3) {
                        com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, this.mog.getString(R.string.mute_option), this.lTZ);
                        SparseArray sparseArray3 = new SparseArray();
                        sparseArray3.put(R.id.tag_user_mute_visible, true);
                        sparseArray3.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                        sparseArray3.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                        sparseArray3.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                        sparseArray3.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                        sparseArray3.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                        sparseArray3.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                        sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                        sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                        sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                        sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                        gVar3.eWK.setTag(sparseArray3);
                        arrayList.add(gVar3);
                    } else {
                        if ((va(z) && TbadkCoreApplication.isLogin()) && !z2) {
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, this.mog.getString(R.string.report_text), this.lTZ);
                            gVar4.eWK.setTag(str);
                            arrayList.add(gVar4);
                        }
                    }
                    com.baidu.tbadk.core.dialog.g gVar5 = null;
                    if (z4) {
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.tag_should_manage_visible, true);
                        sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                        sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                        sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                        sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                        sparseArray4.put(R.id.tag_forbid_user_post_id, str);
                        if (z5) {
                            sparseArray4.put(R.id.tag_user_mute_visible, true);
                            sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                            sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                            sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                            sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                            sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                            sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                        } else {
                            sparseArray4.put(R.id.tag_user_mute_visible, false);
                        }
                        if (z6) {
                            sparseArray4.put(R.id.tag_should_delete_visible, true);
                            sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                            sparseArray4.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                            sparseArray4.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                            gVar5 = new com.baidu.tbadk.core.dialog.g(6, this.mog.getString(R.string.delete), this.lTZ);
                            gVar5.eWK.setTag(sparseArray4);
                        } else {
                            sparseArray4.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new com.baidu.tbadk.core.dialog.g(7, this.mog.getString(R.string.bar_manager), this.lTZ);
                        gVar.eWK.setTag(sparseArray4);
                    } else {
                        if (z6) {
                            SparseArray sparseArray5 = new SparseArray();
                            sparseArray5.put(R.id.tag_should_manage_visible, false);
                            sparseArray5.put(R.id.tag_user_mute_visible, false);
                            sparseArray5.put(R.id.tag_should_delete_visible, true);
                            sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                            sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                            sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                            sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                            if (this.mog.dmG().getPbData().dlE() == 1002 && !z) {
                                gVar5 = new com.baidu.tbadk.core.dialog.g(6, this.mog.getString(R.string.report_text), this.lTZ);
                            } else {
                                gVar5 = new com.baidu.tbadk.core.dialog.g(6, this.mog.getString(R.string.delete), this.lTZ);
                            }
                            gVar5.eWK.setTag(sparseArray5);
                        }
                        gVar = null;
                    }
                    if (gVar5 != null) {
                        arrayList.add(gVar5);
                    }
                    if (gVar != null) {
                        arrayList.add(gVar);
                    }
                }
                this.lTZ.bw(arrayList);
                this.lTY = new com.baidu.tbadk.core.dialog.i(this.mog.getPageContext(), this.lTZ);
                this.lTY.QH();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.fge == null) {
                this.fge = new com.baidu.tbadk.core.message.a();
            }
            if (this.ffO == null) {
                this.ffO = new e();
                this.ffO.uniqueId = this.mog.getUniqueId();
            }
            com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
            eVar.eNB = 5;
            eVar.eNH = 8;
            eVar.eNG = 2;
            if (this.mog != null && this.mog.dmG() != null) {
                eVar.eNF = this.mog.dmG().dpu();
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
                this.fge.a(agreeData, i, this.mog.getUniqueId(), false);
                this.fge.a(agreeData, this.ffO);
                if (this.mog == null && this.mog.dmG() != null && this.mog.dmG().getPbData() != null) {
                    this.fge.a(this.mog.doq(), eVar, agreeData, this.mog.dmG().getPbData().dlp());
                    return;
                }
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (eVar != null) {
                eVar.eNI = 1;
            }
            i = 0;
            this.fge.a(agreeData, i, this.mog.getUniqueId(), false);
            this.fge.a(agreeData, this.ffO);
            if (this.mog == null) {
            }
        }
    }

    public void a(final b.InterfaceC0564b interfaceC0564b, boolean z) {
        if (this.mbH != null) {
            this.mbH.dismiss();
            this.mbH = null;
        }
        k kVar = new k(this.mog.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.mog.dmG().getPbData() != null && this.mog.dmG().getPbData().dlp() != null && !this.mog.dmG().getPbData().dlp().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.mog.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.mog.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.bw(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.mbH.dismiss();
                interfaceC0564b.a(null, i, view);
            }
        });
        this.mbH = new com.baidu.tbadk.core.dialog.i(this.mog.getPageContext(), kVar);
        this.mbH.QH();
    }

    public void aZ(ArrayList<al> arrayList) {
        if (this.mbC == null) {
            this.mbC = LayoutInflater.from(this.mog.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.mog.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.mbC);
        if (this.mbB == null) {
            this.mbB = new Dialog(this.mog.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.mbB.setCanceledOnTouchOutside(true);
            this.mbB.setCancelable(true);
            this.mbK = (ScrollView) this.mbC.findViewById(R.id.good_scroll);
            this.mbB.setContentView(this.mbC);
            WindowManager.LayoutParams attributes = this.mbB.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.mbB.getWindow().setAttributes(attributes);
            this.iBr = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.mbG = (String) compoundButton.getTag();
                        if (a.this.iBq != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.iBq) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.mbG != null && !str.equals(a.this.mbG)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.mbD = (LinearLayout) this.mbC.findViewById(R.id.good_class_group);
            this.mbF = (TextView) this.mbC.findViewById(R.id.dialog_button_cancel);
            this.mbF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.mbB instanceof Dialog) {
                        g.b(a.this.mbB, a.this.mog.getPageContext());
                    }
                }
            });
            this.mbE = (TextView) this.mbC.findViewById(R.id.dialog_button_ok);
            this.mbE.setOnClickListener(this.mog.dul());
        }
        this.mbD.removeAllViews();
        this.iBq = new ArrayList();
        CustomBlueCheckRadioButton fU = fU("0", this.mog.getPageContext().getString(R.string.thread_good_class));
        this.iBq.add(fU);
        fU.setChecked(true);
        this.mbD.addView(fU);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                al alVar = arrayList.get(i2);
                if (alVar != null && !TextUtils.isEmpty(alVar.bmd()) && alVar.bme() > 0) {
                    CustomBlueCheckRadioButton fU2 = fU(String.valueOf(alVar.bme()), alVar.bmd());
                    this.iBq.add(fU2);
                    View view = new View(this.mog.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    ap.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.mbD.addView(view);
                    this.mbD.addView(fU2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.mbK.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.mog.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.mog.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.mog.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.mbK.setLayoutParams(layoutParams2);
            this.mbK.removeAllViews();
            if (this.mbD != null && this.mbD.getParent() == null) {
                this.mbK.addView(this.mbD);
            }
        }
        g.a(this.mbB, this.mog.getPageContext());
    }

    private CustomBlueCheckRadioButton fU(String str, String str2) {
        Activity pageActivity = this.mog.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.iBr);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public boolean dG(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void d(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.lUo;
        userMuteCheckCustomMessage.setTag(this.lUo);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void drv() {
        if (this.mbz != null) {
            this.mbz.dismiss();
        }
        if (this.mbA != null) {
            g.b(this.mbA, this.mog.getPageContext());
        }
        if (this.mbB != null) {
            g.b(this.mbB, this.mog.getPageContext());
        }
        if (this.mby != null) {
            this.mby.dismiss();
        }
    }

    public void dvc() {
        if (this.lTY != null) {
            this.lTY.dismiss();
        }
    }

    public void dru() {
        baP();
        this.mog.dqx();
        if (this.lTY != null) {
            this.lTY.dismiss();
        }
        drv();
    }

    public void drt() {
        baP();
        this.mog.dqx();
        if (this.lTY != null) {
            this.lTY.dismiss();
        }
        this.mog.cDi();
        drv();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener dun() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b dvd() {
        return this.lTr;
    }

    public void setPhoneNumber(String str) {
        this.lPu = str;
    }

    public String dqZ() {
        return this.mbG;
    }

    public View dqY() {
        if (this.mbC != null) {
            return this.mbC.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
