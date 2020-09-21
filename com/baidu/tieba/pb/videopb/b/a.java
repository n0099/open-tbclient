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
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.c;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
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
/* loaded from: classes21.dex */
public class a {
    private bd dWg;
    private com.baidu.tbadk.core.message.a eqK;
    private e equ;
    private List<CustomBlueCheckRadioButton> hth;
    private com.baidu.tieba.NEGFeedBack.e iGA;
    private String kId;
    private com.baidu.adp.widget.ImageView.a kMB;
    private String kMC;
    private TbRichTextMemeInfo kMD;
    private com.baidu.tieba.pb.pb.report.a kMc;
    private i kMj;
    private k kMk;
    public BdUniqueId kMz;
    private PbFragment.b kVg;
    public VideoPbFragment lga;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    private Runnable runnable;
    public static int kUx = 3;
    public static int kUy = 0;
    public static int kUz = 3;
    public static int kUA = 4;
    public static int kUB = 5;
    public static int kUC = 6;
    private i kTP = null;
    private com.baidu.tbadk.core.dialog.a kTH = null;
    private Dialog kTI = null;
    private Dialog kTJ = null;
    private View kTK = null;
    private LinearLayout kTL = null;
    private TextView kTM = null;
    private TextView kTN = null;
    private String kTO = null;
    private ScrollView kTS = null;
    private CompoundButton.OnCheckedChangeListener hti = null;
    private i kTG = null;
    private com.baidu.tbadk.core.view.a hxf = null;
    private com.baidu.tbadk.core.dialog.b kLG = null;
    private AlertDialog kZE = null;
    private aj kZF = null;
    PostData jds = null;
    private boolean kJC = d.baU();
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.12
        /* JADX WARN: Removed duplicated region for block: B:32:0x00ac A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x01f5  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            boolean z;
            boolean z2;
            g gVar;
            g gVar2;
            SparseArray sparseArray;
            if (a.this.lga == null || !a.this.lga.isAdded()) {
                return true;
            }
            SparseArray sparseArray2 = null;
            try {
                sparseArray2 = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray2 == null) {
                if (a.this.cX(view)) {
                    if (view instanceof TbImageView) {
                        a.this.kMB = ((TbImageView) view).getBdImage();
                        a.this.kMC = ((TbImageView) view).getUrl();
                        if (a.this.kMB == null || TextUtils.isEmpty(a.this.kMC)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.kMD = null;
                        } else {
                            a.this.kMD = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            a.this.kMB = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                a.this.kMC = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                a.this.kMD = null;
                            } else {
                                a.this.kMD = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        a.this.kMB = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            a.this.kMC = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.kMD = null;
                        } else {
                            a.this.kMD = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    }
                    if (view.getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                        } catch (ClassCastException e2) {
                            e2.printStackTrace();
                            sparseArray = sparseArray2;
                        }
                    } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                        a.this.a(a.this.kNq, a.this.kMB.isGif());
                    } else {
                        try {
                            sparseArray = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray = sparseArray2;
                        }
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
            a.this.jds = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (a.this.jds == null || a.this.lga.dhw() == null) {
                return true;
            }
            if (!a.this.lga.dhw().bbu() || a.this.jds.getId() == null || !a.this.jds.getId().equals(a.this.lga.dah().bfG())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = a.this.lga.dah().getPbData() != null && a.this.lga.dah().getPbData().cZu();
            if (a.this.kMk == null) {
                a.this.kMk = new k(a.this.lga.getContext());
                a.this.kMk.a(a.this.kNc);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = a.this.cX(view) && !z3;
                boolean z5 = (!a.this.cX(view) || a.this.kMB == null || a.this.kMB.isGif()) ? false : true;
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
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), a.this.kMk));
                }
                if (z5) {
                    arrayList.add(new g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), a.this.kMk));
                }
                if (!z4 && !z5) {
                    g gVar3 = new g(3, TbadkCoreApplication.getInst().getString(R.string.copy), a.this.kMk);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, a.this.jds);
                    gVar3.mTextView.setTag(sparseArray3);
                    arrayList.add(gVar3);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), a.this.kMk);
                    } else {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.mark), a.this.kMk);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, a.this.jds);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar2.mTextView.setTag(sparseArray4);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin() && !a.this.kJC) {
                    if (!z8 && z7) {
                        g gVar4 = new g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), a.this.kMk);
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
                        gVar4.mTextView.setTag(sparseArray5);
                        arrayList.add(gVar4);
                    } else {
                        if ((a.this.tc(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                            g gVar5 = new g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.kMk);
                            gVar5.mTextView.setTag(str);
                            arrayList.add(gVar5);
                        }
                    }
                    g gVar6 = null;
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
                            gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.kMk);
                            gVar6.mTextView.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), a.this.kMk);
                        gVar.mTextView.setTag(sparseArray6);
                    } else {
                        if (z10) {
                            SparseArray sparseArray7 = new SparseArray();
                            sparseArray7.put(R.id.tag_should_manage_visible, false);
                            sparseArray7.put(R.id.tag_user_mute_visible, false);
                            sparseArray7.put(R.id.tag_should_delete_visible, true);
                            sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                            sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                            sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                            sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                            if (a.this.lga.dah().getPbData().cZg() == 1002 && !z6) {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.kMk);
                            } else {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.kMk);
                            }
                            gVar6.mTextView.setTag(sparseArray7);
                        }
                        gVar = null;
                    }
                    if (gVar6 != null) {
                        arrayList.add(gVar6);
                    }
                    if (gVar != null) {
                        arrayList.add(gVar);
                    }
                }
                a.this.kMk.aX(arrayList);
                a.this.kMj = new i(a.this.lga.getPageContext(), a.this.kMk);
                a.this.kMj.NY();
                TiebaStatic.log(new aq("c13272").dF("tid", a.this.lga.dah().dcf()).dF("fid", a.this.lga.dah().getForumId()).dF("uid", a.this.lga.dah().getPbData().cYR().bfy().getUserId()).dF("post_id", a.this.lga.dah().bsX()).ai("obj_source", z2 ? 2 : 1));
            }
            return true;
        }
    };
    private k.c kNc = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.17
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (a.this.kMj != null) {
                a.this.kMj.dismiss();
            }
            switch (i) {
                case 1:
                    if (a.this.kMB != null && !TextUtils.isEmpty(a.this.kMC)) {
                        if (a.this.kMD == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.kMC));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.kMC;
                            aVar.pkgId = a.this.kMD.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.kMD.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.kMB = null;
                        a.this.kMC = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.kMB != null && !TextUtils.isEmpty(a.this.kMC)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.lga.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.lga.getPageContext().getPageActivity())) {
                            if (a.this.dWg == null) {
                                a.this.dWg = new bd(a.this.lga.getPageContext());
                            }
                            a.this.dWg.j(a.this.kMC, a.this.kMB.getImageByte());
                            a.this.kMB = null;
                            a.this.kMC = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.jds != null) {
                        a.this.jds.fL(a.this.lga.getPageContext().getPageActivity());
                        a.this.jds = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new aq("c11739").ai("obj_locate", 2));
                    if (a.this.lga.checkUpIsLogin()) {
                        a.this.cW(view);
                        if (a.this.lga.dah().getPbData().cYR() != null && a.this.lga.dah().getPbData().cYR().bfy() != null && a.this.lga.dah().getPbData().cYR().bfy().getUserId() != null && a.this.lga.dhw() != null) {
                            int h = a.this.h(a.this.lga.dah().getPbData());
                            bw cYR = a.this.lga.dah().getPbData().cYR();
                            if (cYR.beg()) {
                                i2 = 2;
                            } else if (cYR.beh()) {
                                i2 = 3;
                            } else if (cYR.bht()) {
                                i2 = 4;
                            } else {
                                i2 = cYR.bhu() ? 5 : 1;
                            }
                            TiebaStatic.log(new aq("c12526").dF("tid", a.this.lga.dah().dcf()).ai("obj_locate", 2).dF("obj_id", a.this.lga.dah().getPbData().cYR().bfy().getUserId()).ai("obj_type", a.this.lga.dhw().bbu() ? 0 : 1).ai("obj_source", h).ai("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.lga.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new aq("c13079"));
                        a.this.NW((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new aq("c11739").ai("obj_locate", 4));
                        SparseArray<Object> sparseArray2 = (SparseArray) tag;
                        if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray2.put(R.id.tag_from, 0);
                            sparseArray2.put(R.id.tag_check_mute_from, 2);
                            a.this.c(sparseArray2);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        a.this.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    if (!j.isNetWorkAvailable()) {
                        a.this.lga.showToast(R.string.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null) {
                        boolean booleanValue = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue2 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                        if (booleanValue) {
                            if (booleanValue3) {
                                sparseArray4.put(R.id.tag_from, 1);
                                sparseArray4.put(R.id.tag_check_mute_from, 2);
                                a.this.c(sparseArray4);
                                return;
                            }
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            a.this.dc(view);
                            return;
                        } else if (booleanValue2) {
                            a.this.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 8:
                    if (bg.checkUpIsLogin(a.this.lga.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.bhp() != null) {
                            a.this.d(postData.bhp());
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final b.InterfaceC0533b kNq = new b.InterfaceC0533b() { // from class: com.baidu.tieba.pb.videopb.b.a.21
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0533b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.kMB != null && !TextUtils.isEmpty(a.this.kMC)) {
                if (i == 0) {
                    if (a.this.kMD == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.kMC));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.kMC;
                        aVar.pkgId = a.this.kMD.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.kMD.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.lga.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.lga.getPageContext().getPageActivity())) {
                        if (a.this.dWg == null) {
                            a.this.dWg = new bd(a.this.lga.getPageContext());
                        }
                        a.this.dWg.j(a.this.kMC, a.this.kMB.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.kMB = null;
                a.this.kMC = null;
            }
        }
    };

    public void dbi() {
        f pbData;
        bw cYR;
        boolean z = true;
        if (this.lga != null && this.lga.dah() != null && this.lga.dah().getPbData() != null && (cYR = (pbData = this.lga.dah().getPbData()).cYR()) != null && cYR.bfy() != null) {
            this.lga.ddQ();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cYR.bfy().getUserId());
            ak akVar = new ak();
            int cZg = this.lga.dah().getPbData().cZg();
            if (cZg == 1 || cZg == 3) {
                akVar.kRy = true;
                akVar.kRx = true;
                akVar.kRD = cYR.bft() == 1;
                akVar.kRC = cYR.bfu() == 1;
            } else {
                akVar.kRy = false;
                akVar.kRx = false;
            }
            if (cZg == 1002 && !equals) {
                akVar.kRE = true;
            }
            akVar.kRv = td(equals);
            akVar.kRz = dbj();
            akVar.kRw = te(equals);
            akVar.EK = this.lga.dah().dch();
            akVar.kRs = true;
            akVar.kRr = tc(equals);
            akVar.kRB = TbadkCoreApplication.getInst().getSkinType() == 1;
            akVar.kRA = true;
            akVar.isHostOnly = this.lga.dah().getHostMode();
            akVar.kRu = true;
            if (cYR.bfQ() == null) {
                akVar.kRt = true;
            } else {
                akVar.kRt = false;
            }
            if (pbData.cZu()) {
                akVar.kRs = false;
                akVar.kRu = false;
                akVar.kRt = false;
                akVar.kRx = false;
                akVar.kRy = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.cZu()) {
                z = false;
            }
            akVar.kRF = z;
            a(akVar);
        }
    }

    private boolean td(boolean z) {
        boolean z2;
        ab abVar;
        if (this.lga == null || this.lga.dah() == null || this.lga.dah().getPbData() == null) {
            return false;
        }
        f pbData = this.lga.dah().getPbData();
        bw cYR = pbData.cYR();
        if (cYR != null) {
            if (cYR.beg() || cYR.beh()) {
                return false;
            }
            if (cYR.bht() || cYR.bhu()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.cZg() != 0) {
                return pbData.cZg() != 3;
            }
            List<bs> cZo = pbData.cZo();
            if (y.getCount(cZo) > 0) {
                for (bs bsVar : cZo) {
                    if (bsVar != null && (abVar = bsVar.ecI) != null && abVar.eau && !abVar.eav && (abVar.type == 1 || abVar.type == 2)) {
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

    private boolean te(boolean z) {
        if (z || this.lga == null || this.lga.dah() == null || this.lga.dah().getPbData() == null) {
            return false;
        }
        return ((this.lga.dah().getPbData().getForum() != null && this.lga.dah().getPbData().getForum().isBlockBawuDelete) || this.lga.dah().getPbData().cZg() == 0 || this.lga.dah().getPbData().cZg() == 3) ? false : true;
    }

    private boolean dbj() {
        if (this.lga == null || this.lga.dah() == null || !this.lga.dah().dch()) {
            return false;
        }
        return this.lga.dah().getPageData() == null || this.lga.dah().getPageData().bep() != 0;
    }

    public void a(ak akVar) {
        if (!this.lga.getBaseFragmentActivity().isProgressBarShown()) {
            this.kZF = new aj(this.lga, this.lga.aBS);
            this.kZE = new AlertDialog.Builder(this.lga.getContext(), R.style.DialogTheme).create();
            this.kZE.setCanceledOnTouchOutside(true);
            com.baidu.adp.lib.f.g.showDialog(this.kZE, this.lga.getFragmentActivity());
            Window window = this.kZE.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.kZF.getView());
            this.kZF.ts(akVar == null ? false : akVar.kRr);
            this.kZF.tt(akVar == null ? false : akVar.kRv);
            this.kZF.tu(akVar == null ? false : akVar.kRz);
            this.kZF.tw(akVar == null ? false : akVar.kRw);
            this.kZF.tx(akVar == null ? true : akVar.kRt);
            if (akVar == null) {
                this.kZF.am(false, false);
                this.kZF.an(false, false);
            } else {
                this.kZF.am(akVar.kRx, akVar.kRD);
                this.kZF.an(akVar.kRy, akVar.kRC);
            }
            boolean z = akVar == null ? false : akVar.EK;
            boolean z2 = akVar == null ? false : akVar.isHostOnly;
            boolean z3 = akVar == null ? false : akVar.kRu;
            boolean z4 = akVar == null ? false : akVar.kRs;
            boolean z5 = akVar == null ? false : akVar.kRB;
            boolean z6 = akVar == null ? false : akVar.kRA;
            this.kZF.al(z3, z2);
            this.kZF.ao(z4, z);
            this.kZF.ap(z6, z5);
            if (akVar != null) {
                this.kZF.kRo = akVar.kRE;
                if (akVar.kRE) {
                    this.kZF.dds().setText(R.string.report_text);
                    this.kZF.tw(false);
                }
            }
            this.kZF.tv(akVar != null ? akVar.kRF : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.lga.dah() != null && this.lga.dah().getPbData() != null && this.lga.dah().getPbData().getThreadId() != null && this.lga.dah().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.kZF.ddv().setText(R.string.have_called_fans_short);
            }
            dfN();
        }
    }

    private void dfN() {
        if (this.kZF != null) {
            this.kZF.ddz();
        }
    }

    public void aSz() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.kZE != null) {
                        com.baidu.adp.lib.f.g.dismissDialog(a.this.kZE, a.this.lga.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.mX().postDelayed(this.runnable, 100L);
    }

    public void dfO() {
        if (this.kZE != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.kZE, this.lga.getPageContext().getPageActivity());
        }
    }

    public aj dfP() {
        return this.kZF;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.lga = videoPbFragment;
        this.kMz = videoPbFragment.getUniqueId();
        this.kMc = new com.baidu.tieba.pb.pb.report.a(this.lga.getContext());
        this.kMc.w(this.lga.getUniqueId());
        this.kVg = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.16
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.lga.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.lga.dah().getPbData().getUserData().getUserId());
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
                a.this.lga.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.lga.getPageContext().getPageActivity(), a.this.lga.dah().getPbData().getForum().getId(), a.this.lga.dah().getPbData().getForum().getName(), a.this.lga.dah().getPbData().cYR().getId(), valueOf, str, str3, str2, str4)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW(View view) {
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
        PostData I;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.lga.dah().bfG())) {
                z = true;
            }
            MarkData o = this.lga.dah().o(postData);
            if (this.lga.dah().getPbData() != null && this.lga.dah().getPbData().cZu() && (I = this.lga.I(this.lga.dah().getPbData())) != null) {
                o = this.lga.dah().o(I);
            }
            if (o != null) {
                this.lga.dep();
                if (this.lga.dhw() != null) {
                    this.lga.dhw().a(o);
                    if (!z) {
                        this.lga.dhw().bbw();
                    } else {
                        this.lga.dhw().bbv();
                    }
                }
            }
        }
    }

    public int h(f fVar) {
        if (fVar != null && fVar.cYR() != null) {
            if (fVar.cYR().getThreadType() == 0) {
                return 1;
            }
            if (fVar.cYR().getThreadType() == 54) {
                return 2;
            }
            if (fVar.cYR().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tc(boolean z) {
        if (this.lga.dah() == null || this.lga.dah().getPbData() == null) {
            return false;
        }
        return ((this.lga.dah().getPbData().cZg() != 0) || this.lga.dah().getPbData().cYR() == null || this.lga.dah().getPbData().cYR().bfy() == null || TextUtils.equals(this.lga.dah().getPbData().cYR().bfy().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void NW(String str) {
        if (this.lga.dah() != null && this.lga.dah().getPbData() != null && this.lga.dah().getPbData().cZu()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lga.dah().dcf(), str);
            bw cYR = this.lga.dah().getPbData().cYR();
            if (cYR.beg()) {
                format = format + "&channelid=33833";
            } else if (cYR.bhs()) {
                format = format + "&channelid=33842";
            } else if (cYR.beh()) {
                format = format + "&channelid=33840";
            }
            NX(format);
            return;
        }
        this.kMc.Ox(str);
    }

    private void NX(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.lga.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.kMj != null && this.kMj.isShowing()) {
                this.kMj.dismiss();
                this.kMj = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.lga.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.kMj != null) {
                            a.this.kMj.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.kMz);
                            userMuteAddAndDelCustomMessage.setTag(a.this.kMz);
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
                    arrayList.add(new g(0, TbadkCoreApplication.getInst().getResources().getString(R.string.delete), kVar));
                }
                if (z) {
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getResources().getString(R.string.un_mute), kVar));
                } else {
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getResources().getString(R.string.mute), kVar));
                }
                kVar.aX(arrayList);
                this.kMj = new i(this.lga.getPageContext(), kVar);
                this.kMj.NY();
            }
        }
    }

    public void dbE() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lga.getPageContext().getPageActivity());
        aVar.zV(this.lga.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.19
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.lga.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.20
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lga.getPageContext()).bia();
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
        sparseArray.put(kUy, Integer.valueOf(kUz));
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
        this.kTH = new com.baidu.tbadk.core.dialog.a(this.lga.getActivity());
        if (StringUtils.isNull(str2)) {
            this.kTH.nE(i3);
        } else {
            this.kTH.setOnlyMessageShowCenter(false);
            this.kTH.zV(str2);
        }
        this.kTH.setYesButtonTag(sparseArray);
        this.kTH.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.lga.a(aVar, (JSONArray) null);
            }
        });
        this.kTH.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kTH.id(true);
        this.kTH.b(this.lga.getPageContext());
        if (z) {
            this.kTH.bia();
        } else {
            a(this.kTH, i);
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.lga != null && aVar != null) {
            if (this.iGA == null && this.lga.getView() != null) {
                this.iGA = new com.baidu.tieba.NEGFeedBack.e(this.lga.getPageContext(), this.lga.getView());
            }
            AntiData coh = coh();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (coh != null && coh.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = coh.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray);
            this.iGA.setDefaultReasonArray(new String[]{this.lga.getString(R.string.delete_thread_reason_1), this.lga.getString(R.string.delete_thread_reason_2), this.lga.getString(R.string.delete_thread_reason_3), this.lga.getString(R.string.delete_thread_reason_4), this.lga.getString(R.string.delete_thread_reason_5)});
            this.iGA.setData(arVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.iGA.DC(str);
            this.iGA.a(new e.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray) {
                    a.this.lga.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData coh() {
        if (this.lga.dah() == null || this.lga.dah().getPbData() == null) {
            return null;
        }
        return this.lga.dah().getPbData().getAnti();
    }

    public void dc(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        g gVar;
        g gVar2;
        k kVar = new k(this.lga.getContext());
        kVar.setTitleText(this.lga.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.kTG.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (a.this.kVg != null) {
                                a.this.kVg.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
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
                gVar2 = new g(0, this.lga.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new g(0, this.lga.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            g gVar3 = new g(1, this.lga.getString(R.string.forbidden_person), kVar);
            gVar3.mTextView.setTag(sparseArray3);
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
                gVar = new g(2, this.lga.getString(R.string.un_mute), kVar);
            } else {
                gVar = new g(2, this.lga.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.aX(arrayList);
        if (this.kTG == null) {
            this.kTG = new i(this.lga.getPageContext(), kVar);
        } else {
            this.kTG.a(kVar);
        }
        this.kTG.NY();
    }

    public void dbb() {
        if (this.kLG == null) {
            this.kLG = new com.baidu.tbadk.core.dialog.b(this.lga.getPageContext().getPageActivity());
            this.kLG.a(new String[]{this.lga.getPageContext().getString(R.string.call_phone), this.lga.getPageContext().getString(R.string.sms_phone), this.lga.getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0533b() { // from class: com.baidu.tieba.pb.videopb.b.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0533b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.lga.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.kId = a.this.kId.trim();
                        UtilHelper.callPhone(a.this.lga.getPageContext().getPageActivity(), a.this.kId);
                        new com.baidu.tieba.pb.pb.main.b(a.this.lga.dah().dcf(), a.this.kId, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.lga.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.kId = a.this.kId.trim();
                        UtilHelper.smsPhone(a.this.lga.getPageContext().getPageActivity(), a.this.kId);
                        new com.baidu.tieba.pb.pb.main.b(a.this.lga.dah().dcf(), a.this.kId, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.kId = a.this.kId.trim();
                        UtilHelper.startBaiDuBar(a.this.lga.getPageContext().getPageActivity(), a.this.kId);
                        bVar.dismiss();
                    }
                }
            }).nK(b.a.BOTTOM_TO_TOP).nL(17).d(this.lga.getPageContext());
        }
    }

    public void di(final View view) {
        String[] strArr;
        int i = 0;
        if (this.lga != null && this.lga.dah() != null) {
            final i iVar = new i(this.lga.getPageContext());
            if (this.lga.dah().getPbData().kFn == null || this.lga.dah().getPbData().kFn.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.lga.dah().getPbData().kFn.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.lga.dah().getPbData().kFn.size()) {
                        break;
                    }
                    strArr2[i2] = this.lga.dah().getPbData().kFn.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.lga.dah().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.lga.dah().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.lga.dah().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.lga.dah().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new aq("c12097").ai("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).ai("obj_type", i4));
                    if (a.this.lga.dah().getPbData().kFn != null && a.this.lga.dah().getPbData().kFn.size() > i3) {
                        i3 = a.this.lga.dah().getPbData().kFn.get(i3).sort_type.intValue();
                    }
                    boolean EO = a.this.lga.dah().EO(i3);
                    view.setTag(Integer.valueOf(a.this.lga.dah().dcy()));
                    if (EO) {
                        a.this.lga.setIsLoading(true);
                    }
                }
            });
            iVar.NY();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lga.getActivity());
            aVar.zU(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.zV(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.id(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new aq("c12528").dF("obj_id", metaData.getUserId()).ai("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new aq("c12528").dF("obj_id", metaData.getUserId()).ai("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.lga.dhH() != null) {
                        a.this.lga.dhH().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.lga.getPageContext().getUniqueId(), a.this.lga.dah().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.lga.getPageContext()).bia();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.kMz);
        userMuteAddAndDelCustomMessage.setTag(this.kMz);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void CA(String str) {
        if (str == null) {
            str = "";
        }
        if (this.lga != null && this.lga.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lga.getPageContext().getPageActivity());
            aVar.zV(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lga.getPageContext()).bia();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lga.getBaseFragmentActivity());
        if (at.isEmpty(str)) {
            aVar.zV(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.zV(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lga.getPageContext()).bia();
    }

    public void showLoadingDialog() {
        if (this.hxf == null) {
            this.hxf = new com.baidu.tbadk.core.view.a(this.lga.getPageContext());
        }
        this.hxf.setDialogVisiable(true);
    }

    public void bXZ() {
        if (this.hxf != null) {
            this.hxf.setDialogVisiable(false);
        }
    }

    public void f(SparseArray<Object> sparseArray) {
        PostData postData;
        boolean z;
        String str;
        g gVar;
        if (this.lga != null && this.lga.dah() != null && sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            if (this.kMk == null) {
                this.kMk = new k(this.lga.getContext());
                this.kMk.a(this.kNc);
            }
            ArrayList arrayList = new ArrayList();
            boolean z2 = this.lga.dah().getPbData() != null && this.lga.dah().getPbData().cZu();
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
                if (postData.bhp() != null) {
                    g gVar2 = new g(8, (postData.bhp().hasAgree && postData.bgZ() == 5) ? this.lga.getString(R.string.action_cancel_dislike) : this.lga.getString(R.string.action_dislike), this.kMk);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    gVar2.mTextView.setTag(sparseArray2);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z4 && z3) {
                        g gVar3 = new g(5, this.lga.getString(R.string.mute_option), this.kMk);
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
                        gVar3.mTextView.setTag(sparseArray3);
                        arrayList.add(gVar3);
                    } else {
                        if ((tc(z) && TbadkCoreApplication.isLogin()) && !z2) {
                            g gVar4 = new g(5, this.lga.getString(R.string.report_text), this.kMk);
                            gVar4.mTextView.setTag(str);
                            arrayList.add(gVar4);
                        }
                    }
                    g gVar5 = null;
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
                            gVar5 = new g(6, this.lga.getString(R.string.delete), this.kMk);
                            gVar5.mTextView.setTag(sparseArray4);
                        } else {
                            sparseArray4.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, this.lga.getString(R.string.bar_manager), this.kMk);
                        gVar.mTextView.setTag(sparseArray4);
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
                            if (this.lga.dah().getPbData().cZg() == 1002 && !z) {
                                gVar5 = new g(6, this.lga.getString(R.string.report_text), this.kMk);
                            } else {
                                gVar5 = new g(6, this.lga.getString(R.string.delete), this.kMk);
                            }
                            gVar5.mTextView.setTag(sparseArray5);
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
                this.kMk.aX(arrayList);
                this.kMj = new i(this.lga.getPageContext(), this.kMk);
                this.kMj.NY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eqK == null) {
                this.eqK = new com.baidu.tbadk.core.message.a();
            }
            if (this.equ == null) {
                this.equ = new com.baidu.tieba.tbadkCore.data.e();
                this.equ.uniqueId = this.lga.getUniqueId();
            }
            c cVar = new c();
            cVar.dYY = 5;
            cVar.dZe = 8;
            cVar.dZd = 2;
            if (this.lga != null && this.lga.dah() != null) {
                cVar.dZc = this.lga.dah().dcP();
            }
            if (cVar != null) {
                cVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (cVar != null) {
                        cVar.dZf = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (cVar != null) {
                        cVar.dZf = 1;
                        i = 0;
                    }
                }
                this.eqK.a(agreeData, i, this.lga.getUniqueId(), false);
                this.eqK.a(agreeData, this.equ);
                if (this.lga == null && this.lga.dah() != null && this.lga.dah().getPbData() != null) {
                    this.eqK.a(this.lga.dbM(), cVar, agreeData, this.lga.dah().getPbData().cYR());
                    return;
                }
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (cVar != null) {
                cVar.dZf = 1;
            }
            i = 0;
            this.eqK.a(agreeData, i, this.lga.getUniqueId(), false);
            this.eqK.a(agreeData, this.equ);
            if (this.lga == null) {
            }
        }
    }

    public void a(final b.InterfaceC0533b interfaceC0533b, boolean z) {
        if (this.kTP != null) {
            this.kTP.dismiss();
            this.kTP = null;
        }
        k kVar = new k(this.lga.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.lga.dah().getPbData() != null && this.lga.dah().getPbData().cYR() != null && !this.lga.dah().getPbData().cYR().isBjh()) {
            arrayList.add(new g(0, this.lga.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new g(1, this.lga.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.aX(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.kTP.dismiss();
                interfaceC0533b.a(null, i, view);
            }
        });
        this.kTP = new i(this.lga.getPageContext(), kVar);
        this.kTP.NY();
    }

    public void aZ(ArrayList<com.baidu.tbadk.core.data.aj> arrayList) {
        if (this.kTK == null) {
            this.kTK = LayoutInflater.from(this.lga.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.lga.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.kTK);
        if (this.kTJ == null) {
            this.kTJ = new Dialog(this.lga.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.kTJ.setCanceledOnTouchOutside(true);
            this.kTJ.setCancelable(true);
            this.kTS = (ScrollView) this.kTK.findViewById(R.id.good_scroll);
            this.kTJ.setContentView(this.kTK);
            WindowManager.LayoutParams attributes = this.kTJ.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.kTJ.getWindow().setAttributes(attributes);
            this.hti = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.14
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.kTO = (String) compoundButton.getTag();
                        if (a.this.hth != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.hth) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.kTO != null && !str.equals(a.this.kTO)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.kTL = (LinearLayout) this.kTK.findViewById(R.id.good_class_group);
            this.kTN = (TextView) this.kTK.findViewById(R.id.dialog_button_cancel);
            this.kTN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.kTJ instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(a.this.kTJ, a.this.lga.getPageContext());
                    }
                }
            });
            this.kTM = (TextView) this.kTK.findViewById(R.id.dialog_button_ok);
            this.kTM.setOnClickListener(this.lga.dhx());
        }
        this.kTL.removeAllViews();
        this.hth = new ArrayList();
        CustomBlueCheckRadioButton fH = fH("0", this.lga.getPageContext().getString(R.string.thread_good_class));
        this.hth.add(fH);
        fH.setChecked(true);
        this.kTL.addView(fH);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aj ajVar = arrayList.get(i2);
                if (ajVar != null && !TextUtils.isEmpty(ajVar.bdM()) && ajVar.bdN() > 0) {
                    CustomBlueCheckRadioButton fH2 = fH(String.valueOf(ajVar.bdN()), ajVar.bdM());
                    this.hth.add(fH2);
                    View view = new View(this.lga.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    ap.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.kTL.addView(view);
                    this.kTL.addView(fH2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.kTS.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.lga.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.lga.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.lga.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.kTS.setLayoutParams(layoutParams2);
            this.kTS.removeAllViews();
            if (this.kTL != null && this.kTL.getParent() == null) {
                this.kTS.addView(this.kTL);
            }
        }
        com.baidu.adp.lib.f.g.a(this.kTJ, this.lga.getPageContext());
    }

    private CustomBlueCheckRadioButton fH(String str, String str2) {
        Activity pageActivity = this.lga.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.hti);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public boolean cX(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.kMz;
        userMuteCheckCustomMessage.setTag(this.kMz);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void deK() {
        if (this.kTH != null) {
            this.kTH.dismiss();
        }
        if (this.kTI != null) {
            com.baidu.adp.lib.f.g.b(this.kTI, this.lga.getPageContext());
        }
        if (this.kTJ != null) {
            com.baidu.adp.lib.f.g.b(this.kTJ, this.lga.getPageContext());
        }
        if (this.kTG != null) {
            this.kTG.dismiss();
        }
    }

    public void dio() {
        if (this.kMj != null) {
            this.kMj.dismiss();
        }
    }

    public void deJ() {
        aSz();
        this.lga.ddQ();
        if (this.kMj != null) {
            this.kMj.dismiss();
        }
        deK();
    }

    public void deI() {
        aSz();
        this.lga.ddQ();
        if (this.kMj != null) {
            this.kMj.dismiss();
        }
        this.lga.cpF();
        deK();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener dhz() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b dip() {
        return this.kLG;
    }

    public void setPhoneNumber(String str) {
        this.kId = str;
    }

    public String deo() {
        return this.kTO;
    }

    public View den() {
        if (this.kTK != null) {
            return this.kTK.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
