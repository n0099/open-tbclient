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
    public static int lZV = 3;
    public static int lZW = 0;
    public static int lZX = 3;
    public static int lZY = 4;
    public static int lZZ = 5;
    public static int maa = 6;
    private at eIQ;
    private com.baidu.tbadk.core.message.a feF;
    private e fep;
    private List<CustomBlueCheckRadioButton> izt;
    private f jQU;
    private String lNd;
    private boolean lQU;
    private com.baidu.tieba.pb.pb.report.a lRA;
    private i lRH;
    private k lRI;
    public BdUniqueId lRX;
    private com.baidu.adp.widget.ImageView.a lRZ;
    private String lSa;
    private TbRichTextMemeInfo lSb;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    private PbFragment.b maL;
    private com.baidu.tieba.NEGFeedBack.i maw;
    public VideoPbFragment mlP;
    private Runnable runnable;
    private i lZn = null;
    private com.baidu.tbadk.core.dialog.a lZf = null;
    private Dialog lZg = null;
    private Dialog lZh = null;
    private View lZi = null;
    private LinearLayout lZj = null;
    private TextView lZk = null;
    private TextView lZl = null;
    private String lZm = null;
    private ScrollView lZq = null;
    private CompoundButton.OnCheckedChangeListener izu = null;
    private i lZe = null;
    private com.baidu.tbadk.core.view.a iDG = null;
    private com.baidu.tbadk.core.dialog.b lRa = null;
    private AlertDialog mfr = null;
    private ac mfs = null;
    PostData kpS = null;
    private boolean lRy = d.biY();
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.12
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return a.this.dR(view);
        }
    };
    private k.c lSA = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (a.this.lRH != null) {
                a.this.lRH.dismiss();
            }
            a.this.FH(i);
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
                    if (d.bjj() || d.bjk()) {
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
                    if (d.bjj() || d.bjk()) {
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
                    if (a.this.lRZ != null && !TextUtils.isEmpty(a.this.lSa)) {
                        if (a.this.lSb == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.lSa));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.lSa;
                            aVar.pkgId = a.this.lSb.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.lSb.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.lRZ = null;
                        a.this.lSa = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.lRZ != null && !TextUtils.isEmpty(a.this.lSa)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.mlP.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.mlP.getPageContext().getPageActivity())) {
                            if (a.this.eIQ == null) {
                                a.this.eIQ = new at(a.this.mlP.getPageContext());
                            }
                            a.this.eIQ.p(a.this.lSa, a.this.lRZ.getImageByte());
                            a.this.lRZ = null;
                            a.this.lSa = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.kpS != null) {
                        a.this.kpS.gW(a.this.mlP.getPageContext().getPageActivity());
                        a.this.kpS = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new ar("c11739").ap("obj_locate", 2));
                    if (a.this.mlP.checkUpIsLogin()) {
                        a.this.dE(view);
                        if (a.this.mlP.dmq().getPbData().dkZ() != null && a.this.mlP.dmq().getPbData().dkZ().bnQ() != null && a.this.mlP.dmq().getPbData().dkZ().bnQ().getUserId() != null && a.this.mlP.dtU() != null) {
                            int h = a.this.h(a.this.mlP.dmq().getPbData());
                            cb dkZ = a.this.mlP.dmq().getPbData().dkZ();
                            if (dkZ.bmx()) {
                                i2 = 2;
                            } else if (dkZ.bmy()) {
                                i2 = 3;
                            } else if (dkZ.bpN()) {
                                i2 = 4;
                            } else {
                                i2 = dkZ.bpO() ? 5 : 1;
                            }
                            TiebaStatic.log(new ar("c12526").dR("tid", a.this.mlP.dmq().dot()).ap("obj_locate", 2).dR("obj_id", a.this.mlP.dmq().getPbData().dkZ().bnQ().getUserId()).ap("obj_type", a.this.mlP.dtU().bjZ() ? 0 : 1).ap("obj_source", h).ap("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.mlP.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new ar("c13079"));
                        a.this.Pt((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new ar("c11739").ap("obj_locate", 4));
                        SparseArray<Object> sparseArray4 = (SparseArray) tag;
                        if ((sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray4.put(R.id.tag_from, 0);
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            a.this.f(sparseArray4);
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
                        a.this.mlP.showToast(R.string.network_not_available);
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
                                a.this.f(sparseArray6);
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
                    if (bh.checkUpIsLogin(a.this.mlP.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.bpJ() != null) {
                            c bR = com.baidu.tbadk.pageExtra.d.bR(view);
                            if (bR != null) {
                                postData.bpJ().objSource = bR.getCurrentPageKey();
                            }
                            a.this.d(postData.bpJ());
                            return;
                        }
                        return;
                    }
                    return;
            }
        }
    };
    private final b.InterfaceC0558b lSO = new b.InterfaceC0558b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0558b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.lRZ != null && !TextUtils.isEmpty(a.this.lSa)) {
                if (i == 0) {
                    if (a.this.lSb == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.lSa));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.lSa;
                        aVar.pkgId = a.this.lSb.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.lSb.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.mlP.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.mlP.getPageContext().getPageActivity())) {
                        if (a.this.eIQ == null) {
                            a.this.eIQ = new at(a.this.mlP.getPageContext());
                        }
                        a.this.eIQ.p(a.this.lSa, a.this.lRZ.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.lRZ = null;
                a.this.lSa = null;
            }
        }
    };

    public void dnw() {
        com.baidu.tieba.pb.data.f pbData;
        cb dkZ;
        boolean z = true;
        if (this.mlP != null && this.mlP.dmq() != null && this.mlP.dmq().getPbData() != null && (dkZ = (pbData = this.mlP.dmq().getPbData()).dkZ()) != null && dkZ.bnQ() != null) {
            this.mlP.dqh();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dkZ.bnQ().getUserId());
            ad adVar = new ad();
            int dlo = this.mlP.dmq().getPbData().dlo();
            if (dlo == 1 || dlo == 3) {
                adVar.lWV = true;
                adVar.lXb = dkZ.bnL() == 1;
            } else {
                adVar.lWV = false;
            }
            if (FJ(dlo)) {
                adVar.lWW = true;
                adVar.lXa = dkZ.bnM() == 1;
            } else {
                adVar.lWW = false;
            }
            if (dlo == 1002 && !equals) {
                adVar.lXc = true;
            }
            adVar.lWT = vb(equals);
            adVar.lWX = dnx();
            adVar.lWU = vc(equals);
            adVar.FD = this.mlP.dmq().dov();
            adVar.lWQ = true;
            adVar.lWP = va(equals);
            adVar.lWZ = TbadkCoreApplication.getInst().getSkinType() == 1;
            adVar.lWY = true;
            adVar.isHostOnly = this.mlP.dmq().getHostMode();
            adVar.lWS = true;
            if (dkZ.boh() == null) {
                adVar.lWR = true;
            } else {
                adVar.lWR = false;
            }
            if (pbData.dlC()) {
                adVar.lWQ = false;
                adVar.lWS = false;
                adVar.lWR = false;
                adVar.lWV = false;
                adVar.lWW = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.dlC()) {
                z = false;
            }
            adVar.lXd = z;
            if (this.mlP.L(this.mlP.dmq().getPbData()) != null) {
                adVar.eVr = this.mlP.L(this.mlP.dmq().getPbData()).nxk;
            }
            a(adVar);
        }
    }

    public boolean FJ(int i) {
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
        if (!z || this.mlP.dmq().getPbData().getUserData() == null || (forumToolAuth = this.mlP.dmq().getPbData().getUserData().getForumToolAuth()) == null) {
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
        if (this.mlP == null || this.mlP.dmq() == null || this.mlP.dmq().getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.mlP.dmq().getPbData();
        cb dkZ = pbData.dkZ();
        if (dkZ != null) {
            if (dkZ.bmx() || dkZ.bmy()) {
                return false;
            }
            if (dkZ.bpN() || dkZ.bpO()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (dkZ == null || dkZ.bnQ() == null || !dkZ.bnQ().isForumBusinessAccount() || au.isOn()) {
            if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
                if (pbData.dlo() != 0) {
                    return pbData.dlo() != 3;
                }
                List<bx> dlw = pbData.dlw();
                if (y.getCount(dlw) > 0) {
                    for (bx bxVar : dlw) {
                        if (bxVar != null && (adVar = bxVar.ePM) != null && adVar.eNw && !adVar.eNx && (adVar.type == 1 || adVar.type == 2)) {
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
        if (z || this.mlP == null || this.mlP.dmq() == null || this.mlP.dmq().getPbData() == null) {
            return false;
        }
        if (this.mlP.dmq().getPbData().getForum() == null || !this.mlP.dmq().getPbData().getForum().isBlockBawuDelete) {
            com.baidu.tieba.pb.data.f pbData = this.mlP.dmq().getPbData();
            return ((pbData.dkZ() != null && pbData.dkZ().bnQ() != null && pbData.dkZ().bnQ().isForumBusinessAccount() && !au.isOn()) || this.mlP.dmq().getPbData().dlo() == 0 || this.mlP.dmq().getPbData().dlo() == 3) ? false : true;
        }
        return false;
    }

    private boolean dnx() {
        if (this.mlP == null || this.mlP.dmq() == null || !this.mlP.dmq().dov()) {
            return false;
        }
        return this.mlP.dmq().getPageData() == null || this.mlP.dmq().getPageData().bmG() != 0;
    }

    public void a(ad adVar) {
        if (!this.mlP.getBaseFragmentActivity().isProgressBarShown()) {
            this.mfs = new ac(this.mlP, this.mlP.aEh);
            this.mfr = new AlertDialog.Builder(this.mlP.getContext(), R.style.DialogTheme).create();
            this.mfr.setCanceledOnTouchOutside(true);
            g.showDialog(this.mfr, this.mlP.getFragmentActivity());
            Window window = this.mfr.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.mfs.getView());
            this.mfs.vq(adVar == null ? false : adVar.lWP);
            this.mfs.vr(adVar == null ? false : adVar.lWT);
            this.mfs.vs(adVar == null ? false : adVar.lWX);
            this.mfs.vu(adVar == null ? false : adVar.lWU);
            this.mfs.vv(adVar == null ? true : adVar.lWR);
            if (adVar == null) {
                this.mfs.aq(false, false);
                this.mfs.ar(false, false);
            } else {
                this.mfs.aq(adVar.lWV, adVar.lXb);
                this.mfs.ar(adVar.lWW, adVar.lXa);
            }
            boolean z = adVar == null ? false : adVar.FD;
            boolean z2 = adVar == null ? false : adVar.isHostOnly;
            boolean z3 = adVar == null ? false : adVar.lWS;
            boolean z4 = adVar == null ? false : adVar.lWQ;
            boolean z5 = adVar == null ? false : adVar.lWZ;
            boolean z6 = adVar == null ? false : adVar.lWY;
            this.mfs.ap(z3, z2);
            this.mfs.as(z4, z);
            this.mfs.at(z6, z5);
            if (adVar != null) {
                this.mfs.lWM = adVar.lXc;
                if (adVar.lXc) {
                    this.mfs.dpI().setText(R.string.report_text);
                    this.mfs.vu(false);
                }
            }
            this.mfs.vt(adVar != null ? adVar.lXd : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.mlP.dmq() != null && this.mlP.dmq().getPbData() != null && this.mlP.dmq().getPbData().getThreadId() != null && this.mlP.dmq().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.mfs.dpL().setText(R.string.have_called_fans_short);
            }
            dsj();
        }
    }

    private void dsj() {
        if (this.mfs != null) {
            this.mfs.dpP();
        }
    }

    public void baM() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.mfr != null) {
                        g.dismissDialog(a.this.mfr, a.this.mlP.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.mA().postDelayed(this.runnable, 100L);
    }

    public void dsk() {
        if (this.mfr != null) {
            g.dismissDialog(this.mfr, this.mlP.getPageContext().getPageActivity());
        }
    }

    public ac dsl() {
        return this.mfs;
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
        if (this.mlP == null || !this.mlP.isAdded()) {
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
                    this.lRZ = ((TbImageView) view).getBdImage();
                    this.lSa = ((TbImageView) view).getUrl();
                    if (this.lRZ == null || TextUtils.isEmpty(this.lSa)) {
                        return true;
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lSb = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lSb = null;
                    }
                } else if (view instanceof GifView) {
                    if (((GifView) view).getBdImage() != null) {
                        this.lRZ = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            this.lSa = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.lSb = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.lSb = null;
                        }
                    } else {
                        return true;
                    }
                } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                    this.lRZ = ((TbMemeImageView) view).getBdImage();
                    if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                        this.lSa = ((TbMemeImageView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lSb = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lSb = null;
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
                    a(this.lSO, this.lRZ.isGif());
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
        this.kpS = (PostData) sparseArray2.get(R.id.tag_clip_board);
        if (this.kpS == null || this.mlP.dtU() == null) {
            return true;
        }
        if (!this.mlP.dtU().bjZ() || this.kpS.getId() == null || !this.kpS.getId().equals(this.mlP.dmq().bnY())) {
            z = false;
        } else {
            z = true;
        }
        boolean z3 = this.mlP.dmq().getPbData() != null && this.mlP.dmq().getPbData().dlC();
        if (this.lRI == null) {
            this.lRI = new k(this.mlP.getContext());
            this.lRI.a(this.lSA);
        }
        ArrayList arrayList = new ArrayList();
        if (view != null && sparseArray2 != null) {
            boolean z4 = dG(view) && !z3;
            boolean z5 = (!dG(view) || this.lRZ == null || this.lRZ.isGif()) ? false : true;
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
                arrayList.add(new com.baidu.tbadk.core.dialog.g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), this.lRI));
            }
            if (z5) {
                arrayList.add(new com.baidu.tbadk.core.dialog.g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), this.lRI));
            }
            if (!z4 && !z5) {
                com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(3, TbadkCoreApplication.getInst().getString(R.string.copy), this.lRI);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_clip_board, this.kpS);
                gVar2.eVl.setTag(sparseArray3);
                arrayList.add(gVar2);
            }
            if (!z2 && !z3) {
                if (z) {
                    gVar = new com.baidu.tbadk.core.dialog.g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), this.lRI);
                } else {
                    gVar = new com.baidu.tbadk.core.dialog.g(4, TbadkCoreApplication.getInst().getString(R.string.mark), this.lRI);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_clip_board, this.kpS);
                sparseArray4.put(R.id.tag_is_subpb, false);
                gVar.eVl.setTag(sparseArray4);
                arrayList.add(gVar);
            }
            if (TbadkCoreApplication.isLogin() && !this.lRy) {
                if (!z8 && z7) {
                    com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), this.lRI);
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
                    gVar3.eVl.setTag(sparseArray5);
                    arrayList.add(gVar3);
                } else {
                    if ((va(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), this.lRI);
                        gVar4.eVl.setTag(str);
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
                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.lRI);
                        gVar6.eVl.setTag(sparseArray6);
                    } else {
                        sparseArray6.put(R.id.tag_should_delete_visible, false);
                    }
                    gVar5 = new com.baidu.tbadk.core.dialog.g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), this.lRI);
                    gVar5.eVl.setTag(sparseArray6);
                } else if (z10) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.tag_should_manage_visible, false);
                    sparseArray7.put(R.id.tag_user_mute_visible, false);
                    sparseArray7.put(R.id.tag_should_delete_visible, true);
                    sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                    sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                    sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                    sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                    if (this.mlP.dmq().getPbData().dlo() == 1002 && !z6) {
                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), this.lRI);
                    } else {
                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.lRI);
                    }
                    gVar6.eVl.setTag(sparseArray7);
                }
                if (gVar6 != null) {
                    arrayList.add(gVar6);
                }
                if (gVar5 != null) {
                    arrayList.add(gVar5);
                }
            }
            if (com.baidu.tbadk.a.d.bjm()) {
                list = com.baidu.tieba.pb.pb.main.d.a.fq(com.baidu.tieba.pb.pb.main.d.a.x(com.baidu.tieba.pb.pb.main.d.a.a(arrayList, this.kpS.bpJ(), sparseArray2, this.lRI), this.lQU));
                this.lRI.a(com.baidu.tieba.pb.pb.main.d.a.t(this.kpS));
            } else {
                list = arrayList;
            }
            this.lRI.k(list, true);
            this.lRH = new i(this.mlP.getPageContext(), this.lRI);
            this.lRH.QE();
            TiebaStatic.log(new ar("c13272").dR("tid", this.mlP.dmq().dot()).dR("fid", this.mlP.dmq().getForumId()).dR("uid", this.mlP.dmq().getPbData().dkZ().bnQ().getUserId()).dR("post_id", this.mlP.dmq().bBJ()).ap("obj_source", z2 ? 2 : 1));
        }
        return true;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.mlP = videoPbFragment;
        this.lRX = videoPbFragment.getUniqueId();
        this.lRA = new com.baidu.tieba.pb.pb.report.a(this.mlP.getContext());
        this.lRA.x(this.mlP.getUniqueId());
        this.maL = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.17
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.mlP.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.mlP.dmq().getPbData().getUserData().getUserId());
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
                a.this.mlP.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.mlP.getPageContext().getPageActivity(), a.this.mlP.dmq().getPbData().getForum().getId(), a.this.mlP.dmq().getPbData().getForum().getName(), a.this.mlP.dmq().getPbData().dkZ().getId(), valueOf, str, str3, str2, str4)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FH(int i) {
        TiebaStatic.log(new ar("c14000").dR("tid", this.mlP.dmq().dot()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("obj_type", String.valueOf(com.baidu.tieba.pb.pb.main.d.a.Gk(i))));
    }

    public void wu(boolean z) {
        this.lQU = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dD(View view) {
        if (view != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.lQU ? 2 : 3));
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
            if (postData.getId() != null && postData.getId().equals(this.mlP.dmq().bnY())) {
                z = true;
            }
            MarkData o = this.mlP.dmq().o(postData);
            if (this.mlP.dmq().getPbData() != null && this.mlP.dmq().getPbData().dlC() && (L = this.mlP.L(this.mlP.dmq().getPbData())) != null) {
                o = this.mlP.dmq().o(L);
            }
            if (o != null) {
                this.mlP.dqK();
                if (this.mlP.dtU() != null) {
                    this.mlP.dtU().a(o);
                    if (!z) {
                        this.mlP.dtU().bkb();
                    } else {
                        this.mlP.dtU().bka();
                    }
                }
            }
        }
    }

    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dkZ() != null) {
            if (fVar.dkZ().getThreadType() == 0) {
                return 1;
            }
            if (fVar.dkZ().getThreadType() == 54) {
                return 2;
            }
            if (fVar.dkZ().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    private boolean va(boolean z) {
        if (this.mlP.dmq() == null || this.mlP.dmq().getPbData() == null) {
            return false;
        }
        return ((this.mlP.dmq().getPbData().dlo() != 0) || this.mlP.dmq().getPbData().dkZ() == null || this.mlP.dmq().getPbData().dkZ().bnQ() == null || TextUtils.equals(this.mlP.dmq().getPbData().dkZ().bnQ().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void Pt(String str) {
        if (this.mlP.dmq() != null && this.mlP.dmq().getPbData() != null && this.mlP.dmq().getPbData().dlC()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.mlP.dmq().dot(), str);
            cb dkZ = this.mlP.dmq().getPbData().dkZ();
            if (dkZ.bmx()) {
                format = format + "&channelid=33833";
            } else if (dkZ.bpM()) {
                format = format + "&channelid=33842";
            } else if (dkZ.bmy()) {
                format = format + "&channelid=33840";
            }
            Pu(format);
            return;
        }
        this.lRA.PU(str);
    }

    private void Pu(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.mlP.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.lRH != null && this.lRH.isShowing()) {
                this.lRH.dismiss();
                this.lRH = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.mlP.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.19
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.lRH != null) {
                            a.this.lRH.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.lRX);
                            userMuteAddAndDelCustomMessage.setTag(a.this.lRX);
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
                this.lRH = new i(this.mlP.getPageContext(), kVar);
                this.lRH.QE();
            }
        }
    }

    public void dnS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mlP.getPageContext().getPageActivity());
        aVar.Au(this.mlP.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.20
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.mlP.getFragmentActivity(), 2, true, 4);
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
        aVar.b(this.mlP.getPageContext()).bqx();
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
        sparseArray.put(lZW, Integer.valueOf(lZX));
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
        this.lZf = new com.baidu.tbadk.core.dialog.a(this.mlP.getActivity());
        if (StringUtils.isNull(str2)) {
            this.lZf.nx(i3);
        } else {
            this.lZf.setOnlyMessageShowCenter(false);
            this.lZf.Au(str2);
        }
        this.lZf.setYesButtonTag(sparseArray);
        this.lZf.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.23
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.mlP.a(aVar, (JSONArray) null);
            }
        });
        this.lZf.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lZf.jF(true);
        this.lZf.b(this.mlP.getPageContext());
        if (z) {
            this.lZf.bqx();
        } else if (dqE()) {
            h hVar = new h(this.mlP.dmq().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.mlP.dmq().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.mlP.dmq().getPbData().dlI().has_forum_rule.intValue());
            hVar.eg(this.mlP.dmq().getPbData().getForum().getId(), this.mlP.dmq().getPbData().getForum().getName());
            hVar.setForumHeadUrl(this.mlP.dmq().getPbData().getForum().getImage_url());
            hVar.setUserLevel(this.mlP.dmq().getPbData().getForum().getUser_level());
            a(this.lZf, i, hVar, this.mlP.dmq().getPbData().getUserData());
        } else {
            a(this.lZf, i);
        }
    }

    private boolean dqE() {
        if (this.mlP == null || this.mlP.dmq().getPbData().getForum().getDeletedReasonInfo() == null) {
            return false;
        }
        return 1 == this.mlP.dmq().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.mlP != null && aVar != null) {
            if (this.jQU == null && this.mlP.getView() != null) {
                this.jQU = new f(this.mlP.getPageContext(), this.mlP.getView());
            }
            AntiData cBs = cBs();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cBs != null && cBs.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBs.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray);
            this.jQU.setDefaultReasonArray(new String[]{this.mlP.getString(R.string.delete_thread_reason_1), this.mlP.getString(R.string.delete_thread_reason_2), this.mlP.getString(R.string.delete_thread_reason_3), this.mlP.getString(R.string.delete_thread_reason_4), this.mlP.getString(R.string.delete_thread_reason_5)});
            this.jQU.setData(avVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.jQU.Et(str);
            this.jQU.a(new f.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void W(JSONArray jSONArray) {
                    a.this.mlP.a(aVar, jSONArray);
                }
            });
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i, h hVar, UserData userData) {
        String str;
        if (this.mlP != null && aVar != null) {
            if (this.maw == null && this.mlP.getView() != null) {
                this.maw = new com.baidu.tieba.NEGFeedBack.i(this.mlP.getPageContext(), this.mlP.getView(), hVar, userData);
            }
            AntiData cBs = cBs();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cBs != null && cBs.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBs.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            av avVar = new av();
            avVar.setFeedBackReasonMap(sparseArray);
            this.maw.setDefaultReasonArray(new String[]{this.mlP.getString(R.string.delete_thread_reason_1), this.mlP.getString(R.string.delete_thread_reason_2), this.mlP.getString(R.string.delete_thread_reason_3), this.mlP.getString(R.string.delete_thread_reason_4), this.mlP.getString(R.string.delete_thread_reason_5)});
            this.maw.setData(avVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.maw.Et(str);
            this.maw.a(new i.b() { // from class: com.baidu.tieba.pb.videopb.b.a.4
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void W(JSONArray jSONArray) {
                    a.this.mlP.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData cBs() {
        if (this.mlP.dmq() == null || this.mlP.dmq().getPbData() == null) {
            return null;
        }
        return this.mlP.dmq().getPbData().getAnti();
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
        k kVar = new k(this.mlP.getContext());
        kVar.setTitleText(this.mlP.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.5
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.lZe.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 10:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 11:
                            if (a.this.maL != null) {
                                a.this.maL.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.mlP.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.mlP.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.eVl.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(11, this.mlP.getString(R.string.forbidden_person), kVar);
            gVar3.eVl.setTag(sparseArray3);
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
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.mlP.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.mlP.getString(R.string.mute), kVar);
            }
            gVar.eVl.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.bw(arrayList);
        if (this.lZe == null) {
            this.lZe = new com.baidu.tbadk.core.dialog.i(this.mlP.getPageContext(), kVar);
        } else {
            this.lZe.a(kVar);
        }
        this.lZe.QE();
    }

    public void dno() {
        if (this.lRa == null) {
            this.lRa = new com.baidu.tbadk.core.dialog.b(this.mlP.getPageContext().getPageActivity());
            this.lRa.a(new String[]{this.mlP.getPageContext().getString(R.string.call_phone), this.mlP.getPageContext().getString(R.string.sms_phone), this.mlP.getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0558b() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0558b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.mlP.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.lNd = a.this.lNd.trim();
                        UtilHelper.callPhone(a.this.mlP.getPageContext().getPageActivity(), a.this.lNd);
                        new com.baidu.tieba.pb.pb.main.b(a.this.mlP.dmq().dot(), a.this.lNd, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.mlP.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.lNd = a.this.lNd.trim();
                        UtilHelper.smsPhone(a.this.mlP.getPageContext().getPageActivity(), a.this.lNd);
                        new com.baidu.tieba.pb.pb.main.b(a.this.mlP.dmq().dot(), a.this.lNd, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.lNd = a.this.lNd.trim();
                        UtilHelper.startBaiDuBar(a.this.mlP.getPageContext().getPageActivity(), a.this.lNd);
                        bVar.dismiss();
                    }
                }
            }).nD(b.a.BOTTOM_TO_TOP).nE(17).d(this.mlP.getPageContext());
        }
    }

    public void dS(final View view) {
        String[] strArr;
        int i = 0;
        if (this.mlP != null && this.mlP.dmq() != null) {
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mlP.getPageContext());
            if (this.mlP.dmq().getPbData().lJY == null || this.mlP.dmq().getPbData().lJY.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.mlP.dmq().getPbData().lJY.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mlP.dmq().getPbData().lJY.size()) {
                        break;
                    }
                    strArr2[i2] = this.mlP.dmq().getPbData().lJY.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.mlP.dmq().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.mlP.dmq().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.mlP.dmq().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.mlP.dmq().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new ar("c12097").ap("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).ap("obj_type", i4));
                    if (a.this.mlP.dmq().getPbData().lJY != null && a.this.mlP.dmq().getPbData().lJY.size() > i3) {
                        i3 = a.this.mlP.dmq().getPbData().lJY.get(i3).sort_type.intValue();
                    }
                    boolean FU = a.this.mlP.dmq().FU(i3);
                    view.setTag(Integer.valueOf(a.this.mlP.dmq().doN()));
                    if (FU) {
                        a.this.mlP.setIsLoading(true);
                    }
                }
            });
            iVar.QE();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mlP.getActivity());
            aVar.At(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.Au(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.jF(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new ar("c12528").dR("obj_id", metaData.getUserId()).ap("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new ar("c12528").dR("obj_id", metaData.getUserId()).ap("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.mlP.duf() != null) {
                        a.this.mlP.duf().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.mlP.getPageContext().getUniqueId(), a.this.mlP.dmq().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.mlP.getPageContext()).bqx();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.lRX);
        userMuteAddAndDelCustomMessage.setTag(this.lRX);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void Dc(String str) {
        if (str == null) {
            str = "";
        }
        if (this.mlP != null && this.mlP.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mlP.getPageContext().getPageActivity());
            aVar.Au(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mlP.getPageContext()).bqx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mlP.getBaseFragmentActivity());
        if (com.baidu.tbadk.core.util.au.isEmpty(str)) {
            aVar.Au(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Au(str);
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
        aVar.b(this.mlP.getPageContext()).bqx();
    }

    public void showLoadingDialog() {
        if (this.iDG == null) {
            this.iDG = new com.baidu.tbadk.core.view.a(this.mlP.getPageContext());
        }
        this.iDG.setDialogVisiable(true);
    }

    public void ckq() {
        if (this.iDG != null) {
            this.iDG.setDialogVisiable(false);
        }
    }

    public void i(SparseArray<Object> sparseArray) {
        PostData postData;
        boolean z;
        String str;
        com.baidu.tbadk.core.dialog.g gVar;
        if (this.mlP != null && this.mlP.dmq() != null && sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            if (this.lRI == null) {
                this.lRI = new k(this.mlP.getContext());
                this.lRI.a(this.lSA);
            }
            ArrayList arrayList = new ArrayList();
            boolean z2 = this.mlP.dmq().getPbData() != null && this.mlP.dmq().getPbData().dlC();
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
                if (postData.bpJ() != null) {
                    com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(8, (postData.bpJ().hasAgree && postData.bpt() == 5) ? this.mlP.getString(R.string.action_cancel_dislike) : this.mlP.getString(R.string.action_dislike), this.lRI);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    gVar2.eVl.setTag(sparseArray2);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z4 && z3) {
                        com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, this.mlP.getString(R.string.mute_option), this.lRI);
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
                        gVar3.eVl.setTag(sparseArray3);
                        arrayList.add(gVar3);
                    } else {
                        if ((va(z) && TbadkCoreApplication.isLogin()) && !z2) {
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, this.mlP.getString(R.string.report_text), this.lRI);
                            gVar4.eVl.setTag(str);
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
                            gVar5 = new com.baidu.tbadk.core.dialog.g(6, this.mlP.getString(R.string.delete), this.lRI);
                            gVar5.eVl.setTag(sparseArray4);
                        } else {
                            sparseArray4.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new com.baidu.tbadk.core.dialog.g(7, this.mlP.getString(R.string.bar_manager), this.lRI);
                        gVar.eVl.setTag(sparseArray4);
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
                            if (this.mlP.dmq().getPbData().dlo() == 1002 && !z) {
                                gVar5 = new com.baidu.tbadk.core.dialog.g(6, this.mlP.getString(R.string.report_text), this.lRI);
                            } else {
                                gVar5 = new com.baidu.tbadk.core.dialog.g(6, this.mlP.getString(R.string.delete), this.lRI);
                            }
                            gVar5.eVl.setTag(sparseArray5);
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
                this.lRI.bw(arrayList);
                this.lRH = new com.baidu.tbadk.core.dialog.i(this.mlP.getPageContext(), this.lRI);
                this.lRH.QE();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.feF == null) {
                this.feF = new com.baidu.tbadk.core.message.a();
            }
            if (this.fep == null) {
                this.fep = new e();
                this.fep.uniqueId = this.mlP.getUniqueId();
            }
            com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
            eVar.eMa = 5;
            eVar.eMg = 8;
            eVar.eMf = 2;
            if (this.mlP != null && this.mlP.dmq() != null) {
                eVar.eMe = this.mlP.dmq().dpe();
            }
            if (eVar != null) {
                eVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (eVar != null) {
                        eVar.eMh = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (eVar != null) {
                        eVar.eMh = 1;
                        i = 0;
                    }
                }
                this.feF.a(agreeData, i, this.mlP.getUniqueId(), false);
                this.feF.a(agreeData, this.fep);
                if (this.mlP == null && this.mlP.dmq() != null && this.mlP.dmq().getPbData() != null) {
                    this.feF.a(this.mlP.doa(), eVar, agreeData, this.mlP.dmq().getPbData().dkZ());
                    return;
                }
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (eVar != null) {
                eVar.eMh = 1;
            }
            i = 0;
            this.feF.a(agreeData, i, this.mlP.getUniqueId(), false);
            this.feF.a(agreeData, this.fep);
            if (this.mlP == null) {
            }
        }
    }

    public void a(final b.InterfaceC0558b interfaceC0558b, boolean z) {
        if (this.lZn != null) {
            this.lZn.dismiss();
            this.lZn = null;
        }
        k kVar = new k(this.mlP.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.mlP.dmq().getPbData() != null && this.mlP.dmq().getPbData().dkZ() != null && !this.mlP.dmq().getPbData().dkZ().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.mlP.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.mlP.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.bw(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.lZn.dismiss();
                interfaceC0558b.a(null, i, view);
            }
        });
        this.lZn = new com.baidu.tbadk.core.dialog.i(this.mlP.getPageContext(), kVar);
        this.lZn.QE();
    }

    public void aZ(ArrayList<al> arrayList) {
        if (this.lZi == null) {
            this.lZi = LayoutInflater.from(this.mlP.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.mlP.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lZi);
        if (this.lZh == null) {
            this.lZh = new Dialog(this.mlP.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lZh.setCanceledOnTouchOutside(true);
            this.lZh.setCancelable(true);
            this.lZq = (ScrollView) this.lZi.findViewById(R.id.good_scroll);
            this.lZh.setContentView(this.lZi);
            WindowManager.LayoutParams attributes = this.lZh.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.lZh.getWindow().setAttributes(attributes);
            this.izu = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.lZm = (String) compoundButton.getTag();
                        if (a.this.izt != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.izt) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.lZm != null && !str.equals(a.this.lZm)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.lZj = (LinearLayout) this.lZi.findViewById(R.id.good_class_group);
            this.lZl = (TextView) this.lZi.findViewById(R.id.dialog_button_cancel);
            this.lZl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lZh instanceof Dialog) {
                        g.b(a.this.lZh, a.this.mlP.getPageContext());
                    }
                }
            });
            this.lZk = (TextView) this.lZi.findViewById(R.id.dialog_button_ok);
            this.lZk.setOnClickListener(this.mlP.dtV());
        }
        this.lZj.removeAllViews();
        this.izt = new ArrayList();
        CustomBlueCheckRadioButton fU = fU("0", this.mlP.getPageContext().getString(R.string.thread_good_class));
        this.izt.add(fU);
        fU.setChecked(true);
        this.lZj.addView(fU);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                al alVar = arrayList.get(i2);
                if (alVar != null && !TextUtils.isEmpty(alVar.bmb()) && alVar.bmc() > 0) {
                    CustomBlueCheckRadioButton fU2 = fU(String.valueOf(alVar.bmc()), alVar.bmb());
                    this.izt.add(fU2);
                    View view = new View(this.mlP.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    ap.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.lZj.addView(view);
                    this.lZj.addView(fU2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.lZq.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.mlP.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.mlP.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.mlP.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.lZq.setLayoutParams(layoutParams2);
            this.lZq.removeAllViews();
            if (this.lZj != null && this.lZj.getParent() == null) {
                this.lZq.addView(this.lZj);
            }
        }
        g.a(this.lZh, this.mlP.getPageContext());
    }

    private CustomBlueCheckRadioButton fU(String str, String str2) {
        Activity pageActivity = this.mlP.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.izu);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public boolean dG(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void f(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.lRX;
        userMuteCheckCustomMessage.setTag(this.lRX);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void drf() {
        if (this.lZf != null) {
            this.lZf.dismiss();
        }
        if (this.lZg != null) {
            g.b(this.lZg, this.mlP.getPageContext());
        }
        if (this.lZh != null) {
            g.b(this.lZh, this.mlP.getPageContext());
        }
        if (this.lZe != null) {
            this.lZe.dismiss();
        }
    }

    public void duM() {
        if (this.lRH != null) {
            this.lRH.dismiss();
        }
    }

    public void dre() {
        baM();
        this.mlP.dqh();
        if (this.lRH != null) {
            this.lRH.dismiss();
        }
        drf();
    }

    public void drd() {
        baM();
        this.mlP.dqh();
        if (this.lRH != null) {
            this.lRH.dismiss();
        }
        this.mlP.cCV();
        drf();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener dtX() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b duN() {
        return this.lRa;
    }

    public void setPhoneNumber(String str) {
        this.lNd = str;
    }

    public String dqJ() {
        return this.lZm;
    }

    public View dqI() {
        if (this.lZi != null) {
            return this.lZi.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
