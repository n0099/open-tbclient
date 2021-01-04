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
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.x;
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
    public static int lVE = 3;
    public static int lVF = 0;
    public static int lVG = 3;
    public static int lVH = 4;
    public static int lVI = 5;
    public static int lVJ = 6;
    private at eLv;
    private e fgI;
    private com.baidu.tbadk.core.message.a fgY;
    private List<CustomBlueCheckRadioButton> iyq;
    private f jOD;
    private String lIU;
    private boolean lMF;
    public BdUniqueId lNF;
    private com.baidu.adp.widget.ImageView.a lNH;
    private String lNI;
    private TbRichTextMemeInfo lNJ;
    private com.baidu.tieba.pb.pb.report.a lNi;
    private i lNp;
    private k lNq;
    private com.baidu.tieba.NEGFeedBack.i lWd;
    private PbFragment.b lWr;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    public VideoPbFragment mht;
    private Runnable runnable;
    private i lUW = null;
    private com.baidu.tbadk.core.dialog.a lUO = null;
    private Dialog lUP = null;
    private Dialog lUQ = null;
    private View lUR = null;
    private LinearLayout lUS = null;
    private TextView lUT = null;
    private TextView lUU = null;
    private String lUV = null;
    private ScrollView lUZ = null;
    private CompoundButton.OnCheckedChangeListener iyr = null;
    private i lUN = null;
    private com.baidu.tbadk.core.view.a iCD = null;
    private com.baidu.tbadk.core.dialog.b lML = null;
    private AlertDialog maU = null;
    private ac maV = null;
    PostData kmq = null;
    private boolean lNg = d.bmF();
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.12
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return a.this.dT(view);
        }
    };
    private k.c lOi = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (a.this.lNp != null) {
                a.this.lNp.dismiss();
            }
            a.this.GU(i);
            switch (i) {
                case -4:
                    View view2 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_share);
                    a.this.dF(view2);
                    view2.performClick();
                    return;
                case -3:
                    View view3 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_reply);
                    a.this.dF(view3);
                    view3.performClick();
                    return;
                case -2:
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    if (d.bmQ() || d.bmR()) {
                        View view4 = (View) sparseArray2.get(R.id.pb_dialog_item_zan_2);
                        a.this.dF(view4);
                        ((AgreeView) view4).getImgDisagree().performClick();
                        return;
                    }
                    View view5 = (View) sparseArray2.get(R.id.pb_dialog_item_zan_1);
                    a.this.dF(view5);
                    ((AgreeView) view5).getImgDisagree().performClick();
                    return;
                case -1:
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (d.bmQ() || d.bmR()) {
                        View view6 = (View) sparseArray3.get(R.id.pb_dialog_item_zan_2);
                        a.this.dF(view6);
                        ((AgreeView) view6).getImgAgree().performClick();
                        return;
                    }
                    View view7 = (View) sparseArray3.get(R.id.pb_dialog_item_zan_1);
                    a.this.dF(view7);
                    ((AgreeView) view7).getImgAgree().performClick();
                    return;
                case 0:
                default:
                    return;
                case 1:
                    if (a.this.lNH != null && !TextUtils.isEmpty(a.this.lNI)) {
                        if (a.this.lNJ == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.lNI));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.lNI;
                            aVar.pkgId = a.this.lNJ.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.lNJ.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.lNH = null;
                        a.this.lNI = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.lNH != null && !TextUtils.isEmpty(a.this.lNI)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.mht.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.mht.getPageContext().getPageActivity())) {
                            if (a.this.eLv == null) {
                                a.this.eLv = new at(a.this.mht.getPageContext());
                            }
                            a.this.eLv.p(a.this.lNI, a.this.lNH.getImageByte());
                            a.this.lNH = null;
                            a.this.lNI = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.kmq != null) {
                        a.this.kmq.gV(a.this.mht.getPageContext().getPageActivity());
                        a.this.kmq = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new aq("c11739").an("obj_locate", 2));
                    if (a.this.mht.checkUpIsLogin()) {
                        a.this.dG(view);
                        if (a.this.mht.dnV().getPbData().dmE() != null && a.this.mht.dnV().getPbData().dmE().brq() != null && a.this.mht.dnV().getPbData().dmE().brq().getUserId() != null && a.this.mht.dvy() != null) {
                            int h = a.this.h(a.this.mht.dnV().getPbData());
                            bz dmE = a.this.mht.dnV().getPbData().dmE();
                            if (dmE.bpX()) {
                                i2 = 2;
                            } else if (dmE.bpY()) {
                                i2 = 3;
                            } else if (dmE.bto()) {
                                i2 = 4;
                            } else {
                                i2 = dmE.btp() ? 5 : 1;
                            }
                            TiebaStatic.log(new aq("c12526").dX("tid", a.this.mht.dnV().dpW()).an("obj_locate", 2).dX("obj_id", a.this.mht.dnV().getPbData().dmE().brq().getUserId()).an("obj_type", a.this.mht.dvy().bnx() ? 0 : 1).an("obj_source", h).an("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.mht.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new aq("c13079"));
                        a.this.PK((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new aq("c11739").an("obj_locate", 4));
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
                        a.this.mht.showToast(R.string.network_not_available);
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
                            a.this.dN(view);
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
                    if (bg.checkUpIsLogin(a.this.mht.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.btk() != null) {
                            c bV = com.baidu.tbadk.pageExtra.d.bV(view);
                            if (bV != null) {
                                postData.btk().objSource = bV.getCurrentPageKey();
                            }
                            a.this.d(postData.btk());
                            return;
                        }
                        return;
                    }
                    return;
            }
        }
    };
    private final b.InterfaceC0578b lOw = new b.InterfaceC0578b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0578b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.lNH != null && !TextUtils.isEmpty(a.this.lNI)) {
                if (i == 0) {
                    if (a.this.lNJ == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.lNI));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.lNI;
                        aVar.pkgId = a.this.lNJ.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.lNJ.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.mht.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.mht.getPageContext().getPageActivity())) {
                        if (a.this.eLv == null) {
                            a.this.eLv = new at(a.this.mht.getPageContext());
                        }
                        a.this.eLv.p(a.this.lNI, a.this.lNH.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.lNH = null;
                a.this.lNI = null;
            }
        }
    };

    public void doZ() {
        com.baidu.tieba.pb.data.f pbData;
        bz dmE;
        boolean z = true;
        if (this.mht != null && this.mht.dnV() != null && this.mht.dnV().getPbData() != null && (dmE = (pbData = this.mht.dnV().getPbData()).dmE()) != null && dmE.brq() != null) {
            this.mht.drK();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dmE.brq().getUserId());
            ad adVar = new ad();
            int dmT = this.mht.dnV().getPbData().dmT();
            if (dmT == 1 || dmT == 3) {
                adVar.lSE = true;
                adVar.lSK = dmE.brl() == 1;
            } else {
                adVar.lSE = false;
            }
            if (GW(dmT)) {
                adVar.lSF = true;
                adVar.lSJ = dmE.brm() == 1;
            } else {
                adVar.lSF = false;
            }
            if (dmT == 1002 && !equals) {
                adVar.lSL = true;
            }
            adVar.lSC = uQ(equals);
            adVar.lSG = dpa();
            adVar.lSD = uR(equals);
            adVar.FF = this.mht.dnV().dpY();
            adVar.lSz = true;
            adVar.lSy = uP(equals);
            adVar.lSI = TbadkCoreApplication.getInst().getSkinType() == 1;
            adVar.lSH = true;
            adVar.isHostOnly = this.mht.dnV().getHostMode();
            adVar.lSB = true;
            if (dmE.brH() == null) {
                adVar.lSA = true;
            } else {
                adVar.lSA = false;
            }
            if (pbData.dnh()) {
                adVar.lSz = false;
                adVar.lSB = false;
                adVar.lSA = false;
                adVar.lSE = false;
                adVar.lSF = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.dnh()) {
                z = false;
            }
            adVar.lSM = z;
            a(adVar);
        }
    }

    public boolean GW(int i) {
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
        if (!z || this.mht.dnV().getPbData().getUserData() == null || (forumToolAuth = this.mht.dnV().getPbData().getUserData().getForumToolAuth()) == null) {
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

    private boolean uQ(boolean z) {
        boolean z2;
        com.baidu.tbadk.core.data.ac acVar;
        if (this.mht == null || this.mht.dnV() == null || this.mht.dnV().getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.mht.dnV().getPbData();
        if (pbData.getUserData() == null || !pbData.getUserData().isForumBusinessAccount() || au.isOn()) {
            bz dmE = pbData.dmE();
            if (dmE != null) {
                if (dmE.bpX() || dmE.bpY()) {
                    return false;
                }
                if (dmE.bto() || dmE.btp()) {
                    return z;
                }
            }
            if (z) {
                return true;
            }
            if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
                if (pbData.dmT() != 0) {
                    return pbData.dmT() != 3;
                }
                List<bv> dnb = pbData.dnb();
                if (x.getCount(dnb) > 0) {
                    for (bv bvVar : dnb) {
                        if (bvVar != null && (acVar = bvVar.eSl) != null && acVar.ePV && !acVar.ePW && (acVar.type == 1 || acVar.type == 2)) {
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

    private boolean uR(boolean z) {
        if (z || this.mht == null || this.mht.dnV() == null || this.mht.dnV().getPbData() == null) {
            return false;
        }
        return ((this.mht.dnV().getPbData().getForum() != null && this.mht.dnV().getPbData().getForum().isBlockBawuDelete) || this.mht.dnV().getPbData().dmT() == 0 || this.mht.dnV().getPbData().dmT() == 3) ? false : true;
    }

    private boolean dpa() {
        if (this.mht == null || this.mht.dnV() == null || !this.mht.dnV().dpY()) {
            return false;
        }
        return this.mht.dnV().getPageData() == null || this.mht.dnV().getPageData().bqg() != 0;
    }

    public void a(ad adVar) {
        if (!this.mht.getBaseFragmentActivity().isProgressBarShown()) {
            this.maV = new ac(this.mht, this.mht.aHh);
            this.maU = new AlertDialog.Builder(this.mht.getContext(), R.style.DialogTheme).create();
            this.maU.setCanceledOnTouchOutside(true);
            g.showDialog(this.maU, this.mht.getFragmentActivity());
            Window window = this.maU.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.maV.getView());
            this.maV.vf(adVar == null ? false : adVar.lSy);
            this.maV.vg(adVar == null ? false : adVar.lSC);
            this.maV.vh(adVar == null ? false : adVar.lSG);
            this.maV.vj(adVar == null ? false : adVar.lSD);
            this.maV.vk(adVar == null ? true : adVar.lSA);
            if (adVar == null) {
                this.maV.aq(false, false);
                this.maV.ar(false, false);
            } else {
                this.maV.aq(adVar.lSE, adVar.lSK);
                this.maV.ar(adVar.lSF, adVar.lSJ);
            }
            boolean z = adVar == null ? false : adVar.FF;
            boolean z2 = adVar == null ? false : adVar.isHostOnly;
            boolean z3 = adVar == null ? false : adVar.lSB;
            boolean z4 = adVar == null ? false : adVar.lSz;
            boolean z5 = adVar == null ? false : adVar.lSI;
            boolean z6 = adVar == null ? false : adVar.lSH;
            this.maV.ap(z3, z2);
            this.maV.as(z4, z);
            this.maV.at(z6, z5);
            if (adVar != null) {
                this.maV.lSv = adVar.lSL;
                if (adVar.lSL) {
                    this.maV.drl().setText(R.string.report_text);
                    this.maV.vj(false);
                }
            }
            this.maV.vi(adVar != null ? adVar.lSM : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.mht.dnV() != null && this.mht.dnV().getPbData() != null && this.mht.dnV().getPbData().getThreadId() != null && this.mht.dnV().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.maV.dro().setText(R.string.have_called_fans_short);
            }
            dtM();
        }
    }

    private void dtM() {
        if (this.maV != null) {
            this.maV.drs();
        }
    }

    public void bes() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.maU != null) {
                        g.dismissDialog(a.this.maU, a.this.mht.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.mB().postDelayed(this.runnable, 100L);
    }

    public void dtN() {
        if (this.maU != null) {
            g.dismissDialog(this.maU, this.mht.getPageContext().getPageActivity());
        }
    }

    public ac dtO() {
        return this.maV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0091 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dT(View view) {
        boolean z;
        boolean z2;
        List<com.baidu.tbadk.core.dialog.g> list;
        com.baidu.tbadk.core.dialog.g gVar;
        SparseArray sparseArray;
        if (this.mht == null || !this.mht.isAdded()) {
            return true;
        }
        SparseArray sparseArray2 = null;
        try {
            sparseArray2 = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        if (sparseArray2 == null) {
            if (dI(view)) {
                if (view instanceof TbImageView) {
                    this.lNH = ((TbImageView) view).getBdImage();
                    this.lNI = ((TbImageView) view).getUrl();
                    if (this.lNH == null || TextUtils.isEmpty(this.lNI)) {
                        return true;
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lNJ = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lNJ = null;
                    }
                } else if (view instanceof GifView) {
                    if (((GifView) view).getBdImage() != null) {
                        this.lNH = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            this.lNI = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.lNJ = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.lNJ = null;
                        }
                    } else {
                        return true;
                    }
                } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                    this.lNH = ((TbMemeImageView) view).getBdImage();
                    if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                        this.lNI = ((TbMemeImageView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lNJ = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lNJ = null;
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
                    a(this.lOw, this.lNH.isGif());
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
        this.kmq = (PostData) sparseArray2.get(R.id.tag_clip_board);
        if (this.kmq == null || this.mht.dvy() == null) {
            return true;
        }
        if (!this.mht.dvy().bnx() || this.kmq.getId() == null || !this.kmq.getId().equals(this.mht.dnV().bry())) {
            z = false;
        } else {
            z = true;
        }
        boolean z3 = this.mht.dnV().getPbData() != null && this.mht.dnV().getPbData().dnh();
        if (this.lNq == null) {
            this.lNq = new k(this.mht.getContext());
            this.lNq.a(this.lOi);
        }
        ArrayList arrayList = new ArrayList();
        if (view != null && sparseArray2 != null) {
            boolean z4 = dI(view) && !z3;
            boolean z5 = (!dI(view) || this.lNH == null || this.lNH.isGif()) ? false : true;
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
                arrayList.add(new com.baidu.tbadk.core.dialog.g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), this.lNq));
            }
            if (z5) {
                arrayList.add(new com.baidu.tbadk.core.dialog.g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), this.lNq));
            }
            if (!z4 && !z5) {
                com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(3, TbadkCoreApplication.getInst().getString(R.string.copy), this.lNq);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_clip_board, this.kmq);
                gVar2.eXH.setTag(sparseArray3);
                arrayList.add(gVar2);
            }
            if (!z2 && !z3) {
                if (z) {
                    gVar = new com.baidu.tbadk.core.dialog.g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), this.lNq);
                } else {
                    gVar = new com.baidu.tbadk.core.dialog.g(4, TbadkCoreApplication.getInst().getString(R.string.mark), this.lNq);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_clip_board, this.kmq);
                sparseArray4.put(R.id.tag_is_subpb, false);
                gVar.eXH.setTag(sparseArray4);
                arrayList.add(gVar);
            }
            if (TbadkCoreApplication.isLogin() && !this.lNg) {
                if (!z8 && z7) {
                    com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), this.lNq);
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
                    gVar3.eXH.setTag(sparseArray5);
                    arrayList.add(gVar3);
                } else {
                    if ((uP(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), this.lNq);
                        gVar4.eXH.setTag(str);
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
                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.lNq);
                        gVar6.eXH.setTag(sparseArray6);
                    } else {
                        sparseArray6.put(R.id.tag_should_delete_visible, false);
                    }
                    gVar5 = new com.baidu.tbadk.core.dialog.g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), this.lNq);
                    gVar5.eXH.setTag(sparseArray6);
                } else if (z10) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.tag_should_manage_visible, false);
                    sparseArray7.put(R.id.tag_user_mute_visible, false);
                    sparseArray7.put(R.id.tag_should_delete_visible, true);
                    sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                    sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                    sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                    sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                    if (this.mht.dnV().getPbData().dmT() == 1002 && !z6) {
                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), this.lNq);
                    } else {
                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.lNq);
                    }
                    gVar6.eXH.setTag(sparseArray7);
                }
                if (gVar6 != null) {
                    arrayList.add(gVar6);
                }
                if (gVar5 != null) {
                    arrayList.add(gVar5);
                }
            }
            if (com.baidu.tbadk.a.d.bmT()) {
                list = com.baidu.tieba.pb.pb.main.d.a.fs(com.baidu.tieba.pb.pb.main.d.a.w(com.baidu.tieba.pb.pb.main.d.a.a(arrayList, this.kmq.btk(), sparseArray2, this.lNq), this.lMF));
                this.lNq.a(com.baidu.tieba.pb.pb.main.d.a.t(this.kmq));
            } else {
                list = arrayList;
            }
            this.lNq.k(list, true);
            this.lNp = new i(this.mht.getPageContext(), this.lNq);
            this.lNp.SY();
            TiebaStatic.log(new aq("c13272").dX("tid", this.mht.dnV().dpW()).dX("fid", this.mht.dnV().getForumId()).dX("uid", this.mht.dnV().getPbData().dmE().brq().getUserId()).dX("post_id", this.mht.dnV().bFk()).an("obj_source", z2 ? 2 : 1));
        }
        return true;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.mht = videoPbFragment;
        this.lNF = videoPbFragment.getUniqueId();
        this.lNi = new com.baidu.tieba.pb.pb.report.a(this.mht.getContext());
        this.lNi.w(this.mht.getUniqueId());
        this.lWr = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.17
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.mht.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.mht.dnV().getPbData().getUserData().getUserId());
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
                a.this.mht.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.mht.getPageContext().getPageActivity(), a.this.mht.dnV().getPbData().getForum().getId(), a.this.mht.dnV().getPbData().getForum().getName(), a.this.mht.dnV().getPbData().dmE().getId(), valueOf, str, str3, str2, str4)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GU(int i) {
        TiebaStatic.log(new aq("c14000").dX("tid", this.mht.dnV().dpW()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dX("obj_type", String.valueOf(com.baidu.tieba.pb.pb.main.d.a.Hx(i))));
    }

    public void wh(boolean z) {
        this.lMF = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dF(View view) {
        if (view != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.lMF ? 2 : 3));
            view.setTag(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dG(View view) {
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
            if (postData.getId() != null && postData.getId().equals(this.mht.dnV().bry())) {
                z = true;
            }
            MarkData o = this.mht.dnV().o(postData);
            if (this.mht.dnV().getPbData() != null && this.mht.dnV().getPbData().dnh() && (L = this.mht.L(this.mht.dnV().getPbData())) != null) {
                o = this.mht.dnV().o(L);
            }
            if (o != null) {
                this.mht.dsn();
                if (this.mht.dvy() != null) {
                    this.mht.dvy().a(o);
                    if (!z) {
                        this.mht.dvy().bnz();
                    } else {
                        this.mht.dvy().bny();
                    }
                }
            }
        }
    }

    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmE() != null) {
            if (fVar.dmE().getThreadType() == 0) {
                return 1;
            }
            if (fVar.dmE().getThreadType() == 54) {
                return 2;
            }
            if (fVar.dmE().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    private boolean uP(boolean z) {
        if (this.mht.dnV() == null || this.mht.dnV().getPbData() == null) {
            return false;
        }
        return ((this.mht.dnV().getPbData().dmT() != 0) || this.mht.dnV().getPbData().dmE() == null || this.mht.dnV().getPbData().dmE().brq() == null || TextUtils.equals(this.mht.dnV().getPbData().dmE().brq().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void PK(String str) {
        if (this.mht.dnV() != null && this.mht.dnV().getPbData() != null && this.mht.dnV().getPbData().dnh()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.mht.dnV().dpW(), str);
            bz dmE = this.mht.dnV().getPbData().dmE();
            if (dmE.bpX()) {
                format = format + "&channelid=33833";
            } else if (dmE.btn()) {
                format = format + "&channelid=33842";
            } else if (dmE.bpY()) {
                format = format + "&channelid=33840";
            }
            PL(format);
            return;
        }
        this.lNi.Ql(str);
    }

    private void PL(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.mht.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.lNp != null && this.lNp.isShowing()) {
                this.lNp.dismiss();
                this.lNp = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.mht.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.19
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.lNp != null) {
                            a.this.lNp.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.lNF);
                            userMuteAddAndDelCustomMessage.setTag(a.this.lNF);
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
                kVar.bB(arrayList);
                this.lNp = new i(this.mht.getPageContext(), kVar);
                this.lNp.SY();
            }
        }
    }

    public void dpv() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mht.getPageContext().getPageActivity());
        aVar.Bp(this.mht.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.20
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.mht.getFragmentActivity(), 2, true, 4);
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
        aVar.b(this.mht.getPageContext()).btX();
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
        sparseArray.put(lVF, Integer.valueOf(lVG));
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
        this.lUO = new com.baidu.tbadk.core.dialog.a(this.mht.getActivity());
        if (StringUtils.isNull(str2)) {
            this.lUO.pa(i3);
        } else {
            this.lUO.setOnlyMessageShowCenter(false);
            this.lUO.Bp(str2);
        }
        this.lUO.setYesButtonTag(sparseArray);
        this.lUO.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.23
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.mht.a(aVar, (JSONArray) null);
            }
        });
        this.lUO.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lUO.jH(true);
        this.lUO.b(this.mht.getPageContext());
        if (z) {
            this.lUO.btX();
        } else if (dsh()) {
            h hVar = new h(this.mht.dnV().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.mht.dnV().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.mht.dnV().getPbData().dnn().has_forum_rule.intValue());
            hVar.ej(this.mht.dnV().getPbData().getForum().getId(), this.mht.dnV().getPbData().getForum().getName());
            hVar.setForumHeadUrl(this.mht.dnV().getPbData().getForum().getImage_url());
            hVar.setUserLevel(this.mht.dnV().getPbData().getForum().getUser_level());
            a(this.lUO, i, hVar, this.mht.dnV().getPbData().getUserData());
        } else {
            a(this.lUO, i);
        }
    }

    private boolean dsh() {
        if (this.mht == null || this.mht.dnV().getPbData().getForum().getDeletedReasonInfo() == null) {
            return false;
        }
        return 1 == this.mht.dnV().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.mht != null && aVar != null) {
            if (this.jOD == null && this.mht.getView() != null) {
                this.jOD = new f(this.mht.getPageContext(), this.mht.getView());
            }
            AntiData cDY = cDY();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cDY != null && cDY.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cDY.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
            atVar.setFeedBackReasonMap(sparseArray);
            this.jOD.setDefaultReasonArray(new String[]{this.mht.getString(R.string.delete_thread_reason_1), this.mht.getString(R.string.delete_thread_reason_2), this.mht.getString(R.string.delete_thread_reason_3), this.mht.getString(R.string.delete_thread_reason_4), this.mht.getString(R.string.delete_thread_reason_5)});
            this.jOD.setData(atVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.jOD.Fh(str);
            this.jOD.a(new f.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void X(JSONArray jSONArray) {
                    a.this.mht.a(aVar, jSONArray);
                }
            });
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i, h hVar, UserData userData) {
        String str;
        if (this.mht != null && aVar != null) {
            if (this.lWd == null && this.mht.getView() != null) {
                this.lWd = new com.baidu.tieba.NEGFeedBack.i(this.mht.getPageContext(), this.mht.getView(), hVar, userData);
            }
            AntiData cDY = cDY();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cDY != null && cDY.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cDY.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            com.baidu.tbadk.core.data.at atVar = new com.baidu.tbadk.core.data.at();
            atVar.setFeedBackReasonMap(sparseArray);
            this.lWd.setDefaultReasonArray(new String[]{this.mht.getString(R.string.delete_thread_reason_1), this.mht.getString(R.string.delete_thread_reason_2), this.mht.getString(R.string.delete_thread_reason_3), this.mht.getString(R.string.delete_thread_reason_4), this.mht.getString(R.string.delete_thread_reason_5)});
            this.lWd.setData(atVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.lWd.Fh(str);
            this.lWd.a(new i.b() { // from class: com.baidu.tieba.pb.videopb.b.a.4
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void X(JSONArray jSONArray) {
                    a.this.mht.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData cDY() {
        if (this.mht.dnV() == null || this.mht.dnV().getPbData() == null) {
            return null;
        }
        return this.mht.dnV().getPbData().getAnti();
    }

    public void dN(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        k kVar = new k(this.mht.getContext());
        kVar.setTitleText(this.mht.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.5
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.lUN.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 10:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 11:
                            if (a.this.lWr != null) {
                                a.this.lWr.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.mht.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.mht.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.eXH.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(11, this.mht.getString(R.string.forbidden_person), kVar);
            gVar3.eXH.setTag(sparseArray3);
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
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.mht.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.mht.getString(R.string.mute), kVar);
            }
            gVar.eXH.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.bB(arrayList);
        if (this.lUN == null) {
            this.lUN = new com.baidu.tbadk.core.dialog.i(this.mht.getPageContext(), kVar);
        } else {
            this.lUN.a(kVar);
        }
        this.lUN.SY();
    }

    public void doS() {
        if (this.lML == null) {
            this.lML = new com.baidu.tbadk.core.dialog.b(this.mht.getPageContext().getPageActivity());
            this.lML.a(new String[]{this.mht.getPageContext().getString(R.string.call_phone), this.mht.getPageContext().getString(R.string.sms_phone), this.mht.getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0578b() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0578b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.mht.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.lIU = a.this.lIU.trim();
                        UtilHelper.callPhone(a.this.mht.getPageContext().getPageActivity(), a.this.lIU);
                        new com.baidu.tieba.pb.pb.main.b(a.this.mht.dnV().dpW(), a.this.lIU, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.mht.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.lIU = a.this.lIU.trim();
                        UtilHelper.smsPhone(a.this.mht.getPageContext().getPageActivity(), a.this.lIU);
                        new com.baidu.tieba.pb.pb.main.b(a.this.mht.dnV().dpW(), a.this.lIU, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.lIU = a.this.lIU.trim();
                        UtilHelper.startBaiDuBar(a.this.mht.getPageContext().getPageActivity(), a.this.lIU);
                        bVar.dismiss();
                    }
                }
            }).pg(b.a.BOTTOM_TO_TOP).ph(17).d(this.mht.getPageContext());
        }
    }

    public void dU(final View view) {
        String[] strArr;
        int i = 0;
        if (this.mht != null && this.mht.dnV() != null) {
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mht.getPageContext());
            if (this.mht.dnV().getPbData().lFR == null || this.mht.dnV().getPbData().lFR.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.mht.dnV().getPbData().lFR.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mht.dnV().getPbData().lFR.size()) {
                        break;
                    }
                    strArr2[i2] = this.mht.dnV().getPbData().lFR.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.mht.dnV().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.mht.dnV().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.mht.dnV().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.mht.dnV().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new aq("c12097").an("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).an("obj_type", i4));
                    if (a.this.mht.dnV().getPbData().lFR != null && a.this.mht.dnV().getPbData().lFR.size() > i3) {
                        i3 = a.this.mht.dnV().getPbData().lFR.get(i3).sort_type.intValue();
                    }
                    boolean Hh = a.this.mht.dnV().Hh(i3);
                    view.setTag(Integer.valueOf(a.this.mht.dnV().dqq()));
                    if (Hh) {
                        a.this.mht.setIsLoading(true);
                    }
                }
            });
            iVar.SY();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mht.getActivity());
            aVar.Bo(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.Bp(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.jH(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new aq("c12528").dX("obj_id", metaData.getUserId()).an("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new aq("c12528").dX("obj_id", metaData.getUserId()).an("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.mht.dvJ() != null) {
                        a.this.mht.dvJ().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.mht.getPageContext().getUniqueId(), a.this.mht.dnV().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.mht.getPageContext()).btX();
            TiebaStatic.log(new aq("c12527"));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.lNF);
        userMuteAddAndDelCustomMessage.setTag(this.lNF);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void DX(String str) {
        if (str == null) {
            str = "";
        }
        if (this.mht != null && this.mht.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mht.getPageContext().getPageActivity());
            aVar.Bp(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mht.getPageContext()).btX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mht.getBaseFragmentActivity());
        if (com.baidu.tbadk.core.util.at.isEmpty(str)) {
            aVar.Bp(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Bp(str);
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
        aVar.b(this.mht.getPageContext()).btX();
    }

    public void showLoadingDialog() {
        if (this.iCD == null) {
            this.iCD = new com.baidu.tbadk.core.view.a(this.mht.getPageContext());
        }
        this.iCD.setDialogVisiable(true);
    }

    public void cni() {
        if (this.iCD != null) {
            this.iCD.setDialogVisiable(false);
        }
    }

    public void i(SparseArray<Object> sparseArray) {
        PostData postData;
        boolean z;
        String str;
        com.baidu.tbadk.core.dialog.g gVar;
        if (this.mht != null && this.mht.dnV() != null && sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            if (this.lNq == null) {
                this.lNq = new k(this.mht.getContext());
                this.lNq.a(this.lOi);
            }
            ArrayList arrayList = new ArrayList();
            boolean z2 = this.mht.dnV().getPbData() != null && this.mht.dnV().getPbData().dnh();
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
                if (postData.btk() != null) {
                    com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(8, (postData.btk().hasAgree && postData.bsU() == 5) ? this.mht.getString(R.string.action_cancel_dislike) : this.mht.getString(R.string.action_dislike), this.lNq);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    gVar2.eXH.setTag(sparseArray2);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z4 && z3) {
                        com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, this.mht.getString(R.string.mute_option), this.lNq);
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
                        gVar3.eXH.setTag(sparseArray3);
                        arrayList.add(gVar3);
                    } else {
                        if ((uP(z) && TbadkCoreApplication.isLogin()) && !z2) {
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, this.mht.getString(R.string.report_text), this.lNq);
                            gVar4.eXH.setTag(str);
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
                            gVar5 = new com.baidu.tbadk.core.dialog.g(6, this.mht.getString(R.string.delete), this.lNq);
                            gVar5.eXH.setTag(sparseArray4);
                        } else {
                            sparseArray4.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new com.baidu.tbadk.core.dialog.g(7, this.mht.getString(R.string.bar_manager), this.lNq);
                        gVar.eXH.setTag(sparseArray4);
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
                            if (this.mht.dnV().getPbData().dmT() == 1002 && !z) {
                                gVar5 = new com.baidu.tbadk.core.dialog.g(6, this.mht.getString(R.string.report_text), this.lNq);
                            } else {
                                gVar5 = new com.baidu.tbadk.core.dialog.g(6, this.mht.getString(R.string.delete), this.lNq);
                            }
                            gVar5.eXH.setTag(sparseArray5);
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
                this.lNq.bB(arrayList);
                this.lNp = new com.baidu.tbadk.core.dialog.i(this.mht.getPageContext(), this.lNq);
                this.lNp.SY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.fgY == null) {
                this.fgY = new com.baidu.tbadk.core.message.a();
            }
            if (this.fgI == null) {
                this.fgI = new e();
                this.fgI.uniqueId = this.mht.getUniqueId();
            }
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eOz = 5;
            dVar.eOF = 8;
            dVar.eOE = 2;
            if (this.mht != null && this.mht.dnV() != null) {
                dVar.eOD = this.mht.dnV().dqH();
            }
            if (dVar != null) {
                dVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (dVar != null) {
                        dVar.eOG = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (dVar != null) {
                        dVar.eOG = 1;
                        i = 0;
                    }
                }
                this.fgY.a(agreeData, i, this.mht.getUniqueId(), false);
                this.fgY.a(agreeData, this.fgI);
                if (this.mht == null && this.mht.dnV() != null && this.mht.dnV().getPbData() != null) {
                    this.fgY.a(this.mht.dpD(), dVar, agreeData, this.mht.dnV().getPbData().dmE());
                    return;
                }
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (dVar != null) {
                dVar.eOG = 1;
            }
            i = 0;
            this.fgY.a(agreeData, i, this.mht.getUniqueId(), false);
            this.fgY.a(agreeData, this.fgI);
            if (this.mht == null) {
            }
        }
    }

    public void a(final b.InterfaceC0578b interfaceC0578b, boolean z) {
        if (this.lUW != null) {
            this.lUW.dismiss();
            this.lUW = null;
        }
        k kVar = new k(this.mht.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.mht.dnV().getPbData() != null && this.mht.dnV().getPbData().dmE() != null && !this.mht.dnV().getPbData().dmE().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.mht.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.mht.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.bB(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.lUW.dismiss();
                interfaceC0578b.a(null, i, view);
            }
        });
        this.lUW = new com.baidu.tbadk.core.dialog.i(this.mht.getPageContext(), kVar);
        this.lUW.SY();
    }

    public void bf(ArrayList<ak> arrayList) {
        if (this.lUR == null) {
            this.lUR = LayoutInflater.from(this.mht.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.mht.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lUR);
        if (this.lUQ == null) {
            this.lUQ = new Dialog(this.mht.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lUQ.setCanceledOnTouchOutside(true);
            this.lUQ.setCancelable(true);
            this.lUZ = (ScrollView) this.lUR.findViewById(R.id.good_scroll);
            this.lUQ.setContentView(this.lUR);
            WindowManager.LayoutParams attributes = this.lUQ.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.lUQ.getWindow().setAttributes(attributes);
            this.iyr = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.lUV = (String) compoundButton.getTag();
                        if (a.this.iyq != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.iyq) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.lUV != null && !str.equals(a.this.lUV)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.lUS = (LinearLayout) this.lUR.findViewById(R.id.good_class_group);
            this.lUU = (TextView) this.lUR.findViewById(R.id.dialog_button_cancel);
            this.lUU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lUQ instanceof Dialog) {
                        g.b(a.this.lUQ, a.this.mht.getPageContext());
                    }
                }
            });
            this.lUT = (TextView) this.lUR.findViewById(R.id.dialog_button_ok);
            this.lUT.setOnClickListener(this.mht.dvz());
        }
        this.lUS.removeAllViews();
        this.iyq = new ArrayList();
        CustomBlueCheckRadioButton fV = fV("0", this.mht.getPageContext().getString(R.string.thread_good_class));
        this.iyq.add(fV);
        fV.setChecked(true);
        this.lUS.addView(fV);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                ak akVar = arrayList.get(i2);
                if (akVar != null && !TextUtils.isEmpty(akVar.bpC()) && akVar.bpD() > 0) {
                    CustomBlueCheckRadioButton fV2 = fV(String.valueOf(akVar.bpD()), akVar.bpC());
                    this.iyq.add(fV2);
                    View view = new View(this.mht.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    ao.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.lUS.addView(view);
                    this.lUS.addView(fV2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.lUZ.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.mht.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.mht.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.mht.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.lUZ.setLayoutParams(layoutParams2);
            this.lUZ.removeAllViews();
            if (this.lUS != null && this.lUS.getParent() == null) {
                this.lUZ.addView(this.lUS);
            }
        }
        g.a(this.lUQ, this.mht.getPageContext());
    }

    private CustomBlueCheckRadioButton fV(String str, String str2) {
        Activity pageActivity = this.mht.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.iyr);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public boolean dI(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void f(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.lNF;
        userMuteCheckCustomMessage.setTag(this.lNF);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void dsI() {
        if (this.lUO != null) {
            this.lUO.dismiss();
        }
        if (this.lUP != null) {
            g.b(this.lUP, this.mht.getPageContext());
        }
        if (this.lUQ != null) {
            g.b(this.lUQ, this.mht.getPageContext());
        }
        if (this.lUN != null) {
            this.lUN.dismiss();
        }
    }

    public void dwq() {
        if (this.lNp != null) {
            this.lNp.dismiss();
        }
    }

    public void dsH() {
        bes();
        this.mht.drK();
        if (this.lNp != null) {
            this.lNp.dismiss();
        }
        dsI();
    }

    public void dsG() {
        bes();
        this.mht.drK();
        if (this.lNp != null) {
            this.lNp.dismiss();
        }
        this.mht.cFA();
        dsI();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener dvB() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b dwr() {
        return this.lML;
    }

    public void setPhoneNumber(String str) {
        this.lIU = str;
    }

    public String dsm() {
        return this.lUV;
    }

    public View dsl() {
        if (this.lUR != null) {
            return this.lUR.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
