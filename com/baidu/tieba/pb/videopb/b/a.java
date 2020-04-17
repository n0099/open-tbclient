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
    public static int jAQ = 3;
    public static int jAR = 0;
    public static int jAS = 3;
    public static int jAT = 4;
    public static int jAU = 5;
    public static int jAV = 6;
    private List<CustomBlueCheckRadioButton> grw;
    private e hBE;
    private ar hBV;
    private PbFragment.b jBy;
    public VideoPbFragment jLP;
    private String jpY;
    private i jtC;
    private k jtD;
    public BdUniqueId jtS;
    private com.baidu.adp.widget.ImageView.a jtU;
    private String jtV;
    private TbRichTextMemeInfo jtW;
    private com.baidu.tieba.pb.pb.report.a jtu;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    private Runnable runnable;
    private i jAl = null;
    private com.baidu.tbadk.core.dialog.a jAd = null;
    private Dialog jAe = null;
    private Dialog jAf = null;
    private View jAg = null;
    private LinearLayout jAh = null;
    private TextView jAi = null;
    private TextView jAj = null;
    private String jAk = null;
    private ScrollView jAo = null;
    private CompoundButton.OnCheckedChangeListener grx = null;
    private i jAc = null;
    private com.baidu.tbadk.core.view.a gvy = null;
    private com.baidu.tbadk.core.dialog.b jtb = null;
    private AlertDialog jFQ = null;
    private y jFR = null;
    PostData hSV = null;
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
            if (a.this.jLP == null || !a.this.jLP.isAdded()) {
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
                        a.this.jtU = ((TbImageView) view).getBdImage();
                        a.this.jtV = ((TbImageView) view).getUrl();
                        if (a.this.jtU == null || TextUtils.isEmpty(a.this.jtV)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.jtW = null;
                        } else {
                            a.this.jtW = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            a.this.jtU = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                a.this.jtV = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                a.this.jtW = null;
                            } else {
                                a.this.jtW = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        a.this.jtU = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            a.this.jtV = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.jtW = null;
                        } else {
                            a.this.jtW = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        a.this.a(a.this.juF, a.this.jtU.isGif());
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
            a.this.hSV = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (a.this.hSV == null || a.this.jLP.cDJ() == null) {
                return true;
            }
            if (!a.this.jLP.cDJ().aGZ() || a.this.hSV.getId() == null || !a.this.hSV.getId().equals(a.this.jLP.cwD().aKN())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = a.this.jLP.cwD().getPbData() != null && a.this.jLP.cwD().getPbData().cvS();
            if (a.this.jtD == null) {
                a.this.jtD = new k(a.this.jLP.getContext());
                a.this.jtD.a(a.this.juG);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = a.this.cD(view) && !z3;
                boolean z5 = (!a.this.cD(view) || a.this.jtU == null || a.this.jtU.isGif()) ? false : true;
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
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), a.this.jtD));
                }
                if (z5) {
                    arrayList.add(new g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), a.this.jtD));
                }
                if (!z4 && !z5) {
                    g gVar3 = new g(3, TbadkCoreApplication.getInst().getString(R.string.copy), a.this.jtD);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, a.this.hSV);
                    gVar3.mTextView.setTag(sparseArray3);
                    arrayList.add(gVar3);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), a.this.jtD);
                    } else {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.mark), a.this.jtD);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, a.this.hSV);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar2.mTextView.setTag(sparseArray4);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z8 && z7) {
                        g gVar4 = new g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), a.this.jtD);
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
                            g gVar5 = new g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.jtD);
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
                            gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.jtD);
                            gVar6.mTextView.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), a.this.jtD);
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
                            if (a.this.jLP.cwD().getPbData().cvG() == 1002 && !z6) {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.jtD);
                            } else {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.jtD);
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
                a.this.jtD.aI(arrayList);
                a.this.jtC = new i(a.this.jLP.getPageContext(), a.this.jtD);
                a.this.jtC.showDialog();
                TiebaStatic.log(new an("c13272").cI("tid", a.this.jLP.cwD().cyA()).cI("fid", a.this.jLP.cwD().getForumId()).cI("uid", a.this.jLP.cwD().getPbData().cvu().aKE().getUserId()).cI("post_id", a.this.jLP.cwD().aXk()).af("obj_source", z2 ? 2 : 1));
            }
            return true;
        }
    };
    private k.c juG = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.17
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            int i2;
            if (a.this.jtC != null) {
                a.this.jtC.dismiss();
            }
            switch (i) {
                case 1:
                    if (a.this.jtU != null && !TextUtils.isEmpty(a.this.jtV)) {
                        if (a.this.jtW == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.jtV));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.jtV;
                            aVar.pkgId = a.this.jtW.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.jtW.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.jtU = null;
                        a.this.jtV = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.jtU != null && !TextUtils.isEmpty(a.this.jtV)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.jLP.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.jLP.getPageContext().getPageActivity())) {
                            if (a.this.hBV == null) {
                                a.this.hBV = new ar(a.this.jLP.getPageContext());
                            }
                            a.this.hBV.j(a.this.jtV, a.this.jtU.getImageByte());
                            a.this.jtU = null;
                            a.this.jtV = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.hSV != null) {
                        a.this.hSV.fm(a.this.jLP.getPageContext().getPageActivity());
                        a.this.hSV = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new an("c11739").af("obj_locate", 2));
                    if (a.this.jLP.checkUpIsLogin()) {
                        a.this.cC(view);
                        if (a.this.jLP.cwD().getPbData().cvu() != null && a.this.jLP.cwD().getPbData().cvu().aKE() != null && a.this.jLP.cwD().getPbData().cvu().aKE().getUserId() != null && a.this.jLP.cDJ() != null) {
                            int g = a.this.g(a.this.jLP.cwD().getPbData());
                            bj cvu = a.this.jLP.cwD().getPbData().cvu();
                            if (cvu.aJt()) {
                                i2 = 2;
                            } else if (cvu.aJu()) {
                                i2 = 3;
                            } else if (cvu.aMy()) {
                                i2 = 4;
                            } else {
                                i2 = cvu.aMz() ? 5 : 1;
                            }
                            TiebaStatic.log(new an("c12526").cI("tid", a.this.jLP.cwD().cyA()).af("obj_locate", 2).cI("obj_id", a.this.jLP.cwD().getPbData().cvu().aKE().getUserId()).af("obj_type", a.this.jLP.cDJ().aGZ() ? 0 : 1).af("obj_source", g).af("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.jLP.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new an("c13079"));
                        a.this.Hx((String) tag);
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
                        a.this.jLP.showToast(R.string.network_not_available);
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
    private final b.a juF = new b.a() { // from class: com.baidu.tieba.pb.videopb.b.a.21
        @Override // com.baidu.tbadk.core.dialog.b.a
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.jtU != null && !TextUtils.isEmpty(a.this.jtV)) {
                if (i == 0) {
                    if (a.this.jtW == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.jtV));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.jtV;
                        aVar.pkgId = a.this.jtW.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.jtW.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.jLP.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.jLP.getPageContext().getPageActivity())) {
                        if (a.this.hBV == null) {
                            a.this.hBV = new ar(a.this.jLP.getPageContext());
                        }
                        a.this.hBV.j(a.this.jtV, a.this.jtU.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.jtU = null;
                a.this.jtV = null;
            }
        }
    };

    public void cxH() {
        com.baidu.tieba.pb.data.e pbData;
        bj cvu;
        if (this.jLP != null && this.jLP.cwD() != null && this.jLP.cwD().getPbData() != null && (cvu = (pbData = this.jLP.cwD().getPbData()).cvu()) != null && cvu.aKE() != null) {
            this.jLP.cAi();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), cvu.aKE().getUserId());
            z zVar = new z();
            int cvG = this.jLP.cwD().getPbData().cvG();
            if (cvG == 1 || cvG == 3) {
                zVar.jxX = true;
                zVar.jxW = true;
                zVar.jyc = cvu.aKz() == 1;
                zVar.jyb = cvu.aKA() == 1;
            } else {
                zVar.jxX = false;
                zVar.jxW = false;
            }
            if (cvG == 1002 && !equals) {
                zVar.jyd = true;
            }
            zVar.jxU = qW(equals);
            zVar.jxY = cxI();
            zVar.jxV = qX(equals);
            zVar.Dy = this.jLP.cwD().cyB();
            zVar.jxR = true;
            zVar.jxQ = qV(equals);
            zVar.jya = TbadkCoreApplication.getInst().getSkinType() == 1;
            zVar.jxZ = true;
            zVar.isHostOnly = this.jLP.cwD().getHostMode();
            zVar.jxT = true;
            if (cvu.aKV() == null) {
                zVar.jxS = true;
            } else {
                zVar.jxS = false;
            }
            if (pbData.cvS()) {
                zVar.jxR = false;
                zVar.jxT = false;
                zVar.jxS = false;
                zVar.jxW = false;
                zVar.jxX = false;
            }
            a(zVar);
        }
    }

    private boolean qW(boolean z) {
        boolean z2;
        w wVar;
        if (this.jLP == null || this.jLP.cwD() == null || this.jLP.cwD().getPbData() == null) {
            return false;
        }
        com.baidu.tieba.pb.data.e pbData = this.jLP.cwD().getPbData();
        bj cvu = pbData.cvu();
        if (cvu != null) {
            if (cvu.aJt() || cvu.aJu()) {
                return false;
            }
            if (cvu.aMy() || cvu.aMz()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.cvG() != 0) {
                return pbData.cvG() != 3;
            }
            List<bf> cvN = pbData.cvN();
            if (v.getCount(cvN) > 0) {
                for (bf bfVar : cvN) {
                    if (bfVar != null && (wVar = bfVar.dqj) != null && wVar.dod && !wVar.doe && (wVar.type == 1 || wVar.type == 2)) {
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
        if (z || this.jLP == null || this.jLP.cwD() == null || this.jLP.cwD().getPbData() == null) {
            return false;
        }
        return ((this.jLP.cwD().getPbData().getForum() != null && this.jLP.cwD().getPbData().getForum().isBlockBawuDelete) || this.jLP.cwD().getPbData().cvG() == 0 || this.jLP.cwD().getPbData().cvG() == 3) ? false : true;
    }

    private boolean cxI() {
        if (this.jLP == null || this.jLP.cwD() == null || !this.jLP.cwD().cyB()) {
            return false;
        }
        return this.jLP.cwD().getPageData() == null || this.jLP.cwD().getPageData().aJB() != 0;
    }

    public void a(z zVar) {
        if (!this.jLP.getBaseFragmentActivity().isProgressBarShown()) {
            this.jFR = new y(this.jLP, this.jLP.aOK);
            this.jFQ = new AlertDialog.Builder(this.jLP.getContext(), R.style.DialogTheme).create();
            this.jFQ.setCanceledOnTouchOutside(true);
            com.baidu.adp.lib.f.g.showDialog(this.jFQ, this.jLP.getFragmentActivity());
            Window window = this.jFQ.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.jFR.getView());
            this.jFR.rj(zVar == null ? false : zVar.jxQ);
            this.jFR.rk(zVar == null ? false : zVar.jxU);
            this.jFR.rl(zVar == null ? false : zVar.jxY);
            this.jFR.rm(zVar == null ? false : zVar.jxV);
            this.jFR.rn(zVar == null ? true : zVar.jxS);
            if (zVar == null) {
                this.jFR.ab(false, false);
                this.jFR.ac(false, false);
            } else {
                this.jFR.ab(zVar.jxW, zVar.jyc);
                this.jFR.ac(zVar.jxX, zVar.jyb);
            }
            boolean z = zVar == null ? false : zVar.Dy;
            boolean z2 = zVar == null ? false : zVar.isHostOnly;
            boolean z3 = zVar == null ? false : zVar.jxT;
            boolean z4 = zVar == null ? false : zVar.jxR;
            boolean z5 = zVar == null ? false : zVar.jya;
            boolean z6 = zVar == null ? false : zVar.jxZ;
            this.jFR.aa(z3, z2);
            this.jFR.ad(z4, z);
            this.jFR.ae(z6, z5);
            if (zVar != null) {
                this.jFR.jxN = zVar.jyd;
                if (zVar.jyd) {
                    this.jFR.czL().setText(R.string.report_text);
                    this.jFR.rm(false);
                }
            }
            cCc();
        }
    }

    private void cCc() {
        if (this.jFR != null) {
            this.jFR.czR();
        }
    }

    public void aAi() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.jFQ != null) {
                        com.baidu.adp.lib.f.g.dismissDialog(a.this.jFQ, a.this.jLP.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.lb().postDelayed(this.runnable, 100L);
    }

    public void cCd() {
        if (this.jFQ != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.jFQ, this.jLP.getPageContext().getPageActivity());
        }
    }

    public y cCe() {
        return this.jFR;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.jLP = videoPbFragment;
        this.jtS = videoPbFragment.getUniqueId();
        this.jtu = new com.baidu.tieba.pb.pb.report.a(this.jLP.getContext());
        this.jtu.t(this.jLP.getUniqueId());
        this.jBy = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.16
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.jLP.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.jLP.cwD().getPbData().getUserData().getUserId());
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
                a.this.jLP.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.jLP.getPageContext().getPageActivity(), a.this.jLP.cwD().getPbData().getForum().getId(), a.this.jLP.cwD().getPbData().getForum().getName(), a.this.jLP.cwD().getPbData().cvu().getId(), valueOf, str, str3, str2, str4)));
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
            if (postData.getId() != null && postData.getId().equals(this.jLP.cwD().aKN())) {
                z = true;
            }
            MarkData l = this.jLP.cwD().l(postData);
            if (this.jLP.cwD().getPbData() != null && this.jLP.cwD().getPbData().cvS() && (F = this.jLP.F(this.jLP.cwD().getPbData())) != null) {
                l = this.jLP.cwD().l(F);
            }
            if (l != null) {
                this.jLP.cAH();
                if (this.jLP.cDJ() != null) {
                    this.jLP.cDJ().a(l);
                    if (!z) {
                        this.jLP.cDJ().aHb();
                    } else {
                        this.jLP.cDJ().aHa();
                    }
                }
            }
        }
    }

    public int g(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cvu() != null) {
            if (eVar.cvu().getThreadType() == 0) {
                return 1;
            }
            if (eVar.cvu().getThreadType() == 54) {
                return 2;
            }
            if (eVar.cvu().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qV(boolean z) {
        if (this.jLP.cwD() == null || this.jLP.cwD().getPbData() == null) {
            return false;
        }
        return ((this.jLP.cwD().getPbData().cvG() != 0) || this.jLP.cwD().getPbData().cvu() == null || this.jLP.cwD().getPbData().cvu().aKE() == null || TextUtils.equals(this.jLP.cwD().getPbData().cvu().aKE().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void Hx(String str) {
        if (this.jLP.cwD() != null && this.jLP.cwD().getPbData() != null && this.jLP.cwD().getPbData().cvS()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.jLP.cwD().cyA(), str);
            bj cvu = this.jLP.cwD().getPbData().cvu();
            if (cvu.aJt()) {
                format = format + "&channelid=33833";
            } else if (cvu.aMx()) {
                format = format + "&channelid=33842";
            } else if (cvu.aJu()) {
                format = format + "&channelid=33840";
            }
            Hy(format);
            return;
        }
        this.jtu.HX(str);
    }

    private void Hy(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.jLP.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.jtC != null && this.jtC.isShowing()) {
                this.jtC.dismiss();
                this.jtC = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.jLP.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.jtC != null) {
                            a.this.jtC.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.jtS);
                            userMuteAddAndDelCustomMessage.setTag(a.this.jtS);
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
                this.jtC = new i(this.jLP.getPageContext(), kVar);
                this.jtC.showDialog();
            }
        }
    }

    public void cyd() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jLP.getPageContext().getPageActivity());
        aVar.uf(this.jLP.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.19
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.jLP.getFragmentActivity(), 2, true, 4);
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
        aVar.b(this.jLP.getPageContext()).aMU();
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
        sparseArray.put(jAR, Integer.valueOf(jAS));
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
        this.jAd = new com.baidu.tbadk.core.dialog.a(this.jLP.getActivity());
        if (StringUtils.isNull(str2)) {
            this.jAd.kd(i3);
        } else {
            this.jAd.setOnlyMessageShowCenter(false);
            this.jAd.uf(str2);
        }
        this.jAd.setYesButtonTag(sparseArray);
        this.jAd.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.jLP.a(aVar, (JSONArray) null);
            }
        });
        this.jAd.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.jAd.gE(true);
        this.jAd.b(this.jLP.getPageContext());
        if (z) {
            this.jAd.aMU();
        } else {
            a(this.jAd, i);
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.jLP != null && aVar != null) {
            if (this.hBE == null && this.jLP.getView() != null) {
                this.hBE = new e(this.jLP.getPageContext(), this.jLP.getView());
            }
            AntiData bNG = bNG();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (bNG != null && bNG.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bNG.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray);
            this.hBE.setDefaultReasonArray(new String[]{this.jLP.getString(R.string.delete_thread_reason_1), this.jLP.getString(R.string.delete_thread_reason_2), this.jLP.getString(R.string.delete_thread_reason_3), this.jLP.getString(R.string.delete_thread_reason_4), this.jLP.getString(R.string.delete_thread_reason_5)});
            this.hBE.setData(alVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.hBE.xA(str);
            this.hBE.a(new e.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void T(JSONArray jSONArray) {
                    a.this.jLP.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData bNG() {
        if (this.jLP.cwD() == null || this.jLP.cwD().getPbData() == null) {
            return null;
        }
        return this.jLP.cwD().getPbData().getAnti();
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
        k kVar = new k(this.jLP.getContext());
        kVar.setTitleText(this.jLP.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.jAc.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (a.this.jBy != null) {
                                a.this.jBy.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
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
                gVar2 = new g(0, this.jLP.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new g(0, this.jLP.getString(R.string.delete), kVar);
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
            g gVar3 = new g(1, this.jLP.getString(R.string.forbidden_person), kVar);
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
                gVar = new g(2, this.jLP.getString(R.string.un_mute), kVar);
            } else {
                gVar = new g(2, this.jLP.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.aI(arrayList);
        if (this.jAc == null) {
            this.jAc = new i(this.jLP.getPageContext(), kVar);
        } else {
            this.jAc.a(kVar);
        }
        this.jAc.showDialog();
    }

    public void cxz() {
        if (this.jtb == null) {
            this.jtb = new com.baidu.tbadk.core.dialog.b(this.jLP.getPageContext().getPageActivity());
            this.jtb.a(new String[]{this.jLP.getPageContext().getString(R.string.call_phone), this.jLP.getPageContext().getString(R.string.sms_phone), this.jLP.getPageContext().getString(R.string.search_in_baidu)}, new b.a() { // from class: com.baidu.tieba.pb.videopb.b.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.jLP.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.jpY = a.this.jpY.trim();
                        UtilHelper.callPhone(a.this.jLP.getPageContext().getPageActivity(), a.this.jpY);
                        new com.baidu.tieba.pb.pb.main.a(a.this.jLP.cwD().cyA(), a.this.jpY, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.jLP.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.jpY = a.this.jpY.trim();
                        UtilHelper.smsPhone(a.this.jLP.getPageContext().getPageActivity(), a.this.jpY);
                        new com.baidu.tieba.pb.pb.main.a(a.this.jLP.cwD().cyA(), a.this.jpY, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.jpY = a.this.jpY.trim();
                        UtilHelper.startBaiDuBar(a.this.jLP.getPageContext().getPageActivity(), a.this.jpY);
                        bVar.dismiss();
                    }
                }
            }).ki(R.style.dialog_ani_b2t).kj(17).d(this.jLP.getPageContext());
        }
    }

    public void cO(final View view) {
        String[] strArr;
        int i = 0;
        if (this.jLP != null && this.jLP.cwD() != null) {
            final i iVar = new i(this.jLP.getPageContext());
            if (this.jLP.cwD().getPbData().jnv == null || this.jLP.cwD().getPbData().jnv.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.jLP.cwD().getPbData().jnv.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.jLP.cwD().getPbData().jnv.size()) {
                        break;
                    }
                    strArr2[i2] = this.jLP.cwD().getPbData().jnv.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.jLP.cwD().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.jLP.cwD().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.jLP.cwD().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.jLP.cwD().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new an("c12097").af("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).af("obj_type", i4));
                    if (a.this.jLP.cwD().getPbData().jnv != null && a.this.jLP.cwD().getPbData().jnv.size() > i3) {
                        i3 = a.this.jLP.cwD().getPbData().jnv.get(i3).sort_type.intValue();
                    }
                    boolean zF = a.this.jLP.cwD().zF(i3);
                    view.setTag(Integer.valueOf(a.this.jLP.cwD().cyS()));
                    if (zF) {
                        a.this.jLP.setIsLoading(true);
                    }
                }
            });
            iVar.showDialog();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jLP.getActivity());
            aVar.ue(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.uf(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
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
                    if (a.this.jLP.cDU() != null) {
                        a.this.jLP.cDU().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.jLP.getPageContext().getUniqueId(), a.this.jLP.cwD().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.jLP.getPageContext()).aMU();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.jtS);
        userMuteAddAndDelCustomMessage.setTag(this.jtS);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void wF(String str) {
        if (str == null) {
            str = "";
        }
        if (this.jLP != null && this.jLP.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jLP.getPageContext().getPageActivity());
            aVar.uf(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.jLP.getPageContext()).aMU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jLP.getBaseFragmentActivity());
        if (aq.isEmpty(str)) {
            aVar.uf(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.uf(str);
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
        aVar.b(this.jLP.getPageContext()).aMU();
    }

    public void showLoadingDialog() {
        if (this.gvy == null) {
            this.gvy = new com.baidu.tbadk.core.view.a(this.jLP.getPageContext());
        }
        this.gvy.setDialogVisiable(true);
    }

    public void bzU() {
        if (this.gvy != null) {
            this.gvy.setDialogVisiable(false);
        }
    }

    public void a(final b.a aVar, boolean z) {
        if (this.jAl != null) {
            this.jAl.dismiss();
            this.jAl = null;
        }
        k kVar = new k(this.jLP.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.jLP.cwD().getPbData() != null && this.jLP.cwD().getPbData().cvu() != null && !this.jLP.cwD().getPbData().cvu().isBjh()) {
            arrayList.add(new g(0, this.jLP.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new g(1, this.jLP.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.aI(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.jAl.dismiss();
                aVar.a(null, i, view);
            }
        });
        this.jAl = new i(this.jLP.getPageContext(), kVar);
        this.jAl.showDialog();
    }

    public void aO(ArrayList<ad> arrayList) {
        if (this.jAg == null) {
            this.jAg = LayoutInflater.from(this.jLP.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.jLP.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.jAg);
        if (this.jAf == null) {
            this.jAf = new Dialog(this.jLP.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.jAf.setCanceledOnTouchOutside(true);
            this.jAf.setCancelable(true);
            this.jAo = (ScrollView) this.jAg.findViewById(R.id.good_scroll);
            this.jAf.setContentView(this.jAg);
            WindowManager.LayoutParams attributes = this.jAf.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.jAf.getWindow().setAttributes(attributes);
            this.grx = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.14
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.jAk = (String) compoundButton.getTag();
                        if (a.this.grw != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.grw) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.jAk != null && !str.equals(a.this.jAk)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.jAh = (LinearLayout) this.jAg.findViewById(R.id.good_class_group);
            this.jAj = (TextView) this.jAg.findViewById(R.id.dialog_button_cancel);
            this.jAj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.jAf instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(a.this.jAf, a.this.jLP.getPageContext());
                    }
                }
            });
            this.jAi = (TextView) this.jAg.findViewById(R.id.dialog_button_ok);
            this.jAi.setOnClickListener(this.jLP.cDK());
        }
        this.jAh.removeAllViews();
        this.grw = new ArrayList();
        CustomBlueCheckRadioButton es = es("0", this.jLP.getPageContext().getString(R.string.thread_good_class));
        this.grw.add(es);
        es.setChecked(true);
        this.jAh.addView(es);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                ad adVar = arrayList.get(i2);
                if (adVar != null && !TextUtils.isEmpty(adVar.aIZ()) && adVar.aJa() > 0) {
                    CustomBlueCheckRadioButton es2 = es(String.valueOf(adVar.aJa()), adVar.aIZ());
                    this.grw.add(es2);
                    View view = new View(this.jLP.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    am.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.jAh.addView(view);
                    this.jAh.addView(es2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.jAo.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.jLP.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.jLP.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.jLP.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.jAo.setLayoutParams(layoutParams2);
            this.jAo.removeAllViews();
            if (this.jAh != null && this.jAh.getParent() == null) {
                this.jAo.addView(this.jAh);
            }
        }
        com.baidu.adp.lib.f.g.a(this.jAf, this.jLP.getPageContext());
    }

    private CustomBlueCheckRadioButton es(String str, String str2) {
        Activity pageActivity = this.jLP.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.grx);
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
        userMuteCheckCustomMessage.mId = this.jtS;
        userMuteCheckCustomMessage.setTag(this.jtS);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void cBc() {
        if (this.jAd != null) {
            this.jAd.dismiss();
        }
        if (this.jAe != null) {
            com.baidu.adp.lib.f.g.b(this.jAe, this.jLP.getPageContext());
        }
        if (this.jAf != null) {
            com.baidu.adp.lib.f.g.b(this.jAf, this.jLP.getPageContext());
        }
        if (this.jAc != null) {
            this.jAc.dismiss();
        }
    }

    public void cEx() {
        if (this.jtC != null) {
            this.jtC.dismiss();
        }
    }

    public void cBb() {
        aAi();
        this.jLP.cAi();
        if (this.jtC != null) {
            this.jtC.dismiss();
        }
        cBc();
    }

    public void cBa() {
        aAi();
        this.jLP.cAi();
        if (this.jtC != null) {
            this.jtC.dismiss();
        }
        this.jLP.bOU();
        cBc();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener cDM() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b cEy() {
        return this.jtb;
    }

    public void setPhoneNumber(String str) {
        this.jpY = str;
    }

    public String cAG() {
        return this.jAk;
    }

    public View cAF() {
        if (this.jAg != null) {
            return this.jAg.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
