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
/* loaded from: classes22.dex */
public class a {
    public static int lCk = 3;
    public static int lCl = 0;
    public static int lCm = 3;
    public static int lCn = 4;
    public static int lCo = 5;
    public static int lCp = 6;
    private e eQR;
    private com.baidu.tbadk.core.message.a eRh;
    private bd ewz;
    private List<CustomBlueCheckRadioButton> iav;
    private com.baidu.tieba.NEGFeedBack.e jnL;
    private PbFragment.b lCT;
    public VideoPbFragment lNL;
    private String lpO;
    private com.baidu.tieba.pb.pb.report.a ltO;
    private i ltV;
    private k ltW;
    public BdUniqueId lul;
    private com.baidu.adp.widget.ImageView.a lun;
    private String luo;
    private TbRichTextMemeInfo lup;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    private Runnable runnable;
    private i lBC = null;
    private com.baidu.tbadk.core.dialog.a lBu = null;
    private Dialog lBv = null;
    private Dialog lBw = null;
    private View lBx = null;
    private LinearLayout lBy = null;
    private TextView lBz = null;
    private TextView lBA = null;
    private String lBB = null;
    private ScrollView lBF = null;
    private CompoundButton.OnCheckedChangeListener iaw = null;
    private i lBt = null;
    private com.baidu.tbadk.core.view.a iey = null;
    private com.baidu.tbadk.core.dialog.b lts = null;
    private AlertDialog lHr = null;
    private aj lHs = null;
    PostData jKP = null;
    private boolean lrn = d.bhV();
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
            if (a.this.lNL == null || !a.this.lNL.isAdded()) {
                return true;
            }
            SparseArray sparseArray2 = null;
            try {
                sparseArray2 = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray2 == null) {
                if (a.this.dk(view)) {
                    if (view instanceof TbImageView) {
                        a.this.lun = ((TbImageView) view).getBdImage();
                        a.this.luo = ((TbImageView) view).getUrl();
                        if (a.this.lun == null || TextUtils.isEmpty(a.this.luo)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.lup = null;
                        } else {
                            a.this.lup = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            a.this.lun = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                a.this.luo = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                a.this.lup = null;
                            } else {
                                a.this.lup = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        a.this.lun = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            a.this.luo = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.lup = null;
                        } else {
                            a.this.lup = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        a.this.a(a.this.lvc, a.this.lun.isGif());
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
            a.this.jKP = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (a.this.jKP == null || a.this.lNL.dqP() == null) {
                return true;
            }
            if (!a.this.lNL.dqP().biv() || a.this.jKP.getId() == null || !a.this.jKP.getId().equals(a.this.lNL.djz().bmI())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = a.this.lNL.djz().getPbData() != null && a.this.lNL.djz().getPbData().diN();
            if (a.this.ltW == null) {
                a.this.ltW = new k(a.this.lNL.getContext());
                a.this.ltW.a(a.this.luO);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = a.this.dk(view) && !z3;
                boolean z5 = (!a.this.dk(view) || a.this.lun == null || a.this.lun.isGif()) ? false : true;
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
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), a.this.ltW));
                }
                if (z5) {
                    arrayList.add(new g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), a.this.ltW));
                }
                if (!z4 && !z5) {
                    g gVar3 = new g(3, TbadkCoreApplication.getInst().getString(R.string.copy), a.this.ltW);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, a.this.jKP);
                    gVar3.mTextView.setTag(sparseArray3);
                    arrayList.add(gVar3);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), a.this.ltW);
                    } else {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.mark), a.this.ltW);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, a.this.jKP);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar2.mTextView.setTag(sparseArray4);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin() && !a.this.lrn) {
                    if (!z8 && z7) {
                        g gVar4 = new g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), a.this.ltW);
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
                        if ((a.this.uj(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                            g gVar5 = new g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.ltW);
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
                            gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.ltW);
                            gVar6.mTextView.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), a.this.ltW);
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
                            if (a.this.lNL.djz().getPbData().diz() == 1002 && !z6) {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.ltW);
                            } else {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.ltW);
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
                a.this.ltW.br(arrayList);
                a.this.ltV = new i(a.this.lNL.getPageContext(), a.this.ltW);
                a.this.ltV.Qj();
                TiebaStatic.log(new aq("c13272").dR("tid", a.this.lNL.djz().dlx()).dR("fid", a.this.lNL.djz().getForumId()).dR("uid", a.this.lNL.djz().getPbData().dik().bmA().getUserId()).dR("post_id", a.this.lNL.djz().bzZ()).al("obj_source", z2 ? 2 : 1));
            }
            return true;
        }
    };
    private k.c luO = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.17
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (a.this.ltV != null) {
                a.this.ltV.dismiss();
            }
            switch (i) {
                case 1:
                    if (a.this.lun != null && !TextUtils.isEmpty(a.this.luo)) {
                        if (a.this.lup == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.luo));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.luo;
                            aVar.pkgId = a.this.lup.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.lup.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.lun = null;
                        a.this.luo = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.lun != null && !TextUtils.isEmpty(a.this.luo)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.lNL.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.lNL.getPageContext().getPageActivity())) {
                            if (a.this.ewz == null) {
                                a.this.ewz = new bd(a.this.lNL.getPageContext());
                            }
                            a.this.ewz.j(a.this.luo, a.this.lun.getImageByte());
                            a.this.lun = null;
                            a.this.luo = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.jKP != null) {
                        a.this.jKP.fT(a.this.lNL.getPageContext().getPageActivity());
                        a.this.jKP = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new aq("c11739").al("obj_locate", 2));
                    if (a.this.lNL.checkUpIsLogin()) {
                        a.this.dj(view);
                        if (a.this.lNL.djz().getPbData().dik() != null && a.this.lNL.djz().getPbData().dik().bmA() != null && a.this.lNL.djz().getPbData().dik().bmA().getUserId() != null && a.this.lNL.dqP() != null) {
                            int h = a.this.h(a.this.lNL.djz().getPbData());
                            bw dik = a.this.lNL.djz().getPbData().dik();
                            if (dik.bli()) {
                                i2 = 2;
                            } else if (dik.blj()) {
                                i2 = 3;
                            } else if (dik.bov()) {
                                i2 = 4;
                            } else {
                                i2 = dik.bow() ? 5 : 1;
                            }
                            TiebaStatic.log(new aq("c12526").dR("tid", a.this.lNL.djz().dlx()).al("obj_locate", 2).dR("obj_id", a.this.lNL.djz().getPbData().dik().bmA().getUserId()).al("obj_type", a.this.lNL.dqP().biv() ? 0 : 1).al("obj_source", h).al("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.lNL.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new aq("c13079"));
                        a.this.PA((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new aq("c11739").al("obj_locate", 4));
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
                        a.this.lNL.showToast(R.string.network_not_available);
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
                            a.this.dp(view);
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
                    if (bg.checkUpIsLogin(a.this.lNL.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.bor() != null) {
                            a.this.d(postData.bor());
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
    private final b.InterfaceC0576b lvc = new b.InterfaceC0576b() { // from class: com.baidu.tieba.pb.videopb.b.a.21
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0576b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.lun != null && !TextUtils.isEmpty(a.this.luo)) {
                if (i == 0) {
                    if (a.this.lup == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.luo));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.luo;
                        aVar.pkgId = a.this.lup.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.lup.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.lNL.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.lNL.getPageContext().getPageActivity())) {
                        if (a.this.ewz == null) {
                            a.this.ewz = new bd(a.this.lNL.getPageContext());
                        }
                        a.this.ewz.j(a.this.luo, a.this.lun.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.lun = null;
                a.this.luo = null;
            }
        }
    };

    public void dkA() {
        f pbData;
        bw dik;
        boolean z = true;
        if (this.lNL != null && this.lNL.djz() != null && this.lNL.djz().getPbData() != null && (dik = (pbData = this.lNL.djz().getPbData()).dik()) != null && dik.bmA() != null) {
            this.lNL.dni();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dik.bmA().getUserId());
            ak akVar = new ak();
            int diz = this.lNL.djz().getPbData().diz();
            if (diz == 1 || diz == 3) {
                akVar.lzl = true;
                akVar.lzk = true;
                akVar.lzq = dik.bmv() == 1;
                akVar.lzp = dik.bmw() == 1;
            } else {
                akVar.lzl = false;
                akVar.lzk = false;
            }
            if (diz == 1002 && !equals) {
                akVar.lzr = true;
            }
            akVar.lzi = uk(equals);
            akVar.lzm = dkB();
            akVar.lzj = ul(equals);
            akVar.Fc = this.lNL.djz().dlz();
            akVar.lzf = true;
            akVar.lze = uj(equals);
            akVar.lzo = TbadkCoreApplication.getInst().getSkinType() == 1;
            akVar.lzn = true;
            akVar.isHostOnly = this.lNL.djz().getHostMode();
            akVar.lzh = true;
            if (dik.bmS() == null) {
                akVar.lzg = true;
            } else {
                akVar.lzg = false;
            }
            if (pbData.diN()) {
                akVar.lzf = false;
                akVar.lzh = false;
                akVar.lzg = false;
                akVar.lzk = false;
                akVar.lzl = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.diN()) {
                z = false;
            }
            akVar.lzs = z;
            a(akVar);
        }
    }

    private boolean uk(boolean z) {
        boolean z2;
        ab abVar;
        if (this.lNL == null || this.lNL.djz() == null || this.lNL.djz().getPbData() == null) {
            return false;
        }
        f pbData = this.lNL.djz().getPbData();
        bw dik = pbData.dik();
        if (dik != null) {
            if (dik.bli() || dik.blj()) {
                return false;
            }
            if (dik.bov() || dik.bow()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.diz() != 0) {
                return pbData.diz() != 3;
            }
            List<bs> diH = pbData.diH();
            if (y.getCount(diH) > 0) {
                for (bs bsVar : diH) {
                    if (bsVar != null && (abVar = bsVar.eDc) != null && abVar.eAP && !abVar.eAQ && (abVar.type == 1 || abVar.type == 2)) {
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

    private boolean ul(boolean z) {
        if (z || this.lNL == null || this.lNL.djz() == null || this.lNL.djz().getPbData() == null) {
            return false;
        }
        return ((this.lNL.djz().getPbData().getForum() != null && this.lNL.djz().getPbData().getForum().isBlockBawuDelete) || this.lNL.djz().getPbData().diz() == 0 || this.lNL.djz().getPbData().diz() == 3) ? false : true;
    }

    private boolean dkB() {
        if (this.lNL == null || this.lNL.djz() == null || !this.lNL.djz().dlz()) {
            return false;
        }
        return this.lNL.djz().getPageData() == null || this.lNL.djz().getPageData().blr() != 0;
    }

    public void a(ak akVar) {
        if (!this.lNL.getBaseFragmentActivity().isProgressBarShown()) {
            this.lHs = new aj(this.lNL, this.lNL.aFV);
            this.lHr = new AlertDialog.Builder(this.lNL.getContext(), R.style.DialogTheme).create();
            this.lHr.setCanceledOnTouchOutside(true);
            com.baidu.adp.lib.f.g.showDialog(this.lHr, this.lNL.getFragmentActivity());
            Window window = this.lHr.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.lHs.getView());
            this.lHs.uz(akVar == null ? false : akVar.lze);
            this.lHs.uA(akVar == null ? false : akVar.lzi);
            this.lHs.uB(akVar == null ? false : akVar.lzm);
            this.lHs.uD(akVar == null ? false : akVar.lzj);
            this.lHs.uE(akVar == null ? true : akVar.lzg);
            if (akVar == null) {
                this.lHs.ao(false, false);
                this.lHs.ap(false, false);
            } else {
                this.lHs.ao(akVar.lzk, akVar.lzq);
                this.lHs.ap(akVar.lzl, akVar.lzp);
            }
            boolean z = akVar == null ? false : akVar.Fc;
            boolean z2 = akVar == null ? false : akVar.isHostOnly;
            boolean z3 = akVar == null ? false : akVar.lzh;
            boolean z4 = akVar == null ? false : akVar.lzf;
            boolean z5 = akVar == null ? false : akVar.lzo;
            boolean z6 = akVar == null ? false : akVar.lzn;
            this.lHs.an(z3, z2);
            this.lHs.aq(z4, z);
            this.lHs.ar(z6, z5);
            if (akVar != null) {
                this.lHs.lzb = akVar.lzr;
                if (akVar.lzr) {
                    this.lHs.dmK().setText(R.string.report_text);
                    this.lHs.uD(false);
                }
            }
            this.lHs.uC(akVar != null ? akVar.lzs : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.lNL.djz() != null && this.lNL.djz().getPbData() != null && this.lNL.djz().getPbData().getThreadId() != null && this.lNL.djz().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.lHs.dmN().setText(R.string.have_called_fans_short);
            }
            dpg();
        }
    }

    private void dpg() {
        if (this.lHs != null) {
            this.lHs.dmR();
        }
    }

    public void aZC() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.lHr != null) {
                        com.baidu.adp.lib.f.g.dismissDialog(a.this.lHr, a.this.lNL.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.mY().postDelayed(this.runnable, 100L);
    }

    public void dph() {
        if (this.lHr != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.lHr, this.lNL.getPageContext().getPageActivity());
        }
    }

    public aj dpi() {
        return this.lHs;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.lNL = videoPbFragment;
        this.lul = videoPbFragment.getUniqueId();
        this.ltO = new com.baidu.tieba.pb.pb.report.a(this.lNL.getContext());
        this.ltO.w(this.lNL.getUniqueId());
        this.lCT = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.16
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.lNL.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.lNL.djz().getPbData().getUserData().getUserId());
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
                a.this.lNL.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.lNL.getPageContext().getPageActivity(), a.this.lNL.djz().getPbData().getForum().getId(), a.this.lNL.djz().getPbData().getForum().getName(), a.this.lNL.djz().getPbData().dik().getId(), valueOf, str, str3, str2, str4)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dj(View view) {
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
            if (postData.getId() != null && postData.getId().equals(this.lNL.djz().bmI())) {
                z = true;
            }
            MarkData o = this.lNL.djz().o(postData);
            if (this.lNL.djz().getPbData() != null && this.lNL.djz().getPbData().diN() && (I = this.lNL.I(this.lNL.djz().getPbData())) != null) {
                o = this.lNL.djz().o(I);
            }
            if (o != null) {
                this.lNL.dnI();
                if (this.lNL.dqP() != null) {
                    this.lNL.dqP().a(o);
                    if (!z) {
                        this.lNL.dqP().bix();
                    } else {
                        this.lNL.dqP().biw();
                    }
                }
            }
        }
    }

    public int h(f fVar) {
        if (fVar != null && fVar.dik() != null) {
            if (fVar.dik().getThreadType() == 0) {
                return 1;
            }
            if (fVar.dik().getThreadType() == 54) {
                return 2;
            }
            if (fVar.dik().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uj(boolean z) {
        if (this.lNL.djz() == null || this.lNL.djz().getPbData() == null) {
            return false;
        }
        return ((this.lNL.djz().getPbData().diz() != 0) || this.lNL.djz().getPbData().dik() == null || this.lNL.djz().getPbData().dik().bmA() == null || TextUtils.equals(this.lNL.djz().getPbData().dik().bmA().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void PA(String str) {
        if (this.lNL.djz() != null && this.lNL.djz().getPbData() != null && this.lNL.djz().getPbData().diN()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lNL.djz().dlx(), str);
            bw dik = this.lNL.djz().getPbData().dik();
            if (dik.bli()) {
                format = format + "&channelid=33833";
            } else if (dik.bou()) {
                format = format + "&channelid=33842";
            } else if (dik.blj()) {
                format = format + "&channelid=33840";
            }
            PB(format);
            return;
        }
        this.ltO.Qb(str);
    }

    private void PB(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.lNL.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.ltV != null && this.ltV.isShowing()) {
                this.ltV.dismiss();
                this.ltV = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.lNL.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.ltV != null) {
                            a.this.ltV.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.lul);
                            userMuteAddAndDelCustomMessage.setTag(a.this.lul);
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
                this.ltV = new i(this.lNL.getPageContext(), kVar);
                this.ltV.Qj();
            }
        }
    }

    public void dkW() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lNL.getPageContext().getPageActivity());
        aVar.Bo(this.lNL.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.19
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.lNL.getFragmentActivity(), 2, true, 4);
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
        aVar.b(this.lNL.getPageContext()).bpc();
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
        sparseArray.put(lCl, Integer.valueOf(lCm));
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
        this.lBu = new com.baidu.tbadk.core.dialog.a(this.lNL.getActivity());
        if (StringUtils.isNull(str2)) {
            this.lBu.ow(i3);
        } else {
            this.lBu.setOnlyMessageShowCenter(false);
            this.lBu.Bo(str2);
        }
        this.lBu.setYesButtonTag(sparseArray);
        this.lBu.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.lNL.a(aVar, (JSONArray) null);
            }
        });
        this.lBu.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lBu.iV(true);
        this.lBu.b(this.lNL.getPageContext());
        if (z) {
            this.lBu.bpc();
        } else {
            a(this.lBu, i);
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.lNL != null && aVar != null) {
            if (this.jnL == null && this.lNL.getView() != null) {
                this.jnL = new com.baidu.tieba.NEGFeedBack.e(this.lNL.getPageContext(), this.lNL.getView());
            }
            AntiData cxn = cxn();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cxn != null && cxn.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cxn.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray);
            this.jnL.setDefaultReasonArray(new String[]{this.lNL.getString(R.string.delete_thread_reason_1), this.lNL.getString(R.string.delete_thread_reason_2), this.lNL.getString(R.string.delete_thread_reason_3), this.lNL.getString(R.string.delete_thread_reason_4), this.lNL.getString(R.string.delete_thread_reason_5)});
            this.jnL.setData(arVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.jnL.EU(str);
            this.jnL.a(new e.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray) {
                    a.this.lNL.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData cxn() {
        if (this.lNL.djz() == null || this.lNL.djz().getPbData() == null) {
            return null;
        }
        return this.lNL.djz().getPbData().getAnti();
    }

    public void dp(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        g gVar;
        g gVar2;
        k kVar = new k(this.lNL.getContext());
        kVar.setTitleText(this.lNL.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.lBt.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (a.this.lCT != null) {
                                a.this.lCT.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
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
                gVar2 = new g(0, this.lNL.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new g(0, this.lNL.getString(R.string.delete), kVar);
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
            g gVar3 = new g(1, this.lNL.getString(R.string.forbidden_person), kVar);
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
                gVar = new g(2, this.lNL.getString(R.string.un_mute), kVar);
            } else {
                gVar = new g(2, this.lNL.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.br(arrayList);
        if (this.lBt == null) {
            this.lBt = new i(this.lNL.getPageContext(), kVar);
        } else {
            this.lBt.a(kVar);
        }
        this.lBt.Qj();
    }

    public void dkt() {
        if (this.lts == null) {
            this.lts = new com.baidu.tbadk.core.dialog.b(this.lNL.getPageContext().getPageActivity());
            this.lts.a(new String[]{this.lNL.getPageContext().getString(R.string.call_phone), this.lNL.getPageContext().getString(R.string.sms_phone), this.lNL.getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0576b() { // from class: com.baidu.tieba.pb.videopb.b.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0576b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.lNL.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.lpO = a.this.lpO.trim();
                        UtilHelper.callPhone(a.this.lNL.getPageContext().getPageActivity(), a.this.lpO);
                        new com.baidu.tieba.pb.pb.main.b(a.this.lNL.djz().dlx(), a.this.lpO, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.lNL.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.lpO = a.this.lpO.trim();
                        UtilHelper.smsPhone(a.this.lNL.getPageContext().getPageActivity(), a.this.lpO);
                        new com.baidu.tieba.pb.pb.main.b(a.this.lNL.djz().dlx(), a.this.lpO, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.lpO = a.this.lpO.trim();
                        UtilHelper.startBaiDuBar(a.this.lNL.getPageContext().getPageActivity(), a.this.lpO);
                        bVar.dismiss();
                    }
                }
            }).oC(b.a.BOTTOM_TO_TOP).oD(17).d(this.lNL.getPageContext());
        }
    }

    public void dv(final View view) {
        String[] strArr;
        int i = 0;
        if (this.lNL != null && this.lNL.djz() != null) {
            final i iVar = new i(this.lNL.getPageContext());
            if (this.lNL.djz().getPbData().lmT == null || this.lNL.djz().getPbData().lmT.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.lNL.djz().getPbData().lmT.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.lNL.djz().getPbData().lmT.size()) {
                        break;
                    }
                    strArr2[i2] = this.lNL.djz().getPbData().lmT.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.lNL.djz().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.lNL.djz().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.lNL.djz().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.lNL.djz().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new aq("c12097").al("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).al("obj_type", i4));
                    if (a.this.lNL.djz().getPbData().lmT != null && a.this.lNL.djz().getPbData().lmT.size() > i3) {
                        i3 = a.this.lNL.djz().getPbData().lmT.get(i3).sort_type.intValue();
                    }
                    boolean Ga = a.this.lNL.djz().Ga(i3);
                    view.setTag(Integer.valueOf(a.this.lNL.djz().dlQ()));
                    if (Ga) {
                        a.this.lNL.setIsLoading(true);
                    }
                }
            });
            iVar.Qj();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lNL.getActivity());
            aVar.Bn(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.Bo(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.iV(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new aq("c12528").dR("obj_id", metaData.getUserId()).al("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new aq("c12528").dR("obj_id", metaData.getUserId()).al("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.lNL.dra() != null) {
                        a.this.lNL.dra().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.lNL.getPageContext().getUniqueId(), a.this.lNL.djz().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.lNL.getPageContext()).bpc();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.lul);
        userMuteAddAndDelCustomMessage.setTag(this.lul);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void DT(String str) {
        if (str == null) {
            str = "";
        }
        if (this.lNL != null && this.lNL.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lNL.getPageContext().getPageActivity());
            aVar.Bo(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lNL.getPageContext()).bpc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lNL.getBaseFragmentActivity());
        if (at.isEmpty(str)) {
            aVar.Bo(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Bo(str);
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
        aVar.b(this.lNL.getPageContext()).bpc();
    }

    public void showLoadingDialog() {
        if (this.iey == null) {
            this.iey = new com.baidu.tbadk.core.view.a(this.lNL.getPageContext());
        }
        this.iey.setDialogVisiable(true);
    }

    public void chg() {
        if (this.iey != null) {
            this.iey.setDialogVisiable(false);
        }
    }

    public void f(SparseArray<Object> sparseArray) {
        PostData postData;
        boolean z;
        String str;
        g gVar;
        if (this.lNL != null && this.lNL.djz() != null && sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            if (this.ltW == null) {
                this.ltW = new k(this.lNL.getContext());
                this.ltW.a(this.luO);
            }
            ArrayList arrayList = new ArrayList();
            boolean z2 = this.lNL.djz().getPbData() != null && this.lNL.djz().getPbData().diN();
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
                if (postData.bor() != null) {
                    g gVar2 = new g(8, (postData.bor().hasAgree && postData.bob() == 5) ? this.lNL.getString(R.string.action_cancel_dislike) : this.lNL.getString(R.string.action_dislike), this.ltW);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    gVar2.mTextView.setTag(sparseArray2);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z4 && z3) {
                        g gVar3 = new g(5, this.lNL.getString(R.string.mute_option), this.ltW);
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
                        if ((uj(z) && TbadkCoreApplication.isLogin()) && !z2) {
                            g gVar4 = new g(5, this.lNL.getString(R.string.report_text), this.ltW);
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
                            gVar5 = new g(6, this.lNL.getString(R.string.delete), this.ltW);
                            gVar5.mTextView.setTag(sparseArray4);
                        } else {
                            sparseArray4.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, this.lNL.getString(R.string.bar_manager), this.ltW);
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
                            if (this.lNL.djz().getPbData().diz() == 1002 && !z) {
                                gVar5 = new g(6, this.lNL.getString(R.string.report_text), this.ltW);
                            } else {
                                gVar5 = new g(6, this.lNL.getString(R.string.delete), this.ltW);
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
                this.ltW.br(arrayList);
                this.ltV = new i(this.lNL.getPageContext(), this.ltW);
                this.ltV.Qj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eRh == null) {
                this.eRh = new com.baidu.tbadk.core.message.a();
            }
            if (this.eQR == null) {
                this.eQR = new com.baidu.tieba.tbadkCore.data.e();
                this.eQR.uniqueId = this.lNL.getUniqueId();
            }
            c cVar = new c();
            cVar.ezt = 5;
            cVar.ezz = 8;
            cVar.ezy = 2;
            if (this.lNL != null && this.lNL.djz() != null) {
                cVar.ezx = this.lNL.djz().dmh();
            }
            if (cVar != null) {
                cVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (cVar != null) {
                        cVar.ezA = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (cVar != null) {
                        cVar.ezA = 1;
                        i = 0;
                    }
                }
                this.eRh.a(agreeData, i, this.lNL.getUniqueId(), false);
                this.eRh.a(agreeData, this.eQR);
                if (this.lNL == null && this.lNL.djz() != null && this.lNL.djz().getPbData() != null) {
                    this.eRh.a(this.lNL.dle(), cVar, agreeData, this.lNL.djz().getPbData().dik());
                    return;
                }
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (cVar != null) {
                cVar.ezA = 1;
            }
            i = 0;
            this.eRh.a(agreeData, i, this.lNL.getUniqueId(), false);
            this.eRh.a(agreeData, this.eQR);
            if (this.lNL == null) {
            }
        }
    }

    public void a(final b.InterfaceC0576b interfaceC0576b, boolean z) {
        if (this.lBC != null) {
            this.lBC.dismiss();
            this.lBC = null;
        }
        k kVar = new k(this.lNL.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.lNL.djz().getPbData() != null && this.lNL.djz().getPbData().dik() != null && !this.lNL.djz().getPbData().dik().isBjh()) {
            arrayList.add(new g(0, this.lNL.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new g(1, this.lNL.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.br(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.lBC.dismiss();
                interfaceC0576b.a(null, i, view);
            }
        });
        this.lBC = new i(this.lNL.getPageContext(), kVar);
        this.lBC.Qj();
    }

    public void bc(ArrayList<com.baidu.tbadk.core.data.aj> arrayList) {
        if (this.lBx == null) {
            this.lBx = LayoutInflater.from(this.lNL.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.lNL.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lBx);
        if (this.lBw == null) {
            this.lBw = new Dialog(this.lNL.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lBw.setCanceledOnTouchOutside(true);
            this.lBw.setCancelable(true);
            this.lBF = (ScrollView) this.lBx.findViewById(R.id.good_scroll);
            this.lBw.setContentView(this.lBx);
            WindowManager.LayoutParams attributes = this.lBw.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.lBw.getWindow().setAttributes(attributes);
            this.iaw = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.14
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.lBB = (String) compoundButton.getTag();
                        if (a.this.iav != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.iav) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.lBB != null && !str.equals(a.this.lBB)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.lBy = (LinearLayout) this.lBx.findViewById(R.id.good_class_group);
            this.lBA = (TextView) this.lBx.findViewById(R.id.dialog_button_cancel);
            this.lBA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lBw instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(a.this.lBw, a.this.lNL.getPageContext());
                    }
                }
            });
            this.lBz = (TextView) this.lBx.findViewById(R.id.dialog_button_ok);
            this.lBz.setOnClickListener(this.lNL.dqQ());
        }
        this.lBy.removeAllViews();
        this.iav = new ArrayList();
        CustomBlueCheckRadioButton fT = fT("0", this.lNL.getPageContext().getString(R.string.thread_good_class));
        this.iav.add(fT);
        fT.setChecked(true);
        this.lBy.addView(fT);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aj ajVar = arrayList.get(i2);
                if (ajVar != null && !TextUtils.isEmpty(ajVar.bkO()) && ajVar.bkP() > 0) {
                    CustomBlueCheckRadioButton fT2 = fT(String.valueOf(ajVar.bkP()), ajVar.bkO());
                    this.iav.add(fT2);
                    View view = new View(this.lNL.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    ap.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.lBy.addView(view);
                    this.lBy.addView(fT2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.lBF.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.lNL.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.lNL.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.lNL.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.lBF.setLayoutParams(layoutParams2);
            this.lBF.removeAllViews();
            if (this.lBy != null && this.lBy.getParent() == null) {
                this.lBF.addView(this.lBy);
            }
        }
        com.baidu.adp.lib.f.g.a(this.lBw, this.lNL.getPageContext());
    }

    private CustomBlueCheckRadioButton fT(String str, String str2) {
        Activity pageActivity = this.lNL.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.iaw);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public boolean dk(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.lul;
        userMuteCheckCustomMessage.setTag(this.lul);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void dod() {
        if (this.lBu != null) {
            this.lBu.dismiss();
        }
        if (this.lBv != null) {
            com.baidu.adp.lib.f.g.b(this.lBv, this.lNL.getPageContext());
        }
        if (this.lBw != null) {
            com.baidu.adp.lib.f.g.b(this.lBw, this.lNL.getPageContext());
        }
        if (this.lBt != null) {
            this.lBt.dismiss();
        }
    }

    public void drH() {
        if (this.ltV != null) {
            this.ltV.dismiss();
        }
    }

    public void doc() {
        aZC();
        this.lNL.dni();
        if (this.ltV != null) {
            this.ltV.dismiss();
        }
        dod();
    }

    public void dob() {
        aZC();
        this.lNL.dni();
        if (this.ltV != null) {
            this.ltV.dismiss();
        }
        this.lNL.cyL();
        dod();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener dqS() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b drI() {
        return this.lts;
    }

    public void setPhoneNumber(String str) {
        this.lpO = str;
    }

    public String dnH() {
        return this.lBB;
    }

    public View dnG() {
        if (this.lBx != null) {
            return this.lBx.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
