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
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
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
    public static int jAU = 3;
    public static int jAV = 0;
    public static int jAW = 3;
    public static int jAX = 4;
    public static int jAY = 5;
    public static int jAZ = 6;
    private List<CustomBlueCheckRadioButton> grC;
    private e hBK;
    private ar hCb;
    private PbFragment.b jBC;
    public VideoPbFragment jLT;
    private String jqc;
    private i jtG;
    private k jtH;
    public BdUniqueId jtW;
    private com.baidu.adp.widget.ImageView.a jtY;
    private String jtZ;
    private com.baidu.tieba.pb.pb.report.a jty;
    private TbRichTextMemeInfo jua;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    private Runnable runnable;
    private i jAp = null;
    private com.baidu.tbadk.core.dialog.a jAh = null;
    private Dialog jAi = null;
    private Dialog jAj = null;
    private View jAk = null;
    private LinearLayout jAl = null;
    private TextView jAm = null;
    private TextView jAn = null;
    private String jAo = null;
    private ScrollView jAs = null;
    private CompoundButton.OnCheckedChangeListener grD = null;
    private i jAg = null;
    private com.baidu.tbadk.core.view.a gvE = null;
    private com.baidu.tbadk.core.dialog.b jtf = null;
    private AlertDialog jFU = null;
    private y jFV = null;
    PostData hTb = null;
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
            if (a.this.jLT == null || !a.this.jLT.isAdded()) {
                return true;
            }
            SparseArray sparseArray2 = null;
            try {
                sparseArray2 = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray2 == null) {
                if (a.this.cD(view)) {
                    if (view instanceof TbImageView) {
                        a.this.jtY = ((TbImageView) view).getBdImage();
                        a.this.jtZ = ((TbImageView) view).getUrl();
                        if (a.this.jtY == null || TextUtils.isEmpty(a.this.jtZ)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.jua = null;
                        } else {
                            a.this.jua = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            a.this.jtY = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                a.this.jtZ = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                a.this.jua = null;
                            } else {
                                a.this.jua = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        a.this.jtY = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            a.this.jtZ = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.jua = null;
                        } else {
                            a.this.jua = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        a.this.a(a.this.juJ, a.this.jtY.isGif());
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
            a.this.hTb = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (a.this.hTb == null || a.this.jLT.cDG() == null) {
                return true;
            }
            if (!a.this.jLT.cDG().aGX() || a.this.hTb.getId() == null || !a.this.hTb.getId().equals(a.this.jLT.cwA().aKL())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = a.this.jLT.cwA().getPbData() != null && a.this.jLT.cwA().getPbData().cvP();
            if (a.this.jtH == null) {
                a.this.jtH = new k(a.this.jLT.getContext());
                a.this.jtH.a(a.this.juK);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = a.this.cD(view) && !z3;
                boolean z5 = (!a.this.cD(view) || a.this.jtY == null || a.this.jtY.isGif()) ? false : true;
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
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), a.this.jtH));
                }
                if (z5) {
                    arrayList.add(new g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), a.this.jtH));
                }
                if (!z4 && !z5) {
                    g gVar3 = new g(3, TbadkCoreApplication.getInst().getString(R.string.copy), a.this.jtH);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, a.this.hTb);
                    gVar3.mTextView.setTag(sparseArray3);
                    arrayList.add(gVar3);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), a.this.jtH);
                    } else {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.mark), a.this.jtH);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, a.this.hTb);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar2.mTextView.setTag(sparseArray4);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z8 && z7) {
                        g gVar4 = new g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), a.this.jtH);
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
                        if ((a.this.qV(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                            g gVar5 = new g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.jtH);
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
                            gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.jtH);
                            gVar6.mTextView.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), a.this.jtH);
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
                            if (a.this.jLT.cwA().getPbData().cvD() == 1002 && !z6) {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.jtH);
                            } else {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.jtH);
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
                a.this.jtH.aI(arrayList);
                a.this.jtG = new i(a.this.jLT.getPageContext(), a.this.jtH);
                a.this.jtG.showDialog();
                TiebaStatic.log(new an("c13272").cI("tid", a.this.jLT.cwA().cyx()).cI("fid", a.this.jLT.cwA().getForumId()).cI("uid", a.this.jLT.cwA().getPbData().cvr().aKC().getUserId()).cI("post_id", a.this.jLT.cwA().aXi()).af("obj_source", z2 ? 2 : 1));
            }
            return true;
        }
    };
    private k.c juK = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.17
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            int i2;
            if (a.this.jtG != null) {
                a.this.jtG.dismiss();
            }
            switch (i) {
                case 1:
                    if (a.this.jtY != null && !TextUtils.isEmpty(a.this.jtZ)) {
                        if (a.this.jua == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.jtZ));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.jtZ;
                            aVar.pkgId = a.this.jua.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.jua.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.jtY = null;
                        a.this.jtZ = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.jtY != null && !TextUtils.isEmpty(a.this.jtZ)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.jLT.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.jLT.getPageContext().getPageActivity())) {
                            if (a.this.hCb == null) {
                                a.this.hCb = new ar(a.this.jLT.getPageContext());
                            }
                            a.this.hCb.j(a.this.jtZ, a.this.jtY.getImageByte());
                            a.this.jtY = null;
                            a.this.jtZ = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.hTb != null) {
                        a.this.hTb.fa(a.this.jLT.getPageContext().getPageActivity());
                        a.this.hTb = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new an("c11739").af("obj_locate", 2));
                    if (a.this.jLT.checkUpIsLogin()) {
                        a.this.cC(view);
                        if (a.this.jLT.cwA().getPbData().cvr() != null && a.this.jLT.cwA().getPbData().cvr().aKC() != null && a.this.jLT.cwA().getPbData().cvr().aKC().getUserId() != null && a.this.jLT.cDG() != null) {
                            int g = a.this.g(a.this.jLT.cwA().getPbData());
                            bj cvr = a.this.jLT.cwA().getPbData().cvr();
                            if (cvr.aJr()) {
                                i2 = 2;
                            } else if (cvr.aJs()) {
                                i2 = 3;
                            } else if (cvr.aMw()) {
                                i2 = 4;
                            } else {
                                i2 = cvr.aMx() ? 5 : 1;
                            }
                            TiebaStatic.log(new an("c12526").cI("tid", a.this.jLT.cwA().cyx()).af("obj_locate", 2).cI("obj_id", a.this.jLT.cwA().getPbData().cvr().aKC().getUserId()).af("obj_type", a.this.jLT.cDG().aGX() ? 0 : 1).af("obj_source", g).af("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.jLT.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new an("c13079"));
                        a.this.HA((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new an("c11739").af("obj_locate", 4));
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
                        a.this.jLT.showToast(R.string.network_not_available);
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
                            a.this.cI(view);
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
    private final b.a juJ = new b.a() { // from class: com.baidu.tieba.pb.videopb.b.a.21
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.jtY != null && !TextUtils.isEmpty(a.this.jtZ)) {
                if (i == 0) {
                    if (a.this.jua == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.jtZ));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.jtZ;
                        aVar.pkgId = a.this.jua.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.jua.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.jLT.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.jLT.getPageContext().getPageActivity())) {
                        if (a.this.hCb == null) {
                            a.this.hCb = new ar(a.this.jLT.getPageContext());
                        }
                        a.this.hCb.j(a.this.jtZ, a.this.jtY.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.jtY = null;
                a.this.jtZ = null;
            }
        }
    };

    public void cxE() {
        com.baidu.tieba.pb.data.e pbData;
        bj cvr;
        if (this.jLT != null && this.jLT.cwA() != null && this.jLT.cwA().getPbData() != null && (cvr = (pbData = this.jLT.cwA().getPbData()).cvr()) != null && cvr.aKC() != null) {
            this.jLT.cAf();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cvr.aKC().getUserId());
            z zVar = new z();
            int cvD = this.jLT.cwA().getPbData().cvD();
            if (cvD == 1 || cvD == 3) {
                zVar.jyb = true;
                zVar.jya = true;
                zVar.jyg = cvr.aKx() == 1;
                zVar.jyf = cvr.aKy() == 1;
            } else {
                zVar.jyb = false;
                zVar.jya = false;
            }
            if (cvD == 1002 && !equals) {
                zVar.jyh = true;
            }
            zVar.jxY = qW(equals);
            zVar.jyc = cxF();
            zVar.jxZ = qX(equals);
            zVar.DC = this.jLT.cwA().cyy();
            zVar.jxV = true;
            zVar.jxU = qV(equals);
            zVar.jye = TbadkCoreApplication.getInst().getSkinType() == 1;
            zVar.jyd = true;
            zVar.isHostOnly = this.jLT.cwA().getHostMode();
            zVar.jxX = true;
            if (cvr.aKT() == null) {
                zVar.jxW = true;
            } else {
                zVar.jxW = false;
            }
            if (pbData.cvP()) {
                zVar.jxV = false;
                zVar.jxX = false;
                zVar.jxW = false;
                zVar.jya = false;
                zVar.jyb = false;
            }
            a(zVar);
        }
    }

    private boolean qW(boolean z) {
        boolean z2;
        w wVar;
        if (this.jLT == null || this.jLT.cwA() == null || this.jLT.cwA().getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.e pbData = this.jLT.cwA().getPbData();
        bj cvr = pbData.cvr();
        if (cvr != null) {
            if (cvr.aJr() || cvr.aJs()) {
                return false;
            }
            if (cvr.aMw() || cvr.aMx()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.cvD() != 0) {
                return pbData.cvD() != 3;
            }
            List<bf> cvK = pbData.cvK();
            if (v.getCount(cvK) > 0) {
                for (bf bfVar : cvK) {
                    if (bfVar != null && (wVar = bfVar.dqn) != null && wVar.doh && !wVar.doi && (wVar.type == 1 || wVar.type == 2)) {
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

    private boolean qX(boolean z) {
        if (z || this.jLT == null || this.jLT.cwA() == null || this.jLT.cwA().getPbData() == null) {
            return false;
        }
        return ((this.jLT.cwA().getPbData().getForum() != null && this.jLT.cwA().getPbData().getForum().isBlockBawuDelete) || this.jLT.cwA().getPbData().cvD() == 0 || this.jLT.cwA().getPbData().cvD() == 3) ? false : true;
    }

    private boolean cxF() {
        if (this.jLT == null || this.jLT.cwA() == null || !this.jLT.cwA().cyy()) {
            return false;
        }
        return this.jLT.cwA().getPageData() == null || this.jLT.cwA().getPageData().aJz() != 0;
    }

    public void a(z zVar) {
        if (!this.jLT.getBaseFragmentActivity().isProgressBarShown()) {
            this.jFV = new y(this.jLT, this.jLT.aOQ);
            this.jFU = new AlertDialog.Builder(this.jLT.getContext(), R.style.DialogTheme).create();
            this.jFU.setCanceledOnTouchOutside(true);
            com.baidu.adp.lib.f.g.showDialog(this.jFU, this.jLT.getFragmentActivity());
            Window window = this.jFU.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.jFV.getView());
            this.jFV.rj(zVar == null ? false : zVar.jxU);
            this.jFV.rk(zVar == null ? false : zVar.jxY);
            this.jFV.rl(zVar == null ? false : zVar.jyc);
            this.jFV.rm(zVar == null ? false : zVar.jxZ);
            this.jFV.rn(zVar == null ? true : zVar.jxW);
            if (zVar == null) {
                this.jFV.ab(false, false);
                this.jFV.ac(false, false);
            } else {
                this.jFV.ab(zVar.jya, zVar.jyg);
                this.jFV.ac(zVar.jyb, zVar.jyf);
            }
            boolean z = zVar == null ? false : zVar.DC;
            boolean z2 = zVar == null ? false : zVar.isHostOnly;
            boolean z3 = zVar == null ? false : zVar.jxX;
            boolean z4 = zVar == null ? false : zVar.jxV;
            boolean z5 = zVar == null ? false : zVar.jye;
            boolean z6 = zVar == null ? false : zVar.jyd;
            this.jFV.aa(z3, z2);
            this.jFV.ad(z4, z);
            this.jFV.ae(z6, z5);
            if (zVar != null) {
                this.jFV.jxR = zVar.jyh;
                if (zVar.jyh) {
                    this.jFV.czI().setText(R.string.report_text);
                    this.jFV.rm(false);
                }
            }
            cBZ();
        }
    }

    private void cBZ() {
        if (this.jFV != null) {
            this.jFV.czO();
        }
    }

    public void aAi() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.jFU != null) {
                        com.baidu.adp.lib.f.g.dismissDialog(a.this.jFU, a.this.jLT.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.lb().postDelayed(this.runnable, 100L);
    }

    public void cCa() {
        if (this.jFU != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.jFU, this.jLT.getPageContext().getPageActivity());
        }
    }

    public y cCb() {
        return this.jFV;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.jLT = videoPbFragment;
        this.jtW = videoPbFragment.getUniqueId();
        this.jty = new com.baidu.tieba.pb.pb.report.a(this.jLT.getContext());
        this.jty.t(this.jLT.getUniqueId());
        this.jBC = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.16
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.jLT.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.jLT.cwA().getPbData().getUserData().getUserId());
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
                a.this.jLT.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.jLT.getPageContext().getPageActivity(), a.this.jLT.cwA().getPbData().getForum().getId(), a.this.jLT.cwA().getPbData().getForum().getName(), a.this.jLT.cwA().getPbData().cvr().getId(), valueOf, str, str3, str2, str4)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cC(View view) {
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
            if (postData.getId() != null && postData.getId().equals(this.jLT.cwA().aKL())) {
                z = true;
            }
            MarkData l = this.jLT.cwA().l(postData);
            if (this.jLT.cwA().getPbData() != null && this.jLT.cwA().getPbData().cvP() && (F = this.jLT.F(this.jLT.cwA().getPbData())) != null) {
                l = this.jLT.cwA().l(F);
            }
            if (l != null) {
                this.jLT.cAE();
                if (this.jLT.cDG() != null) {
                    this.jLT.cDG().a(l);
                    if (!z) {
                        this.jLT.cDG().aGZ();
                    } else {
                        this.jLT.cDG().aGY();
                    }
                }
            }
        }
    }

    public int g(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cvr() != null) {
            if (eVar.cvr().getThreadType() == 0) {
                return 1;
            }
            if (eVar.cvr().getThreadType() == 54) {
                return 2;
            }
            if (eVar.cvr().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qV(boolean z) {
        if (this.jLT.cwA() == null || this.jLT.cwA().getPbData() == null) {
            return false;
        }
        return ((this.jLT.cwA().getPbData().cvD() != 0) || this.jLT.cwA().getPbData().cvr() == null || this.jLT.cwA().getPbData().cvr().aKC() == null || TextUtils.equals(this.jLT.cwA().getPbData().cvr().aKC().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void HA(String str) {
        if (this.jLT.cwA() != null && this.jLT.cwA().getPbData() != null && this.jLT.cwA().getPbData().cvP()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.jLT.cwA().cyx(), str);
            bj cvr = this.jLT.cwA().getPbData().cvr();
            if (cvr.aJr()) {
                format = format + "&channelid=33833";
            } else if (cvr.aMv()) {
                format = format + "&channelid=33842";
            } else if (cvr.aJs()) {
                format = format + "&channelid=33840";
            }
            HB(format);
            return;
        }
        this.jty.Ia(str);
    }

    private void HB(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.jLT.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.jtG != null && this.jtG.isShowing()) {
                this.jtG.dismiss();
                this.jtG = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.jLT.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.jtG != null) {
                            a.this.jtG.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.jtW);
                            userMuteAddAndDelCustomMessage.setTag(a.this.jtW);
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
                kVar.aI(arrayList);
                this.jtG = new i(this.jLT.getPageContext(), kVar);
                this.jtG.showDialog();
            }
        }
    }

    public void cya() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jLT.getPageContext().getPageActivity());
        aVar.ui(this.jLT.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.19
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.jLT.getFragmentActivity(), 2, true, 4);
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
        aVar.b(this.jLT.getPageContext()).aMS();
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
        sparseArray.put(jAV, Integer.valueOf(jAW));
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
        this.jAh = new com.baidu.tbadk.core.dialog.a(this.jLT.getActivity());
        if (StringUtils.isNull(str2)) {
            this.jAh.kd(i3);
        } else {
            this.jAh.setOnlyMessageShowCenter(false);
            this.jAh.ui(str2);
        }
        this.jAh.setYesButtonTag(sparseArray);
        this.jAh.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.jLT.a(aVar, (JSONArray) null);
            }
        });
        this.jAh.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.jAh.gE(true);
        this.jAh.b(this.jLT.getPageContext());
        if (z) {
            this.jAh.aMS();
        } else {
            a(this.jAh, i);
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.jLT != null && aVar != null) {
            if (this.hBK == null && this.jLT.getView() != null) {
                this.hBK = new e(this.jLT.getPageContext(), this.jLT.getView());
            }
            AntiData bNE = bNE();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bNE != null && bNE.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bNE.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray);
            this.hBK.setDefaultReasonArray(new String[]{this.jLT.getString(R.string.delete_thread_reason_1), this.jLT.getString(R.string.delete_thread_reason_2), this.jLT.getString(R.string.delete_thread_reason_3), this.jLT.getString(R.string.delete_thread_reason_4), this.jLT.getString(R.string.delete_thread_reason_5)});
            this.hBK.setData(alVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.hBK.xD(str);
            this.hBK.a(new e.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void T(JSONArray jSONArray) {
                    a.this.jLT.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData bNE() {
        if (this.jLT.cwA() == null || this.jLT.cwA().getPbData() == null) {
            return null;
        }
        return this.jLT.cwA().getPbData().getAnti();
    }

    public void cI(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        g gVar;
        g gVar2;
        k kVar = new k(this.jLT.getContext());
        kVar.setTitleText(this.jLT.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.jAg.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (a.this.jBC != null) {
                                a.this.jBC.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
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
                gVar2 = new g(0, this.jLT.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new g(0, this.jLT.getString(R.string.delete), kVar);
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
            g gVar3 = new g(1, this.jLT.getString(R.string.forbidden_person), kVar);
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
                gVar = new g(2, this.jLT.getString(R.string.un_mute), kVar);
            } else {
                gVar = new g(2, this.jLT.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.aI(arrayList);
        if (this.jAg == null) {
            this.jAg = new i(this.jLT.getPageContext(), kVar);
        } else {
            this.jAg.a(kVar);
        }
        this.jAg.showDialog();
    }

    public void cxw() {
        if (this.jtf == null) {
            this.jtf = new com.baidu.tbadk.core.dialog.b(this.jLT.getPageContext().getPageActivity());
            this.jtf.a(new String[]{this.jLT.getPageContext().getString(R.string.call_phone), this.jLT.getPageContext().getString(R.string.sms_phone), this.jLT.getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.videopb.b.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.jLT.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.jqc = a.this.jqc.trim();
                        UtilHelper.callPhone(a.this.jLT.getPageContext().getPageActivity(), a.this.jqc);
                        new com.baidu.tieba.pb.pb.main.a(a.this.jLT.cwA().cyx(), a.this.jqc, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.jLT.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.jqc = a.this.jqc.trim();
                        UtilHelper.smsPhone(a.this.jLT.getPageContext().getPageActivity(), a.this.jqc);
                        new com.baidu.tieba.pb.pb.main.a(a.this.jLT.cwA().cyx(), a.this.jqc, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.jqc = a.this.jqc.trim();
                        UtilHelper.startBaiDuBar(a.this.jLT.getPageContext().getPageActivity(), a.this.jqc);
                        bVar.dismiss();
                    }
                }
            }).ki(R.style.dialog_ani_b2t).kj(17).d(this.jLT.getPageContext());
        }
    }

    public void cO(final View view) {
        String[] strArr;
        int i = 0;
        if (this.jLT != null && this.jLT.cwA() != null) {
            final i iVar = new i(this.jLT.getPageContext());
            if (this.jLT.cwA().getPbData().jnz == null || this.jLT.cwA().getPbData().jnz.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.jLT.cwA().getPbData().jnz.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.jLT.cwA().getPbData().jnz.size()) {
                        break;
                    }
                    strArr2[i2] = this.jLT.cwA().getPbData().jnz.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.jLT.cwA().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.jLT.cwA().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.jLT.cwA().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.jLT.cwA().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new an("c12097").af("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).af("obj_type", i4));
                    if (a.this.jLT.cwA().getPbData().jnz != null && a.this.jLT.cwA().getPbData().jnz.size() > i3) {
                        i3 = a.this.jLT.cwA().getPbData().jnz.get(i3).sort_type.intValue();
                    }
                    boolean zF = a.this.jLT.cwA().zF(i3);
                    view.setTag(Integer.valueOf(a.this.jLT.cwA().cyP()));
                    if (zF) {
                        a.this.jLT.setIsLoading(true);
                    }
                }
            });
            iVar.showDialog();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jLT.getActivity());
            aVar.uh(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.ui(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.gE(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new an("c12528").cI("obj_id", metaData.getUserId()).af("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new an("c12528").cI("obj_id", metaData.getUserId()).af("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.jLT.cDR() != null) {
                        a.this.jLT.cDR().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.jLT.getPageContext().getUniqueId(), a.this.jLT.cwA().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.jLT.getPageContext()).aMS();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.jtW);
        userMuteAddAndDelCustomMessage.setTag(this.jtW);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void wI(String str) {
        if (str == null) {
            str = "";
        }
        if (this.jLT != null && this.jLT.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jLT.getPageContext().getPageActivity());
            aVar.ui(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.jLT.getPageContext()).aMS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jLT.getBaseFragmentActivity());
        if (aq.isEmpty(str)) {
            aVar.ui(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.ui(str);
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
        aVar.b(this.jLT.getPageContext()).aMS();
    }

    public void showLoadingDialog() {
        if (this.gvE == null) {
            this.gvE = new com.baidu.tbadk.core.view.a(this.jLT.getPageContext());
        }
        this.gvE.setDialogVisiable(true);
    }

    public void bzS() {
        if (this.gvE != null) {
            this.gvE.setDialogVisiable(false);
        }
    }

    public void a(final b.a aVar, boolean z) {
        if (this.jAp != null) {
            this.jAp.dismiss();
            this.jAp = null;
        }
        k kVar = new k(this.jLT.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.jLT.cwA().getPbData() != null && this.jLT.cwA().getPbData().cvr() != null && !this.jLT.cwA().getPbData().cvr().isBjh()) {
            arrayList.add(new g(0, this.jLT.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new g(1, this.jLT.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.aI(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.jAp.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.jAp = new i(this.jLT.getPageContext(), kVar);
        this.jAp.showDialog();
    }

    public void aO(ArrayList<ad> arrayList) {
        if (this.jAk == null) {
            this.jAk = LayoutInflater.from(this.jLT.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.jLT.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.jAk);
        if (this.jAj == null) {
            this.jAj = new Dialog(this.jLT.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.jAj.setCanceledOnTouchOutside(true);
            this.jAj.setCancelable(true);
            this.jAs = (ScrollView) this.jAk.findViewById(R.id.good_scroll);
            this.jAj.setContentView(this.jAk);
            WindowManager.LayoutParams attributes = this.jAj.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.jAj.getWindow().setAttributes(attributes);
            this.grD = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.14
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.jAo = (String) compoundButton.getTag();
                        if (a.this.grC != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.grC) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.jAo != null && !str.equals(a.this.jAo)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.jAl = (LinearLayout) this.jAk.findViewById(R.id.good_class_group);
            this.jAn = (TextView) this.jAk.findViewById(R.id.dialog_button_cancel);
            this.jAn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jAj instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(a.this.jAj, a.this.jLT.getPageContext());
                    }
                }
            });
            this.jAm = (TextView) this.jAk.findViewById(R.id.dialog_button_ok);
            this.jAm.setOnClickListener(this.jLT.cDH());
        }
        this.jAl.removeAllViews();
        this.grC = new ArrayList();
        CustomBlueCheckRadioButton es = es("0", this.jLT.getPageContext().getString(R.string.thread_good_class));
        this.grC.add(es);
        es.setChecked(true);
        this.jAl.addView(es);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                ad adVar = arrayList.get(i2);
                if (adVar != null && !TextUtils.isEmpty(adVar.aIX()) && adVar.aIY() > 0) {
                    CustomBlueCheckRadioButton es2 = es(String.valueOf(adVar.aIY()), adVar.aIX());
                    this.grC.add(es2);
                    View view = new View(this.jLT.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    am.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.jAl.addView(view);
                    this.jAl.addView(es2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.jAs.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.jLT.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.jLT.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.jLT.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.jAs.setLayoutParams(layoutParams2);
            this.jAs.removeAllViews();
            if (this.jAl != null && this.jAl.getParent() == null) {
                this.jAs.addView(this.jAl);
            }
        }
        com.baidu.adp.lib.f.g.a(this.jAj, this.jLT.getPageContext());
    }

    private CustomBlueCheckRadioButton es(String str, String str2) {
        Activity pageActivity = this.jLT.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.grD);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public boolean cD(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void b(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.jtW;
        userMuteCheckCustomMessage.setTag(this.jtW);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void cAZ() {
        if (this.jAh != null) {
            this.jAh.dismiss();
        }
        if (this.jAi != null) {
            com.baidu.adp.lib.f.g.b(this.jAi, this.jLT.getPageContext());
        }
        if (this.jAj != null) {
            com.baidu.adp.lib.f.g.b(this.jAj, this.jLT.getPageContext());
        }
        if (this.jAg != null) {
            this.jAg.dismiss();
        }
    }

    public void cEu() {
        if (this.jtG != null) {
            this.jtG.dismiss();
        }
    }

    public void cAY() {
        aAi();
        this.jLT.cAf();
        if (this.jtG != null) {
            this.jtG.dismiss();
        }
        cAZ();
    }

    public void cAX() {
        aAi();
        this.jLT.cAf();
        if (this.jtG != null) {
            this.jtG.dismiss();
        }
        this.jLT.bOS();
        cAZ();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener cDJ() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b cEv() {
        return this.jtf;
    }

    public void setPhoneNumber(String str) {
        this.jqc = str;
    }

    public String cAD() {
        return this.jAo;
    }

    public View cAC() {
        if (this.jAk != null) {
            return this.jAk.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
