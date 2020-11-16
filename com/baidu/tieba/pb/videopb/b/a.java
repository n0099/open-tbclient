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
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.g;
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
    public static int lCC = 3;
    public static int lCD = 0;
    public static int lCE = 3;
    public static int lCF = 4;
    public static int lCG = 5;
    public static int lCH = 6;
    private e ePS;
    private com.baidu.tbadk.core.message.a eQi;
    private bd euQ;
    private List<CustomBlueCheckRadioButton> iaX;
    private com.baidu.tieba.NEGFeedBack.e jox;
    private PbFragment.b lDl;
    public VideoPbFragment lOb;
    private String lqd;
    public BdUniqueId luB;
    private com.baidu.adp.widget.ImageView.a luD;
    private String luE;
    private TbRichTextMemeInfo luF;
    private com.baidu.tieba.pb.pb.report.a lue;
    private i lul;
    private k lum;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    private Runnable runnable;
    private i lBU = null;
    private com.baidu.tbadk.core.dialog.a lBM = null;
    private Dialog lBN = null;
    private Dialog lBO = null;
    private View lBP = null;
    private LinearLayout lBQ = null;
    private TextView lBR = null;
    private TextView lBS = null;
    private String lBT = null;
    private ScrollView lBX = null;
    private CompoundButton.OnCheckedChangeListener iaY = null;
    private i lBL = null;
    private com.baidu.tbadk.core.view.a ifn = null;
    private com.baidu.tbadk.core.dialog.b ltI = null;
    private AlertDialog lHJ = null;
    private aj lHK = null;
    PostData jLA = null;
    private boolean lrD = d.bhn();
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
            if (a.this.lOb == null || !a.this.lOb.isAdded()) {
                return true;
            }
            SparseArray sparseArray2 = null;
            try {
                sparseArray2 = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray2 == null) {
                if (a.this.m44do(view)) {
                    if (view instanceof TbImageView) {
                        a.this.luD = ((TbImageView) view).getBdImage();
                        a.this.luE = ((TbImageView) view).getUrl();
                        if (a.this.luD == null || TextUtils.isEmpty(a.this.luE)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.luF = null;
                        } else {
                            a.this.luF = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            a.this.luD = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                a.this.luE = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                a.this.luF = null;
                            } else {
                                a.this.luF = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        a.this.luD = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            a.this.luE = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.luF = null;
                        } else {
                            a.this.luF = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        a.this.a(a.this.lvs, a.this.luD.isGif());
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
            a.this.jLA = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (a.this.jLA == null || a.this.lOb.dqp() == null) {
                return true;
            }
            if (!a.this.lOb.dqp().bhP() || a.this.jLA.getId() == null || !a.this.jLA.getId().equals(a.this.lOb.diV().blK())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = a.this.lOb.diV().getPbData() != null && a.this.lOb.diV().getPbData().dik();
            if (a.this.lum == null) {
                a.this.lum = new k(a.this.lOb.getContext());
                a.this.lum.a(a.this.lve);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = a.this.m44do(view) && !z3;
                boolean z5 = (!a.this.m44do(view) || a.this.luD == null || a.this.luD.isGif()) ? false : true;
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
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), a.this.lum));
                }
                if (z5) {
                    arrayList.add(new g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), a.this.lum));
                }
                if (!z4 && !z5) {
                    g gVar3 = new g(3, TbadkCoreApplication.getInst().getString(R.string.copy), a.this.lum);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, a.this.jLA);
                    gVar3.eGH.setTag(sparseArray3);
                    arrayList.add(gVar3);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), a.this.lum);
                    } else {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.mark), a.this.lum);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, a.this.jLA);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar2.eGH.setTag(sparseArray4);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin() && !a.this.lrD) {
                    if (!z8 && z7) {
                        g gVar4 = new g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), a.this.lum);
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
                        gVar4.eGH.setTag(sparseArray5);
                        arrayList.add(gVar4);
                    } else {
                        if ((a.this.um(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                            g gVar5 = new g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.lum);
                            gVar5.eGH.setTag(str);
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
                            gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.lum);
                            gVar6.eGH.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), a.this.lum);
                        gVar.eGH.setTag(sparseArray6);
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
                            if (a.this.lOb.diV().getPbData().dhW() == 1002 && !z6) {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.lum);
                            } else {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.lum);
                            }
                            gVar6.eGH.setTag(sparseArray7);
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
                a.this.lum.br(arrayList);
                a.this.lul = new i(a.this.lOb.getPageContext(), a.this.lum);
                a.this.lul.PA();
                TiebaStatic.log(new ar("c13272").dR("tid", a.this.lOb.diV().dkU()).dR("fid", a.this.lOb.diV().getForumId()).dR("uid", a.this.lOb.diV().getPbData().dhH().blC().getUserId()).dR("post_id", a.this.lOb.diV().bzp()).ak("obj_source", z2 ? 2 : 1));
            }
            return true;
        }
    };
    private k.c lve = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.17
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (a.this.lul != null) {
                a.this.lul.dismiss();
            }
            switch (i) {
                case 1:
                    if (a.this.luD != null && !TextUtils.isEmpty(a.this.luE)) {
                        if (a.this.luF == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.luE));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.luE;
                            aVar.pkgId = a.this.luF.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.luF.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.luD = null;
                        a.this.luE = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.luD != null && !TextUtils.isEmpty(a.this.luE)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.lOb.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.lOb.getPageContext().getPageActivity())) {
                            if (a.this.euQ == null) {
                                a.this.euQ = new bd(a.this.lOb.getPageContext());
                            }
                            a.this.euQ.j(a.this.luE, a.this.luD.getImageByte());
                            a.this.luD = null;
                            a.this.luE = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.jLA != null) {
                        a.this.jLA.fS(a.this.lOb.getPageContext().getPageActivity());
                        a.this.jLA = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new ar("c11739").ak("obj_locate", 2));
                    if (a.this.lOb.checkUpIsLogin()) {
                        a.this.dn(view);
                        if (a.this.lOb.diV().getPbData().dhH() != null && a.this.lOb.diV().getPbData().dhH().blC() != null && a.this.lOb.diV().getPbData().dhH().blC().getUserId() != null && a.this.lOb.dqp() != null) {
                            int h = a.this.h(a.this.lOb.diV().getPbData());
                            bx dhH = a.this.lOb.diV().getPbData().dhH();
                            if (dhH.bkk()) {
                                i2 = 2;
                            } else if (dhH.bkl()) {
                                i2 = 3;
                            } else if (dhH.bnz()) {
                                i2 = 4;
                            } else {
                                i2 = dhH.bnA() ? 5 : 1;
                            }
                            TiebaStatic.log(new ar("c12526").dR("tid", a.this.lOb.diV().dkU()).ak("obj_locate", 2).dR("obj_id", a.this.lOb.diV().getPbData().dhH().blC().getUserId()).ak("obj_type", a.this.lOb.dqp().bhP() ? 0 : 1).ak("obj_source", h).ak("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.lOb.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new ar("c13079"));
                        a.this.OW((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new ar("c11739").ak("obj_locate", 4));
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
                        a.this.lOb.showToast(R.string.network_not_available);
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
                            a.this.dt(view);
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
                    if (bh.checkUpIsLogin(a.this.lOb.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.bnv() != null) {
                            a.this.d(postData.bnv());
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
    private final b.InterfaceC0574b lvs = new b.InterfaceC0574b() { // from class: com.baidu.tieba.pb.videopb.b.a.21
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0574b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.luD != null && !TextUtils.isEmpty(a.this.luE)) {
                if (i == 0) {
                    if (a.this.luF == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.luE));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.luE;
                        aVar.pkgId = a.this.luF.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.luF.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.lOb.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.lOb.getPageContext().getPageActivity())) {
                        if (a.this.euQ == null) {
                            a.this.euQ = new bd(a.this.lOb.getPageContext());
                        }
                        a.this.euQ.j(a.this.luE, a.this.luD.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.luD = null;
                a.this.luE = null;
            }
        }
    };

    public void djX() {
        f pbData;
        bx dhH;
        boolean z = true;
        if (this.lOb != null && this.lOb.diV() != null && this.lOb.diV().getPbData() != null && (dhH = (pbData = this.lOb.diV().getPbData()).dhH()) != null && dhH.blC() != null) {
            this.lOb.dmG();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dhH.blC().getUserId());
            ak akVar = new ak();
            int dhW = this.lOb.diV().getPbData().dhW();
            if (dhW == 1 || dhW == 3) {
                akVar.lzD = true;
                akVar.lzC = true;
                akVar.lzI = dhH.blx() == 1;
                akVar.lzH = dhH.bly() == 1;
            } else {
                akVar.lzD = false;
                akVar.lzC = false;
            }
            if (dhW == 1002 && !equals) {
                akVar.lzJ = true;
            }
            akVar.lzA = un(equals);
            akVar.lzE = djY();
            akVar.lzB = uo(equals);
            akVar.Fc = this.lOb.diV().dkW();
            akVar.lzx = true;
            akVar.lzw = um(equals);
            akVar.lzG = TbadkCoreApplication.getInst().getSkinType() == 1;
            akVar.lzF = true;
            akVar.isHostOnly = this.lOb.diV().getHostMode();
            akVar.lzz = true;
            if (dhH.blU() == null) {
                akVar.lzy = true;
            } else {
                akVar.lzy = false;
            }
            if (pbData.dik()) {
                akVar.lzx = false;
                akVar.lzz = false;
                akVar.lzy = false;
                akVar.lzC = false;
                akVar.lzD = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.dik()) {
                z = false;
            }
            akVar.lzK = z;
            a(akVar);
        }
    }

    private boolean un(boolean z) {
        boolean z2;
        ac acVar;
        if (this.lOb == null || this.lOb.diV() == null || this.lOb.diV().getPbData() == null) {
            return false;
        }
        f pbData = this.lOb.diV().getPbData();
        bx dhH = pbData.dhH();
        if (dhH != null) {
            if (dhH.bkk() || dhH.bkl()) {
                return false;
            }
            if (dhH.bnz() || dhH.bnA()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.dhW() != 0) {
                return pbData.dhW() != 3;
            }
            List<bt> die = pbData.die();
            if (y.getCount(die) > 0) {
                for (bt btVar : die) {
                    if (btVar != null && (acVar = btVar.eBt) != null && acVar.ezg && !acVar.ezh && (acVar.type == 1 || acVar.type == 2)) {
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

    private boolean uo(boolean z) {
        if (z || this.lOb == null || this.lOb.diV() == null || this.lOb.diV().getPbData() == null) {
            return false;
        }
        return ((this.lOb.diV().getPbData().getForum() != null && this.lOb.diV().getPbData().getForum().isBlockBawuDelete) || this.lOb.diV().getPbData().dhW() == 0 || this.lOb.diV().getPbData().dhW() == 3) ? false : true;
    }

    private boolean djY() {
        if (this.lOb == null || this.lOb.diV() == null || !this.lOb.diV().dkW()) {
            return false;
        }
        return this.lOb.diV().getPageData() == null || this.lOb.diV().getPageData().bkt() != 0;
    }

    public void a(ak akVar) {
        if (!this.lOb.getBaseFragmentActivity().isProgressBarShown()) {
            this.lHK = new aj(this.lOb, this.lOb.aEk);
            this.lHJ = new AlertDialog.Builder(this.lOb.getContext(), R.style.DialogTheme).create();
            this.lHJ.setCanceledOnTouchOutside(true);
            com.baidu.adp.lib.f.g.showDialog(this.lHJ, this.lOb.getFragmentActivity());
            Window window = this.lHJ.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = l.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.lHK.getView());
            this.lHK.uC(akVar == null ? false : akVar.lzw);
            this.lHK.uD(akVar == null ? false : akVar.lzA);
            this.lHK.uE(akVar == null ? false : akVar.lzE);
            this.lHK.uG(akVar == null ? false : akVar.lzB);
            this.lHK.uH(akVar == null ? true : akVar.lzy);
            if (akVar == null) {
                this.lHK.ao(false, false);
                this.lHK.ap(false, false);
            } else {
                this.lHK.ao(akVar.lzC, akVar.lzI);
                this.lHK.ap(akVar.lzD, akVar.lzH);
            }
            boolean z = akVar == null ? false : akVar.Fc;
            boolean z2 = akVar == null ? false : akVar.isHostOnly;
            boolean z3 = akVar == null ? false : akVar.lzz;
            boolean z4 = akVar == null ? false : akVar.lzx;
            boolean z5 = akVar == null ? false : akVar.lzG;
            boolean z6 = akVar == null ? false : akVar.lzF;
            this.lHK.an(z3, z2);
            this.lHK.aq(z4, z);
            this.lHK.ar(z6, z5);
            if (akVar != null) {
                this.lHK.lzt = akVar.lzJ;
                if (akVar.lzJ) {
                    this.lHK.dmh().setText(R.string.report_text);
                    this.lHK.uG(false);
                }
            }
            this.lHK.uF(akVar != null ? akVar.lzK : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.lOb.diV() != null && this.lOb.diV().getPbData() != null && this.lOb.diV().getPbData().getThreadId() != null && this.lOb.diV().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.lHK.dmk().setText(R.string.have_called_fans_short);
            }
            doF();
        }
    }

    private void doF() {
        if (this.lHK != null) {
            this.lHK.dmo();
        }
    }

    public void aYV() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.lHJ != null) {
                        com.baidu.adp.lib.f.g.dismissDialog(a.this.lHJ, a.this.lOb.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.mY().postDelayed(this.runnable, 100L);
    }

    public void doG() {
        if (this.lHJ != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.lHJ, this.lOb.getPageContext().getPageActivity());
        }
    }

    public aj doH() {
        return this.lHK;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.lOb = videoPbFragment;
        this.luB = videoPbFragment.getUniqueId();
        this.lue = new com.baidu.tieba.pb.pb.report.a(this.lOb.getContext());
        this.lue.w(this.lOb.getUniqueId());
        this.lDl = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.16
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.lOb.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.lOb.diV().getPbData().getUserData().getUserId());
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
                a.this.lOb.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.lOb.getPageContext().getPageActivity(), a.this.lOb.diV().getPbData().getForum().getId(), a.this.lOb.diV().getPbData().getForum().getName(), a.this.lOb.diV().getPbData().dhH().getId(), valueOf, str, str3, str2, str4)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dn(View view) {
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
        PostData K;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.lOb.diV().blK())) {
                z = true;
            }
            MarkData o = this.lOb.diV().o(postData);
            if (this.lOb.diV().getPbData() != null && this.lOb.diV().getPbData().dik() && (K = this.lOb.K(this.lOb.diV().getPbData())) != null) {
                o = this.lOb.diV().o(K);
            }
            if (o != null) {
                this.lOb.dng();
                if (this.lOb.dqp() != null) {
                    this.lOb.dqp().a(o);
                    if (!z) {
                        this.lOb.dqp().bhR();
                    } else {
                        this.lOb.dqp().bhQ();
                    }
                }
            }
        }
    }

    public int h(f fVar) {
        if (fVar != null && fVar.dhH() != null) {
            if (fVar.dhH().getThreadType() == 0) {
                return 1;
            }
            if (fVar.dhH().getThreadType() == 54) {
                return 2;
            }
            if (fVar.dhH().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean um(boolean z) {
        if (this.lOb.diV() == null || this.lOb.diV().getPbData() == null) {
            return false;
        }
        return ((this.lOb.diV().getPbData().dhW() != 0) || this.lOb.diV().getPbData().dhH() == null || this.lOb.diV().getPbData().dhH().blC() == null || TextUtils.equals(this.lOb.diV().getPbData().dhH().blC().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void OW(String str) {
        if (this.lOb.diV() != null && this.lOb.diV().getPbData() != null && this.lOb.diV().getPbData().dik()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lOb.diV().dkU(), str);
            bx dhH = this.lOb.diV().getPbData().dhH();
            if (dhH.bkk()) {
                format = format + "&channelid=33833";
            } else if (dhH.bny()) {
                format = format + "&channelid=33842";
            } else if (dhH.bkl()) {
                format = format + "&channelid=33840";
            }
            OX(format);
            return;
        }
        this.lue.Px(str);
    }

    private void OX(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.lOb.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.lul != null && this.lul.isShowing()) {
                this.lul.dismiss();
                this.lul = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.lOb.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.lul != null) {
                            a.this.lul.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.luB);
                            userMuteAddAndDelCustomMessage.setTag(a.this.luB);
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
                kVar.br(arrayList);
                this.lul = new i(this.lOb.getPageContext(), kVar);
                this.lul.PA();
            }
        }
    }

    public void dkt() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lOb.getPageContext().getPageActivity());
        aVar.AJ(this.lOb.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.19
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.lOb.getFragmentActivity(), 2, true, 4);
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
        aVar.b(this.lOb.getPageContext()).bog();
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
        sparseArray.put(lCD, Integer.valueOf(lCE));
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
        this.lBM = new com.baidu.tbadk.core.dialog.a(this.lOb.getActivity());
        if (StringUtils.isNull(str2)) {
            this.lBM.os(i3);
        } else {
            this.lBM.setOnlyMessageShowCenter(false);
            this.lBM.AJ(str2);
        }
        this.lBM.setYesButtonTag(sparseArray);
        this.lBM.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.lOb.a(aVar, (JSONArray) null);
            }
        });
        this.lBM.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lBM.iW(true);
        this.lBM.b(this.lOb.getPageContext());
        if (z) {
            this.lBM.bog();
        } else {
            a(this.lBM, i);
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.lOb != null && aVar != null) {
            if (this.jox == null && this.lOb.getView() != null) {
                this.jox = new com.baidu.tieba.NEGFeedBack.e(this.lOb.getPageContext(), this.lOb.getView());
            }
            AntiData cwP = cwP();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cwP != null && cwP.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cwP.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            as asVar = new as();
            asVar.setFeedBackReasonMap(sparseArray);
            this.jox.setDefaultReasonArray(new String[]{this.lOb.getString(R.string.delete_thread_reason_1), this.lOb.getString(R.string.delete_thread_reason_2), this.lOb.getString(R.string.delete_thread_reason_3), this.lOb.getString(R.string.delete_thread_reason_4), this.lOb.getString(R.string.delete_thread_reason_5)});
            this.jox.setData(asVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.jox.Ev(str);
            this.jox.a(new e.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray) {
                    a.this.lOb.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData cwP() {
        if (this.lOb.diV() == null || this.lOb.diV().getPbData() == null) {
            return null;
        }
        return this.lOb.diV().getPbData().getAnti();
    }

    public void dt(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        g gVar;
        g gVar2;
        k kVar = new k(this.lOb.getContext());
        kVar.setTitleText(this.lOb.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.lBL.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (a.this.lDl != null) {
                                a.this.lDl.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
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
                gVar2 = new g(0, this.lOb.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new g(0, this.lOb.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.eGH.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            g gVar3 = new g(1, this.lOb.getString(R.string.forbidden_person), kVar);
            gVar3.eGH.setTag(sparseArray3);
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
                gVar = new g(2, this.lOb.getString(R.string.un_mute), kVar);
            } else {
                gVar = new g(2, this.lOb.getString(R.string.mute), kVar);
            }
            gVar.eGH.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.br(arrayList);
        if (this.lBL == null) {
            this.lBL = new i(this.lOb.getPageContext(), kVar);
        } else {
            this.lBL.a(kVar);
        }
        this.lBL.PA();
    }

    public void djQ() {
        if (this.ltI == null) {
            this.ltI = new com.baidu.tbadk.core.dialog.b(this.lOb.getPageContext().getPageActivity());
            this.ltI.a(new String[]{this.lOb.getPageContext().getString(R.string.call_phone), this.lOb.getPageContext().getString(R.string.sms_phone), this.lOb.getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0574b() { // from class: com.baidu.tieba.pb.videopb.b.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0574b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.lOb.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.lqd = a.this.lqd.trim();
                        UtilHelper.callPhone(a.this.lOb.getPageContext().getPageActivity(), a.this.lqd);
                        new com.baidu.tieba.pb.pb.main.b(a.this.lOb.diV().dkU(), a.this.lqd, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.lOb.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.lqd = a.this.lqd.trim();
                        UtilHelper.smsPhone(a.this.lOb.getPageContext().getPageActivity(), a.this.lqd);
                        new com.baidu.tieba.pb.pb.main.b(a.this.lOb.diV().dkU(), a.this.lqd, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.lqd = a.this.lqd.trim();
                        UtilHelper.startBaiDuBar(a.this.lOb.getPageContext().getPageActivity(), a.this.lqd);
                        bVar.dismiss();
                    }
                }
            }).oy(b.a.BOTTOM_TO_TOP).oz(17).d(this.lOb.getPageContext());
        }
    }

    public void dz(final View view) {
        String[] strArr;
        int i = 0;
        if (this.lOb != null && this.lOb.diV() != null) {
            final i iVar = new i(this.lOb.getPageContext());
            if (this.lOb.diV().getPbData().lnk == null || this.lOb.diV().getPbData().lnk.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.lOb.diV().getPbData().lnk.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.lOb.diV().getPbData().lnk.size()) {
                        break;
                    }
                    strArr2[i2] = this.lOb.diV().getPbData().lnk.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.lOb.diV().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.lOb.diV().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.lOb.diV().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.lOb.diV().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new ar("c12097").ak("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).ak("obj_type", i4));
                    if (a.this.lOb.diV().getPbData().lnk != null && a.this.lOb.diV().getPbData().lnk.size() > i3) {
                        i3 = a.this.lOb.diV().getPbData().lnk.get(i3).sort_type.intValue();
                    }
                    boolean Gy = a.this.lOb.diV().Gy(i3);
                    view.setTag(Integer.valueOf(a.this.lOb.diV().dln()));
                    if (Gy) {
                        a.this.lOb.setIsLoading(true);
                    }
                }
            });
            iVar.PA();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lOb.getActivity());
            aVar.AI(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.AJ(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.iW(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new ar("c12528").dR("obj_id", metaData.getUserId()).ak("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new ar("c12528").dR("obj_id", metaData.getUserId()).ak("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.lOb.dqA() != null) {
                        a.this.lOb.dqA().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.lOb.getPageContext().getUniqueId(), a.this.lOb.diV().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.lOb.getPageContext()).bog();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.luB);
        userMuteAddAndDelCustomMessage.setTag(this.luB);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void Ds(String str) {
        if (str == null) {
            str = "";
        }
        if (this.lOb != null && this.lOb.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lOb.getPageContext().getPageActivity());
            aVar.AJ(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lOb.getPageContext()).bog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lOb.getBaseFragmentActivity());
        if (au.isEmpty(str)) {
            aVar.AJ(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.AJ(str);
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
        aVar.b(this.lOb.getPageContext()).bog();
    }

    public void showLoadingDialog() {
        if (this.ifn == null) {
            this.ifn = new com.baidu.tbadk.core.view.a(this.lOb.getPageContext());
        }
        this.ifn.setDialogVisiable(true);
    }

    public void cgz() {
        if (this.ifn != null) {
            this.ifn.setDialogVisiable(false);
        }
    }

    public void f(SparseArray<Object> sparseArray) {
        PostData postData;
        boolean z;
        String str;
        g gVar;
        if (this.lOb != null && this.lOb.diV() != null && sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            if (this.lum == null) {
                this.lum = new k(this.lOb.getContext());
                this.lum.a(this.lve);
            }
            ArrayList arrayList = new ArrayList();
            boolean z2 = this.lOb.diV().getPbData() != null && this.lOb.diV().getPbData().dik();
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
                if (postData.bnv() != null) {
                    g gVar2 = new g(8, (postData.bnv().hasAgree && postData.bnf() == 5) ? this.lOb.getString(R.string.action_cancel_dislike) : this.lOb.getString(R.string.action_dislike), this.lum);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    gVar2.eGH.setTag(sparseArray2);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z4 && z3) {
                        g gVar3 = new g(5, this.lOb.getString(R.string.mute_option), this.lum);
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
                        gVar3.eGH.setTag(sparseArray3);
                        arrayList.add(gVar3);
                    } else {
                        if ((um(z) && TbadkCoreApplication.isLogin()) && !z2) {
                            g gVar4 = new g(5, this.lOb.getString(R.string.report_text), this.lum);
                            gVar4.eGH.setTag(str);
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
                            gVar5 = new g(6, this.lOb.getString(R.string.delete), this.lum);
                            gVar5.eGH.setTag(sparseArray4);
                        } else {
                            sparseArray4.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, this.lOb.getString(R.string.bar_manager), this.lum);
                        gVar.eGH.setTag(sparseArray4);
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
                            if (this.lOb.diV().getPbData().dhW() == 1002 && !z) {
                                gVar5 = new g(6, this.lOb.getString(R.string.report_text), this.lum);
                            } else {
                                gVar5 = new g(6, this.lOb.getString(R.string.delete), this.lum);
                            }
                            gVar5.eGH.setTag(sparseArray5);
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
                this.lum.br(arrayList);
                this.lul = new i(this.lOb.getPageContext(), this.lum);
                this.lul.PA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eQi == null) {
                this.eQi = new com.baidu.tbadk.core.message.a();
            }
            if (this.ePS == null) {
                this.ePS = new com.baidu.tieba.tbadkCore.data.e();
                this.ePS.uniqueId = this.lOb.getUniqueId();
            }
            com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
            dVar.exI = 5;
            dVar.exO = 8;
            dVar.exN = 2;
            if (this.lOb != null && this.lOb.diV() != null) {
                dVar.exM = this.lOb.diV().dlE();
            }
            if (dVar != null) {
                dVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (dVar != null) {
                        dVar.exP = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (dVar != null) {
                        dVar.exP = 1;
                        i = 0;
                    }
                }
                this.eQi.a(agreeData, i, this.lOb.getUniqueId(), false);
                this.eQi.a(agreeData, this.ePS);
                if (this.lOb == null && this.lOb.diV() != null && this.lOb.diV().getPbData() != null) {
                    this.eQi.a(this.lOb.dkB(), dVar, agreeData, this.lOb.diV().getPbData().dhH());
                    return;
                }
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (dVar != null) {
                dVar.exP = 1;
            }
            i = 0;
            this.eQi.a(agreeData, i, this.lOb.getUniqueId(), false);
            this.eQi.a(agreeData, this.ePS);
            if (this.lOb == null) {
            }
        }
    }

    public void a(final b.InterfaceC0574b interfaceC0574b, boolean z) {
        if (this.lBU != null) {
            this.lBU.dismiss();
            this.lBU = null;
        }
        k kVar = new k(this.lOb.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.lOb.diV().getPbData() != null && this.lOb.diV().getPbData().dhH() != null && !this.lOb.diV().getPbData().dhH().isBjh()) {
            arrayList.add(new g(0, this.lOb.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new g(1, this.lOb.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.br(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.lBU.dismiss();
                interfaceC0574b.a(null, i, view);
            }
        });
        this.lBU = new i(this.lOb.getPageContext(), kVar);
        this.lBU.PA();
    }

    public void bd(ArrayList<com.baidu.tbadk.core.data.ak> arrayList) {
        if (this.lBP == null) {
            this.lBP = LayoutInflater.from(this.lOb.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.lOb.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lBP);
        if (this.lBO == null) {
            this.lBO = new Dialog(this.lOb.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lBO.setCanceledOnTouchOutside(true);
            this.lBO.setCancelable(true);
            this.lBX = (ScrollView) this.lBP.findViewById(R.id.good_scroll);
            this.lBO.setContentView(this.lBP);
            WindowManager.LayoutParams attributes = this.lBO.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.lBO.getWindow().setAttributes(attributes);
            this.iaY = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.14
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.lBT = (String) compoundButton.getTag();
                        if (a.this.iaX != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.iaX) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.lBT != null && !str.equals(a.this.lBT)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.lBQ = (LinearLayout) this.lBP.findViewById(R.id.good_class_group);
            this.lBS = (TextView) this.lBP.findViewById(R.id.dialog_button_cancel);
            this.lBS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lBO instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(a.this.lBO, a.this.lOb.getPageContext());
                    }
                }
            });
            this.lBR = (TextView) this.lBP.findViewById(R.id.dialog_button_ok);
            this.lBR.setOnClickListener(this.lOb.dqq());
        }
        this.lBQ.removeAllViews();
        this.iaX = new ArrayList();
        CustomBlueCheckRadioButton fT = fT("0", this.lOb.getPageContext().getString(R.string.thread_good_class));
        this.iaX.add(fT);
        fT.setChecked(true);
        this.lBQ.addView(fT);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.ak akVar = arrayList.get(i2);
                if (akVar != null && !TextUtils.isEmpty(akVar.bjQ()) && akVar.bjR() > 0) {
                    CustomBlueCheckRadioButton fT2 = fT(String.valueOf(akVar.bjR()), akVar.bjQ());
                    this.iaX.add(fT2);
                    View view = new View(this.lOb.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    ap.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.lBQ.addView(view);
                    this.lBQ.addView(fT2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.lBX.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.lOb.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.lOb.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.lOb.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.lBX.setLayoutParams(layoutParams2);
            this.lBX.removeAllViews();
            if (this.lBQ != null && this.lBQ.getParent() == null) {
                this.lBX.addView(this.lBQ);
            }
        }
        com.baidu.adp.lib.f.g.a(this.lBO, this.lOb.getPageContext());
    }

    private CustomBlueCheckRadioButton fT(String str, String str2) {
        Activity pageActivity = this.lOb.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.iaY);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    /* renamed from: do  reason: not valid java name */
    public boolean m44do(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.luB;
        userMuteCheckCustomMessage.setTag(this.luB);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void dnC() {
        if (this.lBM != null) {
            this.lBM.dismiss();
        }
        if (this.lBN != null) {
            com.baidu.adp.lib.f.g.b(this.lBN, this.lOb.getPageContext());
        }
        if (this.lBO != null) {
            com.baidu.adp.lib.f.g.b(this.lBO, this.lOb.getPageContext());
        }
        if (this.lBL != null) {
            this.lBL.dismiss();
        }
    }

    public void drh() {
        if (this.lul != null) {
            this.lul.dismiss();
        }
    }

    public void dnB() {
        aYV();
        this.lOb.dmG();
        if (this.lul != null) {
            this.lul.dismiss();
        }
        dnC();
    }

    public void dnA() {
        aYV();
        this.lOb.dmG();
        if (this.lul != null) {
            this.lul.dismiss();
        }
        this.lOb.cyo();
        dnC();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener dqs() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b dri() {
        return this.ltI;
    }

    public void setPhoneNumber(String str) {
        this.lqd = str;
    }

    public String dnf() {
        return this.lBT;
    }

    public View dne() {
        if (this.lBP != null) {
            return this.lBP.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
