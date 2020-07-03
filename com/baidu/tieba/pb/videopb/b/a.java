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
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bq;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.af;
import com.baidu.tieba.pb.pb.main.ag;
import com.baidu.tieba.pb.pb.main.az;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes9.dex */
public class a {
    public static int knm = 3;
    public static int knn = 0;
    public static int kno = 3;
    public static int knp = 4;
    public static int knq = 5;
    public static int knr = 6;
    private az dEN;
    private List<CustomBlueCheckRadioButton> gTC;
    private e ieU;
    private String kbB;
    public BdUniqueId kfL;
    private com.baidu.adp.widget.ImageView.a kfN;
    private String kfO;
    private TbRichTextMemeInfo kfP;
    private com.baidu.tieba.pb.pb.report.a kfn;
    private i kfv;
    private k kfw;
    private PbFragment.b knU;
    public VideoPbFragment kyB;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    private Runnable runnable;
    private i kmE = null;
    private com.baidu.tbadk.core.dialog.a kmw = null;
    private Dialog kmx = null;
    private Dialog kmy = null;
    private View kmz = null;
    private LinearLayout kmA = null;
    private TextView kmB = null;
    private TextView kmC = null;
    private String kmD = null;
    private ScrollView kmH = null;
    private CompoundButton.OnCheckedChangeListener gTD = null;
    private i kmv = null;
    private com.baidu.tbadk.core.view.a gXx = null;
    private com.baidu.tbadk.core.dialog.b keT = null;
    private AlertDialog ksA = null;
    private af ksB = null;
    PostData izC = null;
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.12
        /* JADX WARN: Removed duplicated region for block: B:32:0x00af A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x01fe  */
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
            if (a.this.kyB == null || !a.this.kyB.isAdded()) {
                return true;
            }
            SparseArray sparseArray2 = null;
            try {
                sparseArray2 = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray2 == null) {
                if (a.this.cE(view)) {
                    if (view instanceof TbImageView) {
                        a.this.kfN = ((TbImageView) view).getBdImage();
                        a.this.kfO = ((TbImageView) view).getUrl();
                        if (a.this.kfN == null || TextUtils.isEmpty(a.this.kfO)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.kfP = null;
                        } else {
                            a.this.kfP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            a.this.kfN = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                a.this.kfO = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                a.this.kfP = null;
                            } else {
                                a.this.kfP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        a.this.kfN = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            a.this.kfO = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.kfP = null;
                        } else {
                            a.this.kfP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        a.this.a(a.this.kgz, a.this.kfN.isGif());
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
            a.this.izC = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (a.this.izC == null || a.this.kyB.cPl() == null) {
                return true;
            }
            if (!a.this.kyB.cPl().aOo() || a.this.izC.getId() == null || !a.this.izC.getId().equals(a.this.kyB.cIe().aSx())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = a.this.kyB.cIe().getPbData() != null && a.this.kyB.cIe().getPbData().cHp();
            if (a.this.kfw == null) {
                a.this.kfw = new k(a.this.kyB.getContext());
                a.this.kfw.a(a.this.kgA);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = a.this.cE(view) && !z3;
                boolean z5 = (!a.this.cE(view) || a.this.kfN == null || a.this.kfN.isGif()) ? false : true;
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
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), a.this.kfw));
                }
                if (z5) {
                    arrayList.add(new g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), a.this.kfw));
                }
                if (!z4 && !z5) {
                    g gVar3 = new g(3, TbadkCoreApplication.getInst().getString(R.string.copy), a.this.kfw);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, a.this.izC);
                    gVar3.mTextView.setTag(sparseArray3);
                    arrayList.add(gVar3);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), a.this.kfw);
                    } else {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.mark), a.this.kfw);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, a.this.izC);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar2.mTextView.setTag(sparseArray4);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z8 && z7) {
                        g gVar4 = new g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), a.this.kfw);
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
                        if ((a.this.rH(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                            g gVar5 = new g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.kfw);
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
                            gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.kfw);
                            gVar6.mTextView.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), a.this.kfw);
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
                            if (a.this.kyB.cIe().getPbData().cHc() == 1002 && !z6) {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.kfw);
                            } else {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.kfw);
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
                a.this.kfw.aL(arrayList);
                a.this.kfv = new i(a.this.kyB.getPageContext(), a.this.kfw);
                a.this.kfv.showDialog();
                TiebaStatic.log(new ao("c13272").dk("tid", a.this.kyB.cIe().cJZ()).dk("fid", a.this.kyB.cIe().getForumId()).dk("uid", a.this.kyB.cIe().getPbData().cGN().aSp().getUserId()).dk("post_id", a.this.kyB.cIe().bfw()).ag("obj_source", z2 ? 2 : 1));
            }
            return true;
        }
    };
    private k.c kgA = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.17
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            int i2;
            if (a.this.kfv != null) {
                a.this.kfv.dismiss();
            }
            switch (i) {
                case 1:
                    if (a.this.kfN != null && !TextUtils.isEmpty(a.this.kfO)) {
                        if (a.this.kfP == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.kfO));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.kfO;
                            aVar.pkgId = a.this.kfP.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.kfP.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.kfN = null;
                        a.this.kfO = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.kfN != null && !TextUtils.isEmpty(a.this.kfO)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.kyB.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.kyB.getPageContext().getPageActivity())) {
                            if (a.this.dEN == null) {
                                a.this.dEN = new az(a.this.kyB.getPageContext());
                            }
                            a.this.dEN.j(a.this.kfO, a.this.kfN.getImageByte());
                            a.this.kfN = null;
                            a.this.kfO = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.izC != null) {
                        a.this.izC.fp(a.this.kyB.getPageContext().getPageActivity());
                        a.this.izC = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new ao("c11739").ag("obj_locate", 2));
                    if (a.this.kyB.checkUpIsLogin()) {
                        a.this.cD(view);
                        if (a.this.kyB.cIe().getPbData().cGN() != null && a.this.kyB.cIe().getPbData().cGN().aSp() != null && a.this.kyB.cIe().getPbData().cGN().aSp().getUserId() != null && a.this.kyB.cPl() != null) {
                            int h = a.this.h(a.this.kyB.cIe().getPbData());
                            bu cGN = a.this.kyB.cIe().getPbData().cGN();
                            if (cGN.aQX()) {
                                i2 = 2;
                            } else if (cGN.aQY()) {
                                i2 = 3;
                            } else if (cGN.aUl()) {
                                i2 = 4;
                            } else {
                                i2 = cGN.aUm() ? 5 : 1;
                            }
                            TiebaStatic.log(new ao("c12526").dk("tid", a.this.kyB.cIe().cJZ()).ag("obj_locate", 2).dk("obj_id", a.this.kyB.cIe().getPbData().cGN().aSp().getUserId()).ag("obj_type", a.this.kyB.cPl().aOo() ? 0 : 1).ag("obj_source", h).ag("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.kyB.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new ao("c13079"));
                        a.this.JO((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new ao("c11739").ag("obj_locate", 4));
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray.put(R.id.tag_from, 0);
                            sparseArray.put(R.id.tag_check_mute_from, 2);
                            a.this.c(sparseArray);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray2 = (SparseArray) view.getTag();
                    if (sparseArray2 != null && (sparseArray2.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_id) instanceof String) && (sparseArray2.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    if (!j.isNetWorkAvailable()) {
                        a.this.kyB.showToast(R.string.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        boolean booleanValue = ((Boolean) sparseArray3.get(R.id.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue3 = ((Boolean) sparseArray3.get(R.id.tag_user_mute_visible)).booleanValue();
                        if (booleanValue) {
                            if (booleanValue3) {
                                sparseArray3.put(R.id.tag_from, 1);
                                sparseArray3.put(R.id.tag_check_mute_from, 2);
                                a.this.c(sparseArray3);
                                return;
                            }
                            sparseArray3.put(R.id.tag_check_mute_from, 2);
                            a.this.cJ(view);
                            return;
                        } else if (booleanValue2) {
                            a.this.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final b.a kgz = new b.a() { // from class: com.baidu.tieba.pb.videopb.b.a.21
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.kfN != null && !TextUtils.isEmpty(a.this.kfO)) {
                if (i == 0) {
                    if (a.this.kfP == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.kfO));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.kfO;
                        aVar.pkgId = a.this.kfP.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.kfP.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.kyB.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.kyB.getPageContext().getPageActivity())) {
                        if (a.this.dEN == null) {
                            a.this.dEN = new az(a.this.kyB.getPageContext());
                        }
                        a.this.dEN.j(a.this.kfO, a.this.kfN.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.kfN = null;
                a.this.kfO = null;
            }
        }
    };

    public void cJf() {
        com.baidu.tieba.pb.data.e pbData;
        bu cGN;
        boolean z = true;
        if (this.kyB != null && this.kyB.cIe() != null && this.kyB.cIe().getPbData() != null && (cGN = (pbData = this.kyB.cIe().getPbData()).cGN()) != null && cGN.aSp() != null) {
            this.kyB.cLJ();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cGN.aSp().getUserId());
            ag agVar = new ag();
            int cHc = this.kyB.cIe().getPbData().cHc();
            if (cHc == 1 || cHc == 3) {
                agVar.kkl = true;
                agVar.kkk = true;
                agVar.kkq = cGN.aSk() == 1;
                agVar.kkp = cGN.aSl() == 1;
            } else {
                agVar.kkl = false;
                agVar.kkk = false;
            }
            if (cHc == 1002 && !equals) {
                agVar.kkr = true;
            }
            agVar.kki = rI(equals);
            agVar.kkm = cJg();
            agVar.kkj = rJ(equals);
            agVar.Ef = this.kyB.cIe().cKb();
            agVar.kkf = true;
            agVar.kke = rH(equals);
            agVar.kko = TbadkCoreApplication.getInst().getSkinType() == 1;
            agVar.kkn = true;
            agVar.isHostOnly = this.kyB.cIe().getHostMode();
            agVar.kkh = true;
            if (cGN.aSH() == null) {
                agVar.kkg = true;
            } else {
                agVar.kkg = false;
            }
            if (pbData.cHp()) {
                agVar.kkf = false;
                agVar.kkh = false;
                agVar.kkg = false;
                agVar.kkk = false;
                agVar.kkl = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.cHp()) {
                z = false;
            }
            agVar.kks = z;
            a(agVar);
        }
    }

    private boolean rI(boolean z) {
        boolean z2;
        z zVar;
        if (this.kyB == null || this.kyB.cIe() == null || this.kyB.cIe().getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.e pbData = this.kyB.cIe().getPbData();
        bu cGN = pbData.cGN();
        if (cGN != null) {
            if (cGN.aQX() || cGN.aQY()) {
                return false;
            }
            if (cGN.aUl() || cGN.aUm()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.cHc() != 0) {
                return pbData.cHc() != 3;
            }
            List<bq> cHj = pbData.cHj();
            if (w.getCount(cHj) > 0) {
                for (bq bqVar : cHj) {
                    if (bqVar != null && (zVar = bqVar.dKO) != null && zVar.dIC && !zVar.dID && (zVar.type == 1 || zVar.type == 2)) {
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

    private boolean rJ(boolean z) {
        if (z || this.kyB == null || this.kyB.cIe() == null || this.kyB.cIe().getPbData() == null) {
            return false;
        }
        return ((this.kyB.cIe().getPbData().getForum() != null && this.kyB.cIe().getPbData().getForum().isBlockBawuDelete) || this.kyB.cIe().getPbData().cHc() == 0 || this.kyB.cIe().getPbData().cHc() == 3) ? false : true;
    }

    private boolean cJg() {
        if (this.kyB == null || this.kyB.cIe() == null || !this.kyB.cIe().cKb()) {
            return false;
        }
        return this.kyB.cIe().getPageData() == null || this.kyB.cIe().getPageData().aRg() != 0;
    }

    public void a(ag agVar) {
        if (!this.kyB.getBaseFragmentActivity().isProgressBarShown()) {
            this.ksB = new af(this.kyB, this.kyB.aXG);
            this.ksA = new AlertDialog.Builder(this.kyB.getContext(), R.style.DialogTheme).create();
            this.ksA.setCanceledOnTouchOutside(true);
            com.baidu.adp.lib.f.g.showDialog(this.ksA, this.kyB.getFragmentActivity());
            Window window = this.ksA.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.ksB.getView());
            this.ksB.rV(agVar == null ? false : agVar.kke);
            this.ksB.rW(agVar == null ? false : agVar.kki);
            this.ksB.rX(agVar == null ? false : agVar.kkm);
            this.ksB.rZ(agVar == null ? false : agVar.kkj);
            this.ksB.sa(agVar == null ? true : agVar.kkg);
            if (agVar == null) {
                this.ksB.af(false, false);
                this.ksB.ag(false, false);
            } else {
                this.ksB.af(agVar.kkk, agVar.kkq);
                this.ksB.ag(agVar.kkl, agVar.kkp);
            }
            boolean z = agVar == null ? false : agVar.Ef;
            boolean z2 = agVar == null ? false : agVar.isHostOnly;
            boolean z3 = agVar == null ? false : agVar.kkh;
            boolean z4 = agVar == null ? false : agVar.kkf;
            boolean z5 = agVar == null ? false : agVar.kko;
            boolean z6 = agVar == null ? false : agVar.kkn;
            this.ksB.ae(z3, z2);
            this.ksB.ah(z4, z);
            this.ksB.ai(z6, z5);
            if (agVar != null) {
                this.ksB.kkb = agVar.kkr;
                if (agVar.kkr) {
                    this.ksB.cLl().setText(R.string.report_text);
                    this.ksB.rZ(false);
                }
            }
            this.ksB.rY(agVar != null ? agVar.kks : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.kyB.cIe() != null && this.kyB.cIe().getPbData() != null && this.kyB.cIe().getPbData().getThreadId() != null && this.kyB.cIe().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.ksB.cLo().setText(R.string.have_called_fans_short);
            }
            cNE();
        }
    }

    private void cNE() {
        if (this.ksB != null) {
            this.ksB.cLs();
        }
    }

    public void aFg() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.ksA != null) {
                        com.baidu.adp.lib.f.g.dismissDialog(a.this.ksA, a.this.kyB.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.lt().postDelayed(this.runnable, 100L);
    }

    public void cNF() {
        if (this.ksA != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.ksA, this.kyB.getPageContext().getPageActivity());
        }
    }

    public af cNG() {
        return this.ksB;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.kyB = videoPbFragment;
        this.kfL = videoPbFragment.getUniqueId();
        this.kfn = new com.baidu.tieba.pb.pb.report.a(this.kyB.getContext());
        this.kfn.w(this.kyB.getUniqueId());
        this.knU = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.16
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.kyB.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.kyB.cIe().getPbData().getUserData().getUserId());
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
                a.this.kyB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.kyB.getPageContext().getPageActivity(), a.this.kyB.cIe().getPbData().getForum().getId(), a.this.kyB.cIe().getPbData().getForum().getName(), a.this.kyB.cIe().getPbData().cGN().getId(), valueOf, str, str3, str2, str4)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(View view) {
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
            if (postData.getId() != null && postData.getId().equals(this.kyB.cIe().aSx())) {
                z = true;
            }
            MarkData o = this.kyB.cIe().o(postData);
            if (this.kyB.cIe().getPbData() != null && this.kyB.cIe().getPbData().cHp() && (I = this.kyB.I(this.kyB.cIe().getPbData())) != null) {
                o = this.kyB.cIe().o(I);
            }
            if (o != null) {
                this.kyB.cMi();
                if (this.kyB.cPl() != null) {
                    this.kyB.cPl().a(o);
                    if (!z) {
                        this.kyB.cPl().aOq();
                    } else {
                        this.kyB.cPl().aOp();
                    }
                }
            }
        }
    }

    public int h(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cGN() != null) {
            if (eVar.cGN().getThreadType() == 0) {
                return 1;
            }
            if (eVar.cGN().getThreadType() == 54) {
                return 2;
            }
            if (eVar.cGN().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rH(boolean z) {
        if (this.kyB.cIe() == null || this.kyB.cIe().getPbData() == null) {
            return false;
        }
        return ((this.kyB.cIe().getPbData().cHc() != 0) || this.kyB.cIe().getPbData().cGN() == null || this.kyB.cIe().getPbData().cGN().aSp() == null || TextUtils.equals(this.kyB.cIe().getPbData().cGN().aSp().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void JO(String str) {
        if (this.kyB.cIe() != null && this.kyB.cIe().getPbData() != null && this.kyB.cIe().getPbData().cHp()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.kyB.cIe().cJZ(), str);
            bu cGN = this.kyB.cIe().getPbData().cGN();
            if (cGN.aQX()) {
                format = format + "&channelid=33833";
            } else if (cGN.aUk()) {
                format = format + "&channelid=33842";
            } else if (cGN.aQY()) {
                format = format + "&channelid=33840";
            }
            JP(format);
            return;
        }
        this.kfn.Kp(str);
    }

    private void JP(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.kyB.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.kfv != null && this.kfv.isShowing()) {
                this.kfv.dismiss();
                this.kfv = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.kyB.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.kfv != null) {
                            a.this.kfv.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.kfL);
                            userMuteAddAndDelCustomMessage.setTag(a.this.kfL);
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
                kVar.aL(arrayList);
                this.kfv = new i(this.kyB.getPageContext(), kVar);
                this.kfv.showDialog();
            }
        }
    }

    public void cJB() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kyB.getPageContext().getPageActivity());
        aVar.we(this.kyB.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.19
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.kyB.getFragmentActivity(), 2, true, 4);
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
        aVar.b(this.kyB.getPageContext()).aUN();
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
        sparseArray.put(knn, Integer.valueOf(kno));
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
        this.kmw = new com.baidu.tbadk.core.dialog.a(this.kyB.getActivity());
        if (StringUtils.isNull(str2)) {
            this.kmw.kT(i3);
        } else {
            this.kmw.setOnlyMessageShowCenter(false);
            this.kmw.we(str2);
        }
        this.kmw.setYesButtonTag(sparseArray);
        this.kmw.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.kyB.a(aVar, (JSONArray) null);
            }
        });
        this.kmw.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kmw.hf(true);
        this.kmw.b(this.kyB.getPageContext());
        if (z) {
            this.kmw.aUN();
        } else {
            a(this.kmw, i);
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.kyB != null && aVar != null) {
            if (this.ieU == null && this.kyB.getView() != null) {
                this.ieU = new e(this.kyB.getPageContext(), this.kyB.getView());
            }
            AntiData bXd = bXd();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bXd != null && bXd.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bXd.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            ap apVar = new ap();
            apVar.setFeedBackReasonMap(sparseArray);
            this.ieU.setDefaultReasonArray(new String[]{this.kyB.getString(R.string.delete_thread_reason_1), this.kyB.getString(R.string.delete_thread_reason_2), this.kyB.getString(R.string.delete_thread_reason_3), this.kyB.getString(R.string.delete_thread_reason_4), this.kyB.getString(R.string.delete_thread_reason_5)});
            this.ieU.setData(apVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.ieU.zC(str);
            this.ieU.a(new e.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void T(JSONArray jSONArray) {
                    a.this.kyB.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData bXd() {
        if (this.kyB.cIe() == null || this.kyB.cIe().getPbData() == null) {
            return null;
        }
        return this.kyB.cIe().getPbData().getAnti();
    }

    public void cJ(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        g gVar;
        g gVar2;
        k kVar = new k(this.kyB.getContext());
        kVar.setTitleText(this.kyB.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.kmv.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (a.this.knU != null) {
                                a.this.knU.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
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
        int i = -1;
        if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
            i = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
        }
        if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && i != 2) {
            int i2 = -1;
            if (sparseArray.get(R.id.tag_del_post_type) instanceof Integer) {
                i2 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
            }
            if (i2 == 0) {
                gVar2 = new g(0, this.kyB.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new g(0, this.kyB.getString(R.string.delete), kVar);
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
            g gVar3 = new g(1, this.kyB.getString(R.string.forbidden_person), kVar);
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
                gVar = new g(2, this.kyB.getString(R.string.un_mute), kVar);
            } else {
                gVar = new g(2, this.kyB.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.aL(arrayList);
        if (this.kmv == null) {
            this.kmv = new i(this.kyB.getPageContext(), kVar);
        } else {
            this.kmv.a(kVar);
        }
        this.kmv.showDialog();
    }

    public void cIY() {
        if (this.keT == null) {
            this.keT = new com.baidu.tbadk.core.dialog.b(this.kyB.getPageContext().getPageActivity());
            this.keT.a(new String[]{this.kyB.getPageContext().getString(R.string.call_phone), this.kyB.getPageContext().getString(R.string.sms_phone), this.kyB.getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.videopb.b.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.kyB.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.kbB = a.this.kbB.trim();
                        UtilHelper.callPhone(a.this.kyB.getPageContext().getPageActivity(), a.this.kbB);
                        new com.baidu.tieba.pb.pb.main.b(a.this.kyB.cIe().cJZ(), a.this.kbB, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.kyB.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.kbB = a.this.kbB.trim();
                        UtilHelper.smsPhone(a.this.kyB.getPageContext().getPageActivity(), a.this.kbB);
                        new com.baidu.tieba.pb.pb.main.b(a.this.kyB.cIe().cJZ(), a.this.kbB, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.kbB = a.this.kbB.trim();
                        UtilHelper.startBaiDuBar(a.this.kyB.getPageContext().getPageActivity(), a.this.kbB);
                        bVar.dismiss();
                    }
                }
            }).kY(R.style.dialog_ani_b2t).kZ(17).d(this.kyB.getPageContext());
        }
    }

    public void cQ(final View view) {
        String[] strArr;
        int i = 0;
        if (this.kyB != null && this.kyB.cIe() != null) {
            final i iVar = new i(this.kyB.getPageContext());
            if (this.kyB.cIe().getPbData().jYL == null || this.kyB.cIe().getPbData().jYL.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.kyB.cIe().getPbData().jYL.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.kyB.cIe().getPbData().jYL.size()) {
                        break;
                    }
                    strArr2[i2] = this.kyB.cIe().getPbData().jYL.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.kyB.cIe().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.kyB.cIe().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.kyB.cIe().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.kyB.cIe().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new ao("c12097").ag("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).ag("obj_type", i4));
                    if (a.this.kyB.cIe().getPbData().jYL != null && a.this.kyB.cIe().getPbData().jYL.size() > i3) {
                        i3 = a.this.kyB.cIe().getPbData().jYL.get(i3).sort_type.intValue();
                    }
                    boolean Bu = a.this.kyB.cIe().Bu(i3);
                    view.setTag(Integer.valueOf(a.this.kyB.cIe().cKs()));
                    if (Bu) {
                        a.this.kyB.setIsLoading(true);
                    }
                }
            });
            iVar.showDialog();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kyB.getActivity());
            aVar.wd(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.we(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.hf(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new ao("c12528").dk("obj_id", metaData.getUserId()).ag("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new ao("c12528").dk("obj_id", metaData.getUserId()).ag("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.kyB.cPw() != null) {
                        a.this.kyB.cPw().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.kyB.getPageContext().getUniqueId(), a.this.kyB.cIe().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.kyB.getPageContext()).aUN();
            TiebaStatic.log(new ao("c12527"));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.kfL);
        userMuteAddAndDelCustomMessage.setTag(this.kfL);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void yH(String str) {
        if (str == null) {
            str = "";
        }
        if (this.kyB != null && this.kyB.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kyB.getPageContext().getPageActivity());
            aVar.we(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.kyB.getPageContext()).aUN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.kyB.getBaseFragmentActivity());
        if (ar.isEmpty(str)) {
            aVar.we(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.we(str);
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
        aVar.b(this.kyB.getPageContext()).aUN();
    }

    public void showLoadingDialog() {
        if (this.gXx == null) {
            this.gXx = new com.baidu.tbadk.core.view.a(this.kyB.getPageContext());
        }
        this.gXx.setDialogVisiable(true);
    }

    public void bJm() {
        if (this.gXx != null) {
            this.gXx.setDialogVisiable(false);
        }
    }

    public void a(final b.a aVar, boolean z) {
        if (this.kmE != null) {
            this.kmE.dismiss();
            this.kmE = null;
        }
        k kVar = new k(this.kyB.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.kyB.cIe().getPbData() != null && this.kyB.cIe().getPbData().cGN() != null && !this.kyB.cIe().getPbData().cGN().isBjh()) {
            arrayList.add(new g(0, this.kyB.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new g(1, this.kyB.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.aL(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.kmE.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.kmE = new i(this.kyB.getPageContext(), kVar);
        this.kmE.showDialog();
    }

    public void aQ(ArrayList<ah> arrayList) {
        if (this.kmz == null) {
            this.kmz = LayoutInflater.from(this.kyB.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.kyB.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.kmz);
        if (this.kmy == null) {
            this.kmy = new Dialog(this.kyB.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.kmy.setCanceledOnTouchOutside(true);
            this.kmy.setCancelable(true);
            this.kmH = (ScrollView) this.kmz.findViewById(R.id.good_scroll);
            this.kmy.setContentView(this.kmz);
            WindowManager.LayoutParams attributes = this.kmy.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.kmy.getWindow().setAttributes(attributes);
            this.gTD = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.14
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.kmD = (String) compoundButton.getTag();
                        if (a.this.gTC != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.gTC) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.kmD != null && !str.equals(a.this.kmD)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.kmA = (LinearLayout) this.kmz.findViewById(R.id.good_class_group);
            this.kmC = (TextView) this.kmz.findViewById(R.id.dialog_button_cancel);
            this.kmC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.kmy instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(a.this.kmy, a.this.kyB.getPageContext());
                    }
                }
            });
            this.kmB = (TextView) this.kmz.findViewById(R.id.dialog_button_ok);
            this.kmB.setOnClickListener(this.kyB.cPm());
        }
        this.kmA.removeAllViews();
        this.gTC = new ArrayList();
        CustomBlueCheckRadioButton fa = fa("0", this.kyB.getPageContext().getString(R.string.thread_good_class));
        this.gTC.add(fa);
        fa.setChecked(true);
        this.kmA.addView(fa);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                ah ahVar = arrayList.get(i2);
                if (ahVar != null && !TextUtils.isEmpty(ahVar.aQD()) && ahVar.aQE() > 0) {
                    CustomBlueCheckRadioButton fa2 = fa(String.valueOf(ahVar.aQE()), ahVar.aQD());
                    this.gTC.add(fa2);
                    View view = new View(this.kyB.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    an.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.kmA.addView(view);
                    this.kmA.addView(fa2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.kmH.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.kyB.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.kyB.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.kyB.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.kmH.setLayoutParams(layoutParams2);
            this.kmH.removeAllViews();
            if (this.kmA != null && this.kmA.getParent() == null) {
                this.kmH.addView(this.kmA);
            }
        }
        com.baidu.adp.lib.f.g.a(this.kmy, this.kyB.getPageContext());
    }

    private CustomBlueCheckRadioButton fa(String str, String str2) {
        Activity pageActivity = this.kyB.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.gTD);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public boolean cE(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.kfL;
        userMuteCheckCustomMessage.setTag(this.kfL);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void cMD() {
        if (this.kmw != null) {
            this.kmw.dismiss();
        }
        if (this.kmx != null) {
            com.baidu.adp.lib.f.g.b(this.kmx, this.kyB.getPageContext());
        }
        if (this.kmy != null) {
            com.baidu.adp.lib.f.g.b(this.kmy, this.kyB.getPageContext());
        }
        if (this.kmv != null) {
            this.kmv.dismiss();
        }
    }

    public void cPZ() {
        if (this.kfv != null) {
            this.kfv.dismiss();
        }
    }

    public void cMC() {
        aFg();
        this.kyB.cLJ();
        if (this.kfv != null) {
            this.kfv.dismiss();
        }
        cMD();
    }

    public void cMB() {
        aFg();
        this.kyB.cLJ();
        if (this.kfv != null) {
            this.kfv.dismiss();
        }
        this.kyB.bYx();
        cMD();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener cPo() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b cQa() {
        return this.keT;
    }

    public void setPhoneNumber(String str) {
        this.kbB = str;
    }

    public String cMh() {
        return this.kmD;
    }

    public View cMg() {
        if (this.kmz != null) {
            return this.kmz.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
