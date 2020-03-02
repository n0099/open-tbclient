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
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
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
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.pb.main.y;
import com.baidu.tieba.pb.pb.main.z;
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
    public static int iOU = 3;
    public static int iOV = 0;
    public static int iOW = 3;
    public static int iOX = 4;
    public static int iOY = 5;
    public static int iOZ = 6;
    private List<CustomBlueCheckRadioButton> fLU;
    private ar gQB;
    private e gQj;
    private String iEe;
    private com.baidu.tieba.pb.pb.report.a iHA;
    private i iHI;
    private k iHJ;
    public BdUniqueId iHY;
    private com.baidu.adp.widget.ImageView.a iIa;
    private String iIb;
    private TbRichTextMemeInfo iIc;
    private PbFragment.b iPC;
    public VideoPbFragment iZV;
    private Object mExtra;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    private Runnable runnable;
    private i iOp = null;
    private com.baidu.tbadk.core.dialog.a iOh = null;
    private Dialog iOi = null;
    private Dialog iOj = null;
    private View iOk = null;
    private LinearLayout iOl = null;
    private TextView iOm = null;
    private TextView iOn = null;
    private String iOo = null;
    private ScrollView iOs = null;
    private CompoundButton.OnCheckedChangeListener fLV = null;
    private i iOg = null;
    private com.baidu.tbadk.core.view.a fPV = null;
    private com.baidu.tbadk.core.dialog.b iHh = null;
    private AlertDialog iTT = null;
    private y iTU = null;
    PostData hhz = null;
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
            if (a.this.iZV == null || !a.this.iZV.isAdded()) {
                return true;
            }
            SparseArray sparseArray2 = null;
            try {
                sparseArray2 = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray2 == null) {
                if (a.this.cv(view)) {
                    if (view instanceof TbImageView) {
                        a.this.iIa = ((TbImageView) view).getBdImage();
                        a.this.iIb = ((TbImageView) view).getUrl();
                        if (a.this.iIa == null || TextUtils.isEmpty(a.this.iIb)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.iIc = null;
                        } else {
                            a.this.iIc = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            a.this.iIa = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                a.this.iIb = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                a.this.iIc = null;
                            } else {
                                a.this.iIc = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        a.this.iIa = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            a.this.iIb = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.iIc = null;
                        } else {
                            a.this.iIc = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        a.this.a(a.this.iIK, a.this.iIa.isGif());
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
            a.this.hhz = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (a.this.hhz == null || a.this.iZV.csH() == null) {
                return true;
            }
            if (!a.this.iZV.csH().ayL() || a.this.hhz.getId() == null || !a.this.hhz.getId().equals(a.this.iZV.clB().aCx())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = a.this.iZV.clB().getPbData() != null && a.this.iZV.clB().getPbData().ckS();
            if (a.this.iHJ == null) {
                a.this.iHJ = new k(a.this.iZV.getContext());
                a.this.iHJ.a(a.this.iIL);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = a.this.cv(view) && !z3;
                boolean z5 = (!a.this.cv(view) || a.this.iIa == null || a.this.iIa.isGif()) ? false : true;
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
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), a.this.iHJ));
                }
                if (z5) {
                    arrayList.add(new g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), a.this.iHJ));
                }
                if (!z4 && !z5) {
                    g gVar3 = new g(3, TbadkCoreApplication.getInst().getString(R.string.copy), a.this.iHJ);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, a.this.hhz);
                    gVar3.mTextView.setTag(sparseArray3);
                    arrayList.add(gVar3);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), a.this.iHJ);
                    } else {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.mark), a.this.iHJ);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, a.this.hhz);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar2.mTextView.setTag(sparseArray4);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z8 && z7) {
                        g gVar4 = new g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), a.this.iHJ);
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
                        if ((a.this.pL(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                            g gVar5 = new g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.iHJ);
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
                            gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.iHJ);
                            gVar6.mTextView.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), a.this.iHJ);
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
                            if (a.this.iZV.clB().getPbData().ckG() == 1002 && !z6) {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.iHJ);
                            } else {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.iHJ);
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
                a.this.iHJ.az(arrayList);
                a.this.iHI = new i(a.this.iZV.getPageContext(), a.this.iHJ);
                a.this.iHI.showDialog();
                TiebaStatic.log(new an("c13272").cy("tid", a.this.iZV.clB().cny()).cy("fid", a.this.iZV.clB().getForumId()).cy("uid", a.this.iZV.clB().getPbData().cku().aCo().getUserId()).cy("post_id", a.this.iZV.clB().aOO()).X("obj_source", z2 ? 2 : 1));
            }
            return true;
        }
    };
    private k.c iIL = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.17
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            int i2;
            if (a.this.iHI != null) {
                a.this.iHI.dismiss();
            }
            switch (i) {
                case 1:
                    if (a.this.iIa != null && !TextUtils.isEmpty(a.this.iIb)) {
                        if (a.this.iIc == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.iIb));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.iIb;
                            aVar.pkgId = a.this.iIc.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.iIc.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.iIa = null;
                        a.this.iIb = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.iIa != null && !TextUtils.isEmpty(a.this.iIb)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.iZV.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.iZV.getPageContext().getPageActivity())) {
                            if (a.this.gQB == null) {
                                a.this.gQB = new ar(a.this.iZV.getPageContext());
                            }
                            a.this.gQB.j(a.this.iIb, a.this.iIa.getImageByte());
                            a.this.iIa = null;
                            a.this.iIb = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.hhz != null) {
                        a.this.hhz.fv(a.this.iZV.getPageContext().getPageActivity());
                        a.this.hhz = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new an("c11739").X("obj_locate", 2));
                    if (a.this.iZV.checkUpIsLogin()) {
                        a.this.cu(view);
                        if (a.this.iZV.clB().getPbData().cku() != null && a.this.iZV.clB().getPbData().cku().aCo() != null && a.this.iZV.clB().getPbData().cku().aCo().getUserId() != null && a.this.iZV.csH() != null) {
                            int g = a.this.g(a.this.iZV.clB().getPbData());
                            bj cku = a.this.iZV.clB().getPbData().cku();
                            if (cku.aBd()) {
                                i2 = 2;
                            } else if (cku.aBe()) {
                                i2 = 3;
                            } else if (cku.aEg()) {
                                i2 = 4;
                            } else {
                                i2 = cku.aEh() ? 5 : 1;
                            }
                            TiebaStatic.log(new an("c12526").cy("tid", a.this.iZV.clB().cny()).X("obj_locate", 2).cy("obj_id", a.this.iZV.clB().getPbData().cku().aCo().getUserId()).X("obj_type", a.this.iZV.csH().ayL() ? 0 : 1).X("obj_source", g).X("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.iZV.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new an("c13079"));
                        a.this.FP((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new an("c11739").X("obj_locate", 4));
                        SparseArray<Object> sparseArray = (SparseArray) tag;
                        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray.put(R.id.tag_from, 0);
                            sparseArray.put(R.id.tag_check_mute_from, 2);
                            a.this.b(sparseArray);
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
                        a.this.iZV.showToast(R.string.network_not_available);
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
                                a.this.b(sparseArray3);
                                return;
                            }
                            sparseArray3.put(R.id.tag_check_mute_from, 2);
                            a.this.cA(view);
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
    private final b.a iIK = new b.a() { // from class: com.baidu.tieba.pb.videopb.b.a.21
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.iIa != null && !TextUtils.isEmpty(a.this.iIb)) {
                if (i == 0) {
                    if (a.this.iIc == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.iIb));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.iIb;
                        aVar.pkgId = a.this.iIc.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.iIc.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.iZV.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.iZV.getPageContext().getPageActivity())) {
                        if (a.this.gQB == null) {
                            a.this.gQB = new ar(a.this.iZV.getPageContext());
                        }
                        a.this.gQB.j(a.this.iIb, a.this.iIa.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.iIa = null;
                a.this.iIb = null;
            }
        }
    };

    public void cmF() {
        com.baidu.tieba.pb.data.e pbData;
        bj cku;
        if (this.iZV != null && this.iZV.clB() != null && this.iZV.clB().getPbData() != null && (cku = (pbData = this.iZV.clB().getPbData()).cku()) != null && cku.aCo() != null) {
            this.iZV.cpg();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cku.aCo().getUserId());
            z zVar = new z();
            int ckG = this.iZV.clB().getPbData().ckG();
            if (ckG == 1 || ckG == 3) {
                zVar.iMb = true;
                zVar.iMa = true;
                zVar.iMg = cku.aCj() == 1;
                zVar.iMf = cku.aCk() == 1;
            } else {
                zVar.iMb = false;
                zVar.iMa = false;
            }
            if (ckG == 1002 && !equals) {
                zVar.iMh = true;
            }
            zVar.iLY = pM(equals);
            zVar.iMc = cmG();
            zVar.iLZ = pN(equals);
            zVar.hW = this.iZV.clB().cnz();
            zVar.iLV = true;
            zVar.iLU = pL(equals);
            zVar.iMe = TbadkCoreApplication.getInst().getSkinType() == 1;
            zVar.iMd = true;
            zVar.isHostOnly = this.iZV.clB().getHostMode();
            zVar.iLX = true;
            if (cku.aCF() == null) {
                zVar.iLW = true;
            } else {
                zVar.iLW = false;
            }
            if (pbData.ckS()) {
                zVar.iLV = false;
                zVar.iLX = false;
                zVar.iLW = false;
                zVar.iMa = false;
                zVar.iMb = false;
            }
            a(zVar);
        }
    }

    private boolean pM(boolean z) {
        boolean z2;
        w wVar;
        if (this.iZV == null || this.iZV.clB() == null || this.iZV.clB().getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.e pbData = this.iZV.clB().getPbData();
        bj cku = pbData.cku();
        if (cku != null) {
            if (cku.aBd() || cku.aBe()) {
                return false;
            }
            if (cku.aEg() || cku.aEh()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.ckG() != 0) {
                return pbData.ckG() != 3;
            }
            List<bf> ckN = pbData.ckN();
            if (v.getCount(ckN) > 0) {
                for (bf bfVar : ckN) {
                    if (bfVar != null && (wVar = bfVar.cQP) != null && wVar.cOJ && !wVar.cOK && (wVar.type == 1 || wVar.type == 2)) {
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

    private boolean pN(boolean z) {
        if (z || this.iZV == null || this.iZV.clB() == null || this.iZV.clB().getPbData() == null) {
            return false;
        }
        return ((this.iZV.clB().getPbData().getForum() != null && this.iZV.clB().getPbData().getForum().isBlockBawuDelete) || this.iZV.clB().getPbData().ckG() == 0 || this.iZV.clB().getPbData().ckG() == 3) ? false : true;
    }

    private boolean cmG() {
        if (this.iZV == null || this.iZV.clB() == null || !this.iZV.clB().cnz()) {
            return false;
        }
        return this.iZV.clB().getPageData() == null || this.iZV.clB().getPageData().aBl() != 0;
    }

    public void a(z zVar) {
        if (!this.iZV.getBaseFragmentActivity().isProgressBarShown()) {
            this.iTU = new y(this.iZV, this.iZV.auX);
            this.iTT = new AlertDialog.Builder(this.iZV.getContext(), R.style.DialogTheme).create();
            this.iTT.setCanceledOnTouchOutside(true);
            com.baidu.adp.lib.f.g.showDialog(this.iTT, this.iZV.getFragmentActivity());
            Window window = this.iTT.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.iTU.getView());
            this.iTU.pZ(zVar == null ? false : zVar.iLU);
            this.iTU.qa(zVar == null ? false : zVar.iLY);
            this.iTU.qb(zVar == null ? false : zVar.iMc);
            this.iTU.qc(zVar == null ? false : zVar.iLZ);
            this.iTU.qd(zVar == null ? true : zVar.iLW);
            if (zVar == null) {
                this.iTU.aa(false, false);
                this.iTU.ab(false, false);
            } else {
                this.iTU.aa(zVar.iMa, zVar.iMg);
                this.iTU.ab(zVar.iMb, zVar.iMf);
            }
            boolean z = zVar == null ? false : zVar.hW;
            boolean z2 = zVar == null ? false : zVar.isHostOnly;
            boolean z3 = zVar == null ? false : zVar.iLX;
            boolean z4 = zVar == null ? false : zVar.iLV;
            boolean z5 = zVar == null ? false : zVar.iMe;
            boolean z6 = zVar == null ? false : zVar.iMd;
            this.iTU.Z(z3, z2);
            this.iTU.ac(z4, z);
            this.iTU.ad(z6, z5);
            if (zVar != null) {
                this.iTU.iLR = zVar.iMh;
                if (zVar.iMh) {
                    this.iTU.coJ().setText(R.string.report_text);
                    this.iTU.qc(false);
                }
            }
            cra();
        }
    }

    private void cra() {
        if (this.iTU != null) {
            this.iTU.coP();
        }
    }

    public void arU() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.iTT != null) {
                        com.baidu.adp.lib.f.g.dismissDialog(a.this.iTT, a.this.iZV.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.gx().postDelayed(this.runnable, 100L);
    }

    public void crb() {
        if (this.iTT != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.iTT, this.iZV.getPageContext().getPageActivity());
        }
    }

    public y crc() {
        return this.iTU;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.iZV = videoPbFragment;
        this.iHY = videoPbFragment.getUniqueId();
        this.iHA = new com.baidu.tieba.pb.pb.report.a(this.iZV.getContext());
        this.iHA.t(this.iZV.getUniqueId());
        this.iPC = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.16
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.iZV.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.iZV.clB().getPbData().getUserData().getUserId());
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
                a.this.iZV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.iZV.getPageContext().getPageActivity(), a.this.iZV.clB().getPbData().getForum().getId(), a.this.iZV.clB().getPbData().getForum().getName(), a.this.iZV.clB().getPbData().cku().getId(), valueOf, str, str3, str2, str4)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cu(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            k(postData);
        }
    }

    protected void k(PostData postData) {
        PostData F;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.iZV.clB().aCx())) {
                z = true;
            }
            MarkData l = this.iZV.clB().l(postData);
            if (this.iZV.clB().getPbData() != null && this.iZV.clB().getPbData().ckS() && (F = this.iZV.F(this.iZV.clB().getPbData())) != null) {
                l = this.iZV.clB().l(F);
            }
            if (l != null) {
                this.iZV.cpF();
                if (this.iZV.csH() != null) {
                    this.iZV.csH().a(l);
                    if (!z) {
                        this.iZV.csH().ayN();
                    } else {
                        this.iZV.csH().ayM();
                    }
                }
            }
        }
    }

    public int g(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cku() != null) {
            if (eVar.cku().getThreadType() == 0) {
                return 1;
            }
            if (eVar.cku().getThreadType() == 54) {
                return 2;
            }
            if (eVar.cku().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pL(boolean z) {
        if (this.iZV.clB() == null || this.iZV.clB().getPbData() == null) {
            return false;
        }
        return ((this.iZV.clB().getPbData().ckG() != 0) || this.iZV.clB().getPbData().cku() == null || this.iZV.clB().getPbData().cku().aCo() == null || TextUtils.equals(this.iZV.clB().getPbData().cku().aCo().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void FP(String str) {
        if (this.iZV.clB() != null && this.iZV.clB().getPbData() != null && this.iZV.clB().getPbData().ckS()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.iZV.clB().cny(), str);
            bj cku = this.iZV.clB().getPbData().cku();
            if (cku.aBd()) {
                format = format + "&channelid=33833";
            } else if (cku.aEf()) {
                format = format + "&channelid=33842";
            } else if (cku.aBe()) {
                format = format + "&channelid=33840";
            }
            FQ(format);
            return;
        }
        this.iHA.Gp(str);
    }

    private void FQ(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.iZV.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.iHI != null && this.iHI.isShowing()) {
                this.iHI.dismiss();
                this.iHI = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.iZV.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.iHI != null) {
                            a.this.iHI.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.iHY);
                            userMuteAddAndDelCustomMessage.setTag(a.this.iHY);
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
                kVar.az(arrayList);
                this.iHI = new i(this.iZV.getPageContext(), kVar);
                this.iHI.showDialog();
            }
        }
    }

    public void cnb() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iZV.getPageContext().getPageActivity());
        aVar.sS(this.iZV.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.19
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.iZV.getFragmentActivity(), 2, true, 4);
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
        aVar.b(this.iZV.getPageContext()).aEC();
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
        sparseArray.put(iOV, Integer.valueOf(iOW));
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
        this.iOh = new com.baidu.tbadk.core.dialog.a(this.iZV.getActivity());
        if (StringUtils.isNull(str2)) {
            this.iOh.jW(i3);
        } else {
            this.iOh.setOnlyMessageShowCenter(false);
            this.iOh.sS(str2);
        }
        this.iOh.setYesButtonTag(sparseArray);
        this.iOh.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.iZV.a(aVar, (JSONArray) null);
            }
        });
        this.iOh.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.iOh.fG(true);
        this.iOh.b(this.iZV.getPageContext());
        if (z) {
            this.iOh.aEC();
        } else {
            a(this.iOh, i);
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.iZV != null && aVar != null) {
            if (this.gQj == null && this.iZV.getView() != null) {
                this.gQj = new e(this.iZV.getPageContext(), this.iZV.getView());
            }
            AntiData bCY = bCY();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bCY != null && bCY.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bCY.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray);
            this.gQj.setDefaultReasonArray(new String[]{this.iZV.getString(R.string.delete_thread_reason_1), this.iZV.getString(R.string.delete_thread_reason_2), this.iZV.getString(R.string.delete_thread_reason_3), this.iZV.getString(R.string.delete_thread_reason_4), this.iZV.getString(R.string.delete_thread_reason_5)});
            this.gQj.setData(alVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.gQj.wm(str);
            this.gQj.a(new e.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray) {
                    a.this.iZV.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData bCY() {
        if (this.iZV.clB() == null || this.iZV.clB().getPbData() == null) {
            return null;
        }
        return this.iZV.clB().getPbData().getAnti();
    }

    public void cA(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        g gVar;
        g gVar2;
        k kVar = new k(this.iZV.getContext());
        kVar.setTitleText(this.iZV.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.iOg.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (a.this.iPC != null) {
                                a.this.iPC.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
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
                gVar2 = new g(0, this.iZV.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new g(0, this.iZV.getString(R.string.delete), kVar);
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
            g gVar3 = new g(1, this.iZV.getString(R.string.forbidden_person), kVar);
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
                gVar = new g(2, this.iZV.getString(R.string.un_mute), kVar);
            } else {
                gVar = new g(2, this.iZV.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.az(arrayList);
        if (this.iOg == null) {
            this.iOg = new i(this.iZV.getPageContext(), kVar);
        } else {
            this.iOg.a(kVar);
        }
        this.iOg.showDialog();
    }

    public void cmx() {
        if (this.iHh == null) {
            this.iHh = new com.baidu.tbadk.core.dialog.b(this.iZV.getPageContext().getPageActivity());
            this.iHh.a(new String[]{this.iZV.getPageContext().getString(R.string.call_phone), this.iZV.getPageContext().getString(R.string.sms_phone), this.iZV.getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.videopb.b.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.iZV.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.iEe = a.this.iEe.trim();
                        UtilHelper.callPhone(a.this.iZV.getPageContext().getPageActivity(), a.this.iEe);
                        new com.baidu.tieba.pb.pb.main.a(a.this.iZV.clB().cny(), a.this.iEe, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.iZV.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.iEe = a.this.iEe.trim();
                        UtilHelper.smsPhone(a.this.iZV.getPageContext().getPageActivity(), a.this.iEe);
                        new com.baidu.tieba.pb.pb.main.a(a.this.iZV.clB().cny(), a.this.iEe, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.iEe = a.this.iEe.trim();
                        UtilHelper.startBaiDuBar(a.this.iZV.getPageContext().getPageActivity(), a.this.iEe);
                        bVar.dismiss();
                    }
                }
            }).kb(R.style.dialog_ani_b2t).kc(17).d(this.iZV.getPageContext());
        }
    }

    public void cG(final View view) {
        String[] strArr;
        int i = 0;
        if (this.iZV != null && this.iZV.clB() != null) {
            final i iVar = new i(this.iZV.getPageContext());
            if (this.iZV.clB().getPbData().iBD == null || this.iZV.clB().getPbData().iBD.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.iZV.clB().getPbData().iBD.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.iZV.clB().getPbData().iBD.size()) {
                        break;
                    }
                    strArr2[i2] = this.iZV.clB().getPbData().iBD.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.iZV.clB().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.iZV.clB().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.iZV.clB().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.iZV.clB().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new an("c12097").X("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).X("obj_type", i4));
                    if (a.this.iZV.clB().getPbData().iBD != null && a.this.iZV.clB().getPbData().iBD.size() > i3) {
                        i3 = a.this.iZV.clB().getPbData().iBD.get(i3).sort_type.intValue();
                    }
                    boolean yW = a.this.iZV.clB().yW(i3);
                    view.setTag(Integer.valueOf(a.this.iZV.clB().cnQ()));
                    if (yW) {
                        a.this.iZV.setIsLoading(true);
                    }
                }
            });
            iVar.showDialog();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iZV.getActivity());
            aVar.sR(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.sS(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.fG(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new an("c12528").cy("obj_id", metaData.getUserId()).X("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new an("c12528").cy("obj_id", metaData.getUserId()).X("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.iZV.csS() != null) {
                        a.this.iZV.csS().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.iZV.getPageContext().getUniqueId(), a.this.iZV.clB().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.iZV.getPageContext()).aEC();
            TiebaStatic.log(new an("c12527"));
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.iHY);
        userMuteAddAndDelCustomMessage.setTag(this.iHY);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void vq(String str) {
        if (str == null) {
            str = "";
        }
        if (this.iZV != null && this.iZV.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iZV.getPageContext().getPageActivity());
            aVar.sS(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.iZV.getPageContext()).aEC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iZV.getBaseFragmentActivity());
        if (aq.isEmpty(str)) {
            aVar.sS(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.sS(str);
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
        aVar.b(this.iZV.getPageContext()).aEC();
    }

    public void showLoadingDialog() {
        if (this.fPV == null) {
            this.fPV = new com.baidu.tbadk.core.view.a(this.iZV.getPageContext());
        }
        this.fPV.setDialogVisiable(true);
    }

    public void bqr() {
        if (this.fPV != null) {
            this.fPV.setDialogVisiable(false);
        }
    }

    public void a(final b.a aVar, boolean z) {
        if (this.iOp != null) {
            this.iOp.dismiss();
            this.iOp = null;
        }
        k kVar = new k(this.iZV.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.iZV.clB().getPbData() != null && this.iZV.clB().getPbData().cku() != null && !this.iZV.clB().getPbData().cku().isBjh()) {
            arrayList.add(new g(0, this.iZV.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new g(1, this.iZV.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.az(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.iOp.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.iOp = new i(this.iZV.getPageContext(), kVar);
        this.iOp.showDialog();
    }

    public void aM(ArrayList<ad> arrayList) {
        if (this.iOk == null) {
            this.iOk = LayoutInflater.from(this.iZV.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.iZV.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.iOk);
        if (this.iOj == null) {
            this.iOj = new Dialog(this.iZV.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.iOj.setCanceledOnTouchOutside(true);
            this.iOj.setCancelable(true);
            this.iOs = (ScrollView) this.iOk.findViewById(R.id.good_scroll);
            this.iOj.setContentView(this.iOk);
            WindowManager.LayoutParams attributes = this.iOj.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.iOj.getWindow().setAttributes(attributes);
            this.fLV = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.14
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.iOo = (String) compoundButton.getTag();
                        if (a.this.fLU != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.fLU) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.iOo != null && !str.equals(a.this.iOo)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.iOl = (LinearLayout) this.iOk.findViewById(R.id.good_class_group);
            this.iOn = (TextView) this.iOk.findViewById(R.id.dialog_button_cancel);
            this.iOn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.iOj instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(a.this.iOj, a.this.iZV.getPageContext());
                    }
                }
            });
            this.iOm = (TextView) this.iOk.findViewById(R.id.dialog_button_ok);
            this.iOm.setOnClickListener(this.iZV.csI());
        }
        this.iOl.removeAllViews();
        this.fLU = new ArrayList();
        CustomBlueCheckRadioButton ef = ef("0", this.iZV.getPageContext().getString(R.string.thread_good_class));
        this.fLU.add(ef);
        ef.setChecked(true);
        this.iOl.addView(ef);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                ad adVar = arrayList.get(i2);
                if (adVar != null && !TextUtils.isEmpty(adVar.aAJ()) && adVar.aAK() > 0) {
                    CustomBlueCheckRadioButton ef2 = ef(String.valueOf(adVar.aAK()), adVar.aAJ());
                    this.fLU.add(ef2);
                    View view = new View(this.iZV.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    am.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.iOl.addView(view);
                    this.iOl.addView(ef2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.iOs.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.iZV.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.iZV.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.iZV.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.iOs.setLayoutParams(layoutParams2);
            this.iOs.removeAllViews();
            if (this.iOl != null && this.iOl.getParent() == null) {
                this.iOs.addView(this.iOl);
            }
        }
        com.baidu.adp.lib.f.g.a(this.iOj, this.iZV.getPageContext());
    }

    private CustomBlueCheckRadioButton ef(String str, String str2) {
        Activity pageActivity = this.iZV.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.fLV);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public boolean cv(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.iHY;
        userMuteCheckCustomMessage.setTag(this.iHY);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void cqa() {
        if (this.iOh != null) {
            this.iOh.dismiss();
        }
        if (this.iOi != null) {
            com.baidu.adp.lib.f.g.b(this.iOi, this.iZV.getPageContext());
        }
        if (this.iOj != null) {
            com.baidu.adp.lib.f.g.b(this.iOj, this.iZV.getPageContext());
        }
        if (this.iOg != null) {
            this.iOg.dismiss();
        }
    }

    public void ctv() {
        if (this.iHI != null) {
            this.iHI.dismiss();
        }
    }

    public void cpZ() {
        arU();
        this.iZV.cpg();
        if (this.iHI != null) {
            this.iHI.dismiss();
        }
        cqa();
    }

    public void cpY() {
        arU();
        this.iZV.cpg();
        if (this.iHI != null) {
            this.iHI.dismiss();
        }
        this.iZV.bEl();
        cqa();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener csK() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b ctw() {
        return this.iHh;
    }

    public void setPhoneNumber(String str) {
        this.iEe = str;
    }

    public String cpE() {
        return this.iOo;
    }

    public View cpD() {
        if (this.iOk != null) {
            return this.iOk.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
