package com.baidu.tieba.pb.videopb.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
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
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
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
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.aj;
import com.baidu.tieba.pb.pb.main.ak;
import com.baidu.tieba.pb.pb.main.bd;
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
/* loaded from: classes22.dex */
public class a {
    public static int lQp = 3;
    public static int lQq = 0;
    public static int lQr = 3;
    public static int lQs = 4;
    public static int lQt = 5;
    public static int lQu = 6;
    private bd eBS;
    private e eXh;
    private com.baidu.tbadk.core.message.a eXx;
    private List<CustomBlueCheckRadioButton> ilT;
    private f jBZ;
    private String lDM;
    private com.baidu.tieba.pb.pb.report.a lHR;
    private i lHY;
    private k lHZ;
    private boolean lHo;
    public BdUniqueId lIo;
    private com.baidu.adp.widget.ImageView.a lIq;
    private String lIr;
    private TbRichTextMemeInfo lIs;
    private com.baidu.tieba.NEGFeedBack.i lQO;
    private PbFragment.b lRc;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    public VideoPbFragment mcf;
    private Runnable runnable;
    private i lPH = null;
    private com.baidu.tbadk.core.dialog.a lPz = null;
    private Dialog lPA = null;
    private Dialog lPB = null;
    private View lPC = null;
    private LinearLayout lPD = null;
    private TextView lPE = null;
    private TextView lPF = null;
    private String lPG = null;
    private ScrollView lPK = null;
    private CompoundButton.OnCheckedChangeListener ilU = null;
    private i lPy = null;
    private com.baidu.tbadk.core.view.a iqh = null;
    private com.baidu.tbadk.core.dialog.b lHu = null;
    private AlertDialog lVD = null;
    private aj lVE = null;
    PostData jZd = null;
    private boolean lHP = d.bkr();
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.12
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return a.this.dJ(view);
        }
    };
    private k.c lIR = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (a.this.lHY != null) {
                a.this.lHY.dismiss();
            }
            a.this.Hc(i);
            switch (i) {
                case -4:
                    View view2 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_share);
                    a.this.dv(view2);
                    view2.performClick();
                    return;
                case -3:
                    View view3 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_reply);
                    a.this.dv(view3);
                    view3.performClick();
                    return;
                case -2:
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    if (d.bkD() || d.bkE()) {
                        View view4 = (View) sparseArray2.get(R.id.pb_dialog_item_zan_2);
                        a.this.dv(view4);
                        ((AgreeView) view4).getImgDisagree().performClick();
                        return;
                    }
                    View view5 = (View) sparseArray2.get(R.id.pb_dialog_item_zan_1);
                    a.this.dv(view5);
                    ((AgreeView) view5).getImgDisagree().performClick();
                    return;
                case -1:
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (d.bkD() || d.bkE()) {
                        View view6 = (View) sparseArray3.get(R.id.pb_dialog_item_zan_2);
                        a.this.dv(view6);
                        ((AgreeView) view6).getImgAgree().performClick();
                        return;
                    }
                    View view7 = (View) sparseArray3.get(R.id.pb_dialog_item_zan_1);
                    a.this.dv(view7);
                    ((AgreeView) view7).getImgAgree().performClick();
                    return;
                case 0:
                default:
                    return;
                case 1:
                    if (a.this.lIq != null && !TextUtils.isEmpty(a.this.lIr)) {
                        if (a.this.lIs == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.lIr));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.lIr;
                            aVar.pkgId = a.this.lIs.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.lIs.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.lIq = null;
                        a.this.lIr = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.lIq != null && !TextUtils.isEmpty(a.this.lIr)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.mcf.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.mcf.getPageContext().getPageActivity())) {
                            if (a.this.eBS == null) {
                                a.this.eBS = new bd(a.this.mcf.getPageContext());
                            }
                            a.this.eBS.j(a.this.lIr, a.this.lIq.getImageByte());
                            a.this.lIq = null;
                            a.this.lIr = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.jZd != null) {
                        a.this.jZd.gD(a.this.mcf.getPageContext().getPageActivity());
                        a.this.jZd = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new ar("c11739").al("obj_locate", 2));
                    if (a.this.mcf.checkUpIsLogin()) {
                        a.this.dw(view);
                        if (a.this.mcf.dok().getPbData().dmT() != null && a.this.mcf.dok().getPbData().dmT().boP() != null && a.this.mcf.dok().getPbData().dmT().boP().getUserId() != null && a.this.mcf.dvI() != null) {
                            int h = a.this.h(a.this.mcf.dok().getPbData());
                            by dmT = a.this.mcf.dok().getPbData().dmT();
                            if (dmT.bnx()) {
                                i2 = 2;
                            } else if (dmT.bny()) {
                                i2 = 3;
                            } else if (dmT.bqM()) {
                                i2 = 4;
                            } else {
                                i2 = dmT.bqN() ? 5 : 1;
                            }
                            TiebaStatic.log(new ar("c12526").dY("tid", a.this.mcf.dok().dqj()).al("obj_locate", 2).dY("obj_id", a.this.mcf.dok().getPbData().dmT().boP().getUserId()).al("obj_type", a.this.mcf.dvI().bkY() ? 0 : 1).al("obj_source", h).al("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.mcf.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new ar("c13079"));
                        a.this.Qe((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new ar("c11739").al("obj_locate", 4));
                        SparseArray<Object> sparseArray4 = (SparseArray) tag;
                        if ((sparseArray4.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray4.put(R.id.tag_from, 0);
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            a.this.c(sparseArray4);
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
                        a.this.mcf.showToast(R.string.network_not_available);
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
                                a.this.c(sparseArray6);
                                return;
                            }
                            sparseArray6.put(R.id.tag_check_mute_from, 2);
                            a.this.dD(view);
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
                    if (bh.checkUpIsLogin(a.this.mcf.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.bqI() != null) {
                            c bM = com.baidu.tbadk.pageExtra.d.bM(view);
                            if (bM != null) {
                                postData.bqI().objSource = bM.getCurrentPageKey();
                            }
                            a.this.d(postData.bqI());
                            return;
                        }
                        return;
                    }
                    return;
            }
        }
    };
    private final b.InterfaceC0586b lJf = new b.InterfaceC0586b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0586b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.lIq != null && !TextUtils.isEmpty(a.this.lIr)) {
                if (i == 0) {
                    if (a.this.lIs == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.lIr));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.lIr;
                        aVar.pkgId = a.this.lIs.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.lIs.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.mcf.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.mcf.getPageContext().getPageActivity())) {
                        if (a.this.eBS == null) {
                            a.this.eBS = new bd(a.this.mcf.getPageContext());
                        }
                        a.this.eBS.j(a.this.lIr, a.this.lIq.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.lIq = null;
                a.this.lIr = null;
            }
        }
    };

    public void dpm() {
        com.baidu.tieba.pb.data.f pbData;
        by dmT;
        boolean z = true;
        if (this.mcf != null && this.mcf.dok() != null && this.mcf.dok().getPbData() != null && (dmT = (pbData = this.mcf.dok().getPbData()).dmT()) != null && dmT.boP() != null) {
            this.mcf.drX();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dmT.boP().getUserId());
            ak akVar = new ak();
            int dni = this.mcf.dok().getPbData().dni();
            if (dni == 1 || dni == 3) {
                akVar.lNq = true;
                akVar.lNp = true;
                akVar.lNv = dmT.boK() == 1;
                akVar.lNu = dmT.boL() == 1;
            } else {
                akVar.lNq = false;
                akVar.lNp = false;
            }
            if (dni == 1002 && !equals) {
                akVar.lNw = true;
            }
            akVar.lNn = uP(equals);
            akVar.lNr = dpn();
            akVar.lNo = uQ(equals);
            akVar.FT = this.mcf.dok().dql();
            akVar.lNk = true;
            akVar.lNj = uO(equals);
            akVar.lNt = TbadkCoreApplication.getInst().getSkinType() == 1;
            akVar.lNs = true;
            akVar.isHostOnly = this.mcf.dok().getHostMode();
            akVar.lNm = true;
            if (dmT.bph() == null) {
                akVar.lNl = true;
            } else {
                akVar.lNl = false;
            }
            if (pbData.dnx()) {
                akVar.lNk = false;
                akVar.lNm = false;
                akVar.lNl = false;
                akVar.lNp = false;
                akVar.lNq = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.dnx()) {
                z = false;
            }
            akVar.lNx = z;
            a(akVar);
        }
    }

    private boolean uP(boolean z) {
        boolean z2;
        ac acVar;
        if (this.mcf == null || this.mcf.dok() == null || this.mcf.dok().getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.f pbData = this.mcf.dok().getPbData();
        if (pbData.getUserData() == null || !pbData.getUserData().isForumBusinessAccount() || ax.isOn()) {
            by dmT = pbData.dmT();
            if (dmT != null) {
                if (dmT.bnx() || dmT.bny()) {
                    return false;
                }
                if (dmT.bqM() || dmT.bqN()) {
                    return z;
                }
            }
            if (z) {
                return true;
            }
            if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
                if (pbData.dni() != 0) {
                    return pbData.dni() != 3;
                }
                List<bu> dnq = pbData.dnq();
                if (y.getCount(dnq) > 0) {
                    for (bu buVar : dnq) {
                        if (buVar != null && (acVar = buVar.eIt) != null && acVar.eGf && !acVar.eGg && (acVar.type == 1 || acVar.type == 2)) {
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

    private boolean uQ(boolean z) {
        if (z || this.mcf == null || this.mcf.dok() == null || this.mcf.dok().getPbData() == null) {
            return false;
        }
        return ((this.mcf.dok().getPbData().getForum() != null && this.mcf.dok().getPbData().getForum().isBlockBawuDelete) || this.mcf.dok().getPbData().dni() == 0 || this.mcf.dok().getPbData().dni() == 3) ? false : true;
    }

    private boolean dpn() {
        if (this.mcf == null || this.mcf.dok() == null || !this.mcf.dok().dql()) {
            return false;
        }
        return this.mcf.dok().getPageData() == null || this.mcf.dok().getPageData().bnG() != 0;
    }

    public void a(ak akVar) {
        if (!this.mcf.getBaseFragmentActivity().isProgressBarShown()) {
            this.lVE = new aj(this.mcf, this.mcf.aGQ);
            this.lVD = new AlertDialog.Builder(this.mcf.getContext(), R.style.DialogTheme).create();
            this.lVD.setCanceledOnTouchOutside(true);
            g.showDialog(this.lVD, this.mcf.getFragmentActivity());
            Window window = this.lVD.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.lVE.getView());
            this.lVE.ve(akVar == null ? false : akVar.lNj);
            this.lVE.vf(akVar == null ? false : akVar.lNn);
            this.lVE.vg(akVar == null ? false : akVar.lNr);
            this.lVE.vi(akVar == null ? false : akVar.lNo);
            this.lVE.vj(akVar == null ? true : akVar.lNl);
            if (akVar == null) {
                this.lVE.ao(false, false);
                this.lVE.ap(false, false);
            } else {
                this.lVE.ao(akVar.lNp, akVar.lNv);
                this.lVE.ap(akVar.lNq, akVar.lNu);
            }
            boolean z = akVar == null ? false : akVar.FT;
            boolean z2 = akVar == null ? false : akVar.isHostOnly;
            boolean z3 = akVar == null ? false : akVar.lNm;
            boolean z4 = akVar == null ? false : akVar.lNk;
            boolean z5 = akVar == null ? false : akVar.lNt;
            boolean z6 = akVar == null ? false : akVar.lNs;
            this.lVE.an(z3, z2);
            this.lVE.aq(z4, z);
            this.lVE.ar(z6, z5);
            if (akVar != null) {
                this.lVE.lNg = akVar.lNw;
                if (akVar.lNw) {
                    this.lVE.dry().setText(R.string.report_text);
                    this.lVE.vi(false);
                }
            }
            this.lVE.vh(akVar != null ? akVar.lNx : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.mcf.dok() != null && this.mcf.dok().getPbData() != null && this.mcf.dok().getPbData().getThreadId() != null && this.mcf.dok().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.lVE.drB().setText(R.string.have_called_fans_short);
            }
            dtW();
        }
    }

    private void dtW() {
        if (this.lVE != null) {
            this.lVE.drF();
        }
    }

    public void bca() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.lVD != null) {
                        g.dismissDialog(a.this.lVD, a.this.mcf.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.mY().postDelayed(this.runnable, 100L);
    }

    public void dtX() {
        if (this.lVD != null) {
            g.dismissDialog(this.lVD, this.mcf.getPageContext().getPageActivity());
        }
    }

    public aj dtY() {
        return this.lVE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0091 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dJ(View view) {
        boolean z;
        boolean z2;
        List<com.baidu.tbadk.core.dialog.g> list;
        com.baidu.tbadk.core.dialog.g gVar;
        SparseArray sparseArray;
        if (this.mcf == null || !this.mcf.isAdded()) {
            return true;
        }
        SparseArray sparseArray2 = null;
        try {
            sparseArray2 = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        if (sparseArray2 == null) {
            if (dy(view)) {
                if (view instanceof TbImageView) {
                    this.lIq = ((TbImageView) view).getBdImage();
                    this.lIr = ((TbImageView) view).getUrl();
                    if (this.lIq == null || TextUtils.isEmpty(this.lIr)) {
                        return true;
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lIs = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lIs = null;
                    }
                } else if (view instanceof GifView) {
                    if (((GifView) view).getBdImage() != null) {
                        this.lIq = ((GifView) view).getBdImage();
                        if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                            this.lIr = ((GifView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.lIs = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.lIs = null;
                        }
                    } else {
                        return true;
                    }
                } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                    this.lIq = ((TbMemeImageView) view).getBdImage();
                    if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                        this.lIr = ((TbMemeImageView) view).getBdImage().getUrl();
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.lIs = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.lIs = null;
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
                    a(this.lJf, this.lIq.isGif());
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
        this.jZd = (PostData) sparseArray2.get(R.id.tag_clip_board);
        if (this.jZd == null || this.mcf.dvI() == null) {
            return true;
        }
        if (!this.mcf.dvI().bkY() || this.jZd.getId() == null || !this.jZd.getId().equals(this.mcf.dok().boX())) {
            z = false;
        } else {
            z = true;
        }
        boolean z3 = this.mcf.dok().getPbData() != null && this.mcf.dok().getPbData().dnx();
        if (this.lHZ == null) {
            this.lHZ = new k(this.mcf.getContext());
            this.lHZ.a(this.lIR);
        }
        ArrayList arrayList = new ArrayList();
        if (view != null && sparseArray2 != null) {
            boolean z4 = dy(view) && !z3;
            boolean z5 = (!dy(view) || this.lIq == null || this.lIq.isGif()) ? false : true;
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
                arrayList.add(new com.baidu.tbadk.core.dialog.g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), this.lHZ));
            }
            if (z5) {
                arrayList.add(new com.baidu.tbadk.core.dialog.g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), this.lHZ));
            }
            if (!z4 && !z5) {
                com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(3, TbadkCoreApplication.getInst().getString(R.string.copy), this.lHZ);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_clip_board, this.jZd);
                gVar2.eNK.setTag(sparseArray3);
                arrayList.add(gVar2);
            }
            if (!z2 && !z3) {
                if (z) {
                    gVar = new com.baidu.tbadk.core.dialog.g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), this.lHZ);
                } else {
                    gVar = new com.baidu.tbadk.core.dialog.g(4, TbadkCoreApplication.getInst().getString(R.string.mark), this.lHZ);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_clip_board, this.jZd);
                sparseArray4.put(R.id.tag_is_subpb, false);
                gVar.eNK.setTag(sparseArray4);
                arrayList.add(gVar);
            }
            if (TbadkCoreApplication.isLogin() && !this.lHP) {
                if (!z8 && z7) {
                    com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), this.lHZ);
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
                    gVar3.eNK.setTag(sparseArray5);
                    arrayList.add(gVar3);
                } else {
                    if ((uO(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                        com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), this.lHZ);
                        gVar4.eNK.setTag(str);
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
                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.lHZ);
                        gVar6.eNK.setTag(sparseArray6);
                    } else {
                        sparseArray6.put(R.id.tag_should_delete_visible, false);
                    }
                    gVar5 = new com.baidu.tbadk.core.dialog.g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), this.lHZ);
                    gVar5.eNK.setTag(sparseArray6);
                } else if (z10) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.tag_should_manage_visible, false);
                    sparseArray7.put(R.id.tag_user_mute_visible, false);
                    sparseArray7.put(R.id.tag_should_delete_visible, true);
                    sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                    sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                    sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                    sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                    if (this.mcf.dok().getPbData().dni() == 1002 && !z6) {
                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), this.lHZ);
                    } else {
                        gVar6 = new com.baidu.tbadk.core.dialog.g(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.lHZ);
                    }
                    gVar6.eNK.setTag(sparseArray7);
                }
                if (gVar6 != null) {
                    arrayList.add(gVar6);
                }
                if (gVar5 != null) {
                    arrayList.add(gVar5);
                }
            }
            if (com.baidu.tbadk.a.d.bkG()) {
                list = com.baidu.tieba.pb.pb.main.d.a.fs(com.baidu.tieba.pb.pb.main.d.a.v(com.baidu.tieba.pb.pb.main.d.a.a(arrayList, this.jZd.bqI(), sparseArray2, this.lHZ), this.lHo));
                this.lHZ.a(com.baidu.tieba.pb.pb.main.d.a.t(this.jZd));
            } else {
                list = arrayList;
            }
            this.lHZ.k(list, true);
            this.lHY = new i(this.mcf.getPageContext(), this.lHZ);
            this.lHY.RU();
            TiebaStatic.log(new ar("c13272").dY("tid", this.mcf.dok().dqj()).dY("fid", this.mcf.dok().getForumId()).dY("uid", this.mcf.dok().getPbData().dmT().boP().getUserId()).dY("post_id", this.mcf.dok().bCP()).al("obj_source", z2 ? 2 : 1));
        }
        return true;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.mcf = videoPbFragment;
        this.lIo = videoPbFragment.getUniqueId();
        this.lHR = new com.baidu.tieba.pb.pb.report.a(this.mcf.getContext());
        this.lHR.w(this.mcf.getUniqueId());
        this.lRc = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.17
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.mcf.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.mcf.dok().getPbData().getUserData().getUserId());
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
                a.this.mcf.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.mcf.getPageContext().getPageActivity(), a.this.mcf.dok().getPbData().getForum().getId(), a.this.mcf.dok().getPbData().getForum().getName(), a.this.mcf.dok().getPbData().dmT().getId(), valueOf, str, str3, str2, str4)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hc(int i) {
        TiebaStatic.log(new ar("c14000").dY("tid", this.mcf.dok().dqj()).w("uid", TbadkCoreApplication.getCurrentAccountId()).dY("obj_type", String.valueOf(com.baidu.tieba.pb.pb.main.d.a.HE(i))));
    }

    public void wg(boolean z) {
        this.lHo = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dv(View view) {
        if (view != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.lHo ? 2 : 3));
            view.setTag(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dw(View view) {
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
            if (postData.getId() != null && postData.getId().equals(this.mcf.dok().boX())) {
                z = true;
            }
            MarkData o = this.mcf.dok().o(postData);
            if (this.mcf.dok().getPbData() != null && this.mcf.dok().getPbData().dnx() && (L = this.mcf.L(this.mcf.dok().getPbData())) != null) {
                o = this.mcf.dok().o(L);
            }
            if (o != null) {
                this.mcf.dsy();
                if (this.mcf.dvI() != null) {
                    this.mcf.dvI().a(o);
                    if (!z) {
                        this.mcf.dvI().bla();
                    } else {
                        this.mcf.dvI().bkZ();
                    }
                }
            }
        }
    }

    public int h(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dmT() != null) {
            if (fVar.dmT().getThreadType() == 0) {
                return 1;
            }
            if (fVar.dmT().getThreadType() == 54) {
                return 2;
            }
            if (fVar.dmT().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    private boolean uO(boolean z) {
        if (this.mcf.dok() == null || this.mcf.dok().getPbData() == null) {
            return false;
        }
        return ((this.mcf.dok().getPbData().dni() != 0) || this.mcf.dok().getPbData().dmT() == null || this.mcf.dok().getPbData().dmT().boP() == null || TextUtils.equals(this.mcf.dok().getPbData().dmT().boP().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void Qe(String str) {
        if (this.mcf.dok() != null && this.mcf.dok().getPbData() != null && this.mcf.dok().getPbData().dnx()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.mcf.dok().dqj(), str);
            by dmT = this.mcf.dok().getPbData().dmT();
            if (dmT.bnx()) {
                format = format + "&channelid=33833";
            } else if (dmT.bqL()) {
                format = format + "&channelid=33842";
            } else if (dmT.bny()) {
                format = format + "&channelid=33840";
            }
            Qf(format);
            return;
        }
        this.lHR.QF(str);
    }

    private void Qf(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.mcf.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.lHY != null && this.lHY.isShowing()) {
                this.lHY.dismiss();
                this.lHY = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.mcf.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.19
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.lHY != null) {
                            a.this.lHY.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.lIo);
                            userMuteAddAndDelCustomMessage.setTag(a.this.lIo);
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
                kVar.bu(arrayList);
                this.lHY = new i(this.mcf.getPageContext(), kVar);
                this.lHY.RU();
            }
        }
    }

    public void dpI() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mcf.getPageContext().getPageActivity());
        aVar.Bq(this.mcf.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.20
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.mcf.getFragmentActivity(), 2, true, 4);
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
        aVar.b(this.mcf.getPageContext()).brv();
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
        sparseArray.put(lQq, Integer.valueOf(lQr));
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
        this.lPz = new com.baidu.tbadk.core.dialog.a(this.mcf.getActivity());
        if (StringUtils.isNull(str2)) {
            this.lPz.oQ(i3);
        } else {
            this.lPz.setOnlyMessageShowCenter(false);
            this.lPz.Bq(str2);
        }
        this.lPz.setYesButtonTag(sparseArray);
        this.lPz.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.23
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.mcf.a(aVar, (JSONArray) null);
            }
        });
        this.lPz.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lPz.jl(true);
        this.lPz.b(this.mcf.getPageContext());
        if (z) {
            this.lPz.brv();
        } else if (dsu()) {
            h hVar = new h(this.mcf.dok().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.mcf.dok().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue(), this.mcf.dok().getPbData().dnD().has_forum_rule.intValue());
            hVar.ek(this.mcf.dok().getPbData().getForum().getId(), this.mcf.dok().getPbData().getForum().getName());
            hVar.setForumHeadUrl(this.mcf.dok().getPbData().getForum().getImage_url());
            hVar.setUserLevel(this.mcf.dok().getPbData().getForum().getUser_level());
            a(this.lPz, i, hVar, this.mcf.dok().getPbData().getUserData());
        } else {
            a(this.lPz, i);
        }
    }

    private boolean dsu() {
        if (this.mcf == null || this.mcf.dok().getPbData().getForum().getDeletedReasonInfo() == null) {
            return false;
        }
        return 1 == this.mcf.dok().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue();
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.mcf != null && aVar != null) {
            if (this.jBZ == null && this.mcf.getView() != null) {
                this.jBZ = new f(this.mcf.getPageContext(), this.mcf.getView());
            }
            AntiData cBe = cBe();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cBe != null && cBe.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBe.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            at atVar = new at();
            atVar.setFeedBackReasonMap(sparseArray);
            this.jBZ.setDefaultReasonArray(new String[]{this.mcf.getString(R.string.delete_thread_reason_1), this.mcf.getString(R.string.delete_thread_reason_2), this.mcf.getString(R.string.delete_thread_reason_3), this.mcf.getString(R.string.delete_thread_reason_4), this.mcf.getString(R.string.delete_thread_reason_5)});
            this.jBZ.setData(atVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.jBZ.Fj(str);
            this.jBZ.a(new f.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void X(JSONArray jSONArray) {
                    a.this.mcf.a(aVar, jSONArray);
                }
            });
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i, h hVar, UserData userData) {
        String str;
        if (this.mcf != null && aVar != null) {
            if (this.lQO == null && this.mcf.getView() != null) {
                this.lQO = new com.baidu.tieba.NEGFeedBack.i(this.mcf.getPageContext(), this.mcf.getView(), hVar, userData);
            }
            AntiData cBe = cBe();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cBe != null && cBe.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cBe.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            at atVar = new at();
            atVar.setFeedBackReasonMap(sparseArray);
            this.lQO.setDefaultReasonArray(new String[]{this.mcf.getString(R.string.delete_thread_reason_1), this.mcf.getString(R.string.delete_thread_reason_2), this.mcf.getString(R.string.delete_thread_reason_3), this.mcf.getString(R.string.delete_thread_reason_4), this.mcf.getString(R.string.delete_thread_reason_5)});
            this.lQO.setData(atVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.lQO.Fj(str);
            this.lQO.a(new i.b() { // from class: com.baidu.tieba.pb.videopb.b.a.4
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void X(JSONArray jSONArray) {
                    a.this.mcf.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData cBe() {
        if (this.mcf.dok() == null || this.mcf.dok().getPbData() == null) {
            return null;
        }
        return this.mcf.dok().getPbData().getAnti();
    }

    public void dD(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        com.baidu.tbadk.core.dialog.g gVar;
        com.baidu.tbadk.core.dialog.g gVar2;
        k kVar = new k(this.mcf.getContext());
        kVar.setTitleText(this.mcf.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.5
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.lPy.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 10:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 11:
                            if (a.this.lRc != null) {
                                a.this.lRc.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
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
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.mcf.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new com.baidu.tbadk.core.dialog.g(10, this.mcf.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.eNK.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(11, this.mcf.getString(R.string.forbidden_person), kVar);
            gVar3.eNK.setTag(sparseArray3);
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
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.mcf.getString(R.string.un_mute), kVar);
            } else {
                gVar = new com.baidu.tbadk.core.dialog.g(12, this.mcf.getString(R.string.mute), kVar);
            }
            gVar.eNK.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.bu(arrayList);
        if (this.lPy == null) {
            this.lPy = new com.baidu.tbadk.core.dialog.i(this.mcf.getPageContext(), kVar);
        } else {
            this.lPy.a(kVar);
        }
        this.lPy.RU();
    }

    public void dpf() {
        if (this.lHu == null) {
            this.lHu = new com.baidu.tbadk.core.dialog.b(this.mcf.getPageContext().getPageActivity());
            this.lHu.a(new String[]{this.mcf.getPageContext().getString(R.string.call_phone), this.mcf.getPageContext().getString(R.string.sms_phone), this.mcf.getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0586b() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0586b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.mcf.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.lDM = a.this.lDM.trim();
                        UtilHelper.callPhone(a.this.mcf.getPageContext().getPageActivity(), a.this.lDM);
                        new com.baidu.tieba.pb.pb.main.b(a.this.mcf.dok().dqj(), a.this.lDM, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.mcf.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.lDM = a.this.lDM.trim();
                        UtilHelper.smsPhone(a.this.mcf.getPageContext().getPageActivity(), a.this.lDM);
                        new com.baidu.tieba.pb.pb.main.b(a.this.mcf.dok().dqj(), a.this.lDM, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.lDM = a.this.lDM.trim();
                        UtilHelper.startBaiDuBar(a.this.mcf.getPageContext().getPageActivity(), a.this.lDM);
                        bVar.dismiss();
                    }
                }
            }).oW(b.a.BOTTOM_TO_TOP).oX(17).d(this.mcf.getPageContext());
        }
    }

    public void dK(final View view) {
        String[] strArr;
        int i = 0;
        if (this.mcf != null && this.mcf.dok() != null) {
            final com.baidu.tbadk.core.dialog.i iVar = new com.baidu.tbadk.core.dialog.i(this.mcf.getPageContext());
            if (this.mcf.dok().getPbData().lAJ == null || this.mcf.dok().getPbData().lAJ.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.mcf.dok().getPbData().lAJ.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.mcf.dok().getPbData().lAJ.size()) {
                        break;
                    }
                    strArr2[i2] = this.mcf.dok().getPbData().lAJ.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.mcf.dok().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.mcf.dok().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.mcf.dok().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.mcf.dok().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new ar("c12097").al("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).al("obj_type", i4));
                    if (a.this.mcf.dok().getPbData().lAJ != null && a.this.mcf.dok().getPbData().lAJ.size() > i3) {
                        i3 = a.this.mcf.dok().getPbData().lAJ.get(i3).sort_type.intValue();
                    }
                    boolean Ho = a.this.mcf.dok().Ho(i3);
                    view.setTag(Integer.valueOf(a.this.mcf.dok().dqD()));
                    if (Ho) {
                        a.this.mcf.setIsLoading(true);
                    }
                }
            });
            iVar.RU();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mcf.getActivity());
            aVar.Bp(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.Bq(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.jl(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new ar("c12528").dY("obj_id", metaData.getUserId()).al("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new ar("c12528").dY("obj_id", metaData.getUserId()).al("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.mcf.dvT() != null) {
                        a.this.mcf.dvT().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.mcf.getPageContext().getUniqueId(), a.this.mcf.dok().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.mcf.getPageContext()).brv();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.lIo);
        userMuteAddAndDelCustomMessage.setTag(this.lIo);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void Ea(String str) {
        if (str == null) {
            str = "";
        }
        if (this.mcf != null && this.mcf.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mcf.getPageContext().getPageActivity());
            aVar.Bq(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.10
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.mcf.getPageContext()).brv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mcf.getBaseFragmentActivity());
        if (au.isEmpty(str)) {
            aVar.Bq(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Bq(str);
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
        aVar.b(this.mcf.getPageContext()).brv();
    }

    public void showLoadingDialog() {
        if (this.iqh == null) {
            this.iqh = new com.baidu.tbadk.core.view.a(this.mcf.getPageContext());
        }
        this.iqh.setDialogVisiable(true);
    }

    public void ckt() {
        if (this.iqh != null) {
            this.iqh.setDialogVisiable(false);
        }
    }

    public void f(SparseArray<Object> sparseArray) {
        PostData postData;
        boolean z;
        String str;
        com.baidu.tbadk.core.dialog.g gVar;
        if (this.mcf != null && this.mcf.dok() != null && sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            if (this.lHZ == null) {
                this.lHZ = new k(this.mcf.getContext());
                this.lHZ.a(this.lIR);
            }
            ArrayList arrayList = new ArrayList();
            boolean z2 = this.mcf.dok().getPbData() != null && this.mcf.dok().getPbData().dnx();
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
                if (postData.bqI() != null) {
                    com.baidu.tbadk.core.dialog.g gVar2 = new com.baidu.tbadk.core.dialog.g(8, (postData.bqI().hasAgree && postData.bqs() == 5) ? this.mcf.getString(R.string.action_cancel_dislike) : this.mcf.getString(R.string.action_dislike), this.lHZ);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    gVar2.eNK.setTag(sparseArray2);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z4 && z3) {
                        com.baidu.tbadk.core.dialog.g gVar3 = new com.baidu.tbadk.core.dialog.g(5, this.mcf.getString(R.string.mute_option), this.lHZ);
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
                        gVar3.eNK.setTag(sparseArray3);
                        arrayList.add(gVar3);
                    } else {
                        if ((uO(z) && TbadkCoreApplication.isLogin()) && !z2) {
                            com.baidu.tbadk.core.dialog.g gVar4 = new com.baidu.tbadk.core.dialog.g(5, this.mcf.getString(R.string.report_text), this.lHZ);
                            gVar4.eNK.setTag(str);
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
                            gVar5 = new com.baidu.tbadk.core.dialog.g(6, this.mcf.getString(R.string.delete), this.lHZ);
                            gVar5.eNK.setTag(sparseArray4);
                        } else {
                            sparseArray4.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new com.baidu.tbadk.core.dialog.g(7, this.mcf.getString(R.string.bar_manager), this.lHZ);
                        gVar.eNK.setTag(sparseArray4);
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
                            if (this.mcf.dok().getPbData().dni() == 1002 && !z) {
                                gVar5 = new com.baidu.tbadk.core.dialog.g(6, this.mcf.getString(R.string.report_text), this.lHZ);
                            } else {
                                gVar5 = new com.baidu.tbadk.core.dialog.g(6, this.mcf.getString(R.string.delete), this.lHZ);
                            }
                            gVar5.eNK.setTag(sparseArray5);
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
                this.lHZ.bu(arrayList);
                this.lHY = new com.baidu.tbadk.core.dialog.i(this.mcf.getPageContext(), this.lHZ);
                this.lHY.RU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eXx == null) {
                this.eXx = new com.baidu.tbadk.core.message.a();
            }
            if (this.eXh == null) {
                this.eXh = new e();
                this.eXh.uniqueId = this.mcf.getUniqueId();
            }
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.eEJ = 5;
            dVar.eEP = 8;
            dVar.eEO = 2;
            if (this.mcf != null && this.mcf.dok() != null) {
                dVar.eEN = this.mcf.dok().dqU();
            }
            if (dVar != null) {
                dVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (dVar != null) {
                        dVar.eEQ = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (dVar != null) {
                        dVar.eEQ = 1;
                        i = 0;
                    }
                }
                this.eXx.a(agreeData, i, this.mcf.getUniqueId(), false);
                this.eXx.a(agreeData, this.eXh);
                if (this.mcf == null && this.mcf.dok() != null && this.mcf.dok().getPbData() != null) {
                    this.eXx.a(this.mcf.dpQ(), dVar, agreeData, this.mcf.dok().getPbData().dmT());
                    return;
                }
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (dVar != null) {
                dVar.eEQ = 1;
            }
            i = 0;
            this.eXx.a(agreeData, i, this.mcf.getUniqueId(), false);
            this.eXx.a(agreeData, this.eXh);
            if (this.mcf == null) {
            }
        }
    }

    public void a(final b.InterfaceC0586b interfaceC0586b, boolean z) {
        if (this.lPH != null) {
            this.lPH.dismiss();
            this.lPH = null;
        }
        k kVar = new k(this.mcf.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.mcf.dok().getPbData() != null && this.mcf.dok().getPbData().dmT() != null && !this.mcf.dok().getPbData().dmT().isBjh()) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(0, this.mcf.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new com.baidu.tbadk.core.dialog.g(1, this.mcf.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.bu(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.14
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.lPH.dismiss();
                interfaceC0586b.a(null, i, view);
            }
        });
        this.lPH = new com.baidu.tbadk.core.dialog.i(this.mcf.getPageContext(), kVar);
        this.lPH.RU();
    }

    public void bf(ArrayList<com.baidu.tbadk.core.data.ak> arrayList) {
        if (this.lPC == null) {
            this.lPC = LayoutInflater.from(this.mcf.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.mcf.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lPC);
        if (this.lPB == null) {
            this.lPB = new Dialog(this.mcf.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lPB.setCanceledOnTouchOutside(true);
            this.lPB.setCancelable(true);
            this.lPK = (ScrollView) this.lPC.findViewById(R.id.good_scroll);
            this.lPB.setContentView(this.lPC);
            WindowManager.LayoutParams attributes = this.lPB.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.lPB.getWindow().setAttributes(attributes);
            this.ilU = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.lPG = (String) compoundButton.getTag();
                        if (a.this.ilT != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.ilT) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.lPG != null && !str.equals(a.this.lPG)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.lPD = (LinearLayout) this.lPC.findViewById(R.id.good_class_group);
            this.lPF = (TextView) this.lPC.findViewById(R.id.dialog_button_cancel);
            this.lPF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.16
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lPB instanceof Dialog) {
                        g.b(a.this.lPB, a.this.mcf.getPageContext());
                    }
                }
            });
            this.lPE = (TextView) this.lPC.findViewById(R.id.dialog_button_ok);
            this.lPE.setOnClickListener(this.mcf.dvJ());
        }
        this.lPD.removeAllViews();
        this.ilT = new ArrayList();
        CustomBlueCheckRadioButton fY = fY("0", this.mcf.getPageContext().getString(R.string.thread_good_class));
        this.ilT.add(fY);
        fY.setChecked(true);
        this.lPD.addView(fY);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ak akVar = arrayList.get(i2);
                if (akVar != null && !TextUtils.isEmpty(akVar.bnd()) && akVar.bne() > 0) {
                    CustomBlueCheckRadioButton fY2 = fY(String.valueOf(akVar.bne()), akVar.bnd());
                    this.ilT.add(fY2);
                    View view = new View(this.mcf.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    ap.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.lPD.addView(view);
                    this.lPD.addView(fY2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.lPK.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.mcf.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.mcf.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.mcf.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.lPK.setLayoutParams(layoutParams2);
            this.lPK.removeAllViews();
            if (this.lPD != null && this.lPD.getParent() == null) {
                this.lPK.addView(this.lPD);
            }
        }
        g.a(this.lPB, this.mcf.getPageContext());
    }

    private CustomBlueCheckRadioButton fY(String str, String str2) {
        Activity pageActivity = this.mcf.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.ilU);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public boolean dy(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.lIo;
        userMuteCheckCustomMessage.setTag(this.lIo);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void dsT() {
        if (this.lPz != null) {
            this.lPz.dismiss();
        }
        if (this.lPA != null) {
            g.b(this.lPA, this.mcf.getPageContext());
        }
        if (this.lPB != null) {
            g.b(this.lPB, this.mcf.getPageContext());
        }
        if (this.lPy != null) {
            this.lPy.dismiss();
        }
    }

    public void dwA() {
        if (this.lHY != null) {
            this.lHY.dismiss();
        }
    }

    public void dsS() {
        bca();
        this.mcf.drX();
        if (this.lHY != null) {
            this.lHY.dismiss();
        }
        dsT();
    }

    public void dsR() {
        bca();
        this.mcf.drX();
        if (this.lHY != null) {
            this.lHY.dismiss();
        }
        this.mcf.cCF();
        dsT();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener dvL() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b dwB() {
        return this.lHu;
    }

    public void setPhoneNumber(String str) {
        this.lDM = str;
    }

    public String dsx() {
        return this.lPG;
    }

    public View dsw() {
        if (this.lPC != null) {
            return this.lPC.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
